package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/11.
 */

public class MyScortVO extends BaseVO{

    /**
     * data : {"point":"17","today_point":"0","point_issue":"每年6月30日，您的积分将会减半；每年12月31日未使用完的积分将清零。请关注您的积分，以免给您带来不必要的损失。","point_way":"1.签到可获得积分。\n2.完成每日任务可获得积分奖励。\n3.完成新手任务可获得积分奖励。",
     * "exchange_rule":"可以用积分兑换商品和红包","coupon_list":[{"coupon_type_id":"4","coupon_name":"积分兑换1元红包","money":"1.00","count":"110","exchange_points":"10","remain_count":"92","valid_days":"6"},
     * {"coupon_type_id":"5","coupon_name":"无门槛红包","money":"1.00","count":"100","exchange_points":"10","remain_count":"99","valid_days":"37"},{"coupon_type_id":"6","coupon_name":"满50减2元红包",
     * "money":"2.00","count":"100","exchange_points":"100","remain_count":"99","valid_days":"37"}]}
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
         * point : 17
         * today_point : 0
         * point_issue : 每年6月30日，您的积分将会减半；每年12月31日未使用完的积分将清零。请关注您的积分，以免给您带来不必要的损失。
         * point_way : 1.签到可获得积分。
         2.完成每日任务可获得积分奖励。
         3.完成新手任务可获得积分奖励。
         * exchange_rule : 可以用积分兑换商品和红包
         * coupon_list : [{"coupon_type_id":"4","coupon_name":"积分兑换1元红包","money":"1.00","count":"110","exchange_points":"10","remain_count":"92","valid_days":"6"},{"coupon_type_id":"5",
         * "coupon_name":"无门槛红包","money":"1.00","count":"100","exchange_points":"10","remain_count":"99","valid_days":"37"},{"coupon_type_id":"6","coupon_name":"满50减2元红包","money":"2.00",
         * "count":"100","exchange_points":"100","remain_count":"99","valid_days":"37"}]
         */

        private String point;
        private String today_point;
        private String point_issue;
        private String point_way;
        private String exchange_rule;
        private List<CouponListBean> coupon_list;

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public String getToday_point() {
            return today_point;
        }

        public void setToday_point(String today_point) {
            this.today_point = today_point;
        }

        public String getPoint_issue() {
            return point_issue;
        }

        public void setPoint_issue(String point_issue) {
            this.point_issue = point_issue;
        }

        public String getPoint_way() {
            return point_way;
        }

        public void setPoint_way(String point_way) {
            this.point_way = point_way;
        }

        public String getExchange_rule() {
            return exchange_rule;
        }

        public void setExchange_rule(String exchange_rule) {
            this.exchange_rule = exchange_rule;
        }

        public List<CouponListBean> getCoupon_list() {
            return coupon_list;
        }

        public void setCoupon_list(List<CouponListBean> coupon_list) {
            this.coupon_list = coupon_list;
        }

        public static class CouponListBean {
            /**
             * coupon_type_id : 4
             * coupon_name : 积分兑换1元红包
             * money : 1.00
             * count : 110
             * exchange_points : 10
             * remain_count : 92
             * valid_days : 6
             */

            private String coupon_type_id;
            private String coupon_name;
            private String money;
            private String count;
            private String exchange_points;
            private String remain_count;
            private String valid_days;

            public String getCoupon_type_id() {
                return coupon_type_id;
            }

            public void setCoupon_type_id(String coupon_type_id) {
                this.coupon_type_id = coupon_type_id;
            }

            public String getCoupon_name() {
                return coupon_name;
            }

            public void setCoupon_name(String coupon_name) {
                this.coupon_name = coupon_name;
            }

            public String getMoney() {
                return money;
            }

            public void setMoney(String money) {
                this.money = money;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public String getExchange_points() {
                return exchange_points;
            }

            public void setExchange_points(String exchange_points) {
                this.exchange_points = exchange_points;
            }

            public String getRemain_count() {
                return remain_count;
            }

            public void setRemain_count(String remain_count) {
                this.remain_count = remain_count;
            }

            public String getValid_days() {
                return valid_days;
            }

            public void setValid_days(String valid_days) {
                this.valid_days = valid_days;
            }
        }
    }
}
