package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2019/4/28.
 */
public class StarVO extends BaseVO {


    /**
     * obj : {"pageNum":1,"pageSize":10,"size":10,"orderBy":null,"startRow":1,"endRow":10,"total":19,"pages":2,"list":[{"backUrl":"EB128B6C-09FA-4F04-A4FA-0BF8B418F587","createTime":null,"idolName":"迪丽热巴","nickname":"胖巴","alias":"胖巴别名","groups":null,"id":2,"alias2":null,"iconUrl":"64320B05-0358-4555-9085-399682287AC7","status":0},{"backUrl":"4B739B8D-F24E-42E9-BFF4-C38BCB45896F","createTime":null,"idolName":"王凯","nickname":"帅凯","alias":"帅凯别名","groups":null,"id":3,"alias2":null,"iconUrl":"4B739B8D-F24E-42E9-BFF4-C38BCB45896F","status":0},{"backUrl":"B4176CD4-4DAF-4B9E-8938-0746B9730909","createTime":null,"idolName":"蔡徐坤","nickname":"徐坤","alias":"蔡徐坤别名","groups":null,"id":4,"alias2":null,"iconUrl":"B4176CD4-4DAF-4B9E-8938-0746B9730909","status":0},{"backUrl":"295E77F4-A4F0-4F92-B2A4-5A8B291D94A1","createTime":null,"idolName":"angelbaby","nickname":"baby","alias":"baby别名","groups":null,"id":5,"alias2":null,"iconUrl":"295E77F4-A4F0-4F92-B2A4-5A8B291D94A1","status":0},{"backUrl":"9D752E7C-C267-44F4-8243-53C5D165A776","createTime":null,"idolName":"陈欣予","nickname":"素素","alias":"素素","groups":null,"id":6,"alias2":null,"iconUrl":"9D752E7C-C267-44F4-8243-53C5D165A776","status":0},{"backUrl":"F3C8BDEF-2726-4DE5-B508-5E3972D0F119","createTime":null,"idolName":"刘涛","nickname":"涛","alias":"涛别名","groups":null,"id":7,"alias2":null,"iconUrl":"F3C8BDEF-2726-4DE5-B508-5E3972D0F119","status":0},{"backUrl":"18862393-AF26-426A-BB9C-5936052C100B","createTime":null,"idolName":"刘诗诗","nickname":"诗诗","alias":"诗诗别名","groups":null,"id":8,"alias2":null,"iconUrl":"18862393-AF26-426A-BB9C-5936052C100B","status":0},{"backUrl":"40F2AFDB-0F6C-4014-9370-9FC120DA69A1","createTime":null,"idolName":"郑爽","nickname":"郑爽n","alias":"郑爽a","groups":null,"id":9,"alias2":null,"iconUrl":"40F2AFDB-0F6C-4014-9370-9FC120DA69A1","status":0},{"backUrl":"3EA70DB1-B73B-46A7-BFD8-C4BCD62954F5","createTime":null,"idolName":"赵丽颖","nickname":"赵丽颖n","alias":"赵丽颖a","groups":null,"id":10,"alias2":null,"iconUrl":"3EA70DB1-B73B-46A7-BFD8-C4BCD62954F5","status":0},{"backUrl":"D3080132-3C50-4351-AD51-80106E7FEAB4","createTime":null,"idolName":"关晓彤","nickname":"关晓彤1","alias":"关晓彤2","groups":null,"id":11,"alias2":null,"iconUrl":"D3080132-3C50-4351-AD51-80106E7FEAB4","status":0}],"firstPage":1,"prePage":0,"nextPage":2,"lastPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2]}
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
         * size : 10
         * orderBy : null
         * startRow : 1
         * endRow : 10
         * total : 19
         * pages : 2
         * list : [{"backUrl":"EB128B6C-09FA-4F04-A4FA-0BF8B418F587","createTime":null,"idolName":"迪丽热巴","nickname":"胖巴","alias":"胖巴别名","groups":null,"id":2,"alias2":null,"iconUrl":"64320B05-0358-4555-9085-399682287AC7","status":0},{"backUrl":"4B739B8D-F24E-42E9-BFF4-C38BCB45896F","createTime":null,"idolName":"王凯","nickname":"帅凯","alias":"帅凯别名","groups":null,"id":3,"alias2":null,"iconUrl":"4B739B8D-F24E-42E9-BFF4-C38BCB45896F","status":0},{"backUrl":"B4176CD4-4DAF-4B9E-8938-0746B9730909","createTime":null,"idolName":"蔡徐坤","nickname":"徐坤","alias":"蔡徐坤别名","groups":null,"id":4,"alias2":null,"iconUrl":"B4176CD4-4DAF-4B9E-8938-0746B9730909","status":0},{"backUrl":"295E77F4-A4F0-4F92-B2A4-5A8B291D94A1","createTime":null,"idolName":"angelbaby","nickname":"baby","alias":"baby别名","groups":null,"id":5,"alias2":null,"iconUrl":"295E77F4-A4F0-4F92-B2A4-5A8B291D94A1","status":0},{"backUrl":"9D752E7C-C267-44F4-8243-53C5D165A776","createTime":null,"idolName":"陈欣予","nickname":"素素","alias":"素素","groups":null,"id":6,"alias2":null,"iconUrl":"9D752E7C-C267-44F4-8243-53C5D165A776","status":0},{"backUrl":"F3C8BDEF-2726-4DE5-B508-5E3972D0F119","createTime":null,"idolName":"刘涛","nickname":"涛","alias":"涛别名","groups":null,"id":7,"alias2":null,"iconUrl":"F3C8BDEF-2726-4DE5-B508-5E3972D0F119","status":0},{"backUrl":"18862393-AF26-426A-BB9C-5936052C100B","createTime":null,"idolName":"刘诗诗","nickname":"诗诗","alias":"诗诗别名","groups":null,"id":8,"alias2":null,"iconUrl":"18862393-AF26-426A-BB9C-5936052C100B","status":0},{"backUrl":"40F2AFDB-0F6C-4014-9370-9FC120DA69A1","createTime":null,"idolName":"郑爽","nickname":"郑爽n","alias":"郑爽a","groups":null,"id":9,"alias2":null,"iconUrl":"40F2AFDB-0F6C-4014-9370-9FC120DA69A1","status":0},{"backUrl":"3EA70DB1-B73B-46A7-BFD8-C4BCD62954F5","createTime":null,"idolName":"赵丽颖","nickname":"赵丽颖n","alias":"赵丽颖a","groups":null,"id":10,"alias2":null,"iconUrl":"3EA70DB1-B73B-46A7-BFD8-C4BCD62954F5","status":0},{"backUrl":"D3080132-3C50-4351-AD51-80106E7FEAB4","createTime":null,"idolName":"关晓彤","nickname":"关晓彤1","alias":"关晓彤2","groups":null,"id":11,"alias2":null,"iconUrl":"D3080132-3C50-4351-AD51-80106E7FEAB4","status":0}]
         * firstPage : 1
         * prePage : 0
         * nextPage : 2
         * lastPage : 2
         * isFirstPage : true
         * isLastPage : false
         * hasPreviousPage : false
         * hasNextPage : true
         * navigatePages : 8
         * navigatepageNums : [1,2]
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
             * backUrl : EB128B6C-09FA-4F04-A4FA-0BF8B418F587
             * createTime : null
             * idolName : 迪丽热巴
             * nickname : 胖巴
             * alias : 胖巴别名
             * groups : null
             * id : 2
             * alias2 : null
             * iconUrl : 64320B05-0358-4555-9085-399682287AC7
             * status : 0
             */

            private String backUrl;
            private Object createTime;
            private String idolName;
            private String nickname;
            private String alias;
            private Object groups;
            private int id;
            private Object alias2;
            private String iconUrl;
            private int status;

            public String getBackUrl() {
                return backUrl;
            }

            public void setBackUrl(String backUrl) {
                this.backUrl = backUrl;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public String getIdolName() {
                return idolName;
            }

            public void setIdolName(String idolName) {
                this.idolName = idolName;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getAlias() {
                return alias;
            }

            public void setAlias(String alias) {
                this.alias = alias;
            }

            public Object getGroups() {
                return groups;
            }

            public void setGroups(Object groups) {
                this.groups = groups;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getAlias2() {
                return alias2;
            }

            public void setAlias2(Object alias2) {
                this.alias2 = alias2;
            }

            public String getIconUrl() {
                return iconUrl;
            }

            public void setIconUrl(String iconUrl) {
                this.iconUrl = iconUrl;
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
