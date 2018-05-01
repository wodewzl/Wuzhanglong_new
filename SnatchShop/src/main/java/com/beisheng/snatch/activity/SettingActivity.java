package com.beisheng.snatch.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.allenliu.versionchecklib.v2.AllenVersionChecker;
import com.allenliu.versionchecklib.v2.builder.UIData;
import com.allenliu.versionchecklib.v2.callback.RequestVersionListener;
import com.beisheng.snatch.R;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.UpdateAppVO;
import com.google.gson.Gson;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.DataCleanUtil;
import com.wuzhanglong.library.utils.FileUtil;
import com.wuzhanglong.library.utils.VersionUtils;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class SettingActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTv01, mTv02, mTv03, mTv04, mTv05, mTv06, mTv07, mTv08, mTv09;
    private boolean isClean = true;
    private DataCleanUtil mDataCleanUtil;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.setting_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("设置");
        mTv01 = getViewById(R.id.tv_01);
        mTv02 = getViewById(R.id.tv_02);
        mTv03 = getViewById(R.id.tv_03);
        mTv04 = getViewById(R.id.tv_04);
        mTv05 = getViewById(R.id.tv_05);
        mTv06 = getViewById(R.id.tv_06);
        mTv07 = getViewById(R.id.tv_07);
        mTv07.setText("当前版本：" + VersionUtils.getversionName(this));
        mTv08 = getViewById(R.id.tv_08);
        mTv09 = getViewById(R.id.tv_09);
        mDataCleanUtil = new DataCleanUtil(this);

        if(AppApplication.getInstance().getUserInfoVO()==null){
            mTv09.setVisibility(View.GONE);
        }else {
            mTv09.setVisibility(View.VISIBLE);
        }

    }

    @Override
    public void bindViewsListener() {
        mTv01.setOnClickListener(this);
        mTv02.setOnClickListener(this);
        mTv03.setOnClickListener(this);
        mTv04.setOnClickListener(this);
        mTv05.setOnClickListener(this);
        mTv06.setOnClickListener(this);
        mTv08.setOnClickListener(this);
        mTv09.setOnClickListener(this);
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
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.tv_01:
                if(AppApplication.getInstance().getUserInfoVO()==null){
                    showCustomToast("请先登陆");
                    return;
                }
                openActivity(NameConfirmActivity.class);
                break;
            case R.id.tv_02:
                bundle.putString("title", "关于我们");
                bundle.putString("url", AppApplication.getInstance().getUserInfoVO().getData().getAboutus_url());
                open(WebViewActivity.class, bundle, 0);
                break;
            case R.id.tv_03:

                break;
            case R.id.tv_04:
                bundle.putString("title", "服务协议");
                bundle.putString("url", AppApplication.getInstance().getUserInfoVO().getData().getFwxy_url());
                open(WebViewActivity.class, bundle, 0);
                break;
            case R.id.tv_05:
                bundle.putString("title", "隐私协议");
                bundle.putString("url", AppApplication.getInstance().getUserInfoVO().getData().getYsxy_url());
                open(WebViewActivity.class, bundle, 0);
                break;
            case R.id.tv_06:
                updateApp();
                break;
            case R.id.tv_08:
                final String str = mDataCleanUtil.getCacheSize(this, new File(FileUtil.getSaveFilePath(this, Constant.SDCARD_CACHE)));
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要清除缓存吗?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {

                                if (isClean) {
                                    mDataCleanUtil.cleanApplicationData(SettingActivity.this, FileUtil.getSaveFilePath(SettingActivity.this, Constant.SDCARD_CACHE));
                                    isClean = false;
                                    sDialog.setTitleText("删除成功")
                                            .setContentText("当前清除" + str + "文件缓存")
                                            .setConfirmText("确定")
                                            .setConfirmClickListener(null)
                                            .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                } else {
                                    sDialog.setTitleText("删除成功")
                                            .setContentText("当前清除0KB文件缓存")
                                            .setConfirmText("确定")
                                            .setConfirmClickListener(null)
                                            .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
                                }

                            }


                        })
                        .show();
                break;
            case R.id.tv_09:
                new SweetAlertDialog(mActivity, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要退出登录吗?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                AppApplication.getInstance().saveUserInfoVO(null);
                                EventBus.getDefault().post(new EBMessageVO("login_out"));
                                mTv09.setText("登陆");
//                                JPushInterface.setAlias(mActivity, "", new TagAliasCallback() {
//                                    @Override
//                                    public void gotResult(int i, String s, Set<String> set) {
//                                    }
//                                });
                                sDialog.dismissWithAnimation();//直接消失
                            }
                        })
                        .show();


                break;

            default:
                break;
        }
    }

    public  void updateApp(){
        AllenVersionChecker
                .getInstance()
                .requestVersion()
                .setRequestUrl(BaseConstant.DOMAIN_NAME+Constant.UPDATE_APP_URL)
                .request(new RequestVersionListener() {
                    @Nullable
                    @Override
                    public UIData onRequestVersionSuccess(String result) {
                        //拿到服务器返回的数据，解析，拿到downloadUrl和一些其他的UI数据
                        //如果是最新版本直接return null
                        Gson gson=new Gson();
                        UpdateAppVO bean =  gson.fromJson(result, UpdateAppVO.class);
                        return UIData.create().setDownloadUrl("");
                    }

                    @Override
                    public void onRequestVersionFailure(String message) {

                    }
                })
                .excuteMission(this);
    }
}
