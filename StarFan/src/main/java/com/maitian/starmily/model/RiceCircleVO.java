package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2019/4/19.
 */
public class RiceCircleVO extends BaseVO {

    /**
     * obj : {"pageNum":1,"pageSize":10,"size":8,"orderBy":null,"startRow":1,"endRow":8,"total":8,"pages":1,"list":[{"imgs":"606F6192-70A7-4E45-8117-E0D9350F8F80","topicLike":{"count":1,
     * "topicLikeUser":[{"userId":4338,"userName":"阿杜","phoneNo":"13026367306","wechatNo":null,"qqNo":null,"microblogNo":null,"nickname":"阿杜","exp":null,"sex":"1",
     * "iconUrl":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","address":null,"cityName":"武汉","cityCode":"027","birthday":null,"sign":"啊哈哈哈11111","onlineStatus":null,"loginTime":null,"authType":null,
     * "status":0,"registrationId":null,"lastloginType":null,"backUrl":null,"createTime":null}]},"count":0,"title":"test","userName":"阿杜","userId":4338,"content":"那个我也想知道为什么会","favoriateStatus":1,
     * "topicId":3838,"createTime":1555862201000,"nickname":"阿杜","likeStatus":0,"iconUrl":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","topicComment":{"pageNum":1,"pageSize":3,"size":1,"orderBy":null,
     * "startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"icon_url":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","topicId":3838,"replyMsg":"哈哈，想什么呢","createTime":1555924123000,"commentReply":{"pageNum
     * ":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":5,"pages":3,"list":[{"toIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,
     * "fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"阿杜","replyMsg":"别想多喝热水洗脸神器也有好处\u2026\u2026","fromNickname":"阿杜",
     * "createTime":1555927191000,"commentId":22,"toUserName":"阿杜","id":20,"status":0},{"toIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,
     * "fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"阿杜","replyMsg":"我也不知道","fromNickname":"阿杜","createTime":1555924165000,
     * "commentId":22,"toUserName":"阿杜","id":17,"status":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,
     * "navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"阿杜","likeCount":0,"id":22,"userName":"阿杜","userId":4338,"commentStatus":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,
     * "isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,
     * "isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1]}
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
         * size : 8
         * orderBy : null
         * startRow : 1
         * endRow : 8
         * total : 8
         * pages : 1
         * list : [{"imgs":"606F6192-70A7-4E45-8117-E0D9350F8F80","topicLike":{"count":1,"topicLikeUser":[{"userId":4338,"userName":"阿杜","phoneNo":"13026367306","wechatNo":null,"qqNo":null,
         * "microblogNo":null,"nickname":"阿杜","exp":null,"sex":"1","iconUrl":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","address":null,"cityName":"武汉","cityCode":"027","birthday":null,
         * "sign":"啊哈哈哈11111","onlineStatus":null,"loginTime":null,"authType":null,"status":0,"registrationId":null,"lastloginType":null,"backUrl":null,"createTime":null}]},"count":0,
         * "title":"test","userName":"阿杜","userId":4338,"content":"那个我也想知道为什么会","favoriateStatus":1,"topicId":3838,"createTime":1555862201000,"nickname":"阿杜","likeStatus":0,
         * "iconUrl":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","topicComment":{"pageNum":1,"pageSize":3,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"icon_url
         * ":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","topicId":3838,"replyMsg":"哈哈，想什么呢","createTime":1555924123000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,
         * "endRow":2,"total":5,"pages":3,"list":[{"toIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,"fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,
         * "toNickname":"阿杜","fromUserName":"阿杜","replyMsg":"别想多喝热水洗脸神器也有好处\u2026\u2026","fromNickname":"阿杜","createTime":1555927191000,"commentId":22,"toUserName":"阿杜","id":20,"status":0},{"toIcon
         * ":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,"fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"阿杜",
         * "replyMsg":"我也不知道","fromNickname":"阿杜","createTime":1555924165000,"commentId":22,"toUserName":"阿杜","id":17,"status":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,
         * "isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"阿杜","likeCount":0,"id":22,"userName":"阿杜",
         * "userId":4338,"commentStatus":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,
         * "navigatepageNums":[1]}}]
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
             * imgs : 606F6192-70A7-4E45-8117-E0D9350F8F80
             * topicLike : {"count":1,"topicLikeUser":[{"userId":4338,"userName":"阿杜","phoneNo":"13026367306","wechatNo":null,"qqNo":null,"microblogNo":null,"nickname":"阿杜","exp":null,"sex":"1",
             * "iconUrl":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","address":null,"cityName":"武汉","cityCode":"027","birthday":null,"sign":"啊哈哈哈11111","onlineStatus":null,"loginTime":null,
             * "authType":null,"status":0,"registrationId":null,"lastloginType":null,"backUrl":null,"createTime":null}]}
             * count : 0
             * title : test
             * userName : 阿杜
             * userId : 4338
             * content : 那个我也想知道为什么会
             * favoriateStatus : 1
             * topicId : 3838
             * createTime : 1555862201000
             * nickname : 阿杜
             * likeStatus : 0
             * iconUrl : 300C2EC0-16B6-4CAF-9C42-3167AF51782F
             * topicComment : {"pageNum":1,"pageSize":3,"size":1,"orderBy":null,"startRow":1,"endRow":1,"total":1,"pages":1,"list":[{"icon_url":"300C2EC0-16B6-4CAF-9C42-3167AF51782F",
             * "topicId":3838,"replyMsg":"哈哈，想什么呢","createTime":1555924123000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":5,"pages":3,"list":[{
             * "toIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,"fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,"toNickname":"阿杜",
             * "fromUserName":"阿杜","replyMsg":"别想多喝热水洗脸神器也有好处\u2026\u2026","fromNickname":"阿杜","createTime":1555927191000,"commentId":22,"toUserName":"阿杜","id":20,"status":0},{"toIcon":"300C2EC0
             * -16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,"fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"阿杜",
             * "replyMsg":"我也不知道","fromNickname":"阿杜","createTime":1555924165000,"commentId":22,"toUserName":"阿杜","id":17,"status":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,
             * "isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"阿杜","likeCount":0,"id":22,"userName":"阿杜",
             * "userId":4338,"commentStatus":0}],"firstPage":1,"prePage":0,"nextPage":0,"lastPage":1,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,
             * "navigatePages":8,"navigatepageNums":[1]}
             */

