package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class MyScortRecordVO extends BaseVO{


    /**
     * data : {"list":[{"id":"39","exchange_type":"2","exchange_name":"腾讯视频VIP会员12个月一年卡","consume_points":"20000","exchange_time":"2018-04-26 19:18:44","delivery_status":"1",
     * "goods_picture":"http://qmfq.baonongkang.cn/upload/goods/20180424/2e3f91e11b9f97da68dddf7d63fd6c5b2.png"},{"id":"38","exchange_type":"3","exchange_name":"无门槛红包","consume_points":"10",
     * "exchange_time":"2018-04-25 15:32:19","delivery_status":"0","goods_picture":""},{"id":"37","exchange_type":"3","exchange_name":"积分兑换1元红包","consume_points":"10","exchange_time":"2018-04-25
     * 15:32:15","delivery_status":"0","goods_picture":""},{"id":"36","exchange_type":"3","exchange_name":"满50减2元红包","consume_points":"100","exchange_time":"2018-04-25 15:31:06",
     * "delivery_status":"0","goods_picture":""},{"id":"35","exchange_type":"3","exchange_name":"无门槛红包","consume_points":"10","exchange_time":"2018-04-25 15:30:53","delivery_status":"0",
     * "goods_picture":""},{"id":"34","exchange_type":"3","exchange_name":"积分兑换1元红包","consume_points":"10","exchange_time":"2018-04-25 15:30:42","delivery_status":"0","goods_picture":""},
     * {"id":"33","exchange_type":"3","exchange_name":"积分兑换1元红包","consume_points":"10","exchange_time":"2018-04-25 15:30:33","delivery_status":"0","goods_picture":""},{"id":"32",
     * "exchange_type":"3","exchange_name":"积分兑换1元红包","consume_points":"10","exchange_time":"2018-04-25 15:29:49","delivery_status":"0","goods_picture":""},{"id":"29","exchange_type":"3",
     * "exchange_name":"积分兑换1元红包","consume_points":"10","exchange_time":"2018-04-24 09:10:49","delivery_status":"0","goods_picture":""},{"id":"28","exchange_type":"2",
     * "exchange_name":"100元三网通用话费充值卡","consume_points":"1000","exchange_time":"2018-04-20 14:50:01","delivery_status":"1","goods_picture":"http://qmfq.baonongkang
     * .cn/upload/goods/20180326/30d38241704baba65e7f593d9972fbf92.jpg"}],"page":"1","count":"4"}
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
         * list : [{"id":"39","exchange_type":"2","exchange_name":"腾讯视频VIP会员12个月一年卡","consume_points":"20000","exchange_time":"2018-04-26 19:18:44","delivery_status":"1",
         * "goods_picture":"http://qmfq.baonongkang.cn/upload/goods/20180424/2e3f91e11b9f97da68dddf7d63fd6c5b2.png"},{"id":"38","exchange_type":"3","exchange_name":"无门槛红包","consume_points":"10",
         * "exchange_time":"2018-04-25 15:32:19","delivery_status":"0","goods_picture":""},{"id":"37","exchange_type":"3","exchange_name":"积分兑换1元红包","consume_points":"10",
         * "exchange_time":"2018-04-25 15:32:15","delivery_status":"0","goods_picture":""},{"id":"36","exchange_type":"3","exchange_name":"满50减2元红包","consume_points":"100",
         * "exchange_time":"2018-04-25 15:31:06","delivery_status":"0","goods_picture":""},{"id":"35","exchange_type":"3","exchange_name":"无门槛红包","consume_points":"10","exchange_time":"2018-04-25
         * 15:30:53","delivery_status":"0","goods_picture":""},{"id":"34","exchange_type":"3","exchange_name":"积分兑换1元红包","consume_points":"10","exchange_time":"2018-04-25 15:30:42",
         * "delivery_status":"0","goods_picture":""},{"id":"33","exchange_type":"3","exchange_name":"积分兑换1元红包","consume_points":"10","exchange_time":"2018-04-25 15:30:33","delivery_status":"0",
         * "goods_picture":""},{"id":"32","exchange_type":"3","exchange_name":"积分兑换1元红包","consume_points":"10","exchange_time":"2018-04-25 15:29:49","delivery_status":"0","goods_picture":""},
         * {"id":"29","exchange_type":"3","exchange_name":"积分兑换1元红包","consume_points":"10","exchange_time":"2018-04-24 09:10:49","delivery_status":"0","goods_picture":""},{"id":"28",
         * "exchange_type":"2","exchange_name":"100元三网通用话费充值卡","consume_points":"1000","exchange_time":"2018-04-20 14:50:01","delivery_status":"1","goods_picture":"http://qmfq.baonongkang
         * .cn/upload/goods/20180326/30d38241704baba65e7f593d9972fbf92.jpg"}]
         * page : 1
         * count : 4
         */

        private String page;
        private String count;
        private List<ListBean> list;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 39
             * exchange_type : 2
             * exchange_name : 腾讯视频VIP会员12个月一年卡
             * consume_points : 20000
             * exchange_time : 2018-04-26 19:18:44
             * delivery_status : 1
             * goods_picture : http://qmfq.baonongkang.cn/upload/goods/20180424/2e3f91e11b9f97da68dddf7d63fd6c5b2.png
             */

            private String id;
            private String exchange_type;
            private String exchange_name;
            private String consume_points;
            private String exchange_time;
            private String delivery_status;
            private String goods_picture;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getExchange_type() {
                return exchange_type;
            }

            public void setExchange_type(String exchange_type) {
                this.exchange_type = exchange_type;
            }

            public String getExchange_name() {
                return exchange_name;
            }

            public void setExchange_name(String exchange_name) {
                this.exchange_name = exchange_name;
            }

            public String getConsume_points() {
                return consume_points;
            }

            public void setConsume_points(String consume_points) {
                this.consume_points = consume_points;
            }

            public String getExchange_time() {
                return exchange_time;
            }

            public void setExchange_time(String exchange_time) {
                this.exchange_time = exchange_time;
            }

            public String getDelivery_status() {
                return delivery_status;
            }

            public void setDelivery_status(String delivery_status) {
                this.delivery_status = delivery_status;
            }

            public String getGoods_picture() {
                return goods_picture;
            }

            public void setGoods_picture(String goods_picture) {
                this.goods_picture = goods_picture;
            }
        }
    }
}
