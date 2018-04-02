package com.beisheng.snatch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.beisheng.snatch.R;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

public class SettingActivity extends BaseActivity {

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.setting_activity);
    }

    @Override
    public void initView() {
            mBaseTitleTv.setText("设置");
    }

    @Override
    public void bindViewsListener() {

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
}
