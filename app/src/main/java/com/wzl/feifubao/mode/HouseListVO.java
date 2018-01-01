package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2017/12/30.
 */

public class HouseListVO extends BaseVO {


    /**
     * data : {"house":[{"house_id":"12","house_title":"好房急租","house_name":"民发世界城","house_type":"高层","class_id":"6","house_area":"130","house_face":"南北","house_price":"3000","house_language":"16","house_pic":"http://183.95.85.31:8001//upload/image_collection/1513599867.jpg","renting_style_id":"20","province_id":"1","city_id":"1","apartment":"三室两厅","renting_style":"短租","area":"北京市北京市"},{"house_id":"11","house_title":"好房急租","house_name":"汉江梦","house_type":"高层","class_id":"6","house_area":"130","house_face":"南北","house_price":"3000","house_language":"15","house_pic":"http://183.95.85.31:8001//upload/image_collection/1513599867.jpg","renting_style_id":"19","province_id":"3","city_id":"7","apartment":"三室两厅","renting_style":"合租","area":"河北省邢台市"},{"house_id":"10","house_title":"好房急租","house_name":"绿地中央广场","house_type":"高层","class_id":"5","house_area":"130","house_face":"南北","house_price":"3000","house_language":"14","house_pic":"http://183.95.85.31:8001//upload/image_collection/1513599867.jpg","renting_style_id":"18","province_id":"4","city_id":"14","apartment":"三室一厅","renting_style":"整租","area":"山西省太原市"}],"advs":[{"id":"3","adv_image":"http://183.95.85.31:8001/upload/image_collection/1514193280.png","class_id":"1"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<HouseBean> house;
        private List<AdvsBean> advs;

        public List<HouseBean> getHouse() {
            return house;
        }

        public void setHouse(List<HouseBean> house) {
            this.house = house;
        }

        public List<AdvsBean> getAdvs() {
            return advs;
        }

        public void setAdvs(List<AdvsBean> advs) {
            this.advs = advs;
        }

        public static class HouseBean {
            /**
             * house_id : 12
             * house_title : 好房急租
             * house_name : 民发世界城
             * house_type : 高层
             * class_id : 6
             * house_area : 130
             * house_face : 南北
             * house_price : 3000
             * house_language : 16
             * house_pic : http://183.95.85.31:8001//upload/image_collection/1513599867.jpg
             * renting_style_id : 20
             * province_id : 1
             * city_id : 1
             * apartment : 三室两厅
             * renting_style : 短租
             * area : 北京市北京市
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

        public static class AdvsBean {
            /**
             * id : 3
             * adv_image : http://183.95.85.31:8001/upload/image_collection/1514193280.png
             * class_id : 1
             */

            private String id;
            private String adv_image;
            private String class_id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getAdv_image() {
                return adv_image;
            }

            public void setAdv_image(String adv_image) {
                this.adv_image = adv_image;
            }

            public String getClass_id() {
                return class_id;
            }

            public void setClass_id(String class_id) {
                this.class_id = class_id;
            }
        }
    }
}
