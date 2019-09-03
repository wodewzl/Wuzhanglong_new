package com.maitian.starmily.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maitian.starmily.R;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.UpdateBean;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DataCleanUtil;
import com.wuzhanglong.library.utils.FileUtil;

import java.io.File;
import java.util.HashMap;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MySettiingsActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private Button mLoginOutBt;
    private TextView mBackPwdTv, mAboutTv, mCleanCacheTv, mCacheTv;
    private DataCleanUtil mDataCleanUtil;
    private boolean isClean = true;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_settiings_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("设置");
        mLoginOutBt = getViewById(R.id.login_out_bt);
        mBackPwdTv = getViewById(R.id.back_pwd_tv);
        mAboutTv = getViewById(R.id.about_tv);
        mCleanCacheTv = getViewById(R.id.clean_cache_tv);
        mDataCleanUtil = new DataCleanUtil(this);
        mCacheTv = getViewById(R.id.cache_tv);
        final String str = mDataCleanUtil.getCacheSize(this, new File(FileUtil.getSaveFilePath(this, Constant.SDCARD_CACHE)));
        mCacheTv.setText(str);
    }

    @Override
    public void bindViewsListener() {
        mLoginOutBt.setOnClickListener(this);
        mBackPwdTv.setOnClickListener(this);
        mAboutTv.setOnClickListener(this);
        mCleanCacheTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        show();
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_out_bt:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要退出登录吗?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                AppApplication.getInstance().saveUserInfoVO(null);
                                openActivity(LoginActivity.class);
                                finish();
                                sDialog.dismissWithAnimation();//直接消失
                            }
                        })
                        .show();
                break;
            case R.id.back_pwd_tv:
                openActivity(BackPasswordActivity.class);
                break;
            case R.id.about_tv:
                openActivity(MyAboutActivity.class);
                break;

            case R.id.clean_cache_tv:
                final String str = mDataCleanUtil.getCacheSize(this, new File(FileUtil.getSaveFilePath(this, Constant.SDCARD_CACHE)));
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要清除缓存吗?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                if (isClean) {
                                    mDataCleanUtil.cleanApplicationData(MySettiingsActivity.this, FileUtil.getSaveFilePath(MySettiingsActivity.this, Constant.SDCARD_CACHE));
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
            default:
                break;

        }
    }

    public void updateApp() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        map.put("type", "1");
        map.put("type", "1.0.2");
        StartHttpUtils.postCallBack(mActivity, Constant.VERSION_INFO, map, UpdateBean.class, this);
    }

    @Override
    public void success(BaseVO vo) {
        UpdateBean updateBean = (UpdateBean) vo;

//        UpdateAppUtils.from(this)
//                .serverVersionCode(Integer.parseInt(updateBean.getObj().getFinalVersion()))  //服务器versionCode
//                .serverVersionName(updateVO.getData().getV_name()) //服务器versionName
//                .apkPath(updateVO.getData().getV_address()) //最新apk下载地址
//                .isForce(true)
//                .update();
    }
}
