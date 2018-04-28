package com.beisheng.snatch.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.ShopCategoryLeftAdapter;
import com.beisheng.snatch.adapter.ShopCategoryRightAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.ShopCategoryLeftVO;
import com.beisheng.snatch.model.ShopCategoryRightVO;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGADivider;
import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;


public class ShopCategoryActivity extends BaseActivity implements ShopCategoryLeftAdapter.OnLeftSelectedListener, BGAOnRVItemClickListener, OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener,
        View.OnClickListener {
    private String mKeyword = "";
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private RecyclerView mLeftRecyclerView;//左侧菜单栏
    private LuRecyclerView mRightRecyclerView;//右侧菜单栏
    private ShopCategoryLeftAdapter mLeftAdapter;
    private ShopCategoryRightAdapter mRightAdapter;
    private ShopCategoryLeftVO mLeftVO;
    private ShopCategoryRightVO mRightVO;
    private LinearLayoutManager mLeftLayoutManger;
    private String mCategoryId = "0";
    private String mOrderType = "1";
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private boolean mFistFlag = true;
    private TextView mTitle01Tv, mTitle02Tv, mTitle03Tv, mTitle04Tv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.shop_category_activity);
    }

    @Override
    public void initView() {
        mBaseHeadLayout.setBackgroundResource(R.color.colorAccent);
        mBaseTitleTv.setText("商品分类");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);

        mTitle01Tv = getViewById(R.id.title_01_tv);
        mTitle02Tv = getViewById(R.id.title_02_tv);
        mTitle03Tv = getViewById(R.id.title_03_tv);
        mTitle04Tv = getViewById(R.id.title_04_tv);

        mLeftRecyclerView = getViewById(R.id.left_recyclerview);
        mLeftLayoutManger = new LinearLayoutManager(mActivity);
        mLeftRecyclerView.setLayoutManager(mLeftLayoutManger);
//        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_1, R.color.C3);
//        mLeftRecyclerView.addItemDecoration(divider);
        mLeftAdapter = new ShopCategoryLeftAdapter(mLeftRecyclerView);
        mLeftRecyclerView.setAdapter(mLeftAdapter);

        //右边recyclerview
        mRightRecyclerView = getViewById(R.id.right_recyclerview);
        BGADivider divideRight = DividerUtil.bagDivider(15, 0);
        mRightRecyclerView.addItemDecoration(divideRight);
        mRightAdapter = new ShopCategoryRightAdapter(mRightRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mRightAdapter);
        mRightRecyclerView.setAdapter(adapter);
        mRightRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mRightRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRightRecyclerView.setLoadMoreEnabled(true);

        mBaseOkTv.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.search_img, 0, 0);

    }

    @Override
    public void bindViewsListener() {
        mLeftAdapter.setListener(this);
        mRightAdapter.setOnRVItemClickListener(this);
        mRightRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mTitle01Tv.setOnClickListener(this);
        mTitle02Tv.setOnClickListener(this);
        mTitle03Tv.setOnClickListener(this);
        mTitle04Tv.setOnClickListener(this);
        mBaseOkTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        if (mFistFlag) {
            BSHttpUtils.get(mActivity, this, Constant.SHOP_CATEGORY_URL, map, ShopCategoryLeftVO.class);
            mFistFlag = false;
        }
        map.put("category_id", mCategoryId);
        map.put("order_type", mOrderType);
        BSHttpUtils.get(mActivity, this, Constant.HOME_LIST_URL, map, ShopCategoryRightVO.class);

    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof ShopCategoryLeftVO) {
            mLeftVO = (ShopCategoryLeftVO) vo;
            List<ShopCategoryLeftVO.DataBean.CategoryListBean> list = new ArrayList();
            ShopCategoryLeftVO.DataBean.CategoryListBean allVO = new ShopCategoryLeftVO.DataBean.CategoryListBean();
            allVO.setCategory_name("全部分类");
            allVO.setCategory_id("0");
            list.add(allVO);
            list.addAll(mLeftVO.getData().getCategory_list());
            mLeftAdapter.updateData(list);
        } else {
            mRightVO = (ShopCategoryRightVO) vo;
            if (BaseCommonUtils.parseInt(mRightVO.getData().getCount()) == 1) {
                mRightRecyclerView.setLoadMoreEnabled(false);
            }
            if (mCurrentPage == BaseCommonUtils.parseInt(mRightVO.getData().getCount())) {
                mRightRecyclerView.setNoMore(true);
            } else {
                mRightRecyclerView.setNoMore(false);
            }
            List<ShopCategoryRightVO.DataBean.ListBean> list = mRightVO.getData().getList();
            if (isLoadMore) {
                mRightAdapter.updateDataLast(list);
                isLoadMore = false;
                mCurrentPage++;
            } else {
                mCurrentPage++;
                mRightAdapter.updateData(list);
            }
            mAutoSwipeRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void noData(BaseVO vo) {
    }

    @Override
    public void noNet() {

    }

    @Override
    public void onLeftItemSelected(ShopCategoryLeftVO.DataBean.CategoryListBean leftVO) {
        mCategoryId = leftVO.getCategory_id();
        mAutoSwipeRefreshLayout.autoRefresh();
        mOrderType = "1";
    }

    @Override
    public void moveToTop(View view, int position) {
        int firstPosition = mLeftLayoutManger.findFirstVisibleItemPosition();
        int lastPosition = mLeftLayoutManger.findLastVisibleItemPosition();
        if (position <= lastPosition) {
            int top = mLeftRecyclerView.getChildAt(position - firstPosition).getTop();
            mLeftRecyclerView.smoothScrollBy(0, top);
        }
    }

    @Override
    public void onRVItemClick(ViewGroup viewGroup, View view, int position) {
        if (mRightAdapter.getData().size() == 0)
            return;

        ShopCategoryRightVO.DataBean.ListBean bean= (ShopCategoryRightVO.DataBean.ListBean) mRightAdapter.getItem(position);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_01_tv:
            case R.id.title_02_tv:
            case R.id.title_03_tv:
            case R.id.title_04_tv:
                setTitleStyle(v.getId());
                break;
            case R.id.base_ok_tv:
                openActivity(SearchShopActivity.class);
                break;
            default:
                break;
        }
    }

    public void setTitleStyle(int id) {
        if (id == R.id.title_01_tv) {
            mTitle01Tv.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            mOrderType = "1";
        } else {
            mTitle01Tv.setTextColor(ContextCompat.getColor(this, R.color.C5));
        }
        if (id == R.id.title_02_tv) {
            mTitle02Tv.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            mOrderType = "2";
        } else {
            mTitle02Tv.setTextColor(ContextCompat.getColor(this, R.color.C5));
        }
        if (id == R.id.title_03_tv) {
            mTitle03Tv.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            mOrderType = "3";
        } else {
            mTitle03Tv.setTextColor(ContextCompat.getColor(this, R.color.C5));
        }
        if (id == R.id.title_04_tv) {
            mTitle04Tv.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            mOrderType = "3";
        } else {
            mTitle04Tv.setTextColor(ContextCompat.getColor(this, R.color.C5));
        }
        mAutoSwipeRefreshLayout.autoRefresh();
    }
}
