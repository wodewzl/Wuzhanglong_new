package com.wzl.feifubao.activity;

import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.alipay.android.phone.mrpc.core.NetworkUtils;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.UserInfoVO;

import java.util.HashMap;

public class RegistActivity extends BaseActivity implements View.OnClickListener, PostCallback{
    private EditText mEt01, mEt02, mEt03, mEt04;
    private TextView mOkTv, mCodeTv;
    private boolean mCodeStae = true;
    private String mCode = "";

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
        mCodeTv = getViewById(R.id.code_tv);
        mCodeTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.colorAccent, R.color.colorAccent));
    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
        mCodeTv.setOnClickListener(this);
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
                    showCustomToast("请输入邮箱");
                    return;
                }
                if (TextUtils.isEmpty(mEt02.getText().toString())) {
                    showCustomToast("请输入邮箱验证码");
                    return;
                }

                if (!mCode.equals(mEt02.getText().toString())) {
                    showCustomToast("请输入正确的验证码");
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

            case R.id.code_tv:
                if (mCodeStae) {
                    if (!NetworkUtils.isNetworkAvailable(this)) {
                        //没有网络
                        showCustomToast("请检查您的网络状态");
                        return;
                    }

                    if (TextUtils.isEmpty(mEt01.getText().toString())) {
                        showCustomToast("请输入邮箱");
                        return;
                    }

                    mCodeTv.setBackground(BaseCommonUtils.setBackgroundShap(RegistActivity.this, 5, R.color.C3_1, R.color.C3_1));

                    getCode();
                    DaoJishi();
                    mCodeStae = false;
                }
                break;
            default:
                break;
        }

    }

    public void DaoJishi() {
        final CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long arg0) {
                mCodeTv.setText(arg0 / 1000 + "s后重发 ");
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onFinish() {
                mCodeTv.setText("获取验证码");
                mCodeStae = true;
                mCodeTv.setBackground(BaseCommonUtils.setBackgroundShap(RegistActivity.this, 5, R.color.colorAccent, R.color.colorAccent));
            }
        };
        timer.start();
    }


    public void commit() {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("username", mEt01.getText().toString());
        map.put("email", mEt01.getText().toString());
//        map.put("phone", mEt01.getText().toString());
        map.put("password", mEt03.getText().toString());
        HttpGetDataUtil.post(this, Constant.REGIST_URL, map, UserInfoVO.class, this);
    }

    public void getCode() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("email", mEt01.getText().toString());
//        HttpGetDataUtil.postResult(this, Constant.REGIST_CODE_URL, map, this);
    }

    @Override
    public void success(BaseVO vo) {
        if (vo instanceof UserInfoVO) {
            showCustomToast("注册成功");
            this.finish();
        } else {

        }

    }

//    @Override
//    public void success(String result) {
//
//        try {
//            JSONObject jsonObject = new JSONObject(result);
//            String code = (String) jsonObject.get("code");
//            if ("200".equals(code)) {
//                showCustomToast("验证码发送成功，请查收");
//                mCode = (String) jsonObject.get("data");
//            } else {
//                showCustomToast("验证码发送失败，请从新发送");
//                mCodeStae = true;
//                mCodeTv.setBackground(BaseCommonUtils.setBackgroundShap(RegistActivity.this, 5, R.color.colorAccent, R.color.colorAccent));
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//    }
}
