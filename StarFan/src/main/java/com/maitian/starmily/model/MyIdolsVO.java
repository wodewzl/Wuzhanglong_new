package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2019/4/21.
 */
public class MyIdolsVO extends BaseVO implements Serializable {

    private List<ObjBean> obj;

    public List<ObjBean> getObj() {
        return obj;
    }

    public void setObj(List<ObjBean> obj) {
        this.obj = obj;
    }

    public static class ObjBean implements Serializable {
        /**
         * id : 2
         * idolName : 迪丽热巴
         * nickname : 胖巴
         * alias : 胖巴别名
         * groups : null
         * iconUrl : null
         * backUrl : null
         * info : 我是胖巴
         * createTime : null
         */

        private int id;
        private String idolName;
        private String nickname;
        private String alias;
        private Object groups;
        private String iconUrl;
        private String backUrl;
        private String info;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public String getBackUrl() {
            return backUrl;
        }

        public void setBackUrl(String backUrl) {
            this.backUrl = backUrl;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }



        @Override
        public String toString() {
            return idolName;
        }
    }
}
