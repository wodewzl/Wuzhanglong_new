package com.maitian.starmily.activity;

import android.Manifest;
import android.content.Intent;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.fragment.TabFiveFragment;
import com.maitian.starmily.fragment.TabFourFragment;
import com.maitian.starmily.fragment.TabOneFragment;
import com.maitian.starmily.fragment.TabThreeFragment;
import com.maitian.starmily.fragment.TabTwoFragment;
import com.maitian.starmily.model.AppConfigVO;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.activity.BaseLogoActivity;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.EBMessageVO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
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
        mLogoImageView.setBackgroundResource(R.mipmap.logo);
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

        getAppConfig();
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
        intent.setClass(this, MainActivity.class);
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
            intent.setClass(this, MainActivity.class);


//            intent.setClass(this, MyBindPhoneActivity.class);
//            intent.setClass(this, MyLegalizeActivity.class);
//            intent.setClass(this, MyMessageActivity.class);
//            intent.setClass(this, MyAboutActivity.class);
//                        intent.setClass(this, MyAttentionActivity.class);
//            intent.setClass(this, MyTaskActivity.class);
//            intent.setClass(this, MyPurseActivity.class);
//            intent.setClass(this, MyPaurseDetailActivity.class);
//            intent.setClass(this, MyMemberCentreActivity.class);
//            intent.setClass(this, MySettiingsActivity.class);
//            intent.setClass(this, MyUpdatePwdActivity.class);
//            intent.setClass(this, HomeHitListActivity.class);
//            intent.setClass(this, HomeNewsActivity.class);
//            intent.setClass(this, HomePromotionsActivity.class);//主页—活动
//            intent.setClass(this, RiceCircleStarActivity.class);//明星守护列表
            startActivity(intent);
            this.finish();
        } else {
            EasyPermissions.requestPermissions(this, "是否申请必要的权限？", REQUEST_PERMISSIONS, perms);
        }
    }

    public void getAppConfig() {
        if (!TextUtils.isEmpty(ACache.get(this).getAsString("domain_ulr"))) {
            Constant.DOMAIN_UR = ACache.get(this).getAsString("domain_ulr");
            return;
        }
        final Gson gson = new Gson();
        HashMap<String, Object> map = new HashMap<>();
        new Novate.Builder(this)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build()
                .rxGet(Constant.APP_CONFIG, map, new RxStringCallback() {
                    @Override
                    public void onError(Object tag, Throwable e) {
                        System.out.println();
                    }

                    @Override
                    public void onCancel(Object tag, Throwable e) {
                        System.out.println();
                    }

                    @Override
                    public void onNext(Object o, String s) {
                        AppConfigVO vo = gson.fromJson(s, AppConfigVO.class);
                        ACache.get(LogoActivity.this).put("domain_ulr", vo.getObj().getImgDomain());

//                        AppConfigVO vo = gson.fromJson(s, AppConfigVO.class);
//                        AppApplication.getInstance().saveAppConfigVO(vo);
                    }


                });
    }


}
