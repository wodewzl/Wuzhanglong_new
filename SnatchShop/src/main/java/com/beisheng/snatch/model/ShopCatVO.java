package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2017/5/10.
 */

public class ShopCatVO extends BaseVO {

    private ShopCatVO data;
    private List<ShopCatVO> cart;
    private List<ShopCatVO> tuijian;

    private String cart_id;
    private String goods_id;
    private String goods_name;
    private String sku_id;
    private String sku_name;
    private String num;
    private String stock;
    private String picture;
    private String price;
    private String promotion_price;
    private String description;
    private String pic_cover_small;
    private String type;
    private boolean isCheck = false;

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }

    public ShopCatVO getData() {
        return data;
    }

    public void setData(ShopCatVO data) {
        this.data = data;
    }

    public List<ShopCatVO> getCart() {
        return cart;
    }

    public void setCart(List<ShopCatVO> cart) {
        this.cart = cart;
    }

    public List<ShopCatVO> getTuijian() {
        return tuijian;
    }

    public void setTuijian(List<ShopCatVO> tuijian) {
        this.tuijian = tuijian;
    }

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPromotion_price() {
        return promotion_price;
    }

    public void setPromotion_price(String promotion_price) {
        this.promotion_price = promotion_price;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
