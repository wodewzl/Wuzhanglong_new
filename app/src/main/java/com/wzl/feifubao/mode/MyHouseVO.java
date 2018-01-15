package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/6.
 */

public class MyHouseVO extends BaseVO{


    /**
     * data : {"house":[{"house_id":"88","house_title":"","house_name":"吴二少","house_type":"别墅","class_id":"55","house_area":"132","house_face":"正南正北","house_price":"1358","house_language":"14","house_pic":"http://feidu.baonongkang.cn/upload/house/5a5cd251c3817.jpeg","renting_style_id":"19","province_id":"40","city_id":"582","house_decorate":"中等装修","pay_class_id":"12","house_floor":"18","house_phone":"289666","house_details":"就问你租不租","status":"1","out_trade_no":"151603259394111000","house_language_names":["菲律宾语"],"pay_status":"0","pay_money":"0.10","pay_rmb":"0.01","apartment":"一室一厅","renting_style":"合租","area":"甲拉巴松大区八打雁市","decorateStyleName":"","positionName":""},{"house_id":"87","house_title":"","house_name":"吴二少","house_type":"别墅","class_id":"55","house_area":"132","house_face":"正南正北","house_price":"1358","house_language":"14","house_pic":"http://feidu.baonongkang.cn/upload/house/5a5cd23d04f9a.jpeg","renting_style_id":"19","province_id":"40","city_id":"582","house_decorate":"中等装修","pay_class_id":"12","house_floor":"18","house_phone":"289666","house_details":"就问你租不租","status":"1","out_trade_no":"151603257346171000","house_language_names":["菲律宾语"],"pay_status":"0","pay_money":"0.10","pay_rmb":"0.01","apartment":"一室一厅","renting_style":"合租","area":"甲拉巴松大区八打雁市","decorateStyleName":"","positionName":""},{"house_id":"85","house_title":"","house_name":"吴章龙","house_type":"住宅","class_id":"57","house_area":"123","house_face":"正南正北","house_price":"123","house_language":"16","house_pic":"http://feidu.baonongkang.cn/upload/house/5a5ccfb743103.jpeg","renting_style_id":"60","province_id":"35","city_id":"520","house_decorate":"中等装修","pay_class_id":"54","house_floor":"18","house_phone":"1836856856","house_details":"5句我们","status":"1","out_trade_no":"151603192785131000","house_language_names":["中文"],"pay_status":"0","pay_money":"0.10","pay_rmb":"0.01","apartment":"两室一厅","renting_style":"月租","area":"中米沙鄢杜马格特市","decorateStyleName":"","positionName":""}],"total_count":"3","page_count":"1"}
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
         * house : [{"house_id":"88","house_title":"","house_name":"吴二少","house_type":"别墅","class_id":"55","house_area":"132","house_face":"正南正北","house_price":"1358","house_language":"14","house_pic":"http://feidu.baonongkang.cn/upload/house/5a5cd251c3817.jpeg","renting_style_id":"19","province_id":"40","city_id":"582","house_decorate":"中等装修","pay_class_id":"12","house_floor":"18","house_phone":"289666","house_details":"就问你租不租","status":"1","out_trade_no":"151603259394111000","house_language_names":["菲律宾语"],"pay_status":"0","pay_money":"0.10","pay_rmb":"0.01","apartment":"一室一厅","renting_style":"合租","area":"甲拉巴松大区八打雁市","decorateStyleName":"","positionName":""},{"house_id":"87","house_title":"","house_name":"吴二少","house_type":"别墅","class_id":"55","house_area":"132","house_face":"正南正北","house_price":"1358","house_language":"14","house_pic":"http://feidu.baonongkang.cn/upload/house/5a5cd23d04f9a.jpeg","renting_style_id":"19","province_id":"40","city_id":"582","house_decorate":"中等装修","pay_class_id":"12","house_floor":"18","house_phone":"289666","house_details":"就问你租不租","status":"1","out_trade_no":"151603257346171000","house_language_names":["菲律宾语"],"pay_status":"0","pay_money":"0.10","pay_rmb":"0.01","apartment":"一室一厅","renting_style":"合租","area":"甲拉巴松大区八打雁市","decorateStyleName":"","positionName":""},{"house_id":"85","house_title":"","house_name":"吴章龙","house_type":"住宅","class_id":"57","house_area":"123","house_face":"正南正北","house_price":"123","house_language":"16","house_pic":"http://feidu.baonongkang.cn/upload/house/5a5ccfb743103.jpeg","renting_style_id":"60","province_id":"35","city_id":"520","house_decorate":"中等装修","pay_class_id":"54","house_floor":"18","house_phone":"1836856856","house_details":"5句我们","status":"1","out_trade_no":"151603192785131000","house_language_names":["中文"],"pay_status":"0","pay_money":"0.10","pay_rmb":"0.01","apartment":"两室一厅","renting_style":"月租","area":"中米沙鄢杜马格特市","decorateStyleName":"","positionName":""}]
         * total_count : 3
         * page_count : 1
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
             * house_id : 88
             * house_title :
             * house_name : 吴二少
             * house_type : 别墅
             * class_id : 55
             * house_area : 132
             * house_face : 正南正北
             * house_price : 1358
             * house_language : 14
             * house_pic : http://feidu.baonongkang.cn/upload/house/5a5cd251c3817.jpeg
             * renting_style_id : 19
             * province_id : 40
             * city_id : 582
             * house_decorate : 中等装修
             * pay_class_id : 12
             * house_floor : 18
             * house_phone : 289666
             * house_details : 就问你租不租
             * status : 1
             * out_trade_no : 151603259394111000
             * house_language_names : ["菲律宾语"]
             * pay_status : 0
             * pay_money : 0.10
             * pay_rmb : 0.01
             * apartment : 一室一厅
             * renting_style : 合租
             * area : 甲拉巴松大区八打雁市
             * decorateStyleName :
             * positionName :
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
            private String status;
            private String out_trade_no;
            private String pay_status;
            private String pay_money;
            private String pay_rmb;
            private String apartment;
            private String renting_style;
            private String area;
            private String decorateStyleName;
            private String positionName;
            private List<String> house_language_names;

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

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getOut_trade_no() {
                return out_trade_no;
            }

            public void setOut_trade_no(String out_trade_no) {
                this.out_trade_no = out_trade_no;
            }

            public String getPay_status() {
                return pay_status;
            }

            public void setPay_status(String pay_status) {
                this.pay_status = pay_status;
            }

            public String getPay_money() {
                return pay_money;
            }

            public void setPay_money(String pay_money) {
                this.pay_money = pay_money;
            }

            public String getPay_rmb() {
                return pay_rmb;
            }

            public void setPay_rmb(String pay_rmb) {
                this.pay_rmb = pay_rmb;
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

            public String getDecorateStyleName() {
                return decorateStyleName;
            }

            public void setDecorateStyleName(String decorateStyleName) {
                this.decorateStyleName = decorateStyleName;
            }

            public String getPositionName() {
                return positionName;
            }

            public void setPositionName(String positionName) {
                this.positionName = positionName;
            }

            public List<String> getHouse_language_names() {
                return house_language_names;
            }

            public void setHouse_language_names(List<String> house_language_names) {
                this.house_language_names = house_language_names;
            }
        }
    }
}
