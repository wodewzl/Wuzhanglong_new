package com.maitian.starmily.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maitian.starmily.R;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.UserInfoVO;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private ImageView mLoginWeixinIv, mLoginQqIv, mLoginXinLangIv;
    private TextView mLoginTv, mRegistTv,mTouristModeTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.login_activity);
    }

    @Override
    public void initView() {
        mBaseHeadLayout.setVisibility(View.GONE);
        mLoginWeixinIv = getViewById(R.id.login_weixin_iv);
        mLoginQqIv = getViewById(R.id.login_qq_iv);
        mLoginTv = getViewById(R.id.login_tv);
        mRegistTv = getViewById(R.id.regist_tv);
        mLoginXinLangIv = getViewById(R.id.login_xinlang_iv);
        mTouristModeTv=getViewById(R.id.tourist_mode_tv);
    }

    @Override
    public void bindViewsListener() {
        mLoginWeixinIv.setOnClickListener(this);
        mLoginQqIv.setOnClickListener(this);
        mLoginTv.setOnClickListener(this);
        mRegistTv.setOnClickListener(this);
        mLoginXinLangIv.setOnClickListener(this);
        mTouristModeTv.setOnClickListener(this);
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
        UMShareAPI shareAPI = UMShareAPI.get(mActivity);
        switch (v.getId()) {
            case R.id.login_weixin_iv:
                shareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.WEIXIN, new UMShareListener());
                break;
            case R.id.login_qq_iv:
                shareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.QQ, new UMShareListener());
                break;
            case R.id.login_xinlang_iv:
                shareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.SINA, new UMShareListener());

                break;
            case R.id.login_tv:
                openActivity(LoginPhoneActivity.class);
                break;
            case R.id.regist_tv:
                openActivity(RegistActivity.class);
                break;
            case R.id.tourist_mode_tv:
//                AppApplication.getInstance().saveUserInfoVO(null);
//                openActivity(MainActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    public void success(BaseVO vo) {
        UserInfoVO userInfoVO = (UserInfoVO) vo;
        if (userInfoVO.getObj() != null) {
            AppApplication.getInstance().saveUserInfoVO(userInfoVO);
            if (userInfoVO.getObj().getIdolType() == 0) {
                openActivity(RiceCircleStarActivity.class);
            }else {
//                openActivity(MainActivity.class);
                openActivity(RiceCircleStarActivity.class);
            }
            this.finish();
        }
    }

    class UMShareListener implements Serializable, UMAuthListener {
        /**
         * @param platform 平台名称
         * @desc 授权开始的回调
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
            System.out.println("=============>");
        }

        /**
         * @param platform 平台名称
         * @param action   行为序号，开发者用不上
         * @param data     用户资料返回
         * @desc 授权成功的回调
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            HashMap<String, Object> map = new HashMap<>();
            if (platform == SHARE_MEDIA.WEIXIN) {
                map.put("loginType", "2");
                map.put("nickname", data.get("name"));
                map.put("iconUrl", data.get("iconurl"));
                map.put("wechatNo", data.get("uid"));
                map.put("accessToken", data.get("access_token"));
            } else if (platform == SHARE_MEDIA.QQ) {
                map.put("loginType", "3");
                map.put("nickname", data.get("name"));
                map.put("iconUrl", data.get("iconurl"));
                map.put("qqNo", data.get("uid"));
                map.put("accessToken", data.get("access_token"));
            }
            otherLogin(map);
        }

        /**
         * @param platform 平台名称
         * @param action   行为序号，开发者用不上
         * @param t        错误原因
         * @desc 授权失败的回调
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            mActivity.showFailToast("登录失败");
        }

        /**
         * @param platform 平台名称
         * @param action   行为序号，开发者用不上
         * @desc 授权取消的回调
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            mActivity.showCustomToast("登录取消");
        }
    }

    public void otherLogin(HashMap<String, Object> map) {
        StartHttpUtils.postCallBack(mActivity, Constant.REG_AND_LOG, map, UserInfoVO.class, this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }
}
