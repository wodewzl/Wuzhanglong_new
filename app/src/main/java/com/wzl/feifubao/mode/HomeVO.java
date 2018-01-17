package com.wzl.feifubao.mode;


import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class HomeVO extends BaseVO{

    /**
     * data : {"advs":[{"id":"74","adv_image":"http://feidu.baonongkang.cn/upload/image_collection/1515759661.jpg","class_id":"1"},{"id":"3","adv_image":"http://feidu.baonongkang
     * .cn/upload/image_collection/1515740625.png","class_id":"3"}],"articles":{"news":[{"article_id":"22","title":"中国-东盟国际汽车拉力赛首次抵达菲律宾","content":"http://feidu.baonongkang.cn/index
     * .php?s=/wap/articlecenter/articleContent/article_id/22","status":"0"}]},"huo":[{"id":"29","adv_image":"http://feidu.baonongkang.cn/upload/image_collection/1515760464.jpg","class_id":"3",
     * "content":""},{"id":"23","adv_image":"http://feidu.baonongkang.cn/upload/image_collection/1515760449.jpg","class_id":"3","content":""}],"goods":[{"goods_id":"27",
     * "goods_name":"【官方旗舰店】paparecipe 春雨蜂蜜面膜正品 春雨补水面膜旗舰店","description":"正品保障100%海外原装正品：所有商品均属海外生产或销售；因此，所售商品一律为100%海外原装正品。&nbsp;了解详情&gt;&gt;","pic_cover_small":"http://feidu.baonongkang
     * .cn/upload/goods/20180109/85ba209f0430a5d2f4cceba9318a43fc3.png"}],"house":[{"house_id":"89","house_title":"合租·襄阳两室两厅","house_pic":"http://feidu.baonongkang
     * .cn/upload/house/5a5eb1f625f38.png","class_id":"56","house_area":"888","house_name":"襄阳","house_price":"633","house_tag":"","province_id":"43","city_id":"629","house_decorate":"24",
     * "house_face":"32","house_language":"14,15","apartment":"两室两厅","province":"西米沙鄢大区","city":"埃斯卡兰特市","house_face_name":"正南正北","house_language_names":["菲律宾语","英语"],"house_decorate_name":"中等装修",
     * "area":"西米沙鄢大区埃斯卡兰特市"},{"house_id":"88","house_title":"合租吴二少一室一厅","house_pic":"http://feidu.baonongkang.cn/upload/house/5a5cd251c3817.jpeg","class_id":"55","house_area":"132",
     * "house_name":"吴二少","house_price":"1358","house_tag":"","province_id":"40","city_id":"582","house_decorate":"23","house_face":"31","house_language":"14","apartment":"一室一厅",
     * "province":"甲拉巴松大区","city":"八打雁市","house_face_name":"南北通透","house_language_names":["菲律宾语"],"house_decorate_name":"普通装修","area":"甲拉巴松大区八打雁市"},{"house_id":"86","house_title":"整租·Belton
     * Place一室一厅","house_pic":"http://feidu.baonongkang.cn/upload/house/5a5ccffb3335e.png","class_id":"55","house_area":"50","house_name":"Belton Place","house_price":"20000","house_tag":"",
     * "province_id":"37","city_id":"547","house_decorate":"23","house_face":"31","house_language":"14,15,16","apartment":"一室一厅","province":"伊罗戈斯大区","city":"坎东市","house_face_name":"南北通透",
     * "house_language_names":["菲律宾语","英语","中文"],"house_decorate_name":"普通装修","area":"伊罗戈斯大区坎东市"},{"house_id":"84","house_title":"合租上海霞飞路三室两厅","house_pic":"http://feidu.baonongkang
     * .cn/upload/house/5a5b1dd706495.png","class_id":"6","house_area":"239","house_name":"上海霞飞路","house_price":"123","house_tag":"","province_id":"36","city_id":"537","house_decorate":"24",
     * "house_face":"32","house_language":"14,15,16","apartment":"三室两厅","province":"科迪勒拉行政区","city":"邦贵","house_face_name":"正南正北","house_language_names":["菲律宾语","英语","中文"],
     * "house_decorate_name":"中等装修","area":"科迪勒拉行政区邦贵"},{"house_id":"81","house_title":"合租恐龙两室两厅","house_pic":"http://feidu.baonongkang.cn/upload/house/5a59c152e0eaa.png","class_id":"56",
     * "house_area":"5152","house_name":"恐龙","house_price":"5","house_tag":"","province_id":"40","city_id":"582","house_decorate":"24","house_face":"32","house_language":"15,16","apartment":"两室两厅",
     * "province":"甲拉巴松大区","city":"八打雁市","house_face_name":"正南正北","house_language_names":["英语","中文"],"house_decorate_name":"中等装修","area":"甲拉巴松大区八打雁市"},{"house_id":"80","house_title":"合租啊啊啊摸摸摸一室一厅",
     * "house_pic":"http://feidu.baonongkang.cn/upload/house/5a59b525d538f.png","class_id":"55","house_area":"23","house_name":"啊啊啊摸摸摸","house_price":"233","house_tag":"","province_id":"40",
     * "city_id":"599","house_decorate":"24","house_face":"32","house_language":"15","apartment":"一室一厅","province":"甲拉巴松大区","city":"比南","house_face_name":"正南正北","house_language_names":["英语"],
     * "house_decorate_name":"中等装修","area":"甲拉巴松大区比南"},{"house_id":"79","house_title":"合租武汉江夏区两室两厅","house_pic":"http://feidu.baonongkang.cn/upload/house/5a59b366c586b.png","class_id":"56",
     * "house_area":"566","house_name":"武汉江夏区","house_price":"888","house_tag":"","province_id":"48","city_id":"660","house_decorate":"24","house_face":"31","house_language":"15",
     * "apartment":"两室两厅","province":"棉兰老穆斯林自治区","city":"霍洛","house_face_name":"南北通透","house_language_names":["英语"],"house_decorate_name":"中等装修","area":"棉兰老穆斯林自治区霍洛"},{"house_id":"78",
     * "house_title":"合租上海霞飞路一室一厅","house_pic":"http://feidu.baonongkang.cn/upload/house/5a59a8dddb72e.png","class_id":"55","house_area":"553","house_name":"上海霞飞路","house_price":"123",
     * "house_tag":"","province_id":"48","city_id":"661","house_decorate":"24","house_face":"32","house_language":"15","apartment":"一室一厅","province":"棉兰老穆斯林自治区","city":"邦奥",
     * "house_face_name":"正南正北","house_language_names":["英语"],"house_decorate_name":"中等装修","area":"棉兰老穆斯林自治区邦奥"},{"house_id":"77","house_title":"合租武汉霞飞上海三室两厅","house_pic":"http://feidu.baonongkang
     * .cn/upload/house/5a59b49020c53.png","class_id":"6","house_area":"127","house_name":"武汉霞飞上海","house_price":"888","house_tag":"","province_id":"35","city_id":"526","house_decorate":"23",
     * "house_face":"32","house_language":"14,15,16","apartment":"三室两厅","province":"中米沙鄢","city":"宿务市","house_face_name":"正南正北","house_language_names":["菲律宾语","英语","中文"],
     * "house_decorate_name":"普通装修","area":"中米沙鄢宿务市"},{"house_id":"74","house_title":"月租沃尔玛附近长住短住得可，拎包入住一室0厅","house_pic":"http://feidu.baonongkang
     * .cn/upload/goods/20180112/dda18be83f12da40e364c675cdd1b7da.jpg","class_id":"58","house_area":"50","house_name":"沃尔玛附近长住短住得可，拎包入住","house_price":"600","house_tag":"","province_id":"48",
     * "city_id":"659","house_decorate":"24","house_face":"31","house_language":"16","apartment":"一室0厅","province":"棉兰老穆斯林自治区","city":"谢里夫阿瓜克","house_face_name":"南北通透",
     * "house_language_names":["中文"],"house_decorate_name":"中等装修","area":"棉兰老穆斯林自治区谢里夫阿瓜克"}],"msgStatus":"0","electricity_bill":"http://feidu.baonongkang.cn/index
     * .php?s=/wap/articlecenter/articleContent/article_id/23"}
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
         * advs : [{"id":"74","adv_image":"http://feidu.baonongkang.cn/upload/image_collection/1515759661.jpg","class_id":"1"},{"id":"3","adv_image":"http://feidu.baonongkang
         * .cn/upload/image_collection/1515740625.png","class_id":"3"}]
         * articles : {"news":[{"article_id":"22","title":"中国-东盟国际汽车拉力赛首次抵达菲律宾","content":"http://feidu.baonongkang.cn/index.php?s=/wap/articlecenter/articleContent/article_id/22","status":"0"}]}
         * huo : [{"id":"29","adv_image":"http://feidu.baonongkang.cn/upload/image_collection/1515760464.jpg","class_id":"3","content":""},{"id":"23","adv_image":"http://feidu.baonongkang
         * .cn/upload/image_collection/1515760449.jpg","class_id":"3","content":""}]
         * goods : [{"goods_id":"27","goods_name":"【官方旗舰店】paparecipe 春雨蜂蜜面膜正品 春雨补水面膜旗舰店","description":"正品保障100%海外原装正品：所有商品均属海外生产或销售；因此，所售商品一律为100%海外原装正品。&nbsp;了解详情&gt;&gt;",
         * "pic_cover_small":"http://feidu.baonongkang.cn/upload/goods/20180109/85ba209f0430a5d2f4cceba9318a43fc3.png"}]
         * house : [{"house_id":"89","house_title":"合租·襄阳两室两厅","house_pic":"http://feidu.baonongkang.cn/upload/house/5a5eb1f625f38.png","class_id":"56","house_area":"888","house_name":"襄阳",
         * "house_price":"633","house_tag":"","province_id":"43","city_id":"629","house_decorate":"24","house_face":"32","house_language":"14,15","apartment":"两室两厅","province":"西米沙鄢大区",
         * "city":"埃斯卡兰特市","house_face_name":"正南正北","house_language_names":["菲律宾语","英语"],"house_decorate_name":"中等装修","area":"西米沙鄢大区埃斯卡兰特市"},{"house_id":"88","house_title":"合租吴二少一室一厅",
         * "house_pic":"http://feidu.baonongkang.cn/upload/house/5a5cd251c3817.jpeg","class_id":"55","house_area":"132","house_name":"吴二少","house_price":"1358","house_tag":"","province_id":"40",
         * "city_id":"582","house_decorate":"23","house_face":"31","house_language":"14","apartment":"一室一厅","province":"甲拉巴松大区","city":"八打雁市","house_face_name":"南北通透",
         * "house_language_names":["菲律宾语"],"house_decorate_name":"普通装修","area":"甲拉巴松大区八打雁市"},{"house_id":"86","house_title":"整租·Belton Place一室一厅","house_pic":"http://feidu.baonongkang
         * .cn/upload/house/5a5ccffb3335e.png","class_id":"55","house_area":"50","house_name":"Belton Place","house_price":"20000","house_tag":"","province_id":"37","city_id":"547",
         * "house_decorate":"23","house_face":"31","house_language":"14,15,16","apartment":"一室一厅","province":"伊罗戈斯大区","city":"坎东市","house_face_name":"南北通透","house_language_names":["菲律宾语","英语",
         * "中文"],"house_decorate_name":"普通装修","area":"伊罗戈斯大区坎东市"},{"house_id":"84","house_title":"合租上海霞飞路三室两厅","house_pic":"http://feidu.baonongkang.cn/upload/house/5a5b1dd706495.png",
         * "class_id":"6","house_area":"239","house_name":"上海霞飞路","house_price":"123","house_tag":"","province_id":"36","city_id":"537","house_decorate":"24","house_face":"32","house_language":"14,
         * 15,16","apartment":"三室两厅","province":"科迪勒拉行政区","city":"邦贵","house_face_name":"正南正北","house_language_names":["菲律宾语","英语","中文"],"house_decorate_name":"中等装修","area":"科迪勒拉行政区邦贵"},
         * {"house_id":"81","house_title":"合租恐龙两室两厅","house_pic":"http://feidu.baonongkang.cn/upload/house/5a59c152e0eaa.png","class_id":"56","house_area":"5152","house_name":"恐龙",
         * "house_price":"5","house_tag":"","province_id":"40","city_id":"582","house_decorate":"24","house_face":"32","house_language":"15,16","apartment":"两室两厅","province":"甲拉巴松大区","city":"八打雁市",
         * "house_face_name":"正南正北","house_language_names":["英语","中文"],"house_decorate_name":"中等装修","area":"甲拉巴松大区八打雁市"},{"house_id":"80","house_title":"合租啊啊啊摸摸摸一室一厅","house_pic":"http://feidu
         * .baonongkang.cn/upload/house/5a59b525d538f.png","class_id":"55","house_area":"23","house_name":"啊啊啊摸摸摸","house_price":"233","house_tag":"","province_id":"40","city_id":"599",
         * "house_decorate":"24","house_face":"32","house_language":"15","apartment":"一室一厅","province":"甲拉巴松大区","city":"比南","house_face_name":"正南正北","house_language_names":["英语"],
         * "house_decorate_name":"中等装修","area":"甲拉巴松大区比南"},{"house_id":"79","house_title":"合租武汉江夏区两室两厅","house_pic":"http://feidu.baonongkang.cn/upload/house/5a59b366c586b.png","class_id":"56",
         * "house_area":"566","house_name":"武汉江夏区","house_price":"888","house_tag":"","province_id":"48","city_id":"660","house_decorate":"24","house_face":"31","house_language":"15",
         * "apartment":"两室两厅","province":"棉兰老穆斯林自治区","city":"霍洛","house_face_name":"南北通透","house_language_names":["英语"],"house_decorate_name":"中等装修","area":"棉兰老穆斯林自治区霍洛"},{"house_id":"78",
         * "house_title":"合租上海霞飞路一室一厅","house_pic":"http://feidu.baonongkang.cn/upload/house/5a59a8dddb72e.png","class_id":"55","house_area":"553","house_name":"上海霞飞路","house_price":"123",
         * "house_tag":"","province_id":"48","city_id":"661","house_decorate":"24","house_face":"32","house_language":"15","apartment":"一室一厅","province":"棉兰老穆斯林自治区","city":"邦奥",
         * "house_face_name":"正南正北","house_language_names":["英语"],"house_decorate_name":"中等装修","area":"棉兰老穆斯林自治区邦奥"},{"house_id":"77","house_title":"合租武汉霞飞上海三室两厅","house_pic":"http://feidu
         * .baonongkang.cn/upload/house/5a59b49020c53.png","class_id":"6","house_area":"127","house_name":"武汉霞飞上海","house_price":"888","house_tag":"","province_id":"35","city_id":"526",
         * "house_decorate":"23","house_face":"32","house_language":"14,15,16","apartment":"三室两厅","province":"中米沙鄢","city":"宿务市","house_face_name":"正南正北","house_language_names":["菲律宾语","英语","中文"],
         * "house_decorate_name":"普通装修","area":"中米沙鄢宿务市"},{"house_id":"74","house_title":"月租沃尔玛附近长住短住得可，拎包入住一室0厅","house_pic":"http://feidu.baonongkang
         * .cn/upload/goods/20180112/dda18be83f12da40e364c675cdd1b7da.jpg","class_id":"58","house_area":"50","house_name":"沃尔玛附近长住短住得可，拎包入住","house_price":"600","house_tag":"","province_id":"48",
         * "city_id":"659","house_decorate":"24","house_face":"31","house_language":"16","apartment":"一室0厅","province":"棉兰老穆斯林自治区","city":"谢里夫阿瓜克","house_face_name":"南北通透",
         * "house_language_names":["中文"],"house_decorate_name":"中等装修","area":"棉兰老穆斯林自治区谢里夫阿瓜克"}]
         * msgStatus : 0
         * electricity_bill : http://feidu.baonongkang.cn/index.php?s=/wap/articlecenter/articleContent/article_id/23
         */

        private ArticlesBean articles;
        private String msgStatus;
        private String electricity_bill;
        private List<AdvsBean> advs;
        private List<HuoBean> huo;
        private List<GoodsBean> goods;
        private List<HouseBean> house;

        public ArticlesBean getArticles() {
            return articles;
        }

        public void setArticles(ArticlesBean articles) {
            this.articles = articles;
        }

        public String getMsgStatus() {
            return msgStatus;
        }

        public void setMsgStatus(String msgStatus) {
            this.msgStatus = msgStatus;
        }

        public String getElectricity_bill() {
            return electricity_bill;
        }

        public void setElectricity_bill(String electricity_bill) {
            this.electricity_bill = electricity_bill;
        }

        public List<AdvsBean> getAdvs() {
            return advs;
        }

        public void setAdvs(List<AdvsBean> advs) {
            this.advs = advs;
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

        public static class ArticlesBean {
            private List<NewsBean> news;

            public List<NewsBean> getNews() {
                return news;
            }

            public void setNews(List<NewsBean> news) {
                this.news = news;
            }

            public static class NewsBean {
                /**
                 * article_id : 22
                 * title : 中国-东盟国际汽车拉力赛首次抵达菲律宾
                 * content : http://feidu.baonongkang.cn/index.php?s=/wap/articlecenter/articleContent/article_id/22
                 * status : 0
                 */

                private String article_id;
                private String title;
                private String content;
                private String status;

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

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }
            }
        }

        public static class AdvsBean {
            /**
             * id : 74
             * adv_image : http://feidu.baonongkang.cn/upload/image_collection/1515759661.jpg
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

        public static class HuoBean {
            /**
             * id : 29
             * adv_image : http://feidu.baonongkang.cn/upload/image_collection/1515760464.jpg
             * class_id : 3
             * content :
             */

            private String id;
            private String adv_image;
            private String class_id;
            private String content;

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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }
        }

        public static class GoodsBean {
            /**
             * goods_id : 27
             * goods_name : 【官方旗舰店】paparecipe 春雨蜂蜜面膜正品 春雨补水面膜旗舰店
             * description : 正品保障100%海外原装正品：所有商品均属海外生产或销售；因此，所售商品一律为100%海外原装正品。&nbsp;了解详情&gt;&gt;
             * pic_cover_small : http://feidu.baonongkang.cn/upload/goods/20180109/85ba209f0430a5d2f4cceba9318a43fc3.png
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
             * house_id : 89
             * house_title : 合租·襄阳两室两厅
             * house_pic : http://feidu.baonongkang.cn/upload/house/5a5eb1f625f38.png
             * class_id : 56
             * house_area : 888
             * house_name : 襄阳
             * house_price : 633
             * house_tag :
             * province_id : 43
             * city_id : 629
             * house_decorate : 24
             * house_face : 32
             * house_language : 14,15
             * apartment : 两室两厅
             * province : 西米沙鄢大区
             * city : 埃斯卡兰特市
             * house_face_name : 正南正北
             * house_language_names : ["菲律宾语","英语"]
             * house_decorate_name : 中等装修
             * area : 西米沙鄢大区埃斯卡兰特市
             */

            private String house_id;
            private String house_title;
            private String house_pic;
            private String class_id;
            private String house_area;
            private String house_name;
            private String house_price;
            private String house_tag;
            private String province_id;
            private String city_id;
            private String house_decorate;
            private String house_face;
            private String house_language;
            private String apartment;
            private String province;
            private String city;
            private String house_face_name;
            private String house_decorate_name;
            private String area;
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

            public String getHouse_decorate() {
                return house_decorate;
            }

            public void setHouse_decorate(String house_decorate) {
                this.house_decorate = house_decorate;
            }

            public String getHouse_face() {
                return house_face;
            }

            public void setHouse_face(String house_face) {
                this.house_face = house_face;
            }

            public String getHouse_language() {
                return house_language;
            }

            public void setHouse_language(String house_language) {
                this.house_language = house_language;
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

            public String getHouse_face_name() {
                return house_face_name;
            }

            public void setHouse_face_name(String house_face_name) {
                this.house_face_name = house_face_name;
            }

            public String getHouse_decorate_name() {
                return house_decorate_name;
            }

            public void setHouse_decorate_name(String house_decorate_name) {
                this.house_decorate_name = house_decorate_name;
            }

            public String getArea() {
                return area;
            }

            public void setArea(String area) {
                this.area = area;
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
