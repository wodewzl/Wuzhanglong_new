package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by ${Wuzhanglong} on 2018/4/11.
 */

public class MyCenterVO extends BaseVO{

    /**
     * data : {"nickname":"疯抢用户10005","user_no":"10005","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","flow":"0.60","coupon_count":"0",
     * "point":"155","balance":"708","jiguang_alias":"qmfq_9","sex":"1","user_tel":"18972221696","sex_text":"男","qq_nickname":"","wx_nickname":""}
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
         * nickname : 疯抢用户10005
         * user_no : 10005
         * avatar : http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg
         * flow : 0.60
         * coupon_count : 0
         * point : 155
         * balance : 708
         * jiguang_alias : qmfq_9
         * sex : 1
         * user_tel : 18972221696
         * sex_text : 男
         * qq_nickname :
         * wx_nickname :
         */

        private String nickname;
        private String user_no;
        private String avatar;
        private String flow;
        private String coupon_count;
        private String point;
        private String balance;
        private String jiguang_alias;
        private String sex;
        private String user_tel;
        private String sex_text;
        private String qq_nickname;
        private String wx_nickname;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getUser_no() {
            return user_no;
        }

        public void setUser_no(String user_no) {
            this.user_no = user_no;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getFlow() {
            return flow;
        }

        public void setFlow(String flow) {
            this.flow = flow;
        }

        public String getCoupon_count() {
            return coupon_count;
        }

        public void setCoupon_count(String coupon_count) {
            this.coupon_count = coupon_count;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
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

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getUser_tel() {
            return user_tel;
        }

        public void setUser_tel(String user_tel) {
            this.user_tel = user_tel;
        }

        public String getSex_text() {
            return sex_text;
        }

        public void setSex_text(String sex_text) {
            this.sex_text = sex_text;
        }

        public String getQq_nickname() {
            return qq_nickname;
        }

        public void setQq_nickname(String qq_nickname) {
            this.qq_nickname = qq_nickname;
        }

        public String getWx_nickname() {
            return wx_nickname;
        }

        public void setWx_nickname(String wx_nickname) {
            this.wx_nickname = wx_nickname;
        }
    }
}
