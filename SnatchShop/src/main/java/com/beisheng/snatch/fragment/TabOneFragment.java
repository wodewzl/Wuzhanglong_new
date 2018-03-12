package com.beisheng.snatch.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.beisheng.snatch.R;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.vondear.rxtools.view.RxTextviewVertical;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.WidthHigthUtil;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import java.util.ArrayList;

public class TabOneFragment extends BaseFragment implements View.OnClickListener, ScrollableHelper.ScrollableContainer {
    private String[] mTitleDataList = {"人气", "最新", "进度", "总需人次"};
    private ScrollableLayout mScrollableLayout;

    private RxTextviewVertical mRxText;
    private ViewPager mViewPager;
    private ArrayList<TabOneChildFragment> mFragmentList;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_one_fragment);
    }

    @Override
    public void initView(View view) {
        mActivity.mBaseHeadLayout.setVisibility(View.GONE);

        mScrollableLayout = getViewById(R.id.scrollable_layout);
        mScrollableLayout.getHelper().setCurrentScrollableContainer(this);

        mRxText = (RxTextviewVertical) getViewById(R.id.rx_text);
        mViewPager=getViewById(R.id.view_pager);
        initMagicIndicator();
    }

    @Override
    public void bindViewsListener() {

    }

    private void initMagicIndicator() {
        MagicIndicator magicIndicator = (MagicIndicator) getViewById(R.id.magic_indicator);
        magicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setAdjustMode(false);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleDataList.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mTitleDataList[index]);
                simplePagerTitleView.setWidth(WidthHigthUtil.getScreenWidth(mActivity) / 4);
                simplePagerTitleView.setTextSize(14);
                simplePagerTitleView.setNormalColor(Color.parseColor("#616161"));

                simplePagerTitleView.setSelectedColor(Color.parseColor("#f57c00"));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(1.6f));
//                indicator.setYOffset(UIUtil.dip2px(context, 39));
                indicator.setLineHeight(UIUtil.dip2px(context, 2));
                indicator.setColors(Color.parseColor("#f57c00"));
//                LinePagerIndicator indicator = new LinePagerIndicator(context);
//                indicator.setColors(Color.parseColor("#40c4ff"));
                return indicator;
            }

            @Override
            public float getTitleWeight(Context context, int index) {
                if (index == 0) {
                    return 1.0f;
                } else if (index == 1) {
                    return 1.0f;
                } else {
                    return 1.0f;
                }
            }
        });

        initViewPagerData();
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPager);

    }

    public void initViewPagerData() {
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < mTitleDataList.length; i++) {
            TabOneChildFragment fragment = (TabOneChildFragment) TabOneChildFragment.newInstance();
            mFragmentList.add(fragment);
        }
        mViewPager.setOffscreenPageLimit(mTitleDataList.length);
        mViewPager.setAdapter(new FragmentPagerAdapter(mActivity.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            //            private String[] titles = {"人气", "进度", "最新揭晓"};
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitleDataList[position];
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });

    }

    @Override
    public void getData() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("wuzhanglong","牛逼");
//        map.put("jinrenzheng","傻逼");
//        BSHttpUtils.post(mActivity, this, Constant.HOME_URL, map, HomeVO.class);
       showView();
    }

    @Override
    public void hasData(BaseVO vo) {

        ArrayList<String> list = new ArrayList<>();
        list.add("走过路过不要错过，美女多多");
        list.add("走过路过不要错过，美女多多");
        mRxText.setTextList(list);
        mRxText.setText(14, 5, 0xff766156);//设置属性
        mRxText.setTextStillTime(3000);//设置停留时长间隔
        mRxText.setAnimTime(300);//设置进入和退出的时间间隔
        mRxText.setOnItemClickListener(new RxTextviewVertical.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Bundle bundle = new Bundle();

            }
        });
        mRxText.startAutoScroll();
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }


    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        switch (v.getId()) {

            default:
                break;
        }
    }



    public void showActivity(String type, String id, String url) {
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
    }

    @Override
    public View getScrollableView() {
        return mViewPager;
    }


}
