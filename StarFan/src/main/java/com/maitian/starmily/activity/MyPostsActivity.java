package com.maitian.starmily.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.MyPostAdapter;
import com.maitian.starmily.adapter.PaurseDetailAdapter;
import com.maitian.starmily.adapter.PostAdapter;
import com.maitian.starmily.adapter.RiceCircleAdapter;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.MyPostBean;
import com.maitian.starmily.model.RiceCircleVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyPostsActivity extends BaseActivity implements View.OnClickListener, Serializable, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener, PostCallback, MyPostAdapter.ChildClikCallback {
    private LuRecyclerView mRecyclerView;
    private MyPostAdapter mAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private int mCurrentPage = 1;
    private boolean isLoadMore = false;
    private boolean isFirst = true;
    private CircleImageView mHeadIv;
    private TextView mNameTv,mAttentionTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_posts_activity);
    }

    @Override
    public void initView() {
        mBaseHeadLayout.setVisibility(View.GONE);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new MyPostAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, true);
        mHeadIv = getViewById(R.id.head_iv);
        mNameTv = getViewById(R.id.name_tv);
        mAttentionTv=getViewById(R.id.attention_tv);
    }

    @Override
    public void bindViewsListener() {
        mAdapter.setChildClikCallback(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
//        mAdapter.setOnRVItemClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mAttentionTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId() + "");
        map.put("followUserId", this.getIntent().getStringExtra("followUserId"));
        map.put("pageNum", mCurrentPage + "");
        map.put("pageSize", "10");
        StartHttpUtils.get(mActivity, this, Constant.USER_TOPIC_LIST, map, MyPostBean.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        MyPostBean myPostBean = (MyPostBean) vo;
        if (myPostBean.getObj().getTopics().isHasNextPage()) {
            mRecyclerView.setNoMore(false);
        } else {
            mRecyclerView.setNoMore(true);
            mRecyclerView.setLoadMoreEnabled(false);
        }
        mAutoSwipeRefreshLayout.setRefreshing(false);
        List<MyPostBean.ObjBean.TopicsBean.ListBeanXX> list = myPostBean.getObj().getTopics().getList();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
        } else {
            mAdapter.updateData(list);
        }
        mAdapter.notifyDataSetChanged();

        if (isFirst) {
            isFirst = false;
            if (!TextUtils.isEmpty(myPostBean.getObj().getTopics().getList().get(0).getIconUrl())) {
                if (myPostBean.getObj().getTopics().getList().get(0).getIconUrl().contains("http://")) {
                    Picasso.with(mActivity).load(myPostBean.getObj().getTopics().getList().get(0).getIconUrl()).into(mHeadIv);
                } else {
                    Picasso.with(mActivity).load(Constant.DOMAIN_UR + "/" + myPostBean.getObj().getTopics().getList().get(0).getIconUrl()).into(mHeadIv);
                }
            }
            mNameTv.setText(myPostBean.getObj().getTopics().getList().get(0).getNickname());
        }

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
        mRecyclerView.setLoadMoreEnabled(true);
        getData();
    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        mCurrentPage++;
        getData();
    }


    @Override
    public void success(BaseVO vo) {
        mActivity.showCustomToast(vo.getMsg());
        getData();
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.attention_tv:
                attention();
                break;
            default:
                break;

        }
    }

    @Override
    public void favorPost(String topicId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("topicId", topicId);
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.postCallBack(mActivity, Constant.FAVORIATE_TOPIC, map, BaseVO.class, this);
    }

    @Override
    public void likePost(String topicId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("topicId", topicId);
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.postCallBack(mActivity, Constant.LIKE_TOPIC, map, BaseVO.class, this);
    }

    @Override
    public void replayLikePost(String id, int status) {
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


    public void attention(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        map.put("followUserId", this.getIntent().getStringExtra("followUserId"));
        StartHttpUtils.postCallBack(mActivity, Constant.FOLLOW_USER, map, BaseVO.class, this);
    }


}
