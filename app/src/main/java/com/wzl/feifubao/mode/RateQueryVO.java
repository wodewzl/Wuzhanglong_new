package com.wzl.feifubao.mode;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class RateQueryVO extends BaseVO {

    /**
     * data : {"rate":[["CNY","7.7973","7.9176"],["USD","50.3780","50.3780"],["HKD","6.4388","6.4853"],["EUR","61.1440","62.1380"],["JPY","0.4533","0.4585"],["GBP","68.7140","70.3200"]]}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<List<String>> rate;
        private String money;

        public String getMoney() {
            return money;
        }

        public void setMoney(String money) {
            this.money = money;
        }

        public List<List<String>> getRate() {
            return rate;
        }

        public void setRate(List<List<String>> rate) {
            this.rate = rate;
        }
    }
}
