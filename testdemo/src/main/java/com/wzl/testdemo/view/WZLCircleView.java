package com.wzl.testdemo.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

import com.wzl.testdemo.R;

/**
 * user：wuzhanglong on 2018/5/30.
 * email：zlwu5@iflytek.com
 * desc:学习简单的自定义View
 */
public class WZLCircleView extends View {
    private Paint mPaint;

    public WZLCircleView(Context context) {
        super(context);
    }

    //不主动调用
    public WZLCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //不主动调用
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WZLCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }


    public WZLCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray td = context.obtainStyledAttributes(attrs, R.styleable.WZLCircleView);
        int color = td.getColor(R.styleable.WZLCircleView_bg_color, Color.RED);
        mPaint = new Paint();
        mPaint.setColor(color);
        mPaint.setStrokeWidth(5f);
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() - getPaddingLeft() - getPaddingRight();
        int higth = getHeight() - getPaddingBottom() - getPaddingTop();
        int r = Math.min(higth,width) / 2;
        canvas.drawCircle(width / 2+getPaddingLeft(), higth / 2+getPaddingTop(), r, mPaint);//绘制圆

    }
}
