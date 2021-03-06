package com.maitian.starmily.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

import com.maitian.starmily.R;
import com.maitian.starmily.fragment.PaurseFragment;
import com.maitian.starmily.fragment.PaursePropFragment;
import com.wuzhanglong.library.activity.BaseActivity;
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

public class MyPurseActivity extends BaseActivity {

    private String[] mTitleDataList = {"我的钱包", "我的道具", "道具兑换"};
    private ViewPager mViewPager;
    private ArrayList<BaseFragment> mFragmentList;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_purse_activity);
    }

    @Override
    public void initView() {
        mViewPager = getViewById(R.id.view_pager);
        initMagicIndicator();
    }

    @Override
    public void bindViewsListener() {

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
        MagicIndicator magicIndicator = (MagicIndicator) getViewById(R.id.magic_indicator);
        magicIndicator.setBackgroundColor(ContextCompat.getColor(this, R.color.C1));
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
                simplePagerTitleView.setWidth(WidthHigthUtil.getScreenWidth(mActivity) / 3);
                simplePagerTitleView.setTextSize(14);
                simplePagerTitleView.setNormalColor(ContextCompat.getColor(MyPurseActivity.this, R.color.C5));

                simplePagerTitleView.setSelectedColor(ContextCompat.getColor(MyPurseActivity.this, R.color.colorAccent));
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
                indicator.setColors(ContextCompat.getColor(MyPurseActivity.this, R.color.colorAccent));

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
        PaurseFragment paurseOne = new PaurseFragment();
        mFragmentList.add(paurseOne);
        PaursePropFragment paurseTwo = new PaursePropFragment();
        mFragmentList.add(paurseTwo);
        PaursePropFragment paurseThree = new PaursePropFragment();
        mFragmentList.add(paurseThree);
        mViewPager.setOffscreenPageLimit(mTitleDataList.length);
        mViewPager.setAdapter(new FragmentPagerAdapter(mActivity.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

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
}
