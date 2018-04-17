package com.beisheng.snatch.model;

import com.wuzhanglong.library.mode.BaseVO;

import java.util.List;

/**
 * Created by ${Wuzhanglong} on 2018/4/17.
 */

public class WuLiuVO extends BaseVO{

    /**
     * data : {"express_name":"韵达速递","logistic_code":"3979860133711","traces":[{"AcceptStation":"到达：湖北襄阳公司中原路分部 由 本人 签收","AcceptTime":"2018-03-20 16:34:56"},{"AcceptStation":"到达：湖北襄阳公司中原路分部 指定：熊斌斌
     * (18327527731) 派送","AcceptTime":"2018-03-20 10:00:00"},{"AcceptStation":"到达：湖北襄阳公司 发往：湖北襄阳公司中原路分部(13227568299)","AcceptTime":"2018-03-20 07:51:14"},{"AcceptStation":"到达：湖北武汉分拨中心 发往：湖北襄阳公司",
     * "AcceptTime":"2018-03-18 23:33:18"},{"AcceptStation":"到达：湖北武汉分拨中心","AcceptTime":"2018-03-18 23:27:46"},{"AcceptStation":"到达：湖北随州公司 大包称重","AcceptTime":"2018-03-18 19:11:06"},
     * {"AcceptStation":"到达：湖北随州公司 发往：湖北襄阳公司","AcceptTime":"2018-03-18 18:58:21"},{"AcceptStation":"到达：湖北随州公司 已揽件","AcceptTime":"2018-03-18 18:55:11"}]}
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
         * express_name : 韵达速递
         * logistic_code : 3979860133711
         * traces : [{"AcceptStation":"到达：湖北襄阳公司中原路分部 由 本人 签收","AcceptTime":"2018-03-20 16:34:56"},{"AcceptStation":"到达：湖北襄阳公司中原路分部 指定：熊斌斌(18327527731) 派送","AcceptTime":"2018-03-20 10:00:00"},
         * {"AcceptStation":"到达：湖北襄阳公司 发往：湖北襄阳公司中原路分部(13227568299)","AcceptTime":"2018-03-20 07:51:14"},{"AcceptStation":"到达：湖北武汉分拨中心 发往：湖北襄阳公司","AcceptTime":"2018-03-18 23:33:18"},
         * {"AcceptStation":"到达：湖北武汉分拨中心","AcceptTime":"2018-03-18 23:27:46"},{"AcceptStation":"到达：湖北随州公司 大包称重","AcceptTime":"2018-03-18 19:11:06"},{"AcceptStation":"到达：湖北随州公司 发往：湖北襄阳公司",
         * "AcceptTime":"2018-03-18 18:58:21"},{"AcceptStation":"到达：湖北随州公司 已揽件","AcceptTime":"2018-03-18 18:55:11"}]
         */

        private String express_name;
        private String logistic_code;
        private List<TracesBean> traces;

        public String getExpress_name() {
            return express_name;
        }

        public void setExpress_name(String express_name) {
            this.express_name = express_name;
        }

        public String getLogistic_code() {
            return logistic_code;
        }

        public void setLogistic_code(String logistic_code) {
            this.logistic_code = logistic_code;
        }

        public List<TracesBean> getTraces() {
            return traces;
        }

        public void setTraces(List<TracesBean> traces) {
            this.traces = traces;
        }

        public static class TracesBean {
            /**
             * AcceptStation : 到达：湖北襄阳公司中原路分部 由 本人 签收
             * AcceptTime : 2018-03-20 16:34:56
             */

            private String AcceptStation;
            private String AcceptTime;

            public String getAcceptStation() {
                return AcceptStation;
            }

            public void setAcceptStation(String AcceptStation) {
                this.AcceptStation = AcceptStation;
            }

            public String getAcceptTime() {
                return AcceptTime;
            }

            public void setAcceptTime(String AcceptTime) {
                this.AcceptTime = AcceptTime;
            }
        }
    }
}
