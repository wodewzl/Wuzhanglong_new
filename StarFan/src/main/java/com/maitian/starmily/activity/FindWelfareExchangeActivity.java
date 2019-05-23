package com.maitian.starmily.activity;

import com.maitian.starmily.R;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

public class FindWelfareExchangeActivity extends BaseActivity {


    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.find_welfare_exchange_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("XXXX福利兑换详情");
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
