package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/3/8.
 */

public class HomeVO extends BaseVO{

    /**
     * data : {"multi_adv":[{"adv_title":"app夺宝首页轮播广告位默认图","adv_url":"","adv_image":"http://qmfq.baonongkang.cn/public/static/images/default_img_url/waplunbo.png","adv_width":"320",
     * "adv_height":"175"}],"single_adv":{"adv_title":"app夺宝单图广告位默认图","adv_url":"","adv_image":"http://qmfq.baonongkang.cn/public/static/images/default_img_url/wapshangchengremai.png",
     * "adv_width":"750","adv_height":"200"},"nav_list":[{"nav_title":"商品分类","nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850337.png","nav_url":""},{"nav_title":"优选商品",
     * "nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850320.png","nav_url":""},{"nav_title":"每日任务","nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850328.png","nav_url":""},
     * {"nav_title":"邀一得二","nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850307.png","nav_url":""}],"order1_list":[{"id":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1",
     * "total_count":"5600","remain_count":"5600","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg"},{"id":"3","goods_name":"夏普电视机","total_count":"8000",
     * "remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"}],"order2_list":[{"id":"3","goods_name":"夏普电视机","total_count":"8000",
     * "remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"},{"id":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1",
     * "total_count":"5600","remain_count":"5600","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg"}],"order3_list":[{"id":"2",
     * "goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","total_count":"5600","remain_count":"5600","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg"},
     * {"id":"3","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"}],"order4_list":[{"id":"3",
     * "goods_name":"夏普电视机","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"},{"id":"2",
     * "goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","total_count":"5600","remain_count":"5600","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg"}],
     * "page":"1","count":"2"}
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
         * multi_adv : [{"adv_title":"app夺宝首页轮播广告位默认图","adv_url":"","adv_image":"http://qmfq.baonongkang.cn/public/static/images/default_img_url/waplunbo.png","adv_width":"320","adv_height":"175"}]
         * single_adv : {"adv_title":"app夺宝单图广告位默认图","adv_url":"","adv_image":"http://qmfq.baonongkang.cn/public/static/images/default_img_url/wapshangchengremai.png","adv_width":"750",
         * "adv_height":"200"}
         * nav_list : [{"nav_title":"商品分类","nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850337.png","nav_url":""},{"nav_title":"优选商品","nav_icon":"http://qmfq.baonongkang
         * .cn/upload/common/1520850320.png","nav_url":""},{"nav_title":"每日任务","nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850328.png","nav_url":""},{"nav_title":"邀一得二",
         * "nav_icon":"http://qmfq.baonongkang.cn/upload/common/1520850307.png","nav_url":""}]
         * order1_list : [{"id":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","total_count":"5600","remain_count":"5600","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/14993421511182.jpg"},{"id":"3","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/1499340186842.jpg"}]
         * order2_list : [{"id":"3","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"},
         * {"id":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","total_count":"5600","remain_count":"5600","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/14993421511182.jpg"}]
         * order3_list : [{"id":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","total_count":"5600","remain_count":"5600","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/14993421511182.jpg"},{"id":"3","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/1499340186842.jpg"}]
         * order4_list : [{"id":"3","goods_name":"夏普电视机","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg"},
         * {"id":"2","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","total_count":"5600","remain_count":"5600","percent":"0","goods_image":"http://qmfq.baonongkang
         * .cn/upload/goods/14993421511182.jpg"}]
         * page : 1
         * count : 2
         */

        private SingleAdvBean single_adv;
        private String page;
        private String count;
        private List<MultiAdvBean> multi_adv;
        private List<NavListBean> nav_list;
        private List<Order1ListBean> order1_list;
        private List<Order2ListBean> order2_list;
        private List<Order3ListBean> order3_list;
        private List<Order4ListBean> order4_list;

        public SingleAdvBean getSingle_adv() {
            return single_adv;
        }

        public void setSingle_adv(SingleAdvBean single_adv) {
            this.single_adv = single_adv;
        }

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

        public List<MultiAdvBean> getMulti_adv() {
            return multi_adv;
        }

        public void setMulti_adv(List<MultiAdvBean> multi_adv) {
            this.multi_adv = multi_adv;
        }

        public List<NavListBean> getNav_list() {
            return nav_list;
        }

