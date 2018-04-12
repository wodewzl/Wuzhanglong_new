package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

public class MyFlowVO extends BaseVO {
    private String money;
    private boolean select;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }


}
