package com.beisheng.snatch.constant;

public class Constant {
    public static final String SDCARD_CACHE = "com.beisheng/snatch/files/"; // 文件sdk缓存
    //get 最后加 &
    public static final String HOME_TITLE_URL = "/index.php/Api/Dbindex/index";//首页
    public static final String HOME_LIST_URL = "/index.php/Api/Dbindex/get_more";//首页
    public static final String SHOP_CATEGORY_URL = "/index.php/Api/Dbindex/categorys";//商品分类
    public static final String KEYWORD_LIST_URL = "/index.php/Api/Dbindex/search_list";//搜索列表
    public static final String KEYWORD_URL = "/index.php/Api/Dbindex/hot_search";//搜索列表
    public static final String ADDRESS_LIST_URL = "/index.php/Api/Member/member_address";//收货地址列表
    public static final String ADDRESS_DELETE_URL = "/index.php/Api/Member/delete_member_address";//删除地址
    public static final String ADDRESS_SET_URL = "/index.php/Api/Member/update_address_default";//设置默认收货地址
    public static final String ADDRESS_ADD_URL = "/index.php/Api/Member/add_member_address";//添加收货地址
    public static final String GET_CITY_URL = "/index.php/Api/Dbindex/get_area_list";// 获取城市列表
    public static final String SHOP_CART_BUY_URL = "/index.php/Api/Member/buy_from_cart";
    public static final String SHOP_CART_URL = "/index.php/Api/Member/cart_list";//清单列表
    public static final String LOTTERYING_URL = "/index.php/Api/Dbindex/newest_list";//最新揭晓
    public static final String MY_MESSAGE_URL = "/index.php/Api/Member/messages";//我的消息
    public static final String DAILY_TASK_URL = "/index.php/Api/Task/index";//首页任务列表
    public static final String DAILY_TASK_DETAIL_URL = "/index.php/Api/Task/details";//任务详情
    public static final String SIGN_DATA_URL = "/index.php/Api/Account/signin_index";//获取签到数据
    public static final String SIGN_URL = "/index.php/Api/Account/make_signin";//签到
    public static final String SIGN_GIFT_URL = "/index.php/Api/Account/get_signin_package";//获取签到数据
    public static final String SIGN_NOTIFY_URL = "/index.php/Api/Account/set_signin_notify";//签到提醒
    public static final String SHOP_DETAIL_URL = "/index.php/Api/Dbindex/details";//商品详情
    public static final String SHOP_BUY_LIST_URL = "/index.php/Api/Dbindex/get_join_list";//商品详情谋其抢购列表
    public static final String OTHER_HEAD_URL = "/index.php/Api/User/user_info";//TA个人中心头部信息
    public static final String OTHER_TAB_ONE_URL = "/index.php/Api/User/buy_list";//TA个人中心购买记录
    public static final String OTHER_TAB_TWO_URL = "/index.php/Api/User/lucky_record";//TA个人中心购买记录
    public static final String OTHER_TAB_THREE_URL = "/index.php/Api/User/evaluate_list";//TA个人中心晒单
    public static final String PAST_BUY_URL = "/index.php/Api/Dbindex/history";//往期疯抢列表
    public static final String DISSCUSS_URL = "/index.php/Api/Dbindex/evaluate_list";//评论列表
    public static final String REGIST_URL = "/index.php/Api/Login/sms_register";//注册
    public static final String GET_MSG_CODE_URL = "/index.php/Api/Login/get_sms_code";//获取短信验证码
    public static final String LOGIN_PASSWORD_URL = "/index.php/Api/Login/index";//账号密码登陆
    public static final String LOGIN_MSG_URL = "/index.php/Api/Login/sms_login";//短信登陆
    public static final String FAVOR_ADD_URL = "/index.php/Api/Member/add_favor";//收藏
    public static final String FAVOR_CANCEL_URL = "/index.php/Api/Member/cancel_favor";//取消收藏
    public static final String FAVOR_MY_URL = "/index.php/Api/Member/my_favor";//我的收藏
    public static final String SHOPCART_DELETE_ONE_ULR = "/index.php/Api/Member/del_cart";//删除单个清单
    public static final String MY_LUCKY_RECORD_URL = "/index.php/Api/Member/lucky_record";//幸运记录
    public static final String MY_BUY_RECORD_URL = "/index.php/Api/Member/buy_list";//购买记录
    public static final String NAME_CONFIRM_INFO_URL = "/index.php/Api/Account/getSmrzInfo";//获取实名认证
    public static final String NAME_CONFIRM_URL = "/index.php/Api/Account/smrz";//实名认证
    public static final String MY_ORDER_SHOW = "/index.php/Api/Member/my_evaluate";//我的晒单
    public static final String SCORT_DETAIL_URL = "/index.php/Api/Account/score_log";//积分明细
    public static final String MY_SCORT_URL = "/index.php/Api/Account/score_index";//我的积分
    public static final String MY_RED_MONEY_URL = "/index.php/Api/Account/coupon_list";//我的积分
    public static final String FLOW_EXCHANGE_URL = "/index.php/Api/Account/exchange_flow";//兑换流浪
    public static final String MY_CENTER_URL = "/index.php/Api/Account/index";//我的首页数据
    public static final String SHOW_DETAIL_URL = "/index.php/Api/Dbindex/evaluate_detail";//晒单详情
    public static final String DISCUSS_LIST_URL = "/index.php/Api/Dbindex/evaluate_comments_list";//评论列表
    public static final String PAY_TYPE_LIST_URL = "/index.php/Api/Member/get_payment_list";//支付列表
    public static final String PAY_RED_LIST_URL = "/index.php/Api/Member/get_member_coupons";//支付时可用红包
    public static final String SHOPCAT_UPDATE_URL = "/index.php/Api/Member/update_cart";//更新购物车
    public static final String SHOPCAT_BUY_URL = "/index.php/Api/Member/buy_from_cart";//购物车立即购买
    public static final String SHOPCAT_JOIN_URL = "/index.php/Api/Member/add_cart";//加入购物车
    public static final String GET_SHOP_URL = "/index.php/Api/Member/get_prise";//领取幸运宝贝
    public static final String SHOW_URL = "/index.php/Api/Member/evaluate";//晒单
    public static final String RECHARGE_RECORD_URL = "/index.php/Api/Account/recharge_log";//充值记录
    public static final String LOGIN_OTHER_URL = "/index.php/Api/Login/oauth_login";//第三方登录
    public static final String WU_LIU_URL = "/index.php/Api/Member/get_express_info";//物流
    public static final String NUMBER_TREND_URL = "/index.php/Api/Dbindex/charts_detail";//更多走势图
    public static final String DISSCUSS_COMMIT_URL = "/index.php/Api/Member/like_evaluate";//评论

}

