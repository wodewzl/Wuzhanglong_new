package com.maitian.starmily.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.NewsReplyAdapter;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.DiscussReplyBean;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DateUtils;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeNewsReplyActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private NewsReplyAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private CircleImageView mHeadIv;
    private TextView mNameTv, mContentTv, mTimeTv, mLikeCountTv, mDiscussCountTv;
    private int mType=1;//帖子评论2帖子回复3资讯回复

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.home_news_reply_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("回复详情");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new NewsReplyAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, true);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
        mHeadIv = getViewById(R.id.head_img);
        mNameTv = getViewById(R.id.name_tv);
        mContentTv = getViewById(R.id.content_tv);
        mTimeTv = getViewById(R.id.time_tv);
        mLikeCountTv = getViewById(R.id.like_count_tv);
        mDiscussCountTv = getViewById(R.id.discuss_count_tv);
        Intent intent = this.getIntent();
        mNameTv.setText(intent.getStringExtra("name"));
        mContentTv.setText(intent.getStringExtra("content"));
        mTimeTv.setText(DateUtils.parseDateDayAndHour(intent.getLongExtra("time", 0)+""));
        mLikeCountTv.setText(intent.getStringExtra("like_count"));
        mDiscussCountTv.setText(intent.getStringExtra("discuss_count"));
        mType=intent.getIntExtra("type",1);
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("pageNum", mCurrentPage + "");
        map.put("pageSize", "10");
        map.put("id", this.getIntent().getStringExtra("id"));
        if(mType==1){
            StartHttpUtils.get(mActivity, this, Constant.TOPIC_FIND_COMMENT_BY_PAGE, map, DiscussReplyBean.class);
        }else if(mType==2){
            StartHttpUtils.get(mActivity, this, Constant.TOPIC_FIND_REPLY_BY_PAGE, map, DiscussReplyBean.class);
        }else if(mType==3){
            StartHttpUtils.get(mActivity, this, Constant.FIND_REPLY_BY_PAGE, map, DiscussReplyBean.class);
        }
    }

    @Override
    public void hasData(BaseVO vo) {
        DiscussReplyBean bean = (DiscussReplyBean) vo;
        if (bean.getObj().isHasNextPage()) {
            mRecyclerView.setNoMore(false);
        } else {
            mRecyclerView.setNoMore(true);
        }
        mAutoSwipeRefreshLayout.setRefreshing(false);
        List<DiscussReplyBean.ObjBean.ListBean> list = bean.getObj().getList();
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
}
