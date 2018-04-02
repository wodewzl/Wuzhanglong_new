package com.beisheng.snatch.activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.beisheng.snatch.R;
import com.umeng.socialize.UMShareAPI;
import com.wuzhanglong.library.activity.HomeFragmentActivity;

public class HomeActivity extends HomeFragmentActivity {


    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void initBottomBar() {


//        int[] drawableIds = new int[] {R.drawable.home_01, R.drawable.home_01, R.drawable.home_01, R.drawable.home_01};
//        mTabWidget.update(this,drawableIds);
//        onTabSelected(0);

//        MODE_FIXED+BACKGROUND_STYLE_STATIC
//        MODE_FIXED+BACKGROUND_STYLE_RIPPLE
//        MODE_SHIFTING+BACKGROUND_STYLE_STATIC
//        MODE_SHIFTING+BACKGROUND_STYLE_RIPPLE

        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

//        mBottomNavigationBar.setMode(MODE_SHIFTING);
//        mBottomNavigationBar.setBackgroundStyle(BACKGROUND_STYLE_STATIC);

        mBottomNavigationBar
                .setActiveColor(R.color.C1)
                .setInActiveColor(R.color.C5)
                .setBarBackgroundColor(R.color.colorAccent);
//                .setActiveColor(R.color.XJColor2)
//                .setInActiveColor(R.color.XJColor8)
//                .setBarBackgroundColor(R.color.C1);

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.home_1, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.home_2, "最新"))
                .addItem(new BottomNavigationItem(R.drawable.home_3, "发现"))
                .addItem(new BottomNavigationItem(R.drawable.home_4, "清单"))
                .addItem(new BottomNavigationItem(R.drawable.home_5, "个人"))
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
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
        super.onActivityResult(arg0, arg1, arg2);
        UMShareAPI.get(this).onActivityResult(arg0, arg1, arg2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}
