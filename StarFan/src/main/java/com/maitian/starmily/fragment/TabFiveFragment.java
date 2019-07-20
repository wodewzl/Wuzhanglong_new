package com.maitian.starmily.fragment;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.maitian.starmily.R;
import com.maitian.starmily.activity.MyAttentionActivity;
import com.maitian.starmily.activity.MyMemberCentreActivity;
import com.maitian.starmily.activity.MyPostsActivity;
import com.maitian.starmily.activity.MyPurseActivity;
import com.maitian.starmily.activity.MySettiingsActivity;
import com.maitian.starmily.activity.MyTaskActivity;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.MyHomeBean;
import com.maitian.starmily.model.UserInfoVO;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;

public class TabFiveFragment extends BaseFragment implements View.OnClickListener, PostCallback, Serializable {
    private TextView mSinTv, mItme01Tv, mItme02Tv, mItme03Tv, mItme04Tv, mItme05Tv, mItme06Tv, mItme07Tv;
    private TextView mDescTv, mNameTv, mLoginTv;
    private CircleImageView mHeadIv;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_five_fragment);
    }

    @Override
    public void initView(View view) {
        mSinTv = getViewById(R.id.sign_tv);
        mItme01Tv = getViewById(R.id.item_01_tv);
        mItme02Tv = getViewById(R.id.item_02_tv);
        mItme03Tv = getViewById(R.id.item_03_tv);
        mItme04Tv = getViewById(R.id.item_04_tv);
        mItme05Tv = getViewById(R.id.item_05_tv);
        mItme06Tv = getViewById(R.id.item_06_tv);
        mItme07Tv = getViewById(R.id.item_07_tv);
        mDescTv = getViewById(R.id.desc_tv);
        mNameTv = getViewById(R.id.name_tv);
        mLoginTv = getViewById(R.id.login_tv);
        mHeadIv = getViewById(R.id.head_img);
        if (AppApplication.getInstance().getUserInfoVO() != null) {
            mNameTv.setVisibility(View.VISIBLE);
            mDescTv.setVisibility(View.VISIBLE);
            mLoginTv.setVisibility(View.GONE);
            UserInfoVO userInfoVO = AppApplication.getInstance().getUserInfoVO();
            mNameTv.setText(userInfoVO.getObj().getNickname());
            mDescTv.setText(userInfoVO.getObj().getSign());
            if (!TextUtils.isEmpty(userInfoVO.getObj().getIconUrl())) {
                if (userInfoVO.getObj().getIconUrl().contains("http://")) {
                    Picasso.with(mActivity).load(userInfoVO.getObj().getIconUrl()).into(mHeadIv);
                }else {
                    Picasso.with(mActivity).load(userInfoVO.getObj().getIconUrl()).into(mHeadIv);
                    Picasso.with(mActivity).load(Constant.DOMAIN_UR + "/" + userInfoVO.getObj().getIconUrl()).into(mHeadIv);
                }
            }
        } else {
            mNameTv.setVisibility(View.GONE);
            mDescTv.setVisibility(View.GONE);
            mLoginTv.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void bindViewsListener() {
        EventBus.getDefault().register(this);
        mItme01Tv.setOnClickListener(this);
        mItme02Tv.setOnClickListener(this);
        mItme03Tv.setOnClickListener(this);
        mItme04Tv.setOnClickListener(this);
        mItme05Tv.setOnClickListener(this);
        mItme06Tv.setOnClickListener(this);
        mItme07Tv.setOnClickListener(this);
        mSinTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.get(mActivity, this, Constant.MY_HOME_PAGE, map, MyHomeBean.class);
        showView();
    }

    @Override
    public void hasData(BaseVO vo) {
        showView();
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
        Bundle bundle=new Bundle();
        switch (v.getId()) {
            case R.id.item_01_tv:
                mActivity.openActivity(MyAttentionActivity.class);
                break;
            case R.id.item_02_tv:
                mActivity.openActivity(MyTaskActivity.class);
                break;
            case R.id.item_03_tv:
                mActivity.openActivity(MyPurseActivity.class);
                break;
            case R.id.item_04_tv:
                mActivity.openActivity(MyMemberCentreActivity.class);
                break;
            case R.id.item_05_tv:
                bundle.putString("followUserId",AppApplication.getInstance().getUserInfoVO().getObj().getUserId()+"");
                mActivity.open(MyPostsActivity.class,bundle,0);
                break;
            case R.id.item_06_tv:
                mActivity.openActivity(MySettiingsActivity.class);
                break;
            case R.id.item_07_tv:
//                mActivity.openActivity(MyC.class);
                break;
            case R.id.sign_tv:
                sign();
                break;
            default:
                break;

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
        mActivity.showCustomToast("签到成功");
//      new TaskUtil().taskShow(mActivity,"1");
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void sign() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.postCallBack(mActivity, Constant.SIGN_IN, map, BaseVO.class, this);
    }
}
