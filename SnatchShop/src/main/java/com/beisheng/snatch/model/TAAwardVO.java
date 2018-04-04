package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/4.
 */

public class TAAwardVO extends BaseVO{

    /**
     * data : {"list":[{"id":"1","panic_id":"2","issue_no":"2014980203","goods_id":"57","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","goods_picture":"http://qmfq.baonongkang
     * .cn/upload/goods/14993421511182.jpg","total_buy":"5590","prise_code":"1003872","publish_time":"2018-03-20 10:24:01","total_count":"5600","latest_pid":"0"}],"page":"1","count":"1"}
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
         * list : [{"id":"1","panic_id":"2","issue_no":"2014980203","goods_id":"57","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","goods_picture":"http://qmfq.baonongkang
         * .cn/upload/goods/14993421511182.jpg","total_buy":"5590","prise_code":"1003872","publish_time":"2018-03-20 10:24:01","total_count":"5600","latest_pid":"0"}]
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
             * panic_id : 2
             * issue_no : 2014980203
             * goods_id : 57
             * goods_name : 14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1
             * goods_picture : http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg
             * total_buy : 5590
             * prise_code : 1003872
             * publish_time : 2018-03-20 10:24:01
             * total_count : 5600
             * latest_pid : 0
             */

            private String id;
            private String panic_id;
            private String issue_no;
            private String goods_id;
            private String goods_name;
            private String goods_picture;
            private String total_buy;
            private String prise_code;
            private String publish_time;
            private String total_count;
            private String latest_pid;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPanic_id() {
                return panic_id;
            }

            public void setPanic_id(String panic_id) {
                this.panic_id = panic_id;
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

            public String getTotal_buy() {
                return total_buy;
            }

            public void setTotal_buy(String total_buy) {
                this.total_buy = total_buy;
            }

            public String getPrise_code() {
                return prise_code;
            }

            public void setPrise_code(String prise_code) {
                this.prise_code = prise_code;
            }

            public String getPublish_time() {
                return publish_time;
            }

            public void setPublish_time(String publish_time) {
                this.publish_time = publish_time;
            }

            public String getTotal_count() {
                return total_count;
            }

            public void setTotal_count(String total_count) {
                this.total_count = total_count;
            }

            public String getLatest_pid() {
                return latest_pid;
            }

            public void setLatest_pid(String latest_pid) {
                this.latest_pid = latest_pid;
            }
        }
    }
}
