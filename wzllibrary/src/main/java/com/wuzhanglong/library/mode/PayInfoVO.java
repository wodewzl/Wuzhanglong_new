package com.wuzhanglong.library.mode;

/**
 * Created by ${Wuzhanglong} on 2018/4/14.
 */

public class PayInfoVO extends BaseVO {

    /**
     * data : {"wxpay_params":{"appid":"wxafa13c7f68391fd5","noncestr":"sm499bqi2g47ujq9kkxpraqptdnnru9n","partnerid":"1502007901","prepayid":"wx141714493305609745678aeb1968593175",
     * "timestamp":"1523697272","sign":"C44578D23B17ADA7D08098BCCF02E324","pkg":"Sign=WXPay"}}
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
         * wxpay_params : {"appid":"wxafa13c7f68391fd5","noncestr":"sm499bqi2g47ujq9kkxpraqptdnnru9n","partnerid":"1502007901","prepayid":"wx141714493305609745678aeb1968593175",
         * "timestamp":"1523697272","sign":"C44578D23B17ADA7D08098BCCF02E324","pkg":"Sign=WXPay"}
         */
        private String alipay_string;
        private String alipay_wap_html;
        private WxpayParamsBean wxpay_params;
        private String wx_native_qrcode;
        private String payment_status_api;
        private String pay_status;

        public String getPay_status() {
            return pay_status;
        }

        public void setPay_status(String pay_status) {
            this.pay_status = pay_status;
        }

        public String getWx_native_qrcode() {
            return wx_native_qrcode;
        }

        public void setWx_native_qrcode(String wx_native_qrcode) {
            this.wx_native_qrcode = wx_native_qrcode;
        }

        public String getPayment_status_api() {
            return payment_status_api;
        }

        public void setPayment_status_api(String payment_status_api) {
            this.payment_status_api = payment_status_api;
        }

        public String getAlipay_wap_html() {
            return alipay_wap_html;
        }

        public void setAlipay_wap_html(String alipay_wap_html) {
            this.alipay_wap_html = alipay_wap_html;
        }

        public WxpayParamsBean getWxpay_params() {
            return wxpay_params;
        }

        public void setWxpay_params(WxpayParamsBean wxpay_params) {
            this.wxpay_params = wxpay_params;
        }

        public String getAlipay_string() {
            return alipay_string;
        }

        public void setAlipay_string(String alipay_string) {
            this.alipay_string = alipay_string;
        }

        public static class WxpayParamsBean {
            /**
             * appid : wxafa13c7f68391fd5
             * noncestr : sm499bqi2g47ujq9kkxpraqptdnnru9n
             * partnerid : 1502007901
             * prepayid : wx141714493305609745678aeb1968593175
             * timestamp : 1523697272
             * sign : C44578D23B17ADA7D08098BCCF02E324
             * pkg : Sign=WXPay
             */

            private String appid;
            private String noncestr;
            private String partnerid;
            private String prepayid;
            private String timestamp;
            private String sign;
            private String pkg;

            public String getAppid() {
                return appid;
            }

            public void setAppid(String appid) {
                this.appid = appid;
            }

            public String getNoncestr() {
                return noncestr;
            }

            public void setNoncestr(String noncestr) {
                this.noncestr = noncestr;
            }

            public String getPartnerid() {
                return partnerid;
            }

            public void setPartnerid(String partnerid) {
                this.partnerid = partnerid;
            }

            public String getPrepayid() {
                return prepayid;
            }

            public void setPrepayid(String prepayid) {
                this.prepayid = prepayid;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getPkg() {
                return pkg;
            }

            public void setPkg(String pkg) {
                this.pkg = pkg;
            }
        }
    }
}
