
package com.maitian.starmily.application;


import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.maitian.starmily.model.AppConfigVO;
import com.maitian.starmily.model.MyIdolsVO;
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
        PlatformConfig.setWeixin("wxee271193d3f2c8cc","c02a23423cf23c6a90db195405b2c3ac");
        PlatformConfig.setQQZone("1109182431","tq6xQF7CT7NvHtLO");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad","http://sns.whalecloud.com");

    }

    @Override
    public void onCreate() {
        super.onCreate();
        mAppApplication = this;
//        RxUtils.init(this);
//        JPushInterface.setDebugMode(true);
//        JPushInterface.init(this);

        UMConfigure.init(this,"5cede1a53fc195fe74000883"
                ,"umeng",UMConfigure.DEVICE_TYPE_PHONE,"");//58edcfeb310c93091c000be2 5965ee00734be40b580001a0
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

    public MyIdolsVO getMyIdolsVO() {
        try {
            FileInputStream stream = this.openFileInput("data.MyIdolsVO");
            ObjectInputStream ois = new ObjectInputStream(stream);
            MyIdolsVO myIdolsVO = (MyIdolsVO) ois.readObject();
            return myIdolsVO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void saveMyIdolsVO(MyIdolsVO myIdolsVO) {
        try {
            FileOutputStream stream = this.openFileOutput("data.MyIdolsVO", MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(stream);
            oos.writeObject(myIdolsVO);// td is an Instance of TableData;
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
