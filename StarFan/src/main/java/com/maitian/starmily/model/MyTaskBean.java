package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class MyTaskBean extends BaseVO {

    /**
     * obj : {"infoStatus":0,"taskList":[{"finishMily":0,"count":0,"updateTime":null,"userId":null,"maxCount":1,"taskType":0,"createTime":null,"taskName":"签到","mily":50,"minCount":1,"id":null,"exp":20,"taskId":null,"taskStatus":0,"status":0},{"finishMily":50,"count":0,"updateTime":null,"userId":null,"maxCount":30,"taskType":0,"createTime":null,"taskName":"点赞","mily":10,"minCount":5,"id":null,"exp":5,"taskId":null,"taskStatus":1,"status":0},{"finishMily":30,"count":0,"updateTime":null,"userId":null,"maxCount":20,"taskType":0,"createTime":null,"taskName":"评论","mily":10,"minCount":3,"id":null,"exp":5,"taskId":null,"taskStatus":1,"status":0},{"finishMily":20,"count":0,"updateTime":null,"userId":null,"maxCount":10,"taskType":0,"createTime":null,"taskName":"转发","mily":10,"minCount":2,"id":null,"exp":10,"taskId":null,"taskStatus":1,"status":0},{"finishMily":0,"count":0,"updateTime":null,"userId":null,"maxCount":0,"taskType":1,"createTime":null,"taskName":"参与话题讨论","mily":1000,"minCount":0,"id":null,"exp":0,"taskId":null,"taskStatus":1,"status":0},{"finishMily":0,"count":0,"updateTime":null,"userId":null,"maxCount":0,"taskType":1,"createTime":null,"taskName":"点击广告链接","mily":1500,"minCount":0,"id":null,"exp":0,"taskId":null,"taskStatus":1,"status":0},{"finishMily":0,"count":0,"updateTime":null,"userId":null,"maxCount":0,"taskType":1,"createTime":null,"taskName":"每日一投","mily":1000,"minCount":0,"id":null,"exp":0,"taskId":null,"taskStatus":1,"status":0}]}
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
         * infoStatus : 0
         * taskList : [{"finishMily":0,"count":0,"updateTime":null,"userId":null,"maxCount":1,"taskType":0,"createTime":null,"taskName":"签到","mily":50,"minCount":1,"id":null,"exp":20,"taskId":null,"taskStatus":0,"status":0},{"finishMily":50,"count":0,"updateTime":null,"userId":null,"maxCount":30,"taskType":0,"createTime":null,"taskName":"点赞","mily":10,"minCount":5,"id":null,"exp":5,"taskId":null,"taskStatus":1,"status":0},{"finishMily":30,"count":0,"updateTime":null,"userId":null,"maxCount":20,"taskType":0,"createTime":null,"taskName":"评论","mily":10,"minCount":3,"id":null,"exp":5,"taskId":null,"taskStatus":1,"status":0},{"finishMily":20,"count":0,"updateTime":null,"userId":null,"maxCount":10,"taskType":0,"createTime":null,"taskName":"转发","mily":10,"minCount":2,"id":null,"exp":10,"taskId":null,"taskStatus":1,"status":0},{"finishMily":0,"count":0,"updateTime":null,"userId":null,"maxCount":0,"taskType":1,"createTime":null,"taskName":"参与话题讨论","mily":1000,"minCount":0,"id":null,"exp":0,"taskId":null,"taskStatus":1,"status":0},{"finishMily":0,"count":0,"updateTime":null,"userId":null,"maxCount":0,"taskType":1,"createTime":null,"taskName":"点击广告链接","mily":1500,"minCount":0,"id":null,"exp":0,"taskId":null,"taskStatus":1,"status":0},{"finishMily":0,"count":0,"updateTime":null,"userId":null,"maxCount":0,"taskType":1,"createTime":null,"taskName":"每日一投","mily":1000,"minCount":0,"id":null,"exp":0,"taskId":null,"taskStatus":1,"status":0}]
         */

        private int infoStatus;
        private List<TaskListBean> taskList;

        public int getInfoStatus() {
            return infoStatus;
        }

        public void setInfoStatus(int infoStatus) {
            this.infoStatus = infoStatus;
        }

        public List<TaskListBean> getTaskList() {
            return taskList;
        }

        public void setTaskList(List<TaskListBean> taskList) {
            this.taskList = taskList;
        }

        public static class TaskListBean {
            /**
             * finishMily : 0
             * count : 0
             * updateTime : null
             * userId : null
             * maxCount : 1
             * taskType : 0
             * createTime : null
             * taskName : 签到
             * mily : 50
             * minCount : 1
             * id : null
             * exp : 20
             * taskId : null
             * taskStatus : 0
             * status : 0
             */

            private int finishMily;
            private int count;
            private Object updateTime;
            private Object userId;
            private int maxCount;
            private int taskType;
            private Object createTime;
            private String taskName;
            private int mily;
            private int minCount;
            private Object id;
            private int exp;
            private Object taskId;
            private int taskStatus;
            private int status;

            public int getFinishMily() {
                return finishMily;
            }

            public void setFinishMily(int finishMily) {
                this.finishMily = finishMily;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getUserId() {
                return userId;
            }

            public void setUserId(Object userId) {
                this.userId = userId;
            }

            public int getMaxCount() {
                return maxCount;
            }

            public void setMaxCount(int maxCount) {
                this.maxCount = maxCount;
            }

            public int getTaskType() {
                return taskType;
            }

            public void setTaskType(int taskType) {
                this.taskType = taskType;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

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

            public int getMinCount() {
                return minCount;
            }

            public void setMinCount(int minCount) {
                this.minCount = minCount;
            }

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public int getExp() {
                return exp;
            }

            public void setExp(int exp) {
                this.exp = exp;
            }

            public Object getTaskId() {
                return taskId;
            }

            public void setTaskId(Object taskId) {
                this.taskId = taskId;
            }

            public int getTaskStatus() {
                return taskStatus;
            }

            public void setTaskStatus(int taskStatus) {
                this.taskStatus = taskStatus;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