            private String imgs;
            private TopicLikeBean topicLike;
            private int count;
            private String title;
            private String userName;
            private int userId;
            private String content;
            private int favoriateStatus;
            private int topicId;
            private long createTime;
            private String nickname;
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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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
                 * topicLikeUser : [{"userId":4338,"userName":"阿杜","phoneNo":"13026367306","wechatNo":null,"qqNo":null,"microblogNo":null,"nickname":"阿杜","exp":null,"sex":"1",
                 * "iconUrl":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","address":null,"cityName":"武汉","cityCode":"027","birthday":null,"sign":"啊哈哈哈11111","onlineStatus":null,"loginTime":null,
                 * "authType":null,"status":0,"registrationId":null,"lastloginType":null,"backUrl":null,"createTime":null}]
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
                     * userId : 4338
                     * userName : 阿杜
                     * phoneNo : 13026367306
                     * wechatNo : null
                     * qqNo : null
                     * microblogNo : null
                     * nickname : 阿杜
                     * exp : null
                     * sex : 1
                     * iconUrl : 300C2EC0-16B6-4CAF-9C42-3167AF51782F
                     * address : null
                     * cityName : 武汉
                     * cityCode : 027
                     * birthday : null
                     * sign : 啊哈哈哈11111
                     * onlineStatus : null
                     * loginTime : null
                     * authType : null
                     * status : 0
                     * registrationId : null
                     * lastloginType : null
                     * backUrl : null
                     * createTime : null
                     */

                    private int userId;
                    private String userName;
                    private String phoneNo;
                    private Object wechatNo;
                    private Object qqNo;
                    private Object microblogNo;
                    private String nickname;
                    private Object exp;
                    private String sex;
                    private String iconUrl;
                    private Object address;
                    private String cityName;
                    private String cityCode;
                    private Object birthday;
                    private String sign;
                    private Object onlineStatus;
                    private Object loginTime;
                    private Object authType;
                    private int status;
                    private Object registrationId;
                    private Object lastloginType;
                    private Object backUrl;
                    private Object createTime;

                    public int getUserId() {
                        return userId;
                    }

                    public void setUserId(int userId) {
                        this.userId = userId;
                    }

                    public String getUserName() {
                        return userName;
                    }

                    public void setUserName(String userName) {
                        this.userName = userName;
                    }

                    public String getPhoneNo() {
                        return phoneNo;
                    }

                    public void setPhoneNo(String phoneNo) {
                        this.phoneNo = phoneNo;
                    }

                    public Object getWechatNo() {
                        return wechatNo;
                    }

