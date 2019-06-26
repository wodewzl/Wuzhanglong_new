package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class TurnsPicturesBean extends BaseVO {

    private List<ObjBean> obj;

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean {
        /**
         * id : 1
         * linkType : INSIDE
         * linkAddress : sdfsdfsd
         * qiNiuAddress : 1F8D3A35-CB9D-4E4D-BC1E-61103F68BA55
         * sort : 1
         * description : sds真的VS的发射点
         * isShow : 1
         * startDate : 1536422400000
         * endDate : 1567958400000
         * createTime : 1536422400000
         * updateTime : 1536422400000
         * createUserId : 1
         * updateUserId : 1
         * delFlag : 1
         */

        private String id;
        private String linkType;
        private String linkAddress;
        private String qiNiuAddress;
        private int sort;
        private String description;
        private int isShow;
        private long startDate;
        private long endDate;
        private long createTime;
        private long updateTime;
        private String createUserId;
        private String updateUserId;
        private int delFlag;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLinkType() {
            return linkType;
        }

        public void setLinkType(String linkType) {
            this.linkType = linkType;
        }

        public String getLinkAddress() {
            return linkAddress;
        }

        public void setLinkAddress(String linkAddress) {
            this.linkAddress = linkAddress;
        }

        public String getQiNiuAddress() {
            return qiNiuAddress;
        }

        public void setQiNiuAddress(String qiNiuAddress) {
            this.qiNiuAddress = qiNiuAddress;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getIsShow() {
            return isShow;
        }

        public void setIsShow(int isShow) {
            this.isShow = isShow;
        }

        public long getStartDate() {
            return startDate;
        }

        public void setStartDate(long startDate) {
            this.startDate = startDate;
        }

        public long getEndDate() {
            return endDate;
        }

        public void setEndDate(long endDate) {
            this.endDate = endDate;
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

        public String getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(String createUserId) {
            this.createUserId = createUserId;
        }

        public String getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(String updateUserId) {
            this.updateUserId = updateUserId;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }
    }
}
