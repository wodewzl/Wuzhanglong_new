package com.wzl.feifubao.fragment;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.LoginActivity;
import com.wzl.feifubao.activity.ShopCartActivity;
import com.wzl.feifubao.application.AppApplication;

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

public class TabTwoFragment extends BaseFragment implements View.OnClickListener{
    private String[] mTitleDataList = {"首页", "手机", "电脑", "家电", "美装", "家居", "数码"};
    private ViewPager mViewPager;
    private ArrayList<Fragment> mFragmentList;
    private TextView mCartTv;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_two_fragment);
    }

    @Override
    public void initView(View view) {
        mViewPager = getViewById(R.id.view_pager);
        mViewPager.setOffscreenPageLimit(mTitleDataList.length);
        initMagicIndicator();
        mCartTv=getViewById(R.id.cart_tv);
    }

    @Override
    public void bindViewsListener() {
        mCartTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        showView();
    }

    @Override
    public void hasData(BaseVO vo) {

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    private void initMagicIndicator() {
        MagicIndicator magicIndicator = getViewById(R.id.magic_indicator);
        magicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setAdjustMode(true);//是固定

        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleDataList.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
//                SimplePagerTitleView simplePagerTitleView = new ScaleTransitionPagerTitleView(context);// 文字变化样式
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mTitleDataList[index]);
                simplePagerTitleView.setTextSize(14);
                simplePagerTitleView.setNormalColor(Color.parseColor("#616161"));
                simplePagerTitleView.setSelectedColor(ContextCompat.getColor(mActivity,R.color.colorAccent));
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
                indicator.setColors(ContextCompat.getColor(mActivity,R.color.colorAccent));
//                LinePagerIndicator indicator = new LinePagerIndicator(context);
//                indicator.setColors(Color.parseColor("#40c4ff"));
                return indicator;
            }

//            @Override
//            public float getTitleWeight(Context context, int index) {
//                if (index == 0) {
//                    return 1.0f;
//                } else if (index == 1) {
//                    return 1.0f;
//                } else {
//                    return 1.0f;
//                }
//            }
        });

        initViewPagerData();
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPager);
    }


    public void initViewPagerData() {
        mFragmentList = new ArrayList<>();
        ShopHomeFragment homeFragment = (ShopHomeFragment) ShopHomeFragment.newInstance();
            mFragmentList.add(homeFragment);
        for (int i =3; i <9; i++) {
            ShopFragment fragment = (ShopFragment) ShopFragment.newInstance();
            fragment.setType(i);
            mFragmentList.add(fragment);

        }
        mViewPager.setOffscreenPageLimit(mTitleDataList.length);
        mViewPager.setAdapter(new FragmentPagerAdapter(mActivity.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cart_tv:
                if(AppApplication.getInstance().getUserInfoVO()==null){
                    mActivity.openActivity(LoginActivity.class);
                    return;
                }
                mActivity.openActivity(ShopCartActivity.class);
                break;
            default:
                break;
        }
    }
}
