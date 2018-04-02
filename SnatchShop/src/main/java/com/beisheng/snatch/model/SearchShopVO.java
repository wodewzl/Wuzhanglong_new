package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/3/22.
 */

public class SearchShopVO extends BaseVO{


    /**
     * data : {"list":[{"id":"15","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","total_count":"5600","remain_count":"5559","percent":"1","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg"},{"id":"14","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g","total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"},{"id":"13","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","total_count":"1000","remain_count":"1000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg"},{"id":"12","goods_name":"美度手表(MIDO)手表 贝伦赛丽自动机械女表 40周年纪念款 M027.207.36.013.00白盘皮带","total_count":"10000","remain_count":"10000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/374fb5a5f21149269b1e0af795d3db4a2.jpg"},{"id":"11","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","total_count":"3000","remain_count":"3000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg"},{"id":"10","goods_name":"雷霆世纪The fire 六核i5-8400/GTX1070-8G/华硕Z370/M.2 128G SSD/吃鸡专用","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/745df0276343f610978b770fed2852572.jpg"},{"id":"9","goods_name":"Apple iPad 平板电脑 9.7英寸（128G WLAN版/A9 芯片/Retina显示屏/Touch ID技术","total_count":"6000","remain_count":"6000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/ce395a0993094b860749de13dfa9354b2.jpg"},{"id":"8","goods_name":"ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑","total_count":"5000","remain_count":"5000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg"},{"id":"7","goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅","total_count":"4000","remain_count":"3980","percent":"1","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"},{"id":"6","goods_name":"索尼（SONY） ILCE-7RM2全画幅微单相机单机身(约4240万有效像素 4K视频 5轴防抖","total_count":"15000","remain_count":"14964","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/f90e4e724f918b7f1fa7a044bf6054e22.jpg"}],"page":"1","count":"1"}
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
         * list : [{"id":"15","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","total_count":"5600","remain_count":"5559","percent":"1","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg"},{"id":"14","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g","total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"},{"id":"13","goods_name":"中国黄金 足金黄金耳钉女磨砂路路通耳钉耳饰珠宝首饰 圆状 约1.62g","total_count":"1000","remain_count":"1000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/b602cee595a2a17a6aff66ff30c6610f2.jpg"},{"id":"12","goods_name":"美度手表(MIDO)手表 贝伦赛丽自动机械女表 40周年纪念款 M027.207.36.013.00白盘皮带","total_count":"10000","remain_count":"10000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/374fb5a5f21149269b1e0af795d3db4a2.jpg"},{"id":"11","goods_name":"Apple适用于12.9英寸iPad Pro的Smart Keyboard","total_count":"3000","remain_count":"3000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/69f5fd5aa4d909009a4f0763b110d7e52.jpg"},{"id":"10","goods_name":"雷霆世纪The fire 六核i5-8400/GTX1070-8G/华硕Z370/M.2 128G SSD/吃鸡专用","total_count":"8000","remain_count":"8000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/745df0276343f610978b770fed2852572.jpg"},{"id":"9","goods_name":"Apple iPad 平板电脑 9.7英寸（128G WLAN版/A9 芯片/Retina显示屏/Touch ID技术","total_count":"6000","remain_count":"6000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/ce395a0993094b860749de13dfa9354b2.jpg"},{"id":"8","goods_name":"ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑","total_count":"5000","remain_count":"5000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg"},{"id":"7","goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅","total_count":"4000","remain_count":"3980","percent":"1","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"},{"id":"6","goods_name":"索尼（SONY） ILCE-7RM2全画幅微单相机单机身(约4240万有效像素 4K视频 5轴防抖","total_count":"15000","remain_count":"14964","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/f90e4e724f918b7f1fa7a044bf6054e22.jpg"}]
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
             * total_count : 5600
             * remain_count : 5559
             * percent : 1
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
