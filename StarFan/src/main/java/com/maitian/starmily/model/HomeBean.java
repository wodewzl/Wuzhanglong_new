package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class HomeBean extends BaseVO {

    /**
     * obj : {"pageNum":1,"pageSize":10,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"count":null,"updateTime":1561566554000,"linkAddress":"http://www.baidu.com","likeCount":null,"delFlag":0,"type":2,"picturesAddress":"http://img.starmily.com/fe27b69e-b831-45fb-bbb2-da46f66930eb","newsId":111,"eventTitle":"北京天气预报","createTime":1559999075000,"commentReplyCount":null,"onlineTime":1560002163000,"offlineTime":1560024305000,"id":1}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
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
         * list : [{"count":null,"updateTime":1561566554000,"linkAddress":"http://www.baidu.com","likeCount":null,"delFlag":0,"type":2,"picturesAddress":"http://img.starmily.com/fe27b69e-b831-45fb-bbb2-da46f66930eb","newsId":111,"eventTitle":"北京天气预报","createTime":1559999075000,"commentReplyCount":null,"onlineTime":1560002163000,"offlineTime":1560024305000,"id":1}]
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
             * count : null
             * updateTime : 1561566554000
             * linkAddress : http://www.baidu.com
             * likeCount : null
             * delFlag : 0
             * type : 2
             * picturesAddress : http://img.starmily.com/fe27b69e-b831-45fb-bbb2-da46f66930eb
             * newsId : 111
             * eventTitle : 北京天气预报
             * createTime : 1559999075000
             * commentReplyCount : null
             * onlineTime : 1560002163000
             * offlineTime : 1560024305000
             * id : 1
             */

            private Object count;
            private long updateTime;
            private String linkAddress;
            private Object likeCount;
            private int delFlag;
            private int type;
            private String picturesAddress;
            private int newsId;
            private String eventTitle;
            private long createTime;
            private Object commentReplyCount;
            private long onlineTime;
            private long offlineTime;
            private int id;

            public Object getCount() {
                return count;
            }

            public void setCount(Object count) {
                this.count = count;
            }

            public long getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(long updateTime) {
                this.updateTime = updateTime;
            }

            public String getLinkAddress() {
                return linkAddress;
            }

            public void setLinkAddress(String linkAddress) {
                this.linkAddress = linkAddress;
            }

            public Object getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(Object likeCount) {
                this.likeCount = likeCount;
            }

            public int getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(int delFlag) {
                this.delFlag = delFlag;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getPicturesAddress() {
                return picturesAddress;
            }

            public void setPicturesAddress(String picturesAddress) {
                this.picturesAddress = picturesAddress;
            }

            public int getNewsId() {
                return newsId;
            }

            public void setNewsId(int newsId) {
                this.newsId = newsId;
            }

            public String getEventTitle() {
                return eventTitle;
            }

            public void setEventTitle(String eventTitle) {
                this.eventTitle = eventTitle;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public Object getCommentReplyCount() {
                return commentReplyCount;
            }

            public void setCommentReplyCount(Object commentReplyCount) {
                this.commentReplyCount = commentReplyCount;
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

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }
        }
    }
}
