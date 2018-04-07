package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/24.
 */

public class UserInfoVO extends BaseVO implements Serializable{


    /**
     * data : {"user_no":"10007","balance":"0","jiguang_alias":"qmfq_11"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * user_no : 10007
         * balance : 0
         * jiguang_alias : qmfq_11
         */

        private String user_no;
        private String balance;
        private String jiguang_alias;

        public String getUser_no() {
            return user_no;
        }

        public void setUser_no(String user_no) {
            this.user_no = user_no;
        }

        public String getBalance() {
            return balance;
        }

        public void setBalance(String balance) {
            this.balance = balance;
        }

        public String getJiguang_alias() {
            return jiguang_alias;
        }

        public void setJiguang_alias(String jiguang_alias) {
            this.jiguang_alias = jiguang_alias;
        }
    }
}
