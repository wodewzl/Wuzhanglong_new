package com.wzl.txffc;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/12/24.
 */

public class UserInfoVO extends BaseVO implements Serializable {

    /**
     * row : 1
     * code : txffc
     * data : [{"opentime":"2019-03-05 10:50:00","expect":"201903050650","opencode":"4,3,5,8,9"}]
     */

    private int row;

    private List<DataBean> data;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }


    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * opentime : 2019-03-05 10:50:00
         * expect : 201903050650
         * opencode : 4,3,5,8,9
         */

        private String opentime;
        private String expect;
        private String opencode;

        public String getOpentime() {
            return opentime;
        }

        public void setOpentime(String opentime) {
            this.opentime = opentime;
        }

        public String getExpect() {
            return expect;
        }

        public void setExpect(String expect) {
            this.expect = expect;
        }

        public String getOpencode() {
            return opencode;
        }

        public void setOpencode(String opencode) {
            this.opencode = opencode;
        }
    }
}
