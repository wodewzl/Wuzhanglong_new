package com.maitian.starfan.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.maitian.starfan.R;
import com.maitian.starfan.adapter.WelfareAdapter;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class HomeWelfareActivity extends BaseActivity  implements BGAOnRVItemClickListener, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {

    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private WelfareAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.home_welfare_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("咨询");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new WelfareAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_10, R.color.C3, true);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
    }

    @Override
    public void getData() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
//        map.put("curpage", mCurrentPage+"");
//        BSHttpUtils.post(mActivity, this, Constant.MY_MESSAGE_URL, map, MyMessageVO.class);

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
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
//        if (mAdapter.getData().size() == 0)
//            return;
//
//        MyMessageVO.DataBean.ListBean vo= (MyMessageVO.DataBean.ListBean) mAdapter.getItem(position);
//
//        Bundle bundle = new Bundle();
//        bundle.putString("url", vo.getDetail_url());
//        bundle.putString("title", "消息详情");
//        open(WebViewActivity.class, bundle, 0);
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
