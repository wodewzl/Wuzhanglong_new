package com.wzl.feifubao.constant;

import java.lang.reflect.Member;

public class Constant {

    public static final String FIRSTID = "firstid";
    public static final String LASTID = "lastid";

    public static final String SDCARD_CACHE = "com.xiaojing/files/"; // 文件sdk缓存
    //get 最后加 &

    public static final String HOME_URL = "api/home";//首页
    public static final String HOUSE_LIST_URL = "api/house/lists";//房源列表
    public static final String HOUSE_LIST_OPTION_URL = "api/house/getClassList";//房源列表条件
    public static final String HOUSE_DETAIL_URL = "api/house/detail";//房详情
    public static final String REGIST_URL = "api/Member/register";//注册
    public static final String LOGIN_URL = "api/Member/login";//登陆
    public static final String ADDRESS_LIST_URL = "api/Member/getMemberExpressAddress";//收货地址列表
    public static final String ADDRESS_ADD_URL = "api/Member/setDefaultExpressAddress";//添加收货地址列表
    public static final String CITY_URL = "api/member/getArea";//添加收货地址列表

}
