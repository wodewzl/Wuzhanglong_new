package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/11.
 */

public class ShowDetailListVO extends BaseVO{

    /**
     * data : {"list":[{"id":"4","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"九九九","addtime":"04-09 15:53","avatar":"http://qmfq.baonongkang
     * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"3","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"很牛啊","addtime":"04-09 15:35",
     * "avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"2","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005",
     * "content":"牛","addtime":"04-09 15:33","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"1","evaluate_id":"2",
     * "uid":"9","nickname":"疯抢用户10005","content":"恭喜恭喜","addtime":"03-27 14:58","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg",
     * "user_no":"10005"}],"page":"1","count":"1"}
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
         * list : [{"id":"4","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"九九九","addtime":"04-09 15:53","avatar":"http://qmfq.baonongkang
         * .cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"3","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005","content":"很牛啊","addtime":"04-09 15:35",
         * "avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"2","evaluate_id":"2","uid":"9","nickname":"疯抢用户10005",
         * "content":"牛","addtime":"04-09 15:33","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg","user_no":"10005"},{"id":"1","evaluate_id":"2",
         * "uid":"9","nickname":"疯抢用户10005","content":"恭喜恭喜","addtime":"03-27 14:58","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg",
         * "user_no":"10005"}]
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
