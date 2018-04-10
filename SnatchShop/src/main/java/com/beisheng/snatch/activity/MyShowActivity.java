package com.beisheng.snatch.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.MyBuyRecordAdapter;
import com.beisheng.snatch.adapter.MyShowAdapter;
import com.beisheng.snatch.fragment.MyBuyRecordFragment;
import com.beisheng.snatch.fragment.MyShowRecordFragment;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

public class MyShowActivity extends BaseActivity implements View.OnClickListener{
    private TextView mTitle1, mTitle2;
    public ViewPager mViewPager;
    private List<MyShowRecordFragment> mList = new ArrayList<>();


    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_show_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("我的晒单");
        mTitle1 = getViewById(R.id.title1);
        mTitle2 = getViewById(R.id.title2);
        MyShowRecordFragment one = MyShowRecordFragment.newInstance();
        one.setType("0");
        MyShowRecordFragment two = MyShowRecordFragment.newInstance();
        two.setType("1");
        mList.add(one);
        mList.add(two);
        mViewPager = (ViewPager) findViewById(com.wuzhanglong.library.R.id.vp_home);
        mViewPager.setOffscreenPageLimit(2);
    }

    @Override
    public void bindViewsListener() {
        mTitle1.setOnClickListener(this);
        mTitle2.setOnClickListener(this);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {

                return mList.get(position);
            }

            @Override
            public int getCount() {
                return mList.size();
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    mTitle1.setBackgroundResource(R.drawable.corners_tab_left_select);
                    mTitle1.setTextColor(ContextCompat.getColor(MyShowActivity.this, R.color.C1));
                    mTitle2.setBackgroundResource(R.drawable.corners_tab_right_normal);
                    mTitle2.setTextColor(ContextCompat.getColor(MyShowActivity.this, R.color.colorAccent));
                } else {
                    mTitle2.setBackgroundResource(R.drawable.corners_tab_right_select);
                    mTitle2.setTextColor(ContextCompat.getColor(MyShowActivity.this, R.color.C1));
                    mTitle1.setBackgroundResource(R.drawable.corners_tab_left_normal);
                    mTitle1.setTextColor(ContextCompat.getColor(MyShowActivity.this, R.color.colorAccent));
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
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
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title1:
                mTitle1.setBackgroundResource(R.drawable.corners_tab_left_select);
                mTitle1.setTextColor(ContextCompat.getColor(this, R.color.C1));
                mTitle2.setBackgroundResource(R.drawable.corners_tab_right_normal);
                mTitle2.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                mViewPager.setCurrentItem(0);
                break;
            case R.id.title2:
                mTitle2.setBackgroundResource(R.drawable.corners_tab_right_select);
                mTitle2.setTextColor(ContextCompat.getColor(this, R.color.C1));
                mTitle1.setBackgroundResource(R.drawable.corners_tab_left_normal);
                mTitle1.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                mViewPager.setCurrentItem(1);
                break;

            default:
                break;
        }
    }
}
