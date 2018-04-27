package com.beisheng.snatch.model;

import com.google.gson.annotations.SerializedName;
import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/27.
 */

public class MyFlowRecordVO extends BaseVO{

    /**
     * data : {"list":[{"id":"16","flow_count":"5MB","mobile":"189****7406","create_time":"1523872234","recharge_status":"2","recharge_time":"1523872346","status_text":"兑换失败","month":"04月",
     * "date_week":"16日/周一","date_time":"17:50:34"},{"id":"15","flow_count":"5MB","mobile":"189****7406","create_time":"1523871364","recharge_status":"2","recharge_time":"1523871505",
     * "status_text":"兑换失败","month":"04月","date_week":"16日/周一","date_time":"17:36:04"},{"id":"14","flow_count":"10MB","mobile":"189****7406","create_time":"1523866780","recharge_status":"2",
     * "recharge_time":"1523866940","status_text":"兑换失败","month":"04月","date_week":"16日/周一","date_time":"16:19:40"},{"id":"13","flow_count":"5MB","mobile":"189****7406","create_time":"1523866602",
     * "recharge_status":"2","recharge_time":"1523866700","status_text":"兑换失败","month":"04月","date_week":"16日/周一","date_time":"16:16:42"},{"id":"12","flow_count":"5MB","mobile":"189****1696",
     * "create_time":"1523866009","recharge_status":"2","recharge_time":"1523866119","status_text":"兑换失败","month":"04月","date_week":"16日/周一","date_time":"16:06:49"},{"id":"11","flow_count":"20MB",
     * "mobile":"155****0627","create_time":"1523598908","recharge_status":"1","recharge_time":"1523599093","status_text":"兑换成功","month":"04月","date_week":"13日/周五","date_time":"13:55:08"},
     * {"id":"10","flow_count":"5MB","mobile":"189****1696","create_time":"1523598698","recharge_status":"2","recharge_time":"1523610022","status_text":"兑换失败","month":"04月","date_week":"13日/周五",
     * "date_time":"13:51:38"},{"id":"9","flow_count":"5MB","mobile":"189****1696","create_time":"1523526005","recharge_status":"2","recharge_time":"0","status_text":"兑换失败","month":"04月",
     * "date_week":"12日/周四","date_time":"17:40:05"},{"id":"6","flow_count":"5MB","mobile":"189****1696","create_time":"1523524654","recharge_status":"2","recharge_time":"0","status_text":"兑换失败",
     * "month":"04月","date_week":"12日/周四","date_time":"17:17:34"}],"page":"1","count":"1"}
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
         * list : [{"id":"16","flow_count":"5MB","mobile":"189****7406","create_time":"1523872234","recharge_status":"2","recharge_time":"1523872346","status_text":"兑换失败","month":"04月",
         * "date_week":"16日/周一","date_time":"17:50:34"},{"id":"15","flow_count":"5MB","mobile":"189****7406","create_time":"1523871364","recharge_status":"2","recharge_time":"1523871505",
         * "status_text":"兑换失败","month":"04月","date_week":"16日/周一","date_time":"17:36:04"},{"id":"14","flow_count":"10MB","mobile":"189****7406","create_time":"1523866780","recharge_status":"2",
         * "recharge_time":"1523866940","status_text":"兑换失败","month":"04月","date_week":"16日/周一","date_time":"16:19:40"},{"id":"13","flow_count":"5MB","mobile":"189****7406",
         * "create_time":"1523866602","recharge_status":"2","recharge_time":"1523866700","status_text":"兑换失败","month":"04月","date_week":"16日/周一","date_time":"16:16:42"},{"id":"12",
         * "flow_count":"5MB","mobile":"189****1696","create_time":"1523866009","recharge_status":"2","recharge_time":"1523866119","status_text":"兑换失败","month":"04月","date_week":"16日/周一",
         * "date_time":"16:06:49"},{"id":"11","flow_count":"20MB","mobile":"155****0627","create_time":"1523598908","recharge_status":"1","recharge_time":"1523599093","status_text":"兑换成功",
         * "month":"04月","date_week":"13日/周五","date_time":"13:55:08"},{"id":"10","flow_count":"5MB","mobile":"189****1696","create_time":"1523598698","recharge_status":"2",
         * "recharge_time":"1523610022","status_text":"兑换失败","month":"04月","date_week":"13日/周五","date_time":"13:51:38"},{"id":"9","flow_count":"5MB","mobile":"189****1696",
         * "create_time":"1523526005","recharge_status":"2","recharge_time":"0","status_text":"兑换失败","month":"04月","date_week":"12日/周四","date_time":"17:40:05"},{"id":"6","flow_count":"5MB",
         * "mobile":"189****1696","create_time":"1523524654","recharge_status":"2","recharge_time":"0","status_text":"兑换失败","month":"04月","date_week":"12日/周四","date_time":"17:17:34"}]
         * page : 1
         * count : 1
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
             * id : 16
             * flow_count : 5MB
             * mobile : 189****7406
             * create_time : 1523872234
             * recharge_status : 2
             * recharge_time : 1523872346
             * status_text : 兑换失败
             * month : 04月
             * date_week : 16日/周一
             * date_time : 17:50:34
             */

            private String id;
            private String flow_count;
            private String mobile;
            private String create_time;
            private String recharge_status;
            private String recharge_time;
            private String status_text;
            private String month;
            private String date_week;
            @SerializedName("date_time")
            private String date_timeX;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getFlow_count() {
                return flow_count;
            }

            public void setFlow_count(String flow_count) {
                this.flow_count = flow_count;
            }

            public String getMobile() {
                return mobile;
            }

            public void setMobile(String mobile) {
                this.mobile = mobile;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getRecharge_status() {
                return recharge_status;
            }

            public void setRecharge_status(String recharge_status) {
                this.recharge_status = recharge_status;
            }

            public String getRecharge_time() {
                return recharge_time;
            }

            public void setRecharge_time(String recharge_time) {
                this.recharge_time = recharge_time;
            }

            public String getStatus_text() {
                return status_text;
            }

            public void setStatus_text(String status_text) {
                this.status_text = status_text;
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
        }
    }
}
