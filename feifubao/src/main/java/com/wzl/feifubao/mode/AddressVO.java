package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2017/5/2.
 */

public class AddressVO extends BaseVO implements Serializable{

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean  implements Serializable{
        /**
         * id : 6
         * uid : 40
         * consigner : 吴章龙
         * mobile : 18602727134
         * phone : 18602727134
         * province : 1
         * city : 1
         * district : 1
         * address : 图文信息雨无图
         * zip_code :
         * alias :
         * is_default : 1
         * address_info : 北京市-北京市-东城区
         */

        private String id;
        private String uid;
        private String consigner;
        private String mobile;
        private String phone;
        private String province;
        private String city;
        private String district;
        private String address;
        private String zip_code;
        private String alias;
        private String is_default;
        private String address_info;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getConsigner() {
            return consigner;
        }

        public void setConsigner(String consigner) {
            this.consigner = consigner;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getZip_code() {
            return zip_code;
        }

        public void setZip_code(String zip_code) {
            this.zip_code = zip_code;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public String getIs_default() {
            return is_default;
        }

        public void setIs_default(String is_default) {
            this.is_default = is_default;
        }

        public String getAddress_info() {
            return address_info;
        }

        public void setAddress_info(String address_info) {
            this.address_info = address_info;
        }
    }
}
