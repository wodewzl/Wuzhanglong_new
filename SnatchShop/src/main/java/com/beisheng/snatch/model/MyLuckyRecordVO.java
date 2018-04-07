package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class MyLuckyRecordVO extends BaseVO {

    /**
     * data : {"list":[{"id":"1","pid":"2","issue_no":"2014980203","goods_id":"57","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","goods_picture":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg","buy_total":"5590","delivery_status":"1","is_evaluate":"0","is_virtual":"0","delivery_status_text":"正在派件"}],"page":"1","count":"1"}
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
         * list : [{"id":"1","pid":"2","issue_no":"2014980203","goods_id":"57","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","goods_picture":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg","buy_total":"5590","delivery_status":"1","is_evaluate":"0","is_virtual":"0","delivery_status_text":"正在派件"}]
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
             * id : 1
             * pid : 2
             * issue_no : 2014980203
             * goods_id : 57
             * goods_name : 14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1
             * goods_picture : http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg
             * buy_total : 5590
             * delivery_status : 1
             * is_evaluate : 0
             * is_virtual : 0
             * delivery_status_text : 正在派件
             */

            private String id;
            private String pid;
            private String issue_no;
            private String goods_id;
            private String goods_name;
            private String goods_picture;
            private String buy_total;
            private String delivery_status;
            private String is_evaluate;
            private String is_virtual;
            private String delivery_status_text;
            private boolean check = false;

            public boolean isCheck() {
                return check;
            }

            public void setCheck(boolean check) {
                this.check = check;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getIssue_no() {
                return issue_no;
            }

            public void setIssue_no(String issue_no) {
                this.issue_no = issue_no;
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

            public String getGoods_picture() {
                return goods_picture;
            }

            public void setGoods_picture(String goods_picture) {
                this.goods_picture = goods_picture;
            }

            public String getBuy_total() {
                return buy_total;
            }

            public void setBuy_total(String buy_total) {
                this.buy_total = buy_total;
            }

            public String getDelivery_status() {
                return delivery_status;
            }

            public void setDelivery_status(String delivery_status) {
                this.delivery_status = delivery_status;
            }

            public String getIs_evaluate() {
                return is_evaluate;
            }

            public void setIs_evaluate(String is_evaluate) {
                this.is_evaluate = is_evaluate;
            }

            public String getIs_virtual() {
                return is_virtual;
            }

            public void setIs_virtual(String is_virtual) {
                this.is_virtual = is_virtual;
            }

            public String getDelivery_status_text() {
                return delivery_status_text;
            }

            public void setDelivery_status_text(String delivery_status_text) {
                this.delivery_status_text = delivery_status_text;
            }
        }
    }
}
