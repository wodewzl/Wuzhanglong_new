package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/2.
 */

public class MyMessageVO extends BaseVO{

    /**
     * data : {"list":[{"id":"16","records_type":"3","title":"红包到期提醒","content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！","create_date":"3月31日","is_read":"0","detail_url":"http://qmfq.baonongkang
     * .cn/index.php?s=/Api/Dbindex/notice_detail&id=16&uid=9"},{"id":"15","records_type":"3","title":"红包到期提醒","content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！","create_date":"3月31日","is_read":"0",
     * "detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=15&uid=9"},{"id":"14","records_type":"3","title":"红包到期提醒","content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！",
     * "create_date":"3月31日","is_read":"0","detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=14&uid=9"},{"id":"12","records_type":"3","title":"红包到期提醒",
     * "content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！","create_date":"3月31日","is_read":"0","detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=12&uid=9"},{"id":"11",
     * "records_type":"4","title":"发货提醒","content":"[物流更新]您的海尔（Haier）60升电热水器 5倍增容速热遥控预约 一级能效节能抑菌专利2.0安全防电墙EC6003-G6正在使用韵达速递已发出，快递单号：3905120715127，请注意查收。","create_date":"3月30日","is_read":"1",
     * "detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=11&uid=9"},{"id":"6","records_type":"2","title":"红包到期提醒","content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！",
     * "create_date":"3月30日","is_read":"0","detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=6&uid=9"},{"id":"5","records_type":"2","title":"红包到期提醒",
     * "content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！","create_date":"3月30日","is_read":"0","detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=5&uid=9"},{"id":"4",
     * "records_type":"1","title":"46s16d11","content":"asdfsadddddddddddd","create_date":"3月30日","is_read":"0","detail_url":"http://qmfq.baonongkang.cn/index
     * .php?s=/Api/Dbindex/notice_detail&id=4&uid=9"},{"id":"3","records_type":"1","title":"推送一下","content":"推送一下推送一下推送一下推送一下","create_date":"3月30日","is_read":"0","detail_url":"http://qmfq
     * .baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=3&uid=9"},{"id":"2","records_type":"1","title":"推送一下","content":"推送一下推送一下推送一下推送一下推送一下","create_date":"3月30日","is_read":"0",
     * "detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=2&uid=9"}],"page":"1","count":"2"}
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
         * list : [{"id":"16","records_type":"3","title":"红包到期提醒","content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！","create_date":"3月31日","is_read":"0","detail_url":"http://qmfq.baonongkang.cn/index
         * .php?s=/Api/Dbindex/notice_detail&id=16&uid=9"},{"id":"15","records_type":"3","title":"红包到期提醒","content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！","create_date":"3月31日","is_read":"0",
         * "detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=15&uid=9"},{"id":"14","records_type":"3","title":"红包到期提醒",
         * "content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！","create_date":"3月31日","is_read":"0","detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=14&uid=9"},
         * {"id":"12","records_type":"3","title":"红包到期提醒","content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！","create_date":"3月31日","is_read":"0","detail_url":"http://qmfq.baonongkang.cn/index
         * .php?s=/Api/Dbindex/notice_detail&id=12&uid=9"},{"id":"11","records_type":"4","title":"发货提醒","content":"[物流更新]您的海尔（Haier）60升电热水器 5倍增容速热遥控预约
         * 一级能效节能抑菌专利2.0安全防电墙EC6003-G6正在使用韵达速递已发出，快递单号：3905120715127，请注意查收。","create_date":"3月30日","is_read":"1","detail_url":"http://qmfq.baonongkang.cn/index
         * .php?s=/Api/Dbindex/notice_detail&id=11&uid=9"},{"id":"6","records_type":"2","title":"红包到期提醒","content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！","create_date":"3月30日","is_read":"0",
         * "detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=6&uid=9"},{"id":"5","records_type":"2","title":"红包到期提醒",
         * "content":"亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！","create_date":"3月30日","is_read":"0","detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=5&uid=9"},
         * {"id":"4","records_type":"1","title":"46s16d11","content":"asdfsadddddddddddd","create_date":"3月30日","is_read":"0","detail_url":"http://qmfq.baonongkang.cn/index
         * .php?s=/Api/Dbindex/notice_detail&id=4&uid=9"},{"id":"3","records_type":"1","title":"推送一下","content":"推送一下推送一下推送一下推送一下","create_date":"3月30日","is_read":"0","detail_url":"http://qmfq
         * .baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=3&uid=9"},{"id":"2","records_type":"1","title":"推送一下","content":"推送一下推送一下推送一下推送一下推送一下","create_date":"3月30日","is_read":"0",
         * "detail_url":"http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=2&uid=9"}]
         * page : 1
         * count : 2
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
             * id : 16
             * records_type : 3
             * title : 红包到期提醒
             * content : 亲爱的疯抢用户10005，您的1.00元红包还有3小时到期，不要错过哦！
             * create_date : 3月31日
             * is_read : 0
             * detail_url : http://qmfq.baonongkang.cn/index.php?s=/Api/Dbindex/notice_detail&id=16&uid=9
             */

            private String id;
            private String records_type;
            private String title;
            private String content;
            private String create_date;
            private String is_read;
            private String detail_url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getRecords_type() {
                return records_type;
            }

            public void setRecords_type(String records_type) {
                this.records_type = records_type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreate_date() {
                return create_date;
            }

            public void setCreate_date(String create_date) {
                this.create_date = create_date;
            }

            public String getIs_read() {
                return is_read;
            }

            public void setIs_read(String is_read) {
                this.is_read = is_read;
            }

            public String getDetail_url() {
                return detail_url;
            }

            public void setDetail_url(String detail_url) {
                this.detail_url = detail_url;
            }
        }
    }
}
