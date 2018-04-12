package com.beisheng.snatch.activity;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.fragment.RecordAwardFragment;
import com.beisheng.snatch.fragment.RecordBuyFragment;
import com.beisheng.snatch.fragment.RecordShowFragment;
import com.beisheng.snatch.model.TAInfoVO;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
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
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonalCenterActivity extends BaseActivity {
    private String[] mTitleDataList = {"兑换记录", "获奖记录", "晒图记录"};
    private ViewPager mViewPager;
    private ArrayList<BaseFragment> mFragmentList;
    private ScrollableLayout mScrollableLayout;
    private TextView mNameTv,mUserId;
    private CircleImageView mHeadImg;
    private LinearLayout mHeadLayout;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.personal_center_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("TA的个人中心");
        mNameTv=getViewById(R.id.name_tv);
        mUserId=getViewById(R.id.user_id);
        mHeadImg=getViewById(R.id.head_img);
        mScrollableLayout = getViewById(R.id.scrollable_layout);
        mViewPager = getViewById(R.id.view_pager);
        mHeadLayout=getViewById(R.id.head_layout);
        initMagicIndicator();
    }

    private void initMagicIndicator() {
        MagicIndicator magicIndicator = (MagicIndicator) getViewById(R.id.magic_indicator);
        magicIndicator.setBackgroundColor(ContextCompat.getColor(this, R.color.C3));
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
                simplePagerTitleView.setNormalColor(ContextCompat.getColor(PersonalCenterActivity.this, R.color.C5));

                simplePagerTitleView.setSelectedColor(ContextCompat.getColor(PersonalCenterActivity.this, R.color.colorAccent));
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
                indicator.setColors(ContextCompat.getColor(PersonalCenterActivity.this, R.color.colorAccent));
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
        final RecordBuyFragment fragment1 = RecordBuyFragment.newInstance();
        mFragmentList.add(fragment1);
        final RecordAwardFragment fragment2 = RecordAwardFragment.newInstance();
        mFragmentList.add(fragment2);
        final RecordShowFragment fragment3 = RecordShowFragment.newInstance();
        mFragmentList.add(fragment3);
        mScrollableLayout.getHelper().setCurrentScrollableContainer(fragment1);
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
                switch (position) {
                    case 0:
                        mScrollableLayout.getHelper().setCurrentScrollableContainer(fragment1);
                        break;
                    case 1:
                        mScrollableLayout.getHelper().setCurrentScrollableContainer(fragment2);
                        break;
                    case 2:
                        mScrollableLayout.getHelper().setCurrentScrollableContainer(fragment3);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void bindViewsListener() {
        mScrollableLayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                mHeadLayout.setTranslationY(currentY / 2);

            }
        });
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", this.getIntent().getStringExtra("id"));
        BSHttpUtils.get(mActivity, this, Constant.OTHER_HEAD_URL, map, TAInfoVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        TAInfoVO taInfoVO= (TAInfoVO) vo;
        if(!TextUtils.isEmpty(taInfoVO.getData().getAvatar()))
            Picasso.with(this).load(taInfoVO.getData().getAvatar()).into(mHeadImg);
        mNameTv.setText(taInfoVO.getData().getNickname());
        mUserId.setText("ID："+taInfoVO.getData().getUser_no());
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }
}
