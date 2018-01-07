package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/6.
 */

public class MyHouseVO extends BaseVO{

    /**
     * data : {"house":[{"house_id":"32","house_title":"整租 . 上海霞飞路 三室两厅","house_name":"上海霞飞路","house_type":"30","class_id":"6","house_area":"300","house_face":"31","house_price":"8888","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f01ca7b4.png","renting_style_id":"18","province_id":"9","city_id":"73","house_decorate":"25","pay_class_id":"12","house_floor":"189","house_phone":"13871732009","house_details":"好房看看咯酷酷兔可口可乐了快快乐乐咯莫哦哦按摩","apartment":"三室两厅","renting_style":"整租","area":"上海市上海市"},{"house_id":"31","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f47a0800.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343158","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"30","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f5437f93.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"29","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f65604ca.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"28","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f7d56d97.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"27","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f922506b.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"26","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519fa2c0f5c.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"25","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519fb06e7d8.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙空空的克隆不习惯吧","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"24","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519fc10e99d.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"23","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519fd243b96.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙涂涂秀","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"}],"total_count":"26","page_count":"3"}
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
         * house : [{"house_id":"32","house_title":"整租 . 上海霞飞路 三室两厅","house_name":"上海霞飞路","house_type":"30","class_id":"6","house_area":"300","house_face":"31","house_price":"8888","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f01ca7b4.png","renting_style_id":"18","province_id":"9","city_id":"73","house_decorate":"25","pay_class_id":"12","house_floor":"189","house_phone":"13871732009","house_details":"好房看看咯酷酷兔可口可乐了快快乐乐咯莫哦哦按摩","apartment":"三室两厅","renting_style":"整租","area":"上海市上海市"},{"house_id":"31","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f47a0800.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343158","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"30","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f5437f93.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"29","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f65604ca.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"28","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f7d56d97.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"27","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519f922506b.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"26","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519fa2c0f5c.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"25","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519fb06e7d8.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙空空的克隆不习惯吧","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"24","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519fc10e99d.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"},{"house_id":"23","house_title":"合租 . 明发新城 三室两厅","house_name":"明发新城","house_type":"29","class_id":"6","house_area":"127","house_face":"32","house_price":"12345","house_language":"15","house_pic":"http://183.95.85.31:8001/upload/house/5a519fd243b96.png","renting_style_id":"19","province_id":"26","city_id":"286","house_decorate":"24","pay_class_id":"12","house_floor":"15","house_phone":"13720343150","house_details":"恐龙涂涂秀","apartment":"三室两厅","renting_style":"合租","area":"西藏自治区阿里地区"}]
         * total_count : 26
         * page_count : 3
         */

        private String total_count;
        private String page_count;
        private List<HouseBean> house;

        public String getTotal_count() {
            return total_count;
        }

        public void setTotal_count(String total_count) {
            this.total_count = total_count;
        }

        public String getPage_count() {
            return page_count;
        }

        public void setPage_count(String page_count) {
            this.page_count = page_count;
        }

        public List<HouseBean> getHouse() {
            return house;
        }

        public void setHouse(List<HouseBean> house) {
            this.house = house;
        }

        public static class HouseBean {
            /**
             * house_id : 32
             * house_title : 整租 . 上海霞飞路 三室两厅
             * house_name : 上海霞飞路
             * house_type : 30
             * class_id : 6
             * house_area : 300
             * house_face : 31
             * house_price : 8888
             * house_language : 15
             * house_pic : http://183.95.85.31:8001/upload/house/5a519f01ca7b4.png
             * renting_style_id : 18
             * province_id : 9
             * city_id : 73
             * house_decorate : 25
             * pay_class_id : 12
             * house_floor : 189
             * house_phone : 13871732009
             * house_details : 好房看看咯酷酷兔可口可乐了快快乐乐咯莫哦哦按摩
             * apartment : 三室两厅
             * renting_style : 整租
             * area : 上海市上海市
             */

            private String house_id;
            private String house_title;
            private String house_name;
            private String house_type;
            private String class_id;
            private String house_area;
            private String house_face;
            private String house_price;
            private String house_language;
            private String house_pic;
            private String renting_style_id;
            private String province_id;
            private String city_id;
            private String house_decorate;
            private String pay_class_id;
            private String house_floor;
            private String house_phone;
            private String house_details;
            private String apartment;
            private String renting_style;
            private String area;

            public String getHouse_id() {
                return house_id;
            }

            public void setHouse_id(String house_id) {
                this.house_id = house_id;
            }

            public String getHouse_title() {
                return house_title;
            }

            public void setHouse_title(String house_title) {
                this.house_title = house_title;
            }

            public String getHouse_name() {
                return house_name;
            }

            public void setHouse_name(String house_name) {
                this.house_name = house_name;
            }

            public String getHouse_type() {
                return house_type;
            }

            public void setHouse_type(String house_type) {
                this.house_type = house_type;
            }

            public String getClass_id() {
                return class_id;
            }

            public void setClass_id(String class_id) {
                this.class_id = class_id;
            }

            public String getHouse_area() {
                return house_area;
            }

            public void setHouse_area(String house_area) {
                this.house_area = house_area;
            }

            public String getHouse_face() {
                return house_face;
            }

            public void setHouse_face(String house_face) {
                this.house_face = house_face;
            }

            public String getHouse_price() {
                return house_price;
            }

            public void setHouse_price(String house_price) {
                this.house_price = house_price;
            }

            public String getHouse_language() {
                return house_language;
            }

            public void setHouse_language(String house_language) {
                this.house_language = house_language;
            }

            public String getHouse_pic() {
                return house_pic;
            }

            public void setHouse_pic(String house_pic) {
                this.house_pic = house_pic;
            }

            public String getRenting_style_id() {
                return renting_style_id;
            }

            public void setRenting_style_id(String renting_style_id) {
                this.renting_style_id = renting_style_id;
            }

            public String getProvince_id() {
                return province_id;
            }

            public void setProvince_id(String province_id) {
                this.province_id = province_id;
            }

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getHouse_decorate() {
                return house_decorate;
            }

            public void setHouse_decorate(String house_decorate) {
                this.house_decorate = house_decorate;
            }

            public String getPay_class_id() {
                return pay_class_id;
            }

            public void setPay_class_id(String pay_class_id) {
                this.pay_class_id = pay_class_id;
            }

            public String getHouse_floor() {
                return house_floor;
            }

            public void setHouse_floor(String house_floor) {
                this.house_floor = house_floor;
            }

            public String getHouse_phone() {
                return house_phone;
            }

            public void setHouse_phone(String house_phone) {
                this.house_phone = house_phone;
            }

            public String getHouse_details() {
                return house_details;
            }

            public void setHouse_details(String house_details) {
                this.house_details = house_details;
            }

            public String getApartment() {
                return apartment;
            }

            public void setApartment(String apartment) {
                this.apartment = apartment;
            }

            public String getRenting_style() {
                return renting_style;
            }

            public void setRenting_style(String renting_style) {
                this.renting_style = renting_style;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
            }
        }
    }
}
