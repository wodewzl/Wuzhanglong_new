package com.maitian.starmily.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.FindServiceAdapter;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.FindServiceBean;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class FindServiceActivity extends BaseActivity implements BGAOnRVItemClickListener, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private FindServiceAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.find_service_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("应援服务");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new FindServiceAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_10, R.color.C3, true);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("pageNum", mCurrentPage + "");
        map.put("pageSize", "10");
        StartHttpUtils.get(mActivity, this, Constant.CUSTOM_SERVICE_LIST, map, FindServiceBean.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        FindServiceBean bean = (FindServiceBean) vo;
        if (bean.getObj().isHasNextPage()) {
            mRecyclerView.setNoMore(false);
        } else {
            mRecyclerView.setNoMore(true);
        }
        mAutoSwipeRefreshLayout.setRefreshing(false);
        List<FindServiceBean.ObjBean.ListBean> list = bean.getObj().getList();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
        } else {
            mAdapter.updateData(list);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        getData();
    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        mCurrentPage++;
        getData();
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
    }
}
