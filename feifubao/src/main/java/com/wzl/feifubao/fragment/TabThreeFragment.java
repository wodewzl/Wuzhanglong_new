package com.wzl.feifubao.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.AddressActivity;
import com.wzl.feifubao.activity.LoginActivity;
import com.wzl.feifubao.activity.MyHouseActivity;
import com.wzl.feifubao.activity.MyOverActivity;
import com.wzl.feifubao.activity.OrderActivity;
import com.wzl.feifubao.activity.PaymentRecordsActivity;
import com.wzl.feifubao.activity.UserInfoActivity;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.MyMessageVO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import cn.pedant.SweetAlert.SweetAlertDialog;
import q.rorbin.badgeview.QBadgeView;

public class TabThreeFragment extends BaseFragment implements View.OnClickListener {
    private TextView mOrderTv01, mOrderTv02, mOrderTv03, mOrderTv04, mOrderTv05, mNameTv, mDescTV;
    private LinearLayout mPhoneLayout, mDianLayout, mWangLayout, mHouseLayout, mLogoutLayout, mOverLayout, mAddressLayout, mOrderLayout;
    private QBadgeView mQBadgeView01, mQBadgeView02, mQBadgeView03, mQBadgeView04, mQBadgeView05;
    private ImageView mMyInfoImg, mHeadImg;


    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_three_layout);
    }

    @Override
    public void initView(View view) {
        mActivity.mBaseHeadLayout.setVisibility(View.GONE);
        mHeadImg = getViewById(R.id.head_img);
        mNameTv = getViewById(R.id.name_tv);
        mDescTV = getViewById(R.id.desc_tv);
        if (AppApplication.getInstance().getUserInfoVO() != null) {
            if (!TextUtils.isEmpty(AppApplication.getInstance().getUserInfoVO().getData().getUser_headimg()))
                Picasso.with(mActivity).load(AppApplication.getInstance().getUserInfoVO().getData().getUser_headimg()).into(mHeadImg);
            mNameTv.setText(AppApplication.getInstance().getUserInfoVO().getData().getNick_name());
            mDescTV.setText(AppApplication.getInstance().getUserInfoVO().getData().getUser_email());
        }


        mMyInfoImg = getViewById(R.id.my_info_img);
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
        mOrderLayout = getViewById(R.id.order_layout);

        mQBadgeView01 = (QBadgeView) new QBadgeView(mActivity).bindTarget(mOrderTv01).setBadgeGravity(Gravity.END | Gravity
                .TOP).setShowShadow(true).setBadgeTextSize(10, true)
                .setGravityOffset(8, 0, true);
        mQBadgeView02 = (QBadgeView) new QBadgeView(mActivity).bindTarget(mOrderTv02).setBadgeGravity(Gravity.END | Gravity
                .TOP).setShowShadow(true).setBadgeTextSize(10, true)
                .setGravityOffset(8, 0, true);
        mQBadgeView03 = (QBadgeView) new QBadgeView(mActivity).bindTarget(mOrderTv03).setBadgeGravity(Gravity.END | Gravity
                .TOP).setShowShadow(true).setBadgeTextSize(10, true)
                .setGravityOffset(8, 0, true);
        mQBadgeView04 = (QBadgeView) new QBadgeView(mActivity).bindTarget(mOrderTv04).setBadgeGravity(Gravity.END | Gravity.TOP)
                .setShowShadow(true).setBadgeTextSize(10, true)
                .setGravityOffset(8, 0, true);
        mQBadgeView05 = (QBadgeView) new QBadgeView(mActivity).bindTarget(mOrderTv05).setBadgeGravity(Gravity.END | Gravity
                .TOP).setShowShadow(true).setBadgeTextSize(10, true)
                .setGravityOffset(8, 0, true);
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
        mOrderLayout.setOnClickListener(this);
        mMyInfoImg.setOnClickListener(this);
        mLogoutLayout.setOnClickListener(this);
        EventBus.getDefault().register(this);
        mHeadImg.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        HttpGetDataUtil.get(mActivity, this, Constant.MY_MESSAGE_URL, map, MyMessageVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        MyMessageVO myMessageVO = (MyMessageVO) vo;
        mQBadgeView01.setBadgeNumber(BaseCommonUtils.parseInt(myMessageVO.getData().getWait_pay()));
        mQBadgeView02.setBadgeNumber(BaseCommonUtils.parseInt(myMessageVO.getData().getWait_delivery()));
        mQBadgeView03.setBadgeNumber(BaseCommonUtils.parseInt(myMessageVO.getData().getWait_recieved()));
        mQBadgeView04.setBadgeNumber(BaseCommonUtils.parseInt(myMessageVO.getData().getRecieved()));
        mQBadgeView05.setBadgeNumber(BaseCommonUtils.parseInt(myMessageVO.getData().getRefunding()));
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onClick(View v) {

        if (AppApplication.getInstance().getUserInfoVO() == null) {
            mActivity.openActivity(LoginActivity.class);
            return;
        }
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.head_img:
            case R.id.my_info_img:
                mActivity.openActivity(UserInfoActivity.class);
                break;
            case R.id.order_layout:
                mActivity.openActivity(OrderActivity.class);
                break;
            case R.id.order_tv_01:
                bundle.putString("type", "1");
                mActivity.open(OrderActivity.class, bundle, 0);
                break;
            case R.id.order_tv_02:
                bundle.putString("type", "2");
                mActivity.open(OrderActivity.class, bundle, 0);
                break;
            case R.id.order_tv_03:
                bundle.putString("type", "3");
                mActivity.open(OrderActivity.class, bundle, 0);
                break;
            case R.id.order_tv_04:
                bundle.putString("type", "4");
                mActivity.open(OrderActivity.class, bundle, 0);

                break;
            case R.id.order_tv_05:
//                bundle.putString("type", "5");
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
            case R.id.logout_layout:
                new SweetAlertDialog(mActivity, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要退出登录吗?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                AppApplication.getInstance().saveUserInfoVO(null);
                                logOut();

                                JPushInterface.setAlias(mActivity, "", new TagAliasCallback() {
                                    @Override
                                    public void gotResult(int i, String s, Set<String> set) {
                                    }
                                });
                                sDialog.dismissWithAnimation();//直接消失
                            }
                        })
                        .show();


                break;
            default:
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEvent(String event) {

    }

    @Subscribe
    public void onEventMainThread(EBMessageVO event) {
        if ("update".equals(event.getMessage())) {
            if (AppApplication.getInstance().getUserInfoVO() != null) {
                if (!TextUtils.isEmpty(AppApplication.getInstance().getUserInfoVO().getData().getUser_headimg()))
                    Picasso.with(mActivity).load(AppApplication.getInstance().getUserInfoVO().getData().getUser_headimg()).into(mHeadImg);
                mNameTv.setText(AppApplication.getInstance().getUserInfoVO().getData().getNick_name());
                mDescTV.setText(AppApplication.getInstance().getUserInfoVO().getData().getUser_email());
            }
        }
    }

    public void logOut() {
        mQBadgeView01.setBadgeNumber(0);
        mQBadgeView02.setBadgeNumber(0);
        mQBadgeView03.setBadgeNumber(0);
        mQBadgeView04.setBadgeNumber(0);
        mQBadgeView05.setBadgeNumber(0);
        mNameTv.setText("点击登录");
        mDescTV.setText("");
        mActivity.openActivity(LoginActivity.class);
    }

}
