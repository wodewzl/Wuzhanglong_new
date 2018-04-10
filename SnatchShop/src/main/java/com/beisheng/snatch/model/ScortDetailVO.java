package com.beisheng.snatch.model;

import com.google.gson.annotations.SerializedName;
import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class ScortDetailVO extends BaseVO{

    /**
     * data : {"list":[{"id":"162","month":"04月","date_week":"09日/周一","date_time":"17:06:12","type_name":"每日任务","number":"1","sign":"1"},{"id":"160","month":"04月","date_week":"09日/周一","date_time":"12:09:36","type_name":"每日任务","number":"10","sign":"1"},{"id":"158","month":"04月","date_week":"09日/周一","date_time":"10:10:34","type_name":"商城订单","number":"0","sign":"1"},{"id":"157","month":"04月","date_week":"09日/周一","date_time":"10:09:53","type_name":"商城订单","number":"-1000","sign":"0"},{"id":"156","month":"04月","date_week":"09日/周一","date_time":"09:35:00","type_name":"7日签到礼包","number":"10","sign":"1"},{"id":"154","month":"04月","date_week":"09日/周一","date_time":"09:34:08","type_name":"签到","number":"1","sign":"1"},{"id":"150","month":"04月","date_week":"08日/周日","date_time":"11:53:02","type_name":"每日任务","number":"1","sign":"1"},{"id":"134","month":"04月","date_week":"04日/周三","date_time":"15:54:02","type_name":"每日任务","number":"10","sign":"1"},{"id":"130","month":"04月","date_week":"03日/周二","date_time":"17:05:24","type_name":"每日任务","number":"1","sign":"1"},{"id":"129","month":"04月","date_week":"03日/周二","date_time":"09:50:43","type_name":"签到","number":"1","sign":"1"}],"page":"1","count":"5"}
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
         * list : [{"id":"162","month":"04月","date_week":"09日/周一","date_time":"17:06:12","type_name":"每日任务","number":"1","sign":"1"},{"id":"160","month":"04月","date_week":"09日/周一","date_time":"12:09:36","type_name":"每日任务","number":"10","sign":"1"},{"id":"158","month":"04月","date_week":"09日/周一","date_time":"10:10:34","type_name":"商城订单","number":"0","sign":"1"},{"id":"157","month":"04月","date_week":"09日/周一","date_time":"10:09:53","type_name":"商城订单","number":"-1000","sign":"0"},{"id":"156","month":"04月","date_week":"09日/周一","date_time":"09:35:00","type_name":"7日签到礼包","number":"10","sign":"1"},{"id":"154","month":"04月","date_week":"09日/周一","date_time":"09:34:08","type_name":"签到","number":"1","sign":"1"},{"id":"150","month":"04月","date_week":"08日/周日","date_time":"11:53:02","type_name":"每日任务","number":"1","sign":"1"},{"id":"134","month":"04月","date_week":"04日/周三","date_time":"15:54:02","type_name":"每日任务","number":"10","sign":"1"},{"id":"130","month":"04月","date_week":"03日/周二","date_time":"17:05:24","type_name":"每日任务","number":"1","sign":"1"},{"id":"129","month":"04月","date_week":"03日/周二","date_time":"09:50:43","type_name":"签到","number":"1","sign":"1"}]
         * page : 1
         * count : 5
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
             * id : 162
             * month : 04月
             * date_week : 09日/周一
             * date_time : 17:06:12
             * type_name : 每日任务
             * number : 1
             * sign : 1
             */

            private String id;
            private String month;
            private String date_week;
            @SerializedName("date_time")
            private String date_timeX;
            private String type_name;
            private String number;
            private String sign;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getMonth() {
                return month;
            }

            public void setMonth(String month) {
                this.month = month;
            }

            public String getDate_week() {
                return date_week;
            }

            public void setDate_week(String date_week) {
                this.date_week = date_week;
            }

            public String getDate_timeX() {
                return date_timeX;
            }

            public void setDate_timeX(String date_timeX) {
                this.date_timeX = date_timeX;
            }

            public String getType_name() {
                return type_name;
            }

            public void setType_name(String type_name) {
                this.type_name = type_name;
            }

            public String getNumber() {
                return number;
            }

            public void setNumber(String number) {
                this.number = number;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }
        }
    }
}
