package com.beisheng.snatch.model;

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

    public static class DataBean {
        /**
         * id : 2
         * consigner : 金仁政
         * mobile : 18972221695
         * province : 湖北省
         * city : 襄阳市
         * district : 樊城区
         * address : 汉江创新创意产业园2楼
         * address_info : 湖北省襄阳市樊城区汉江创新创意产业园2楼
         * is_default : 1
         */

        private String id;
        private String consigner;
        private String mobile;
        private String province;
        private String city;
        private String district;
        private String address;
        private String address_info;
        private String is_default;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getAddress_info() {
            return address_info;
        }

        public void setAddress_info(String address_info) {
            this.address_info = address_info;
        }

        public String getIs_default() {
            return is_default;
        }

        public void setIs_default(String is_default) {
            this.is_default = is_default;
        }
    }
}
