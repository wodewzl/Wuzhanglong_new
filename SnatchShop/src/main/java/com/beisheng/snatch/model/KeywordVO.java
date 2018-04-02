package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by wuzhanglong on 2018/3/22.
 */

public class KeywordVO extends BaseVO{

    /**
     * data : {"keywords_list":["笔记本","iphone","华为","1111"]}
     */

    private DataBean data;
    private List<String> keywords_history;
    public List<String> getKeywords_history() {
        return keywords_history;
    }

    public void setKeywords_history(List<String> keywords_history) {
        this.keywords_history = keywords_history;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private List<String> keywords_list;



        public List<String> getKeywords_list() {
            return keywords_list;
        }

        public void setKeywords_list(List<String> keywords_list) {
            this.keywords_list = keywords_list;
        }
    }
}
