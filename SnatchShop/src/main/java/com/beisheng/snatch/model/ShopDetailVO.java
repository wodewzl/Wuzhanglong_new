package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/3.
 */

public class ShopDetailVO extends BaseVO{

    /**
     * data : {"id":"2","img_list":["http://qmfq.baonongkang.cn/upload/goods/1181499342151.jpg","http://qmfq.baonongkang.cn/upload/goods/1171499342147.jpg"],"prise_status":"3","status_text":"已揭晓",
     * "goods_id":"57","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","issue_no":"2014980203","total_count":"5600","buy_count":"5600","remain_count":"0","percent":"100","publish_time":"2018-03-20
     * 10:24:01","prise_code":"1003872","code_end":"1005600","category_id":"3","create_time":"1520851518","user_data":{"buy_count":"0","buy_codes":[]},"is_favor":"0",
     * "chart_data":[{"pf_no":"2014980203","buy_period":"4","is_fq":"1"}],"dfw_data":{"uid":"9","nickname":"疯抢用户10005","total_buy":"5590","avatar":"http://qmfq.baonongkang
     * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},"edj_data":{"uid":"9","nickname":"疯抢用户10005","total_buy":"10","avatar":"http://qmfq.baonongkang
     * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},"xdz_data":{"uid":"9","nickname":"疯抢用户10005","total_buy":"5570","avatar":"http://qmfq.baonongkang
     * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},"seconds_remain":"0","lucky_user":{"uid":"9","user_no":"10005","nickname":"疯抢用户10005","avatar":"http://qmfq.baonongkang
     * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","buy_count":"5590","publish_time":"2018-03-20 10:24:01","prise_code":"1003872"},"goods_detail_url":"http://qmfq.baonongkang
     * .cn/index.php?s=/Api/Dbindex/goods_detail&id=57","is_hb":"0","join_first_page":{"list":[{"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北",
     * "payment_time":"2018-03-19 18:10:08","buy_count":"5570","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},{"uid":"6","nickname":"lhb",
     * "user_no":"10002","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 17:55:01","buy_count":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/1520324232.jpg"},
     * {"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 17:54:03","buy_count":"10","avatar":"http://qmfq.baonongkang
     * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},{"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19
     * 17:50:35","buy_count":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"}],"page":"1","count":"1","start_time":"2018-03-12 18:45:18"}}
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
         * id : 2
         * img_list : ["http://qmfq.baonongkang.cn/upload/goods/1181499342151.jpg","http://qmfq.baonongkang.cn/upload/goods/1171499342147.jpg"]
         * prise_status : 3
         * status_text : 已揭晓
         * goods_id : 57
         * goods_name : 14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1
         * issue_no : 2014980203
         * total_count : 5600
         * buy_count : 5600
         * remain_count : 0
         * percent : 100
         * publish_time : 2018-03-20 10:24:01
         * prise_code : 1003872
         * code_end : 1005600
         * category_id : 3
         * create_time : 1520851518
         * user_data : {"buy_count":"0","buy_codes":[]}
         * is_favor : 0
         * chart_data : [{"pf_no":"2014980203","buy_period":"4","is_fq":"1"}]
         * dfw_data : {"uid":"9","nickname":"疯抢用户10005","total_buy":"5590","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"}
         * edj_data : {"uid":"9","nickname":"疯抢用户10005","total_buy":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"}
         * xdz_data : {"uid":"9","nickname":"疯抢用户10005","total_buy":"5570","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"}
         * seconds_remain : 0
         * lucky_user : {"uid":"9","user_no":"10005","nickname":"疯抢用户10005","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","buy_count":"5590",
         * "publish_time":"2018-03-20 10:24:01","prise_code":"1003872"}
         * goods_detail_url : http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/goods_detail&id=57
         * is_hb : 0
         * join_first_page : {"list":[{"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 18:10:08","buy_count":"5570",
         * "avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},{"uid":"6","nickname":"lhb","user_no":"10002","user_ip":"27.27.16.38","user_city":"湖北",
         * "payment_time":"2018-03-19 17:55:01","buy_count":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/1520324232.jpg"},{"uid":"9","nickname":"疯抢用户10005","user_no":"10005",
         * "user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 17:54:03","buy_count":"10","avatar":"http://qmfq.baonongkang
         * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},{"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19
         * 17:50:35","buy_count":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"}],"page":"1","count":"1","start_time":"2018-03-12 18:45:18"}
         */

