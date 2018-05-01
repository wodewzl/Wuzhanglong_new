package com.beisheng.snatch.fragment;


import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.DailyTaskActivity;
import com.beisheng.snatch.activity.KeywordActivity;
import com.beisheng.snatch.activity.SearchShopActivity;
import com.beisheng.snatch.activity.ShopCategoryActivity;
import com.beisheng.snatch.activity.ShopChoseActivity;
import com.beisheng.snatch.activity.SignActivity;
import com.beisheng.snatch.activity.WebViewActivity;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.HomeVO;
import com.beisheng.snatch.model.UserInfoVO;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.CheckBox;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.vondear.rxtools.view.RxTextviewVertical;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.BottomDialogUtil;
import com.wuzhanglong.library.utils.WidthHigthUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TabOneFragment extends BaseFragment implements View.OnClickListener,PostCallback{
    private String[] mTitleDataList = {"人气", "最新", "进度", "总需人次"};
    private ScrollableLayout mScrollableLayout;

    private RxTextviewVertical mRxText;
    private ViewPager mViewPager;
    private ArrayList<TabOneChildFragment> mFragmentList;
    private Banner mBanner;
    private ImageView mOneImg, mOrderImg, mSearchImg;
    private String mStatus = "4";//4为升序5为降序
    private TextView mMenu01Tv, mMenu02Tv, mMenu03Tv, mMenu04Tv;
    private ImageView mMenu01Img,mMenu02Img,mMenu03Img,mMenu04Img;
    private ImageView mSginImg;
    private LinearLayout mHeadLayout;
    private HomeVO mHomeVO;

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
    public void setContentView() {
        contentInflateView(R.layout.tab_one_fragment);
    }

    @Override
    public void initView(View view) {
        mActivity.mBaseHeadLayout.setVisibility(View.GONE);
        mBanner = getViewById(R.id.banner);
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
//        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        mScrollableLayout = getViewById(R.id.scrollable_layout);
        mOneImg = getViewById(R.id.one_img);
        mRxText = (RxTextviewVertical) getViewById(R.id.rx_text);
        mViewPager = getViewById(R.id.view_pager);
        mOrderImg = getViewById(R.id.order_img);
        mSearchImg = getViewById(R.id.search_img);
        mMenu01Tv = getViewById(R.id.menu_01_tv);
        mMenu02Tv = getViewById(R.id.menu_02_tv);
        mMenu03Tv = getViewById(R.id.menu_03_tv);
        mMenu04Tv = getViewById(R.id.menu_04_tv);
        mMenu01Img=getViewById(R.id.menu_01_img);
        mMenu02Img=getViewById(R.id.menu_02_img);
        mMenu03Img=getViewById(R.id.menu_03_img);
        mMenu04Img=getViewById(R.id.menu_04_img);
        mSginImg = getViewById(R.id.sgin_img);
        mHeadLayout=getViewById(R.id.head_layouat);
        initMagicIndicator();
    }

    @Override
    public void bindViewsListener() {
        mOrderImg.setOnClickListener(this);
        mSearchImg.setOnClickListener(this);
        mMenu01Img.setOnClickListener(this);
        mMenu02Img.setOnClickListener(this);
        mMenu03Img.setOnClickListener(this);
        mMenu04Img.setOnClickListener(this);

        mSginImg.setOnClickListener(this);
        mScrollableLayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                mHeadLayout.setTranslationY(currentY / 2);

            }
        });
    }

    private void initMagicIndicator() {
        MagicIndicator magicIndicator = (MagicIndicator) getViewById(R.id.magic_indicator);
        magicIndicator.setBackgroundColor(Color.WHITE);
        CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setAdjustMode(false);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleDataList.length;
            }

            @Override
            public IPagerTitleView getTitleView(Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mTitleDataList[index]);
                simplePagerTitleView.setWidth((WidthHigthUtil.getScreenWidth(mActivity) - 100) / 4);
                simplePagerTitleView.setTextSize(14);
                simplePagerTitleView.setNormalColor(ContextCompat.getColor(mActivity, R.color.C5));

                simplePagerTitleView.setSelectedColor(ContextCompat.getColor(mActivity, R.color.colorAccent));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mViewPager.setCurrentItem(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(1.6f));
//                indicator.setYOffset(UIUtil.dip2px(context, 39));
                indicator.setLineHeight(UIUtil.dip2px(context, 2));
                indicator.setColors(ContextCompat.getColor(mActivity, R.color.colorAccent));
