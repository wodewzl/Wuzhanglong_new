package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class ShopVO extends BaseVO{

    /**
     * data : {"goods":[{"goods_id":"3","goods_name":"iphoneX","price":"8200.00","category_id":"3","pic_cover_small":"http://183.95.85.31:8001/upload/goods/20171226/2ed7db33f7e55e19f8f3378d8f62848d3.jpg"}],"total_count":"1","page_count":"1"}
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
         * goods : [{"goods_id":"3","goods_name":"iphoneX","price":"8200.00","category_id":"3","pic_cover_small":"http://183.95.85.31:8001/upload/goods/20171226/2ed7db33f7e55e19f8f3378d8f62848d3.jpg"}]
         * total_count : 1
         * page_count : 1
         */

        private String total_count;
        private String page_count;
        private List<GoodsBean> goods;

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

        public List<GoodsBean> getGoods() {
            return goods;
        }

        public void setGoods(List<GoodsBean> goods) {
            this.goods = goods;
        }

        public static class GoodsBean {
            /**
             * goods_id : 3
             * goods_name : iphoneX
             * price : 8200.00
             * category_id : 3
             * pic_cover_small : http://183.95.85.31:8001/upload/goods/20171226/2ed7db33f7e55e19f8f3378d8f62848d3.jpg
             */

            private String goods_id;
            private String goods_name;
            private String price;
            private String category_id;
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

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getPic_cover_small() {
                return pic_cover_small;
            }

            public void setPic_cover_small(String pic_cover_small) {
                this.pic_cover_small = pic_cover_small;
            }
        }
    }
}
