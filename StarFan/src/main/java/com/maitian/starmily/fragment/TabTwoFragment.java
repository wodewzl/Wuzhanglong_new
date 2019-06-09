package com.maitian.starmily.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.RiceCircleAdapter;
import com.maitian.starmily.adapter.RiceCircleAdapter.ChildClikCallback;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.RiceCircleVO;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class TabTwoFragment extends BaseFragment implements View.OnClickListener, Serializable, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener, PostCallback, ChildClikCallback {
    private LuRecyclerView mRecyclerView;
    private RiceCircleAdapter mAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private boolean isLoadMore = true;
    private int mCurrentPage = 1;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_two_fragment);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new RiceCircleAdapter(mRecyclerView);

        RecyclerViewUtil.initRecyclerViewLinearLayout(this.getActivity(), mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, true);
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
//        mAdapter.setOnRVItemClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mAdapter.setChildClikCallback(this);
    }


    @Override
    public void getData() {
//        http://132.232.197.128:8080/topic/userTopicList?pageNum=1&pageSize=10&userId=4337
        HashMap<String, Object> map = new HashMap<>();
        map.put("idolId", "2");
        map.put("userId", "4338");
        map.put("pageNum", mCurrentPage + "");
        map.put("pageSize", "10");
        StartHttpUtils.get(mActivity, this, Constant.TOPIC_LIST, map, RiceCircleVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        RiceCircleVO riceCircleVO = (RiceCircleVO) vo;
        if (riceCircleVO.getObj().isHasNextPage()) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        mAutoSwipeRefreshLayout.setRefreshing(false);
        List<RiceCircleVO.ObjBean.ListBeanXX> list = riceCircleVO.getObj().getList();
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
        showView();
    }

    @Override
    public void noNet() {

    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

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
    public void success(BaseVO vo) {
        mActivity.showCustomToast(vo.getMsg());
    }

    @Override
    public void favorPost(String topicId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("topicId", topicId);
        map.put("userId", "4338");
        StartHttpUtils.postCallBack(mActivity, Constant.FAVORIATE_TOPIC, map, BaseVO.class, this);
    }

    @Override
    public void likePost(String topicId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("topicId", topicId);
        map.put("userId", "4338");
        StartHttpUtils.postCallBack(mActivity, Constant.LIKE_TOPIC, map, BaseVO.class, this);
    }

    @Override
    public void replayLikePost(String id, int status) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("commentId", id);
        map.put("userId", "4338");
        if (status == 1) {
            map.put("type", "0");
        } else {
            map.put("type", "1");
        }
        StartHttpUtils.postCallBack(mActivity, Constant.LIKE_COMMENT, map, BaseVO.class, this);
    }
}
