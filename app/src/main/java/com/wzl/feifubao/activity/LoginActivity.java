package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.UserInfoVO;

import java.util.HashMap;

public class LoginActivity extends BaseActivity implements View.OnClickListener,PostCallback {
    private TextView mPhoneTv, mPasswordTv, mOkTv;


    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_login);
    }

    @Override
    public void initView() {
        mBaseHeadLayout.setVisibility(View.GONE);
        mPhoneTv = getViewById(R.id.phone_tv);
        mPasswordTv = getViewById(R.id.password_tv);
        mOkTv = getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.colorAccent, R.color.colorAccent));
    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
    }

    @Override
    public void getData() {

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
        switch (v.getId()) {
            case R.id.ok_tv:

                if(TextUtils.isEmpty(mPhoneTv.getText().toString())){
                    showCustomToast("请输入手机号");
                    return;
                }
                if(TextUtils.isEmpty(mPasswordTv.getText().toString())){
                    showCustomToast("请输入密码");
                    return;
                }

                commit();
                break;
            default:
                break;
        }
    }


    public void commit() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", mPhoneTv.getText().toString());
        map.put("password", mPasswordTv.getText().toString());
        HttpGetDataUtil.post(this, Constant.LOGIN_URL, map, UserInfoVO.class,this);
    }

    @Override
    public void success(BaseVO vo) {

    }
}
