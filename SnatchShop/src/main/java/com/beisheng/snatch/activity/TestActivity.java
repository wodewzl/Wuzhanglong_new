package com.beisheng.snatch.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.fragment.TabOneChildFragment;
import com.beisheng.snatch.model.HomeVO;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.squareup.picasso.Picasso;
import com.vondear.rxtools.view.RxTextviewVertical;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.WidthHigthUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

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
import java.util.HashMap;

public class TestActivity extends BaseActivity {
    private String[] mTitleDataList = {"人气", "最新", "进度", "总需人次"};
    private ScrollableLayout mScrollableLayout;

    private RxTextviewVertical mRxText;
    private ViewPager mViewPager;
    private ArrayList<TabOneChildFragment> mFragmentList;
    private Banner mBanner;
    private ImageView mOneImg;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.tab_one_fragment);
    }

    @Override
    public void initView() {
        mActivity.mBaseHeadLayout.setVisibility(View.GONE);
        mBanner = getViewById(R.id.banner);
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
//        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        mScrollableLayout = getViewById(R.id.scrollable_layout);

        mOneImg = getViewById(R.id.one_img);
        mRxText = (RxTextviewVertical) getViewById(R.id.rx_text);
        mViewPager = getViewById(R.id.view_pager);

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
            fragment.setType((i + 1) + "");
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
        HashMap<String, Object> map = new HashMap<>();
        BSHttpUtils.get(mActivity, this, Constant.HOME_TITLE_URL, map, HomeVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        HomeVO homeVO = (HomeVO) vo;
        mBanner.setImages(homeVO.getData().getMulti_adv());
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                HomeVO.DataBean.MultiAdvBean bannerVO = (HomeVO.DataBean.MultiAdvBean) o;
                Picasso.with(context).load(bannerVO.getAdv_image()).into(imageView);
            }
        });
        mBanner.setOnBannerListener(new OnBannerListener() {

            @Override
            public void OnBannerClick(int position) {

            }
        });
        mBanner.start();
        Picasso.with(mActivity).load(homeVO.getData().getSingle_adv().getAdv_image()).into(mOneImg);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < homeVO.getData().getRecord_list().size(); i++) {
            list.add(homeVO.getData().getRecord_list().get(i).getPrise_desc());
        }
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

        initMagicIndicator();
        mScrollableLayout.getHelper().setCurrentScrollableContainer(mFragmentList.get(0));
//        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
//            @Override
//            public void onPageSelected(int position) {
//                mScrollableLayout.getHelper().setCurrentScrollableContainer(mFragmentList.get(position));
//            }
//        });
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }




}
