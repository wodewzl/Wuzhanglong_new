package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2017/12/30.
 */

public class HouseOptionVO extends BaseVO{

    /**
     * data : {"huxing":[{"class_id":"5","name":"三室一厅"},{"class_id":"6","name":"三室两厅"}],"fukuan":[{"class_id":"12","name":"押一付三"}],"language":[{"class_id":"14","name":"菲律宾语"},{"class_id":"15","name":"英语"},{"class_id":"16","name":"中文"}],"rentingStyle":[{"class_id":"18","name":"整租"},{"class_id":"19","name":"合租"},{"class_id":"20","name":"短租"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<HuxingBean> huxing;
        private List<FukuanBean> fukuan;
        private List<LanguageBean> language;
        private List<RentingStyleBean> rentingStyle;

        public List<HuxingBean> getHuxing() {
            return huxing;
        }

        public void setHuxing(List<HuxingBean> huxing) {
            this.huxing = huxing;
        }

        public List<FukuanBean> getFukuan() {
            return fukuan;
        }

        public void setFukuan(List<FukuanBean> fukuan) {
            this.fukuan = fukuan;
        }

        public List<LanguageBean> getLanguage() {
            return language;
        }

        public void setLanguage(List<LanguageBean> language) {
            this.language = language;
        }

        public List<RentingStyleBean> getRentingStyle() {
            return rentingStyle;
        }

        public void setRentingStyle(List<RentingStyleBean> rentingStyle) {
            this.rentingStyle = rentingStyle;
        }

        public static class HuxingBean {
            /**
             * class_id : 5
             * name : 三室一厅
             */

            private String class_id;
            private String name;

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

        public static class FukuanBean {
            /**
             * class_id : 12
             * name : 押一付三
             */

            private String class_id;
            private String name;

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

        public static class LanguageBean {
            /**
             * class_id : 14
             * name : 菲律宾语
             */

            private String class_id;
            private String name;

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

        public static class RentingStyleBean {
            /**
             * class_id : 18
             * name : 整租
             */

            private String class_id;
            private String name;

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
