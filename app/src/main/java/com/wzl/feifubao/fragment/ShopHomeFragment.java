package com.wzl.feifubao.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.ShopDetailActivity;
import com.wzl.feifubao.adapter.ShopHomeAdapter;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.ShopHomeVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class ShopHomeFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, BGAOnRVItemClickListener {
    private LuRecyclerView mRecyclerView;
    private ShopHomeAdapter mAdapter;
    private LuRecyclerViewAdapter mLuAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new ShopHomeFragment();
        return fragment;
    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.shop_home_fragment);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(mActivity, 6);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ShopHomeAdapter(mRecyclerView);
        mLuAdapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(mLuAdapter);
        mRecyclerView.setLoadMoreEnabled(false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                ShopHomeVO vo = (ShopHomeVO) mAdapter.getData().get(position);
                if ("9".equals(vo.getType())) {
                    return 3;
                } else {
                    return 6;
                }

            }
        });

    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnRVItemClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        HttpGetDataUtil.get(mActivity, this, Constant.SHOP_HOME_ULR, map, ShopHomeVO.class);

    }

    @Override
    public void hasData(BaseVO vo) {
        ShopHomeVO shopHomeVO = (ShopHomeVO) vo;
        List<ShopHomeVO> list = new ArrayList<>();
        if (shopHomeVO.getData().getAdvs() != null && shopHomeVO.getData().getAdvs().size() > 0) {
            ShopHomeVO advs = new ShopHomeVO();
            advs.setData(shopHomeVO.getData());
            advs.setType("1");
            list.add(advs);
        }
        if (shopHomeVO.getData().getArticles() != null && shopHomeVO.getData().getArticles().size() > 0) {
            ShopHomeVO articles = new ShopHomeVO();
            articles.setData(shopHomeVO.getData());
            articles.setType("2");
            list.add(articles);
        }

        if (shopHomeVO.getData().getTehui() != null) {
            ShopHomeVO tehuiTitle = new ShopHomeVO();
            tehuiTitle.setType("3");
            list.add(tehuiTitle);
//            List<ShopHomeVO> tehui = shopHomeVO.getData().getTehui();
//            for (int i = 0; i < tehui.size(); i++) {
//                ShopHomeVO tehuiVO = tehui.get(i);
//                tehuiVO.setType("4");
//                list.add(tehuiVO);
//            }

            ShopHomeVO tehui = new ShopHomeVO();
            List<ShopHomeVO> tehuiList = shopHomeVO.getData().getTehui();
            tehui.setTehui(tehuiList);
            tehui.setType("4");
            list.add(tehui);
        }

        if (shopHomeVO.getData().getXianshi() != null) {
            ShopHomeVO xianshiTitle = new ShopHomeVO();
            xianshiTitle.setType("5");
            list.add(xianshiTitle);
//            List<ShopHomeVO> xianshi = shopHomeVO.getData().getXianshi();
//            for (int i = 0; i < xianshi.size(); i++) {
//                ShopHomeVO xianshiVO = xianshi.get(i);
//                xianshiVO.setType("6");
//                list.add(xianshiVO);
//            }

            ShopHomeVO xianshi = new ShopHomeVO();
            List<ShopHomeVO> xianshiList = shopHomeVO.getData().getXianshi();
            xianshi.setXianshi(xianshiList);
            xianshi.setType("6");
            list.add(xianshi);
        }

        if (shopHomeVO.getData().getTuijianadvs() != null) {
            List<ShopHomeVO> tuijianadvs = shopHomeVO.getData().getTuijianadvs();
            for (int i = 0; i < tuijianadvs.size(); i++) {
                ShopHomeVO tuijianadvsVO = tuijianadvs.get(i);
                tuijianadvsVO.setType("7");
                list.add(tuijianadvsVO);
            }
        }
        if (shopHomeVO.getData().getTuijian() != null) {
            ShopHomeVO tuijianTitle = new ShopHomeVO();
            tuijianTitle.setType("8");
            list.add(tuijianTitle);

            List<ShopHomeVO> tuijian = shopHomeVO.getData().getTuijian();
            for (int i = 0; i < tuijian.size(); i++) {
                ShopHomeVO tuijianVO = tuijian.get(i);
                tuijianVO.setType("9");
                list.add(tuijianVO);
            }
        }
        mAutoSwipeRefreshLayout.setRefreshing(false);
        mAdapter.updateData(list);
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onRefresh() {
        getData();
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        ShopHomeVO bean = mAdapter.getItem(position);
        if ("9".equals(bean.getType())) {
            Bundle bundle = new Bundle();
            bundle.putString("id", bean.getGoods_id());
            mActivity.open(ShopDetailActivity.class, bundle, 0);
        } else if ("6".equals(bean.getType())) {
            Bundle bundle = new Bundle();
            bundle.putString("id", bean.getGoods_id());
            mActivity.open(ShopDetailActivity.class, bundle, 0);
        } else if ("4".equals(bean.getType())) {
            Bundle bundle = new Bundle();
            bundle.putString("id", bean.getGoods_id());
            mActivity.open(ShopDetailActivity.class, bundle, 0);
        }

    }

}
