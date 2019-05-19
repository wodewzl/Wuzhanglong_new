package com.maitian.starfan.activity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.maitian.starfan.R;

import com.maitian.starfan.view.SpecialTab;
import com.maitian.starfan.view.SpecialTabRound;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;

import java.util.ArrayList;
import java.util.List;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends BaseActivity implements EasyPermissions.PermissionCallbacks {
    public ViewPager mVpHome;
    public PageNavigationView mBottomNavigationBar;
    public ArrayList<BaseFragment> mFragmentList = new ArrayList<>();
    private double mBackPressed;
    public AMapLocationClient mLocationClient = null;
    public AMapLocationClientOption mLocationOption = null;

    @Override
    public void baseSetContentView() {
        View.inflate(this, R.layout.main_activity, mBaseContentLayout);
    }

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void initView() {
        mFragmentList = (ArrayList<BaseFragment>) this.getIntent().getSerializableExtra("fragment_list");

        mVpHome = (ViewPager) findViewById(com.wuzhanglong.library.R.id.vp_home);
        mVpHome.setOffscreenPageLimit(4);
        mBottomNavigationBar = (PageNavigationView) findViewById(com.wuzhanglong.library.R.id.bottom_navigation_bar);
        initBottomBar();
        initPermissions();
    }


    @Override
    public void bindViewsListener() {
        mVpHome.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
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
    protected void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
        if (mLocationClient != null)
            mLocationClient.onDestroy();//销毁定位客户端，同时销毁本地定位服务。
    }


    @Override
    public void onBackPressed() {
        if (isShow()) {
//            dismissProgressDialog();
        } else {
            if (mBackPressed + 3000 > System.currentTimeMillis()) {
                finish();
                super.onBackPressed();
            } else
                showCustomToast("再次点击，退出" + this.getResources().getString(com.wuzhanglong.library.R.string.app_name));
            mBackPressed = System.currentTimeMillis();
        }
    }

    public void initPermissions() {
        String[] perms = {android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION, android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            // 县市定位
            initMap();
        } else {
            EasyPermissions.requestPermissions(this, "请允许打开权限权限", 1, perms);
        }

    }

    public void initMap() {
        mLocationClient = new AMapLocationClient(getApplicationContext());
        mLocationClient.setLocationListener(locationListener);
        mLocationOption = new AMapLocationClientOption();
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        mLocationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Battery_Saving);
        mLocationOption.setOnceLocation(true);
        mLocationOption.setInterval(0);
        mLocationOption.setNeedAddress(true);
        mLocationClient.setLocationOption(mLocationOption);
        mLocationClient.startLocation();
    }

    AMapLocationListener locationListener = new AMapLocationListener() {
        @Override
        public void onLocationChanged(AMapLocation amapLocation) {
            if (amapLocation != null) {
                try {
                    double lat = amapLocation.getLatitude();//获取纬度
                    double lo = amapLocation.getLongitude();//获取经度
                    String address = amapLocation.getAddress();
                    String city = amapLocation.getCity();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    public void onPermissionsGranted(int i, List<String> list) {
        initMap();
    }

    @Override
    public void onPermissionsDenied(int i, List<String> list) {
        Toast.makeText(this, "请允许权限", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    public void initBottomBar() {
        NavigationController navigationController = mBottomNavigationBar.custom()
                .addItem(newItem(R.mipmap.home_1, R.mipmap.home_2, "首页"))
                .addItem(newItem(R.mipmap.home_2, R.mipmap.home_2, "饭圈"))
                .addItem(newRoundItem(R.mipmap.home_3, R.mipmap.home_3, ""))
                .addItem(newItem(R.mipmap.home_4, R.mipmap.home_4, "发现"))
                .addItem(newItem(R.mipmap.home_5, R.mipmap.home_5, "我的"))
                .build();

        navigationController.setupWithViewPager(mVpHome);
        mBaseHeadLayout.setVisibility(View.GONE);


        mBaseHeadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
//                checkUpdate();
            }
        }, 1000);


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 正常tab
     */

    @SuppressLint("ResourceAsColor")
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {

        SpecialTab mainTab = new SpecialTab(this);
        mainTab.initialize(drawable, checkedDrawable, text);
//        mainTab.setTextDefaultColor(R.color.C9);
//        mainTab.setTextCheckedColor(0xFFFF8FA9);
        return mainTab;
    }

    /**
     * 圆形tab
     */
    private BaseTabItem newRoundItem(int drawable, int checkedDrawable, String text) {
        SpecialTabRound mainTab = new SpecialTabRound(this);
        mainTab.initialize(drawable, checkedDrawable, text);

        return mainTab;
    }
}
