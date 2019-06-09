package com.maitian.starmily.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.NewsAdapter;
import com.maitian.starmily.adapter.RiceCircleDetailAdapter;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.RiceCircleVO;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class RiceCircleDetailActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private RiceCircleDetailAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;


    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.rice_circle_detail_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("回复详情");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new RiceCircleDetailAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_10, R.color.C3, true);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);

    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
    }

    @Override
    public void getData() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("topicId", "2");
//        map.put("userId", "4338");
//        map.put("pageNum", mCurrentPage + "");
//        map.put("pageSize", "10");
//        BSHttpUtils.post(mActivity, this, Constant.TOPIC_DETAILS, map, RiceCircleVO.class);
        showView();
    }

    @Override
    public void hasData(BaseVO vo) {
//        MyMessageVO myMessageVO = (MyMessageVO) vo;
//        if (BaseCommonUtils.parseInt(myMessageVO.getData().getCount()) == 1) {
//            mRecyclerView.setLoadMoreEnabled(false);
//        }
//        if (mCurrentPage == BaseCommonUtils.parseInt(myMessageVO.getData().getCount())) {
//            mRecyclerView.setNoMore(true);
//        } else {
//            mRecyclerView.setNoMore(false);
//        }
//        List<MyMessageVO.DataBean.ListBean> list = myMessageVO.getData().getList();
//        if (isLoadMore) {
//            mAdapter.updateDataLast(list);
//            isLoadMore = false;
//        } else {
//            mAdapter.updateData(list);
//        }
//        mAdapter.notifyDataSetChanged();
//        mAutoSwipeRefreshLayout.setRefreshing(false);
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
}
