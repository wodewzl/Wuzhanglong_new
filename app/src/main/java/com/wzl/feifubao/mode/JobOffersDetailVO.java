package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by wuzhanglong on 2018/1/6.
 */

public class JobOffersDetailVO extends BaseVO{

    /**
     * data : {"id":"1","supplier_id":"5","supplier_name":"浦发银行","position_name":"信用卡专员","position_salary":"9000.00","position_class":"43","position_class_name":"信用卡专员","position_education":"46","position_life":"47","position_desc":"卖信用卡的","position_createtime":"","address":"湖北襄阳","company_desc":"伤害浦发银行信用卡中心，是全国最早活的获得金融许可证的信用卡中心之一","linkman_name":"juyoujuju","linkman_tel":"18672133655"}
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
         * address : 湖北襄阳
         * company_desc : 伤害浦发银行信用卡中心，是全国最早活的获得金融许可证的信用卡中心之一
         * linkman_name : juyoujuju
         * linkman_tel : 18672133655
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
        private String address;
        private String company_desc;
        private String linkman_name;
        private String linkman_tel;

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCompany_desc() {
            return company_desc;
        }

        public void setCompany_desc(String company_desc) {
            this.company_desc = company_desc;
        }

        public String getLinkman_name() {
            return linkman_name;
        }

        public void setLinkman_name(String linkman_name) {
            this.linkman_name = linkman_name;
        }

        public String getLinkman_tel() {
            return linkman_tel;
        }

        public void setLinkman_tel(String linkman_tel) {
            this.linkman_tel = linkman_tel;
        }
    }
}
