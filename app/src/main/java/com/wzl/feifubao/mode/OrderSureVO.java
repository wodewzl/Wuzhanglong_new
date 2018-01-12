package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/11.
 */

public class OrderSureVO extends BaseVO {

    /**
     * data : {"goods_sku_list":"15:5","addresslist":[{"id":"3","uid":"39","consigner":"庄猛","mobile":"13720343150","phone":"","province":"17","city":"173","district":"1565","address":"东津世纪城",
     * "zip_code":"","alias":"","is_default":"1","address_info":"湖北省&nbsp;襄樊市&nbsp;襄阳区"},{"id":"4","uid":"39","consigner":"毕进","mobile":"15927310680","phone":"","province":"23","city":"251",
     * "district":"2167","address":"啊啊啊呃呃","zip_code":"","alias":"","is_default":"0","address_info":"四川省&nbsp;巴中市&nbsp;南江县"}],"address_is_have":"1","expressCompanyCount":"2","yunfei":"30.00",
     * "express_company_list":[{"co_id":"1","company_name":"顺丰","is_default":"1","express_fee":"30"}],"discount_money":"0.00","count_money":"41500.00","rate":"0.13100000","total_price":"41530",
     * "total_price_rmb":"5440.43","pick_up_money":"0","list":[{"sku_id":"15","goods_id":"3","num":"5","sku_name":"黑色 64G 4.8 ","price":"8300.00","pic_cover_micro":"http://feidu.baonongkang
     * .cn/upload/goods/20171226/2ed7db33f7e55e19f8f3378d8f62848d4.jpg","subtotal":"41500.00","picture_info":""}],"count_point_exchange":"0","member_account":{"point":"0","balance":"5000.00",
     * "coin":"0"},"coupon_list":[],"promotion_full_mail":{"mail_id":"1","shop_id":"0","is_open":"0","full_mail_money":"0.00","create_time":"1513594939","modify_time":"0",
     * "no_mail_province_id_array":"","no_mail_city_id_array":""},"pickup_point_list":{"data":[],"total_count":"0","page_count":"1"}}
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
         * goods_sku_list : 15:5
         * addresslist : [{"id":"3","uid":"39","consigner":"庄猛","mobile":"13720343150","phone":"","province":"17","city":"173","district":"1565","address":"东津世纪城","zip_code":"","alias":"",
         * "is_default":"1","address_info":"湖北省&nbsp;襄樊市&nbsp;襄阳区"},{"id":"4","uid":"39","consigner":"毕进","mobile":"15927310680","phone":"","province":"23","city":"251","district":"2167",
         * "address":"啊啊啊呃呃","zip_code":"","alias":"","is_default":"0","address_info":"四川省&nbsp;巴中市&nbsp;南江县"}]
         * address_is_have : 1
         * expressCompanyCount : 2
         * yunfei : 30.00
         * express_company_list : [{"co_id":"1","company_name":"顺丰","is_default":"1","express_fee":"30"}]
         * discount_money : 0.00
         * count_money : 41500.00
         * rate : 0.13100000
         * total_price : 41530
         * total_price_rmb : 5440.43
         * pick_up_money : 0
         * list : [{"sku_id":"15","goods_id":"3","num":"5","sku_name":"黑色 64G 4.8 ","price":"8300.00","pic_cover_micro":"http://feidu.baonongkang
         * .cn/upload/goods/20171226/2ed7db33f7e55e19f8f3378d8f62848d4.jpg","subtotal":"41500.00","picture_info":""}]
         * count_point_exchange : 0
         * member_account : {"point":"0","balance":"5000.00","coin":"0"}
         * coupon_list : []
         * promotion_full_mail : {"mail_id":"1","shop_id":"0","is_open":"0","full_mail_money":"0.00","create_time":"1513594939","modify_time":"0","no_mail_province_id_array":"",
         * "no_mail_city_id_array":""}
         * pickup_point_list : {"data":[],"total_count":"0","page_count":"1"}
         */

