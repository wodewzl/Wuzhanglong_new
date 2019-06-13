package com.maitian.starmily.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.maitian.starmily.R;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.UserInfoVO;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.MD5;

import java.util.HashMap;

public class LoginPhoneActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private EditText mPhoneEt, mPwdEt;
    private Button mOkBt;
    private TextView mPwdBackTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.login_phone_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("登录");
        mPhoneEt = getViewById(R.id.phone_et);
        mPwdEt = getViewById(R.id.pwd_et);
        mOkBt = getViewById(R.id.ok_bt);
        mPwdBackTv = getViewById(R.id.pwd_back_tv);
    }

    @Override
    public void bindViewsListener() {
        mOkBt.setOnClickListener(this);
        mPwdBackTv.setOnClickListener(this);
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ok_bt:
                login();
                break;
            case R.id.pwd_back_tv:
                openActivity(BackPasswordActivity.class);
                break;
            default:
                break;

        }
    }

    public void login() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("loginType", "0");
        map.put("phoneNo", mPhoneEt.getText().toString());
        map.put("password",  MD5.Md5(mPwdEt.getText().toString()));
        StartHttpUtils.postCallBack(mActivity, Constant.REG_AND_LOG, map, UserInfoVO.class, this);
    }

    public void success(BaseVO vo) {
        UserInfoVO userInfoVO = (UserInfoVO) vo;
        if (userInfoVO.getObj() != null) {
            AppApplication.getInstance().saveUserInfoVO(userInfoVO);
            openActivity(MainActivity.class);
            this.finish();
        }
    }
}
