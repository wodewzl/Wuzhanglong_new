package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;

/**
 * Created by ${Wuzhanglong} on 2019/3/30.
 */
public class UserInfoVO extends BaseVO implements Serializable {

    /**
     * obj : {"userId":1,"userName":"樊舒桐","password":"","phoneNo":"","wechatNo":"","qqNo":"","nikename":"0","sex":"0女1男","iconUrl":"132.232.197.128/group1/M00/00/00/rBsAD1xvuPyAMAVMAABQespvTuM068.jpg","address":"武汉","cityName":"武汉","cityCode":"420100","sign":"不服就干","status":0,"registrationId":"","lastloginType":1,"backUrl":"","idolType":1,"token":""}
     */

    private ObjBean obj;

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean  implements Serializable {
        /**
         * userId : 1
         * userName : 樊舒桐
         * password :
         * phoneNo :
         * wechatNo :
         * qqNo :
         * nikename : 0
         * sex : 0女1男
         * iconUrl : 132.232.197.128/group1/M00/00/00/rBsAD1xvuPyAMAVMAABQespvTuM068.jpg
         * address : 武汉
         * cityName : 武汉
         * cityCode : 420100
         * sign : 不服就干
         * status : 0
         * registrationId :
         * lastloginType : 1
         * backUrl :
         * idolType : 1
         * token :
         */

        private int userId;
        private String userName;
        private String password;
        private String phoneNo;
        private String wechatNo;
        private String qqNo;
        private String nikename;
        private String sex;
        private String iconUrl;
        private String address;
        private String cityName;
        private String cityCode;
        private String sign;
        private int status;
        private String registrationId;
        private int lastloginType;
        private String backUrl;
        private int idolType;
        private String token;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getWechatNo() {
            return wechatNo;
        }

        public void setWechatNo(String wechatNo) {
            this.wechatNo = wechatNo;
        }

        public String getQqNo() {
            return qqNo;
        }

        public void setQqNo(String qqNo) {
            this.qqNo = qqNo;
        }

        public String getNikename() {
            return nikename;
        }

        public void setNikename(String nikename) {
            this.nikename = nikename;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getRegistrationId() {
            return registrationId;
        }

        public void setRegistrationId(String registrationId) {
            this.registrationId = registrationId;
        }

        public int getLastloginType() {
            return lastloginType;
        }

        public void setLastloginType(int lastloginType) {
            this.lastloginType = lastloginType;
        }

        public String getBackUrl() {
            return backUrl;
        }

        public void setBackUrl(String backUrl) {
            this.backUrl = backUrl;
        }

        public int getIdolType() {
            return idolType;
        }

        public void setIdolType(int idolType) {
            this.idolType = idolType;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }
    }
}
