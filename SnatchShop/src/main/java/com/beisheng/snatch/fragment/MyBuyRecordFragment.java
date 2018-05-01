package com.beisheng.snatch.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.ShopCategoryActivity;
import com.beisheng.snatch.activity.ShopDetailActivity;
import com.beisheng.snatch.adapter.LoveAdapter;
import com.beisheng.snatch.adapter.MyBuyRecordAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.MyBuyRecordVO;
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

import static com.beisheng.snatch.R.color.C3;

public class MyBuyRecordFragment extends BaseFragment implements OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, BGAOnRVItemClickListener {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView, mRecyclerViewLove;
    private MyBuyRecordAdapter mAdapter;
    private LoveAdapter mAdapterLove;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String type = "1";
    private boolean mFlag = true;


    public static MyBuyRecordFragment newInstance() {
        MyBuyRecordFragment fragment = new MyBuyRecordFragment();
        return fragment;
    }

    @Override
    public void noNet() {

    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.my_buy_record_fragment);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new MyBuyRecordAdapter(mRecyclerView);
        mAdapter.setType(type);
        RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, mRecyclerView, mAdapter, R.dimen.dp_1, C3, true);

        mRecyclerViewLove = getViewById(R.id.recycler_view_love);
        mAdapterLove = new LoveAdapter(mRecyclerViewLove);
        RecyclerViewUtil.initRecyclerViewLinearLayoutHorizontal(mActivity, mRecyclerViewLove, mAdapterLove, R.dimen.dp_1, C3);

    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mAdapterLove.setOnRVItemClickListener(this);

    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        map.put("curpage", mCurrentPage + "");
        map.put("type", this.getType());
        BSHttpUtils.post(mActivity, this, Constant.MY_BUY_RECORD_URL, map, MyBuyRecordVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        MyBuyRecordVO bean = (MyBuyRecordVO) vo;
        if (BaseCommonUtils.parseInt(bean.getData().getCount()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(bean.getData().getCount())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        List<MyBuyRecordVO.DataBean.ListBean> list = bean.getData().getList();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
        } else {
            mAdapter.updateData(list);
        }
        mAdapter.notifyDataSetChanged();
        mAutoSwipeRefreshLayout.setRefreshing(false);
        if (mFlag) {
            mFlag = false;
            List<MyBuyRecordVO.DataBean.GuessLikeBean> loveList = bean.getData().getGuess_like();
            mAdapterLove.updateData(loveList);
        }
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        mCurrentPage++;
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
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (parent == mRecyclerView) {
            if (mAdapter.getItemCount() == 0)
                return;
            MyBuyRecordVO.DataBean.ListBean vo = (MyBuyRecordVO.DataBean.ListBean) mAdapter.getItem(position);
            Bundle bundle = new Bundle();
            bundle.putString("id", vo.getPanic_id());
            mActivity.open(ShopDetailActivity.class, bundle, 0);
        } else {
            if (mAdapterLove.getItemCount() == 0)
                return;
            MyBuyRecordVO.DataBean.GuessLikeBean vo = (MyBuyRecordVO.DataBean.GuessLikeBean) mAdapterLove.getItem(position);
            Bundle bundle = new Bundle();
            bundle.putString("category_id", vo.getCategory_id());
            mActivity.open(ShopCategoryActivity.class, bundle, 0);
        }


    }
}
