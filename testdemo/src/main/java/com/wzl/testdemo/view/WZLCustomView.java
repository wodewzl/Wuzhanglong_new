package com.wzl.testdemo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import com.wzl.testdemo.R;

public class WZLCustomView extends View {
    private Paint mPaint;

    //java 代码new 调用第一个构造函数
    public WZLCustomView(Context context) {
        super(context);
    }

    //java xml  调用第二个构造函数
    public WZLCustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WZLCustomView);//获取xml的资源文件的属性
        int color = typedArray.getColor(R.styleable.WZLCustomView_view_color, Color.GREEN);

        mPaint = new Paint();
        mPaint.setColor(Color.RED);//画笔颜色
        mPaint.setStrokeWidth(5f);//画笔
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(color);
//        init(context);
    }

    //不主动调用
    public WZLCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //不主动调用
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public WZLCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @SuppressLint("ResourceType")
    public void init(Context context) {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);//画笔颜色
        mPaint.setStrokeWidth(5f);//画笔
        mPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //xml没有加padding
//        int width = this.getWidth();//获取控件的宽
//        int higth = this.getHeight();//获取控件的高

        //xml 添加padding值 ，需要动态计算才能生效
        int width = this.getWidth() - this.getPaddingLeft() - this.getPaddingRight();//宽带去掉左右padding值
        int higth = getHeight() - getPaddingBottom() - getPaddingTop();//高度去掉上下padding
        int r = Math.min(width, higth) / 2;
        canvas.drawCircle(width / 2 + getPaddingLeft(), higth / 2 + getPaddingTop(), r, mPaint);//绘制圆,圆心坐标xy抽要加上左上padding
    }


    //自定义view xml里使用里wrap_content时要复写onMeasure,否则不生效
//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//    }
}