//                LinePagerIndicator indicator = new LinePagerIndicator(context);
//                indicator.setColors(Color.parseColor("#40c4ff"));
                return indicator;
            }

            @Override
            public float getTitleWeight(Context context, int index) {
                if (index == 0) {
                    return 1.0f;
                } else if (index == 1) {
                    return 1.0f;
                } else {
                    return 1.0f;
                }

            }
        });

        initViewPagerData();
        magicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind(magicIndicator, mViewPager);

    }

    public void initViewPagerData() {
        mFragmentList = new ArrayList<>();
        for (int i = 0; i < mTitleDataList.length; i++) {
            TabOneChildFragment fragment = TabOneChildFragment.newInstance();
            fragment.setType((i + 1) + "");
            mFragmentList.add(fragment);
        }

        mScrollableLayout.getHelper().setCurrentScrollableContainer(mFragmentList.get(0));
        mViewPager.setOffscreenPageLimit(mTitleDataList.length);
        mViewPager.setAdapter(new FragmentPagerAdapter(mActivity.getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragmentList.get(position);
            }

            //            private String[] titles = {"人气", "进度", "最新揭晓"};
            @Override
            public CharSequence getPageTitle(int position) {
                return mTitleDataList[position];
            }

            @Override
            public int getCount() {
                return mFragmentList.size();
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                mScrollableLayout.getHelper().setCurrentScrollableContainer(mFragmentList.get(position));
            }
        });
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        BSHttpUtils.post(mActivity, this, Constant.HOME_TITLE_URL, map, HomeVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        final HomeVO homeVO = (HomeVO) vo;
        mHomeVO= (HomeVO) vo;
        mBanner.setImages(homeVO.getData().getMulti_adv());
        Banner banner = mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                HomeVO.DataBean.MultiAdvBean bannerVO = (HomeVO.DataBean.MultiAdvBean) o;
                Picasso.with(context).load(bannerVO.getAdv_image()).into(imageView);
            }
        });
        mBanner.setOnBannerListener(new OnBannerListener() {

            @Override
            public void OnBannerClick(int position) {
                Bundle bundle= new Bundle();
                if("1".equals(homeVO.getData().getMulti_adv().get(position).getJump_type())){
                    bundle.putString("keyword",homeVO.getData().getMulti_adv().get(position).getAdv_url());
                    mActivity.open(SearchShopActivity.class,bundle,0);
                }else {
                    bundle.putString("url",homeVO.getData().getMulti_adv().get(position).getAdv_url());
                    mActivity.open(WebViewActivity.class,bundle,0);
                }

            }
        });
        mBanner.start();
        Picasso.with(mActivity).load(homeVO.getData().getSingle_adv().getAdv_image()).into(mOneImg);

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < homeVO.getData().getRecord_list().size(); i++) {
            list.add(homeVO.getData().getRecord_list().get(i).getPrise_desc());
        }
        mRxText.setTextList(list);
        mRxText.setText(14, 5, 0xff766156);//设置属性
        mRxText.setTextStillTime(3000);//设置停留时长间隔
        mRxText.setAnimTime(300);//设置进入和退出的时间间隔
        mRxText.setOnItemClickListener(new RxTextviewVertical.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Bundle bundle = new Bundle();

            }
        });
        mRxText.startAutoScroll();


        Picasso.with(mActivity).load(homeVO.getData().getNav_list().get(0).getNav_icon()).into(mMenu01Img);
        Picasso.with(mActivity).load(homeVO.getData().getNav_list().get(1).getNav_icon()).into(mMenu02Img);
        Picasso.with(mActivity).load(homeVO.getData().getNav_list().get(2).getNav_icon()).into(mMenu03Img);
        Picasso.with(mActivity).load(homeVO.getData().getNav_list().get(3).getNav_icon()).into(mMenu04Img);
        mMenu01Tv.setText(homeVO.getData().getNav_list().get(0).getNav_title());
        mMenu02Tv.setText(homeVO.getData().getNav_list().get(1).getNav_title());
        mMenu03Tv.setText(homeVO.getData().getNav_list().get(2).getNav_title());
        mMenu04Tv.setText(homeVO.getData().getNav_list().get(3).getNav_title());

        ACache.get(mActivity).put("share_title",homeVO.getData().getShare_params().getTitle());
        ACache.get(mActivity).put("share_desc",homeVO.getData().getShare_params().getDescX());
        ACache.get(mActivity).put("share_img",homeVO.getData().getShare_params().getImage());
        ACache.get(mActivity).put("share_url",homeVO.getData().getShare_params().getUrl());
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
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.order_img:
                if ("5".equals(mStatus)) {
                    EventBus.getDefault().post(new EBMessageVO("order_high"));
                    mOrderImg.setImageResource(R.drawable.order_high);
                    mStatus = "4";
                } else {
                    EventBus.getDefault().post(new EBMessageVO("order_low"));
                    mOrderImg.setImageResource(R.drawable.order_low);
                    mStatus = "5";
                }
                break;

            case R.id.search_img:
                mActivity.openActivity(KeywordActivity.class);
                break;
            case R.id.menu_01_img:
                mActivity.openActivity(ShopCategoryActivity.class);
                break;
            case R.id.menu_02_img:
                mActivity.openActivity(ShopChoseActivity.class);
                break;
            case R.id.menu_03_img:
                mActivity.openActivity(DailyTaskActivity.class);
                break;
            case R.id.menu_04_img:
                bundle.putString("title",mHomeVO.getData().getNav_list().get(3).getNav_title());
                bundle.putString("url",mHomeVO.getData().getNav_list().get(3).getNav_url());
                mActivity.open(WebViewActivity.class,bundle,0);
                break;
            case R.id.sgin_img:
                if(AppApplication.getInstance().getUserInfoVO()==null){
                    login();
                    return;
                }
                mActivity.openActivity(SignActivity.class);
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


    public void otherLogin(String openid, String nickname, String headpicurl) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", mOhterLoginType);
        map.put("openid", openid);
        map.put("nickname", nickname);
        map.put("platform", "1");
        map.put("headpicurl", headpicurl);
        BSHttpUtils.postCallBack(mActivity, Constant.LOGIN_OTHER_URL, map, UserInfoVO.class, this);
    }
}
