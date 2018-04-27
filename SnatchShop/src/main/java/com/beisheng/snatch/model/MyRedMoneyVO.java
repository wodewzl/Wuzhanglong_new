package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class MyRedMoneyVO extends BaseVO {

    /**
     * data : {"coupon_list":[{"coupon_id":"1","coupon_name":"1元红包","at_least":"5.00","start_date":"2018-03-20 18:37:13","end_date":"2018-03-31 18:37:17","money":"1.00","coupon_desc":"满5.00减1.00","tips":"仅限实物商品使用","state":"2","state_text":"已使用"},{"coupon_id":"2","coupon_name":"1元红包","at_least":"5.00","start_date":"2018-03-20 18:37:13","end_date":"2018-03-31 18:37:17","money":"1.00","coupon_desc":"满5.00减1.00","tips":"仅限实物商品使用","state":"2","state_text":"已使用"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<CouponListBean> list;

        public List<CouponListBean> getList() {
            return list;
        }

        public void setList(List<CouponListBean> list) {
            this.list = list;
        }

        public static class CouponListBean {
            /**
             * coupon_id : 1
             * coupon_name : 1元红包
             * at_least : 5.00
             * start_date : 2018-03-20 18:37:13
             * end_date : 2018-03-31 18:37:17
             * money : 1.00
             * coupon_desc : 满5.00减1.00
             * tips : 仅限实物商品使用
             * state : 2
             * state_text : 已使用
             */

            private String coupon_id;
            private String coupon_name;
            private String at_least;
            private String start_date;
            private String end_date;
            private String money;
            private String coupon_desc;
            private String tips;
            private String state;
            private String state_text;

            public String getCoupon_id() {
                return coupon_id;
            }

            public void setCoupon_id(String coupon_id) {
                this.coupon_id = coupon_id;
            }

            public String getCoupon_name() {
                return coupon_name;
            }

            public void setCoupon_name(String coupon_name) {
                this.coupon_name = coupon_name;
            }

            public String getAt_least() {
                return at_least;
            }

            public void setAt_least(String at_least) {
                this.at_least = at_least;
            }

            public String getStart_date() {
                return start_date;
            }

            public void setStart_date(String start_date) {
                this.start_date = start_date;
            }

            public String getEnd_date() {
                return end_date;
            }

            public void setEnd_date(String end_date) {
                this.end_date = end_date;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getCoupon_desc() {
                return coupon_desc;
            }

            public void setCoupon_desc(String coupon_desc) {
                this.coupon_desc = coupon_desc;
            }

            public String getTips() {
                return tips;
            }

            public void setTips(String tips) {
                this.tips = tips;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public String getState_text() {
                return state_text;
            }

            public void setState_text(String state_text) {
                this.state_text = state_text;
            }
        }
    }
}
