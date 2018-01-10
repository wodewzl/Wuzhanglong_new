package com.wzl.feifubao.fragment;


import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.AddressActivity;
import com.wzl.feifubao.activity.MyHouseActivity;
import com.wzl.feifubao.activity.MyOverActivity;
import com.wzl.feifubao.activity.PaymentRecordsActivity;

public class TabThreeFragment extends BaseFragment implements View.OnClickListener {
    private TextView mOrderTv01, mOrderTv02, mOrderTv03, mOrderTv04, mOrderTv05;
    private LinearLayout mPhoneLayout, mDianLayout, mWangLayout, mHouseLayout, mLogoutLayout, mOverLayout, mAddressLayout;


    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_three_layout);
    }

    @Override
    public void initView(View view) {
        mActivity.mBaseHeadLayout.setVisibility(View.GONE);
        mOrderTv01 = getViewById(R.id.order_tv_01);
        mOrderTv02 = getViewById(R.id.order_tv_02);
        mOrderTv03 = getViewById(R.id.order_tv_03);
        mOrderTv04 = getViewById(R.id.order_tv_04);
        mOrderTv05 = getViewById(R.id.order_tv_05);
        mOverLayout = getViewById(R.id.over_layout);
        mPhoneLayout = getViewById(R.id.phone_layout);
        mDianLayout = getViewById(R.id.dian_layout);
        mWangLayout = getViewById(R.id.wang_layout);
        mHouseLayout = getViewById(R.id.house_layout);
        mLogoutLayout = getViewById(R.id.logout_layout);
        mAddressLayout = getViewById(R.id.address_layout);

    }

    @Override
    public void bindViewsListener() {
        mOrderTv01.setOnClickListener(this);
        mOrderTv02.setOnClickListener(this);
        mOrderTv03.setOnClickListener(this);
        mOrderTv04.setOnClickListener(this);
        mOrderTv05.setOnClickListener(this);
        mOverLayout.setOnClickListener(this);
        mPhoneLayout.setOnClickListener(this);
        mDianLayout.setOnClickListener(this);
        mWangLayout.setOnClickListener(this);
        mHouseLayout.setOnClickListener(this);
        mAddressLayout.setOnClickListener(this);
    }

    @Override
    public void getData() {
        showView();
    }

    @Override
    public void hasData(BaseVO vo) {

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.order_tv_01:
//                bundle.putString("type", "1");
//                mActivity.open(OrderActivity.class, bundle, 0);
                break;
            case R.id.order_tv_02:
//                bundle.putString("type", "2");
//                mActivity.open(OrderActivity.class, bundle, 0);
                break;
            case R.id.order_tv_03:
//                bundle.putString("type", "4");
//                mActivity.open(OrderActivity.class, bundle, 0);
                break;
            case R.id.order_tv_04:
////                bundle.putString("type", "4");
////                mActivity.open(OrderActivity.class, bundle, 0);
//                mActivity.openActivity(ShopBackActivity.class);
                break;
            case R.id.order_tv_05:
//                bundle.putString("type", "3");
//                mActivity.open(OrderActivity.class, bundle, 0);
                break;

            case R.id.over_layout:
                mActivity.openActivity(MyOverActivity.class);
                break;
            case R.id.phone_layout:
                bundle.putString("type", "3");
                mActivity.open(PaymentRecordsActivity.class, bundle, 0);
                break;
            case R.id.dian_layout:
                bundle.putString("type", "1");
                mActivity.open(PaymentRecordsActivity.class, bundle, 0);
                break;
            case R.id.wang_layout:
                bundle.putString("type", "2");
                mActivity.open(PaymentRecordsActivity.class, bundle, 0);
                break;
            case R.id.house_layout:
                mActivity.openActivity(MyHouseActivity.class);
                break;
            case R.id.address_layout:
                mActivity.openActivity(AddressActivity.class);
                break;
            default:
                break;
        }
    }
}
