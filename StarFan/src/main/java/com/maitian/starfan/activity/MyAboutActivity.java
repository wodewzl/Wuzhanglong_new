package com.maitian.starfan.activity;

import com.maitian.starfan.R;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by ${Wuzhanglong} on 2019/3/30.
 */
public class MyAboutActivity extends BaseActivity {
    @Override
    public void baseSetContentView() {
     contentInflateView(R.layout.my_about_activity);
    }

    @Override
    public void initView() {

    }

    @Override
    public void bindViewsListener() {

    }

    @Override
    public void getData() {
        show();
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
