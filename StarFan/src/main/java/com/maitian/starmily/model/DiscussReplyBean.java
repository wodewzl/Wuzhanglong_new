package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class DiscussReplyBean extends BaseVO {

    /**
     * obj : {"pageNum":1,"pageSize":10,"size":3,"orderBy":null,"startRow":1,"endRow":3,"total":3,"pages":1,"list":[{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4337,"fromIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"大攀","replyMsg":"234","fromNickname":"大攀","createTime":1558284060000,"replyId":30,"commentId":35,"toUserName":"阿杜"},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557732294000,"replyId":31,"commentId":35,"toUserName":"大攀"},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557158476000,"replyId":29,"commentId":35,"toUserName":"大攀"}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
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
         * pageNum : 1
         * pageSize : 10
         * size : 3
         * orderBy : null
         * startRow : 1
         * endRow : 3
         * total : 3
         * pages : 1
         * list : [{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4337,"fromIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"大攀","replyMsg":"234","fromNickname":"大攀","createTime":1558284060000,"replyId":30,"commentId":35,"toUserName":"阿杜"},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557732294000,"replyId":31,"commentId":35,"toUserName":"大攀"},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557158476000,"replyId":29,"commentId":35,"toUserName":"大攀"}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 0
         * lastPage : 1
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         */

        private int pageNum;
        private int pageSize;
        private int size;
        private Object orderBy;
        private int startRow;
        private int endRow;
        private int total;
        private int pages;
        private int firstPage;
        private int prePage;
        private int nextPage;
        private int lastPage;
        private boolean isFirstPage;
        private boolean isLastPage;
        private boolean hasPreviousPage;
        private boolean hasNextPage;
        private int navigatePages;
        private List<ListBean> list;
        private List<Integer> navigatepageNums;

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public Object getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(Object orderBy) {
            this.orderBy = orderBy;
        }

        public int getStartRow() {
            return startRow;
        }

        public void setStartRow(int startRow) {
            this.startRow = startRow;
        }

        public int getEndRow() {
            return endRow;
        }

        public void setEndRow(int endRow) {
            this.endRow = endRow;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getPages() {
            return pages;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public int getFirstPage() {
            return firstPage;
        }

        public void setFirstPage(int firstPage) {
            this.firstPage = firstPage;
        }

        public int getPrePage() {
            return prePage;
        }

        public void setPrePage(int prePage) {
            this.prePage = prePage;
        }

        public int getNextPage() {
            return nextPage;
        }

        public void setNextPage(int nextPage) {
            this.nextPage = nextPage;
        }

        public int getLastPage() {
            return lastPage;
        }

        public void setLastPage(int lastPage) {
            this.lastPage = lastPage;
        }

        public boolean isIsFirstPage() {
            return isFirstPage;
        }

        public void setIsFirstPage(boolean isFirstPage) {
            this.isFirstPage = isFirstPage;
        }

        public boolean isIsLastPage() {
            return isLastPage;
        }

        public void setIsLastPage(boolean isLastPage) {
            this.isLastPage = isLastPage;
        }

        public boolean isHasPreviousPage() {
            return hasPreviousPage;
        }

        public void setHasPreviousPage(boolean hasPreviousPage) {
            this.hasPreviousPage = hasPreviousPage;
        }

        public boolean isHasNextPage() {
            return hasNextPage;
        }

        public void setHasNextPage(boolean hasNextPage) {
            this.hasNextPage = hasNextPage;
        }

        public int getNavigatePages() {
            return navigatePages;
        }

        public void setNavigatePages(int navigatePages) {
            this.navigatePages = navigatePages;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBean {
            /**
             * toIcon : 38D2D985-C517-4020-846B-9D65E392F6DC
             * fromUserId : 4337
             * fromIcon : http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif
             * likeCount : 0
             * toUserId : 4338
             * toNickname : 阿杜
             * fromUserName : 大攀
             * replyMsg : 234
             * fromNickname : 大攀
             * createTime : 1558284060000
             * replyId : 30
             * commentId : 35
             * toUserName : 阿杜
             */

            private String toIcon;
            private int fromUserId;
            private String fromIcon;
            private int likeCount;
            private int toUserId;
            private String toNickname;
            private String fromUserName;
            private String replyMsg;
            private String fromNickname;
            private long createTime;
            private int replyId;
            private int commentId;
            private String toUserName;

            public String getToIcon() {
                return toIcon;
            }

            public void setToIcon(String toIcon) {
                this.toIcon = toIcon;
            }

            public int getFromUserId() {
                return fromUserId;
            }

            public void setFromUserId(int fromUserId) {
                this.fromUserId = fromUserId;
            }

            public String getFromIcon() {
                return fromIcon;
            }

            public void setFromIcon(String fromIcon) {
                this.fromIcon = fromIcon;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public int getToUserId() {
                return toUserId;
            }

            public void setToUserId(int toUserId) {
                this.toUserId = toUserId;
            }

            public String getToNickname() {
                return toNickname;
            }

            public void setToNickname(String toNickname) {
                this.toNickname = toNickname;
            }

            public String getFromUserName() {
                return fromUserName;
            }

            public void setFromUserName(String fromUserName) {
                this.fromUserName = fromUserName;
            }

            public String getReplyMsg() {
                return replyMsg;
            }

            public void setReplyMsg(String replyMsg) {
                this.replyMsg = replyMsg;
            }

            public String getFromNickname() {
                return fromNickname;
            }

            public void setFromNickname(String fromNickname) {
                this.fromNickname = fromNickname;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public int getReplyId() {
                return replyId;
            }

            public void setReplyId(int replyId) {
                this.replyId = replyId;
            }

            public int getCommentId() {
                return commentId;
            }

            public void setCommentId(int commentId) {
                this.commentId = commentId;
            }

            public String getToUserName() {
                return toUserName;
            }

            public void setToUserName(String toUserName) {
                this.toUserName = toUserName;
            }
        }
    }
}
