package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by ${Wuzhanglong} on 2018/1/20.
 */

public class ChargeMoneyVO extends BaseVO {

    /**
     * data : {"id":"28","recharge_money":"0.01","uid":"40","out_trade_no":"151641351527701000","create_time":"0","is_pay":"0","status":"0","pay_rmb":"0"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 28
         * recharge_money : 0.01
         * uid : 40
         * out_trade_no : 151641351527701000
         * create_time : 0
         * is_pay : 0
         * status : 0
         * pay_rmb : 0
         */

        private String id;
        private String recharge_money;
        private String uid;
        private String out_trade_no;
        private String create_time;
        private String is_pay;
        private String status;
        private String pay_rmb;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRecharge_money() {
            return recharge_money;
        }

        public void setRecharge_money(String recharge_money) {
            this.recharge_money = recharge_money;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getIs_pay() {
            return is_pay;
        }

        public void setIs_pay(String is_pay) {
            this.is_pay = is_pay;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPay_rmb() {
            return pay_rmb;
        }

        public void setPay_rmb(String pay_rmb) {
            this.pay_rmb = pay_rmb;
        }
    }
}
