package com.maitian.starmily.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.maitian.starmily.R;
import com.maitian.starmily.activity.FindTopicActivity;
import com.maitian.starmily.activity.HomeHitListActivity;
import com.maitian.starmily.activity.HomeNewsActivity;
import com.maitian.starmily.activity.HomePromotionsActivity;
import com.maitian.starmily.activity.HomeWelfareActivity;
import com.maitian.starmily.adapter.HomeAdapter;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.FindTopicVO;
import com.maitian.starmily.model.HomeBean;
import com.maitian.starmily.model.RiceCircleVO;
import com.maitian.starmily.model.TurnsPicturesBean;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class TabOneFragment extends BaseFragment implements View.OnClickListener, PostCallback, Serializable , BGAOnRVItemClickListener, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener {
    private LuRecyclerView mRecyclerView;
    private HomeAdapter mAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private int mCurrentPage = 1;
    private boolean isLoadMore = false;
    private Banner mBanner;


    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_one_frament);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_10, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new HomeAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        adapter.addHeaderView(findHeadView());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(false);
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);

    }


    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        StartHttpUtils.get(mActivity, this, Constant.TURNS_PICTURES, map, TurnsPicturesBean.class);

        HashMap<String, Object> homeMap = new HashMap<>();
        homeMap.put("pageNum", mCurrentPage + "");
        homeMap.put("pageSize", "10");
        StartHttpUtils.get(mActivity, this, Constant.HOME_PAGE, homeMap, HomeBean.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof TurnsPicturesBean) {
            TurnsPicturesBean bean = (TurnsPicturesBean) vo;
            mBanner.setImages(bean.getObj());
            mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object o, ImageView imageView) {
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    TurnsPicturesBean.ObjBean bannerBean = (TurnsPicturesBean.ObjBean) o;
                    if (!TextUtils.isEmpty(bannerBean.getQiNiuAddress())){
                        if (bannerBean.getQiNiuAddress().contains("http://")) {
                            Picasso.with(mActivity).load(bannerBean.getQiNiuAddress()).into(imageView);
                        }else {
                            Picasso.with(mActivity).load(Constant.DOMAIN_UR + "/" + bannerBean.getQiNiuAddress()).into(imageView);
                        }
                    }
                }
            });
            mBanner.setOnBannerListener(new OnBannerListener() {

                @Override
                public void OnBannerClick(int position) {
                    Bundle bundle = new Bundle();
                }
            });
            mBanner.start();
        } else if (vo instanceof HomeBean) {
            HomeBean homeBean = (HomeBean) vo;
            if (homeBean.getObj().isHasNextPage()) {
                mRecyclerView.setNoMore(false);
            } else {
                mRecyclerView.setNoMore(true);
            }
            mAutoSwipeRefreshLayout.setRefreshing(false);
            List<HomeBean.ObjBean.ListBean> list = homeBean.getObj().getList();
            if (isLoadMore) {
                mAdapter.updateDataLast(list);
                isLoadMore = false;
            } else {
                mAdapter.updateData(list);
            }
            mAdapter.notifyDataSetChanged();
        }
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
        switch (v.getId()) {
            case R.id.news_tv:
                mActivity.openActivity(HomeNewsActivity.class);
                break;
            case R.id.topic_tv:
                mActivity.openActivity(FindTopicActivity.class);
                break;
            case R.id.promotions_tv:
                mActivity.openActivity(HomePromotionsActivity.class);
                break;
            case R.id.welfare_tv:
                mActivity.openActivity(HomeWelfareActivity.class);
                break;
            case R.id.rank_layout:
                mActivity.openActivity(HomeHitListActivity.class);
                break;
            default:
                break;

        }
    }


    @Override
    public void success(BaseVO vo) {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public View findHeadView() {
        View view = View.inflate(mActivity, R.layout.home_head, null);
        view.findViewById(R.id.rank_layout).setOnClickListener(this);
        view.findViewById(R.id.topic_tv).setOnClickListener(this);
        view.findViewById(R.id.news_tv).setOnClickListener(this);
        view.findViewById(R.id.promotions_tv).setOnClickListener(this);
        view.findViewById(R.id.welfare_tv).setOnClickListener(this);
        mBanner = view.findViewById(R.id.banner);
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        return view;
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
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {

    }
}