                    public void setWechatNo(Object wechatNo) {
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

                    public String getCityName() {
                        return cityName;
                    }

                    public void setCityName(String cityName) {
                        this.cityName = cityName;
                    }

                    public String getCityCode() {
                        return cityCode;
                    }

                    public void setCityCode(String cityCode) {
                        this.cityCode = cityCode;
                    }

                    public Object getBirthday() {
                        return birthday;
                    }

                    public void setBirthday(Object birthday) {
                        this.birthday = birthday;
                    }

                    public String getSign() {
                        return sign;
                    }

                    public void setSign(String sign) {
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

                    public Object getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(Object createTime) {
                        this.createTime = createTime;
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
                 * list : [{"icon_url":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","topicId":3838,"replyMsg":"哈哈，想什么呢","createTime":1555924123000,"commentReply":{"pageNum":1,"pageSize":2,"size":2,
                 * "orderBy":null,"startRow":1,"endRow":2,"total":5,"pages":3,"list":[{"toIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,
                 * "fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"阿杜","replyMsg":"别想多喝热水洗脸神器也有好处\u2026\u2026","fromNickname":"阿杜",
                 * "createTime":1555927191000,"commentId":22,"toUserName":"阿杜","id":20,"status":0},{"toIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,
                 * "fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"阿杜","replyMsg":"我也不知道","fromNickname":"阿杜",
                 * "createTime":1555924165000,"commentId":22,"toUserName":"阿杜","id":17,"status":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,
                 * "hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]},"nickname":"阿杜","likeCount":0,"id":22,"userName":"阿杜","userId":4338,"commentStatus":0}]
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
                     * icon_url : 300C2EC0-16B6-4CAF-9C42-3167AF51782F
                     * topicId : 3838
                     * replyMsg : 哈哈，想什么呢
                     * createTime : 1555924123000
                     * commentReply : {"pageNum":1,"pageSize":2,"size":2,"orderBy":null,"startRow":1,"endRow":2,"total":5,"pages":3,"list":[{"toIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,"fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"阿杜","replyMsg":"别想多喝热水洗脸神器也有好处\u2026\u2026","fromNickname":"阿杜","createTime":1555927191000,"commentId":22,"toUserName":"阿杜","id":20,"status":0},{"toIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,"fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"阿杜","replyMsg":"我也不知道","fromNickname":"阿杜","createTime":1555924165000,"commentId":22,"toUserName":"阿杜","id":17,"status":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":3,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3]}
                     * nickname : 阿杜
                     * likeCount : 0
                     * id : 22
                     * userName : 阿杜
                     * userId : 4338
                     * commentStatus : 0
                     */

                    private String icon_url;
                    private int topicId;
                    private String replyMsg;
                    private long createTime;
                    private CommentReplyBean commentReply;
                    private String nickname;
                    private int likeCount;
                    private int likeStatus;
                    private int id;
                    private String userName;
                    private int userId;
                    private int commentStatus;
                    private int commentId;


                    public int getCommentId() {
                        return commentId;
                    }

                    public void setCommentId(int commentId) {
                        this.commentId = commentId;
                    }

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

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
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

                    public int getCommentStatus() {
                        return commentStatus;
                    }

                    public void setCommentStatus(int commentStatus) {
                        this.commentStatus = commentStatus;
                    }

                    public static class CommentReplyBean {
                        /**
                         * pageNum : 1
                         * pageSize : 2
                         * size : 2
                         * orderBy : null
                         * startRow : 1
                         * endRow : 2
                         * total : 5
                         * pages : 3
                         * list : [{"toIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,"fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"阿杜","replyMsg":"别想多喝热水洗脸神器也有好处\u2026\u2026","fromNickname":"阿杜","createTime":1555927191000,"commentId":22,"toUserName":"阿杜","id":20,"status":0},{"toIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","fromUserId":4338,"fromIcon":"300C2EC0-16B6-4CAF-9C42-3167AF51782F","likeCount":0,"toUserId":4338,"toNickname":"阿杜","fromUserName":"阿杜","replyMsg":"我也不知道","fromNickname":"阿杜","createTime":1555924165000,"commentId":22,"toUserName":"阿杜","id":17,"status":0}]
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
                             * toIcon : 300C2EC0-16B6-4CAF-9C42-3167AF51782F
                             * fromUserId : 4338
                             * fromIcon : 300C2EC0-16B6-4CAF-9C42-3167AF51782F
                             * likeCount : 0
                             * toUserId : 4338
                             * toNickname : 阿杜
                             * fromUserName : 阿杜
                             * replyMsg : 别想多喝热水洗脸神器也有好处……
                             * fromNickname : 阿杜
                             * createTime : 1555927191000
                             * commentId : 22
                             * toUserName : 阿杜
                             * id : 20
                             * status : 0
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
                            private int commentId;
                            private String toUserName;
                            private int id;
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

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
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
}
