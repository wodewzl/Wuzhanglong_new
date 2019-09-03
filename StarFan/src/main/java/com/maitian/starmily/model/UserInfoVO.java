package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;

/**
 * Created by ${Wuzhanglong} on 2019/3/30.
 */
public class UserInfoVO extends BaseVO implements Serializable {

    /**
     * obj : {"userId":4355,"userName":null,"nickname":"宇轩","phoneNo":null,"wechatNo":"oe82L1JIw_qQHv4a_RCAnHRR01rA","qqNo":null,"microblogNo":null,
     * "accessToken":"22_LNwmu6x9WIv3jACqelvS_0zMUOp4AuOmlMQ4aWlAEkXs049MZT27KpO0yStU6UruTrweXj-cb6wtcIv4-PCGJ93kQmPyxREjJHhtFmpBuCM","verifyCode":null,"exp":null,"sex":"1",
     * "iconUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","address":null,"cityName":null,
     * "cityCode":null,"birthday":null,"sign":null,"onlineStatus":null,"loginTime":null,"authType":null,"status":0,"registrationId":null,"lastloginType":null,"backUrl":null,"loginType":"2",
     * "idolType":0,"token":"201eb9ac2b08a26286e5d78a10e4f7ff"}
     */

    private ObjBean obj;

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean implements Serializable {
        /**
         * userId : 4355
         * userName : null
         * nickname : 宇轩
         * phoneNo : null
         * wechatNo : oe82L1JIw_qQHv4a_RCAnHRR01rA
         * qqNo : null
         * microblogNo : null
         * accessToken : 22_LNwmu6x9WIv3jACqelvS_0zMUOp4AuOmlMQ4aWlAEkXs049MZT27KpO0yStU6UruTrweXj-cb6wtcIv4-PCGJ93kQmPyxREjJHhtFmpBuCM
         * verifyCode : null
         * exp : null
         * sex : 1
         * iconUrl : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132
         * address : null
         * cityName : null
         * cityCode : null
         * birthday : null
         * sign : null
         * onlineStatus : null
         * loginTime : null
         * authType : null
         * status : 0
         * registrationId : null
         * lastloginType : null
         * backUrl : null
         * loginType : 2
         * idolType : 0
         * token : 201eb9ac2b08a26286e5d78a10e4f7ff
         */

        private int userId;
        private Object userName;
        private String nickname;
        private Object phoneNo;
        private String wechatNo;
        private Object qqNo;
        private Object microblogNo;
        private String accessToken;
        private Object verifyCode;
        private Object exp;
        private String sex;
        private String iconUrl;
        private Object address;
        private Object cityName;
        private Object cityCode;
        private Object birthday;
        private String sign;
        private Object onlineStatus;
        private Object loginTime;
        private Object authType;
        private int status;
        private Object registrationId;
        private Object lastloginType;
        private Object backUrl;
        private String loginType;
        private int idolType;
        private String token;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getUserName() {
            return userName;
        }

        public void setUserName(Object userName) {
            this.userName = userName;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(Object phoneNo) {
            this.phoneNo = phoneNo;
        }

        public String getWechatNo() {
            return wechatNo;
        }

        public void setWechatNo(String wechatNo) {
            this.wechatNo = wechatNo;
        }

        public Object getQqNo() {
            return qqNo;
        }

        public void setQqNo(Object qqNo) {
            this.qqNo = qqNo;
        }

        public Object getMicroblogNo() {
            return microblogNo;
        }

        public void setMicroblogNo(Object microblogNo) {
            this.microblogNo = microblogNo;
        }

        public String getAccessToken() {
            return accessToken;
        }

        public void setAccessToken(String accessToken) {
            this.accessToken = accessToken;
        }

        public Object getVerifyCode() {
            return verifyCode;
        }

        public void setVerifyCode(Object verifyCode) {
            this.verifyCode = verifyCode;
        }

        public Object getExp() {
            return exp;
        }

        public void setExp(Object exp) {
            this.exp = exp;
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

        public Object getAddress() {
            return address;
        }

        public void setAddress(Object address) {
            this.address = address;
        }

        public Object getCityName() {
            return cityName;
        }

        public void setCityName(Object cityName) {
            this.cityName = cityName;
        }

        public Object getCityCode() {
            return cityCode;
        }

        public void setCityCode(Object cityCode) {
            this.cityCode = cityCode;
        }

        public Object getBirthday() {
            return birthday;
        }

        public void setBirthday(Object birthday) {
            this.birthday = birthday;
        }

        public String getSign() {
            return sign;
        }

        public void setSign(String sign) {
            this.sign = sign;
        }

        public Object getOnlineStatus() {
            return onlineStatus;
        }

        public void setOnlineStatus(Object onlineStatus) {
            this.onlineStatus = onlineStatus;
        }

        public Object getLoginTime() {
            return loginTime;
        }

        public void setLoginTime(Object loginTime) {
            this.loginTime = loginTime;
        }

        public Object getAuthType() {
            return authType;
        }

        public void setAuthType(Object authType) {
            this.authType = authType;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public Object getRegistrationId() {
            return registrationId;
        }

        public void setRegistrationId(Object registrationId) {
            this.registrationId = registrationId;
        }

        public Object getLastloginType() {
            return lastloginType;
        }

        public void setLastloginType(Object lastloginType) {
            this.lastloginType = lastloginType;
        }

        public Object getBackUrl() {
            return backUrl;
        }

        public void setBackUrl(Object backUrl) {
            this.backUrl = backUrl;
        }

        public String getLoginType() {
            return loginType;
        }

        public void setLoginType(String loginType) {
            this.loginType = loginType;
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
