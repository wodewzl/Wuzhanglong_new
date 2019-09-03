package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by ${Wuzhanglong} on 2019/7/20.
 */
public class AdBean extends BaseVO {

    /**
     * obj : {"id":10001,"type":0,"linkAddress":"http://www.baidu.com","description":"1212121212","isShow":"1","onlineTime":1536422400000,"offlineTime":1567958400000,"createTime":1559664000000,
     * "updateTime":1561219200000,"delFlag":0,"qiNiuAddress":"http://img.starmily.com/20e2bffe-aec5-4259-b40c-1f92da44f4be","newsId":33}
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
         * id : 10001
         * type : 0
         * linkAddress : http://www.baidu.com
         * description : 1212121212
         * isShow : 1
         * onlineTime : 1536422400000
         * offlineTime : 1567958400000
         * createTime : 1559664000000
         * updateTime : 1561219200000
         * delFlag : 0
         * qiNiuAddress : http://img.starmily.com/20e2bffe-aec5-4259-b40c-1f92da44f4be
         * newsId : 33
         */

        private int id;
        private int type;
        private String linkAddress;
        private String description;
        private String isShow;
        private long onlineTime;
        private long offlineTime;
        private long createTime;
        private long updateTime;
        private int delFlag;
        private String qiNiuAddress;
        private int newsId;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getLinkAddress() {
            return linkAddress;
        }

        public void setLinkAddress(String linkAddress) {
            this.linkAddress = linkAddress;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIsShow() {
            return isShow;
        }

        public void setIsShow(String isShow) {
            this.isShow = isShow;
        }

        public long getOnlineTime() {
            return onlineTime;
        }

        public void setOnlineTime(long onlineTime) {
            this.onlineTime = onlineTime;
        }

        public long getOfflineTime() {
            return offlineTime;
        }

        public void setOfflineTime(long offlineTime) {
            this.offlineTime = offlineTime;
        }

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public String getQiNiuAddress() {
            return qiNiuAddress;
        }

        public void setQiNiuAddress(String qiNiuAddress) {
            this.qiNiuAddress = qiNiuAddress;
        }

        public int getNewsId() {
            return newsId;
        }

        public void setNewsId(int newsId) {
            this.newsId = newsId;
        }
    }
}
