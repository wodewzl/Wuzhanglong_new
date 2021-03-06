package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class AttentionBean extends BaseVO {

    private List<ObjBean> obj;

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }


    public static class ObjBean {
        /**
         * followIcon : 38D2D985-C517-4020-846B-9D65E392F6DC
         * followUserId : 4338
         * createTime : 2019
         * nickname : 舒桐
         * icon : null
         * id : 240096
         * followNickname : 阿杜
         * userName : 舒桐
         * userId : 4341
         * status : 0
         * followUserName : 阿杜
         */

        private String followIcon;
        private int followUserId;
        private long createTime;
        private String nickname;
        private Object icon;
        private int id;
        private String followNickname;
        private String userName;
        private int userId;
        private int status;
        private String followUserName;

        private String idolName;
        private String alias;
        private Object groups;
        private String iconUrl;
        private String backUrl;
        private String info;


        public String getIdolName() {
            return idolName;
        }

        public void setIdolName(String idolName) {
            this.idolName = idolName;
        }

        public String getAlias() {
            return alias;
        }

        public void setAlias(String alias) {
            this.alias = alias;
        }

        public Object getGroups() {
            return groups;
        }

        public void setGroups(Object groups) {
            this.groups = groups;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getBackUrl() {
            return backUrl;
        }

        public void setBackUrl(String backUrl) {
            this.backUrl = backUrl;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getFollowIcon() {
            return followIcon;
        }

        public void setFollowIcon(String followIcon) {
            this.followIcon = followIcon;
        }

        public int getFollowUserId() {
            return followUserId;
        }

        public void setFollowUserId(int followUserId) {
            this.followUserId = followUserId;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getIcon() {
            return icon;
        }

        public void setIcon(Object icon) {
            this.icon = icon;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFollowNickname() {
            return followNickname;
        }

        public void setFollowNickname(String followNickname) {
            this.followNickname = followNickname;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getFollowUserName() {
            return followUserName;
        }

        public void setFollowUserName(String followUserName) {
            this.followUserName = followUserName;
        }
    }
}
