package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by ${Wuzhanglong} on 2018/5/1.
 */

public class CardPasswordVO extends BaseVO{

    /**
     * data : {"virtual_code":"20470850e7021a10","status_text":"已使用","status":"2"}
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
         * virtual_code : 20470850e7021a10
         * status_text : 已使用
         * status : 2
         */

        private String virtual_code;
        private String status_text;
        private String status;

        public String getVirtual_code() {
            return virtual_code;
        }

        public void setVirtual_code(String virtual_code) {
            this.virtual_code = virtual_code;
        }

        public String getStatus_text() {
            return status_text;
        }

        public void setStatus_text(String status_text) {
            this.status_text = status_text;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
