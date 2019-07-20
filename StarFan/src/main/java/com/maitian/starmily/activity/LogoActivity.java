package com.maitian.starmily.activity;

import android.Manifest;
import android.content.Intent;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.google.gson.Gson;
import com.maitian.starmily.R;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.AdBean;
import com.maitian.starmily.model.AppConfigVO;
import com.maitian.starmily.model.MyIdolsVO;
import com.squareup.picasso.Picasso;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.wuzhanglong.library.activity.BaseLogoActivity;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.constant.BaseConstant;

import java.util.HashMap;

import io.reactivex.functions.Consumer;


public class LogoActivity extends BaseLogoActivity {

    @Override
    public void initLogo() {
        getAppConfig();
        getMyIdol();
        getAd();

        if (TextUtils.isEmpty(ACache.get(this).getAsString("logo_url"))) {
            mLogoImageView.setBackgroundResource(R.mipmap.logo);
        } else {
            if (ACache.get(this).getAsString("logo_url").contains("http:")) {
                Picasso.with(this).load(ACache.get(this).getAsString("logo_url")).into(mLogoImageView);
            } else {
                Picasso.with(this).load(Constant.DOMAIN_UR + "/" + ACache.get(this).getAsString("logo_url")).into(mLogoImageView);
            }
            mLogoImageView.setBackgroundResource(R.mipmap.logo);
        }
//        mLogoImageView.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                rxPermissions();
//            }
//        }, 3000);

        mTimer.start();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mTimer != null)
            mTimer.cancel();
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

    public void getMyIdol() {
        if (AppApplication.getInstance().getUserInfoVO() == null)
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
                        if (vo.getObj().size() > 0)
                            AppApplication.getInstance().saveMyIdolsVO(vo);
                    }
                });
    }


    public void rxPermissions() {
        RxPermissions rxPermissions = new RxPermissions(this);
        rxPermissions.request(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CALL_PHONE, Manifest.permission.INTERNET).subscribe(new Consumer<Boolean>() {
            @Override
            public void accept(Boolean aBoolean) throws Exception {
                if (aBoolean) {
                    //申请的权限全部允许
                    Intent intent = new Intent();
                    if (AppApplication.getInstance().getUserInfoVO() != null) {
                        intent.setClass(LogoActivity.this, MainActivity.class);
                    } else {
                        intent.setClass(LogoActivity.this, LoginActivity.class);
                    }
                    startActivity(intent);
                    LogoActivity.this.finish();

                } else {
                    //只要有一个权限被拒绝，就会执行
                    Toast.makeText(LogoActivity.this, "未授权权限，部分功能不能使用", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getAd() {
        if (AppApplication.getInstance().getUserInfoVO() == null)
            return;
        HashMap<String, Object> idolMap = new HashMap<>();
        idolMap.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        final Gson gson = new Gson();
        new Novate.Builder(this)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build()
                .rxGet(Constant.BOOT_SCREEN, idolMap, new RxStringCallback() {
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
                        AdBean vo = gson.fromJson(s, AdBean.class);
                        ACache.get(LogoActivity.this).put("logo_url", vo.getObj().getQiNiuAddress());
                        ACache.get(LogoActivity.this).put("logo_link_url", vo.getObj().getLinkAddress());
                    }
                });
    }

    private CountDownTimer mTimer = new CountDownTimer(5 * 1000, 1000) {
        /**
         * 固定间隔被调用,就是每隔countDownInterval会回调一次方法onTick
         * @param millisUntilFinished
         */
        @Override
        public void onTick(long millisUntilFinished) {
            mTimeTv.setText(millisUntilFinished / 1000 + "");
            Animation animation = AnimationUtils.loadAnimation(LogoActivity.this, R.anim.anim_textview_time);
            animation.reset();
            mTimeTv.startAnimation(animation);
        }

        /**
         * 倒计时完成时被调用
         */
        @Override
        public void onFinish() {
            rxPermissions();
        }
    };

    @Override
    public void onClick(View v) {
        super.onClick(v);

        switch (v.getId()) {
            case R.id.time_root_layout:
                rxPermissions();
                this.finish();
                break;
            case R.id.logo_image:
                Intent intent = new Intent();
                intent.putExtra("url", ACache.get(LogoActivity.this).getAsString("logo_link_url"));
                intent.setClass(LogoActivity.this, WebViewActivity.class);
                startActivity(intent);

                break;
            default:
                break;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mTimer != null)
            mTimer.cancel();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mTimer != null)
            mTimer.start();
    }
}
