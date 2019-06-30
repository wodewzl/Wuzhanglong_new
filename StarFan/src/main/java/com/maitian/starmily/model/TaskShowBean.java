package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

public class TaskShowBean extends BaseVO {

    /**
     * obj : {"taskName":"点赞","mily":10,"exp":5}
     */

    private ObjBean obj;

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * taskName : 点赞
         * mily : 10
         * exp : 5
         */

        private String taskName;
        private int mily;
        private int exp;

        public String getTaskName() {
            return taskName;
        }

        public void setTaskName(String taskName) {
            this.taskName = taskName;
        }

        public int getMily() {
            return mily;
        }

        public void setMily(int mily) {
            this.mily = mily;
        }

        public int getExp() {
            return exp;
        }

        public void setExp(int exp) {
            this.exp = exp;
        }
    }
}
