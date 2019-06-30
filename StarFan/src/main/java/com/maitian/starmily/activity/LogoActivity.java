package com.maitian.starmily.activity;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.Toast;

import com.google.gson.Gson;
import com.maitian.starmily.R;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.fragment.TabFiveFragment;
import com.maitian.starmily.fragment.TabFourFragment;
import com.maitian.starmily.fragment.TabOneFragment;
import com.maitian.starmily.fragment.TabThreeFragment;
import com.maitian.starmily.fragment.TabTwoFragment;
import com.maitian.starmily.model.AppConfigVO;
import com.maitian.starmily.model.MyIdolsVO;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.tbruyelle.rxpermissions2.Permission;
import com.tbruyelle.rxpermissions2.RxPermissions;
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

import io.reactivex.functions.Consumer;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;


public class LogoActivity extends BaseLogoActivity  {
    private static final int REQUEST_PERMISSIONS = 1;
    private boolean mFlag = false;

    @Override
    public void initLogo() {
        EventBus.getDefault().register(this);
        mLogoImageView.setBackgroundResource(R.mipmap.logo);
//        initPermissions();
        getAppConfig();
        getMyIdol();

        mLogoImageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                rxPermissions();
            }
        }, 3000);
    }


    @Subscribe
    public void onEventMainThread(EBMessageVO event) {
        if ("guide".equals(event.getMessage())) {



        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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
                    }
                });
    }

    public void getMyIdol(){
        if(AppApplication.getInstance().getUserInfoVO()==null)
            return;
        HashMap<String, Object> idolMap = new HashMap<>();
        idolMap.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        final Gson gson = new Gson();
        new Novate.Builder(this)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build()
                .rxGet(Constant.MY_IDOLS, idolMap, new RxStringCallback() {
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
                        MyIdolsVO vo = gson.fromJson(s, MyIdolsVO.class);
                        if(vo.getObj().size()>0)
                            AppApplication.getInstance().saveMyIdolsVO(vo);
                    }
                });
    }


    public void rxPermissions(){
        RxPermissions rxPermissions=new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.CALL_PHONE,Manifest.permission.INTERNET).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (aBoolean){
                    //申请的权限全部允许
                    Intent intent = new Intent();
                    if (AppApplication.getInstance().getUserInfoVO() != null) {
                        intent.setClass(LogoActivity.this, MainActivity.class);
                    } else {
                        intent.setClass(LogoActivity.this, LoginActivity.class);
                    }
                    startActivity(intent);
                    LogoActivity.this.finish();

                }else{
                    //只要有一个权限被拒绝，就会执行
                    Toast.makeText(LogoActivity.this, "未授权权限，部分功能不能使用", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
