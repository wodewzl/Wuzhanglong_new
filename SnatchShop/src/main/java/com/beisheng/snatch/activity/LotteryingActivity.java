package com.beisheng.snatch.activity;

import android.support.v7.widget.GridLayoutManager;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.LotteryingAdapter;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import cn.bingoogolapple.baseadapter.BGAGridDivider;

public class LotteryingActivity extends BaseActivity {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private LotteryingAdapter mAdapter;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.lotterying_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("最新揭晓");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity,2));
        BGAGridDivider divider =DividerUtil.bgaGridDivider(R.dimen.dp_2);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new LotteryingAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);

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
