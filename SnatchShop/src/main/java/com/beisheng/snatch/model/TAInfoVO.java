package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by ${Wuzhanglong} on 2018/4/4.
 */

public class TAInfoVO extends BaseVO {

    /**
     * data : {"uid":"9","nickname":"疯抢用户10005","user_no":"10005","avatar":"http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg"}
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
         * uid : 9
         * nickname : 疯抢用户10005
         * user_no : 10005
         * avatar : http://qmfq.baonongkang.cn/upload/avator/20180327/547e0080928a301433792ff0b4eb304b.jpg
         */

        private String uid;
        private String nickname;
        private String user_no;
        private String avatar;

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

        public String getUser_no() {
            return user_no;
        }

        public void setUser_no(String user_no) {
            this.user_no = user_no;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
