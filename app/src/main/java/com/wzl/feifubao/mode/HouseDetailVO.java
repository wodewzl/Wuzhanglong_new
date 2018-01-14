package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2017/12/30.
 */

public class HouseDetailVO extends BaseVO{

    /**
     * data : {"house_id":"81","house_name":"恐龙","house_price":"5","house_createtime":"2018-01-13","house_tag":"","class_id":"56","pay_class_id":"54","house_area":"5152","province_id":"30","city_id":"324","house_face":"32","house_floor":"33","house_decorate":"24","house_type":"30","house_details":"健健康康","house_pic":["http://feidu.baonongkang.cn/upload/house/5a59c152e0eaa.png"],"status":"2","house_phone":"13720343150","sort":"0","house_title":"合租 . 恐龙 两室两厅","house_language":"15,16","renting_style_id":"19","uid":"39","out_trade_no":"151583163413851000","img_temp_array":[{"pic_id":"342","shop_id":"0","album_id":"0","is_wide":"0","pic_name":"房源","pic_tag":"房源","pic_cover":"http://feidu.baonongkang.cn/upload/house/5a59c152e0eaa.png","pic_size":"","pic_spec":"","pic_cover_big":"","pic_size_big":"","pic_spec_big":"","pic_cover_mid":"","pic_size_mid":"","pic_spec_mid":"","pic_cover_small":"","pic_size_small":"","pic_spec_small":"","pic_cover_micro":"","pic_size_micro":"","pic_spec_micro":"","upload_time":"1515831634","upload_type":"0","domain":"","bucket":""}],"apartment":"两室两厅","renting_style":"合租","decorateStyle":"中等装修","houseStyle":"别墅","position":"正南正北","house_language_names":["英语","中文"]}
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
         * house_id : 81
         * house_name : 恐龙
         * house_price : 5
         * house_createtime : 2018-01-13
         * house_tag :
         * class_id : 56
         * pay_class_id : 54
         * house_area : 5152
         * province_id : 30
         * city_id : 324
         * house_face : 32
         * house_floor : 33
         * house_decorate : 24
         * house_type : 30
         * house_details : 健健康康
         * house_pic : ["http://feidu.baonongkang.cn/upload/house/5a59c152e0eaa.png"]
         * status : 2
         * house_phone : 13720343150
         * sort : 0
         * house_title : 合租 . 恐龙 两室两厅
         * house_language : 15,16
         * renting_style_id : 19
         * uid : 39
         * out_trade_no : 151583163413851000
         * img_temp_array : [{"pic_id":"342","shop_id":"0","album_id":"0","is_wide":"0","pic_name":"房源","pic_tag":"房源","pic_cover":"http://feidu.baonongkang.cn/upload/house/5a59c152e0eaa.png","pic_size":"","pic_spec":"","pic_cover_big":"","pic_size_big":"","pic_spec_big":"","pic_cover_mid":"","pic_size_mid":"","pic_spec_mid":"","pic_cover_small":"","pic_size_small":"","pic_spec_small":"","pic_cover_micro":"","pic_size_micro":"","pic_spec_micro":"","upload_time":"1515831634","upload_type":"0","domain":"","bucket":""}]
         * apartment : 两室两厅
         * renting_style : 合租
         * decorateStyle : 中等装修
         * houseStyle : 别墅
         * position : 正南正北
         * house_language_names : ["英语","中文"]
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
        private List<String> house_pic;
        private List<ImgTempArrayBean> img_temp_array;
        private List<String> house_language_names;

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

        public List<String> getHouse_pic() {
            return house_pic;
        }

        public void setHouse_pic(List<String> house_pic) {
            this.house_pic = house_pic;
        }

        public List<ImgTempArrayBean> getImg_temp_array() {
            return img_temp_array;
        }

        public void setImg_temp_array(List<ImgTempArrayBean> img_temp_array) {
            this.img_temp_array = img_temp_array;
        }

        public List<String> getHouse_language_names() {
            return house_language_names;
        }

        public void setHouse_language_names(List<String> house_language_names) {
            this.house_language_names = house_language_names;
        }

        public static class ImgTempArrayBean {
            /**
             * pic_id : 342
             * shop_id : 0
             * album_id : 0
             * is_wide : 0
             * pic_name : 房源
             * pic_tag : 房源
             * pic_cover : http://feidu.baonongkang.cn/upload/house/5a59c152e0eaa.png
             * pic_size :
             * pic_spec :
             * pic_cover_big :
             * pic_size_big :
             * pic_spec_big :
             * pic_cover_mid :
             * pic_size_mid :
             * pic_spec_mid :
             * pic_cover_small :
             * pic_size_small :
             * pic_spec_small :
             * pic_cover_micro :
             * pic_size_micro :
             * pic_spec_micro :
             * upload_time : 1515831634
             * upload_type : 0
             * domain :
             * bucket :
             */

