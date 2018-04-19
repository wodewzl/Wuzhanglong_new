package com.beisheng.snatch.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.MyLuckyRecordActivity;
import com.beisheng.snatch.activity.ShowDetailActivity;
import com.beisheng.snatch.adapter.MyShowAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.DiscussVO;
import com.beisheng.snatch.model.ShowVO;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class MyShowRecordFragment extends BaseFragment implements OnLoadMoreListener, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener,BGAOnRVItemClickListener {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private MyShowAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String type = "1";
    private TextView mOkTv;
    private LinearLayout mBottomLayout;
    private  TextView mShowTv;

    public static MyShowRecordFragment newInstance() {
        MyShowRecordFragment fragment = new MyShowRecordFragment();
        return fragment;
    }

    @Override
    public void noNet() {

    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.my_show_record_fragment);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new MyShowAdapter(mRecyclerView);
        mAdapter.setType(type);
        RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, true);
        mBottomLayout = getViewById(R.id.bottom_layout);
        mShowTv=getViewById(R.id.show_tv);

    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mShowTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        map.put("curpage", mCurrentPage + "");
        map.put("type", this.getType());
        BSHttpUtils.get(mActivity, this, Constant.MY_ORDER_SHOW, map, ShowVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        ShowVO bean = (ShowVO) vo;
        if (BaseCommonUtils.parseInt(bean.getData().getCount()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(bean.getData().getCount())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        List<ShowVO.DataBean.ListBean> list = bean.getData().getList();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
            mCurrentPage++;
        } else {
            mCurrentPage++;
            mAdapter.updateData(list);
        }
        mAdapter.notifyDataSetChanged();
        mAutoSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        getData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_tv:
                mActivity.openActivity(MyLuckyRecordActivity.class);
                break;

            default:
                break;
        }

    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        DiscussVO.DataBean.ListBean vo = (DiscussVO.DataBean.ListBean) mAdapter.getItem(position);
        Bundle bundle = new Bundle();
        bundle.putString("id", vo.getId());
        mActivity.open(ShowDetailActivity.class, bundle, 0);
    }

}
