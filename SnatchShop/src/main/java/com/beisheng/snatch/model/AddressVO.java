package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2017/5/2.
 */

public class AddressVO extends BaseVO implements Serializable{

    /**
     * data : {"list":[{"id":"20","consigner":"最具体","mobile":"18654935558","province":"1","city":"1","district":"1","address":"下咯与接口","address_info":"111下咯与接口","is_default":"1"},{"id":"19",
     * "consigner":"吴打好","mobile":"18602727134","province":"24","city":"264","district":"2299","address":"投缘","address_info":"242642299投缘","is_default":"0"},{"id":"18","consigner":"吴大爷",
     * "mobile":"18602727134","province":"30","city":"320","district":"2747","address":"4级鸡鸡","address_info":"3032027474级鸡鸡","is_default":"0"},{"id":"17","consigner":"吴积极","mobile":"18602727134",
     * "province":"22","city":"234","district":"2028","address":"炫舞QQ","address_info":"222342028炫舞QQ","is_default":"0"},{"id":"16","consigner":"吴章龙","mobile":"1860227134","province":"30",
     * "city":"320","district":"2752","address":"陶玉玲木头","address_info":"303202752陶玉玲木头","is_default":"0"},{"id":"2","consigner":"金仁政","mobile":"18972221695","province":"湖北省","city":"襄阳市",
     * "district":"樊城区","address":"汉江创新创意产业园2楼","address_info":"湖北省襄阳市樊城区汉江创新创意产业园2楼","is_default":"0"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 20
             * consigner : 最具体
             * mobile : 18654935558
             * province : 1
             * city : 1
             * district : 1
             * address : 下咯与接口
             * address_info : 111下咯与接口
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
}
