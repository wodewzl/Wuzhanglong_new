package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/16.
 */

public class DailyTaskAdapter extends RecyclerBaseAdapter {
    public DailyTaskAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.dail_task_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {

    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.dail_task_adapter;
    }

    @Override
    public int getItemCount() {
        return 20;
    }
}
