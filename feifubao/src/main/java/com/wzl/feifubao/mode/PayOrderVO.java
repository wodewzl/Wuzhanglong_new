package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by ${Wuzhanglong} on 2018/1/22.
 */

public class PayOrderVO extends BaseVO{

    /**
     * data : {"order_id":"419","order_status":"0","order_no":"2018012219240001","out_trade_no":"151662044418821000","pay_status":"0","pay_money":"0.10","pay_rmb":"0.01","bill_num":"",
     * "account_number":"","stoptime":"","type":"0","receiver_mobile":"","face_value":"100","carrier_operator":"Globle"}
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
         * order_id : 419
         * order_status : 0
         * order_no : 2018012219240001
         * out_trade_no : 151662044418821000
         * pay_status : 0
         * pay_money : 0.10
         * pay_rmb : 0.01
         * bill_num :
         * account_number :
         * stoptime :
         * type : 0
         * receiver_mobile :
         * face_value : 100
         * carrier_operator : Globle
         */

        private String order_id;
        private String order_status;
        private String order_no;
        private String out_trade_no;
        private String pay_status;
        private String pay_money;
        private String pay_rmb;
        private String bill_num;
        private String account_number;
        private String stoptime;
        private String type;
        private String receiver_mobile;
        private String face_value;
        private String carrier_operator;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOrder_status() {
            return order_status;
        }

        public void setOrder_status(String order_status) {
            this.order_status = order_status;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }

        public String getPay_money() {
            return pay_money;
        }

        public void setPay_money(String pay_money) {
            this.pay_money = pay_money;
        }

        public String getPay_rmb() {
            return pay_rmb;
        }

        public void setPay_rmb(String pay_rmb) {
            this.pay_rmb = pay_rmb;
        }

        public String getBill_num() {
            return bill_num;
        }

        public void setBill_num(String bill_num) {
            this.bill_num = bill_num;
        }

        public String getAccount_number() {
            return account_number;
        }

        public void setAccount_number(String account_number) {
            this.account_number = account_number;
        }

        public String getStoptime() {
            return stoptime;
        }

        public void setStoptime(String stoptime) {
            this.stoptime = stoptime;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getReceiver_mobile() {
            return receiver_mobile;
        }

        public void setReceiver_mobile(String receiver_mobile) {
            this.receiver_mobile = receiver_mobile;
        }

        public String getFace_value() {
            return face_value;
        }

        public void setFace_value(String face_value) {
            this.face_value = face_value;
        }

        public String getCarrier_operator() {
            return carrier_operator;
        }

        public void setCarrier_operator(String carrier_operator) {
            this.carrier_operator = carrier_operator;
        }
    }
}
