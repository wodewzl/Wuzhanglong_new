package com.wzl.feifubao.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.JobOffersAdapter;
import com.wzl.feifubao.adapter.MessageAdapter;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.LifeVO;
import com.wzl.feifubao.mode.PaymentRecordsVO;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class MessageActivity extends BaseActivity implements BGAOnRVItemClickListener, OnLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener{
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private MessageAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_message);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("消息");

        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new MessageAdapter(mRecyclerView);
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
//        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("uid", "39");
        map.put("page", mCurrentPage+"");
        map.put("pagesize", "10");
        HttpGetDataUtil.get(mActivity, this, Constant.MESSAGE_LIST_URL, map, PaymentRecordsVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
//        LifeVO lifeVO = (LifeVO) vo;
//        if (BaseCommonUtils.parseInt(lifeVO.getData().getPage_count())==1 ) {
//            mRecyclerView.setLoadMoreEnabled(false);
//        }
//        if (mCurrentPage == BaseCommonUtils.parseInt(lifeVO.getData().getPage_count())) {
//            mRecyclerView.setNoMore(true);
//        } else {
//            mRecyclerView.setNoMore(false);
//        }
//
//        List<LifeVO.DataBean.NewsBean> list = lifeVO.getData().getNews();
//        if (isLoadMore) {
//            mAdapter.updateDataLast(list);
//            isLoadMore = false;
//            mCurrentPage++;
//        } else {
//            mCurrentPage++;
//            mAdapter.updateData(list);
//        }
//        mAutoSwipeRefreshLayout.setRefreshing(false);
//        mAdapter.notifyDataSetChanged();
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
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {

    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }
}
