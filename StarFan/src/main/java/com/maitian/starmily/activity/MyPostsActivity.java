package com.maitian.starmily.activity;

import android.view.View;

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
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

public class MyPostsActivity extends BaseActivity {
    private LuRecyclerView mRecyclerView;
    private MyPostAdapter mAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private int mCurrentPage = 1;
    private boolean isLoadMore = false;

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
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_10, R.color.C3, true);
    }

    @Override
    public void bindViewsListener() {

    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId()+"");
        map.put("followUserId", this.getIntent().getStringExtra("followUserId"));
        map.put("pageNum", mCurrentPage + "");
        map.put("pageSize", "10");
        StartHttpUtils.get(mActivity, this, Constant.USER_TOPIC_LIST, map, MyPostBean.class);
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

    }

    @Override
    public void noNet() {

    }
}
