package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2017/12/30.
 */

public class HouseOptionVO extends BaseVO{


    /**
     * data : {"huxing":[{"class_id":"5","name":"三室一厅"},{"class_id":"6","name":"三室两厅"},{"class_id":"55","name":"一室一厅"},{"class_id":"56","name":"两室两厅"},{"class_id":"57","name":"两室一厅"},{"class_id":"58","name":"一室零厅"}],"fukuan":[{"class_id":"12","name":"押一付三"},{"class_id":"54","name":"押一付二"},{"class_id":"59","name":"押一付一"},{"class_id":"64","name":"押二付二"}],"language":[{"class_id":"14","name":"菲律宾语"},{"class_id":"15","name":"英语"},{"class_id":"16","name":"中文"}],"rentingStyle":[{"class_id":"18","name":"整租"},{"class_id":"19","name":"合租"},{"class_id":"60","name":"短租"}],"decorateStyle":[{"class_id":"23","name":"普通装修"},{"class_id":"24","name":"中等装修"},{"class_id":"25","name":"精装修"}],"houseStyle":[{"class_id":"28","name":"公寓"},{"class_id":"29","name":"Loft上下层"},{"class_id":"30","name":"别墅"},{"class_id":"61","name":"酒店"}],"position":[{"class_id":"31","name":"有阳台"},{"class_id":"32","name":"无阳台"}],"tag":[{"class_id":"34","name":"配套齐全"},{"class_id":"35","name":"绿化好"},{"class_id":"36","name":"地铁近"}],"yellowPagesClass":[{"class_id":"39","name":"餐饮美食"},{"class_id":"40","name":"快递物流"},{"class_id":"53","name":"留学教育"},{"class_id":"65","name":"银行金融"},{"class_id":"69","name":"休闲娱乐"},{"class_id":"70","name":"商超购物"},{"class_id":"71","name":"宾馆酒店"},{"class_id":"72","name":"政府部门"}],"networkSupplier":[{"supplier_id":"40","supplier_name":"PLDT"},{"supplier_id":"39","supplier_name":"Globle"}]}
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
        private List<DecorateStyleBean> decorateStyle;
        private List<HouseStyleBean> houseStyle;
        private List<PositionBean> position;
        private List<TagBean> tag;
        private List<YellowPagesClassBean> yellowPagesClass;
        private List<NetworkSupplierBean> networkSupplier;

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

        public List<DecorateStyleBean> getDecorateStyle() {
            return decorateStyle;
        }

        public void setDecorateStyle(List<DecorateStyleBean> decorateStyle) {
            this.decorateStyle = decorateStyle;
        }

        public List<HouseStyleBean> getHouseStyle() {
            return houseStyle;
        }

        public void setHouseStyle(List<HouseStyleBean> houseStyle) {
            this.houseStyle = houseStyle;
        }

        public List<PositionBean> getPosition() {
            return position;
        }

        public void setPosition(List<PositionBean> position) {
            this.position = position;
        }

        public List<TagBean> getTag() {
            return tag;
        }

        public void setTag(List<TagBean> tag) {
            this.tag = tag;
        }

        public List<YellowPagesClassBean> getYellowPagesClass() {
            return yellowPagesClass;
        }

        public void setYellowPagesClass(List<YellowPagesClassBean> yellowPagesClass) {
            this.yellowPagesClass = yellowPagesClass;
        }

        public List<NetworkSupplierBean> getNetworkSupplier() {
            return networkSupplier;
        }

        public void setNetworkSupplier(List<NetworkSupplierBean> networkSupplier) {
            this.networkSupplier = networkSupplier;
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

        public static class DecorateStyleBean {
            /**
             * class_id : 23
             * name : 普通装修
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

        public static class HouseStyleBean {
            /**
             * class_id : 28
             * name : 公寓
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

        public static class PositionBean {
            /**
             * class_id : 31
             * name : 有阳台
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

        public static class TagBean {
            /**
             * class_id : 34
             * name : 配套齐全
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

        public static class YellowPagesClassBean {
            /**
             * class_id : 39
             * name : 餐饮美食
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

        public static class NetworkSupplierBean {
            /**
             * supplier_id : 40
             * supplier_name : PLDT
             */

            private String supplier_id;
            private String supplier_name;

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
        }
    }
}
