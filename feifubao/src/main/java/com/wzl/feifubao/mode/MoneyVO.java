package com.wzl.feifubao.mode;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class MoneyVO {
    private String money ;
    private String id;
    private String status="0";

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
