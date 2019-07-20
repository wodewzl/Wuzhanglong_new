package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by ${Wuzhanglong} on 2019/7/20.
 */
public class UpdateBean extends BaseVO {

    /**
     * obj : {"updateStatus":true,"finalVersion":{"id":10001,"versionId":"1.0.0","type":0,"versionUrl":"http://img.starmily.com/12","createTime":1561899368000,"forceToUpdate":0,
     * "contentDesc":"苹果升级","delFlag":0}}
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
         * updateStatus : true
         * finalVersion : {"id":10001,"versionId":"1.0.0","type":0,"versionUrl":"http://img.starmily.com/12","createTime":1561899368000,"forceToUpdate":0,"contentDesc":"苹果升级","delFlag":0}
         */

        private boolean updateStatus;
        private FinalVersionBean finalVersion;

        public boolean isUpdateStatus() {
            return updateStatus;
        }

        public void setUpdateStatus(boolean updateStatus) {
            this.updateStatus = updateStatus;
        }

        public FinalVersionBean getFinalVersion() {
            return finalVersion;
        }

        public void setFinalVersion(FinalVersionBean finalVersion) {
            this.finalVersion = finalVersion;
        }

        public static class FinalVersionBean {
            /**
             * id : 10001
             * versionId : 1.0.0
             * type : 0
             * versionUrl : http://img.starmily.com/12
             * createTime : 1561899368000
             * forceToUpdate : 0
             * contentDesc : 苹果升级
             * delFlag : 0
             */

            private int id;
            private String versionId;
            private int type;
            private String versionUrl;
            private long createTime;
            private int forceToUpdate;
            private String contentDesc;
            private int delFlag;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getVersionId() {
                return versionId;
            }

            public void setVersionId(String versionId) {
                this.versionId = versionId;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getVersionUrl() {
                return versionUrl;
            }

            public void setVersionUrl(String versionUrl) {
                this.versionUrl = versionUrl;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getForceToUpdate() {
                return forceToUpdate;
            }

            public void setForceToUpdate(int forceToUpdate) {
                this.forceToUpdate = forceToUpdate;
            }

            public String getContentDesc() {
                return contentDesc;
            }

            public void setContentDesc(String contentDesc) {
                this.contentDesc = contentDesc;
            }

            public int getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(int delFlag) {
                this.delFlag = delFlag;
            }
        }
    }
}
