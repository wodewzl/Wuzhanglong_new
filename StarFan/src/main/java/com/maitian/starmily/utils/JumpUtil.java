package com.maitian.starmily.utils;

import android.os.Bundle;
import android.text.TextUtils;

import com.maitian.starmily.activity.HomeNewsDetailActivity;
import com.maitian.starmily.activity.WebViewActivity;
import com.wuzhanglong.library.activity.BaseActivity;

public class JumpUtil {

    public static void jumpActivity(BaseActivity activity, int type, String link, String title, String id) {
        Bundle bundle = new Bundle();
        if (type == 0) {
            bundle.putString("url", link);
            if (TextUtils.isEmpty(title)) {
                bundle.putString("title", title);
            }
            activity.open(WebViewActivity.class, bundle, 0);
        } else if (type == 1) {
            bundle.putString("url", link);
            if (TextUtils.isEmpty(title)) {
                bundle.putString("title", title);
            }
            activity.open(WebViewActivity.class, bundle, 0);
        } else if (type == 2) {
            bundle.putString("likeCount", "0");
            bundle.putString("newsId", id);
            activity.open(HomeNewsDetailActivity.class, bundle, 0);
        }
    }
}
