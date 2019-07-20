package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/10.
 */

public class MessageVO extends BaseVO{

    /**
     * data : {"data":[{"jpush_id":"82","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"这是官方发出的一条测试消息，这是官方发出的一条测试消息。","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"81","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"最新官方","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"80","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"1","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"78","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"官方推送","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"77","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"官方push","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"74","jpush_addtime":"2018-01-19","jpush_uid":"39","jpush_content":"蝴蝶结你好","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"73","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"官方今天的天气不错哦","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"72","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"官方推送","jpush_type":"5","article_id":"0","msg_status":"1"}],"total_count":"8","page_count":"1"}
     */

    private DataBeanX data;

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * data : [{"jpush_id":"82","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"这是官方发出的一条测试消息，这是官方发出的一条测试消息。","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"81","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"最新官方","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"80","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"1","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"78","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"官方推送","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"77","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"官方push","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"74","jpush_addtime":"2018-01-19","jpush_uid":"39","jpush_content":"蝴蝶结你好","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"73","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"官方今天的天气不错哦","jpush_type":"5","article_id":"0","msg_status":"1"},{"jpush_id":"72","jpush_addtime":"2018-01-19","jpush_uid":"2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43","jpush_content":"官方推送","jpush_type":"5","article_id":"0","msg_status":"1"}]
         * total_count : 8
         * page_count : 1
         */

        private String total_count;
        private String page_count;
        private List<DataBean> data;

        public String getTotal_count() {
            return total_count;
        }

        public void setTotal_count(String total_count) {
            this.total_count = total_count;
        }

        public String getPage_count() {
            return page_count;
        }

        public void setPage_count(String page_count) {
            this.page_count = page_count;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * jpush_id : 82
             * jpush_addtime : 2018-01-19
             * jpush_uid : 2,27,28,29,30,31,32,33,34,36,37,38,39,40,41,43
             * jpush_content : 这是官方发出的一条测试消息，这是官方发出的一条测试消息。
             * jpush_type : 5
             * article_id : 0
             * msg_status : 1
             */

            private String jpush_id;
            private String jpush_addtime;
            private String jpush_uid;
            private String jpush_content;
            private String jpush_type;
            private String jpush_title="后台加一个字段叫jpush_title";
            private String article_id;
            private String msg_status;

            public String getJpush_title() {
                return jpush_title;
            }

            public void setJpush_title(String jpush_title) {
                this.jpush_title = jpush_title;
            }

            public String getJpush_id() {
                return jpush_id;
            }

            public void setJpush_id(String jpush_id) {
                this.jpush_id = jpush_id;
            }

            public String getJpush_addtime() {
                return jpush_addtime;
            }

            public void setJpush_addtime(String jpush_addtime) {
                this.jpush_addtime = jpush_addtime;
            }

            public String getJpush_uid() {
                return jpush_uid;
            }

            public void setJpush_uid(String jpush_uid) {
                this.jpush_uid = jpush_uid;
            }

            public String getJpush_content() {
                return jpush_content;
            }

            public void setJpush_content(String jpush_content) {
                this.jpush_content = jpush_content;
            }

            public String getJpush_type() {
                return jpush_type;
            }

            public void setJpush_type(String jpush_type) {
                this.jpush_type = jpush_type;
            }

            public String getArticle_id() {
                return article_id;
            }

            public void setArticle_id(String article_id) {
                this.article_id = article_id;
            }

            public String getMsg_status() {
                return msg_status;
            }

            public void setMsg_status(String msg_status) {
                this.msg_status = msg_status;
            }
        }
    }
}
