package com.beisheng.snatch.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class ScortDetailAdapter extends RecyclerBaseAdapter {
    public ScortDetailAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.scort_detail_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {

    }
    @Override
    public int getItemViewType(int position) {
        return R.layout.recharge_record_adapter;
    }

    @Override
    public int getItemCount() {
        return 55;
    }
}
