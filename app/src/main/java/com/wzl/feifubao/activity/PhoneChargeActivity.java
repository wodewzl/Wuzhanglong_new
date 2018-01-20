package com.wzl.feifubao.activity;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.adapter.TieAdapter;
import com.dou361.dialogui.bean.BuildBean;
import com.dou361.dialogui.bean.TieBean;
import com.dou361.dialogui.listener.DialogUIItemListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.google.gson.Gson;
import com.rey.material.widget.CheckBox;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.PayResult;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.PayUtis;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.MoneyAdapter;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.MoneyVO;
import com.wzl.feifubao.mode.OrderCrateVO;
import com.wzl.feifubao.mode.ShopDetailVO;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class PhoneChargeActivity extends BaseActivity implements BGAOnRVItemClickListener, View.OnClickListener, PostCallback, CompoundButton.OnCheckedChangeListener {
    private LuRecyclerView mRecyclerView;
    private MoneyAdapter mAdapter;
    private String[] mOneyArray = {"30PHP", "50PHP", "100PHP", "300PHP", "500PHP", "1000PHP", "2000PHP", "3000PHP"};
    private TextView mOkTv;
    private MoneyVO mSelectVO;
    private LinearLayout mTypeLayout;
    private TextView mTypeTv;
    private ShopDetailVO.DataBean mDataBean;
    private CheckBox mPayCb1, mPayCb2;
    private String mPayType = "2";
    private EditText mPhoneEt;
    private TextView mPhpTv, mRmbTv;
    private String mMoneyStr;
    private String mShopType = "";
    private String mPayStr = "";

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_phone_charge);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("话费充值");
        mTypeLayout = getViewById(R.id.type_layout);
        mTypeTv = getViewById(R.id.type_tv);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        mAdapter = new MoneyAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadMoreEnabled(false);
//        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_10, R.color.C3);
//        mRecyclerView.addItemDecoration(divider);


        mOkTv = getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.colorAccent, R.color.colorAccent));
        mPayCb1 = getViewById(R.id.pay_cb_1);
        mPayCb2 = getViewById(R.id.pay_cb_2);
        mPhoneEt = getViewById(R.id.phone_tv);
        mPhpTv = getViewById(R.id.php_tv);
        mRmbTv = getViewById(R.id.rmb_tv);
    }

    @Override
    public void bindViewsListener() {
        mAdapter.setOnRVItemClickListener(this);
        mTypeLayout.setOnClickListener(this);
        mPayCb1.setOnCheckedChangeListener(this);
        mPayCb2.setOnCheckedChangeListener(this);
        mPayCb1.setChecked(true);
        mOkTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("goodsId", "4");
        HttpGetDataUtil.get(mActivity, this, Constant.SHOP_DETAIL_ULR, map, ShopDetailVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        ShopDetailVO shopDetailVO = (ShopDetailVO) vo;
        mDataBean = shopDetailVO.getData();

        List<MoneyVO> list = new ArrayList<>();
        for (int i = 0; i < mDataBean.getSpec_list().get(1).getValue().size(); i++) {
            MoneyVO moneyVO = new MoneyVO();
            if (i == 0){
                moneyVO.setStatus("1");
                mSelectVO=moneyVO;
                BaseCommonUtils.setTextTwoBefore(this, mPhpTv, mDataBean.getSpec_list().get(1).getValue().get(0).getSpec_value_name(), "PHP", R.color.FUBColor3, 1.7f);
                mShopType = mDataBean.getSpec_list().get(0).getValue().get(0).getSpec_id() + ":" + mDataBean.getSpec_list().get(0).getValue().get(0).getSpec_value_id();
                mMoneyStr = mDataBean.getSpec_list().get(1).getValue().get(0).getSpec_id() + ":" + mDataBean.getSpec_list().get(1).getValue().get(0).getSpec_value_id();

                totalMoney();
            }

            moneyVO.setMoney(mDataBean.getSpec_list().get(1).getValue().get(i).getSpec_value_name());
            moneyVO.setId(mDataBean.getSpec_list().get(1).getValue().get(i).getSpec_id() + ":" + mDataBean.getSpec_list().get(1).getValue().get(i).getSpec_value_id());
            list.add(moneyVO);
        }

        mAdapter.updateData(list);
        mTypeTv.setText(mDataBean.getSpec_list().get(0).getValue().get(0).getSpec_value_name());
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        if (mSelectVO != null) {
            mSelectVO.setStatus("0");
        }
        mSelectVO = mAdapter.getItem(position);
        mSelectVO.setStatus("1");
        mAdapter.notifyDataSetChanged();

        mMoneyStr = mSelectVO.getId();

        BaseCommonUtils.setTextTwoBefore(this, mPhpTv, mSelectVO.getMoney(), "PHP", R.color.FUBColor3, 1.7f);
        totalMoney();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.type_layout:
                final List<TieBean> datas = new ArrayList<TieBean>();
                for (int i = 0; i < mDataBean.getSpec_list().get(0).getValue().size(); i++) {
                    datas.add(new TieBean(mDataBean.getSpec_list().get(0).getValue().get(i).getSpec_value_name(),
                            BaseCommonUtils.parseInt(mDataBean.getSpec_list().get(0).getValue().get(i).getSpec_value_id())));
                }
                TieAdapter adapter = new TieAdapter(this, datas, true);
                BuildBean buildBean = DialogUIUtils.showMdBottomSheet(mActivity, true, "", datas, 0, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        String str = (String) text;
                        mTypeTv.setText(str);
                        mShopType = mDataBean.getSpec_list().get(0).getValue().get(position).getSpec_id() + ":" + mDataBean.getSpec_list().get(0).getValue().get(position).getSpec_value_id();

                        totalMoney();
                    }

                });
                buildBean.mAdapter = adapter;
                buildBean.show();

                break;
            case R.id.ok_tv:
                commit();

                break;
            default:
                break;
        }
    }


    public void totalMoney(){
        for (int i = 0; i < mDataBean.getSku_list().size(); i++) {
            if ((mMoneyStr + ";" + mShopType).equals(mDataBean.getSku_list().get(i).getAttr_value_items())) {
                BaseCommonUtils.setTextTwoBefore(PhoneChargeActivity.this, mRmbTv, mDataBean.getSku_list().get(i).getPrice_rmb(), "元", R.color.FUBColor3, 1.3f);
            }
        }
    }

    @Override
    public void success(BaseVO vo) {
        if (vo instanceof OrderCrateVO) {
            OrderCrateVO orderCrateVO = (OrderCrateVO) vo;
            pay(orderCrateVO.getData().getOut_trade_no(), orderCrateVO.getData().getPay_rmb());
        }
    }

    public void pay(String orderNo, String money) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("out_trade_no", orderNo);
        map.put("pay_type", mPayType);
        map.put("payment", money);

