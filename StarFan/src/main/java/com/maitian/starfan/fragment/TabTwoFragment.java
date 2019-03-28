package com.maitian.starfan.fragment;


import android.view.View;

import com.maitian.starfan.R;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.Map;

public class TabTwoFragment extends BaseFragment implements View.OnClickListener, PostCallback, Serializable {


    //登录



    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_five_fragment);
    }

    @Override
    public void initView(View view) {

    }

    @Override
    public void bindViewsListener() {
        EventBus.getDefault().register(this);
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
        showView();
    }

    @Override
    public void noNet() {

    }


    @Override
    public void onClick(View v) {

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

    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void bindPhone() {

    }
}
