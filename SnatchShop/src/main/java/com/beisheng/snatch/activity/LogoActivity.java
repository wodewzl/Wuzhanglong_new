package com.beisheng.snatch.activity;

import android.Manifest;
import android.content.Intent;

import com.beisheng.snatch.R;
import com.beisheng.snatch.fragment.TabFiveFragment;
import com.beisheng.snatch.fragment.TabFourFragment;
import com.beisheng.snatch.fragment.TabOneFragment;
import com.beisheng.snatch.fragment.TabThreeFragment;
import com.beisheng.snatch.fragment.TabTwoFragment;
import com.wuzhanglong.library.activity.BaseLogoActivity;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.EBMessageVO;

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
        TabFourFragment four = new TabFourFragment();
        TabFiveFragment five = new TabFiveFragment();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(four);
        list.add(five);
    }


    @Subscribe
    public void onEventMainThread(EBMessageVO event) {
        if ("guide".equals(event.getMessage())) {
            reuestPerm();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        Intent intent = new Intent();
        intent.putExtra("fragment_list", (Serializable) list);
        intent.setClass(this, HomeActivity.class);
//        intent.setClass(this, HomeWebActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        System.out.println("==========>");
    }

    @AfterPermissionGranted(REQUEST_PERMISSIONS)
    private void reuestPerm() {
        String[] perms = {Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(this, perms)) {
            Intent intent = new Intent();
            intent.putExtra("fragment_list", (Serializable) list);
            intent.setClass(this, HomeActivity.class);
//            intent.setClass(this, HomeWebActivity.class);
            startActivity(intent);
            this.finish();
        } else {
            EasyPermissions.requestPermissions(this, "是否申请必要的权限？", REQUEST_PERMISSIONS, perms);
        }
    }
}
