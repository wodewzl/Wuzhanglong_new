package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by ${Wuzhanglong} on 2018/4/2.
 */

public class DailyTaskDetailVO extends BaseVO{

    /**
     * data : {"id":"4","task_name":"每日登陆","task_type":"1","task_icon":"http://qmfq.baonongkang.cn/upload/common/1522316526.jpg","event_id":"1","give_points":"1","do_count":"1",
     * "content":"每日登陆每日登陆每日登陆每日登陆每日登陆每日登陆每日登陆每日登陆每日登陆","type_name":"每日任务","user_do_count":"0"}
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
         * id : 4
         * task_name : 每日登陆
         * task_type : 1
         * task_icon : http://qmfq.baonongkang.cn/upload/common/1522316526.jpg
         * event_id : 1
         * give_points : 1
         * do_count : 1
         * content : 每日登陆每日登陆每日登陆每日登陆每日登陆每日登陆每日登陆每日登陆每日登陆
         * type_name : 每日任务
         * user_do_count : 0
         */

        private String id;
        private String task_name;
        private String task_type;
        private String task_icon;
        private String event_id;
        private String give_points;
        private String do_count;
        private String content;
        private String type_name;
        private String user_do_count;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTask_name() {
            return task_name;
        }

        public void setTask_name(String task_name) {
            this.task_name = task_name;
        }

        public String getTask_type() {
            return task_type;
        }

        public void setTask_type(String task_type) {
            this.task_type = task_type;
        }

        public String getTask_icon() {
            return task_icon;
        }

        public void setTask_icon(String task_icon) {
            this.task_icon = task_icon;
        }

        public String getEvent_id() {
            return event_id;
        }

        public void setEvent_id(String event_id) {
            this.event_id = event_id;
        }

        public String getGive_points() {
            return give_points;
        }

        public void setGive_points(String give_points) {
            this.give_points = give_points;
        }

        public String getDo_count() {
            return do_count;
        }

        public void setDo_count(String do_count) {
            this.do_count = do_count;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getType_name() {
            return type_name;
        }

        public void setType_name(String type_name) {
            this.type_name = type_name;
        }

        public String getUser_do_count() {
            return user_do_count;
        }

        public void setUser_do_count(String user_do_count) {
            this.user_do_count = user_do_count;
        }
    }
}
