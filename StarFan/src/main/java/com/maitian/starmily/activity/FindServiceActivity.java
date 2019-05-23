package com.maitian.starmily.activity;

import android.speech.tts.TextToSpeech;
import android.support.v7.widget.LinearLayoutManager;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.FindAdapter;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

public class FindServiceActivity extends BaseActivity {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private FindAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private TextToSpeech mTextToSpeech = null;
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.find_service_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("服务中心");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new FindAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_10, R.color.C1, true);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
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
