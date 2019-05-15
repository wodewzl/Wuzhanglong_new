package com.beisheng.snatch.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.MoneyAdapter;
import com.beisheng.snatch.adapter.PayTypeAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.MyFlowVO;
import com.beisheng.snatch.model.PayTypeVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.squareup.picasso.Picasso;
import com.vondear.rxui.view.dialog.RxDialogEditSureCancel;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.PayInfoVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.PayUtis;
import com.wuzhanglong.library.utils.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildCheckedChangeListener;
import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class BuyFlowActivity extends BaseActivity implements BGAOnRVItemClickListener, BGAOnItemChildCheckedChangeListener,View.OnClickListener,PostCallback {
    private String[] mOneyArray = {"20", "50", "100", "200", "500", "其他金额"};
    private LuRecyclerView mRecyclerView;
    private MoneyAdapter mAdapter;
    private MyFlowVO mSelectVO;
    private PayTypeAdapter mPayTypeAdapter;
    private LuRecyclerView mPayRecyclerView;
    private PayTypeVO.DataBean.ListBean mDefaultVO;
    private TextView mFlowTv;
    private ImageView mFlowImg;
    private TextView mDescTv;
    private TextView mOkTv;


    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.buy_flow_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("买流量");
        mFlowImg = getViewById(R.id.flow_bg);
        Picasso.with(this).load(AppApplication.getInstance().getUserInfoVO().getData().getRecharge_banner()).into(mFlowImg);
        mDescTv = getViewById(R.id.desc_tv);
        mDescTv.setText(AppApplication.getInstance().getUserInfoVO().getData().getRecharge_desc());
        mFlowTv = getViewById(R.id.flow_tv);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mAdapter = new MoneyAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadMoreEnabled(false);
        List<MyFlowVO> list = new ArrayList<>();
        for (int i = 1; i <= mOneyArray.length; i++) {
            MyFlowVO myFlowVO = new MyFlowVO();
            myFlowVO.setMoney(mOneyArray[i - 1]);
            if (i == 1) {
                mSelectVO = myFlowVO;
                myFlowVO.setSelect(true);
            }
            myFlowVO.setId(i + "");
            list.add(myFlowVO);
        }
        mAdapter.updateData(list);
        mPayRecyclerView = getViewById(R.id.recycler_view_pay);
        mPayTypeAdapter = new PayTypeAdapter(mPayRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, mPayRecyclerView, mPayTypeAdapter, R.dimen.dp_1, R.color.C3, false);
        mOkTv=getViewById(R.id.ok_tv);
    }

    @Override
    public void bindViewsListener() {
        mAdapter.setOnRVItemClickListener(this);
        mPayTypeAdapter.setOnRVItemClickListener(this);
//        mPayTypeAdapter.setOnItemChildCheckedChangeListener(this);
        mOkTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> payTypeMap = new HashMap<>();
        payTypeMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        payTypeMap.put("is_recharge", "1");
        BSHttpUtils.post(mActivity, this, Constant.PAY_TYPE_LIST_URL, payTypeMap, PayTypeVO.class);

    }

    @Override
    public void hasData(BaseVO vo) {
        PayTypeVO payTypeVO = (PayTypeVO) vo;
        List<PayTypeVO.DataBean.ListBean> list = payTypeVO.getData().getList();
        mDefaultVO = list.get(0);
        mDefaultVO.setCheck(true);
        BaseCommonUtils.setTextThree(this, mFlowTv, "选择购买：", mOneyArray[0], "元", R.color.color_yellow, 1.3f);

        mPayTypeAdapter.updateData(list);

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (parent == mRecyclerView) {
            MyFlowVO myFlowVO = (MyFlowVO) mAdapter.getItem(position);
            if (mSelectVO != null) {
                mSelectVO.setSelect(false);
            }
            mSelectVO = myFlowVO;
            mSelectVO.setSelect(true);
            mAdapter.notifyDataSetChanged();
            if ("其他金额".equals(myFlowVO.getMoney())) {
                showCustomDialog("其他金额", "请输入金额");
            } else {
                BaseCommonUtils.setTextThree(this, mFlowTv, "选择购买：", mOneyArray[position], "元", R.color.color_yellow, 1.3f);
            }
        } else {
            mDefaultVO.setCheck(false);
            mDefaultVO = (PayTypeVO.DataBean.ListBean) mPayTypeAdapter.getItem(position);
            mDefaultVO.setCheck(true);
            mPayTypeAdapter.notifyDataSetChanged();
        }

    }

    @Override
    public void onItemChildCheckedChanged(ViewGroup parent, CompoundButton childView, int position, boolean isChecked) {
        System.out.println("----------");
    }

    public void showCustomDialog(String title, String hint) {
        final RxDialogEditSureCancel rxDialogEditTextSureCancle = new RxDialogEditSureCancel(this);//提示弹窗
        rxDialogEditTextSureCancle.setTitle(title);
        rxDialogEditTextSureCancle.getTitleView().setBackgroundColor(ContextCompat.getColor(this, R.color.C1));
        rxDialogEditTextSureCancle.getTitleView().setTextSize(13);
        rxDialogEditTextSureCancle.getCancelView().setTextSize(13);
        rxDialogEditTextSureCancle.getSureView().setTextSize(13);
        rxDialogEditTextSureCancle.getEditText().setHint(hint);
        rxDialogEditTextSureCancle.getEditText().setTextSize(11);
        rxDialogEditTextSureCancle.getEditText().setInputType(InputType.TYPE_CLASS_NUMBER);
        rxDialogEditTextSureCancle.getEditText().setHintTextColor(ContextCompat.getColor(this, R.color.C6));
        rxDialogEditTextSureCancle.getSureView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(BaseCommonUtils.parseInt(rxDialogEditTextSureCancle.getEditText().getText().toString())<=0){
                    showCustomToast("充值金额要大于20元");
                 return;
                }
                mSelectVO.setMoney(rxDialogEditTextSureCancle.getEditText().getText().toString());
                BaseCommonUtils.setTextThree(BuyFlowActivity.this, mFlowTv, "选择购买：", rxDialogEditTextSureCancle.getEditText().getText().toString(), "元", R.color.color_yellow, 1.3f);

                rxDialogEditTextSureCancle.cancel();
            }
        });
        rxDialogEditTextSureCancle.getCancelView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectVO.setSelect(false);
                mSelectVO= (MyFlowVO) mAdapter.getItem(0);
                mSelectVO.setSelect(true);
                mAdapter.notifyDataSetChanged();
                BaseCommonUtils.setTextThree(BuyFlowActivity.this, mFlowTv, "选择购买：", mOneyArray[0], "元", R.color.color_yellow, 1.3f);
                rxDialogEditTextSureCancle.cancel();
            }
        });
        rxDialogEditTextSureCancle.show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_tv:

                HashMap<String, Object> map = new HashMap<>();
                map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                map.put("recharge_money", mSelectVO.getMoney());
                map.put("payment_code", mDefaultVO.getPayment_code());
                map.put("platform", "1");
                BSHttpUtils.postCallBack(mActivity, Constant.BUY_FLOW_URL, map, PayInfoVO.class, this);

                break;
            default:
                break;
        }
    }

    @Override
    public void success(BaseVO vo) {
        PayInfoVO payInfoVO = (PayInfoVO) vo;

        if ("200".equals(vo.getCode())) {
            if ("WPAY".equals(mDefaultVO.getPayment_code())) {
                PayUtis.weiXinPay(mActivity, payInfoVO.getData().getWxpay_params());
            } else if ("ALIPAY".equals(mDefaultVO.getPayment_code())) {
                String payInfo = payInfoVO.getData().getAlipay_string();
                PayUtis.zhiFuBaoPay(mActivity, payInfo, new PayCallback() {
                    @Override
                    public void payResult(int type) {
                        buyRecord();
                    }
                });
            } else if ("ALIWAP".equals(mDefaultVO.getPayment_code())) {
                Bundle bundle = new Bundle();
                bundle.putString("title", "支付宝支付");
                bundle.putString("content", payInfoVO.getData().getAlipay_wap_html());
                mActivity.open(WebViewActivity.class, bundle, 0);
            } else if ("WSCAN".equals(mDefaultVO.getPayment_code())) {
                Bundle bundle = new Bundle();
                bundle.putString("img", payInfoVO.getData().getWx_native_qrcode());
                bundle.putString("url", payInfoVO.getData().getPayment_status_api());
                mActivity.open(QRCodeActivity.class, bundle, 0);
            } else if ("BALANCE".equals(mDefaultVO.getPayment_code())) {
                mActivity.showCustomToast(vo.getDesc());
                buyRecord();
            }

        }
    }

    public void buyRecord(){
        openActivity(RechargeRecordActivity.class);
    }
}
