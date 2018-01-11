
package com.wzl.feifubao.application;


import android.content.Context;
import android.support.multidex.MultiDex;

import com.umeng.socialize.PlatformConfig;
import com.wuzhanglong.library.application.BaseAppApplication;
import com.wzl.feifubao.mode.UserInfoVO;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class AppApplication extends BaseAppApplication {
    private static AppApplication mAppApplication;
    {
        PlatformConfig.setWeixin("wx2c13faa1a2947596","2b196a7043a25b3edc8c2813224c07fa");
        PlatformConfig.setQQZone("1106176952","KEYRhCNnGRnsBJ7b9tN");
        PlatformConfig.setSinaWeibo("319845988","fbb3df56985bcd557975e1bd8e8d8a1e","http://xiaojingsc.test.beisheng.wang/ht");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppApplication = this;
//        RxUtils.init(this);
//        JPushInterface.setDebugMode(true);
//        JPushInterface.init(this);
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
