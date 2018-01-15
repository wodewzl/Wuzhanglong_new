package com.wzl.feifubao.mode;


import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class HomeVO extends BaseVO{


    /**
     * data : {"advs":[{"id":"2","adv_image":"http://183.95.85.31:8001/upload/image_collection/1513599867.jpg","class_id":"1"},{"id":"1","adv_image":"http://183.95.85.31:8001/upload/image_collection/1513599832.jpg","class_id":"3"}],"articles":[{"article_id":"2","title":"习近平引领中国经济向高质量发展阶段迈进"},{"article_id":"3","title":"习近平引领中国经济向高质量发展阶段迈进"}],"huo":[{"id":"3","adv_image":"http://183.95.85.31:8001/upload/image_collection/1513935675.png","class_id":"1"},{"id":"2","adv_image":"http://183.95.85.31:8001/upload/image_collection/1513935517.png","class_id":"3"}],"goods":[{"goods_id":"2","goods_name":"小包包","description":"买手推荐的小包包","pic_cover_small":"http://183.95.85.31:8001/upload/goods/20171222/b572af59fcf657e46c0021b647cd19b33.png"}],"house":[{"house_title":"好房急租","house_pic":"http://183.95.85.31:8001//upload/image_collection/1513599867.jpg","class_id":"6","house_area":"130","house_name":"民发世界城","house_price":"3000","house_tag":"南北通透;绿化好","province_id":"1","city_id":"1","apartment":"三室两厅","province":"北京市","city":"北京市"},{"house_title":"好房急租","house_pic":"http://183.95.85.31:8001//upload/image_collection/1513599867.jpg","class_id":"6","house_area":"130","house_name":"汉江梦","house_price":"3000","house_tag":"南北通透;绿化好","province_id":"3","city_id":"7","apartment":"三室两厅","province":"河北省","city":"邢台市"},{"house_title":"好房急租","house_pic":"http://183.95.85.31:8001//upload/image_collection/1513599867.jpg","class_id":"5","house_area":"130","house_name":"绿地中央广场","house_price":"3000","house_tag":"南北通透;绿化好","province_id":"4","city_id":"14","apartment":"三室一厅","province":"山西省","city":"太原市"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<AdvsBean> advs;
        private List<ArticlesBean> articles;
        private List<HuoBean> huo;
        private List<GoodsBean> goods;
        private List<HouseBean> house;

        public List<AdvsBean> getAdvs() {
            return advs;
        }

        public void setAdvs(List<AdvsBean> advs) {
            this.advs = advs;
        }

        public List<ArticlesBean> getArticles() {
            return articles;
        }

        public void setArticles(List<ArticlesBean> articles) {
            this.articles = articles;
        }

        public List<HuoBean> getHuo() {
            return huo;
        }

        public void setHuo(List<HuoBean> huo) {
            this.huo = huo;
        }

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public List<HouseBean> getHouse() {
            return house;
        }

        public void setHouse(List<HouseBean> house) {
            this.house = house;
        }

        public static class AdvsBean {
            /**
             * id : 2
             * adv_image : http://183.95.85.31:8001/upload/image_collection/1513599867.jpg
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

        public static class ArticlesBean {
            /**
             * article_id : 2
             * title : 习近平引领中国经济向高质量发展阶段迈进
             */

            private String article_id;
            private String title;

            public String getArticle_id() {
                return article_id;
            }

            public void setArticle_id(String article_id) {
                this.article_id = article_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class HuoBean {
            /**
             * id : 3
             * adv_image : http://183.95.85.31:8001/upload/image_collection/1513935675.png
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

        public static class GoodsBean {
            /**
             * goods_id : 2
             * goods_name : 小包包
             * description : 买手推荐的小包包
             * pic_cover_small : http://183.95.85.31:8001/upload/goods/20171222/b572af59fcf657e46c0021b647cd19b33.png
             */

            private String goods_id;
            private String goods_name;
            private String description;
            private String pic_cover_small;

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getPic_cover_small() {
                return pic_cover_small;
            }

            public void setPic_cover_small(String pic_cover_small) {
                this.pic_cover_small = pic_cover_small;
            }
        }

        public static class HouseBean {
            /**
             * house_title : 好房急租
             * house_pic : http://183.95.85.31:8001//upload/image_collection/1513599867.jpg
             * class_id : 6
             * house_area : 130
             * house_name : 民发世界城
             * house_price : 3000
             * house_tag : 南北通透;绿化好
             * province_id : 1
             * city_id : 1
             * apartment : 三室两厅
             * province : 北京市
             * city : 北京市
             */

            private String house_title;
            private String house_pic;
            private String class_id;
            private String house_area;
            private String house_name;
            private String house_price;
            private String house_tag;
            private String province_id;
            private String city_id;
            private String apartment;
            private String province;
            private String city;
            private String house_id;
            private String house_face_name;

            public String getHouse_face_name() {
                return house_face_name;
            }

            public void setHouse_face_name(String house_face_name) {
                this.house_face_name = house_face_name;
            }

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

            public String getHouse_pic() {
                return house_pic;
            }

            public void setHouse_pic(String house_pic) {
                this.house_pic = house_pic;
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

            public String getHouse_tag() {
                return house_tag;
            }

            public void setHouse_tag(String house_tag) {
                this.house_tag = house_tag;
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
        }
    }
}
