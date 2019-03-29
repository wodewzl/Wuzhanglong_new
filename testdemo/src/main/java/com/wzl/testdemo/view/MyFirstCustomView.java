package com.wzl.testdemo.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ViewAnimator;

/**
 * user：wuzhanglong on 2018/5/30.
 * email：zlwu5@iflytek.com
 * desc:
 */
public class MyFirstCustomView extends View {
    private Paint mPaint;
    private int mLeftX = 0;
    private int mRightX = 0;
    private int mRadius = 0;
    private ValueAnimator mValueAnimator;

    public MyFirstCustomView(Context context) {
        super(context);
    }

    public MyFirstCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public MyFirstCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public MyFirstCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void init(Context context) {
        mRadius = 15;
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mLeftX = getWidth() / 2;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mRightX = Math.abs(getWidth() / 2 - mLeftX) * 2 + mLeftX;

        mPaint.setColor(Color.RED);
        canvas.drawCircle(mLeftX, getHeight() / 2, mRadius, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawCircle(mRightX, getHeight() / 2, mRadius, mPaint);

        mValueAnimator = ValueAnimator.ofInt(getWidth() / 2, getWidth() / 2 - 50);
        // 设置动画重复播放次数 = 重放次数+1
        // 动画播放次数 = infinite时,动画无限重复
        mValueAnimator.setRepeatCount(ValueAnimator.INFINITE);

        mValueAnimator.setRepeatMode(ValueAnimator.RESTART);//正序播放
        mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);//倒叙回放
        mValueAnimator.setDuration(500);
        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mLeftX = (int) animation.getAnimatedValue();
                System.out.println("======================》++" + mLeftX);
                invalidate();
            }
        });
    }

    public void startCustAmin() {
        mValueAnimator.start();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int width = 0;
        if (widthMode == MeasureSpec.EXACTLY) {
//            MeasureSpec.EXACTLY  match_parent或指定的大小，直接使用的结果
            width = widthSize;
        } else {
            // MeasureSpec.AT_MOST wrap_content 需要自己计算

        }

        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int height = 0;
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            // MeasureSpec.AT_MOST wrap_content 需要自己计算
        }
        setMeasuredDimension(width, height);

    }
}
