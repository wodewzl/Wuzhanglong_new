package com.beisheng.snatch.activity;

import com.beisheng.snatch.R;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

public class DailyTaskDetailActivity extends BaseActivity {

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.daily_task_detail_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("任务详情");
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