        private String goods_sku_list;
        private String address_is_have;
        private String expressCompanyCount;
        private String yunfei;
        private String discount_money;
        private String count_money;
        private String rate;
        private String total_price;
        private String total_price_rmb;
        private String pick_up_money;
        private String count_point_exchange;
        private MemberAccountBean member_account;
        private PromotionFullMailBean promotion_full_mail;
        private PickupPointListBean pickup_point_list;
        private List<AddresslistBean> addresslist;
        private List<ExpressCompanyListBean> express_company_list;
        private List<ListBean> list;
        private List<?> coupon_list;

        public String getGoods_sku_list() {
            return goods_sku_list;
        }

        public void setGoods_sku_list(String goods_sku_list) {
            this.goods_sku_list = goods_sku_list;
        }

        public String getAddress_is_have() {
            return address_is_have;
        }

        public void setAddress_is_have(String address_is_have) {
            this.address_is_have = address_is_have;
        }

        public String getExpressCompanyCount() {
            return expressCompanyCount;
        }

        public void setExpressCompanyCount(String expressCompanyCount) {
            this.expressCompanyCount = expressCompanyCount;
        }

        public String getYunfei() {
            return yunfei;
        }

        public void setYunfei(String yunfei) {
            this.yunfei = yunfei;
        }

        public String getDiscount_money() {
            return discount_money;
        }

        public void setDiscount_money(String discount_money) {
            this.discount_money = discount_money;
        }

        public String getCount_money() {
            return count_money;
        }

        public void setCount_money(String count_money) {
            this.count_money = count_money;
        }

        public String getRate() {
            return rate;
        }

        public void setRate(String rate) {
            this.rate = rate;
        }

        public String getTotal_price() {
            return total_price;
        }

        public void setTotal_price(String total_price) {
            this.total_price = total_price;
        }

        public String getTotal_price_rmb() {
            return total_price_rmb;
        }

        public void setTotal_price_rmb(String total_price_rmb) {
            this.total_price_rmb = total_price_rmb;
        }

        public String getPick_up_money() {
            return pick_up_money;
        }

        public void setPick_up_money(String pick_up_money) {
            this.pick_up_money = pick_up_money;
        }

        public String getCount_point_exchange() {
            return count_point_exchange;
        }

        public void setCount_point_exchange(String count_point_exchange) {
            this.count_point_exchange = count_point_exchange;
        }

        public MemberAccountBean getMember_account() {
            return member_account;
        }

        public void setMember_account(MemberAccountBean member_account) {
            this.member_account = member_account;
        }

        public PromotionFullMailBean getPromotion_full_mail() {
            return promotion_full_mail;
        }

        public void setPromotion_full_mail(PromotionFullMailBean promotion_full_mail) {
            this.promotion_full_mail = promotion_full_mail;
        }

        public PickupPointListBean getPickup_point_list() {
            return pickup_point_list;
        }

        public void setPickup_point_list(PickupPointListBean pickup_point_list) {
            this.pickup_point_list = pickup_point_list;
        }

        public List<AddresslistBean> getAddresslist() {
            return addresslist;
        }

        public void setAddresslist(List<AddresslistBean> addresslist) {
            this.addresslist = addresslist;
        }

        public List<ExpressCompanyListBean> getExpress_company_list() {
            return express_company_list;
        }

