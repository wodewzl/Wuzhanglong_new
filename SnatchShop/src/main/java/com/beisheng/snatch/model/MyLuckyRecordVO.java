package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class MyLuckyRecordVO extends BaseVO {


    /**
     * data : {"list":[{"id":"33","pid":"29","issue_no":"5199536046","goods_id":"67","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","goods_picture":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg","buy_total":"1000","delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},
     * {"id":"28","pid":"22","issue_no":"1850003821","goods_id":"65","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","goods_picture":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg","buy_total":"3000","delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},
     * {"id":"25","pid":"22","issue_no":"1850003821","goods_id":"65","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","goods_picture":"http://qmfq.baonongkang
     * .cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg","buy_total":"3000","delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},
     * {"id":"24","pid":"20","issue_no":"1381882978","goods_id":"71","goods_name":"高档茶壶","goods_picture":"http://qmfq.baonongkang.cn/upload/goods/1499337509542.jpg","buy_total":"200",
     * "delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},{"id":"23","pid":"19","issue_no":"4896855698","goods_id":"67","goods_name":"中国黄金
     * 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","goods_picture":"http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg","buy_total":"1000","delivery_status":"0",
     * "is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},{"id":"22","pid":"28","issue_no":"1304916358","goods_id":"67","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状
     * 约1.62g","goods_picture":"http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg","buy_total":"1000","delivery_status":"0","is_evaluate":"0","is_virtual":"0",
     * "overtime":"1","delivery_status_text":"待发货"},{"id":"21","pid":"22","issue_no":"1850003821","goods_id":"65","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","goods_picture":"http://qmfq
     * .baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg","buy_total":"3000","delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1",
     * "delivery_status_text":"待发货"},{"id":"20","pid":"20","issue_no":"1381882978","goods_id":"71","goods_name":"高档茶壶","goods_picture":"http://qmfq.baonongkang.cn/upload/goods/1499337509542.jpg",
     * "buy_total":"200","delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},{"id":"19","pid":"19","issue_no":"4896855698","goods_id":"67",
     * "goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","goods_picture":"http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg","buy_total":"1000",
     * "delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},{"id":"18","pid":"16","issue_no":"8031888093","goods_id":"58","goods_name":"夏普电视机",
     * "goods_picture":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg","buy_total":"7987","delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1",
     * "delivery_status_text":"待发货"}],"page":"1","count":"2"}
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
         * list : [{"id":"33","pid":"29","issue_no":"5199536046","goods_id":"67","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","goods_picture":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg","buy_total":"1000","delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},
         * {"id":"28","pid":"22","issue_no":"1850003821","goods_id":"65","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","goods_picture":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg","buy_total":"3000","delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},
         * {"id":"25","pid":"22","issue_no":"1850003821","goods_id":"65","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","goods_picture":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg","buy_total":"3000","delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},
         * {"id":"24","pid":"20","issue_no":"1381882978","goods_id":"71","goods_name":"高档茶壶","goods_picture":"http://qmfq.baonongkang.cn/upload/goods/1499337509542.jpg","buy_total":"200",
         * "delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},{"id":"23","pid":"19","issue_no":"4896855698","goods_id":"67","goods_name":"中国黄金
         * 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","goods_picture":"http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg","buy_total":"1000","delivery_status":"0",
         * "is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},{"id":"22","pid":"28","issue_no":"1304916358","goods_id":"67","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状
         * 约1.62g","goods_picture":"http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg","buy_total":"1000","delivery_status":"0","is_evaluate":"0",
         * "is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},{"id":"21","pid":"22","issue_no":"1850003821","goods_id":"65","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard",
         * "goods_picture":"http://qmfq.baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg","buy_total":"3000","delivery_status":"0","is_evaluate":"0","is_virtual":"0",
         * "overtime":"1","delivery_status_text":"待发货"},{"id":"20","pid":"20","issue_no":"1381882978","goods_id":"71","goods_name":"高档茶壶","goods_picture":"http://qmfq.baonongkang
         * .cn/upload/goods/1499337509542.jpg","buy_total":"200","delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},{"id":"19","pid":"19",
         * "issue_no":"4896855698","goods_id":"67","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","goods_picture":"http://qmfq.baonongkang
         * .cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg","buy_total":"1000","delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"},
         * {"id":"18","pid":"16","issue_no":"8031888093","goods_id":"58","goods_name":"夏普电视机","goods_picture":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg","buy_total":"7987",
         * "delivery_status":"0","is_evaluate":"0","is_virtual":"0","overtime":"1","delivery_status_text":"待发货"}]
         * page : 1
         * count : 2
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
             * id : 33
             * pid : 29
             * issue_no : 5199536046
             * goods_id : 67
             * goods_name : 中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g
             * goods_picture : http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg
             * buy_total : 1000
             * delivery_status : 0
             * is_evaluate : 0
             * is_virtual : 0
             * overtime : 1
             * delivery_status_text : 待发货
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
            private String overtime;
            private String delivery_status_text;
            private boolean isCheck=false;

            public boolean isCheck() {
                return isCheck;
            }

            public void setCheck(boolean check) {
                isCheck = check;
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

            public String getOvertime() {
                return overtime;
            }

            public void setOvertime(String overtime) {
                this.overtime = overtime;
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
