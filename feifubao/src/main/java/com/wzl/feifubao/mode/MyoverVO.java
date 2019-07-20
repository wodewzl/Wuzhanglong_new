package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/6.
 */

public class MyoverVO extends BaseVO{

    /**
     * data : {"total_count":"3","page_count":"1","sum":"14,095.00","data":[{"id":"10","uid":"39","shop_id":"0","account_type":"2","sign":"1","number":"3996.00","from_type":"2","data_id":"12","text":"订单退款","create_time":"2017-12-30 14:42:07","nick_name":"n180102112896","user_name":"n180102112896","user_tel":"13720343150","user_email":"514674526@qq.com","user_headimg":"","type_name":"订单退还"},{"id":"9","uid":"39","shop_id":"0","account_type":"2","sign":"1","number":"999.00","from_type":"2","data_id":"7","text":"订单退款","create_time":"2017-12-30 14:20:05","nick_name":"n180102112896","user_name":"n180102112896","user_tel":"13720343150","user_email":"514674526@qq.com","user_headimg":"","type_name":"订单退还"},{"id":"8","uid":"39","shop_id":"0","account_type":"2","sign":"1","number":"9100.00","from_type":"2","data_id":"2","text":"订单退款","create_time":"2017-12-30 11:40:30","nick_name":"n180102112896","user_name":"n180102112896","user_tel":"13720343150","user_email":"514674526@qq.com","user_headimg":"","type_name":"订单退还"}]}
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
         * total_count : 3
         * page_count : 1
         * sum : 14,095.00
         * data : [{"id":"10","uid":"39","shop_id":"0","account_type":"2","sign":"1","number":"3996.00","from_type":"2","data_id":"12","text":"订单退款","create_time":"2017-12-30 14:42:07","nick_name":"n180102112896","user_name":"n180102112896","user_tel":"13720343150","user_email":"514674526@qq.com","user_headimg":"","type_name":"订单退还"},{"id":"9","uid":"39","shop_id":"0","account_type":"2","sign":"1","number":"999.00","from_type":"2","data_id":"7","text":"订单退款","create_time":"2017-12-30 14:20:05","nick_name":"n180102112896","user_name":"n180102112896","user_tel":"13720343150","user_email":"514674526@qq.com","user_headimg":"","type_name":"订单退还"},{"id":"8","uid":"39","shop_id":"0","account_type":"2","sign":"1","number":"9100.00","from_type":"2","data_id":"2","text":"订单退款","create_time":"2017-12-30 11:40:30","nick_name":"n180102112896","user_name":"n180102112896","user_tel":"13720343150","user_email":"514674526@qq.com","user_headimg":"","type_name":"订单退还"}]
         */

        private String total_count;
        private String page_count;
        private String sum;
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

        public String getSum() {
            return sum;
        }

        public void setSum(String sum) {
            this.sum = sum;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * id : 10
             * uid : 39
             * shop_id : 0
             * account_type : 2
             * sign : 1
             * number : 3996.00
             * from_type : 2
             * data_id : 12
             * text : 订单退款
             * create_time : 2017-12-30 14:42:07
             * nick_name : n180102112896
             * user_name : n180102112896
             * user_tel : 13720343150
             * user_email : 514674526@qq.com
             * user_headimg :
             * type_name : 订单退还
             */

            private String id;
            private String uid;
            private String shop_id;
            private String account_type;
            private String sign;
            private String number;
            private String from_type;
            private String data_id;
            private String text;
            private String create_time;
            private String nick_name;
            private String user_name;
            private String user_tel;
            private String user_email;
            private String user_headimg;
            private String type_name;
            private String current_balance;

            public String getCurrent_balance() {
                return current_balance;
            }

            public void setCurrent_balance(String current_balance) {
                this.current_balance = current_balance;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getShop_id() {
                return shop_id;
            }

            public void setShop_id(String shop_id) {
                this.shop_id = shop_id;
            }

            public String getAccount_type() {
                return account_type;
            }

            public void setAccount_type(String account_type) {
                this.account_type = account_type;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getFrom_type() {
                return from_type;
            }

            public void setFrom_type(String from_type) {
                this.from_type = from_type;
            }

            public String getData_id() {
                return data_id;
            }

            public void setData_id(String data_id) {
                this.data_id = data_id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getNick_name() {
                return nick_name;
            }

            public void setNick_name(String nick_name) {
                this.nick_name = nick_name;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getUser_tel() {
                return user_tel;
            }

            public void setUser_tel(String user_tel) {
                this.user_tel = user_tel;
            }

            public String getUser_email() {
                return user_email;
            }

            public void setUser_email(String user_email) {
                this.user_email = user_email;
            }

            public String getUser_headimg() {
                return user_headimg;
            }

            public void setUser_headimg(String user_headimg) {
                this.user_headimg = user_headimg;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }
        }
    }
}
