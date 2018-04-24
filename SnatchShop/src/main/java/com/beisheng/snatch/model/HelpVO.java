package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by ${Wuzhanglong} on 2018/4/24.
 */

public class HelpVO extends BaseVO{

    /**
     * data : {"qq_group_no":"324058021","service_tel":"027-00000000"}
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
         * qq_group_no : 324058021
         * service_tel : 027-00000000
         */

        private String qq_group_no;
        private String service_tel;

        public String getQq_group_no() {
            return qq_group_no;
        }

        public void setQq_group_no(String qq_group_no) {
            this.qq_group_no = qq_group_no;
        }

        public String getService_tel() {
            return service_tel;
        }

        public void setService_tel(String service_tel) {
            this.service_tel = service_tel;
        }
    }
}
