package com.wuzhanglong.library.utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.R;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

/**
 * Created by wuzhanglong on 2018/3/28.
 */

public class RecyclerViewUtil {
    public static void initRecyclerViewLinearLayout(Context context, LuRecyclerView recyclerView, RecyclerBaseAdapter baseAdapter,int dividerHigh, int dividerColor, boolean loadMore){
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        DividerDecoration divider = DividerUtil.linnerDivider(context, dividerHigh,dividerColor);
        recyclerView.addItemDecoration(divider);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(baseAdapter);
        recyclerView.setAdapter(adapter);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadMoreEnabled(loadMore);
    }

}