        public void setExpress_company_list(List<ExpressCompanyListBean> express_company_list) {
            this.express_company_list = express_company_list;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<?> getCoupon_list() {
            return coupon_list;
        }

        public void setCoupon_list(List<?> coupon_list) {
            this.coupon_list = coupon_list;
        }

        public static class MemberAccountBean {
            /**
             * point : 0
             * balance : 5000.00
             * coin : 0
             */

            private String point;
            private String balance;
            private String coin;

            public String getPoint() {
                return point;
            }

            public void setPoint(String point) {
                this.point = point;
            }

            public String getBalance() {
                return balance;
            }

            public void setBalance(String balance) {
                this.balance = balance;
            }

            public String getCoin() {
                return coin;
            }

            public void setCoin(String coin) {
                this.coin = coin;
            }
        }

        public static class PromotionFullMailBean {
            /**
             * mail_id : 1
             * shop_id : 0
             * is_open : 0
             * full_mail_money : 0.00
             * create_time : 1513594939
             * modify_time : 0
             * no_mail_province_id_array :
             * no_mail_city_id_array :
             */

            private String mail_id;
            private String shop_id;
            private String is_open;
            private String full_mail_money;
            private String create_time;
            private String modify_time;
            private String no_mail_province_id_array;
            private String no_mail_city_id_array;

            public String getMail_id() {
                return mail_id;
            }

            public void setMail_id(String mail_id) {
                this.mail_id = mail_id;
            }

            public String getShop_id() {
                return shop_id;
            }

            public void setShop_id(String shop_id) {
                this.shop_id = shop_id;
            }

            public String getIs_open() {
                return is_open;
            }

            public void setIs_open(String is_open) {
                this.is_open = is_open;
            }

            public String getFull_mail_money() {
                return full_mail_money;
            }

            public void setFull_mail_money(String full_mail_money) {
                this.full_mail_money = full_mail_money;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getModify_time() {
                return modify_time;
            }

            public void setModify_time(String modify_time) {
                this.modify_time = modify_time;
            }

            public String getNo_mail_province_id_array() {
                return no_mail_province_id_array;
            }

            public void setNo_mail_province_id_array(String no_mail_province_id_array) {
                this.no_mail_province_id_array = no_mail_province_id_array;
            }

            public String getNo_mail_city_id_array() {
                return no_mail_city_id_array;
            }

            public void setNo_mail_city_id_array(String no_mail_city_id_array) {
                this.no_mail_city_id_array = no_mail_city_id_array;
            }
        }

        public static class PickupPointListBean {
            /**
             * data : []
             * total_count : 0
             * page_count : 1
             */

            private String total_count;
            private String page_count;
            private List<?> data;

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

            public List<?> getData() {
                return data;
            }

            public void setData(List<?> data) {
                this.data = data;
            }
        }


        public static class ExpressCompanyListBean {
            /**
             * co_id : 1
             * company_name : 顺丰
             * is_default : 1
             * express_fee : 30
             */

            private String co_id;
            private String company_name;
            private String is_default;
            private String express_fee;

            public String getCo_id() {
                return co_id;
            }

            public void setCo_id(String co_id) {
                this.co_id = co_id;
            }

            public String getCompany_name() {
                return company_name;
            }

            public void setCompany_name(String company_name) {
                this.company_name = company_name;
            }

            public String getIs_default() {
                return is_default;
            }

            public void setIs_default(String is_default) {
                this.is_default = is_default;
            }

            public String getExpress_fee() {
                return express_fee;
            }

            public void setExpress_fee(String express_fee) {
                this.express_fee = express_fee;
            }
        }

        public static class ListBean {
            /**
             * sku_id : 15
             * goods_id : 3
             * num : 5
             * sku_name : 黑色 64G 4.8
             * price : 8300.00
             * pic_cover_micro : http://feidu.baonongkang.cn/upload/goods/20171226/2ed7db33f7e55e19f8f3378d8f62848d4.jpg
             * subtotal : 41500.00
             * picture_info :
             */

            private String sku_id;
            private String goods_id;
            private String num;
            private String sku_name;
            private String price;
            private String pic_cover_micro;
            private String subtotal;
            private String picture_info;

            public String getSku_id() {
                return sku_id;
            }

            public void setSku_id(String sku_id) {
                this.sku_id = sku_id;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
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

            public String getPic_cover_micro() {
                return pic_cover_micro;
            }

            public void setPic_cover_micro(String pic_cover_micro) {
                this.pic_cover_micro = pic_cover_micro;
            }

            public String getSubtotal() {
                return subtotal;
            }

            public void setSubtotal(String subtotal) {
                this.subtotal = subtotal;
            }

            public String getPicture_info() {
                return picture_info;
            }

            public void setPicture_info(String picture_info) {
                this.picture_info = picture_info;
            }
        }
    }
}
