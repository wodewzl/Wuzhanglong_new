package com.beisheng.snatch.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
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
import com.vondear.rxtools.view.dialog.RxDialogEditSureCancel;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildCheckedChangeListener;
import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class BuyFlowActivity extends BaseActivity implements BGAOnRVItemClickListener,BGAOnItemChildCheckedChangeListener {
    private String[] mOneyArray = {"20", "50", "100", "200", "500", "其他金额"};
    private LuRecyclerView mRecyclerView;
    private MoneyAdapter mAdapter;
    private MyFlowVO mSelectVO;
    private PayTypeAdapter mPayTypeAdapter;
    private LuRecyclerView mPayRecyclerView;
    private PayTypeVO.DataBean.ListBean mDefaultVO;
    private TextView mFlowTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.buy_flow_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("买流量");
        mFlowTv=getViewById(R.id.flow_tv);
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
    }

    @Override
    public void bindViewsListener() {
        mAdapter.setOnRVItemClickListener(this);
        mPayTypeAdapter.setOnRVItemClickListener(this);
//        mPayTypeAdapter.setOnItemChildCheckedChangeListener(this);
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
        BaseCommonUtils.setTextThree(this,mFlowTv,"选择购买：",mOneyArray[0],"元",R.color.color_yellow,1.3f);

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
            if("其他金额".equals(myFlowVO.getMoney())){
                showCustomDialog("其他金额","请输入金额");
            }else {
                BaseCommonUtils.setTextThree(this,mFlowTv,"选择购买：",mOneyArray[position],"元",R.color.color_yellow,1.3f);
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
        rxDialogEditTextSureCancle.getTvTitle().setBackgroundColor(ContextCompat.getColor(this, R.color.C1));
        rxDialogEditTextSureCancle.getTvTitle().setTextSize(13);
        rxDialogEditTextSureCancle.getTvCancel().setTextSize(13);
        rxDialogEditTextSureCancle.getTvSure().setTextSize(13);
        rxDialogEditTextSureCancle.getEditText().setHint(hint);
        rxDialogEditTextSureCancle.getEditText().setTextSize(11);
        rxDialogEditTextSureCancle.getEditText().setInputType(InputType.TYPE_CLASS_NUMBER);
        rxDialogEditTextSureCancle.getEditText().setHintTextColor(ContextCompat.getColor(this, R.color.C6));
        rxDialogEditTextSureCancle.getTvSure().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSelectVO.setMoney(rxDialogEditTextSureCancle.getEditText().getText().toString());
                BaseCommonUtils.setTextThree(BuyFlowActivity.this,mFlowTv,"选择购买：",rxDialogEditTextSureCancle.getEditText().getText().toString(),"元",R.color.color_yellow,1.3f);

                rxDialogEditTextSureCancle.cancel();
            }
        });
        rxDialogEditTextSureCancle.getTvCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxDialogEditTextSureCancle.cancel();
            }
        });
        rxDialogEditTextSureCancle.show();

    }
}
