package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;

/**
 * Created by ${Wuzhanglong} on 2018/5/1.
 */

public class UpdateAppVO extends BaseVO{
    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        public String android_version;
        public String ios_version;

        public String getAndroid_version() {
            return android_version;
        }

        public String getIos_version() {
            return ios_version;
        }

        public void setIos_version(String ios_version) {
            this.ios_version = ios_version;
        }

        public void setAndroid_version(String android_version) {
            this.android_version = android_version;
        }
    }
}
