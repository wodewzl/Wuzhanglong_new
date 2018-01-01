package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wzl.feifubao.R;

public class JobOffersDetailActivity extends BaseActivity {
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_job_offers_detail);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("招聘信息");

    }

    @Override
    public void bindViewsListener() {

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
