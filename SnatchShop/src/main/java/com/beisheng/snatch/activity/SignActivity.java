package com.beisheng.snatch.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.ShopChoseAdapter;
import com.beisheng.snatch.adapter.SignAdapter;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;

import cn.bingoogolapple.baseadapter.BGAGridDivider;

public class SignActivity extends BaseActivity {
    private LuRecyclerView mRecyclerView;
    private SignAdapter mAdapter;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.sign_activity);

    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("签到有礼");
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2));
        mAdapter = new SignAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);

        adapter.addHeaderView(initHeadView());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
    }

public View initHeadView(){
    View header = View.inflate(mActivity, R.layout.sign_head_layout, null);
    return header;
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
