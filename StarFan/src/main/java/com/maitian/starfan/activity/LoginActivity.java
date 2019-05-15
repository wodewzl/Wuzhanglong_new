package com.maitian.starfan.activity;

import android.view.View;
import android.widget.TextView;

import com.maitian.starfan.R;
import com.maitian.starfan.constant.Constant;
import com.maitian.starfan.model.UserInfoVO;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private TextView mLoginWeixinTv, mLoginQqTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.login_activity);
    }

    @Override
    public void initView() {
        mLoginWeixinTv = getViewById(R.id.login_weixin_tv);
        mLoginQqTv = getViewById(R.id.login_qq_tv);
    }

    @Override
    public void bindViewsListener() {
        mLoginWeixinTv.setOnClickListener(this);
        mLoginQqTv.setOnClickListener(this);
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
        UMShareAPI shareAPI = UMShareAPI.get(mActivity);
        switch (v.getId()) {
            case R.id.login_weixin_tv:
                shareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.WEIXIN, new UMShareListener());
                break;
            case R.id.login_qq_tv:
                shareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.QQ, new UMShareListener());

                break;
            default:
                break;
        }
    }

    @Override
    public void success(BaseVO vo) {

    }

    class UMShareListener implements Serializable, UMAuthListener {
        /**
         * @param platform 平台名称
         * @desc 授权开始的回调
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
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
//                mSuccessType = "6";
//        map.put("type", mOhterLoginType);
//                map.put("openid", openid);
//                map.put("nickname", nickname);
//                map.put("platform", "1");
//                map.put("headpicurl", headpicurl);
            } else {
//                mSuccessType = "7";
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

        BSHttpUtils.postCallBack(mActivity, Constant.REG_AND_LOG, map, UserInfoVO.class, this);
    }
}