        private String id;
        private String prise_status;
        private String status_text;
        private String goods_id;
        private String goods_name;
        private String issue_no;
        private String total_count;
        private String buy_count;
        private String remain_count;
        private String percent;
        private String publish_time;
        private String prise_code;
        private String code_end;
        private String category_id;
        private String create_time;
        private UserDataBean user_data;
        private String is_favor;
        private DfwDataBean dfw_data;
        private EdjDataBean edj_data;
        private XdzDataBean xdz_data;
        private String seconds_remain;
        private LuckyUserBean lucky_user;
        private String goods_detail_url;
        private String calc_detail_url;
        private String is_hb;
        private JoinFirstPageBean join_first_page;
        private List<String> img_list;
        private List<ChartDataBean> chart_data;
        private String honor_rule;

        public String getHonor_rule() {
            return honor_rule;
        }

        public void setHonor_rule(String honor_rule) {
            this.honor_rule = honor_rule;
        }

        public String getCalc_detail_url() {
            return calc_detail_url;
        }

        public void setCalc_detail_url(String calc_detail_url) {
            this.calc_detail_url = calc_detail_url;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPrise_status() {
            return prise_status;
        }

        public void setPrise_status(String prise_status) {
            this.prise_status = prise_status;
        }

        public String getStatus_text() {
            return status_text;
        }

        public void setStatus_text(String status_text) {
            this.status_text = status_text;
        }

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getIssue_no() {
            return issue_no;
        }

        public void setIssue_no(String issue_no) {
            this.issue_no = issue_no;
        }

        public String getTotal_count() {
            return total_count;
        }

        public void setTotal_count(String total_count) {
            this.total_count = total_count;
        }

        public String getBuy_count() {
            return buy_count;
        }

        public void setBuy_count(String buy_count) {
            this.buy_count = buy_count;
        }

        public String getRemain_count() {
            return remain_count;
        }

        public void setRemain_count(String remain_count) {
            this.remain_count = remain_count;
        }

        public String getPercent() {
            return percent;
        }

        public void setPercent(String percent) {
            this.percent = percent;
        }

        public String getPublish_time() {
            return publish_time;
        }

        public void setPublish_time(String publish_time) {
            this.publish_time = publish_time;
        }

        public String getPrise_code() {
            return prise_code;
        }

        public void setPrise_code(String prise_code) {
            this.prise_code = prise_code;
        }

        public String getCode_end() {
            return code_end;
        }

        public void setCode_end(String code_end) {
            this.code_end = code_end;
        }

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public UserDataBean getUser_data() {
            return user_data;
        }

        public void setUser_data(UserDataBean user_data) {
            this.user_data = user_data;
        }

        public String getIs_favor() {
            return is_favor;
        }

        public void setIs_favor(String is_favor) {
            this.is_favor = is_favor;
        }

        public DfwDataBean getDfw_data() {
            return dfw_data;
        }

        public void setDfw_data(DfwDataBean dfw_data) {
            this.dfw_data = dfw_data;
        }

        public EdjDataBean getEdj_data() {
            return edj_data;
        }

        public void setEdj_data(EdjDataBean edj_data) {
            this.edj_data = edj_data;
        }

        public XdzDataBean getXdz_data() {
            return xdz_data;
        }

        public void setXdz_data(XdzDataBean xdz_data) {
            this.xdz_data = xdz_data;
        }

        public String getSeconds_remain() {
            return seconds_remain;
        }

        public void setSeconds_remain(String seconds_remain) {
            this.seconds_remain = seconds_remain;
        }

        public LuckyUserBean getLucky_user() {
            return lucky_user;
        }

        public void setLucky_user(LuckyUserBean lucky_user) {
            this.lucky_user = lucky_user;
        }

        public String getGoods_detail_url() {
            return goods_detail_url;
        }

        public void setGoods_detail_url(String goods_detail_url) {
            this.goods_detail_url = goods_detail_url;
        }

        public String getIs_hb() {
            return is_hb;
        }

        public void setIs_hb(String is_hb) {
            this.is_hb = is_hb;
        }

        public JoinFirstPageBean getJoin_first_page() {
            return join_first_page;
        }

        public void setJoin_first_page(JoinFirstPageBean join_first_page) {
            this.join_first_page = join_first_page;
        }

        public List<String> getImg_list() {
            return img_list;
        }

        public void setImg_list(List<String> img_list) {
            this.img_list = img_list;
        }

        public List<ChartDataBean> getChart_data() {
            return chart_data;
        }

        public void setChart_data(List<ChartDataBean> chart_data) {
            this.chart_data = chart_data;
        }

        public static class UserDataBean {
            /**
             * buy_count : 0
             * buy_codes : []
             */

            private String buy_count;
            private List<?> buy_codes;

            public String getBuy_count() {
                return buy_count;
            }

            public void setBuy_count(String buy_count) {
                this.buy_count = buy_count;
            }

            public List<?> getBuy_codes() {
                return buy_codes;
            }

            public void setBuy_codes(List<?> buy_codes) {
                this.buy_codes = buy_codes;
            }
        }

        public static class DfwDataBean {
            /**
             * uid : 9
             * nickname : 疯抢用户10005
             * total_buy : 5590
             * avatar : http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg
             */

            private String uid;
            private String nickname;
            private String total_buy;
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

            public String getTotal_buy() {
                return total_buy;
            }

            public void setTotal_buy(String total_buy) {
                this.total_buy = total_buy;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }

        public static class EdjDataBean {
            /**
             * uid : 9
             * nickname : 疯抢用户10005
             * total_buy : 10
             * avatar : http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg
             */

            private String uid;
            private String nickname;
            private String total_buy;
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

            public String getTotal_buy() {
                return total_buy;
            }

            public void setTotal_buy(String total_buy) {
                this.total_buy = total_buy;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }

        public static class XdzDataBean {
            /**
             * uid : 9
             * nickname : 疯抢用户10005
             * total_buy : 5570
             * avatar : http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg
             */

            private String uid;
            private String nickname;
            private String total_buy;
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

            public String getTotal_buy() {
                return total_buy;
            }

            public void setTotal_buy(String total_buy) {
                this.total_buy = total_buy;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }
        }

        public static class LuckyUserBean {
            /**
             * uid : 9
             * user_no : 10005
             * nickname : 疯抢用户10005
             * avatar : http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg
             * buy_count : 5590
             * publish_time : 2018-03-20 10:24:01
             * prise_code : 1003872
             */

            private String uid;
            private String user_no;
            private String nickname;
            private String avatar;
            private String buy_count;
            private String publish_time;
            private String prise_code;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getUser_no() {
                return user_no;
            }

            public void setUser_no(String user_no) {
                this.user_no = user_no;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getBuy_count() {
                return buy_count;
            }

            public void setBuy_count(String buy_count) {
                this.buy_count = buy_count;
            }

            public String getPublish_time() {
                return publish_time;
            }

            public void setPublish_time(String publish_time) {
                this.publish_time = publish_time;
            }

            public String getPrise_code() {
                return prise_code;
            }

            public void setPrise_code(String prise_code) {
                this.prise_code = prise_code;
            }
        }

        public static class JoinFirstPageBean {
            /**
             * list : [{"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 18:10:08","buy_count":"5570","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},{"uid":"6","nickname":"lhb","user_no":"10002","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 17:55:01","buy_count":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/1520324232.jpg"},{"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 17:54:03","buy_count":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"},{"uid":"9","nickname":"疯抢用户10005","user_no":"10005","user_ip":"27.27.16.38","user_city":"湖北","payment_time":"2018-03-19 17:50:35","buy_count":"10","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"}]
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

        public static class ChartDataBean {
            /**
             * pf_no : 2014980203
             * buy_period : 4
             * is_fq : 1
             */

            private String pf_no;
            private String buy_period;
            private String is_fq;

            public String getPf_no() {
                return pf_no;
            }

            public void setPf_no(String pf_no) {
                this.pf_no = pf_no;
            }

            public String getBuy_period() {
                return buy_period;
            }

            public void setBuy_period(String buy_period) {
                this.buy_period = buy_period;
            }

            public String getIs_fq() {
                return is_fq;
            }

            public void setIs_fq(String is_fq) {
                this.is_fq = is_fq;
            }
        }
    }
}
