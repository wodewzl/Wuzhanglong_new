package com.beisheng.snatch.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.DailyTaskDetailVO;
import com.beisheng.snatch.model.UserInfoVO;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.CheckBox;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.BottomDialogUtil;
import com.wuzhanglong.library.utils.ShareUtil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class DailyTaskDetailActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private ImageView mTaskImg;
    private TextView mBuyTv, mTv01, mTv02, mTv03, mTv04, mRuleTv;
    private TextView mStatusTv,mFinishTv;
    private DailyTaskDetailVO mDailyTaskDetailVO;

    //登录
    private BottomSheetDialog mRegistDialog, mLoginTypeDialog, mLoginDialog, mBackPwdDialog, mBindPhoneDialog;
    private View mLoginPasswrodLayout, mLoginMsgLayout;
    private TextView mRegistOkTv, mRegistGetMsgCodeTv, mLoginOkTv, mLoginBackPasswordTv, mLoginChangeLoginTypeTv, mLoginTypeTv, mLoginMsgPhoneEt, mLoginMsgCodeEt, mLoginMsgGetCodeTv,
            mLoginBindPhoneTv, mBackPwdTv, mBuyCountTv;
    private EditText mRegistCodeEt, mRegistPhoneEt, mRegistPaswrodEt, mLoginPhoneEt, mLoginPasswordEt, mBackPwdSureEt;
    private boolean mRegistCodeStae = true;
    private String mSuccessType = "";//1注册验证码2注册3手机号登陆4短信登陆5加入购物车//6威信登录7QQ登录
    private String mLoginType = "1";//1手机号登陆2短信登陆
    private String mOhterLoginType = "1";//1微信2QQ
    private TextView mLoginTv, mRegistTv, mLoginWeixinTv, mLoginQqTv;
    private UserInfoVO mUserInfoVO;
    private CheckBox mRegistCheckBox;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.daily_task_detail_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("任务详情");
        mTaskImg = getViewById(R.id.img);
        mBuyTv = getViewById(R.id.buy_tv);
        mTv01 = getViewById(R.id.tv_01);
        mTv02 = getViewById(R.id.tv_02);
        mTv03 = getViewById(R.id.tv_03);
        mTv04 = getViewById(R.id.tv_04);
        mRuleTv = getViewById(R.id.rule_tv);
        mStatusTv = getViewById(R.id.buy_tv);
    }

    @Override
    public void bindViewsListener() {
        mStatusTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.getIntent().getStringExtra("id"));
        BSHttpUtils.get(mActivity, this, Constant.DAILY_TASK_DETAIL_URL, map, DailyTaskDetailVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        mDailyTaskDetailVO = (DailyTaskDetailVO) vo;
        if (!TextUtils.isEmpty(mDailyTaskDetailVO.getData().getTask_icon()))
            Picasso.with(this).load(mDailyTaskDetailVO.getData().getTask_icon()).into(mTaskImg);
        mTv01.setText(mDailyTaskDetailVO.getData().getTask_name());
        mTv02.setText("任务性质：" + mDailyTaskDetailVO.getData().getTask_type());
        BaseCommonUtils.setTextTwoLast(this, mTv03, "奖励积分：", "+" + mDailyTaskDetailVO.getData().getGive_points(), R.color.colorAccent, 1.3f);
        BaseCommonUtils.setTextTwoLast(this, mTv04, "完成情况：", mDailyTaskDetailVO.getData().getUser_do_count() + "/" + mDailyTaskDetailVO.getData().getDo_count(), R.color.colorAccent, 1.3f);
        mRuleTv.setText(mDailyTaskDetailVO.getData().getContent());
        if(mDailyTaskDetailVO.getData().getUser_do_count().equals(mDailyTaskDetailVO.getData().getDo_count())){
            mStatusTv.setText("已经完成");
        }
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        UMShareAPI shareAPI = UMShareAPI.get(mActivity);
        switch (v.getId()) {
            case R.id.buy_tv:
                if ("1".equals(mDailyTaskDetailVO.getData().getEvent_id())) {
                    login();
                } else if ("2".equals(mDailyTaskDetailVO.getData().getEvent_id()) || "11".equals(mDailyTaskDetailVO.getData().getEvent_id())) {
                    openActivity(HomeActivity.class);
                } else if ("3".equals(mDailyTaskDetailVO.getData().getEvent_id())) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest
                                .permission
                                .READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW,
                                Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
                        ActivityCompat.requestPermissions(this, mPermissionList, 123);
                    } else {
                        String title = ACache.get(mActivity).getAsString("share_title");
                        String desc = ACache.get(mActivity).getAsString("share_desc");
                        String img = ACache.get(mActivity).getAsString("share_img");
                        String url = ACache.get(mActivity).getAsString("share_url");
                        ShareUtil.share(this, img, title, desc, url);
                    }
                } else if ("4".equals(mDailyTaskDetailVO.getData().getEvent_id()) || "12".equals(mDailyTaskDetailVO.getData().getEvent_id())) {
                    openActivity(HomeActivity.class);

                } else if ("5".equals(mDailyTaskDetailVO.getData().getEvent_id()) || "13".equals(mDailyTaskDetailVO.getData().getEvent_id())) {
                    openActivity(MyLuckyRecordActivity.class);
                } else if ("6".equals(mDailyTaskDetailVO.getData().getEvent_id()) || "14".equals(mDailyTaskDetailVO.getData().getEvent_id())) {
                    openActivity(BuyFlowActivity.class);
                } else if ("7".equals(mDailyTaskDetailVO.getData().getEvent_id())) {
                    login();
                } else if ("8".equals(mDailyTaskDetailVO.getData().getEvent_id())) {
                    login();
                } else if ("9".equals(mDailyTaskDetailVO.getData().getEvent_id())) {

                } else if ("10".equals(mDailyTaskDetailVO.getData().getEvent_id())) {
                    if (Build.VERSION.SDK_INT >= 23) {
                        String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest
                                .permission
                                .READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW,
                                Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
                        ActivityCompat.requestPermissions(this, mPermissionList, 123);
                    } else {
                        String title = ACache.get(mActivity).getAsString("share_title");
                        String desc = ACache.get(mActivity).getAsString("share_desc");
                        String img = ACache.get(mActivity).getAsString("share_img");
                        String url = ACache.get(mActivity).getAsString("share_url");
                        ShareUtil.share(this, img, title, desc, url);
                    }
                } else if ("11".equals(mDailyTaskDetailVO.getData().getEvent_id())) {

                } else if ("12".equals(mDailyTaskDetailVO.getData().getEvent_id())) {

                }
                break;

            case R.id.regist_get_msge_code_tv:

                if (mRegistCodeStae) {
                    if (TextUtils.isEmpty(mRegistPhoneEt.getText().toString())) {
                        mActivity.showCustomToast("请填写手机号");
                        return;
                    }
                    HashMap<String, Object> registMsgMap = new HashMap<>();
                    registMsgMap.put("mobile", mRegistPhoneEt.getText().toString());
                    if ("8".equals(mSuccessType)) {
                        registMsgMap.put("type", "5");// 1-注册验证码 2-验证码登录 3-修改密码 4-绑定手机号 5-忘记密码
                    } else {
                        registMsgMap.put("type", "1");// 1-注册验证码 2-验证码登录 3-修改密码
                    }
                    mRegistGetMsgCodeTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 30, R.color.C6, R.color.C6));
                    BSHttpUtils.postCallBack(mActivity, Constant.GET_MSG_CODE_URL, registMsgMap, BaseVO.class, this);
                    daoJishi(mRegistGetMsgCodeTv);
                    mRegistCodeStae = false;
                }

                break;

            case R.id.register_ok_tv:
                if (TextUtils.isEmpty(mRegistPhoneEt.getText().toString())) {
                    mActivity.showCustomToast("请填写手机号");
                    return;
                }
                if (TextUtils.isEmpty(mRegistCodeEt.getText().toString())) {
                    mActivity.showCustomToast("请填验证码");
                    return;
                }
                if (TextUtils.isEmpty(mRegistPaswrodEt.getText().toString())) {
                    mActivity.showCustomToast("请填写注册密码");
                    return;
                }

                if (!mRegistCheckBox.isChecked()) {
                    mActivity.showCustomToast("请同意服务条款与隐私相关权限");
                    return;
                }
                mSuccessType = "2";
                HashMap<String, Object> registMap = new HashMap<>();
                registMap.put("mobile", mRegistPhoneEt.getText().toString());
                registMap.put("sms_code", mRegistCodeEt.getText().toString());
                registMap.put("password", mRegistPaswrodEt.getText().toString());
                registMap.put("platform", "1");

                BSHttpUtils.postCallBack(mActivity, Constant.REGIST_URL, registMap, BaseVO.class, this);
                break;

            case R.id.login_back_passwrod_tv:
                mBackPwdDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.login__back_pwd);
                mRegistCodeEt = mBackPwdDialog.findViewById(R.id.regist_msg_et);
                mRegistPhoneEt = mBackPwdDialog.findViewById(R.id.regist_phone_et);
                mRegistPaswrodEt = mBackPwdDialog.findViewById(R.id.regist_password_et);
                mRegistCheckBox = mBackPwdDialog.findViewById(R.id.regist_check_box);
                mBackPwdTv = mBackPwdDialog.findViewById(R.id.back_pwd_tv);
                mBackPwdSureEt = mBackPwdDialog.findViewById(R.id.sure_password_et);
                mRegistGetMsgCodeTv = mBackPwdDialog.findViewById(R.id.regist_get_msge_code_tv);
                mRegistGetMsgCodeTv.setOnClickListener(this);
                mBackPwdTv.setOnClickListener(this);
                mSuccessType = "8";
                break;
            case R.id.login_change_login_type_tv:
                if ("1".equals(mLoginType)) {
                    mLoginType = "2";
                    mLoginMsgLayout.setVisibility(View.VISIBLE);
                    mLoginPasswrodLayout.setVisibility(View.GONE);
                    mLoginChangeLoginTypeTv.setText("使用短信登陆");
                } else {
                    mLoginType = "1";
                    mLoginMsgLayout.setVisibility(View.GONE);
                    mLoginPasswrodLayout.setVisibility(View.VISIBLE);
                    mLoginChangeLoginTypeTv.setText("使用密码登陆");
                }

                break;
            case R.id.login_ok_tv:
                if ("2".equals(mLoginType)) {
                    if (TextUtils.isEmpty(mLoginMsgPhoneEt.getText().toString())) {
                        mActivity.showCustomToast("请填写手机号");
                        return;
                    }

                    if (TextUtils.isEmpty(mLoginMsgCodeEt.getText().toString())) {
                        mActivity.showCustomToast("请填验证码");
                        return;
                    }

                } else {
                    if (TextUtils.isEmpty(mLoginPhoneEt.getText().toString())) {
                        mActivity.showCustomToast("请填写手机号");
                        return;
                    }
                    if (TextUtils.isEmpty(mLoginPasswordEt.getText().toString())) {
                        mActivity.showCustomToast("请填写注册密码");
                        return;
                    }
                }

                HashMap<String, Object> loginMap = new HashMap<>();
                if ("1".equals(mLoginType)) {
                    loginMap.put("username", mLoginPhoneEt.getText().toString());
                    loginMap.put("password", mLoginPasswordEt.getText().toString());
                    BSHttpUtils.postCallBack(mActivity, Constant.LOGIN_PASSWORD_URL, loginMap, UserInfoVO.class, this);
                    mSuccessType = "3";
                } else {
                    loginMap.put("mobile", mLoginMsgPhoneEt.getText().toString());
                    loginMap.put("sms_code", mLoginMsgCodeEt.getText().toString());
                    BSHttpUtils.postCallBack(mActivity, Constant.LOGIN_MSG_URL, loginMap, UserInfoVO.class, this);
                    mSuccessType = "4";
                }

                break;

            case R.id.login_get_msg_code_tv:
                if (mRegistCodeStae) {
                    if (TextUtils.isEmpty(mLoginMsgPhoneEt.getText().toString())) {
                        mActivity.showCustomToast("请填写手机号");
                        return;
                    }
                    HashMap<String, Object> registMsgMap = new HashMap<>();
                    registMsgMap.put("mobile", mLoginMsgPhoneEt.getText().toString());
                    if ("9".equals(mSuccessType)) {
                        registMsgMap.put("type", "4");// 1-注册验证码 2-验证码登录 3-修改密码 4-绑定手机号 5-忘记密码
                    } else {
                        registMsgMap.put("type", "2");// 1-注册验证码 2-验证码登录 3-修改密码
                    }
                    mLoginMsgGetCodeTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 30, R.color.C6, R.color.C6));
                    BSHttpUtils.postCallBack(mActivity, Constant.GET_MSG_CODE_URL, registMsgMap, BaseVO.class, this);
                    daoJishi(mLoginMsgGetCodeTv);
                    mRegistCodeStae = false;
                }
                break;
            case R.id.login_tv:
                mLoginType = "1";
                mSuccessType = "1";
                mLoginDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.login_layout);
                mLoginPhoneEt = mLoginDialog.findViewById(R.id.login_phone_et);
                mLoginPasswordEt = mLoginDialog.findViewById(R.id.login_password_et);
                mLoginBackPasswordTv = mLoginDialog.findViewById(R.id.login_back_passwrod_tv);
                mLoginChangeLoginTypeTv = mLoginDialog.findViewById(R.id.login_change_login_type_tv);
                mLoginOkTv = mLoginDialog.findViewById(R.id.login_ok_tv);
                mLoginPasswrodLayout = mLoginDialog.findViewById(R.id.login_passwrod_layout);
                mLoginMsgLayout = mLoginDialog.findViewById(R.id.Login_msg_layout);
                mLoginTypeTv = mLoginDialog.findViewById(R.id.login_type_tv);
                mLoginMsgPhoneEt = mLoginDialog.findViewById(R.id.login_msg_phone_et);
                mLoginMsgCodeEt = mLoginDialog.findViewById(R.id.login_msg_code_et);
                mLoginMsgGetCodeTv = mLoginDialog.findViewById(R.id.login_get_msg_code_tv);
                mLoginMsgGetCodeTv.setOnClickListener(this);
                mLoginChangeLoginTypeTv.setOnClickListener(this);
                mLoginBackPasswordTv.setOnClickListener(this);
                mLoginOkTv.setOnClickListener(this);
                break;
            case R.id.regist_tv:
                System.out.println("=========>");
                mRegistDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.login_regist);
                mRegistCodeEt = mRegistDialog.findViewById(R.id.regist_msg_et);
                mRegistPhoneEt = mRegistDialog.findViewById(R.id.regist_phone_et);
                mRegistPaswrodEt = mRegistDialog.findViewById(R.id.regist_password_et);
                mRegistCheckBox = mRegistDialog.findViewById(R.id.regist_check_box);
                mRegistOkTv = mRegistDialog.findViewById(R.id.register_ok_tv);
                mRegistGetMsgCodeTv = mRegistDialog.findViewById(R.id.regist_get_msge_code_tv);
                mRegistGetMsgCodeTv.setOnClickListener(this);
                mRegistOkTv.setOnClickListener(this);
                break;

            case R.id.login_weixin_tv:
                mOhterLoginType = "1";
                shareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.WEIXIN, new UMShareListener());

                break;
            case R.id.login_qq_tv:
                mOhterLoginType = "2";
                shareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.QQ, new UMShareListener());
                break;

            case R.id.login_bind_phone_tv:
                if (TextUtils.isEmpty(mLoginMsgPhoneEt.getText().toString())) {
                    mActivity.showCustomToast("请填写手机号");
                    return;
                }

                if (TextUtils.isEmpty(mLoginMsgCodeEt.getText().toString())) {
                    mActivity.showCustomToast("请填验证码");
                    return;
                }
                HashMap<String, Object> bindPhoneMap = new HashMap<>();
                bindPhoneMap.put("mobile", mLoginMsgPhoneEt.getText().toString());
                bindPhoneMap.put("sms_code", mLoginMsgCodeEt.getText().toString());
                bindPhoneMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                BSHttpUtils.postCallBack(mActivity, Constant.LOGIN_BIND_PHONE_URL, bindPhoneMap, UserInfoVO.class, this);
                mSuccessType = "11";
                break;

            case R.id.back_pwd_tv:
                if (TextUtils.isEmpty(mRegistPhoneEt.getText().toString())) {
                    mActivity.showCustomToast("请填写手机号");
                    return;
                }
                if (TextUtils.isEmpty(mRegistCodeEt.getText().toString())) {
                    mActivity.showCustomToast("请填验证码");
                    return;
                }
                if (TextUtils.isEmpty(mRegistPaswrodEt.getText().toString())) {
                    mActivity.showCustomToast("请填写新的密码");
                    return;
                }
                if (TextUtils.isEmpty(mBackPwdSureEt.getText().toString())) {
                    mActivity.showCustomToast("请确认密码");
                    return;
                }

                if (!mRegistPaswrodEt.getText().toString().equals(mBackPwdSureEt.getText().toString())) {
                    mActivity.showCustomToast("密码不一致");
                    return;
                }


                mSuccessType = "10";
                HashMap<String, Object> backMap = new HashMap<>();
                backMap.put("mobile", mRegistPhoneEt.getText().toString());
                backMap.put("sms_code", mRegistCodeEt.getText().toString());
                backMap.put("password", mRegistPaswrodEt.getText().toString());
                backMap.put("repassword", mBackPwdSureEt.getText().toString());

                BSHttpUtils.postCallBack(mActivity, Constant.BACK_PWD_URL, backMap, BaseVO.class, this);
                break;
            default:
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        String title = ACache.get(mActivity).getAsString("share_title");
        String desc = ACache.get(mActivity).getAsString("share_desc");
        String img = ACache.get(mActivity).getAsString("share_img");
        String url = ACache.get(mActivity).getAsString("share_url");
        ShareUtil.share(this, img, title, desc, url);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    public void otherLogin(String openid, String nickname, String headpicurl) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", mOhterLoginType);
        map.put("openid", openid);
        map.put("nickname", nickname);
        map.put("platform", "1");
        map.put("headpicurl", headpicurl);
        BSHttpUtils.postCallBack(mActivity, Constant.LOGIN_OTHER_URL, map, UserInfoVO.class, this);
    }

    @Override
    public void success(BaseVO vo) {
        if ("2".equals(mSuccessType)) {
            mActivity.showSuccessToast(vo.getDesc());
            mRegistDialog.dismiss();
        } else if ("3".equals(mSuccessType) || "4".equals(mSuccessType) || "6".equals(mSuccessType) || "7".equals(mSuccessType)) {
            mActivity.showSuccessToast(vo.getDesc());
            mUserInfoVO = (UserInfoVO) vo;
            if (!"1".equals(mUserInfoVO.getData().getUser_tel_bind())) {
                bindPhone();
            } else {
                if (mLoginDialog != null)
                    mLoginDialog.dismiss();
                if (mLoginTypeDialog != null)
                    mLoginTypeDialog.dismiss();
                AppApplication.getInstance().saveUserInfoVO(mUserInfoVO);
                getData();
            }

        } else if ("8".equals(mSuccessType)) {
            //忘记密码发送验证码
            mActivity.showSuccessToast(vo.getDesc());
        } else if ("10".equals(mSuccessType)) {
            //忘记密码
            mActivity.showSuccessToast(vo.getDesc());
        } else if ("9".equals(mSuccessType)) {
            //绑定手机号
            if (mBindPhoneDialog != null)
                mBindPhoneDialog.dismiss();
            AppApplication.getInstance().saveUserInfoVO(mUserInfoVO);
            getData();
        } else if ("11".equals(mSuccessType)) {
            if (mBackPwdDialog != null)
                mBackPwdDialog.dismiss();
            if (mLoginDialog != null)
                mLoginDialog.dismiss();
            if (mLoginTypeDialog != null)
                mLoginTypeDialog.dismiss();
        }
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
            if (platform == SHARE_MEDIA.WEIXIN) {
                mSuccessType = "6";
            } else {
                mSuccessType = "7";
            }
            otherLogin(data.get("uid"), data.get("name"), data.get("iconurl"));
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

    public void daoJishi(final TextView tv) {
        final CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long arg0) {
                tv.setText(arg0 / 1000 + "s后重发 ");
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onFinish() {
                tv.setText("获取验证码");
                mRegistCodeStae = true;
                tv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 30, R.color.color_yellow, R.color.color_yellow));
            }
        };
        timer.start();
    }

    public void bindPhone() {
        mSuccessType = "9";
        mBindPhoneDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.login_bind_phone);
        mLoginMsgPhoneEt = mBindPhoneDialog.findViewById(R.id.login_msg_phone_et);
        mLoginMsgCodeEt = mBindPhoneDialog.findViewById(R.id.login_msg_code_et);
        mLoginMsgGetCodeTv = mBindPhoneDialog.findViewById(R.id.login_get_msg_code_tv);
        mLoginBindPhoneTv = mBindPhoneDialog.findViewById(R.id.login_bind_phone_tv);
        mLoginMsgGetCodeTv.setOnClickListener(this);
        mLoginBindPhoneTv.setOnClickListener(this);
    }

    public void login() {
        if (AppApplication.getInstance().getUserInfoVO() != null)
            return;

        mLoginTypeDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.login_type);
        mLoginTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.login_tv);
        mRegistTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.regist_tv);
        mLoginWeixinTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.login_weixin_tv);
        mLoginQqTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.login_qq_tv);
        mLoginTv.setOnClickListener(this);
        mRegistTv.setOnClickListener(this);
        mLoginWeixinTv.setOnClickListener(this);
        mLoginQqTv.setOnClickListener(this);
    }
}
