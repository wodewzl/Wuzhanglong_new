package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/2.
 */

public class SignVO extends BaseVO {

    /**
     * data : {"point":"10","continuous_days":"0","is_notify":"0","is_signin":"0","exchange_list":[{"goods_id":"69","goods_name":"100元三网通用话费充值卡","goods_detail_url":"http://qmfq.baonongkang.cn/index
     * .php?s=/Wap/Goods/pointGoodsDetail&id=69","picture":"http://qmfq.baonongkang.cn/upload/goods/20180326/30d38241704baba65e7f593d9972fbf92.jpg","price":"120.00","score":"1000",
     * "is_material":"0"},{"goods_id":"68","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g","goods_detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Wap/Goods/pointGoodsDetail&id=68",
     * "picture":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg","price":"4000.00","score":"5000","is_material":"1"}],"sevenday_points_array":["1","1","1",
     * "2","2","3","5"]}
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
         * point : 10
         * continuous_days : 0
         * is_notify : 0
         * is_signin : 0
         * exchange_list : [{"goods_id":"69","goods_name":"100元三网通用话费充值卡","goods_detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Wap/Goods/pointGoodsDetail&id=69","picture":"http://qmfq
         * .baonongkang.cn/upload/goods/20180326/30d38241704baba65e7f593d9972fbf92.jpg","price":"120.00","score":"1000","is_material":"0"},{"goods_id":"68","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条
         * 10g","goods_detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Wap/Goods/pointGoodsDetail&id=68","picture":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg","price":"4000.00","score":"5000","is_material":"1"}]
         * sevenday_points_array : ["1","1","1","2","2","3","5"]
         */

        private String point;
        private String continuous_days;
        private String is_notify;
        private String is_signin;
        private List<ExchangeListBean> exchange_list;
        private List<String> sevenday_points_array;

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }

        public String getContinuous_days() {
            return continuous_days;
        }

        public void setContinuous_days(String continuous_days) {
            this.continuous_days = continuous_days;
        }

        public String getIs_notify() {
            return is_notify;
        }

        public void setIs_notify(String is_notify) {
            this.is_notify = is_notify;
        }

        public String getIs_signin() {
            return is_signin;
        }

        public void setIs_signin(String is_signin) {
            this.is_signin = is_signin;
        }

        public List<ExchangeListBean> getExchange_list() {
            return exchange_list;
        }

        public void setExchange_list(List<ExchangeListBean> exchange_list) {
            this.exchange_list = exchange_list;
        }

        public List<String> getSevenday_points_array() {
            return sevenday_points_array;
        }

        public void setSevenday_points_array(List<String> sevenday_points_array) {
            this.sevenday_points_array = sevenday_points_array;
        }

        public static class ExchangeListBean {
            /**
             * goods_id : 69
             * goods_name : 100元三网通用话费充值卡
             * goods_detail_url : http://qmfq.baonongkang.cn/index.php?s=/Wap/Goods/pointGoodsDetail&id=69
             * picture : http://qmfq.baonongkang.cn/upload/goods/20180326/30d38241704baba65e7f593d9972fbf92.jpg
             * price : 120.00
             * score : 1000
             * is_material : 0
             */

            private String goods_id;
            private String goods_name;
            private String goods_detail_url;
            private String picture;
            private String price;
            private String score;
            private String is_material;

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

            public String getGoods_detail_url() {
                return goods_detail_url;
            }

            public void setGoods_detail_url(String goods_detail_url) {
                this.goods_detail_url = goods_detail_url;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getScore() {
                return score;
            }

            public void setScore(String score) {
                this.score = score;
            }

            public String getIs_material() {
                return is_material;
            }

            public void setIs_material(String is_material) {
                this.is_material = is_material;
            }
        }
    }
}
