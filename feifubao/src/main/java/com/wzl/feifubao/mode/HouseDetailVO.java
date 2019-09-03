package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2017/12/30.
 */

public class HouseDetailVO extends BaseVO{


    /**
     * data : {"house_id":"74","house_name":"沃尔玛附近长住短住得可，拎包入住","house_price":"600","house_createtime":"2018-01-12","house_tag":"","class_id":"58","pay_class_id":"59","house_area":"50",
     * "province_id":"48","city_id":"659","house_face":"31","house_floor":"8","house_decorate":"24","house_type":"61","house_details":"经济实惠，拎包入住，全天热水，可用热水洗衣服，无线网络，免费停车场，出行方便，门口就是公交车站台(26-9-517路)
     * ，走路几分钟到沃尔玛","house_pic":["http://feidu.baonongkang.cn/upload/goods/20180112/dda18be83f12da40e364c675cdd1b7da.jpg","http://feidu.baonongkang
     * .cn/upload/goods/20180112/ca049bef34c826b1dae0b82608f102fe.jpg","http://feidu.baonongkang.cn/upload/goods/20180112/f7b21f723be7dde40353d68faf744fcd.jpg"],"status":"2",
     * "house_phone":"13476380438","sort":"0","house_title":"月租沃尔玛附近长住短住得可，拎包入住一室0厅","house_language":"16","renting_style_id":"60","uid":"0","out_trade_no":"151582477550301000","img_temp_array":[],
     * "apartment":"一室0厅","renting_style":"短租","decorateStyle":"中等装修","houseStyle":"公寓/酒店","position":"南北通透","house_language_names":["中文"],"user_headimg":"http://feidu.baonongkang
     * .cn/upload/avator/2017122020031226.jpg"}
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
         * house_id : 74
         * house_name : 沃尔玛附近长住短住得可，拎包入住
         * house_price : 600
         * house_createtime : 2018-01-12
         * house_tag :
         * class_id : 58
         * pay_class_id : 59
         * house_area : 50
         * province_id : 48
         * city_id : 659
         * house_face : 31
         * house_floor : 8
         * house_decorate : 24
         * house_type : 61
         * house_details : 经济实惠，拎包入住，全天热水，可用热水洗衣服，无线网络，免费停车场，出行方便，门口就是公交车站台(26-9-517路)，走路几分钟到沃尔玛
         * house_pic : ["http://feidu.baonongkang.cn/upload/goods/20180112/dda18be83f12da40e364c675cdd1b7da.jpg","http://feidu.baonongkang.cn/upload/goods/20180112/ca049bef34c826b1dae0b82608f102fe
         * .jpg","http://feidu.baonongkang.cn/upload/goods/20180112/f7b21f723be7dde40353d68faf744fcd.jpg"]
         * status : 2
         * house_phone : 13476380438
         * sort : 0
         * house_title : 月租沃尔玛附近长住短住得可，拎包入住一室0厅
         * house_language : 16
         * renting_style_id : 60
         * uid : 0
         * out_trade_no : 151582477550301000
         * img_temp_array : []
         * apartment : 一室0厅
         * renting_style : 短租
         * decorateStyle : 中等装修
         * houseStyle : 公寓/酒店
         * position : 南北通透
         * house_language_names : ["中文"]
         * user_headimg : http://feidu.baonongkang.cn/upload/avator/2017122020031226.jpg
         */

        private String house_id;
        private String house_name;
        private String house_price;
        private String house_createtime;
        private String house_tag;
        private String class_id;
        private String pay_class_id;
        private String house_area;
        private String province_id;
        private String city_id;
        private String house_face;
        private String house_floor;
        private String house_decorate;
        private String house_type;
        private String house_details;
        private String status;
        private String house_phone;
        private String sort;
        private String house_title;
        private String house_language;
        private String renting_style_id;
        private String uid;
        private String out_trade_no;
        private String apartment;
        private String renting_style;
        private String decorateStyle;
        private String houseStyle;
        private String position;
        private String user_headimg;
        private List<String> house_pic;
        private List<?> img_temp_array;
        private List<String> house_language_names;
        private String pay_class;
        private String nick_name;

