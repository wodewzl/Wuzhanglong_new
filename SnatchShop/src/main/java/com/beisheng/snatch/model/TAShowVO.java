package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/4.
 */

public class TAShowVO extends BaseVO{

    /**
     * data : {"list":[{"id":"2","title":"很好的平台","content":"中*了，好开心。","img":"http://qmfq.baonongkang.cn/upload/comment/20180327/bf9ab70c44abb921de706395b9e5f0a8.jpg","addtime":"2018-03-27",
     * "goods_picture":"http://qmfq.baonongkang.cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"}],"page":"1","count":"1"}
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
         * list : [{"id":"2","title":"很好的平台","content":"中*了，好开心。","img":"http://qmfq.baonongkang.cn/upload/comment/20180327/bf9ab70c44abb921de706395b9e5f0a8.jpg","addtime":"2018-03-27",
         * "goods_picture":"http://qmfq.baonongkang.cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg"}]
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
             * id : 2
             * title : 很好的平台
             * content : 中*了，好开心。
             * img : http://qmfq.baonongkang.cn/upload/comment/20180327/bf9ab70c44abb921de706395b9e5f0a8.jpg
             * addtime : 2018-03-27
             * goods_picture : http://qmfq.baonongkang.cn/upload/goods/20180315/a2585ca5076defa4f747f8a8394b9e922.jpg
             */

            private String id;
            private String title;
            private String content;
            private String img;
            private String addtime;
            private String goods_picture;

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

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getAddtime() {
                return addtime;
            }

            public void setAddtime(String addtime) {
                this.addtime = addtime;
            }

            public String getGoods_picture() {
                return goods_picture;
            }

            public void setGoods_picture(String goods_picture) {
                this.goods_picture = goods_picture;
            }
        }
    }
}
