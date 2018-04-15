package com.beisheng.snatch.model;

import com.google.gson.annotations.SerializedName;
import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/15.
 */

public class RechargeRecordVO extends BaseVO{

    /**
     * data : {"list":[{"id":"198","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"14日/周六","date_time":"20:39:47","give_number":"+20次"},{"id":"193",
     * "recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"14日/周六","date_time":"20:06:46","give_number":"+20次"},{"id":"191","recharge_money":"20.00元","give_flux":"+0.20M",
     * "month":"04月","date_week":"14日/周六","date_time":"20:02:20","give_number":"+20次"},{"id":"183","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"14日/周六",
     * "date_time":"19:11:03","give_number":"+20次"},{"id":"182","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"14日/周六","date_time":"19:08:35","give_number":"+20次"},
     * {"id":"177","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"14日/周六","date_time":"18:39:27","give_number":"+20次"},{"id":"172","recharge_money":"30.00元",
     * "give_flux":"+0.20M","month":"04月","date_week":"14日/周六","date_time":"15:54:30","give_number":"+30次"},{"id":"164","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月",
     * "date_week":"13日/周五","date_time":"16:21:09","give_number":"+20次"},{"id":"163","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"13日/周五","date_time":"16:19:46",
     * "give_number":"+20次"},{"id":"155","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"13日/周五","date_time":"15:52:26","give_number":"+20次"}],"page":"1","count":"2"}
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
         * list : [{"id":"198","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"14日/周六","date_time":"20:39:47","give_number":"+20次"},{"id":"193","recharge_money":"20.00元",
         * "give_flux":"+0.20M","month":"04月","date_week":"14日/周六","date_time":"20:06:46","give_number":"+20次"},{"id":"191","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月",
         * "date_week":"14日/周六","date_time":"20:02:20","give_number":"+20次"},{"id":"183","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"14日/周六","date_time":"19:11:03",
         * "give_number":"+20次"},{"id":"182","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"14日/周六","date_time":"19:08:35","give_number":"+20次"},{"id":"177",
         * "recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"14日/周六","date_time":"18:39:27","give_number":"+20次"},{"id":"172","recharge_money":"30.00元","give_flux":"+0.20M",
         * "month":"04月","date_week":"14日/周六","date_time":"15:54:30","give_number":"+30次"},{"id":"164","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"13日/周五",
         * "date_time":"16:21:09","give_number":"+20次"},{"id":"163","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"13日/周五","date_time":"16:19:46","give_number":"+20次"},
         * {"id":"155","recharge_money":"20.00元","give_flux":"+0.20M","month":"04月","date_week":"13日/周五","date_time":"15:52:26","give_number":"+20次"}]
         * page : 1
         * count : 2
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
             * id : 198
             * recharge_money : 20.00元
             * give_flux : +0.20M
             * month : 04月
             * date_week : 14日/周六
             * date_time : 20:39:47
             * give_number : +20次
             */

            private String id;
            private String recharge_money;
            private String give_flux;
            private String month;
            private String date_week;
            @SerializedName("date_time")
            private String date_timeX;
            private String give_number;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getRecharge_money() {
                return recharge_money;
            }

            public void setRecharge_money(String recharge_money) {
                this.recharge_money = recharge_money;
            }

            public String getGive_flux() {
                return give_flux;
            }

            public void setGive_flux(String give_flux) {
                this.give_flux = give_flux;
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

            public String getGive_number() {
                return give_number;
            }

            public void setGive_number(String give_number) {
                this.give_number = give_number;
            }
        }
    }
}
