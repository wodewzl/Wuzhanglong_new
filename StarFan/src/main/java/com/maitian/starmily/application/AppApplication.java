
package com.maitian.starmily.application;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.maitian.starmily.model.AppConfigVO;
import com.maitian.starmily.model.UserInfoVO;
import com.qiniu.android.common.FixedZone;
import com.qiniu.android.storage.Configuration;
import com.qiniu.android.storage.UploadManager;
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
        initQiNiu();

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


    public AppConfigVO getAppConfigVO() {
        try {
            FileInputStream stream = this.openFileInput("data.AppConfigVO");
            ObjectInputStream ois = new ObjectInputStream(stream);
            AppConfigVO appConfigVO = (AppConfigVO) ois.readObject();
            return appConfigVO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveAppConfigVO(AppConfigVO appConfigVO) {
        try {
            FileOutputStream stream = this.openFileOutput("data.AppConfigVO", MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(stream);
            oos.writeObject(appConfigVO);// td is an Instance of TableData;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public void initQiNiu(){
        Configuration config = new Configuration.Builder()
                .chunkSize(512 * 1024)        // 分片上传时，每片的大小。 默认256K
                .putThreshhold(1024 * 1024)   // 启用分片上传阀值。默认512K
                .connectTimeout(10)           // 链接超时。默认10秒
                .useHttps(true)               // 是否使用https上传域名
                .responseTimeout(60)          // 服务器响应超时。默认60秒
//                .recorder(null)           // recorder分片上传时，已上传片记录器。默认null
//                .recorder(recorder, keyGen)   // keyGen 分片上传时，生成标识符，用于片记录器区分是那个文件的上传记录
                .zone(FixedZone.zone0)        // 设置区域，指定不同区域的上传域名、备用域名、备用IP。
                .build();
// 重用uploadManager。一般地，只需要创建一个uploadManager对象
        UploadManager uploadManager = new UploadManager(config);
    }
}
