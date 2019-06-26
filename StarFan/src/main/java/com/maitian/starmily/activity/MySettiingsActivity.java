package com.maitian.starmily.activity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.maitian.starmily.R;
import com.maitian.starmily.application.AppApplication;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MySettiingsActivity extends BaseActivity implements View.OnClickListener {
    private Button mLoginOutBt;
    private TextView mBackPwdTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_settiings_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("设置");
        mLoginOutBt = getViewById(R.id.login_out_bt);
        mBackPwdTv=getViewById(R.id.back_pwd_tv);
    }

    @Override
    public void bindViewsListener() {
        mLoginOutBt.setOnClickListener(this);
        mBackPwdTv.setOnClickListener(this);
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
            default:
                break;

        }
    }
}
