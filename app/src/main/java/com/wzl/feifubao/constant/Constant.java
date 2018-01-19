package com.wzl.feifubao.constant;

import java.lang.reflect.Member;

public class Constant {

    public static final String FIRSTID = "firstid";
    public static final String LASTID = "lastid";

    public static final String SDCARD_CACHE = "com.feifubao/files/"; // 文件sdk缓存
    //get 最后加 &

    public static final String HOME_URL = "api/home";//首页
    public static final String HOUSE_LIST_URL = "api/house/lists";//房源列表
    public static final String HOUSE_LIST_OPTION_URL = "api/house/getClassList";//房源列表条件
    public static final String HOUSE_DETAIL_URL = "api/house/detail";//房详情
    public static final String REGIST_URL = "api/Member/register";//注册
    public static final String REGIST_CODE_URL = "api/Member/sendEmail";//获取验证码
    public static final String LOGIN_URL = "api/Member/login";//登陆
    public static final String ADDRESS_LIST_URL = "api/Member/getMemberExpressAddress";//收货地址列表
    public static final String ADDRESS_ADD_URL = "api/Member/addMemberExpressAddress";//添加收货地址
    public static final String ADDRESS_SET_URL = "api/Member/setDefaultExpressAddress";//设置默认收货地址
    public static final String ADDRESS_DELETE_URL = "api/Member/memberAddressDelete";//删除地址
    public static final String CITY_URL = "api/member/getArea";//城市
    public static final String RATE_URL = "api/Rate";//汇率列表
    public static final String RATE_EXCHANGE_URL = "api/Rate/changeMoney";//汇率换算
    public static final String SHOP_LIST_ULR = "api/Good/getGoodsList";//商城除首页其他的界面界面接口
    public static final String SHOP_HOME_ULR = "api/Mall/index";//商城除首页其他的界面界面接口
    public static final String SHOP_DETAIL_ULR = "api/Good/getGoodsDetail";//商品详情
    public static final String JOBOFFER_URL = "api/Recruit/getRecruitLists";//招聘列表
    public static final String JOBOFFER_DETAIL_URL = "api/Recruit/getRecruitDetail";//招聘详情
    public static final String LIFE_LIST_URL = "api/news/lists";//生活列表
    public static final String YELLOW_PAGE_LIST_URL = "api/Recruit/getYellowPages";//企业黄页
    public static final String MY_HOUSE_LIST_URL = "api/House/myHouse";//我的房源列表接口
    public static final String MY_OVER_LIST_URL = "api/Member/balanceList";//我的房源列表接口
    public static final String DELETE_HOUSE_URL = "api/House/deleteHouse";//我的房源列表接口
    public static final String SHOP_ADD_CART_URL = "api/Order/addCart";//添加到购物车
    public static final String SHOP_CART_LIST_URL = "api/Order/getCart";//获取购物车列表
    public static final String PAYMENT_RECORDS_URL = "api/Order/virtualOrderList";//缴费记录
    public static final String MESSAGE_LIST_URL = "api/Member/jpushLists";//极光推送
    public static final String COMMIT_ORDER_URL = "api/Order/orderInfo";//提交订单
    public static final String ADD_SHOP_COUNT = "api/Order/changeCartNum";//购物车添加
    public static final String DELETE_SHOP_COUNT = "api/Order/cartDelete";//购物车删除
    public static final String  SURE_ORDER1_URL= "api/Order/orderCreate";//确认订单1
    public static final String  SURE_ORDER2_URL= "api/Pay/pay_order";//确认订单2
    public static final String  MY_ORDER_URL= "api/Order/myOrderList";//个人中心我的订单
    public static final String  ORDER_DELETE_URL= "api/Order/deleteOrder";//删除订单
    public static final String  ORDER_CANCEL_URL= "api/Order/orderClose";//取消订单订单
    public static final String  SHOP_RECIVER_URL= "api/Order/deleteOrde";//收货
    public static final String  MY_MESSAGE_URL= "api/Order/orderState";//个人中心消息
    public static final String  UPDATE_USERINFO_URL= "api/Member/updateMember";//修改头像，昵称

    public static final String  SHOP_EVALUATION_URL= "api/Order/deleteOrder";//商品评价
    public static final String  HOUSE_ADD_URL= "api/house/addHouse";//发布房源
    public static final String  CHAGE_URL= "Api/Order/virtualOrderCreate";//发布房源
    public static final String  WITHDRAW_URL= "api/Member/addMemberBalanceWithdraw";//提现
    public static final String  PASSWORD_BACK_URL= "api/Member/resetUserPassword";//提现
}
