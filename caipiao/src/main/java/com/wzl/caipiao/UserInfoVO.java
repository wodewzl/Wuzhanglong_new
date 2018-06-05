package com.wzl.caipiao;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/12/24.
 */

public class UserInfoVO  implements Serializable{
    List<UserInfoVO> list;

    public List<UserInfoVO> getList() {
        return list;
    }

    public void setList(List<UserInfoVO> list) {
        this.list = list;
    }
}
