
package com.wuzhanglong.library.application;

import android.app.Application;

public class BaseAppApplication extends Application {
    private static BaseAppApplication mAppApplication;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppApplication = this;
//        registerActivityLifecycleCallbacks(ActivityLifecycleHelper.build());//仿微信滑动返回
//        RxUtils.init(this);//rx工具
//        UMShareAPI.get(this);//友盟
    }
}
