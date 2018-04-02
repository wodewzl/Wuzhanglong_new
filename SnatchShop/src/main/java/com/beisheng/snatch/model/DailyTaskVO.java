package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/2.
 */

public class DailyTaskVO extends BaseVO{

    /**
     * data : {"list":[{"id":"4","task_icon":"http://qmfq.baonongkang.cn/upload/common/1522316526.jpg","task_name":"每日登陆","do_count":"1","give_points":"1","type_name":"每日任务","user_do_count":"0"},
     * {"id":"2","task_icon":"http://qmfq.baonongkang.cn/upload/common/1522308784.png","task_name":"疯抢进行时","do_count":"1","give_points":"10","type_name":"每日任务","user_do_count":"0"},{"id":"8",
     * "task_icon":"http://qmfq.baonongkang.cn/upload/common/1522322458.png","task_name":"邀请好友","do_count":"1","give_points":"1","type_name":"每日任务","user_do_count":"0"},{"id":"3",
     * "task_icon":"http://qmfq.baonongkang.cn/upload/common/1522308842.jpg","task_name":"注册用户","do_count":"1","give_points":"1","type_name":"新手任务","user_do_count":"0"},{"id":"5",
     * "task_icon":"http://qmfq.baonongkang.cn/upload/common/1522316562.jpg","task_name":"初次登陆","do_count":"1","give_points":"1","type_name":"新手任务","user_do_count":"1"},{"id":"7",
     * "task_icon":"http://qmfq.baonongkang.cn/upload/common/1522320622.png","task_name":"初次抢购","do_count":"1","give_points":"1","type_name":"新手任务","user_do_count":"1"}]}
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
             * id : 4
             * task_icon : http://qmfq.baonongkang.cn/upload/common/1522316526.jpg
             * task_name : 每日登陆
             * do_count : 1
             * give_points : 1
             * type_name : 每日任务
             * user_do_count : 0
             */

            private String id;
            private String task_icon;
            private String task_name;
            private String do_count;
            private String give_points;
            private String type_name;
            private String user_do_count;
            private String type;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTask_icon() {
                return task_icon;
            }

            public void setTask_icon(String task_icon) {
                this.task_icon = task_icon;
            }

            public String getTask_name() {
                return task_name;
            }

            public void setTask_name(String task_name) {
                this.task_name = task_name;
            }

            public String getDo_count() {
                return do_count;
            }

            public void setDo_count(String do_count) {
                this.do_count = do_count;
            }

            public String getGive_points() {
                return give_points;
            }

            public void setGive_points(String give_points) {
                this.give_points = give_points;
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
}
