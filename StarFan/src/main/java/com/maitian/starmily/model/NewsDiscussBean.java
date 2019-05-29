package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class NewsDiscussBean extends BaseVO {


    /**
     * obj : {"pageNum":1,"pageSize":10,"size":7,"orderBy":"a.like_count DESC,a.create_time DESC","startRow":1,"endRow":7,"total":7,"pages":1,"list":[{"icon_url":"38D2D985-C517-4020-846B-9D65E392F6DC","newsId":3835,"replyMsg":"完美","createTime":1558286601000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":6,"pages":3,"list":[{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"再测试下下","fromNickname":"星米粒","createTime":1558452837000,"replyId":42,"commentId":45,"toUserName":"阿杜","likeStatus":0},{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"我的天","fromNickname":"星米粒","createTime":1558452732000,"replyId":41,"commentId":45,"toUserName":"阿杜","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"阿杜","commentId":45,"likeCount":0,"likeStatus":0,"userName":"阿杜","userId":4338},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"就是说","createTime":1557916025000,"commentReply":null,"nickname":"星米粒","commentId":44,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"光谷","createTime":1557915834000,"commentReply":null,"nickname":"星米粒","commentId":43,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"痛恨","createTime":1557915678000,"commentReply":null,"nickname":"星米粒","commentId":42,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"哈哈哈有点想","createTime":1557915359000,"commentReply":null,"nickname":"星米粒","commentId":37,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","newsId":3835,"replyMsg":"123","createTime":1557732251000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":5,"pages":3,"list":[{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"666","fromNickname":"阿杜","createTime":1558334109000,"replyId":36,"commentId":36,"toUserName":"大攀","likeStatus":0},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"555","fromNickname":"阿杜","createTime":1558334033000,"replyId":35,"commentId":36,"toUserName":"大攀","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"大攀","commentId":36,"likeCount":0,"likeStatus":0,"userName":"大攀","userId":4337},{"icon_url":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","newsId":3835,"replyMsg":"123","createTime":1557158395000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":3,"pages":2,"list":[{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557732294000,"replyId":31,"commentId":35,"toUserName":"大攀","likeStatus":0},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557158476000,"replyId":29,"commentId":35,"toUserName":"大攀","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]},"nickname":"大攀","commentId":35,"likeCount":0,"likeStatus":0,"userName":"大攀","userId":4337}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
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
         * size : 7
         * orderBy : a.like_count DESC,a.create_time DESC
         * startRow : 1
         * endRow : 7
         * total : 7
         * pages : 1
         * list : [{"icon_url":"38D2D985-C517-4020-846B-9D65E392F6DC","newsId":3835,"replyMsg":"完美","createTime":1558286601000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":6,"pages":3,"list":[{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"再测试下下","fromNickname":"星米粒","createTime":1558452837000,"replyId":42,"commentId":45,"toUserName":"阿杜","likeStatus":0},{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"我的天","fromNickname":"星米粒","createTime":1558452732000,"replyId":41,"commentId":45,"toUserName":"阿杜","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"阿杜","commentId":45,"likeCount":0,"likeStatus":0,"userName":"阿杜","userId":4338},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"就是说","createTime":1557916025000,"commentReply":null,"nickname":"星米粒","commentId":44,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"光谷","createTime":1557915834000,"commentReply":null,"nickname":"星米粒","commentId":43,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"痛恨","createTime":1557915678000,"commentReply":null,"nickname":"星米粒","commentId":42,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","newsId":3835,"replyMsg":"哈哈哈有点想","createTime":1557915359000,"commentReply":null,"nickname":"星米粒","commentId":37,"likeCount":0,"likeStatus":0,"userName":"星米粒3","userId":4344},{"icon_url":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","newsId":3835,"replyMsg":"123","createTime":1557732251000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":5,"pages":3,"list":[{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"666","fromNickname":"阿杜","createTime":1558334109000,"replyId":36,"commentId":36,"toUserName":"大攀","likeStatus":0},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"555","fromNickname":"阿杜","createTime":1558334033000,"replyId":35,"commentId":36,"toUserName":"大攀","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"大攀","commentId":36,"likeCount":0,"likeStatus":0,"userName":"大攀","userId":4337},{"icon_url":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","newsId":3835,"replyMsg":"123","createTime":1557158395000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":3,"pages":2,"list":[{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557732294000,"replyId":31,"commentId":35,"toUserName":"大攀","likeStatus":0},{"toIcon":"http://132.232.197.128/group1/M00/00/00/rBsAD1yY4baAfoJJAABLPj-HsHc573.gif","fromUserId":4338,"fromIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","likeCount":0,"toUserId":4337,"toNickname":"大攀","fromUserName":"阿杜","replyMsg":"123","fromNickname":"阿杜","createTime":1557158476000,"replyId":29,"commentId":35,"toUserName":"大攀","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]},"nickname":"大攀","commentId":35,"likeCount":0,"likeStatus":0,"userName":"大攀","userId":4337}]
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
        private String orderBy;
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
        private List<ListBeanX> list;
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

        public String getOrderBy() {
            return orderBy;
        }

        public void setOrderBy(String orderBy) {
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

        public List<ListBeanX> getList() {
            return list;
        }

        public void setList(List<ListBeanX> list) {
            this.list = list;
        }

        public List<Integer> getNavigatepageNums() {
            return navigatepageNums;
        }

        public void setNavigatepageNums(List<Integer> navigatepageNums) {
            this.navigatepageNums = navigatepageNums;
        }

        public static class ListBeanX {
            /**
             * icon_url : 38D2D985-C517-4020-846B-9D65E392F6DC
             * newsId : 3835
             * replyMsg : 完美
             * createTime : 1558286601000
             * commentReply : {"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":6,"pages":3,"list":[{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"再测试下下","fromNickname":"星米粒","createTime":1558452837000,"replyId":42,"commentId":45,"toUserName":"阿杜","likeStatus":0},{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"我的天","fromNickname":"星米粒","createTime":1558452732000,"replyId":41,"commentId":45,"toUserName":"阿杜","likeStatus":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]}
             * nickname : 阿杜
             * commentId : 45
             * likeCount : 0
             * likeStatus : 0
             * userName : 阿杜
             * userId : 4338
             */

            private String icon_url;
            private int newsId;
            private String replyMsg;
            private long createTime;
            private CommentReplyBean commentReply;
            private String nickname;
            private int commentId;
            private int likeCount;
            private int likeStatus;
            private String userName;
            private int userId;

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public int getNewsId() {
                return newsId;
            }

            public void setNewsId(int newsId) {
                this.newsId = newsId;
            }

            public String getReplyMsg() {
                return replyMsg;
            }

            public void setReplyMsg(String replyMsg) {
                this.replyMsg = replyMsg;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public CommentReplyBean getCommentReply() {
                return commentReply;
            }

            public void setCommentReply(CommentReplyBean commentReply) {
                this.commentReply = commentReply;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public int getCommentId() {
                return commentId;
            }

            public void setCommentId(int commentId) {
                this.commentId = commentId;
            }

            public int getLikeCount() {
                return likeCount;
            }

            public void setLikeCount(int likeCount) {
                this.likeCount = likeCount;
            }

            public int getLikeStatus() {
                return likeStatus;
            }

            public void setLikeStatus(int likeStatus) {
                this.likeStatus = likeStatus;
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

            public static class CommentReplyBean {
                /**
                 * pageNum : 1
                 * pageSize : 2
                 * size : 2
                 * orderBy : null
                 * startRow : 1
                 * endRow : 2
                 * total : 6
                 * pages : 3
                 * list : [{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"再测试下下","fromNickname":"星米粒","createTime":1558452837000,"replyId":42,"commentId":45,"toUserName":"阿杜","likeStatus":0},{"toIcon":"38D2D985-C517-4020-846B-9D65E392F6DC","fromUserId":4344,"fromIcon":"60BAA0B7-42AC-42D3-A6A9-E9AB556BF274","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"星米粒3","replyMsg":"我的天","fromNickname":"星米粒","createTime":1558452732000,"replyId":41,"commentId":45,"toUserName":"阿杜","likeStatus":0}]
                 * firstPage : 1
                 * prePage : 0
                 * nextPage : 2
                 * lastPage : 3
                 * isFirstPage : true
                 * isLastPage : false
                 * hasPreviousPage : false
                 * hasNextPage : true
                 * navigatePages : 8
                 * navigatepageNums : [1,2,3]
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
                     * fromUserId : 4344
                     * fromIcon : 60BAA0B7-42AC-42D3-A6A9-E9AB556BF274
                     * likeCount : 0
                     * toUserId : 4338
                     * toNickname : 阿杜
                     * fromUserName : 星米粒3
                     * replyMsg : 再测试下下
                     * fromNickname : 星米粒
                     * createTime : 1558452837000
                     * replyId : 42
                     * commentId : 45
                     * toUserName : 阿杜
                     * likeStatus : 0
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
                    private int likeStatus;

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

                    public int getLikeStatus() {
                        return likeStatus;
                    }

                    public void setLikeStatus(int likeStatus) {
                        this.likeStatus = likeStatus;
                    }
                }
            }
        }
    }
}
