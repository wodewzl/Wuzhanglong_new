package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class MyPostBean extends BaseVO {

    /**
     * obj : {"topics":{"pageNum":1,"pageSize":10,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"imgs":"icon_20190625154313","topicLike":{"count":1,"topicLikeUser":[{"userId":4355,"userName":null,"phoneNo":null,"wechatNo":"oe82L1JIw_qQHv4a_RCAnHRR01rA","qqNo":null,"microblogNo":null,"nickname":"宇轩","exp":null,"sex":"1","iconUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","address":null,"cityName":null,"cityCode":null,"birthday":null,"sign":null,"onlineStatus":null,"loginTime":null,"authType":null,"status":0,"registrationId":null,"lastloginType":null,"backUrl":null,"createTime":1561043067000,"updateTime":1561043067000}]},"count":0,"userName":null,"userId":4355,"content":"吴二少发帖了","favoriateStatus":1,"topicId":3856,"createTime":1561448601000,"nickname":"宇轩","likeStatus":1,"iconUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","topicComment":{"pageNum":1,"pageSize":3,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"icon_url":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","topicId":3856,"replyMsg":"好呀，小哥哥","createTime":1561602175000,"commentReply":{"pageNum":1,"pageSize":2,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"toIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","fromUserId":4355,"fromIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","likeCount":0,"toUserId":4355,"toNickname":"宇轩","fromUserName":null,"replyMsg":"你好约","fromNickname":"宇轩","createTime":1561602199000,"replyId":61,"commentId":59,"toUserName":null,"status":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]},"nickname":"宇轩","commentId":59,"likeCount":0,"likeStatus":1,"userName":null,"userId":4355}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]},"followUserInfo":{"icon_url":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","nickname":"宇轩","sign":null,"userName":null,"exp":166,"status":0}}
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
         * topics : {"pageNum":1,"pageSize":10,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"imgs":"icon_20190625154313","topicLike":{"count":1,"topicLikeUser":[{"userId":4355,"userName":null,"phoneNo":null,"wechatNo":"oe82L1JIw_qQHv4a_RCAnHRR01rA","qqNo":null,"microblogNo":null,"nickname":"宇轩","exp":null,"sex":"1","iconUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","address":null,"cityName":null,"cityCode":null,"birthday":null,"sign":null,"onlineStatus":null,"loginTime":null,"authType":null,"status":0,"registrationId":null,"lastloginType":null,"backUrl":null,"createTime":1561043067000,"updateTime":1561043067000}]},"count":0,"userName":null,"userId":4355,"content":"吴二少发帖了","favoriateStatus":1,"topicId":3856,"createTime":1561448601000,"nickname":"宇轩","likeStatus":1,"iconUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","topicComment":{"pageNum":1,"pageSize":3,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"icon_url":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","topicId":3856,"replyMsg":"好呀，小哥哥","createTime":1561602175000,"commentReply":{"pageNum":1,"pageSize":2,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"toIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","fromUserId":4355,"fromIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","likeCount":0,"toUserId":4355,"toNickname":"宇轩","fromUserName":null,"replyMsg":"你好约","fromNickname":"宇轩","createTime":1561602199000,"replyId":61,"commentId":59,"toUserName":null,"status":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]},"nickname":"宇轩","commentId":59,"likeCount":0,"likeStatus":1,"userName":null,"userId":4355}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
         * followUserInfo : {"icon_url":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","nickname":"宇轩","sign":null,"userName":null,"exp":166,"status":0}
         */

        private TopicsBean topics;
        private FollowUserInfoBean followUserInfo;

        public TopicsBean getTopics() {
            return topics;
        }

        public void setTopics(TopicsBean topics) {
            this.topics = topics;
        }

        public FollowUserInfoBean getFollowUserInfo() {
            return followUserInfo;
        }

        public void setFollowUserInfo(FollowUserInfoBean followUserInfo) {
            this.followUserInfo = followUserInfo;
        }

        public static class TopicsBean {
            /**
             * pageNum : 1
             * pageSize : 10
             * size : 1
             * orderBy : null
             * startRow : 1
             * endRow : 1
             * total : 1
             * pages : 1
             * list : [{"imgs":"icon_20190625154313","topicLike":{"count":1,"topicLikeUser":[{"userId":4355,"userName":null,"phoneNo":null,"wechatNo":"oe82L1JIw_qQHv4a_RCAnHRR01rA","qqNo":null,"microblogNo":null,"nickname":"宇轩","exp":null,"sex":"1","iconUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","address":null,"cityName":null,"cityCode":null,"birthday":null,"sign":null,"onlineStatus":null,"loginTime":null,"authType":null,"status":0,"registrationId":null,"lastloginType":null,"backUrl":null,"createTime":1561043067000,"updateTime":1561043067000}]},"count":0,"userName":null,"userId":4355,"content":"吴二少发帖了","favoriateStatus":1,"topicId":3856,"createTime":1561448601000,"nickname":"宇轩","likeStatus":1,"iconUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","topicComment":{"pageNum":1,"pageSize":3,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"icon_url":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","topicId":3856,"replyMsg":"好呀，小哥哥","createTime":1561602175000,"commentReply":{"pageNum":1,"pageSize":2,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"toIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","fromUserId":4355,"fromIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","likeCount":0,"toUserId":4355,"toNickname":"宇轩","fromUserName":null,"replyMsg":"你好约","fromNickname":"宇轩","createTime":1561602199000,"replyId":61,"commentId":59,"toUserName":null,"status":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]},"nickname":"宇轩","commentId":59,"likeCount":0,"likeStatus":1,"userName":null,"userId":4355}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}}]
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
            private List<ListBeanXX> list;
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

            public List<ListBeanXX> getList() {
                return list;
            }

            public void setList(List<ListBeanXX> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBeanXX {
                /**
                 * imgs : icon_20190625154313
                 * topicLike : {"count":1,"topicLikeUser":[{"userId":4355,"userName":null,"phoneNo":null,"wechatNo":"oe82L1JIw_qQHv4a_RCAnHRR01rA","qqNo":null,"microblogNo":null,"nickname":"宇轩","exp":null,"sex":"1","iconUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","address":null,"cityName":null,"cityCode":null,"birthday":null,"sign":null,"onlineStatus":null,"loginTime":null,"authType":null,"status":0,"registrationId":null,"lastloginType":null,"backUrl":null,"createTime":1561043067000,"updateTime":1561043067000}]}
                 * count : 0
                 * userName : null
                 * userId : 4355
                 * content : 吴二少发帖了
                 * favoriateStatus : 1
                 * topicId : 3856
                 * createTime : 1561448601000
                 * nickname : 宇轩
                 * likeStatus : 1
                 * iconUrl : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132
                 * topicComment : {"pageNum":1,"pageSize":3,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"icon_url":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","topicId":3856,"replyMsg":"好呀，小哥哥","createTime":1561602175000,"commentReply":{"pageNum":1,"pageSize":2,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"toIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","fromUserId":4355,"fromIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","likeCount":0,"toUserId":4355,"toNickname":"宇轩","fromUserName":null,"replyMsg":"你好约","fromNickname":"宇轩","createTime":1561602199000,"replyId":61,"commentId":59,"toUserName":null,"status":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]},"nickname":"宇轩","commentId":59,"likeCount":0,"likeStatus":1,"userName":null,"userId":4355}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
                 */

                private String imgs;
                private TopicLikeBean topicLike;
                private int count;
                private Object userName;
                private int userId;
                private String content;
                private int favoriateStatus;
                private int topicId;
                private long createTime;
                private String nickname;
                private String sign;
                private int likeStatus;
                private String iconUrl;
                private TopicCommentBean topicComment;

                public String getImgs() {
                    return imgs;
                }

                public void setImgs(String imgs) {
                    this.imgs = imgs;
                }

                public TopicLikeBean getTopicLike() {
                    return topicLike;
                }

                public void setTopicLike(TopicLikeBean topicLike) {
                    this.topicLike = topicLike;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public Object getUserName() {
                    return userName;
                }

                public void setUserName(Object userName) {
                    this.userName = userName;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public int getFavoriateStatus() {
                    return favoriateStatus;
                }

                public void setFavoriateStatus(int favoriateStatus) {
                    this.favoriateStatus = favoriateStatus;
                }

                public int getTopicId() {
                    return topicId;
                }

                public void setTopicId(int topicId) {
                    this.topicId = topicId;
                }

                public long getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(long createTime) {
                    this.createTime = createTime;
                }

                public String getSign() {
                    return sign;
                }

                public void setSign(String sign) {
                    this.sign = sign;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public int getLikeStatus() {
                    return likeStatus;
                }

                public void setLikeStatus(int likeStatus) {
                    this.likeStatus = likeStatus;
                }

                public String getIconUrl() {
                    return iconUrl;
                }

                public void setIconUrl(String iconUrl) {
                    this.iconUrl = iconUrl;
                }

                public TopicCommentBean getTopicComment() {
                    return topicComment;
                }

                public void setTopicComment(TopicCommentBean topicComment) {
                    this.topicComment = topicComment;
                }

                public static class TopicLikeBean {
                    /**
                     * count : 1
                     * topicLikeUser : [{"userId":4355,"userName":null,"phoneNo":null,"wechatNo":"oe82L1JIw_qQHv4a_RCAnHRR01rA","qqNo":null,"microblogNo":null,"nickname":"宇轩","exp":null,"sex":"1","iconUrl":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","address":null,"cityName":null,"cityCode":null,"birthday":null,"sign":null,"onlineStatus":null,"loginTime":null,"authType":null,"status":0,"registrationId":null,"lastloginType":null,"backUrl":null,"createTime":1561043067000,"updateTime":1561043067000}]
                     */

                    private int count;
                    private List<TopicLikeUserBean> topicLikeUser;

                    public int getCount() {
                        return count;
                    }

                    public void setCount(int count) {
                        this.count = count;
                    }

                    public List<TopicLikeUserBean> getTopicLikeUser() {
                        return topicLikeUser;
                    }

                    public void setTopicLikeUser(List<TopicLikeUserBean> topicLikeUser) {
                        this.topicLikeUser = topicLikeUser;
                    }

                    public static class TopicLikeUserBean {
                        /**
                         * userId : 4355
                         * userName : null
                         * phoneNo : null
                         * wechatNo : oe82L1JIw_qQHv4a_RCAnHRR01rA
                         * qqNo : null
                         * microblogNo : null
                         * nickname : 宇轩
                         * exp : null
                         * sex : 1
                         * iconUrl : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132
                         * address : null
                         * cityName : null
                         * cityCode : null
                         * birthday : null
                         * sign : null
                         * onlineStatus : null
                         * loginTime : null
                         * authType : null
                         * status : 0
                         * registrationId : null
                         * lastloginType : null
                         * backUrl : null
                         * createTime : 1561043067000
                         * updateTime : 1561043067000
                         */

                        private int userId;
                        private Object userName;
                        private Object phoneNo;
                        private String wechatNo;
                        private Object qqNo;
                        private Object microblogNo;
                        private String nickname;
                        private Object exp;
                        private String sex;
                        private String iconUrl;
                        private Object address;
                        private Object cityName;
                        private Object cityCode;
                        private Object birthday;
                        private Object sign;
                        private Object onlineStatus;
                        private Object loginTime;
                        private Object authType;
                        private int status;
                        private Object registrationId;
                        private Object lastloginType;
                        private Object backUrl;
                        private long createTime;
                        private long updateTime;

                        public int getUserId() {
                            return userId;
                        }

                        public void setUserId(int userId) {
                            this.userId = userId;
                        }

                        public Object getUserName() {
                            return userName;
                        }

                        public void setUserName(Object userName) {
                            this.userName = userName;
                        }

                        public Object getPhoneNo() {
                            return phoneNo;
                        }

                        public void setPhoneNo(Object phoneNo) {
                            this.phoneNo = phoneNo;
                        }

                        public String getWechatNo() {
                            return wechatNo;
                        }

                        public void setWechatNo(String wechatNo) {
                            this.wechatNo = wechatNo;
                        }

                        public Object getQqNo() {
                            return qqNo;
                        }

                        public void setQqNo(Object qqNo) {
                            this.qqNo = qqNo;
                        }

                        public Object getMicroblogNo() {
                            return microblogNo;
                        }

                        public void setMicroblogNo(Object microblogNo) {
                            this.microblogNo = microblogNo;
                        }

                        public String getNickname() {
                            return nickname;
                        }

                        public void setNickname(String nickname) {
                            this.nickname = nickname;
                        }

                        public Object getExp() {
                            return exp;
                        }

                        public void setExp(Object exp) {
                            this.exp = exp;
                        }

                        public String getSex() {
                            return sex;
                        }

                        public void setSex(String sex) {
                            this.sex = sex;
                        }

                        public String getIconUrl() {
                            return iconUrl;
                        }

                        public void setIconUrl(String iconUrl) {
                            this.iconUrl = iconUrl;
                        }

                        public Object getAddress() {
                            return address;
                        }

                        public void setAddress(Object address) {
                            this.address = address;
                        }

                        public Object getCityName() {
                            return cityName;
                        }

                        public void setCityName(Object cityName) {
                            this.cityName = cityName;
                        }

                        public Object getCityCode() {
                            return cityCode;
                        }

                        public void setCityCode(Object cityCode) {
                            this.cityCode = cityCode;
                        }

                        public Object getBirthday() {
                            return birthday;
                        }

                        public void setBirthday(Object birthday) {
                            this.birthday = birthday;
                        }

                        public Object getSign() {
                            return sign;
                        }

                        public void setSign(Object sign) {
                            this.sign = sign;
                        }

                        public Object getOnlineStatus() {
                            return onlineStatus;
                        }

                        public void setOnlineStatus(Object onlineStatus) {
                            this.onlineStatus = onlineStatus;
                        }

                        public Object getLoginTime() {
                            return loginTime;
                        }

                        public void setLoginTime(Object loginTime) {
                            this.loginTime = loginTime;
                        }

                        public Object getAuthType() {
                            return authType;
                        }

                        public void setAuthType(Object authType) {
                            this.authType = authType;
                        }

                        public int getStatus() {
                            return status;
                        }

                        public void setStatus(int status) {
                            this.status = status;
                        }

                        public Object getRegistrationId() {
                            return registrationId;
                        }

                        public void setRegistrationId(Object registrationId) {
                            this.registrationId = registrationId;
                        }

                        public Object getLastloginType() {
                            return lastloginType;
                        }

                        public void setLastloginType(Object lastloginType) {
                            this.lastloginType = lastloginType;
                        }

                        public Object getBackUrl() {
                            return backUrl;
                        }

                        public void setBackUrl(Object backUrl) {
                            this.backUrl = backUrl;
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
                    }
                }

                public static class TopicCommentBean {
                    /**
                     * pageNum : 1
                     * pageSize : 3
                     * size : 1
                     * orderBy : null
                     * startRow : 1
                     * endRow : 1
                     * total : 1
                     * pages : 1
                     * list : [{"icon_url":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","topicId":3856,"replyMsg":"好呀，小哥哥","createTime":1561602175000,"commentReply":{"pageNum":1,"pageSize":2,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"toIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","fromUserId":4355,"fromIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","likeCount":0,"toUserId":4355,"toNickname":"宇轩","fromUserName":null,"replyMsg":"你好约","fromNickname":"宇轩","createTime":1561602199000,"replyId":61,"commentId":59,"toUserName":null,"status":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]},"nickname":"宇轩","commentId":59,"likeCount":0,"likeStatus":1,"userName":null,"userId":4355}]
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
                         * icon_url : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132
                         * topicId : 3856
                         * replyMsg : 好呀，小哥哥
                         * createTime : 1561602175000
                         * commentReply : {"pageNum":1,"pageSize":2,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"toIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","fromUserId":4355,"fromIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","likeCount":0,"toUserId":4355,"toNickname":"宇轩","fromUserName":null,"replyMsg":"你好约","fromNickname":"宇轩","createTime":1561602199000,"replyId":61,"commentId":59,"toUserName":null,"status":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
                         * nickname : 宇轩
                         * commentId : 59
                         * likeCount : 0
                         * likeStatus : 1
                         * userName : null
                         * userId : 4355
                         */

                        private String icon_url;
                        private int topicId;
                        private String replyMsg;
                        private long createTime;
                        private CommentReplyBean commentReply;
                        private String nickname;
                        private int commentId;
                        private int likeCount;
                        private int likeStatus;
                        private Object userName;
                        private int userId;

                        public String getIcon_url() {
                            return icon_url;
                        }

                        public void setIcon_url(String icon_url) {
                            this.icon_url = icon_url;
                        }

                        public int getTopicId() {
                            return topicId;
                        }

                        public void setTopicId(int topicId) {
                            this.topicId = topicId;
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

                        public Object getUserName() {
                            return userName;
                        }

                        public void setUserName(Object userName) {
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
                             * size : 1
                             * orderBy : null
                             * startRow : 1
                             * endRow : 1
                             * total : 1
                             * pages : 1
                             * list : [{"toIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","fromUserId":4355,"fromIcon":"http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132","likeCount":0,"toUserId":4355,"toNickname":"宇轩","fromUserName":null,"replyMsg":"你好约","fromNickname":"宇轩","createTime":1561602199000,"replyId":61,"commentId":59,"toUserName":null,"status":0}]
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
                                 * toIcon : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132
                                 * fromUserId : 4355
                                 * fromIcon : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132
                                 * likeCount : 0
                                 * toUserId : 4355
                                 * toNickname : 宇轩
                                 * fromUserName : null
                                 * replyMsg : 你好约
                                 * fromNickname : 宇轩
                                 * createTime : 1561602199000
                                 * replyId : 61
                                 * commentId : 59
                                 * toUserName : null
                                 * status : 0
                                 */

                                private String toIcon;
                                private int fromUserId;
                                private String fromIcon;
                                private int likeCount;
                                private int toUserId;
                                private String toNickname;
                                private Object fromUserName;
                                private String replyMsg;
                                private String fromNickname;
                                private long createTime;
                                private int replyId;
                                private int commentId;
                                private Object toUserName;
                                private int status;

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

                                public Object getFromUserName() {
                                    return fromUserName;
                                }

                                public void setFromUserName(Object fromUserName) {
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

                                public Object getToUserName() {
                                    return toUserName;
                                }

                                public void setToUserName(Object toUserName) {
                                    this.toUserName = toUserName;
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
                }
            }
        }

        public static class FollowUserInfoBean {
            /**
             * icon_url : http://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLSbMtbEEx4LWHQK19JHicAtq3FZqVyU78ibg8bKsFJm5gTTpbFGicibWiaraibL0t8icXRXbfGqFfsb335A/132
             * nickname : 宇轩
             * sign : null
             * userName : null
             * exp : 166
             * status : 0
             */

            private String icon_url;
            private String nickname;
            private Object sign;
            private Object userName;
            private int exp;
            private int status;

            public String getIcon_url() {
                return icon_url;
            }

            public void setIcon_url(String icon_url) {
                this.icon_url = icon_url;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public Object getSign() {
                return sign;
            }

            public void setSign(Object sign) {
                this.sign = sign;
            }

            public Object getUserName() {
                return userName;
            }

            public void setUserName(Object userName) {
                this.userName = userName;
            }

            public int getExp() {
                return exp;
            }

            public void setExp(int exp) {
                this.exp = exp;
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