            private String pic_id;
            private String shop_id;
            private String album_id;
            private String is_wide;
            private String pic_name;
            private String pic_tag;
            private String pic_cover;
            private String pic_size;
            private String pic_spec;
            private String pic_cover_big;
            private String pic_size_big;
            private String pic_spec_big;
            private String pic_cover_mid;
            private String pic_size_mid;
            private String pic_spec_mid;
            private String pic_cover_small;
            private String pic_size_small;
            private String pic_spec_small;
            private String pic_cover_micro;
            private String pic_size_micro;
            private String pic_spec_micro;
            private String upload_time;
            private String upload_type;
            private String domain;
            private String bucket;

            public String getPic_id() {
                return pic_id;
            }

            public void setPic_id(String pic_id) {
                this.pic_id = pic_id;
            }

            public String getShop_id() {
                return shop_id;
            }

            public void setShop_id(String shop_id) {
                this.shop_id = shop_id;
            }

            public String getAlbum_id() {
                return album_id;
            }

            public void setAlbum_id(String album_id) {
                this.album_id = album_id;
            }

            public String getIs_wide() {
                return is_wide;
            }

            public void setIs_wide(String is_wide) {
                this.is_wide = is_wide;
            }

            public String getPic_name() {
                return pic_name;
            }

            public void setPic_name(String pic_name) {
                this.pic_name = pic_name;
            }

            public String getPic_tag() {
                return pic_tag;
            }

            public void setPic_tag(String pic_tag) {
                this.pic_tag = pic_tag;
            }

            public String getPic_cover() {
                return pic_cover;
            }

            public void setPic_cover(String pic_cover) {
                this.pic_cover = pic_cover;
            }

            public String getPic_size() {
                return pic_size;
            }

            public void setPic_size(String pic_size) {
                this.pic_size = pic_size;
            }

            public String getPic_spec() {
                return pic_spec;
            }

            public void setPic_spec(String pic_spec) {
                this.pic_spec = pic_spec;
            }

            public String getPic_cover_big() {
                return pic_cover_big;
            }

            public void setPic_cover_big(String pic_cover_big) {
                this.pic_cover_big = pic_cover_big;
            }

            public String getPic_size_big() {
                return pic_size_big;
            }

            public void setPic_size_big(String pic_size_big) {
                this.pic_size_big = pic_size_big;
            }

            public String getPic_spec_big() {
                return pic_spec_big;
            }

            public void setPic_spec_big(String pic_spec_big) {
                this.pic_spec_big = pic_spec_big;
            }

            public String getPic_cover_mid() {
                return pic_cover_mid;
            }

            public void setPic_cover_mid(String pic_cover_mid) {
                this.pic_cover_mid = pic_cover_mid;
            }

            public String getPic_size_mid() {
                return pic_size_mid;
            }

            public void setPic_size_mid(String pic_size_mid) {
                this.pic_size_mid = pic_size_mid;
            }

            public String getPic_spec_mid() {
                return pic_spec_mid;
            }

            public void setPic_spec_mid(String pic_spec_mid) {
                this.pic_spec_mid = pic_spec_mid;
            }

            public String getPic_cover_small() {
                return pic_cover_small;
            }

            public void setPic_cover_small(String pic_cover_small) {
                this.pic_cover_small = pic_cover_small;
            }

            public String getPic_size_small() {
                return pic_size_small;
            }

            public void setPic_size_small(String pic_size_small) {
                this.pic_size_small = pic_size_small;
            }

            public String getPic_spec_small() {
                return pic_spec_small;
            }

            public void setPic_spec_small(String pic_spec_small) {
                this.pic_spec_small = pic_spec_small;
            }

            public String getPic_cover_micro() {
                return pic_cover_micro;
            }

            public void setPic_cover_micro(String pic_cover_micro) {
                this.pic_cover_micro = pic_cover_micro;
            }

            public String getPic_size_micro() {
                return pic_size_micro;
            }

            public void setPic_size_micro(String pic_size_micro) {
                this.pic_size_micro = pic_size_micro;
            }

            public String getPic_spec_micro() {
                return pic_spec_micro;
            }

            public void setPic_spec_micro(String pic_spec_micro) {
                this.pic_spec_micro = pic_spec_micro;
            }

            public String getUpload_time() {
                return upload_time;
            }

            public void setUpload_time(String upload_time) {
                this.upload_time = upload_time;
            }

            public String getUpload_type() {
                return upload_type;
            }

            public void setUpload_type(String upload_type) {
                this.upload_type = upload_type;
            }

            public String getDomain() {
                return domain;
            }

            public void setDomain(String domain) {
                this.domain = domain;
            }

            public String getBucket() {
                return bucket;
            }

            public void setBucket(String bucket) {
                this.bucket = bucket;
            }
        }
    }
}

