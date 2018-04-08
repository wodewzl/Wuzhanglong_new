package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

public class NameConfirmVO extends BaseVO{

    /**
     * data : {"real_name":"吴**","id_card":"420683******3117"}
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
         * real_name : 吴**
         * id_card : 420683******3117
         */

        private String real_name;
        private String id_card;

        public String getReal_name() {
            return real_name;
        }

        public void setReal_name(String real_name) {
            this.real_name = real_name;
        }

        public String getId_card() {
            return id_card;
        }

        public void setId_card(String id_card) {
            this.id_card = id_card;
        }
    }
}
