package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/3/14.
 */

public class HomeChildVO extends BaseVO{

    /**
     * data : {"list":[{"id":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","total_count":"5600","remain_count":"5600","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/14993421511182.jpg"},{"id":"3","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang
     * .cn/upload/goods/1499340186842.jpg"}],"page":"1","count":"1"}
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
         * list : [{"id":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","total_count":"5600","remain_count":"5600","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/14993421511182.jpg"},{"id":"3","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/1499340186842.jpg"}]
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
             * id : 2
             * goods_name : 14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1
             * total_count : 5600
             * remain_count : 5600
             * percent : 0
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg
             */

            private String id;
            private String goods_name;
            private String total_count;
            private String remain_count;
            private String percent;
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

            public String getTotal_count() {
                return total_count;
            }

            public void setTotal_count(String total_count) {
                this.total_count = total_count;
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

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }
        }
    }
}
