package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class FindTopicVO extends BaseVO {

    /**
     * obj : {"pageNum":1,"pageSize":10,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"id":1,"createTime":1561015262000,"updateTime":1561566572000,"delFlag":0,"type":2,"linkAddress":"","newsId":3835,"eventTitle":"星米粒话题","qiNiuAddress":"http://img.starmily.com/99f91ffb-bca9-45a1-9933-eba69b8c54f0","createUserId":null,"updateUserId":null}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
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
         * list : [{"id":1,"createTime":1561015262000,"updateTime":1561566572000,"delFlag":0,"type":2,"linkAddress":"","newsId":3835,"eventTitle":"星米粒话题","qiNiuAddress":"http://img.starmily.com/99f91ffb-bca9-45a1-9933-eba69b8c54f0","createUserId":null,"updateUserId":null}]
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
             * id : 1
             * createTime : 1561015262000
             * updateTime : 1561566572000
             * delFlag : 0
             * type : 2
             * linkAddress :
             * newsId : 3835
             * eventTitle : 星米粒话题
             * qiNiuAddress : http://img.starmily.com/99f91ffb-bca9-45a1-9933-eba69b8c54f0
             * createUserId : null
             * updateUserId : null
             */

            private int id;
            private long createTime;
            private long updateTime;
            private int delFlag;
            private int type;
            private String linkAddress;
            private int newsId;
            private String eventTitle;
            private String qiNiuAddress;
            private Object createUserId;
            private Object updateUserId;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public String getQiNiuAddress() {
                return qiNiuAddress;
            }

            public void setQiNiuAddress(String qiNiuAddress) {
                this.qiNiuAddress = qiNiuAddress;
            }

            public Object getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(Object createUserId) {
                this.createUserId = createUserId;
            }

            public Object getUpdateUserId() {
                return updateUserId;
            }

            public void setUpdateUserId(Object updateUserId) {
                this.updateUserId = updateUserId;
            }
        }
    }
}