        public void setNav_list(List<NavListBean> nav_list) {
            this.nav_list = nav_list;
        }

        public List<Order1ListBean> getOrder1_list() {
            return order1_list;
        }

        public void setOrder1_list(List<Order1ListBean> order1_list) {
            this.order1_list = order1_list;
        }

        public List<Order2ListBean> getOrder2_list() {
            return order2_list;
        }

        public void setOrder2_list(List<Order2ListBean> order2_list) {
            this.order2_list = order2_list;
        }

        public List<Order3ListBean> getOrder3_list() {
            return order3_list;
        }

        public void setOrder3_list(List<Order3ListBean> order3_list) {
            this.order3_list = order3_list;
        }

        public List<Order4ListBean> getOrder4_list() {
            return order4_list;
        }

        public void setOrder4_list(List<Order4ListBean> order4_list) {
            this.order4_list = order4_list;
        }

        public static class SingleAdvBean {
            /**
             * adv_title : app夺宝单图广告位默认图
             * adv_url :
             * adv_image : http://qmfq.baonongkang.cn/public/static/images/default_img_url/wapshangchengremai.png
             * adv_width : 750
             * adv_height : 200
             */

            private String adv_title;
            private String adv_url;
            private String adv_image;
            private String adv_width;
            private String adv_height;

            public String getAdv_title() {
                return adv_title;
            }

            public void setAdv_title(String adv_title) {
                this.adv_title = adv_title;
            }

            public String getAdv_url() {
                return adv_url;
            }

            public void setAdv_url(String adv_url) {
                this.adv_url = adv_url;
            }

            public String getAdv_image() {
                return adv_image;
            }

            public void setAdv_image(String adv_image) {
                this.adv_image = adv_image;
            }

            public String getAdv_width() {
                return adv_width;
            }

            public void setAdv_width(String adv_width) {
                this.adv_width = adv_width;
            }

            public String getAdv_height() {
                return adv_height;
            }

            public void setAdv_height(String adv_height) {
                this.adv_height = adv_height;
            }
        }

        public static class MultiAdvBean {
            /**
             * adv_title : app夺宝首页轮播广告位默认图
             * adv_url :
             * adv_image : http://qmfq.baonongkang.cn/public/static/images/default_img_url/waplunbo.png
             * adv_width : 320
             * adv_height : 175
             */

            private String adv_title;
            private String adv_url;
            private String adv_image;
            private String adv_width;
            private String adv_height;

            public String getAdv_title() {
                return adv_title;
            }

            public void setAdv_title(String adv_title) {
                this.adv_title = adv_title;
            }

            public String getAdv_url() {
                return adv_url;
            }

            public void setAdv_url(String adv_url) {
                this.adv_url = adv_url;
            }

            public String getAdv_image() {
                return adv_image;
            }

            public void setAdv_image(String adv_image) {
                this.adv_image = adv_image;
            }

            public String getAdv_width() {
                return adv_width;
            }

            public void setAdv_width(String adv_width) {
                this.adv_width = adv_width;
            }

            public String getAdv_height() {
                return adv_height;
            }

            public void setAdv_height(String adv_height) {
                this.adv_height = adv_height;
            }
        }

        public static class NavListBean {
            /**
             * nav_title : 商品分类
             * nav_icon : http://qmfq.baonongkang.cn/upload/common/1520850337.png
             * nav_url :
             */

            private String nav_title;
            private String nav_icon;
            private String nav_url;

            public String getNav_title() {
                return nav_title;
            }

            public void setNav_title(String nav_title) {
                this.nav_title = nav_title;
            }

            public String getNav_icon() {
                return nav_icon;
            }

            public void setNav_icon(String nav_icon) {
                this.nav_icon = nav_icon;
            }

            public String getNav_url() {
                return nav_url;
            }

            public void setNav_url(String nav_url) {
                this.nav_url = nav_url;
            }
        }

        public static class Order1ListBean {
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

        public static class Order2ListBean {
            /**
             * id : 3
             * goods_name : 夏普电视机
             * total_count : 8000
             * remain_count : 8000
             * percent : 0
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg
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

        public static class Order3ListBean {
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

        public static class Order4ListBean {
            /**
             * id : 3
             * goods_name : 夏普电视机
             * total_count : 8000
             * remain_count : 8000
             * percent : 0
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/1499340186842.jpg
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
