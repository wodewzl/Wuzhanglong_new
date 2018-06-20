package com.wzl.caipiao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/12/24.
 */

public class UserInfoVO implements Serializable {
    List<UserInfoVO> list;

    public List<UserInfoVO> getList() {
        return list;
    }

    public void setList(List<UserInfoVO> list) {
        this.list = list;
    }

    private String result;
    private String yuce1;
    private String yuce2;
    private String yuce3;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getYuce1() {
        return yuce1;
    }

    public void setYuce1(String yuce1) {
        this.yuce1 = yuce1;
    }

    public String getYuce2() {
        return yuce2;
    }

    public void setYuce2(String yuce2) {
        this.yuce2 = yuce2;
    }

    public String getYuce3() {
        return yuce3;
    }

    public void setYuce3(String yuce3) {
        this.yuce3 = yuce3;
    }
}
