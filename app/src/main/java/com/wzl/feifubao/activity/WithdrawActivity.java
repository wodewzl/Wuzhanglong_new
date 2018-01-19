package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;

public class WithdrawActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private TextView mOkTv;
    private EditText mEt01, mEt02, mEt03, mEt04, mEt05;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_withdraw);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("提现");
        mOkTv = getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.colorAccent, R.color.colorAccent));
        mEt01 = getViewById(R.id.et_01);
        mEt02 = getViewById(R.id.et_02);
        mEt03 = getViewById(R.id.et_03);
        mEt04 = getViewById(R.id.et_04);
        mEt05 = getViewById(R.id.et_05);
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

                commit();
                break;
            default:
                break;
        }
    }

    public void commit() {
        HashMap<String, Object> map = new HashMap<>();
        if (TextUtils.isEmpty(mEt01.getText().toString())) {
            showCustomToast("请填写持卡人");
            return;
        }
        if (TextUtils.isEmpty(mEt02.getText().toString())) {
            showCustomToast("请填手机号");
            return;
        }
        if (TextUtils.isEmpty(mEt03.getText().toString())) {
            showCustomToast("请填写支行名称");
            return;
        }
        if (TextUtils.isEmpty(mEt04.getText().toString())) {
            showCustomToast("请填写银行卡号");
            return;
        }
        if (TextUtils.isEmpty(mEt05.getText().toString())) {
            showCustomToast("请填写提现金额");
            return;
        }
        showProgressDialog();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("cash", mEt05.getText().toString());
        map.put("bank_name", mEt03.getText().toString());
        map.put("realname", mEt01.getText().toString());
        map.put("account_number", mEt04.getText().toString());
        map.put("mobile", mEt02.getText().toString());
        HttpGetDataUtil.post(this, Constant.WITHDRAW_URL, map, this);
    }

    @Override
    public void success(BaseVO vo) {
        showCustomToast(vo.getMessage());
        EventBus.getDefault().post(new EBMessageVO("over_update"));
        this.finish();
    }


}
