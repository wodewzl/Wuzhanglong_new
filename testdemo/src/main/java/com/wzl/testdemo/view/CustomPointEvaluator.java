package com.wzl.testdemo.view;

import android.animation.TypeEvaluator;

/**
 * user：wuzhanglong on 2018/5/30.
 * email：zlwu5@iflytek.com
 * desc:
 */
public class CustomPointEvaluator implements TypeEvaluator {

    /**
     *
     * @param fraction 系数
     * @param startValue 起始值
     * @param endValue 终点值
     * @return
     */
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        CustomPoint startPoint = (CustomPoint) startValue;
        CustomPoint endPoint = (CustomPoint) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        CustomPoint point = new CustomPoint(x, y);
        return point;
    }
}
