package com.maitian.starmily.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.io.Serializable;

/**
 * Created by ${Wuzhanglong} on 2019/4/23.
 */
public class AppConfigVO extends BaseVO implements Serializable {

    /**
     * obj : {"imgDomain":"http://ppocwb3lg.bkt.clouddn.com"}
     */

    private ObjBean obj;

    public ObjBean getObj() {
        return obj;
    }

    public void setObj(ObjBean obj) {
        this.obj = obj;
    }

    public static class ObjBean implements Serializable{
        /**
         * imgDomain : http://ppocwb3lg.bkt.clouddn.com
         */

        private String imgDomain;

        public String getImgDomain() {
            return imgDomain;
        }

        public void setImgDomain(String imgDomain) {
            this.imgDomain = imgDomain;
        }
    }
}
