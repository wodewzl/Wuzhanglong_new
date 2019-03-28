package com.maitian.starfan.activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.maitian.starfan.R;
import com.umeng.socialize.UMShareAPI;
import com.wuzhanglong.library.activity.BaseHomeActivity;

public class MainActivity extends BaseHomeActivity {



    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void initBottomBar() {
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        mBottomNavigationBar
                .setActiveColor(R.color.C1)
                .setInActiveColor(R.color.C5)
                .setBarBackgroundColor(R.color.colorAccent);
//                .setActiveColor(R.color.XJColor2)
//                .setInActiveColor(R.color.XJColor8)
//                .setBarBackgroundColor(R.color.C1);

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.mipmap.home_1, "首页"))
                .addItem(new BottomNavigationItem(R.mipmap.home_2, "饭圈"))
                .addItem(new BottomNavigationItem(R.mipmap.home_3, ""))
                .addItem(new BottomNavigationItem(R.mipmap.home_4, "发现"))
                .addItem(new BottomNavigationItem(R.mipmap.home_5, "我的"))
//                .setFirstSelectedPosition(0)
                .initialise();
//        mBottomNavigationBar.selectTab(0);
        mBaseHeadLayout.setVisibility(View.GONE);


        mBaseHeadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
//                checkUpdate();
            }
        }, 1000);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
        super.onActivityResult(arg0, arg1, arg2);
        UMShareAPI.get(this).onActivityResult(arg0, arg1, arg2);
    }

}
