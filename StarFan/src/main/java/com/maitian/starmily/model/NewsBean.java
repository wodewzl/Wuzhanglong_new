package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class NewsBean extends BaseVO {

    /**
     * obj : {"pageNum":1,"pageSize":10,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"adImg":null,"count":424,"likeCount":3,"title":"星米粒团队test","hot":0,"userName":"大攀","userId":4337,"newsId":3835,"top":1,"createTime":1557106887000,"nickname":"大攀","commentReplyCount":14,"iconUrl":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","status":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
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
         * size : 1
         * orderBy : null
         * startRow : 1
         * endRow : 1
         * total : 1
         * pages : 1
         * list : [{"adImg":null,"count":424,"likeCount":3,"title":"星米粒团队test","hot":0,"userName":"大攀","userId":4337,"newsId":3835,"top":1,"createTime":1557106887000,"nickname":"大攀","commentReplyCount":14,"iconUrl":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","status":0}]
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
             * adImg : null
             * count : 424
             * likeCount : 3
             * title : 星米粒团队test
             * hot : 0
             * userName : 大攀
             * userId : 4337
             * newsId : 3835
             * top : 1
             * createTime : 1557106887000
             * nickname : 大攀
             * commentReplyCount : 14
             * iconUrl : http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif
             * status : 0
             */

            private String adImg;
            private int count;
            private int likeCount;
            private String title;
            private int hot;
            private String userName;
            private int userId;
            private int newsId;
            private int top;
            private long createTime;
            private String nickname;
            private int commentReplyCount;
            private String iconUrl;
            private int status;

            public String getAdImg() {
                return adImg;
            }

            public void setAdImg(String adImg) {
                this.adImg = adImg;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getHot() {
                return hot;
            }

            public void setHot(int hot) {
                this.hot = hot;
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

            public int getNewsId() {
                return newsId;
            }

            public void setNewsId(int newsId) {
                this.newsId = newsId;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
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

            public int getCommentReplyCount() {
                return commentReplyCount;
            }

            public void setCommentReplyCount(int commentReplyCount) {
                this.commentReplyCount = commentReplyCount;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
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
