package com.maitian.starmily.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.NewsReplyAdapter;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.DiscussReplyBean;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DateUtils;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import de.hdodenhof.circleimageview.CircleImageView;

public class HomeNewsReplyActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener, View.OnClickListener, BGAOnItemChildClickListener, PostCallback {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private NewsReplyAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private CircleImageView mHeadIv;
    private TextView mNameTv, mContentTv, mTimeTv, mLikeCountTv, mDiscussCountTv;
    private int mType = 1;//帖子评论2帖子回复3资讯回复
    private TextView mCommitTv, mDiscussTv;


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
        String headUrl = intent.getStringExtra("head_url");
        if (!TextUtils.isEmpty(headUrl)) {
            if (headUrl.contains("http://")) {
                Picasso.with(this).load(headUrl).error(R.drawable.user_icon_def).into(mHeadIv);
            } else {
                Picasso.with(this).load(Constant.DOMAIN_UR + "/" + headUrl).error(R.drawable.user_icon_def).into(mHeadIv);
            }
        }

        if ("0".equals(this.getIntent().getStringExtra("like_status"))) {
            mLikeCountTv.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_normal_small, 0, 0, 0);
        } else {
            mLikeCountTv.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_press_small, 0, 0, 0);
        }
        mNameTv.setText(intent.getStringExtra("name"));
        mContentTv.setText(intent.getStringExtra("content"));
        mTimeTv.setText(DateUtils.parseDateDayAndHour(intent.getLongExtra("time", 0) + ""));
        mLikeCountTv.setText(intent.getStringExtra("like_count"));
        mDiscussCountTv.setText(intent.getStringExtra("discuss_count"));
        mType = intent.getIntExtra("type", 1);
        mAdapter.setType(mType);
        mCommitTv = getViewById(R.id.commit_tv);
        mDiscussTv = getViewById(R.id.discuss_count_tv);
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mCommitTv.setOnClickListener(this);
        mDiscussTv.setOnClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        mLikeCountTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("pageNum", mCurrentPage + "");
        map.put("pageSize", "10");

        if (mType == 1) {
            map.put("topicId", this.getIntent().getStringExtra("id"));
            map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
            StartHttpUtils.get(mActivity, this, Constant.TOPIC_FIND_COMMENT_BY_PAGE, map, DiscussReplyBean.class);
        } else if (mType == 2) {
            map.put("id", this.getIntent().getStringExtra("id"));
            StartHttpUtils.get(mActivity, this, Constant.TOPIC_FIND_REPLY_BY_PAGE, map, DiscussReplyBean.class);
        } else if (mType == 3) {
            map.put("id", this.getIntent().getStringExtra("id"));
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

    public void commit() {
        if (mType == 1) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "1");
            bundle.putString("topicId", this.getIntent().getStringExtra("id"));
            bundle.putString("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId() + "");
            mActivity.open(PublishDiscussActivity.class, bundle, 0);
        } else if (mType == 2) {
            Bundle bundleDiscuss = new Bundle();
            bundleDiscuss.putString("type", "2");
            bundleDiscuss.putString("commentId", this.getIntent().getStringExtra("id"));
            bundleDiscuss.putString("fromUserId", this.getIntent().getStringExtra("user_id"));
            bundleDiscuss.putString("toUserId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId() + "");
            mActivity.open(PublishDiscussActivity.class, bundleDiscuss, 0);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit_tv:
                commit();
                break;
            case R.id.discuss_count_tv:
                commit();
                break;
            case R.id.like_count_tv:
                headLike();
                break;
            default:
                break;

        }
    }

    @Override
    public void onItemChildClick(ViewGroup parent, View childView, int position) {
        DiscussReplyBean.ObjBean.ListBean bean = (DiscussReplyBean.ObjBean.ListBean) mAdapter.getItem(position);
        if (mType == 1) {
            commitLikePost(bean.getCommentId() + "", bean.getLikeStatus());
        } else if (mType == 2) {
            replayLikePost(bean.getReplyId() + "", bean.getLikeStatus());
        } else if (mType == 3) {

        } else if (mType == 4) {

        }
    }


    //帖子点赞
    public void likePost(String topicId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("topicId", topicId);
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.postCallBack(mActivity, Constant.LIKE_TOPIC, map, BaseVO.class, this);
    }

    //评论点赞
    public void commitLikePost(String id, int status) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("commentId", id);
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        if (status == 1) {
            map.put("type", "0");
        } else {
            map.put("type", "1");
        }
        StartHttpUtils.postCallBack(mActivity, Constant.LIKE_COMMENT, map, BaseVO.class, this);
    }

    //回复点赞
    public void replayLikePost(String id, int status) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("replyId", id);
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        if (status == 1) {
            map.put("type", "0");
        } else {
            map.put("type", "1");
        }
        StartHttpUtils.postCallBack(mActivity, Constant.LIKE_REPLY, map, BaseVO.class, this);
    }

    public void headLike() {
        if (mType == 1) {
            likePost(this.getIntent().getStringExtra("id"));
        } else if (mType == 2) {
            commitLikePost(this.getIntent().getStringExtra("id"), Integer.parseInt(this.getIntent().getStringExtra("like_status")));
            if ("0".equals(this.getIntent().getStringExtra("like_status"))) {
                mLikeCountTv.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_press_small, 0, 0, 0);
            } else {
                mLikeCountTv.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_normal_small, 0, 0, 0);
            }
        } else if (mType == 3) {

        } else if (mType == 4) {

        }
    }

    @Override
    public void success(BaseVO vo) {
        showCustomToast(vo.getMsg());
        getData();
    }
}
