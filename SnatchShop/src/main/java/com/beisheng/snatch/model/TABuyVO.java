package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/4.
 */

public class TABuyVO extends BaseVO {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {


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
             * panic_id : 8
             * goods_name : ThinkPad 联想 E570系列 15.6英寸大屏游戏商务办公手提商用笔记本电脑
             * goods_image : http://qmfq.baonongkang.cn/upload/goods/20180315/5bd7f37bda4b7b02f411b99ebf8dac692.jpg
             * issue_no : 9767084747
             * total_buy : 160
             * total_count : 5000
             * remain_count : 1800
             * is_prise : 0
             * prise_status : 1
             * percent : 64
             * buy_codes : ["1000101","1000102","1000103","1000104","1000105","1000106","1000107","1000108","1000109","1000110","1000111","1000112","1000113","1000114","1000115","1000116",
             * "1000117","1000118","1000119","1000120","1000121","1000122","1000123","1000124","1000125","1000126","1000127","1000128","1000129","1000130","1000131","1000132","1000133","1000134",
             * "1000135","1000136","1000137","1000138","1000139","1000140","1000141","1000142","1000143","1000144","1000145","1000146","1000147","1000148","1000149","1000150","1000151","1000152",
             * "1000153","1000154","1000155","1000156","1000157","1000158","1000159","1000160","1000161","1000162","1000163","1000164","1000165","1000166","1000167","1000168","1000169","1000170",
             * "1000171","1000172","1000173","1000174","1000175","1000176","1000177","1000178","1000179","1000180","1000181","1000182","1000183","1000184","1000185","1000186","1000187","1000188",
             * "1000189","1000190","1000191","1000192","1000193","1000194","1000195","1000196","1000197","1000198","1000199","1000200"]
             * prise_info : {}
             * latest_pid : 8
             */

            private String panic_id;
            private String goods_name;
            private String goods_image;
            private String issue_no;
            private String total_buy;
            private String total_count;
            private String remain_count;
            private String is_prise;
            private String prise_status;
            private String percent;
            private PriseInfoBean prise_info;
            private String latest_pid;
            private List<String> buy_codes;

            public String getPanic_id() {
                return panic_id;
            }

            public void setPanic_id(String panic_id) {
                this.panic_id = panic_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_image() {
                return goods_image;
            }

            public void setGoods_image(String goods_image) {
                this.goods_image = goods_image;
            }

            public String getIssue_no() {
                return issue_no;
            }

            public void setIssue_no(String issue_no) {
                this.issue_no = issue_no;
            }

            public String getTotal_buy() {
                return total_buy;
            }

            public void setTotal_buy(String total_buy) {
                this.total_buy = total_buy;
            }

            public String getTotal_count() {
                return total_count;
            }

            public void setTotal_count(String total_count) {
                this.total_count = total_count;
            }

            public String getRemain_count() {
                return remain_count;
            }

            public void setRemain_count(String remain_count) {
                this.remain_count = remain_count;
            }

            public String getIs_prise() {
                return is_prise;
            }

            public void setIs_prise(String is_prise) {
                this.is_prise = is_prise;
            }

            public String getPrise_status() {
                return prise_status;
            }

            public void setPrise_status(String prise_status) {
                this.prise_status = prise_status;
            }

            public String getPercent() {
                return percent;
            }

            public void setPercent(String percent) {
                this.percent = percent;
            }

            public PriseInfoBean getPrise_info() {
                return prise_info;
            }

            public void setPrise_info(PriseInfoBean prise_info) {
                this.prise_info = prise_info;
            }

            public String getLatest_pid() {
                return latest_pid;
            }

            public void setLatest_pid(String latest_pid) {
                this.latest_pid = latest_pid;
            }

            public List<String> getBuy_codes() {
                return buy_codes;
            }

            public void setBuy_codes(List<String> buy_codes) {
                this.buy_codes = buy_codes;
            }

            public static class PriseInfoBean {
            }
        }
    }
}
