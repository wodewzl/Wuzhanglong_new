
package com.beisheng.snatch.application;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.beisheng.snatch.model.UserInfoVO;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.socialize.PlatformConfig;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class AppApplication extends Application {
    private static AppApplication mAppApplication;
    {
        PlatformConfig.setWeixin("wxafa13c7f68391fd5","087d98720a5f9cb9feb3e2e3de44d58e");
        PlatformConfig.setQQZone("1106689363","kWwnHAXjYQ40YaQW");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppApplication = this;
//        RxUtils.init(this);
//        JPushInterface.setDebugMode(true);
//        JPushInterface.init(this);
        UMConfigure.init(this,"5ad16d84b27b0a6346000067"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");
    }

    /** 获取Application */
    public static AppApplication getInstance() {
        return mAppApplication;
    }


    public UserInfoVO getUserInfoVO() {
        try {
            FileInputStream stream = this.openFileInput("data.UserInfoVO");
            ObjectInputStream ois = new ObjectInputStream(stream);
            UserInfoVO userInfoVO = (UserInfoVO) ois.readObject();
            return userInfoVO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveUserInfoVO(UserInfoVO userInfoVO) {
        try {
            FileOutputStream stream = this.openFileOutput("data.UserInfoVO", MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(stream);
            oos.writeObject(userInfoVO);// td is an Instance of TableData;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
