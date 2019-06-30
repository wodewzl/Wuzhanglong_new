package com.maitian.starmily.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.maitian.starmily.R;

public class StarmilyToast extends Toast {
    /**
     * Toast单例
     */
    private static StarmilyToast toast;


    /**
     * 构造
     *
     * @param context
     */
    public StarmilyToast(Context context) {
        super(context);
    }

    public static void showTaskToast(Context context, String title, String exp, String mily) {
        // 初始化一个新的Toast对象
        initToast(context, title, exp, mily);

        // 设置显示时长
        toast.setDuration(Toast.LENGTH_LONG);

//        // 判断图标是否该显示，显示√还是×
//        if (imgType == TYPE_HIDE) {
//            toast_img.setVisibility(View.GONE);
//        } else {
//            if (imgType == TYPE_TRUE) {
//                toast_img.setBackgroundResource(R.drawable.toast_y);
//            } else {
//                toast_img.setBackgroundResource(R.drawable.toast_n);
//            }
//            toast_img.setVisibility(View.VISIBLE);
//            ObjectAnimator.ofFloat(toast_img, "rotationY", 0, 360).setDuration(1700).start();
//        }

        // 显示Toast
        toast.show();
    }

    private static void initToast(Context context, String title, String exp, String mily) {
        try {
            cancelToast();

            toast = new StarmilyToast(context);
            // 获取LayoutInflater对象
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            // 由layout文件创建一个View对象
            View layout = inflater.inflate(R.layout.starmily_toast_layout, null);

            // 吐司上的图片
//            toast_img = (ImageView) layout.findViewById(R.id.toast_img);

            // 实例化ImageView和TextView对象
            TextView titleTv = (TextView) layout.findViewById(R.id.title_tv);
            titleTv.setText(title);
            TextView expTv = (TextView) layout.findViewById(R.id.experience_tv);
            expTv.setText(exp);
            if(TextUtils.isEmpty(exp)){
                expTv.setVisibility(View.GONE);
            }
            TextView milyTv = (TextView) layout.findViewById(R.id.mily_tv);
            milyTv.setText(mily);
            toast.setView(layout);
            toast.setGravity(Gravity.CENTER, 0, 70);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 隐藏当前Toast
     */
    public static void cancelToast() {
        if (toast != null) {
            toast.cancel();
        }
    }

    public void cancel() {
        try {
            super.cancel();
        } catch (Exception e) {

        }
    }

    @Override
    public void show() {
        try {
            super.show();
        } catch (Exception e) {

        }
    }
}
