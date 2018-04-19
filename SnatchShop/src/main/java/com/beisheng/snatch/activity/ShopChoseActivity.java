package com.beisheng.snatch.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.ShopChoseAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.ShopVO;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAGridDivider;
import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class ShopChoseActivity extends BaseActivity  implements SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener, BGAOnRVItemClickListener {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private ShopChoseAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.shop_chose_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("商品优选");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        BGAGridDivider divider = DividerUtil.bgaGridDivider(R.dimen.dp_2);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new ShopChoseAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
        GridLayoutManager layoutManager = new GridLayoutManager(mActivity, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mAdapter.getData().size() == 0 || position == mAdapter.getData().size()) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mAdapter.setOnRVItemClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("is_recommend", "1");
        BSHttpUtils.get(mActivity, this, Constant.HOME_LIST_URL, map, ShopVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        ShopVO shopVO = (ShopVO) vo;
        if (BaseCommonUtils.parseInt(shopVO.getData().getCount()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(shopVO.getData().getCount())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        List<ShopVO.DataBean.ListBean> list = shopVO.getData().getList();
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
    public void noNet() {

    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        ShopVO.DataBean.ListBean bean= (ShopVO.DataBean.ListBean) mAdapter.getItem(position);
        Bundle bundle=new Bundle();
        bundle.putString("id",bean.getId());
        open(ShopDetailActivity.class,bundle,0);
    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        getData();
    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }

}
