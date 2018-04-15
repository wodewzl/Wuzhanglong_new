package com.beisheng.snatch.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.application.AppApplication;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.VersionUtils;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTv01, mTv02, mTv03, mTv04, mTv05, mTv06, mTv07, mTv08;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.setting_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("设置");
        mTv01 = getViewById(R.id.tv_01);
        mTv02 = getViewById(R.id.tv_02);
        mTv03 = getViewById(R.id.tv_03);
        mTv04 = getViewById(R.id.tv_04);
        mTv05 = getViewById(R.id.tv_05);
        mTv06 = getViewById(R.id.tv_06);
        mTv07 = getViewById(R.id.tv_07);
        mTv07.setText("当前版本："+VersionUtils.getversionName(this));
        mTv08 = getViewById(R.id.tv_08);
    }

    @Override
    public void bindViewsListener() {
        mTv01.setOnClickListener(this);
        mTv02.setOnClickListener(this);
        mTv03.setOnClickListener(this);
        mTv04.setOnClickListener(this);
        mTv05.setOnClickListener(this);
        mTv06.setOnClickListener(this);
        mTv08.setOnClickListener(this);

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
            case R.id.tv_01:
                openActivity(NameConfirmActivity.class);
                break;
            case R.id.tv_02:
                bundle.putString("title","关于我们");
                bundle.putString("url", AppApplication.getInstance().getUserInfoVO().getData().getAboutus_url());
                open(WebViewActivity.class,bundle,0);
                break;
            case R.id.tv_03:

                break;
            case R.id.tv_04:
                bundle.putString("title","服务协议");
                bundle.putString("url", AppApplication.getInstance().getUserInfoVO().getData().getFwxy_url());
                open(WebViewActivity.class,bundle,0);
                break;
            case R.id.tv_05:
                bundle.putString("title","隐私协议");
                bundle.putString("url", AppApplication.getInstance().getUserInfoVO().getData().getYsxy_url());
                open(WebViewActivity.class,bundle,0);
                break;
            case R.id.tv_06:
                mActivity.openActivity(AddressActivity.class);
                break;
            case R.id.tv_08:
                mActivity.openActivity(HelpActivity.class);
                break;

            default:
                break;
        }
    }
}
