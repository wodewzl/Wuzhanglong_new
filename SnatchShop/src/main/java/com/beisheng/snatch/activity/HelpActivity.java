package com.beisheng.snatch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.beisheng.snatch.R;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

public class HelpActivity extends BaseActivity {

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.help_activity);
    }

    @Override
    public void initView() {

    }

    @Override
    public void bindViewsListener() {
        showView();
    }

    @Override
    public void getData() {

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
