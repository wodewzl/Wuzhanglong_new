package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by Administrator on 2017/12/24.
 */

public class UserInfoVO extends BaseVO{
    private UserInfoVO data;
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public UserInfoVO getData() {
        return data;
    }

    public void setData(UserInfoVO data) {
        this.data = data;
    }
}
