package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2017/5/2.
 */

public class CityVO extends BaseVO {


    private List<DataBean> data;



    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * province_id : 34
         * area_id : 8
         * province_name : 台湾省
         * sort : 0
         * citys : [{"city_id":"345","province_id":"34","city_name":"台湾省","zipcode":"000000","sort":"0","districts":[{"district_id":"2869","city_id":"345","district_name":"台北","sort":"2"}]}]
         */
        @Override
        public String toString() {
            if(province_name!=null){
                return province_name;
            }else {
                return "";
            }
        }
        private String province_id;
        private String area_id;
        private String province_name;
        private String sort;
        private List<CitysBean> citys;

        public String getProvince_id() {
            return province_id;
        }

        public void setProvince_id(String province_id) {
            this.province_id = province_id;
        }

        public String getArea_id() {
            return area_id;
        }

        public void setArea_id(String area_id) {
            this.area_id = area_id;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public List<CitysBean> getCitys() {
            return citys;
        }

        public void setCitys(List<CitysBean> citys) {
            this.citys = citys;
        }

        public static class CitysBean {
            @Override
            public String toString() {
                if(city_name!=null){
                    return city_name;
                }else {
                    return "";
                }
            }

            /**
             * city_id : 345
             * province_id : 34
             * city_name : 台湾省
             * zipcode : 000000
             * sort : 0
             * districts : [{"district_id":"2869","city_id":"345","district_name":"台北","sort":"2"}]
             */

            private String city_id;
            private String province_id;
            private String city_name;
            private String zipcode;
            private String sort;
            private List<DistrictsBean> districts;

            public String getCity_id() {
                return city_id;
            }

            public void setCity_id(String city_id) {
                this.city_id = city_id;
            }

            public String getProvince_id() {
                return province_id;
            }

            public void setProvince_id(String province_id) {
                this.province_id = province_id;
            }

            public String getCity_name() {
                return city_name;
            }

            public void setCity_name(String city_name) {
                this.city_name = city_name;
            }

            public String getZipcode() {
                return zipcode;
            }

            public void setZipcode(String zipcode) {
                this.zipcode = zipcode;
            }

            public String getSort() {
                return sort;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public List<DistrictsBean> getDistricts() {
                return districts;
            }

            public void setDistricts(List<DistrictsBean> districts) {
                this.districts = districts;
            }

            public static class DistrictsBean {
                @Override
                public String toString() {
                    if(district_name!=null){
                        return district_name;
                    }else {
                        return "";
                    }
                }


                /**
                 * district_id : 2869
                 * city_id : 345
                 * district_name : 台北
                 * sort : 2
                 */

                private String district_id;
                private String city_id;
                private String district_name;
                private String sort;

                public String getDistrict_id() {
                    return district_id;
                }

                public void setDistrict_id(String district_id) {
                    this.district_id = district_id;
                }

                public String getCity_id() {
                    return city_id;
                }

                public void setCity_id(String city_id) {
                    this.city_id = city_id;
                }

                public String getDistrict_name() {
                    return district_name;
                }

                public void setDistrict_name(String district_name) {
                    this.district_name = district_name;
                }

                public String getSort() {
                    return sort;
                }

                public void setSort(String sort) {
                    this.sort = sort;
                }
            }
        }
    }
}


