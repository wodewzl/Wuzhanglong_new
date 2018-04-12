package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/24.
 */

public class UserInfoVO extends BaseVO implements Serializable{

    /**
     * data : {"nickname":"疯抢用户10005","user_no":"10005","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","flow":"10000.00","coupon_count":"1","point":"150","balance":"768","jiguang_alias":"qmfq_9","sex":"1","user_tel":"18972221696","sex_text":"男","qq_nickname":"","wx_nickname":"","aboutus_url":"http://qmfq.baonongkang.cn/index.php?s=/Wap/helpcenter/index&id=17","ysxy_url":"http://qmfq.baonongkang.cn/index.php?s=/Wap/helpcenter/index&id=3","fwxy_url":"http://qmfq.baonongkang.cn/index.php?s=/Wap/helpcenter/index&id=1"}
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
         * nickname : 疯抢用户10005
         * user_no : 10005
         * avatar : http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg
         * flow : 10000.00
         * coupon_count : 1
         * point : 150
         * balance : 768
         * jiguang_alias : qmfq_9
         * sex : 1
         * user_tel : 18972221696
         * sex_text : 男
         * qq_nickname :
         * wx_nickname :
         * aboutus_url : http://qmfq.baonongkang.cn/index.php?s=/Wap/helpcenter/index&id=17
         * ysxy_url : http://qmfq.baonongkang.cn/index.php?s=/Wap/helpcenter/index&id=3
         * fwxy_url : http://qmfq.baonongkang.cn/index.php?s=/Wap/helpcenter/index&id=1
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
        private String aboutus_url;
        private String ysxy_url;
        private String fwxy_url;

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

        public String getAboutus_url() {
            return aboutus_url;
        }

        public void setAboutus_url(String aboutus_url) {
            this.aboutus_url = aboutus_url;
        }

        public String getYsxy_url() {
            return ysxy_url;
        }

        public void setYsxy_url(String ysxy_url) {
            this.ysxy_url = ysxy_url;
        }

        public String getFwxy_url() {
            return fwxy_url;
        }

        public void setFwxy_url(String fwxy_url) {
            this.fwxy_url = fwxy_url;
        }
    }
}
