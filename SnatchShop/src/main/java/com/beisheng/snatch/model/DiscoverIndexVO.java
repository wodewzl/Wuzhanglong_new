package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

public class DiscoverIndexVO extends BaseVO {


    /**
     * code : 200
     * desc : 请求成功！
     * data : {"guide":{"icon":"http://qmfq.baonongkang.cn/public/static/images/guide.png","title":"新手指南","desc":"老司机带带你","url":"http://qmfq.baonongkang.cn/special/guide.html"},"evaluate":{"icon":"http://qmfq.baonongkang.cn/public/static/images/evaluate.png","title":"晒图分享","desc":"送抢购次数","url":""},"recharge_banner":"http://qmfq.baonongkang.cn/public/static/images/recharge_banner.jpg","recharge_desc":"充值1元，获得0.01M流量，获赠1次疯抢资格。","list":[{"icon":"http://qmfq.baonongkang.cn/public/static/images/guide.png","title":"新手指南","desc":"老司机带带你","url":"http://qmfq.baonongkang.cn/special/guide.html"}]}
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
         * guide : {"icon":"http://qmfq.baonongkang.cn/public/static/images/guide.png","title":"新手指南","desc":"老司机带带你","url":"http://qmfq.baonongkang.cn/special/guide.html"}
         * evaluate : {"icon":"http://qmfq.baonongkang.cn/public/static/images/evaluate.png","title":"晒图分享","desc":"送抢购次数","url":""}
         * recharge_banner : http://qmfq.baonongkang.cn/public/static/images/recharge_banner.jpg
         * recharge_desc : 充值1元，获得0.01M流量，获赠1次疯抢资格。
         * list : [{"icon":"http://qmfq.baonongkang.cn/public/static/images/guide.png","title":"新手指南","desc":"老司机带带你","url":"http://qmfq.baonongkang.cn/special/guide.html"}]
         */

        private GuideBean guide;
        private EvaluateBean evaluate;
        private String recharge_banner;
        private String recharge_desc;
        private List<ListBean> list;

        public GuideBean getGuide() {
            return guide;
        }

        public void setGuide(GuideBean guide) {
            this.guide = guide;
        }

        public EvaluateBean getEvaluate() {
            return evaluate;
        }

        public void setEvaluate(EvaluateBean evaluate) {
            this.evaluate = evaluate;
        }

        public String getRecharge_banner() {
            return recharge_banner;
        }

        public void setRecharge_banner(String recharge_banner) {
            this.recharge_banner = recharge_banner;
        }

        public String getRecharge_desc() {
            return recharge_desc;
        }

        public void setRecharge_desc(String recharge_desc) {
            this.recharge_desc = recharge_desc;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class GuideBean {
            /**
             * icon : http://qmfq.baonongkang.cn/public/static/images/guide.png
             * title : 新手指南
             * desc : 老司机带带你
             * url : http://qmfq.baonongkang.cn/special/guide.html
             */

            private String icon;
            private String title;
            private String desc;
            private String url;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class EvaluateBean {
            /**
             * icon : http://qmfq.baonongkang.cn/public/static/images/evaluate.png
             * title : 晒图分享
             * desc : 送抢购次数
             * url :
             */

            private String icon;
            private String title;
            private String desc;
            private String url;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class ListBean {
            /**
             * icon : http://qmfq.baonongkang.cn/public/static/images/guide.png
             * title : 新手指南
             * desc : 老司机带带你
             * url : http://qmfq.baonongkang.cn/special/guide.html
             */

            private String icon;
            private String title;
            private String desc;
            private String url;

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
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
