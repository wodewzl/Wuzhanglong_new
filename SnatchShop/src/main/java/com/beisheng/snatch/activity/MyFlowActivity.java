package com.beisheng.snatch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.MoneyAdapter;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

public class MyFlowActivity extends BaseActivity {
    private String[] mOneyArray = {"30PHP", "50PHP", "100PHP", "300PHP", "500PHP", "1000PHP", "2000PHP", "3000PHP"};
    private LuRecyclerView mRecyclerView;
    private MoneyAdapter mAdapter;
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_flow_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("我的流量");
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        mAdapter = new MoneyAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadMoreEnabled(false);
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
