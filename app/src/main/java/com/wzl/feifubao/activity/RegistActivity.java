package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.HouseDetailVO;
import com.wzl.feifubao.mode.UserInfoVO;

import java.util.HashMap;

public class RegistActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private EditText mEt01, mEt02, mEt03, mEt04;
    private TextView mOkTv;


    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_regist);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("用户注册");
        mEt01 = getViewById(R.id.et_01);
        mEt02 = getViewById(R.id.et_02);
        mEt03 = getViewById(R.id.et_03);
        mEt04 = getViewById(R.id.et_04);
        mOkTv = getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.colorAccent, R.color.colorAccent));
    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
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
        switch (v.getId()) {
            case R.id.ok_tv:
                if (TextUtils.isEmpty(mEt01.getText().toString())) {
                    showCustomToast("请输入用户名");
                    return;
                }
                if (TextUtils.isEmpty(mEt02.getText().toString())) {
                    showCustomToast("请输入手机号");
                    return;
                }
                if (TextUtils.isEmpty(mEt03.getText().toString())) {
                    showCustomToast("请输入密码");
                    return;
                }

                if (TextUtils.isEmpty(mEt04.getText().toString())) {
                    showCustomToast("请输入确认密码");
                    return;
                }

                if (!mEt03.getText().toString().equals(mEt04.getText().toString())) {
                    showCustomToast("两次密码一样");
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
        map.put("username", mEt01.getText().toString());
        map.put("phone", mEt02.getText().toString());
        map.put("password", mEt03.getText().toString());
        HttpGetDataUtil.post(this, Constant.REGIST_URL, map, UserInfoVO.class, this);
    }

    @Override
    public void success(BaseVO vo) {
        showCustomToast("注册成功");
        this.finish();
    }
}
