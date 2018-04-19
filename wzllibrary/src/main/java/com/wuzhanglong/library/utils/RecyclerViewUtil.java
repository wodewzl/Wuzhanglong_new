package com.wuzhanglong.library.utils;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAGridDivider;

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

    public static void initRecyclerViewLinearLayoutHorizontal(Context context, LuRecyclerView recyclerView, RecyclerBaseAdapter baseAdapter,int dividerHigh, int dividerColor){
       LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerDecoration divider = DividerUtil.linnerDivider(context, dividerHigh,dividerColor);
        recyclerView.addItemDecoration(divider);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(baseAdapter);
        recyclerView.setAdapter(adapter);

    }
    public static void initRecyclerViewGridLayoutManager(Context context, LuRecyclerView recyclerView, RecyclerBaseAdapter baseAdapter, int count, int dividerHigh, int dividerColor, boolean loadMore){
        GridLayoutManager layoutManager=new GridLayoutManager(context,count);
        recyclerView.setLayoutManager(layoutManager);
        BGAGridDivider divider = DividerUtil.bgaGridDivider(dividerHigh);
        recyclerView.addItemDecoration(divider);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(baseAdapter);
        recyclerView.setAdapter(adapter);
        recyclerView.setLoadMoreEnabled(loadMore);
    }
}
