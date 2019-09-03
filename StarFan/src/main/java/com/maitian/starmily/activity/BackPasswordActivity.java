package com.maitian.starmily.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.MD5;

import java.util.HashMap;

public class BackPasswordActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private EditText mPhoneEt, mCodeEt, mPwdEt, mPwdSureEt;
    private TextView mSendCodeTv;
    private Button mOkBt;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.back_password_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("重置");
        mPhoneEt = getViewById(R.id.phone_et);
        mCodeEt = getViewById(R.id.code_et);
        mPwdEt = getViewById(R.id.pwd_et);
        mPwdSureEt = getViewById(R.id.pwd_sure_et);
        mSendCodeTv = getViewById(R.id.send_code_tv);
        mOkBt = getViewById(R.id.ok_bt);
    }

    @Override
    public void bindViewsListener() {
        mOkBt.setOnClickListener(this);
        mSendCodeTv.setOnClickListener(this);
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
                if (TextUtils.isEmpty(mPhoneEt.getText().toString())) {
                    Toast.makeText(this, "请填写手机号", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mCodeEt.getText().toString())) {
                    Toast.makeText(this, "请填写手机验证码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(mPhoneEt.getText().toString()) || TextUtils.isEmpty(mPwdSureEt.getText().toString())) {
                    Toast.makeText(this, "请填写密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!mPwdEt.getText().toString().equals(mPwdSureEt.getText().toString())) {
                    Toast.makeText(this, "两次密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mPwdEt.getText().toString().length() < 6) {
                    Toast.makeText(this, "密码长度至少6位", Toast.LENGTH_SHORT).show();
                    return;
                }
                updatePwd();
                break;
            case R.id.send_code_tv:
                if (TextUtils.isEmpty(mPhoneEt.getText().toString())) {
                    return;
                }
                sendMsgCode();
                break;
            default:
                break;

        }
    }

    public void sendMsgCode() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("phoneNo", mPhoneEt.getText().toString());
        map.put("type", "3");
        StartHttpUtils.get(mActivity, this, Constant.VERIFY_CODE, map, BaseVO.class);
    }

    public void updatePwd() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("phoneNo", mPhoneEt.getText().toString());
        map.put("password", MD5.Md5(mPwdEt.getText().toString()));
        map.put("verifyCode", mCodeEt.getText().toString());
        StartHttpUtils.postCallBack(mActivity, Constant.UPDATE_PASSWORD, map, BaseVO.class, this);

    }

    @Override
    public void success(BaseVO vo) {
        this.finish();
    }
}
