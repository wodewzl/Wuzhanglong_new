package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/18.
 */

public class NumberTrendVO extends BaseVO{

    /**
     * data : {"list":[{"pf_no":"5312396306","buy_period":"4","buy_count":"5439","prise_code":"1003690","remain_count":"1910","is_fq":"1"},{"pf_no":"2014980203","buy_period":"4","buy_count":"5570",
     * "prise_code":"1003872","remain_count":"1728","is_fq":"1"}]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * pf_no : 5312396306
             * buy_period : 4
             * buy_count : 5439
             * prise_code : 1003690
             * remain_count : 1910
             * is_fq : 1
             */

            private String pf_no;
            private String buy_period;
            private String buy_count;
            private String prise_code;
            private String remain_count;
            private String is_fq;

            public String getPf_no() {
                return pf_no;
            }

            public void setPf_no(String pf_no) {
                this.pf_no = pf_no;
            }

            public String getBuy_period() {
                return buy_period;
            }

            public void setBuy_period(String buy_period) {
                this.buy_period = buy_period;
            }

            public String getBuy_count() {
                return buy_count;
            }

            public void setBuy_count(String buy_count) {
                this.buy_count = buy_count;
            }

            public String getPrise_code() {
                return prise_code;
            }

            public void setPrise_code(String prise_code) {
                this.prise_code = prise_code;
            }

            public String getRemain_count() {
                return remain_count;
            }

            public void setRemain_count(String remain_count) {
                this.remain_count = remain_count;
            }

            public String getIs_fq() {
                return is_fq;
            }

            public void setIs_fq(String is_fq) {
                this.is_fq = is_fq;
            }
        }
    }
}
