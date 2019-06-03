package com.maitian.starmily.activity;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.PaurseDetailAdapter;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

public class MyPaurseDetailActivity extends BaseActivity {
    private LuRecyclerView mRecyclerView;
    private PaurseDetailAdapter mAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_paurse_detail_activity);
    }

    @Override
    public void initView() {
        mBaseOkTv.setText("使用明细");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new PaurseDetailAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_10, R.color.C3, true);
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