//        HttpGetDataUtil.post(this, Constant.SURE_ORDER2_URL, map, OrderPayVO.class,this);

        new Novate.Builder(PhoneChargeActivity.this)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build().rxPost(Constant.SURE_ORDER2_URL, map, new RxStringCallback() {


            @Override
            public void onError(Object o, Throwable throwable) {

                System.out.println("=============");
            }

            @Override
            public void onCancel(Object o, Throwable throwable) {

                System.out.println("=============");
            }

            @Override
            public void onNext(Object o, String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    int code = (int) jsonObject.get("code");
                    if (code == 200) {
                        if ("1".equals(mPayType)) {
                            Gson gson = new Gson();
                            final PayResult vo = gson.fromJson(s, PayResult.class);
                            PayUtis.weiXinPay(PhoneChargeActivity.this, vo.getData());
                        } else {
                            String payInfo = (String) jsonObject.get("data");
                            PayUtis.zhiFuBaoPay(PhoneChargeActivity.this, payInfo, new PayCallback() {
                                @Override
                                public void payResult(int type) {
                                    ;
                                    if (type == 1) {
                                        payFinish();
                                    } else {
                                        showCustomToast("支付失败");
                                    }
                                }
                            });
                        }

                    } else {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton v, boolean b) {
        switch (v.getId()) {
            case R.id.pay_cb_1:
                if (b) {
                    mPayCb2.setChecked(false);
                }

                break;
            case R.id.pay_cb_2:
                if (b) {
                    mPayCb1.setChecked(false);
                }
                break;


            default:
                break;
        }

        if (mPayCb1.isChecked()) {
            mPayType = "2";
        } else {
            mPayType = "1";
        }
    }

    public void commit() {
        if (TextUtils.isEmpty(mMoneyStr)) {
            showCustomToast("请选择金额");
            return;
        }
        if (TextUtils.isEmpty(mShopType)) {
            showCustomToast("充值类型");
            return;
        }


        for (int i = 0; i < mDataBean.getSku_list().size(); i++) {
            if ((mMoneyStr + ";" + mShopType).equals(mDataBean.getSku_list().get(i).getAttr_value_items())) {
                mPayStr = mDataBean.getSku_list().get(i).getSku_id() + ":1";
            }
        }

        showProgressDialog();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("goods_sku_list", mPayStr);
        map.put("user_telephone", mPhoneEt.getText().toString());
        HttpGetDataUtil.post(this, Constant.CHAGE_URL, map, OrderCrateVO.class, this);
    }

    public void payFinish() {
        showCustomToast("支付成功");
        mOkTv.postDelayed(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("type", "3");
                mActivity.open(PaymentRecordsActivity.class, bundle, 0);
                PhoneChargeActivity.this.finish();
            }


        }, 1000);
    }
}
