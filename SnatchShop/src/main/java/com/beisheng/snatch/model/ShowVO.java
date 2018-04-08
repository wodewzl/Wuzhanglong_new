package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class ShowVO extends BaseVO{

    /**
     * data : {"list":[{"id":"2","nickname":"lhb","avatar":"http://qmfq.baonongkang.cn/upload/avator/1520324232.jpg","status":"1","status_text":"审核成功","content":"中*了，好开心。","imgs":["http://qmfq.baonongkang.cn/upload/comment/20180327/bf9ab70c44abb921de706395b9e5f0a8.jpg"],"likes":"1","comments":"1","shares":"0","adjust_reason":"","latest_pid":"18"}],"page":"1","count":"1"}
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
         * list : [{"id":"2","nickname":"lhb","avatar":"http://qmfq.baonongkang.cn/upload/avator/1520324232.jpg","status":"1","status_text":"审核成功","content":"中*了，好开心。","imgs":["http://qmfq.baonongkang.cn/upload/comment/20180327/bf9ab70c44abb921de706395b9e5f0a8.jpg"],"likes":"1","comments":"1","shares":"0","adjust_reason":"","latest_pid":"18"}]
         * page : 1
         * count : 1
         */

        private String page;
        private String count;
        private List<ListBean> list;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 2
             * nickname : lhb
             * avatar : http://qmfq.baonongkang.cn/upload/avator/1520324232.jpg
             * status : 1
             * status_text : 审核成功
             * content : 中*了，好开心。
             * imgs : ["http://qmfq.baonongkang.cn/upload/comment/20180327/bf9ab70c44abb921de706395b9e5f0a8.jpg"]
             * likes : 1
             * comments : 1
             * shares : 0
             * adjust_reason :
             * latest_pid : 18
             */

            private String id;
            private String nickname;
            private String avatar;
            private String status;
            private String status_text;
            private String content;
            private String likes;
            private String comments;
            private String shares;
            private String adjust_reason;
            private String latest_pid;
            private List<String> imgs;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStatus_text() {
                return status_text;
            }

            public void setStatus_text(String status_text) {
                this.status_text = status_text;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }

            public String getComments() {
                return comments;
            }

            public void setComments(String comments) {
                this.comments = comments;
            }

            public String getShares() {
                return shares;
            }

            public void setShares(String shares) {
                this.shares = shares;
            }

            public String getAdjust_reason() {
                return adjust_reason;
            }

            public void setAdjust_reason(String adjust_reason) {
                this.adjust_reason = adjust_reason;
            }

            public String getLatest_pid() {
                return latest_pid;
            }

            public void setLatest_pid(String latest_pid) {
                this.latest_pid = latest_pid;
            }

            public List<String> getImgs() {
                return imgs;
            }

            public void setImgs(List<String> imgs) {
                this.imgs = imgs;
            }
        }
    }
}
