package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2017/5/10.
 */

public class ShopCatVO extends BaseVO {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * cart_id : 4
         * goods_id : 3
         * goods_name : iphoneX
         * sku_id : 16
         * sku_name : 黑色 128G 5.5
         * price : 11000
         * num : 17
         * stock : 54
         * picture :
         */

        private String cart_id;
        private String goods_id;
        private String goods_name;
        private String sku_id;
        private String sku_name;
        private String price;
        private String num;
        private String stock;
        private String picture;

        public String getCart_id() {
            return cart_id;
        }

        public void setCart_id(String cart_id) {
            this.cart_id = cart_id;
        }

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

        public String getSku_id() {
            return sku_id;
        }

        public void setSku_id(String sku_id) {
            this.sku_id = sku_id;
        }

        public String getSku_name() {
            return sku_name;
        }

        public void setSku_name(String sku_name) {
            this.sku_name = sku_name;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public String getStock() {
            return stock;
        }

        public void setStock(String stock) {
            this.stock = stock;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }
    }
}
