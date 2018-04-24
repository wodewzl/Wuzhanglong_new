package com.beisheng.snatch.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.DailyTaskActivity;
import com.beisheng.snatch.activity.KeywordActivity;
import com.beisheng.snatch.activity.SearchShopActivity;
import com.beisheng.snatch.activity.ShopCategoryActivity;
import com.beisheng.snatch.activity.ShopChoseActivity;
import com.beisheng.snatch.activity.SignActivity;
import com.beisheng.snatch.activity.WebViewActivity;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.HomeVO;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.squareup.picasso.Picasso;
import com.vondear.rxtools.view.RxTextviewVertical;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
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

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;

public class TabOneFragment extends BaseFragment implements View.OnClickListener {
    private String[] mTitleDataList = {"人气", "最新", "进度", "总需人次"};
    private ScrollableLayout mScrollableLayout;

    private RxTextviewVertical mRxText;
    private ViewPager mViewPager;
    private ArrayList<TabOneChildFragment> mFragmentList;
    private Banner mBanner;
    private ImageView mOneImg, mOrderImg, mSearchImg;
    private String mStatus = "4";//4为升序5为降序
    private TextView mMenu01Tv, mMenu02Tv, mMenu03Tv, mMenu04Tv;
    private ImageView mMenu01Img,mMenu02Img,mMenu03Img,mMenu04Img;
    private ImageView mSginImg;
    private LinearLayout mHeadLayout;
    private HomeVO mHomeVO;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_one_fragment);
    }

    @Override
    public void initView(View view) {
        mActivity.mBaseHeadLayout.setVisibility(View.GONE);
        mBanner = getViewById(R.id.banner);
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
//        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        mScrollableLayout = getViewById(R.id.scrollable_layout);
        mOneImg = getViewById(R.id.one_img);
        mRxText = (RxTextviewVertical) getViewById(R.id.rx_text);
        mViewPager = getViewById(R.id.view_pager);
        mOrderImg = getViewById(R.id.order_img);
        mSearchImg = getViewById(R.id.search_img);
        mMenu01Tv = getViewById(R.id.menu_01_tv);
        mMenu02Tv = getViewById(R.id.menu_02_tv);
        mMenu03Tv = getViewById(R.id.menu_03_tv);
        mMenu04Tv = getViewById(R.id.menu_04_tv);
        mMenu01Img=getViewById(R.id.menu_01_img);
        mMenu02Img=getViewById(R.id.menu_02_img);
        mMenu03Img=getViewById(R.id.menu_03_img);
        mMenu04Img=getViewById(R.id.menu_04_img);
        mSginImg = getViewById(R.id.sgin_img);
        mHeadLayout=getViewById(R.id.head_layouat);
        initMagicIndicator();
    }

    @Override
    public void bindViewsListener() {
        mOrderImg.setOnClickListener(this);
        mSearchImg.setOnClickListener(this);
        mMenu01Img.setOnClickListener(this);
        mMenu02Img.setOnClickListener(this);
        mMenu03Img.setOnClickListener(this);
        mMenu04Img.setOnClickListener(this);

        mSginImg.setOnClickListener(this);
        mScrollableLayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                mHeadLayout.setTranslationY(currentY / 2);

            }
        });
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
                simplePagerTitleView.setWidth((WidthHigthUtil.getScreenWidth(mActivity) - 100) / 4);
                simplePagerTitleView.setTextSize(14);
                simplePagerTitleView.setNormalColor(ContextCompat.getColor(mActivity, R.color.C5));

                simplePagerTitleView.setSelectedColor(ContextCompat.getColor(mActivity, R.color.colorAccent));
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
                indicator.setColors(ContextCompat.getColor(mActivity, R.color.colorAccent));
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
            TabOneChildFragment fragment = TabOneChildFragment.newInstance();
            fragment.setType((i + 1) + "");
            mFragmentList.add(fragment);
        }

        mScrollableLayout.getHelper().setCurrentScrollableContainer(mFragmentList.get(0));
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

        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mScrollableLayout.getHelper().setCurrentScrollableContainer(mFragmentList.get(position));
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
        final HomeVO homeVO = (HomeVO) vo;
        mHomeVO= (HomeVO) vo;
        mBanner.setImages(homeVO.getData().getMulti_adv());
        Banner banner = mBanner.setImageLoader(new ImageLoader() {
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
                Bundle bundle= new Bundle();
                if("1".equals(homeVO.getData().getMulti_adv().get(position).getJump_type())){
                    bundle.putString("keyword",homeVO.getData().getMulti_adv().get(position).getAdv_url());
                    mActivity.open(SearchShopActivity.class,bundle,0);
                }else {
                    bundle.putString("url",homeVO.getData().getMulti_adv().get(position).getAdv_url());
                    mActivity.open(WebViewActivity.class,bundle,0);
                }

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


        Picasso.with(mActivity).load(homeVO.getData().getNav_list().get(0).getNav_icon()).into(mMenu01Img);
        Picasso.with(mActivity).load(homeVO.getData().getNav_list().get(1).getNav_icon()).into(mMenu02Img);
        Picasso.with(mActivity).load(homeVO.getData().getNav_list().get(2).getNav_icon()).into(mMenu03Img);
        Picasso.with(mActivity).load(homeVO.getData().getNav_list().get(3).getNav_icon()).into(mMenu04Img);
        mMenu01Tv.setText(homeVO.getData().getNav_list().get(0).getNav_title());
        mMenu02Tv.setText(homeVO.getData().getNav_list().get(1).getNav_title());
        mMenu03Tv.setText(homeVO.getData().getNav_list().get(2).getNav_title());
        mMenu04Tv.setText(homeVO.getData().getNav_list().get(3).getNav_title());

        ACache.get(mActivity).put("share_title",homeVO.getData().getShare_params().getTitle());
        ACache.get(mActivity).put("share_desc",homeVO.getData().getShare_params().getDescX());
        ACache.get(mActivity).put("share_img",homeVO.getData().getShare_params().getImage());
        ACache.get(mActivity).put("share_url",homeVO.getData().getShare_params().getUrl());
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
            case R.id.order_img:
                if ("5".equals(mStatus)) {
                    EventBus.getDefault().post(new EBMessageVO("order_high"));
                    mOrderImg.setImageResource(R.drawable.order_high);
                    mStatus = "4";
                } else {
                    EventBus.getDefault().post(new EBMessageVO("order_low"));
                    mOrderImg.setImageResource(R.drawable.order_low);
                    mStatus = "5";
                }
                break;

            case R.id.search_img:
                mActivity.openActivity(KeywordActivity.class);
                break;
            case R.id.menu_01_img:
                mActivity.openActivity(ShopCategoryActivity.class);
                break;
            case R.id.menu_02_img:
                mActivity.openActivity(ShopChoseActivity.class);
                break;
            case R.id.menu_03_img:
                mActivity.openActivity(DailyTaskActivity.class);
                break;
            case R.id.menu_04_img:
                bundle.putString("title",mHomeVO.getData().getNav_list().get(3).getNav_title());
                bundle.putString("url",mHomeVO.getData().getNav_list().get(3).getNav_url());
                mActivity.open(WebViewActivity.class,bundle,0);
                break;
            case R.id.sgin_img:
                mActivity.openActivity(SignActivity.class);
                break;
            default:
                break;
        }
    }
}
