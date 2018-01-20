package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/6.
 */

public class PaymentRecordsVO extends BaseVO{


    /**
     * data : {"total_count":"1","page_count":"1","data":[{"datetime":"2018-01","lists":[{"order_id":"223","order_no":"2018011420080001","out_trade_no":"151593318850071000","sku_name":"电费",
     * "price":"12869","create_time":"2018-01-14 20:33","buyer_id":"40","user_name":"ccc","receiver_mobile":"","return_img":"","bill_num":"123456","type":"1","pay_status":"2","pay_rmb":"1672.97",
     * "stoptime":""},{"order_id":"222","order_no":"2018011420120001","out_trade_no":"151593307281171000","sku_name":"电费","price":"35","create_time":"2018-01-14 20:31","buyer_id":"40",
     * "user_name":"ccc","receiver_mobile":"","return_img":"","bill_num":"123456789","type":"1","pay_status":"0","pay_rmb":"4.55","stoptime":""},{"order_id":"221","order_no":"2018011420000001",
     * "out_trade_no":"151593306086721000","sku_name":"电费","price":"35","create_time":"2018-01-14 20:31","buyer_id":"40","user_name":"ccc","receiver_mobile":"","return_img":"",
     * "bill_num":"123456789","type":"1","pay_status":"0","pay_rmb":"4.55","stoptime":""}]}]}
     */

    private DataBeanX data;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * total_count : 1
         * page_count : 1
         * data : [{"datetime":"2018-01","lists":[{"order_id":"223","order_no":"2018011420080001","out_trade_no":"151593318850071000","sku_name":"电费","price":"12869","create_time":"2018-01-14
         * 20:33","buyer_id":"40","user_name":"ccc","receiver_mobile":"","return_img":"","bill_num":"123456","type":"1","pay_status":"2","pay_rmb":"1672.97","stoptime":""},{"order_id":"222",
         * "order_no":"2018011420120001","out_trade_no":"151593307281171000","sku_name":"电费","price":"35","create_time":"2018-01-14 20:31","buyer_id":"40","user_name":"ccc","receiver_mobile":"",
         * "return_img":"","bill_num":"123456789","type":"1","pay_status":"0","pay_rmb":"4.55","stoptime":""},{"order_id":"221","order_no":"2018011420000001","out_trade_no":"151593306086721000",
         * "sku_name":"电费","price":"35","create_time":"2018-01-14 20:31","buyer_id":"40","user_name":"ccc","receiver_mobile":"","return_img":"","bill_num":"123456789","type":"1","pay_status":"0",
         * "pay_rmb":"4.55","stoptime":""}]}]
         */

        private String total_count;
        private String page_count;
        private List<DataBeanX> data;
        private List<DataBeanX> lists;
        private String datetime;
        private String order_id;
        private String order_no;
        private String out_trade_no;
        private String sku_name;
        private String price;
        private String create_time;
        private String buyer_id;
        private String user_name;
        private String receiver_mobile;
        private String return_img;
        private String bill_num;
        private String type;
        private String pay_status;
        private String pay_rmb;
        private String stoptime;



        public List<DataBeanX> getData() {
            return data;
        }

        public void setData(List<DataBeanX> data) {
            this.data = data;
        }

        public List<DataBeanX> getLists() {
            return lists;
        }

        public void setLists(List<DataBeanX> lists) {
            this.lists = lists;
        }

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getOrder_no() {
            return order_no;
        }

        public void setOrder_no(String order_no) {
            this.order_no = order_no;
        }

        public String getOut_trade_no() {
            return out_trade_no;
        }

        public void setOut_trade_no(String out_trade_no) {
            this.out_trade_no = out_trade_no;
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

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getBuyer_id() {
            return buyer_id;
        }

        public void setBuyer_id(String buyer_id) {
            this.buyer_id = buyer_id;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public String getReceiver_mobile() {
            return receiver_mobile;
        }

        public void setReceiver_mobile(String receiver_mobile) {
            this.receiver_mobile = receiver_mobile;
        }

        public String getReturn_img() {
            return return_img;
        }

        public void setReturn_img(String return_img) {
            this.return_img = return_img;
        }

        public String getBill_num() {
            return bill_num;
        }

        public void setBill_num(String bill_num) {
            this.bill_num = bill_num;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }

        public String getPay_rmb() {
            return pay_rmb;
        }

        public void setPay_rmb(String pay_rmb) {
            this.pay_rmb = pay_rmb;
        }

        public String getStoptime() {
            return stoptime;
        }

        public void setStoptime(String stoptime) {
            this.stoptime = stoptime;
        }

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


        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }
    }
}
