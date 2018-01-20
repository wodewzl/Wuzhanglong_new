package com.wzl.feifubao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.fragment.TabOneFragment;
import com.wzl.feifubao.fragment.TabThreeFragment;
import com.wzl.feifubao.fragment.TabTwoFragment;
import com.wzl.feifubao.mode.UserInfoVO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

public class LoginActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private TextView mPhoneTv, mPasswordTv, mOkTv, mRegistTv, mForgetTv;


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
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.colorAccent, R.color.colorAccent));
        mRegistTv = getViewById(R.id.regist_tv);
        mForgetTv = getViewById(R.id.forget_tv);
    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
        mRegistTv.setOnClickListener(this);
        mForgetTv.setOnClickListener(this);
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

                if (TextUtils.isEmpty(mPhoneTv.getText().toString())) {
                    showCustomToast("请输入手机号");
                    return;
                }
                if (TextUtils.isEmpty(mPasswordTv.getText().toString())) {
                    showCustomToast("请输入密码");
                    return;
                }

                commit();
                break;

            case R.id.regist_tv:

                openActivity(RegistActivity.class);
                break;
            case R.id.forget_tv:
                Bundle bundle = new Bundle();
                bundle.putString("type", "2");
                open(RegistActivity.class, bundle, 0);
                break;
            default:
                break;
        }
    }


    public void commit() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username", mPhoneTv.getText().toString());
        map.put("password", mPasswordTv.getText().toString());
        HttpGetDataUtil.post(this, Constant.LOGIN_URL, map, UserInfoVO.class, this);
    }

    @Override
    public void success(BaseVO vo) {
        UserInfoVO userInfoVO = (UserInfoVO) vo;
        if (userInfoVO.getData() != null) {
            JPushInterface.setAlias(LoginActivity.this, userInfoVO.getData().getUid(), new TagAliasCallback() {
                @Override
                public void gotResult(int i, String s, Set<String> set) {
                }
            });

            AppApplication.getInstance().saveUserInfoVO(userInfoVO);
            List<BaseFragment> list = new ArrayList<>();
            TabOneFragment one = new TabOneFragment();
            TabTwoFragment two = new TabTwoFragment();
            TabThreeFragment three = new TabThreeFragment();
            list.add(one);
//            list.add(two);
            list.add(three);
            Intent intent = new Intent();
            intent.putExtra("fragment_list", (Serializable) list);
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        }
    }
}
