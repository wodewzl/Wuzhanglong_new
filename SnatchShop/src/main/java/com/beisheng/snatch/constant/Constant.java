package com.beisheng.snatch.constant;

import android.accounts.Account;

import java.lang.reflect.Member;
import java.net.URL;

public class Constant {
    public static final String SDCARD_CACHE = "com.beisheng/snatch/files/"; // 文件sdk缓存
    //get 最后加 &
    public static final String HOME_TITLE_URL = "/index.php/Api/Dbindex/index";//首页
    public static final String HOME_LIST_URL = "/index.php/Api/Dbindex/get_more";//首页
    public static final String SHOP_CATEGORY_URL = "/index.php/Api/Dbindex/categorys";//商品分类
    public static final String KEYWORD_LIST_URL = "/index.php/Api/Dbindex/search_list";//搜索列表
    public static final String KEYWORD_URL = "/index.php/Api/Dbindex/hot_search";//搜索列表
    public static final String ADDRESS_LIST_URL="/index.php/Api/Member/member_address";//收货地址列表
    public static final String ADDRESS_DELETE_URL="/index.php/Api/Member/delete_member_address";//删除地址
    public static final String ADDRESS_SET_URL="/index.php/Api/Member/update_address_default";//设置默认收货地址
    public static final String SHOP_CART_BUY_URL="/index.php/Api/Member/buy_from_cart";
    public static final String SHOP_CART_URL="/index.php/Api/Member/cart_list";//清单列表
    public static final String LOTTERYING_URL="index.php/Api/Dbindex/newest_list";//最新揭晓
}

