package com.maitian.starmily.activity;

import com.maitian.starmily.R;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

public class MyBindPhoneActivity extends BaseActivity {

    @Override
    public void baseSetContentView() {
     contentInflateView(R.layout.my_bind_phone_activity);
    }

    @Override
    public void initView() {

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
