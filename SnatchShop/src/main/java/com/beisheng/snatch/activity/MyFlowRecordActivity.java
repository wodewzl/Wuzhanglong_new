package com.beisheng.snatch.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.MyFlowRecordAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.MyFlowRecordVO;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

public class MyFlowRecordActivity extends BaseActivity implements OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private MyFlowRecordAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_flow_record_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("兑换记录");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new MyFlowRecordAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        map.put("curpage", mCurrentPage + "");
        BSHttpUtils.post(mActivity, this, Constant.FLOW_RECORD_URL, map, MyFlowRecordVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        MyFlowRecordVO bean = (MyFlowRecordVO) vo;
        if (BaseCommonUtils.parseInt(bean.getData().getCount()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(bean.getData().getCount())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        List<MyFlowRecordVO.DataBean.ListBean> list = bean.getData().getList();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
        } else {
            mAdapter.updateData(list);
        }
        mAdapter.notifyDataSetChanged();
        mAutoSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        mCurrentPage++;
        getData();
    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        getData();
    }
}
