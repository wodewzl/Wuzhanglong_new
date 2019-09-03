package com.wzl.feifubao.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.google.gson.Gson;
import com.rey.material.widget.CheckBox;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.mode.PayResult;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.utils.PayUtis;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.OrderSureAdapter;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.OrderCrateVO;
import com.wzl.feifubao.mode.OrderSureVO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.HashMap;

public class OrderSureActivity extends BaseActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, PostCallback {
    private LinearLayout mAddAddressLayout;
    private RelativeLayout mAddressLayout;
    View mXuxian;
    private TextView mNameTv, mPhoneTv, mAddressTv;
    private OrderSureVO.DataBean mDataBean;
    private LuRecyclerView mRecyclerView;
    private OrderSureAdapter mAdapter;
    private TextView mMoneyBiSuoTv, mMoneyTv, mTotalCountTv, mOkTv;
    private CheckBox mPayCb1, mPayCb2;
    private String mPayType;
    private EditText mLiuYanTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_order_sure);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("确认订单");
        mXuxian = getViewById(R.id.xuxian);
        mXuxian.setBackground(BaseCommonUtils.setBackgroundShap(this, 0, R.color.FUBColor7, R.color.FUBColor7, 1));
        mAddAddressLayout = getViewById(R.id.add_address_layout);
        mAddressLayout = getViewById(R.id.address_layout);
        mNameTv = getViewById(R.id.name_tv);
        mAddressTv = getViewById(R.id.address_tv);
        mPhoneTv = getViewById(R.id.phone_tv);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        mAdapter = new OrderSureAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setLoadMoreEnabled(false);
        mMoneyBiSuoTv = getViewById(R.id.money_bisuo_tv);
        mMoneyTv = getViewById(R.id.money_tv);
        mTotalCountTv = getViewById(R.id.total_count_tv);
        mPayCb1 = getViewById(R.id.pay_cb_1);
        mPayCb2 = getViewById(R.id.pay_cb_2);
        mOkTv = getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.colorAccent, R.color.colorAccent));
        mLiuYanTv = getViewById(R.id.liuyan_tv);
    }

    @Override
    public void bindViewsListener() {
        mAddressLayout.setOnClickListener(this);
        mAddAddressLayout.setOnClickListener(this);
        EventBus.getDefault().register(this);
        mOkTv.setOnClickListener(this);
        mPayCb1.setOnCheckedChangeListener(this);
        mPayCb2.setOnCheckedChangeListener(this);
        mPayCb1.setChecked(true);
    }

    @Override
    public void getData() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("sku_list", this.getIntent().getStringExtra("sku_list"));

        HttpGetDataUtil.get(mActivity, this, Constant.COMMIT_ORDER_URL, map, OrderSureVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        OrderSureVO orderSureVO = (OrderSureVO) vo;
        mDataBean = orderSureVO.getData();
        if ("1".equals(mDataBean.getAddress_is_have())) {
            mAddressLayout.setVisibility(View.VISIBLE);
            mAddAddressLayout.setVisibility(View.GONE);
            mNameTv.setText("收货人：" + mDataBean.getAddresslist().get(0).getConsigner());
            mPhoneTv.setText("" + mDataBean.getAddresslist().get(0).getMobile());
            mAddressTv.setText(mDataBean.getAddresslist().get(0).getAddress_info() + mDataBean.getAddresslist().get(0).getAddress());
        } else {
            mAddressLayout.setVisibility(View.GONE);
            mAddAddressLayout.setVisibility(View.VISIBLE);
        }

        if (mDataBean.getList() != null && mDataBean.getList().size() > 0) {
            mAdapter.updateData(mDataBean.getList());
        }

        BaseCommonUtils.setTextTwoLast(this, mMoneyBiSuoTv, "支付索比：", mDataBean.getTotal_price() + "P", R.color.FUBColor3, 1.3f);
        BaseCommonUtils.setTextTwoLast(this, mMoneyTv, "小计：", "￥" + mDataBean.getTotal_price_rmb(), R.color.FUBColor3, 1.3f);
        BaseCommonUtils.setTextThree(this, mTotalCountTv, "共", mDataBean.getExpressCompanyCount(), "件商品", R.color.FUBColor3, 1.3f);
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.address_layout:
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", (Serializable) mDataBean.getAddresslist());
                open(AddressSelectActivity.class, bundle, 0);
                break;
            case R.id.add_address_layout:
                openActivity(AddressAddActivity.class);
                break;

            case R.id.ok_tv:
                if (TextUtils.isEmpty(mPhoneTv.getText().toString())) {
                    showCustomToast("请填写收获地址");
                    return;
                }
                commit();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {
        if ("refresh".equals(event.getMessage())) {
            getData();
        } else if ("order_change".equals(event.getMessage())) {
            String[] strArray = event.getParams();
            mNameTv.setText("收货人：" + strArray[0]);
            mPhoneTv.setText("" + strArray[1]);
            mAddressTv.setText(strArray[2] + strArray[3]);
        } else if ("weixin_pay".equals(event.getMessage())) {
            payFinish();
        }
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

    @Override
    public void success(BaseVO vo) {
        if (vo instanceof OrderCrateVO) {
            OrderCrateVO orderCrateVO = (OrderCrateVO) vo;
            pay(orderCrateVO.getData().getOut_trade_no(), orderCrateVO.getData().getPay_rmb());
        }
    }

    public void commit() {
        showProgressDialog();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("goods_sku_list", mDataBean.getGoods_sku_list());
        map.put("leavemessage", mLiuYanTv.getText().toString());
        map.put("mobile", mPhoneTv.getText().toString());
        map.put("province", mDataBean.getAddresslist().get(0).getProvince());
        map.put("city", mDataBean.getAddresslist().get(0).getCity());
        map.put("district", mDataBean.getAddresslist().get(0).getDistrict());
        map.put("address", mDataBean.getAddresslist().get(0).getAddress());
        HttpGetDataUtil.post(this, Constant.SURE_ORDER1_URL, map, OrderCrateVO.class, this);
    }

    public void pay(String orderNo, String money) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("out_trade_no", orderNo);
        map.put("pay_type", mPayType);
        map.put("payment", money);
//        map.put("payment", "0.01");
//        HttpGetDataUtil.post(this, Constant.SURE_ORDER2_URL, map, OrderPayVO.class,this);

        new Novate.Builder(OrderSureActivity.this)
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
                            PayUtis.weiXinPay(OrderSureActivity.this, vo.getData());
                        } else {
                            String payInfo = (String) jsonObject.get("data");
                            PayUtis.zhiFuBaoPay(OrderSureActivity.this, payInfo, new PayCallback() {
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


    public void payFinish() {
        showCustomToast("支付成功");
        mOkTv.postDelayed(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("type", "0");
                mActivity.open(OrderActivity.class, bundle, 0);
                OrderSureActivity.this.finish();
            }


        }, 1000);
    }
}
