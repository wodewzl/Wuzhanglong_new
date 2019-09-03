package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by wuzhanglong on 2018/1/15.
 */

public class HouseAddVO extends BaseVO{

    /**
     * data : {"rate":"0.13333330","order_id":"280","out_trade_no":"151603192785131000","order_type":"2","pay_money":"0.10","pay_rmb":"0.01"}
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
         * rate : 0.13333330
         * order_id : 280
         * out_trade_no : 151603192785131000
         * order_type : 2
         * pay_money : 0.10
         * pay_rmb : 0.01
         */

        private String rate;
        private String order_id;
        private String out_trade_no;
        private String order_type;
        private String pay_money;
        private String pay_rmb;

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
        }

        public String getOrder_type() {
            return order_type;
        }

        public void setOrder_type(String order_type) {
            this.order_type = order_type;
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
    }
}
