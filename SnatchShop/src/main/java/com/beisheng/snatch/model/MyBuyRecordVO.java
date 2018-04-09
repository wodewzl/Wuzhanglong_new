package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class MyBuyRecordVO extends BaseVO{

    /**
     * data : {"list":[{"panic_id":"8","goods_name":"ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg","issue_no":"9767084747","total_buy":"160","remain_count":"1800","seconds_remain":"0","is_prise":"0","prise_status":"1","status_text":"进行中"}],"page":"1","count":"1","guess_like":[{"id":"14","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g","category_id":"5","total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"}]}
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
         * list : [{"panic_id":"8","goods_name":"ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg","issue_no":"9767084747","total_buy":"160","remain_count":"1800","seconds_remain":"0","is_prise":"0","prise_status":"1","status_text":"进行中"}]
         * page : 1
         * count : 1
         * guess_like : [{"id":"14","goods_name":"菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g","category_id":"5","total_count":"4000","remain_count":"4000","percent":"0","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg"}]
         */

        private String page;
        private String count;
        private List<ListBean> list;
        private List<GuessLikeBean> guess_like;

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

        public List<GuessLikeBean> getGuess_like() {
            return guess_like;
        }

        public void setGuess_like(List<GuessLikeBean> guess_like) {
            this.guess_like = guess_like;
        }

        public static class ListBean {
            /**
             * panic_id : 8
             * goods_name : ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg
             * issue_no : 9767084747
             * total_buy : 160
             * remain_count : 1800
             * seconds_remain : 0
             * is_prise : 0
             * prise_status : 1
             * status_text : 进行中
             */

            private String panic_id;
            private String goods_name;
            private String goods_image;
            private String issue_no;
            private String total_buy;
            private String remain_count;
            private String seconds_remain;
            private String is_prise;
            private String prise_status;
            private String status_text;

            public String getPanic_id() {
                return panic_id;
            }

            public void setPanic_id(String panic_id) {
                this.panic_id = panic_id;
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

            public String getIssue_no() {
                return issue_no;
            }

            public void setIssue_no(String issue_no) {
                this.issue_no = issue_no;
            }

            public String getTotal_buy() {
                return total_buy;
            }

            public void setTotal_buy(String total_buy) {
                this.total_buy = total_buy;
            }

            public String getRemain_count() {
                return remain_count;
            }

            public void setRemain_count(String remain_count) {
                this.remain_count = remain_count;
            }

            public String getSeconds_remain() {
                return seconds_remain;
            }

            public void setSeconds_remain(String seconds_remain) {
                this.seconds_remain = seconds_remain;
            }

            public String getIs_prise() {
                return is_prise;
            }

            public void setIs_prise(String is_prise) {
                this.is_prise = is_prise;
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
        }

        public static class GuessLikeBean {
            /**
             * id : 14
             * goods_name : 菜百首饰 足金Au9999福字金条 菜百投资黄金金条 10g
             * category_id : 5
             * total_count : 4000
             * remain_count : 4000
             * percent : 0
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/20180315/466185ae6d62f4bbc900272b7bafbbec2.jpg
             */

            private String id;
            private String goods_name;
            private String category_id;
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

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
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
