package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class FindBean extends BaseVO {

    /**
     * obj : {"pageNum":1,"pageSize":10,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":2,"pages":1,"list":[{"newsId":3835,"adImg":"4B739B8D-F24E-42E9-BFF4-C38BCB45896F","createTime":1558802938000,"responseParam":"{\"newsId\":3835}","id":3837,"title":"星米粒团队test","type":1,"status":0,"url":"https://mp.weixin.qq.com/s/lC72vZxN4jGqkzcLf4j6tw"},{"adImg":"B4176CD4-4DAF-4B9E-8938-0746B9730909","createTime":1558803131000,"responseParam":"{\"url\":\"https://mp.weixin.qq.com/s/lC72vZxN4jGqkzcLf4j6tw\"}","id":3838,"title":"星米粒外部地址","type":0,"url":"https://mp.weixin.qq.com/s/lC72vZxN4jGqkzcLf4j6tw","status":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
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
         * size : 2
         * orderBy : null
         * startRow : 1
         * endRow : 2
         * total : 2
         * pages : 1
         * list : [{"newsId":3835,"adImg":"4B739B8D-F24E-42E9-BFF4-C38BCB45896F","createTime":1558802938000,"responseParam":"{\"newsId\":3835}","id":3837,"title":"星米粒团队test","type":1,"status":0},{"adImg":"B4176CD4-4DAF-4B9E-8938-0746B9730909","createTime":1558803131000,"responseParam":"{\"url\":\"https://mp.weixin.qq.com/s/lC72vZxN4jGqkzcLf4j6tw\"}","id":3838,"title":"星米粒外部地址","type":0,"url":"https://mp.weixin.qq.com/s/lC72vZxN4jGqkzcLf4j6tw","status":0}]
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
             * newsId : 3835
             * adImg : 4B739B8D-F24E-42E9-BFF4-C38BCB45896F
             * createTime : 1558802938000
             * responseParam : {"newsId":3835}
             * id : 3837
             * title : 星米粒团队test
             * type : 1
             * status : 0
             * url : https://mp.weixin.qq.com/s/lC72vZxN4jGqkzcLf4j6tw
             */

            private int newsId;
            private String adImg;
            private long createTime;
            private String responseParam;
            private int id;
            private String title;
            private int type;
            private int status;
            private String url;

            public int getNewsId() {
                return newsId;
            }

            public void setNewsId(int newsId) {
                this.newsId = newsId;
            }

            public String getAdImg() {
                return adImg;
            }

            public void setAdImg(String adImg) {
                this.adImg = adImg;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getResponseParam() {
                return responseParam;
            }

            public void setResponseParam(String responseParam) {
                this.responseParam = responseParam;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
