package com.wzl.feifubao.mode;

import com.google.gson.annotations.SerializedName;
import com.wuzhanglong.library.mode.BaseVO;

/**
 * Created by wuzhanglong on 2018/1/13.
 */

public class OrderPayVO {

    /**
     * code : 200
     * data : alipay_sdk=alipay-sdk-php-20161101&app_id=2017122601227506&biz_content=%7B%22body%22%3A%22151582169022331000%22%2C%22subject%22%3A%22151582169022331000%22%2C%22out_trade_no%22%3A%22151582169022331000%22%2C%22timeout_express%22%3A%2230m%22%2C%22total_amount%22%3A6724%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%7D&charset=UTF-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2Ffeidu.baonongkang.cn%2Findex.php%2FApi%2FCallback%2FaliPayBack&sign_type=RSA2&timestamp=2018-01-13+13%3A34%3A58&version=1.0&sign=Ji4NxBPV4yWyPA065u834vgYs3EqQfJ%2BC9T4zSnMaSGtCAqwejfF5VI5wY0r7kWcAGUYwykQFvJzyS0%2FOZ%2FQLc01P11rQBih1865ond6I3WRpdGOlVGdgqtY1bn6zJ9yU66RaXX7oym2LuAfRZbr1hggmVcJj0liCRc0z3UXnEqj88zuyt0BbnkF%2FW6XsManfxlwSIhc5fz%2FfzuxC7tSjBq1%2F4UUJYq8dBgy4Q8e%2BcoKhmfP%2FMSJKKEhWJIbzeg9XbNVjmPyfpgsNjJiqlQcw0hO9xYyp50EP%2BHIeNRDJtCHNPMsvZA%2BqGrZPKpwI4iEsOOgEJ29a5Ty6ztmSjrlSg%3D%3D
     * system_time : 2018-01-13 13:34:58
     */

    private int code;
    private String data;
    private String system_time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getSystem_time() {
        return system_time;
    }

    public void setSystem_time(String system_time) {
        this.system_time = system_time;
    }
}
