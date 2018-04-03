package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/3.
 */

public class ShopDetailListVO extends BaseVO{

    /**
     * data : {"list":[{"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 18:10:08","buy_count":"5570","avatar":"http://qmfq
     * .baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},{"uid":"6","nickname":"lhb","user_no":"10002","user_ip":"27.27.16.38","user_city":"湖北",
     * "payment_time":"2018-03-19 17:55:01","buy_count":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/1520324232.jpg"},{"uid":"9","nickname":"疯抢用户10005","user_no":"10005",
     * "user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 17:54:03","buy_count":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b
     * .jpg"},{"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 17:50:35","buy_count":"10","avatar":"http://qmfq.baonongkang
     * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"}],"page":"1","count":"1","start_time":"2018-03-12 18:45:18"}
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
         * list : [{"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 18:10:08","buy_count":"5570","avatar":"http://qmfq
         * .baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},{"uid":"6","nickname":"lhb","user_no":"10002","user_ip":"27.27.16.38","user_city":"湖北",
         * "payment_time":"2018-03-19 17:55:01","buy_count":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/1520324232.jpg"},{"uid":"9","nickname":"疯抢用户10005","user_no":"10005",
         * "user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 17:54:03","buy_count":"10","avatar":"http://qmfq.baonongkang
         * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},{"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19
         * 17:50:35","buy_count":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"}]
         * page : 1
         * count : 1
         * start_time : 2018-03-12 18:45:18
         */

        private String page;
        private String count;
        private String start_time;
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

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * uid : 9
             * nickname : 疯抢用户10005
             * user_no : 10005
             * user_ip : 27.27.16.38
             * user_city : 湖北
             * payment_time : 2018-03-19 18:10:08
             * buy_count : 5570
             * avatar : http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg
             */

            private String uid;
            private String nickname;
            private String user_no;
            private String user_ip;
            private String user_city;
            private String payment_time;
            private String buy_count;
            private String avatar;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getUser_no() {
                return user_no;
            }

            public void setUser_no(String user_no) {
                this.user_no = user_no;
            }

            public String getUser_ip() {
                return user_ip;
            }

            public void setUser_ip(String user_ip) {
                this.user_ip = user_ip;
            }

            public String getUser_city() {
                return user_city;
            }

            public void setUser_city(String user_city) {
                this.user_city = user_city;
            }

            public String getPayment_time() {
                return payment_time;
            }

            public void setPayment_time(String payment_time) {
                this.payment_time = payment_time;
            }

            public String getBuy_count() {
                return buy_count;
            }

            public void setBuy_count(String buy_count) {
                this.buy_count = buy_count;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }
    }
}
