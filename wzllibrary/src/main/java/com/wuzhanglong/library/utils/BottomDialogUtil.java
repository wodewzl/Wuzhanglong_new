package com.wuzhanglong.library.utils;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.rey.material.app.BottomSheetDialog;

/**
 * Created by wuzhanglong on 2018/3/28.
 */

public class BottomDialogUtil {

    public static BottomSheetDialog initBottomDialog(Context context,int layoutId) {
//        BottomSheetDialog dialog = new BottomSheetDialog(mActivity);
        BottomSheetDialog dialog = new BottomSheetDialog(context);

        View dialogView = View.inflate(context, layoutId, null);
        dialog.contentView(dialogView)
                .heightParam(ViewGroup.LayoutParams.WRAP_CONTENT)
                .inDuration(500)
                .cancelable(true)
                .show();
        return dialog;
    }
}
