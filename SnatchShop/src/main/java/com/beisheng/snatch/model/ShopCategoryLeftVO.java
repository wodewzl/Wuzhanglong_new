package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/3/15.
 */

public class ShopCategoryLeftVO extends BaseVO{

    /**
     * data : {"category_list":[{"category_id":"1","category_name":"家用电器","category_pic":""},{"category_id":"2","category_name":"数码通讯","category_pic":""},{"category_id":"3","category_name":"电脑办公",
     * "category_pic":""},{"category_id":"4","category_name":"家居用品","category_pic":""},{"category_id":"5","category_name":"女性时尚","category_pic":""},{"category_id":"6","category_name":"美妆个护",
     * "category_pic":""},{"category_id":"8","category_name":"运动户外","category_pic":""},{"category_id":"9","category_name":"汽车用品","category_pic":""},{"category_id":"10","category_name":"母婴玩具",
     * "category_pic":""},{"category_id":"11","category_name":"美食天地","category_pic":""}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<CategoryListBean> category_list;

        public List<CategoryListBean> getCategory_list() {
            return category_list;
        }

        public void setCategory_list(List<CategoryListBean> category_list) {
            this.category_list = category_list;
        }

        public static class CategoryListBean {
            /**
             * category_id : 1
             * category_name : 家用电器
             * category_pic :
             */

            private String category_id;
            private String category_name;
            private String category_pic;
            private boolean select=false;

            public boolean isSelect() {
                return select;
            }

            public void setSelect(boolean select) {
                this.select = select;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getCategory_name() {
                return category_name;
            }

            public void setCategory_name(String category_name) {
                this.category_name = category_name;
            }

            public String getCategory_pic() {
                return category_pic;
            }

            public void setCategory_pic(String category_pic) {
                this.category_pic = category_pic;
            }
        }
    }
}
