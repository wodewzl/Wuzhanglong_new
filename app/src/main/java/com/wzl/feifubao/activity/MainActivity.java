package com.wzl.feifubao.activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.umeng.socialize.UMShareAPI;
import com.wuzhanglong.library.activity.HomeFragmentActivity;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.UpdateVersionVO;
import com.wzl.feifubao.R;

import org.greenrobot.eventbus.EventBus;

public class MainActivity extends HomeFragmentActivity implements PostCallback {
    BottomNavigationItem mTabThree;
    private UpdateVersionVO mUpdateVersionVO;

    @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
    @Override
    public void initBottomBar() {


//        int[] drawableIds = new int[] {R.drawable.home_01, R.drawable.home_01, R.drawable.home_01, R.drawable.home_01};
//        mTabWidget.update(this,drawableIds);
//        onTabSelected(0);

//        MODE_FIXED+BACKGROUND_STYLE_STATIC
//        MODE_FIXED+BACKGROUND_STYLE_RIPPLE
//        MODE_SHIFTING+BACKGROUND_STYLE_STATIC
//        MODE_SHIFTING+BACKGROUND_STYLE_RIPPLE

        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

//        mBottomNavigationBar.setMode(MODE_SHIFTING);
//        mBottomNavigationBar.setBackgroundStyle(BACKGROUND_STYLE_STATIC);

        mBottomNavigationBar
                .setActiveColor(R.color.C1)
                .setInActiveColor(R.color.FUBColor1)
                .setBarBackgroundColor(R.color.FUBColor2);
//                .setActiveColor(R.color.XJColor2)
//                .setInActiveColor(R.color.XJColor8)
//                .setBarBackgroundColor(R.color.C1);

        mBottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.ic_launcher, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher, "分类"))
                .addItem(new BottomNavigationItem(R.drawable.ic_launcher, "个人中心"))
//                .setFirstSelectedPosition(0)
                .initialise();
//        mBottomNavigationBar.selectTab(0);
        mBaseHeadLayout.setVisibility(View.GONE);



        mBaseHeadLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
//                checkUpdate();
            }
        },1000);
    }


    @Override
    protected void onActivityResult(int arg0, int arg1, Intent arg2) {
        super.onActivityResult(arg0, arg1, arg2);
        UMShareAPI.get(this).onActivityResult(arg0, arg1, arg2);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        EventBus.getDefault().unregister(this);
    }

    @Override
    public void success(BaseVO vo) {

    }


//    public void checkUpdate() {
//        HttpClientUtil.post(this, this, Constant.CHECK_UPDATE_URL, null, UpdateVersionVO.class, this);
//    }
//
//
//    @Override
//    public void success(BaseVO vo) {
//        UpdateVersionVO updateVersionVO = (UpdateVersionVO) vo;
//        mUpdateVersionVO = updateVersionVO.getDatas();
//        if (BaseConstant.RESULT_SUCCESS_CODE.equals(updateVersionVO.getCode())) {
//            if (BaseCommonUtils.parseInt(updateVersionVO.getDatas().getAndroid_version()) > VersionUtils.getversionCode(this)) {
//                updateDialog();
//            } else {
//                // mActivity.showCustomToast("亲，已是最新版本哦");
////                Toast.makeText(this, "亲，已是最新版本哦", Toast.LENGTH_SHORT).show();
//            }
//        }
//
//    }
//
//    public void updateDialog() {
//        new SweetAlertDialog(this, SweetAlertDialog.NORMAL_TYPE)
//                .setTitleText("友情提示")
//                .setContentText("发现有新的版本，赶紧下来看看吧")
//                .setConfirmText("确定")
//                .setCancelText("取消")
//                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                    @Override
//                    public void onClick(SweetAlertDialog sDialog) {
//                        sDialog.dismiss();
//                        Intent updateIntent = new Intent(HomeActivity.this, DownloadService.class);
//                        updateIntent.putExtra("url", mUpdateVersionVO.getAndroid_url());
//                        updateIntent.putExtra("drawableId", R.drawable.ic_launcher);
//                        HomeActivity.this.startService(updateIntent);
//                    }
//                })
//                .show();
//    }


}
