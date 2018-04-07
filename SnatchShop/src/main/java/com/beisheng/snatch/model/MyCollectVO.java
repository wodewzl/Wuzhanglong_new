package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class MyCollectVO extends BaseVO{


    /**
     * data : {"list":[{"log_id":"22","pid":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg","total_count":"5600","fav_time":"2018-04-07 17:00:59"}],"page":"1","count":"1"}
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
         * list : [{"log_id":"22","pid":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg","total_count":"5600","fav_time":"2018-04-07 17:00:59"}]
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
             * log_id : 22
             * pid : 2
             * goods_name : 14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg
             * total_count : 5600
             * fav_time : 2018-04-07 17:00:59
             */

            private String log_id;
            private String pid;
            private String goods_name;
            private String goods_image;
            private String total_count;
            private String fav_time;

            public String getLog_id() {
                return log_id;
            }

            public void setLog_id(String log_id) {
                this.log_id = log_id;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getTotal_count() {
                return total_count;
            }

            public void setTotal_count(String total_count) {
                this.total_count = total_count;
            }

            public String getFav_time() {
                return fav_time;
            }

            public void setFav_time(String fav_time) {
                this.fav_time = fav_time;
            }
        }
    }
}
