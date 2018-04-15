package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2017/5/10.
 */

public class ShopCatVO extends BaseVO {


    /**
     * data : {"list":[{"cart_id":"4","panic_id":"8","goods_id":"62","goods_name":"ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑","goods_image":"http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg","category_id":"3","num":"1","max_count":"5000","is_valid":"1"},{"cart_id":"3","panic_id":"15","goods_id":"57","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg","category_id":"3","num":"1","max_count":"5439","is_valid":"1"},{"cart_id":"5","panic_id":"2","goods_id":"57","goods_name":"14.1英寸轻薄刀锋四核笔记本电脑手提固态商务学生游戏上网本分期1","goods_image":"http://qmfq.baonongkang.cn/upload/goods/14993421511182.jpg","category_id":"3","num":"0","max_count":"0","is_valid":"0"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * cart_id : 4
             * panic_id : 8
             * goods_id : 62
             * goods_name : ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg
             * category_id : 3
             * num : 1
             * max_count : 5000
             * is_valid : 1
             */

            private String cart_id;
            private String panic_id;
            private String goods_id;
            private String goods_name;
            private String goods_image;
            private String category_id;
            private String num;
            private String max_count;
            private String is_valid;
            private String validedCount;
            private boolean longClick;
            private boolean isCheck;
            private String title;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public boolean isCheck() {
                return isCheck;
            }

            public void setCheck(boolean check) {
                isCheck = check;
            }

            public boolean isLongClick() {
                return longClick;
            }

            public void setLongClick(boolean longClick) {
                this.longClick = longClick;
            }

            public String getValidedCount() {
                return validedCount;
            }

            public void setValidedCount(String validedCount) {
                this.validedCount = validedCount;
            }

            public String getCart_id() {
                return cart_id;
            }

            public void setCart_id(String cart_id) {
                this.cart_id = cart_id;
            }

            public String getPanic_id() {
                return panic_id;
            }

            public void setPanic_id(String panic_id) {
                this.panic_id = panic_id;
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

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getNum() {
                return num;
            }

            public void setNum(String num) {
                this.num = num;
            }

            public String getMax_count() {
                return max_count;
            }

            public void setMax_count(String max_count) {
                this.max_count = max_count;
            }

            public String getIs_valid() {
                return is_valid;
            }

            public void setIs_valid(String is_valid) {
                this.is_valid = is_valid;
            }
        }
    }
}
