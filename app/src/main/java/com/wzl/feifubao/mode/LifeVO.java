package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/6.
 */

public class LifeVO extends BaseVO{

    /**
     * data : {"news":[{"article_id":"6","title":"生活服务测试标题！！！！！！","short_title":"生活服务测试短标题","create_time":"01月05日 17:14","image":"http://183.95.85.31:8001/upload/cms/1515143639.jpg"}],"total_count":"1","page_count":"1"}
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
         * news : [{"article_id":"6","title":"生活服务测试标题！！！！！！","short_title":"生活服务测试短标题","create_time":"01月05日 17:14","image":"http://183.95.85.31:8001/upload/cms/1515143639.jpg"}]
         * total_count : 1
         * page_count : 1
         */

        private String total_count;
        private String page_count;
        private List<NewsBean> news;

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

        public List<NewsBean> getNews() {
            return news;
        }

        public void setNews(List<NewsBean> news) {
            this.news = news;
        }

        public static class NewsBean {
            /**
             * article_id : 6
             * title : 生活服务测试标题！！！！！！
             * short_title : 生活服务测试短标题
             * create_time : 01月05日 17:14
             * image : http://183.95.85.31:8001/upload/cms/1515143639.jpg
             */

            private String article_id;
            private String title;
            private String short_title;
            private String create_time;
            private String image;
            private String content;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getArticle_id() {
                return article_id;
            }

            public void setArticle_id(String article_id) {
                this.article_id = article_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getShort_title() {
                return short_title;
            }

            public void setShort_title(String short_title) {
                this.short_title = short_title;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}
