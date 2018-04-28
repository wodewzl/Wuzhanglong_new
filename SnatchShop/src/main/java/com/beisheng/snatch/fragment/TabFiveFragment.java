package com.beisheng.snatch.fragment;


import android.os.Build;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.AddressActivity;
import com.beisheng.snatch.activity.BuyFlowActivity;
import com.beisheng.snatch.activity.HelpActivity;
import com.beisheng.snatch.activity.MyBuyRecordActivity;
import com.beisheng.snatch.activity.MyCollectActivity;
import com.beisheng.snatch.activity.MyFlowActivity;
import com.beisheng.snatch.activity.MyLuckyRecordActivity;
import com.beisheng.snatch.activity.MyMessageActivity;
import com.beisheng.snatch.activity.MyRedMoneyActivity;
import com.beisheng.snatch.activity.MyScortActivity;
import com.beisheng.snatch.activity.MyShowActivity;
import com.beisheng.snatch.activity.RechargeRecordActivity;
import com.beisheng.snatch.activity.SettingActivity;
import com.beisheng.snatch.activity.UserInfoActivity;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.UserInfoVO;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.CheckBox;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.BottomDialogUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class TabFiveFragment extends BaseFragment implements View.OnClickListener, PostCallback, Serializable {
    private ImageView mMessageImg, mSettingImg;
    private TextView mItem01Tv, mItem02Tv, mItem03Tv, mItem04Tv, mItem05Tv, mItem06Tv, mItem07Tv;
    private TextView mBuyFlowTv;
    private LinearLayout mMyFlowLayout, mMyRedMoneyLayout, mMyScortLayout;
    private CircleImageView mHeadImg;
    private TextView mFlowTv, mRedTv, mScortTv, mNameTv, mUserNoTv;
    private CheckBox mRegistCheckBox;

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

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_five_fragment);
    }

    @Override
    public void initView(View view) {
        mMessageImg = getViewById(R.id.msg_img);
        mSettingImg = getViewById(R.id.setting_img);
        mMyFlowLayout = getViewById(R.id.my_flow_layout);
        mMyRedMoneyLayout = getViewById(R.id.my_red_money_layout);
        mMyScortLayout = getViewById(R.id.my_red_scort_layout);
        mItem01Tv = getViewById(R.id.item_01_tv);
        mItem02Tv = getViewById(R.id.item_02_tv);
        mItem03Tv = getViewById(R.id.item_03_tv);
        mItem04Tv = getViewById(R.id.item_04_tv);
        mItem05Tv = getViewById(R.id.item_05_tv);
        mItem06Tv = getViewById(R.id.item_06_tv);
        mItem07Tv = getViewById(R.id.item_07_tv);
        mBuyFlowTv = getViewById(R.id.buy_flow_tv);
        mBuyFlowTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 5, R.color.C1, R.color.color_black));
        mHeadImg = getViewById(R.id.head_img);
        mFlowTv = getViewById(R.id.flow_tv);
        mRedTv = getViewById(R.id.red_tv);
        mScortTv = getViewById(R.id.scort_tv);
        mNameTv = getViewById(R.id.name_tv);
        mUserNoTv = getViewById(R.id.user_no_tv);
        mBuyCountTv = getViewById(R.id.buy_count_tv);
    }

    @Override
    public void bindViewsListener() {
        mMessageImg.setOnClickListener(this);
        mSettingImg.setOnClickListener(this);
        mMyFlowLayout.setOnClickListener(this);
        mMyRedMoneyLayout.setOnClickListener(this);
        mMyScortLayout.setOnClickListener(this);
        mItem01Tv.setOnClickListener(this);
        mItem02Tv.setOnClickListener(this);
        mItem03Tv.setOnClickListener(this);
        mItem04Tv.setOnClickListener(this);
        mItem05Tv.setOnClickListener(this);
        mItem06Tv.setOnClickListener(this);
        mItem07Tv.setOnClickListener(this);
        mBuyFlowTv.setOnClickListener(this);
        mHeadImg.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }


    @Override
    public void getData() {
        if (AppApplication.getInstance().getUserInfoVO() != null) {
            HashMap<String, Object> map = new HashMap<>();
            if (AppApplication.getInstance().getUserInfoVO() != null)
                map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
            BSHttpUtils.post(mActivity, this, Constant.MY_CENTER_URL, map, UserInfoVO.class);
        } else {
            showView();
        }

    }

    @Override
    public void hasData(BaseVO vo) {
        mUserInfoVO = (UserInfoVO) vo;
        AppApplication.getInstance().saveUserInfoVO(mUserInfoVO);
        if (!TextUtils.isEmpty(mUserInfoVO.getData().getAvatar()))
            Picasso.with(mActivity).load(mUserInfoVO.getData().getAvatar()).into(mHeadImg);
        mNameTv.setText(mUserInfoVO.getData().getNickname());
        mUserNoTv.setText("ID:" + mUserInfoVO.getData().getUser_no());
        mFlowTv.setText(mUserInfoVO.getData().getFlow());
        mRedTv.setText(mUserInfoVO.getData().getCoupon_count());
        mScortTv.setText(mUserInfoVO.getData().getPoint());

        BaseCommonUtils.setTextThree(mActivity, mBuyCountTv, "抢购次数：", mUserInfoVO.getData().getBalance(), "次", R.color.colorAccent, 1.1f);
    }

    @Override
    public void noData(BaseVO vo) {
        showView();
    }

    @Override
    public void noNet() {

    }


    @Override
    public void onClick(View v) {
        UMShareAPI shareAPI = UMShareAPI.get(mActivity);
        if (v.getId() == R.id.head_img
                || v.getId() == R.id.msg_img
                || v.getId() == R.id.my_flow_layout
                || v.getId() == R.id.my_red_money_layout
                || v.getId() == R.id.my_red_scort_layout
                || v.getId() == R.id.item_01_tv
                || v.getId() == R.id.item_02_tv
                || v.getId() == R.id.item_03_tv
                || v.getId() == R.id.item_04_tv
                || v.getId() == R.id.item_05_tv
                || v.getId() == R.id.item_06_tv
                || v.getId() == R.id.item_07_tv
                || v.getId() == R.id.buy_flow_tv) {
            if (AppApplication.getInstance().getUserInfoVO() == null) {
                mLoginTypeDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.login_type);
                mLoginTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.login_tv);
                mRegistTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.regist_tv);
                mLoginWeixinTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.login_weixin_tv);
                mLoginQqTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.login_qq_tv);
                mLoginTv.setOnClickListener(this);
                mRegistTv.setOnClickListener(this);
                mLoginWeixinTv.setOnClickListener(this);
                mLoginQqTv.setOnClickListener(this);
                return;
            }
        }
        switch (v.getId()) {
            case R.id.head_img:
                mActivity.openActivity(UserInfoActivity.class);
                break;
            case R.id.msg_img:
                mActivity.openActivity(MyMessageActivity.class);
                break;
            case R.id.setting_img:
                mActivity.openActivity(SettingActivity.class);
                break;
            case R.id.my_flow_layout:
                mActivity.openActivity(MyFlowActivity.class);
                break;
            case R.id.my_red_money_layout:
                mActivity.openActivity(MyRedMoneyActivity.class);
                break;
            case R.id.my_red_scort_layout:
                mActivity.openActivity(MyScortActivity.class);
                break;
            case R.id.item_01_tv:
                mActivity.openActivity(MyBuyRecordActivity.class);
                break;
            case R.id.item_02_tv:
                mActivity.openActivity(MyLuckyRecordActivity.class);
                break;
            case R.id.item_03_tv:
                mActivity.openActivity(RechargeRecordActivity.class);
                break;
            case R.id.item_04_tv:
                mActivity.openActivity(MyShowActivity.class);
                break;
            case R.id.item_05_tv:
                mActivity.openActivity(MyCollectActivity.class);
                break;
            case R.id.item_06_tv:
                mActivity.openActivity(AddressActivity.class);
                break;
            case R.id.item_07_tv:
                mActivity.openActivity(HelpActivity.class);
                break;
            case R.id.buy_flow_tv:
                mActivity.openActivity(BuyFlowActivity.class);
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


    public void otherLogin(String openid, String nickname, String headpicurl) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", mOhterLoginType);
        map.put("openid", openid);
        map.put("nickname", nickname);
        map.put("platform", "1");
        map.put("headpicurl", headpicurl);
        BSHttpUtils.postCallBack(mActivity, Constant.LOGIN_OTHER_URL, map, UserInfoVO.class, this);
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


    @Override
    public void success(BaseVO vo) {
        if ("2".equals(mSuccessType)) {
            mActivity.showSuccessToast(vo.getDesc());
            mUserInfoVO = (UserInfoVO) vo;
            AppApplication.getInstance().saveUserInfoVO(mUserInfoVO);
            getData();
            if (mRegistDialog != null)
                mRegistDialog.dismiss();
            if (mLoginDialog != null)
                mLoginDialog.dismiss();
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {
        if ("login_out".equals(event.getMessage())) {
            mNameTv.setText("登录/注册");
            mUserNoTv.setText("ID:");
            mFlowTv.setText("0");
            mRedTv.setText("0");
            mScortTv.setText("0");
            BaseCommonUtils.setTextThree(mActivity, mBuyCountTv, "购买次数：", "0", "次", R.color.colorAccent, 1.1f);
        } else if ("update_userinfo".equals(event.getMessage())) {
            getData();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
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
}
