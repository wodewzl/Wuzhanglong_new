package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class RateQueryVO extends BaseVO {

    /**
     * data : {"id":"30","CNY":"7.61840000","USD":"50.09900000","JPY":"0.44193000","HKD":"6.40940000","EUR":"59.38200000","GBP":"67.04700000","date":"2017-12-22","type":"0"}
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
         * id : 30
         * CNY : 7.61840000
         * USD : 50.09900000
         * JPY : 0.44193000
         * HKD : 6.40940000
         * EUR : 59.38200000
         * GBP : 67.04700000
         * date : 2017-12-22
         * type : 0
         */

        private String id;
        private String CNY;
        private String USD;
        private String JPY;
        private String HKD;
        private String EUR;
        private String GBP;
        private String date;
        private String type;
        private String tag;
        private String money;

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

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

        public String getCNY() {
            return CNY;
        }

        public void setCNY(String CNY) {
            this.CNY = CNY;
        }

        public String getUSD() {
            return USD;
        }

        public void setUSD(String USD) {
            this.USD = USD;
        }

        public String getJPY() {
            return JPY;
        }

        public void setJPY(String JPY) {
            this.JPY = JPY;
        }

        public String getHKD() {
            return HKD;
        }

        public void setHKD(String HKD) {
            this.HKD = HKD;
        }

        public String getEUR() {
            return EUR;
        }

        public void setEUR(String EUR) {
            this.EUR = EUR;
        }

        public String getGBP() {
            return GBP;
        }

        public void setGBP(String GBP) {
            this.GBP = GBP;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
