package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class PastBuyVO extends BaseVO{

    /**
     * data : {"list":[{"id":"15","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","front_issue_no":"5312396306","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg","nickname":"lhb","buy_total":"5439","buy_time":"2018-03-29 17:59:54"},{"id":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","front_issue_no":"2014980203","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg","nickname":"疯抢用户10005","buy_total":"5590","buy_time":"2018-03-19 18:10:08"}],"page":"1","count":"1"}
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
         * list : [{"id":"15","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","front_issue_no":"5312396306","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg","nickname":"lhb","buy_total":"5439","buy_time":"2018-03-29 17:59:54"},{"id":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","front_issue_no":"2014980203","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg","nickname":"疯抢用户10005","buy_total":"5590","buy_time":"2018-03-19 18:10:08"}]
         * page : 1
         * count : 1
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
             * id : 15
             * goods_name : 14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1
             * front_issue_no : 5312396306
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg
             * nickname : lhb
             * buy_total : 5439
             * buy_time : 2018-03-29 17:59:54
             */

            private String id;
            private String goods_name;
            private String front_issue_no;
            private String goods_image;
            private String nickname;
            private String buy_total;
            private String buy_time;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getFront_issue_no() {
                return front_issue_no;
            }

            public void setFront_issue_no(String front_issue_no) {
                this.front_issue_no = front_issue_no;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getBuy_total() {
                return buy_total;
            }

            public void setBuy_total(String buy_total) {
                this.buy_total = buy_total;
            }

            public String getBuy_time() {
                return buy_time;
            }

            public void setBuy_time(String buy_time) {
                this.buy_time = buy_time;
            }
        }
    }
}
