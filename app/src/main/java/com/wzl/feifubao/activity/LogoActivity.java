package com.wzl.feifubao.activity;

import android.Manifest;
import android.content.Intent;

import com.wuzhanglong.library.activity.BaseLogoActivity;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.fragment.TabFourragment;
import com.wzl.feifubao.fragment.TabOneFragment;
import com.wzl.feifubao.fragment.TabThreeFragment;
import com.wzl.feifubao.fragment.TabTwoFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class LogoActivity extends BaseLogoActivity implements EasyPermissions.PermissionCallbacks {
    private static final int REQUEST_PERMISSIONS = 1;
    public List<BaseFragment> list = new ArrayList<>();
    private boolean mFlag = false;
    @Override
    public void initLogo() {
        EventBus.getDefault().register(this);
        mLogoImageView.setBackgroundResource(R.drawable.logo);
//        initPermissions();
        list = new ArrayList<>();
        TabOneFragment one = new TabOneFragment();
        TabTwoFragment two = new TabTwoFragment();
        TabThreeFragment three = new TabThreeFragment();
        TabFourragment four = new TabFourragment();
        list.add(one);
        list.add(four);
        list.add(three);
    }


    @Subscribe
    public void onEventMainThread(EBMessageVO event) {
        if ("guide".equals(event.getMessage())) {
            reuestPerm();

//            Intent intent = new Intent();
//            intent.putExtra("fragment_list", (Serializable) list);
//            intent.setClass(this, MainActivity.class);
//            startActivity(intent);
//            this.finish();

//            Intent intent = new Intent();
//            intent.setClass(this, HouseListActivity.class);//房源列表
//            intent.setClass(this, HouseDetailActivity.class);//房源详情
//            intent.setClass(this, RegistActivity.class);//用户注册
//            intent.setClass(this, LoginActivity.class);//用户登陆
//                        intent.setClass(this, AddressAddActivity.class);//添加收获地址
//            intent.setClass(this, AddressActivity.class);//添加收获地址
//            intent.setClass(this, JobOffersActivity.class);//招聘信息
//            startActivity(intent);
//            this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Intent intent = new Intent();
        if (AppApplication.getInstance().getUserInfoVO() != null) {
            intent.putExtra("fragment_list", (Serializable) list);
            intent.setClass(this, MainActivity.class);
        } else {
            intent.setClass(this, LoginActivity.class);
        }

        startActivity(intent);
        this.finish();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

    }

    @AfterPermissionGranted(REQUEST_PERMISSIONS)
    private void reuestPerm() {
        String[] perms = {android.Manifest.permission.ACCESS_COARSE_LOCATION, android.Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(this, perms)) {
            Intent intent = new Intent();
            if (AppApplication.getInstance().getUserInfoVO() != null) {
                intent.putExtra("fragment_list", (Serializable) list);
                intent.setClass(this, MainActivity.class);
            } else {
                intent.setClass(this, LoginActivity.class);
            }

            startActivity(intent);
            this.finish();
        } else {
            EasyPermissions.requestPermissions(this, "", REQUEST_PERMISSIONS, perms);
        }
    }
}
