package com.beisheng.snatch.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.AddressDialogAdapter;
import com.beisheng.snatch.adapter.MyBuyRecordAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.fragment.MyLuckyRecordFragment;
import com.beisheng.snatch.model.MyLuckyRecordVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.nanchen.compresshelper.CompressHelper;
import com.rey.material.app.BottomSheetDialog;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BottomDialogUtil;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MyLuckyRecordActivity extends BaseActivity implements View.OnClickListener {

    private TextView mTitle1, mTitle2;
    public ViewPager mViewPager;
    private List<MyLuckyRecordFragment> mList = new ArrayList<>();
    private MyLuckyRecordFragment mTwo;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_lucky_record_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("幸运记录");
        mTitle1 = getViewById(R.id.title1);
        mTitle2 = getViewById(R.id.title2);
        MyLuckyRecordFragment one = MyLuckyRecordFragment.newInstance();
        one.setType("0");
        mTwo = MyLuckyRecordFragment.newInstance();
        mTwo.setType("1");
        mList.add(one);
        mList.add(mTwo);
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
                if(position==0){
                    mTitle1.setBackgroundResource(R.drawable.corners_tab_left_select);
                    mTitle1.setTextColor(ContextCompat.getColor(MyLuckyRecordActivity.this, R.color.C1));
                    mTitle2.setBackgroundResource(R.drawable.corners_tab_right_normal);
                    mTitle2.setTextColor(ContextCompat.getColor(MyLuckyRecordActivity.this, R.color.colorAccent));
                }else {
                    mTitle2.setBackgroundResource(R.drawable.corners_tab_right_select);
                    mTitle2.setTextColor(ContextCompat.getColor(MyLuckyRecordActivity.this, R.color.C1));
                    mTitle1.setBackgroundResource(R.drawable.corners_tab_left_normal);
                    mTitle1.setTextColor(ContextCompat.getColor(MyLuckyRecordActivity.this, R.color.colorAccent));
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




    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mTwo.onActivityResult(requestCode, resultCode, data);
    }


}
