package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/6.
 */

public class PaymentRecordsVO extends BaseVO{

    /**
     * data : {"data":[{"order_id":"40","order_no":"2018011011490001","out_trade_no":"151555546974091000","sku_name":"电费","price":"150.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"4861546515615","type":"1"},{"order_id":"39","order_no":"2018011011460001","out_trade_no":"151555546555751000","sku_name":"电费","price":"50.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"4861546515615","type":"1"},{"order_id":"38","order_no":"2018011011420001","out_trade_no":"151555546241491000","sku_name":"电费","price":"300.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"4861546515615","type":"1"},{"order_id":"37","order_no":"2018011011400001","out_trade_no":"151555545920801000","sku_name":"电费","price":"200.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"4861546515615","type":"1"},{"order_id":"32","order_no":"2018011011550001","out_trade_no":"151555535481371000","sku_name":"电费","price":"200.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672354354","return_img":"","bill_num":"486154632461531231","type":"1"},{"order_id":"31","order_no":"2018011011450001","out_trade_no":"151555534594121000","sku_name":"电费","price":"100.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"486154651561531231","type":"1"},{"order_id":"30","order_no":"2018011011430001","out_trade_no":"151555534351971000","sku_name":"电费","price":"100.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"486154651561531231","type":"1"}],"total_count":"7","page_count":"1"}
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
         * data : [{"order_id":"40","order_no":"2018011011490001","out_trade_no":"151555546974091000","sku_name":"电费","price":"150.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"4861546515615","type":"1"},{"order_id":"39","order_no":"2018011011460001","out_trade_no":"151555546555751000","sku_name":"电费","price":"50.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"4861546515615","type":"1"},{"order_id":"38","order_no":"2018011011420001","out_trade_no":"151555546241491000","sku_name":"电费","price":"300.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"4861546515615","type":"1"},{"order_id":"37","order_no":"2018011011400001","out_trade_no":"151555545920801000","sku_name":"电费","price":"200.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"4861546515615","type":"1"},{"order_id":"32","order_no":"2018011011550001","out_trade_no":"151555535481371000","sku_name":"电费","price":"200.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672354354","return_img":"","bill_num":"486154632461531231","type":"1"},{"order_id":"31","order_no":"2018011011450001","out_trade_no":"151555534594121000","sku_name":"电费","price":"100.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"486154651561531231","type":"1"},{"order_id":"30","order_no":"2018011011430001","out_trade_no":"151555534351971000","sku_name":"电费","price":"100.00","create_time":"2018-01-10","buyer_id":"39","user_name":"鸭梨山大","receiver_mobile":"18672133699","return_img":"","bill_num":"486154651561531231","type":"1"}]
         * total_count : 7
         * page_count : 1
         */

        private String total_count;
        private String page_count;
        private List<DataBean> data;

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

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * order_id : 40
             * order_no : 2018011011490001
             * out_trade_no : 151555546974091000
             * sku_name : 电费
             * price : 150.00
             * create_time : 2018-01-10
             * buyer_id : 39
             * user_name : 鸭梨山大
             * receiver_mobile : 18672133699
             * return_img :
             * bill_num : 4861546515615
             * type : 1
             */

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
            private String typeView;

            public String getTypeView() {
                return typeView;
            }

            public void setTypeView(String typeView) {
                this.typeView = typeView;
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
        }
    }
}
