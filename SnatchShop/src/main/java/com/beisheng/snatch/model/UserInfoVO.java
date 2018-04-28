package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/24.
 */

public class UserInfoVO extends BaseVO implements Serializable{

    /**
     * data : {"nickname":"武大郎","user_no":"10007","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180424/10c0b3df6d7891ce1973469537562e23.jpeg","flow":"0.20","coupon_count":"2","point":"15",
     * "balance":"15","jiguang_alias":"qmfq_11","sex":"0","user_tel":"18602727134","sex_text":"未知","qq_nickname":"潍渼の緈鍢","wx_nickname":"","aboutus_url":"http://qmfq.baonongkang.cn/index
     * .php?s=/Wap/helpcenter/index&id=17","ysxy_url":"http://qmfq.baonongkang.cn/index.php?s=/Wap/helpcenter/index&id=3","fwxy_url":"http://qmfq.baonongkang.cn/index
     * .php?s=/Wap/helpcenter/index&id=1","default_address":"广东省广州市东山区通用名图","recharge_banner":"http://qmfq.baonongkang.cn/public/static/images/recharge_banner.jpg",
     * "recharge_desc":"充值1元，获得0.01M流量，获赠1次疯抢资格。","smrz_banner":"http://qmfq.baonongkang.cn/public/static/images/smrz_banner.jpg"}
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
         * nickname : 武大郎
         * user_no : 10007
         * avatar : http://qmfq.baonongkang.cn/upload/avator/20180424/10c0b3df6d7891ce1973469537562e23.jpeg
         * flow : 0.20
         * coupon_count : 2
         * point : 15
         * balance : 15
         * jiguang_alias : qmfq_11
         * sex : 0
         * user_tel : 18602727134
         * sex_text : 未知
         * qq_nickname : 潍渼の緈鍢
         * wx_nickname :
         * aboutus_url : http://qmfq.baonongkang.cn/index.php?s=/Wap/helpcenter/index&id=17
         * ysxy_url : http://qmfq.baonongkang.cn/index.php?s=/Wap/helpcenter/index&id=3
         * fwxy_url : http://qmfq.baonongkang.cn/index.php?s=/Wap/helpcenter/index&id=1
         * default_address : 广东省广州市东山区通用名图
         * recharge_banner : http://qmfq.baonongkang.cn/public/static/images/recharge_banner.jpg
         * recharge_desc : 充值1元，获得0.01M流量，获赠1次疯抢资格。
         * smrz_banner : http://qmfq.baonongkang.cn/public/static/images/smrz_banner.jpg
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
        private String default_address;
        private String recharge_banner;
        private String recharge_desc;
        private String smrz_banner;
        private String user_tel_bind;

        public String getUser_tel_bind() {
            return user_tel_bind;
        }

        public void setUser_tel_bind(String user_tel_bind) {
            this.user_tel_bind = user_tel_bind;
        }

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

        public String getDefault_address() {
            return default_address;
        }

        public void setDefault_address(String default_address) {
            this.default_address = default_address;
        }

        public String getRecharge_banner() {
            return recharge_banner;
        }

        public void setRecharge_banner(String recharge_banner) {
            this.recharge_banner = recharge_banner;
        }

        public String getRecharge_desc() {
            return recharge_desc;
        }

        public void setRecharge_desc(String recharge_desc) {
            this.recharge_desc = recharge_desc;
        }

        public String getSmrz_banner() {
            return smrz_banner;
        }

        public void setSmrz_banner(String smrz_banner) {
            this.smrz_banner = smrz_banner;
        }
    }
}
