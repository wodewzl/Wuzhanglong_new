package com.wzl.feifubao.mode;

import com.google.gson.annotations.SerializedName;
import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2017/12/31.
 */

public class YellowPagesVO extends BaseVO{

    /**
     * data : {"data":[{"supplier_id":"4","uid":"0","supplier_name":"一点点","desc":"湖北襄阳最大的奶茶","linkman_tel":"18672133699","linkman_name":"大表哥","linkman_address":"湖北襄阳","type":"2","pic":"http://183.95.85.31:8001/upload/house/5a4c9e9353200.png","class_id":"39","name":"餐饮美食"},{"supplier_id":"3","uid":"0","supplier_name":"顺丰物流","desc":"湖北襄阳最大的物流","linkman_tel":"18672133699","linkman_name":"juyoujuju","linkman_address":"湖北襄阳","type":"2","pic":"http://183.95.85.31:8001/upload/house/5a4c9e9353200.png","class_id":"40","name":"快递物流"},{"supplier_id":"2","uid":"0","supplier_name":"coco奶茶","desc":"湖北襄阳最大的naicha","linkman_tel":"18672133699","linkman_name":"李先生","linkman_address":"湖北襄阳","type":"2","pic":"http://183.95.85.31:8001/upload/house/5a4c9e9353200.png","class_id":"39","name":"餐饮美食"}],"total_count":"3","page_count":"1"}
     */

    private DataBeanX data;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * data : [{"supplier_id":"4","uid":"0","supplier_name":"一点点","desc":"湖北襄阳最大的奶茶","linkman_tel":"18672133699","linkman_name":"大表哥","linkman_address":"湖北襄阳","type":"2","pic":"http://183.95.85.31:8001/upload/house/5a4c9e9353200.png","class_id":"39","name":"餐饮美食"},{"supplier_id":"3","uid":"0","supplier_name":"顺丰物流","desc":"湖北襄阳最大的物流","linkman_tel":"18672133699","linkman_name":"juyoujuju","linkman_address":"湖北襄阳","type":"2","pic":"http://183.95.85.31:8001/upload/house/5a4c9e9353200.png","class_id":"40","name":"快递物流"},{"supplier_id":"2","uid":"0","supplier_name":"coco奶茶","desc":"湖北襄阳最大的naicha","linkman_tel":"18672133699","linkman_name":"李先生","linkman_address":"湖北襄阳","type":"2","pic":"http://183.95.85.31:8001/upload/house/5a4c9e9353200.png","class_id":"39","name":"餐饮美食"}]
         * total_count : 3
         * page_count : 1
         */

        private String total_count;
        private String page_count;
        private List<DataBean> data;

        public String getTotal_count() {
            return total_count;
        }

        public void setTotal_count(String total_count) {
            this.total_count = total_count;
        }

        public String getPage_count() {
            return page_count;
        }

        public void setPage_count(String page_count) {
            this.page_count = page_count;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * supplier_id : 4
             * uid : 0
             * supplier_name : 一点点
             * desc : 湖北襄阳最大的奶茶
             * linkman_tel : 18672133699
             * linkman_name : 大表哥
             * linkman_address : 湖北襄阳
             * type : 2
             * pic : http://183.95.85.31:8001/upload/house/5a4c9e9353200.png
             * class_id : 39
             * name : 餐饮美食
             */

            private String supplier_id;
            private String uid;
            private String supplier_name;
            @SerializedName("desc")
            private String descX;
            private String linkman_tel;
            private String linkman_name;
            private String linkman_address;
            private String type;
            private String pic;
            private String class_id;
            private String name;

            public String getSupplier_id() {
                return supplier_id;
            }

            public void setSupplier_id(String supplier_id) {
                this.supplier_id = supplier_id;
            }

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
            }

            public String getSupplier_name() {
                return supplier_name;
            }

            public void setSupplier_name(String supplier_name) {
                this.supplier_name = supplier_name;
            }

            public String getDescX() {
                return descX;
            }

            public void setDescX(String descX) {
                this.descX = descX;
            }

            public String getLinkman_tel() {
                return linkman_tel;
            }

            public void setLinkman_tel(String linkman_tel) {
                this.linkman_tel = linkman_tel;
            }

            public String getLinkman_name() {
                return linkman_name;
            }

            public void setLinkman_name(String linkman_name) {
                this.linkman_name = linkman_name;
            }

            public String getLinkman_address() {
                return linkman_address;
            }

            public void setLinkman_address(String linkman_address) {
                this.linkman_address = linkman_address;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getClass_id() {
                return class_id;
            }

            public void setClass_id(String class_id) {
                this.class_id = class_id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
