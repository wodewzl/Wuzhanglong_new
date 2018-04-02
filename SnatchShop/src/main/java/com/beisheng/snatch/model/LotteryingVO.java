package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/3/29.
 */

public class LotteryingVO extends BaseVO{

    /**
     * data : {"list":[{"id":"15","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","category_id":"3","front_issue_no":"5312396306","seconds_remain":"7091","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg"}],"page":"1","count":"1"}
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
         * list : [{"id":"15","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","category_id":"3","front_issue_no":"5312396306","seconds_remain":"7091","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg"}]
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
             * category_id : 3
             * front_issue_no : 5312396306
             * seconds_remain : 7091
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg
             */

            private String id;
            private String goods_name;
            private String category_id;
            private String front_issue_no;
            private String seconds_remain;
            private String goods_image;

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

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getFront_issue_no() {
                return front_issue_no;
            }

            public void setFront_issue_no(String front_issue_no) {
                this.front_issue_no = front_issue_no;
            }

            public String getSeconds_remain() {
                return seconds_remain;
            }

            public void setSeconds_remain(String seconds_remain) {
                this.seconds_remain = seconds_remain;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }
        }
    }
}