        public String getPay_class() {
            return pay_class;
        }

        public void setPay_class(String pay_class) {
            this.pay_class = pay_class;
        }

        public String getNick_name() {
            return nick_name;
        }

        public void setNick_name(String nick_name) {
            this.nick_name = nick_name;
        }

        public String getHouse_id() {
            return house_id;
        }

        public void setHouse_id(String house_id) {
            this.house_id = house_id;
        }

        public String getHouse_name() {
            return house_name;
        }

        public void setHouse_name(String house_name) {
            this.house_name = house_name;
        }

        public String getHouse_price() {
            return house_price;
        }

        public void setHouse_price(String house_price) {
            this.house_price = house_price;
        }

        public String getHouse_createtime() {
            return house_createtime;
        }

        public void setHouse_createtime(String house_createtime) {
            this.house_createtime = house_createtime;
        }

        public String getHouse_tag() {
            return house_tag;
        }

        public void setHouse_tag(String house_tag) {
            this.house_tag = house_tag;
        }

        public String getClass_id() {
            return class_id;
        }

        public void setClass_id(String class_id) {
            this.class_id = class_id;
        }

        public String getPay_class_id() {
            return pay_class_id;
        }

        public void setPay_class_id(String pay_class_id) {
            this.pay_class_id = pay_class_id;
        }

        public String getHouse_area() {
            return house_area;
        }

        public void setHouse_area(String house_area) {
            this.house_area = house_area;
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

        public String getHouse_face() {
            return house_face;
        }

        public void setHouse_face(String house_face) {
            this.house_face = house_face;
        }

        public String getHouse_floor() {
            return house_floor;
        }

        public void setHouse_floor(String house_floor) {
            this.house_floor = house_floor;
        }

        public String getHouse_decorate() {
            return house_decorate;
        }

        public void setHouse_decorate(String house_decorate) {
            this.house_decorate = house_decorate;
        }

        public String getHouse_type() {
            return house_type;
        }

        public void setHouse_type(String house_type) {
            this.house_type = house_type;
        }

        public String getHouse_details() {
            return house_details;
        }

        public void setHouse_details(String house_details) {
            this.house_details = house_details;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getHouse_phone() {
            return house_phone;
        }

        public void setHouse_phone(String house_phone) {
            this.house_phone = house_phone;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public String getHouse_title() {
            return house_title;
        }

        public void setHouse_title(String house_title) {
            this.house_title = house_title;
        }

        public String getHouse_language() {
            return house_language;
        }

        public void setHouse_language(String house_language) {
            this.house_language = house_language;
        }

        public String getRenting_style_id() {
            return renting_style_id;
        }

        public void setRenting_style_id(String renting_style_id) {
            this.renting_style_id = renting_style_id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
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

        public String getDecorateStyle() {
            return decorateStyle;
        }

        public void setDecorateStyle(String decorateStyle) {
            this.decorateStyle = decorateStyle;
        }

        public String getHouseStyle() {
            return houseStyle;
        }

        public void setHouseStyle(String houseStyle) {
            this.houseStyle = houseStyle;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getUser_headimg() {
            return user_headimg;
        }

        public void setUser_headimg(String user_headimg) {
            this.user_headimg = user_headimg;
        }

        public List<String> getHouse_pic() {
            return house_pic;
        }

        public void setHouse_pic(List<String> house_pic) {
            this.house_pic = house_pic;
        }

        public List<?> getImg_temp_array() {
            return img_temp_array;
        }

        public void setImg_temp_array(List<?> img_temp_array) {
            this.img_temp_array = img_temp_array;
        }

        public List<String> getHouse_language_names() {
            return house_language_names;
        }

        public void setHouse_language_names(List<String> house_language_names) {
            this.house_language_names = house_language_names;
        }
    }
}

