package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/7.
 */

public class ShopHomeVO extends BaseVO{
    private ShopHomeVO data;
    private List<ShopHomeVO> advs;
    private List<ShopHomeVO> articles;
    private List<ShopHomeVO> tehui;
    private List<ShopHomeVO> xianshi;
    private List<ShopHomeVO> tuijianadvs;
    private List<ShopHomeVO> tuijian;
    private String id;
    private String adv_image;
    private String class_id;
    private String article_id;
    private String title;
    private String goods_id;
    private String goods_name;
    private String price;
    private String promotion_price;
    private String discount_name;
    private String pic_cover_small;
    private String type;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<ShopHomeVO> getAdvs() {
        return advs;
    }

    public void setAdvs(List<ShopHomeVO> advs) {
        this.advs = advs;
    }

    public List<ShopHomeVO> getArticles() {
        return articles;
    }

    public void setArticles(List<ShopHomeVO> articles) {
        this.articles = articles;
    }

    public List<ShopHomeVO> getTehui() {
        return tehui;
    }

    public void setTehui(List<ShopHomeVO> tehui) {
        this.tehui = tehui;
    }

    public List<ShopHomeVO> getXianshi() {
        return xianshi;
    }

    public void setXianshi(List<ShopHomeVO> xianshi) {
        this.xianshi = xianshi;
    }

    public List<ShopHomeVO> getTuijianadvs() {
        return tuijianadvs;
    }

    public void setTuijianadvs(List<ShopHomeVO> tuijianadvs) {
        this.tuijianadvs = tuijianadvs;
    }

    public List<ShopHomeVO> getTuijian() {
        return tuijian;
    }

    public void setTuijian(List<ShopHomeVO> tuijian) {
        this.tuijian = tuijian;
    }

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

    public String getPromotion_price() {
        return promotion_price;
    }

    public void setPromotion_price(String promotion_price) {
        this.promotion_price = promotion_price;
    }

    public String getDiscount_name() {
        return discount_name;
    }

    public void setDiscount_name(String discount_name) {
        this.discount_name = discount_name;
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

    public ShopHomeVO getData() {
        return data;
    }

    public void setData(ShopHomeVO data) {
        this.data = data;
    }
}
