package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by wuzhanglong on 2018/1/13.
 */

public class MyMessageVO extends BaseVO{

    /**
     * data : {"all":"44","wait_pay":"20","wait_delivery":"11","wait_recieved":"0","recieved":"6","success":"0","closed":"6","refunding":"68","refunded":"0","wait_evaluate":"6","refundOrder":"68"}
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
         * all : 44
         * wait_pay : 20
         * wait_delivery : 11
         * wait_recieved : 0
         * recieved : 6
         * success : 0
         * closed : 6
         * refunding : 68
         * refunded : 0
         * wait_evaluate : 6
         * refundOrder : 68
         */

        private String all;
        private String wait_pay;
        private String wait_delivery;
        private String wait_recieved;
        private String recieved;
        private String success;
        private String closed;
        private String refunding;
        private String refunded;
        private String wait_evaluate;
        private String refundOrder;

        public String getAll() {
            return all;
        }

        public void setAll(String all) {
            this.all = all;
        }

        public String getWait_pay() {
            return wait_pay;
        }

        public void setWait_pay(String wait_pay) {
            this.wait_pay = wait_pay;
        }

        public String getWait_delivery() {
            return wait_delivery;
        }

        public void setWait_delivery(String wait_delivery) {
            this.wait_delivery = wait_delivery;
        }

        public String getWait_recieved() {
            return wait_recieved;
        }

        public void setWait_recieved(String wait_recieved) {
            this.wait_recieved = wait_recieved;
        }

        public String getRecieved() {
            return recieved;
        }

        public void setRecieved(String recieved) {
            this.recieved = recieved;
        }

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        public String getClosed() {
            return closed;
        }

        public void setClosed(String closed) {
            this.closed = closed;
        }

        public String getRefunding() {
            return refunding;
        }

        public void setRefunding(String refunding) {
            this.refunding = refunding;
        }

        public String getRefunded() {
            return refunded;
        }

        public void setRefunded(String refunded) {
            this.refunded = refunded;
        }

        public String getWait_evaluate() {
            return wait_evaluate;
        }

        public void setWait_evaluate(String wait_evaluate) {
            this.wait_evaluate = wait_evaluate;
        }

        public String getRefundOrder() {
            return refundOrder;
        }

        public void setRefundOrder(String refundOrder) {
            this.refundOrder = refundOrder;
        }
    }
}
