package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/14.
 */

public class PayRedVO extends BaseVO{

    /**
     * data : {"coupon_count":"2","coupon_list":[{"coupon_id":"309","coupon_name":"积分兑换1元红包","at_least":"5.00","start_date":"2018-03-30","end_date":"2018-04-30","money":"1.00",
     * "coupon_desc":"满5.00减1.00","tips":"仅限实物商品使用"},{"coupon_id":"310","coupon_name":"积分兑换1元红包","at_least":"5.00","start_date":"2018-03-30","end_date":"2018-04-30","money":"1.00",
     * "coupon_desc":"满5.00减1.00","tips":"仅限实物商品使用"}]}
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
         * coupon_count : 2
         * coupon_list : [{"coupon_id":"309","coupon_name":"积分兑换1元红包","at_least":"5.00","start_date":"2018-03-30","end_date":"2018-04-30","money":"1.00","coupon_desc":"满5.00减1.00",
         * "tips":"仅限实物商品使用"},{"coupon_id":"310","coupon_name":"积分兑换1元红包","at_least":"5.00","start_date":"2018-03-30","end_date":"2018-04-30","money":"1.00","coupon_desc":"满5.00减1.00",
         * "tips":"仅限实物商品使用"}]
         */

        private String coupon_count;
        private List<CouponListBean> coupon_list;

        public String getCoupon_count() {
            return coupon_count;
        }

        public void setCoupon_count(String coupon_count) {
            this.coupon_count = coupon_count;
        }

        public List<CouponListBean> getCoupon_list() {
            return coupon_list;
        }

        public void setCoupon_list(List<CouponListBean> coupon_list) {
            this.coupon_list = coupon_list;
        }

        public static class CouponListBean {
            /**
             * coupon_id : 309
             * coupon_name : 积分兑换1元红包
             * at_least : 5.00
             * start_date : 2018-03-30
             * end_date : 2018-04-30
             * money : 1.00
             * coupon_desc : 满5.00减1.00
             * tips : 仅限实物商品使用
             */

            private String coupon_id;
            private String coupon_name;
            private String at_least;
            private String start_date;
            private String end_date;
            private String money;
            private String coupon_desc;
            private String tips;

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
        }
    }
}
