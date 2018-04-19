package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class SignDayAdapter extends RecyclerBaseAdapter {

    public SignDayAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.sign_day_adapter);
    }
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
    }


}
