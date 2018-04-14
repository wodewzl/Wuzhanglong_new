package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/14.
 */

public class PayTypeVO extends BaseVO{

    /**
     * data : {"list":[{"payment_code":"ALIPAY","payment_name":"支付宝APP支付","payment_icon":"http://qmfq.baonongkang.cn/public/admin/images/pay.png"},{"payment_code":"WPAY","payment_name":"微信APP支付",
     * "payment_icon":"http://qmfq.baonongkang.cn/public/admin/images/wchat.png"},{"payment_code":"WSCAN","payment_name":"微信扫码支付","payment_icon":"http://qmfq.baonongkang
     * .cn/public/admin/images/wchat_scan.png"},{"payment_code":"ALIWAP","payment_name":"支付宝网页支付","payment_icon":"http://qmfq.baonongkang.cn/public/admin/images/ali_wap.png"},
     * {"payment_code":"BALANCE","payment_name":"剩余次数支付","payment_icon":"http://qmfq.baonongkang.cn/public/admin/images/balance.png"}],"wx_appid":"wxafa13c7f68391fd5"}
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
         * list : [{"payment_code":"ALIPAY","payment_name":"支付宝APP支付","payment_icon":"http://qmfq.baonongkang.cn/public/admin/images/pay.png"},{"payment_code":"WPAY","payment_name":"微信APP支付",
         * "payment_icon":"http://qmfq.baonongkang.cn/public/admin/images/wchat.png"},{"payment_code":"WSCAN","payment_name":"微信扫码支付","payment_icon":"http://qmfq.baonongkang
         * .cn/public/admin/images/wchat_scan.png"},{"payment_code":"ALIWAP","payment_name":"支付宝网页支付","payment_icon":"http://qmfq.baonongkang.cn/public/admin/images/ali_wap.png"},
         * {"payment_code":"BALANCE","payment_name":"剩余次数支付","payment_icon":"http://qmfq.baonongkang.cn/public/admin/images/balance.png"}]
         * wx_appid : wxafa13c7f68391fd5
         */

        private String wx_appid;
        private List<ListBean> list;

        public String getWx_appid() {
            return wx_appid;
        }

        public void setWx_appid(String wx_appid) {
            this.wx_appid = wx_appid;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * payment_code : ALIPAY
             * payment_name : 支付宝APP支付
             * payment_icon : http://qmfq.baonongkang.cn/public/admin/images/pay.png
             */

            private String payment_code;
            private String payment_name;
            private String payment_icon;
            private boolean check=false;

            public boolean isCheck() {
                return check;
            }

            public void setCheck(boolean check) {
                this.check = check;
            }

            public String getPayment_code() {
                return payment_code;
            }

            public void setPayment_code(String payment_code) {
                this.payment_code = payment_code;
            }

            public String getPayment_name() {
                return payment_name;
            }

            public void setPayment_name(String payment_name) {
                this.payment_name = payment_name;
            }

            public String getPayment_icon() {
                return payment_icon;
            }

            public void setPayment_icon(String payment_icon) {
                this.payment_icon = payment_icon;
            }
        }
    }
}
