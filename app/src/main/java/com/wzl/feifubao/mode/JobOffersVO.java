package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2017/12/30.
 */

public class JobOffersVO extends BaseVO{

    /**
     * data : {"data":[{"id":"1","supplier_id":"5","supplier_name":"浦发银行","position_name":"信用卡专员","position_salary":"9000.00","position_class":"43","position_class_name":"信用卡专员","position_education":"46","position_life":"47","position_desc":"卖信用卡的","position_createtime":""},{"id":"2","supplier_id":"5","supplier_name":"浦发银行","position_name":"信用卡专员","position_salary":"9000.00","position_class":"43","position_class_name":"信用卡专员","position_education":"46","position_life":"47","position_desc":"卖信用卡的，分段式hi呼呼大睡","position_createtime":""}],"total_count":"2","page_count":"1"}
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
         * data : [{"id":"1","supplier_id":"5","supplier_name":"浦发银行","position_name":"信用卡专员","position_salary":"9000.00","position_class":"43","position_class_name":"信用卡专员","position_education":"46","position_life":"47","position_desc":"卖信用卡的","position_createtime":""},{"id":"2","supplier_id":"5","supplier_name":"浦发银行","position_name":"信用卡专员","position_salary":"9000.00","position_class":"43","position_class_name":"信用卡专员","position_education":"46","position_life":"47","position_desc":"卖信用卡的，分段式hi呼呼大睡","position_createtime":""}]
         * total_count : 2
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
             * id : 1
             * supplier_id : 5
             * supplier_name : 浦发银行
             * position_name : 信用卡专员
             * position_salary : 9000.00
             * position_class : 43
             * position_class_name : 信用卡专员
             * position_education : 46
             * position_life : 47
             * position_desc : 卖信用卡的
             * position_createtime :
             */

            private String id;
            private String supplier_id;
            private String supplier_name;
            private String position_name;
            private String position_salary;
            private String position_class;
            private String position_class_name;
            private String position_education;
            private String position_life;
            private String position_desc;
            private String position_createtime;
            private String position_education_name;
            private String position_life_name;

            public String getPosition_life_name() {
                return position_life_name;
            }

            public void setPosition_life_name(String position_life_name) {
                this.position_life_name = position_life_name;
            }

            public String getPosition_education_name() {
                return position_education_name;
            }

            public void setPosition_education_name(String position_education_name) {
                this.position_education_name = position_education_name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getSupplier_id() {
                return supplier_id;
            }

            public void setSupplier_id(String supplier_id) {
                this.supplier_id = supplier_id;
            }

            public String getSupplier_name() {
                return supplier_name;
            }

            public void setSupplier_name(String supplier_name) {
                this.supplier_name = supplier_name;
            }

            public String getPosition_name() {
                return position_name;
            }

            public void setPosition_name(String position_name) {
                this.position_name = position_name;
            }

            public String getPosition_salary() {
                return position_salary;
            }

            public void setPosition_salary(String position_salary) {
                this.position_salary = position_salary;
            }

            public String getPosition_class() {
                return position_class;
            }

            public void setPosition_class(String position_class) {
                this.position_class = position_class;
            }

            public String getPosition_class_name() {
                return position_class_name;
            }

            public void setPosition_class_name(String position_class_name) {
                this.position_class_name = position_class_name;
            }

            public String getPosition_education() {
                return position_education;
            }

            public void setPosition_education(String position_education) {
                this.position_education = position_education;
            }

            public String getPosition_life() {
                return position_life;
            }

            public void setPosition_life(String position_life) {
                this.position_life = position_life;
            }

            public String getPosition_desc() {
                return position_desc;
            }

            public void setPosition_desc(String position_desc) {
                this.position_desc = position_desc;
            }

            public String getPosition_createtime() {
                return position_createtime;
            }

            public void setPosition_createtime(String position_createtime) {
                this.position_createtime = position_createtime;
            }
        }
    }
}
