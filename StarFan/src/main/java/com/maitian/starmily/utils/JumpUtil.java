package com.maitian.starmily.utils;

import android.os.Bundle;
import android.text.TextUtils;

import com.maitian.starmily.activity.WebViewActivity;
import com.wuzhanglong.library.activity.BaseActivity;

public class JumpUtil {

    public static void jumpActivity(BaseActivity activity, int type, String link, String title) {
        if (type == 0) {
            Bundle bundle = new Bundle();
            bundle.putString("url", link);
            if (TextUtils.isEmpty(title)) {
                bundle.putString("title", title);
            }
            activity.open(WebViewActivity.class, bundle, 0);
        } else if (type == 1) {

        } else if (type == 2) {
//            Bundle bundle =new Bundle();
//            bundle.putString("url",bean.getLinkAddress());
//            bundle.putString("title","推荐");
//            mActivity.open(WebViewActivity.class,bundle,0);
        }
    }
}
