package com.wzl.testdemo.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.opengl.Visibility;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.wzl.testdemo.R;
import com.wzl.testdemo.view.MyFirstCustomView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MyFirstCustomView myFirstCustomView = findViewById(R.id.custom_view);
        final TextView textView = findViewById(R.id.start_tv);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //平移
//                Animation translateAnimation = new TranslateAnimation(0, 120, 0, 200);
//                translateAnimation.setDuration(500);
//                translateAnimation.setFillAfter(true);//动画结束停留在结束位置
//                textView.startAnimation(translateAnimation);

                //缩放动画 参数说明
//                1. fromX ：动画在水平方向X的结束缩放倍数
//                2. toX ：动画在水平方向X的结束缩放倍数
//                3. fromY ：动画开始前在竖直方向Y的起始缩放倍数
//                4. toY：动画在竖直方向Y的结束缩放倍数
//                5. pivotXType:缩放轴点的x坐标的模式
//                6. pivotXValue:缩放轴点x坐标的相对值
//                7. pivotYType:缩放轴点的y坐标的模式
//                8. pivotYValue:缩放轴点y坐标的相对值
//                        pivotXType = Animation.ABSOLUTE:缩放轴点的x坐标 =  View左上角的原点 在x方向 加上 pivotXValue数值的点(y方向同理)
//                pivotXType = Animation.RELATIVE_TO_SELF:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 自身宽度乘上pivotXValue数值的值(y方向同理)
//                pivotXType = Animation.RELATIVE_TO_PARENT:缩放轴点的x坐标 = View左上角的原点 在x方向 加上 父控件宽度乘上pivotXValue数值的值 (y方向同理)
//                Animation scaleAnimation = new ScaleAnimation(0.0f, 2.0f, 0.0f, 2.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                scaleAnimation.setDuration(500);
//                textView.startAnimation(scaleAnimation);

                //透明度
                Animation alphaAnimation=new AlphaAnimation(0,1.0f);
                alphaAnimation.setDuration(500);
                alphaAnimation.setFillAfter(true);
                textView.startAnimation(alphaAnimation);

                //自定义View
//                myFirstCustomView.startCustAmin();

                //属性动画自动改变属性
//                ObjectAnimator objectAnimator=ObjectAnimator.ofInt(textView,"visibility", View.GONE,View.VISIBLE);
//                objectAnimator.setDuration(2000);
//                objectAnimator.setRepeatCount(Animation.INFINITE);
//                objectAnimator.setRepeatMode(ValueAnimator.RESTART);
//                objectAnimator.start();

                //属性动画手动赋值改变属性
//                ValueAnimator valueAnimator=ValueAnimator.ofInt(1,100);
//                valueAnimator.setDuration(2000);
//                valueAnimator.setRepeatCount(Animation.INFINITE);
//                valueAnimator.setRepeatMode(ValueAnimator.RESTART);
//                valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
//                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator animation) {
//                        int value= (int) animation.getAnimatedValue();
//                        textView.setPadding(value,0,value,0);
//                    }
//                });
//                valueAnimator.start();
            }
        });


//        final ValueAnimator   mValueAnimator= ValueAnimator.ofInt(0, 100);
//
//        mValueAnimator.setDuration(5000);
//        mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                mValueAnimator.setRepeatCount(ValueAnimator.INFINITE);
//                // 设置动画重复播放次数 = 重放次数+1
//                // 动画播放次数 = infinite时,动画无限重复
//
//                mValueAnimator.setRepeatMode(ValueAnimator.RESTART);//正序播放
//                mValueAnimator.setRepeatMode(ValueAnimator.REVERSE);//倒叙回放
//                int value= (int) animation.getAnimatedValue();
//                System.out.println("======================》++"+value);
//            }
//        });
//        mValueAnimator.start();

    }
}
