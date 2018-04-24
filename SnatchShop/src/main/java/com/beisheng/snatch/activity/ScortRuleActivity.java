package com.beisheng.snatch.activity;

import android.widget.TextView;

import com.beisheng.snatch.R;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

public class ScortRuleActivity extends BaseActivity {
    private TextView mRuleTv;
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.scort_rule_activity);
    }

    @Override
    public void initView() {
        mRuleTv=getViewById(R.id.rule_tv);
        mRuleTv.setText(this.getIntent().getStringExtra("content"));
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
