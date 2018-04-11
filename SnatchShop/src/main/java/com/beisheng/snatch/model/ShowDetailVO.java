package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/11.
 */

public class ShowDetailVO extends BaseVO{

    /**
     * data : {"id":"2","title":"很好的平台","nickname":"lhb","content":"中*了，好开心。","imgs":["http://qmfq.baonongkang.cn/upload/comment/20180327/bf9ab70c44abb921de706395b9e5f0a8.jpg"],"likes":"1",
     * "comments":"4","shares":"0","latest_pid":"18","addtime":"2018-03-27","prise_info":{"goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅","issue_no":"5918553867",
     * "buy_count":"3960","prise_code":"1003246","get_time":"2018-03-23 10:01:10"},"comments_first_page":{"list":[{"id":"4","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"九九九",
     * "addtime":"04-09 15:53","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"3","evaluate_id":"2","uid":"9",
     * "nickname":"疯抢用户10005","content":"很牛啊","addtime":"04-09 15:35","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"2",
     * "evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"牛","addtime":"04-09 15:33","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg",
     * "user_no":"10005"},{"id":"1","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"恭喜恭喜","addtime":"03-27 14:58","avatar":"http://qmfq.baonongkang
     * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"}],"page":"1","count":"1"}}
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
         * id : 2
         * title : 很好的平台
         * nickname : lhb
         * content : 中*了，好开心。
         * imgs : ["http://qmfq.baonongkang.cn/upload/comment/20180327/bf9ab70c44abb921de706395b9e5f0a8.jpg"]
         * likes : 1
         * comments : 4
         * shares : 0
         * latest_pid : 18
         * addtime : 2018-03-27
         * prise_info : {"goods_name":"Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅","issue_no":"5918553867","buy_count":"3960","prise_code":"1003246","get_time":"2018-03-23 10:01:10"}
         * comments_first_page : {"list":[{"id":"4","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"九九九","addtime":"04-09 15:53","avatar":"http://qmfq.baonongkang
         * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"3","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"很牛啊","addtime":"04-09 15:35",
         * "avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"2","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005",
         * "content":"牛","addtime":"04-09 15:33","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"1","evaluate_id":"2",
         * "uid":"9","nickname":"疯抢用户10005","content":"恭喜恭喜","addtime":"03-27 14:58","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg",
         * "user_no":"10005"}],"page":"1","count":"1"}
         */

        private String id;
        private String title;
        private String nickname;
        private String content;
        private String likes;
        private String comments;
        private String shares;
        private String latest_pid;
        private String addtime;
        private PriseInfoBean prise_info;
        private CommentsFirstPageBean comments_first_page;
        private List<String> imgs;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
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

        public String getLatest_pid() {
            return latest_pid;
        }

        public void setLatest_pid(String latest_pid) {
            this.latest_pid = latest_pid;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public PriseInfoBean getPrise_info() {
            return prise_info;
        }

        public void setPrise_info(PriseInfoBean prise_info) {
            this.prise_info = prise_info;
        }

        public CommentsFirstPageBean getComments_first_page() {
            return comments_first_page;
        }

        public void setComments_first_page(CommentsFirstPageBean comments_first_page) {
            this.comments_first_page = comments_first_page;
        }

        public List<String> getImgs() {
            return imgs;
        }

        public void setImgs(List<String> imgs) {
            this.imgs = imgs;
        }

        public static class PriseInfoBean {
            /**
             * goods_name : Apple Watch Sport Series 1智能手表（38毫米银色铝金属表壳 白色运动型表带 防水溅
             * issue_no : 5918553867
             * buy_count : 3960
             * prise_code : 1003246
             * get_time : 2018-03-23 10:01:10
             */

            private String goods_name;
            private String issue_no;
            private String buy_count;
            private String prise_code;
            private String get_time;

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getIssue_no() {
                return issue_no;
            }

            public void setIssue_no(String issue_no) {
                this.issue_no = issue_no;
            }

            public String getBuy_count() {
                return buy_count;
            }

            public void setBuy_count(String buy_count) {
                this.buy_count = buy_count;
            }

            public String getPrise_code() {
                return prise_code;
            }

            public void setPrise_code(String prise_code) {
                this.prise_code = prise_code;
            }

            public String getGet_time() {
                return get_time;
            }

            public void setGet_time(String get_time) {
                this.get_time = get_time;
            }
        }

        public static class CommentsFirstPageBean {
            /**
             * list : [{"id":"4","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"九九九","addtime":"04-09 15:53","avatar":"http://qmfq.baonongkang
             * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"3","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"很牛啊","addtime":"04-09
             * 15:35","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"2","evaluate_id":"2","uid":"9",
             * "nickname":"疯抢用户10005","content":"牛","addtime":"04-09 15:33","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},
             * {"id":"1","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"恭喜恭喜","addtime":"03-27 14:58","avatar":"http://qmfq.baonongkang
             * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"}]
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
                 * id : 4
                 * evaluate_id : 2
                 * uid : 9
                 * nickname : 疯抢用户10005
                 * content : 九九九
                 * addtime : 04-09 15:53
                 * avatar : http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg
                 * user_no : 10005
                 */

                private String id;
                private String evaluate_id;
                private String uid;
                private String nickname;
                private String content;
                private String addtime;
                private String avatar;
                private String user_no;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getEvaluate_id() {
                    return evaluate_id;
                }

                public void setEvaluate_id(String evaluate_id) {
                    this.evaluate_id = evaluate_id;
                }

                public String getUid() {
                    return uid;
                }

                public void setUid(String uid) {
                    this.uid = uid;
                }

                public String getNickname() {
                    return nickname;
                }

                public void setNickname(String nickname) {
                    this.nickname = nickname;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getAddtime() {
                    return addtime;
                }

                public void setAddtime(String addtime) {
                    this.addtime = addtime;
                }

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getUser_no() {
                    return user_no;
                }

                public void setUser_no(String user_no) {
                    this.user_no = user_no;
                }
            }
        }
    }
}
