package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/24.
 */

public class UserInfoVO extends BaseVO implements Serializable{

    /**
     * data : {"uid":"43","instance_id":"0","user_name":"n180115118351","user_password":"96e79218965eb72c92a549dd5a330112","user_status":"1","user_headimg":"","is_system":"0","is_member":"1","user_tel":"944908457","user_tel_bind":"0","user_qq":"","qq_openid":"","qq_info":"","user_email":"944908457","user_email_bind":"0","wx_openid":"","wx_is_sub":"0","wx_info":"","other_info":"","current_login_ip":"59.172.180.118","current_login_type":"1","last_login_ip":"59.172.180.118","last_login_type":"1","login_num":"2","real_name":"","sex":"0","location":"","nick_name":"n180115118351","wx_unionid":"","qrcode_template_id":"0","wx_sub_time":"0","wx_notsub_time":"0","reg_time":"1516030799","current_login_time":"1516030835","last_login_time":"1516030799","birthday":"0","msg_status":"0"}
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
         * uid : 43
         * instance_id : 0
         * user_name : n180115118351
         * user_password : 96e79218965eb72c92a549dd5a330112
         * user_status : 1
         * user_headimg :
         * is_system : 0
         * is_member : 1
         * user_tel : 944908457
         * user_tel_bind : 0
         * user_qq :
         * qq_openid :
         * qq_info :
         * user_email : 944908457
         * user_email_bind : 0
         * wx_openid :
         * wx_is_sub : 0
         * wx_info :
         * other_info :
         * current_login_ip : 59.172.180.118
         * current_login_type : 1
         * last_login_ip : 59.172.180.118
         * last_login_type : 1
         * login_num : 2
         * real_name :
         * sex : 0
         * location :
         * nick_name : n180115118351
         * wx_unionid :
         * qrcode_template_id : 0
         * wx_sub_time : 0
         * wx_notsub_time : 0
         * reg_time : 1516030799
         * current_login_time : 1516030835
         * last_login_time : 1516030799
         * birthday : 0
         * msg_status : 0
         */

        private String uid;
        private String instance_id;
        private String user_name;
        private String user_password;
        private String user_status;
        private String user_headimg;
        private String is_system;
        private String is_member;
        private String user_tel;
        private String user_tel_bind;
        private String user_qq;
        private String qq_openid;
        private String qq_info;
        private String user_email;
        private String user_email_bind;
        private String wx_openid;
        private String wx_is_sub;
        private String wx_info;
        private String other_info;
        private String current_login_ip;
        private String current_login_type;
        private String last_login_ip;
        private String last_login_type;
        private String login_num;
        private String real_name;
        private String sex;
        private String location;
        private String nick_name;
        private String wx_unionid;
        private String qrcode_template_id;
        private String wx_sub_time;
        private String wx_notsub_time;
        private String reg_time;
        private String current_login_time;
        private String last_login_time;
        private String birthday;
        private String msg_status;

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getInstance_id() {
            return instance_id;
        }

        public void setInstance_id(String instance_id) {
            this.instance_id = instance_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getUser_password() {
            return user_password;
        }

        public void setUser_password(String user_password) {
            this.user_password = user_password;
        }

        public String getUser_status() {
            return user_status;
        }

        public void setUser_status(String user_status) {
            this.user_status = user_status;
        }

        public String getUser_headimg() {
            return user_headimg;
        }

        public void setUser_headimg(String user_headimg) {
            this.user_headimg = user_headimg;
        }

        public String getIs_system() {
            return is_system;
        }

        public void setIs_system(String is_system) {
            this.is_system = is_system;
        }

        public String getIs_member() {
            return is_member;
        }

        public void setIs_member(String is_member) {
            this.is_member = is_member;
        }

        public String getUser_tel() {
            return user_tel;
        }

        public void setUser_tel(String user_tel) {
            this.user_tel = user_tel;
        }

        public String getUser_tel_bind() {
            return user_tel_bind;
        }

        public void setUser_tel_bind(String user_tel_bind) {
            this.user_tel_bind = user_tel_bind;
        }

        public String getUser_qq() {
            return user_qq;
        }

        public void setUser_qq(String user_qq) {
            this.user_qq = user_qq;
        }

        public String getQq_openid() {
            return qq_openid;
        }

        public void setQq_openid(String qq_openid) {
            this.qq_openid = qq_openid;
        }

        public String getQq_info() {
            return qq_info;
        }

        public void setQq_info(String qq_info) {
            this.qq_info = qq_info;
        }

        public String getUser_email() {
            return user_email;
        }

        public void setUser_email(String user_email) {
            this.user_email = user_email;
        }

        public String getUser_email_bind() {
            return user_email_bind;
        }

        public void setUser_email_bind(String user_email_bind) {
            this.user_email_bind = user_email_bind;
        }

        public String getWx_openid() {
            return wx_openid;
        }

        public void setWx_openid(String wx_openid) {
            this.wx_openid = wx_openid;
        }

        public String getWx_is_sub() {
            return wx_is_sub;
        }

        public void setWx_is_sub(String wx_is_sub) {
            this.wx_is_sub = wx_is_sub;
        }

        public String getWx_info() {
            return wx_info;
        }

        public void setWx_info(String wx_info) {
            this.wx_info = wx_info;
        }

        public String getOther_info() {
            return other_info;
        }

        public void setOther_info(String other_info) {
            this.other_info = other_info;
        }

        public String getCurrent_login_ip() {
            return current_login_ip;
        }

        public void setCurrent_login_ip(String current_login_ip) {
            this.current_login_ip = current_login_ip;
        }

        public String getCurrent_login_type() {
            return current_login_type;
        }

        public void setCurrent_login_type(String current_login_type) {
            this.current_login_type = current_login_type;
        }

        public String getLast_login_ip() {
            return last_login_ip;
        }

        public void setLast_login_ip(String last_login_ip) {
            this.last_login_ip = last_login_ip;
        }

        public String getLast_login_type() {
            return last_login_type;
        }

        public void setLast_login_type(String last_login_type) {
            this.last_login_type = last_login_type;
        }

        public String getLogin_num() {
            return login_num;
        }

        public void setLogin_num(String login_num) {
            this.login_num = login_num;
        }

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getWx_unionid() {
            return wx_unionid;
        }

        public void setWx_unionid(String wx_unionid) {
            this.wx_unionid = wx_unionid;
        }

        public String getQrcode_template_id() {
            return qrcode_template_id;
        }

        public void setQrcode_template_id(String qrcode_template_id) {
            this.qrcode_template_id = qrcode_template_id;
        }

        public String getWx_sub_time() {
            return wx_sub_time;
        }

        public void setWx_sub_time(String wx_sub_time) {
            this.wx_sub_time = wx_sub_time;
        }

        public String getWx_notsub_time() {
            return wx_notsub_time;
        }

        public void setWx_notsub_time(String wx_notsub_time) {
            this.wx_notsub_time = wx_notsub_time;
        }

        public String getReg_time() {
            return reg_time;
        }

        public void setReg_time(String reg_time) {
            this.reg_time = reg_time;
        }

        public String getCurrent_login_time() {
            return current_login_time;
        }

        public void setCurrent_login_time(String current_login_time) {
            this.current_login_time = current_login_time;
        }

        public String getLast_login_time() {
            return last_login_time;
        }

        public void setLast_login_time(String last_login_time) {
            this.last_login_time = last_login_time;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getMsg_status() {
            return msg_status;
        }

        public void setMsg_status(String msg_status) {
            this.msg_status = msg_status;
        }
    }
}
