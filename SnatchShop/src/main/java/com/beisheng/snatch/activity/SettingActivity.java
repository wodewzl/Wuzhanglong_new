package com.beisheng.snatch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

public class SettingActivity extends BaseActivity implements View.OnClickListener{
    private TextView mTv01;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.setting_activity);
    }

    @Override
    public void initView() {
            mBaseTitleTv.setText("设置");
            mTv01=getViewById(R.id.tv_01);
    }

    @Override
    public void bindViewsListener() {
        mTv01.setOnClickListener(this);
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
        switch (v.getId()) {
            case R.id.tv_01:
                mActivity.openActivity(NameConfirmActivity.class);
                break;
            case R.id.item_02_tv:
                mActivity.openActivity(MyLuckyRecordActivity.class);
                break;
            case R.id.item_03_tv:
                mActivity.openActivity(BuyFlowActivity.class);
                break;
            case R.id.item_04_tv:
                mActivity.openActivity(MyShowActivity.class);
                break;
            case R.id.item_05_tv:
                mActivity.openActivity(MyCollectActivity.class);
                break;
            case R.id.item_06_tv:
                mActivity.openActivity(AddressActivity.class);
                break;
            case R.id.item_07_tv:
                mActivity.openActivity(HelpActivity.class);
                break;
            case R.id.buy_flow_tv:
                mActivity.openActivity(BuyFlowActivity.class);
                break;
            default:
                break;
        }
    }
}
