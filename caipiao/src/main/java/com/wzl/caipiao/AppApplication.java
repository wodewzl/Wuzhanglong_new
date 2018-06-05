
package com.wzl.caipiao;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;


public class AppApplication extends Application {
    private static AppApplication mAppApplication;


    @Override
    public void onCreate() {
        super.onCreate();
        mAppApplication = this;

    }

    /** 获取Application */
    public static AppApplication getInstance() {
        return mAppApplication;
    }


    public List<UserInfoVO> getDataVO() {
        try {
            FileInputStream stream = this.openFileInput("data.UserInfoVO");
            ObjectInputStream ois = new ObjectInputStream(stream);
            List<UserInfoVO> list = (List<UserInfoVO>) ois.readObject();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveDataVO(List<UserInfoVO> list) {
        try {
            FileOutputStream stream = this.openFileOutput("data.UserInfoVO", MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(stream);
            oos.writeObject(list);// td is an Instance of TableData;
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
