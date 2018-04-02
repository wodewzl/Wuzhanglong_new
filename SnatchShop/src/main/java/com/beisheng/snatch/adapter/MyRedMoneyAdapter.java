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

public class MyRedMoneyAdapter extends RecyclerBaseAdapter {
    public MyRedMoneyAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_red_money_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {

    }
    @Override
    public int getItemViewType(int position) {
        return R.layout.my_red_money_adapter;
    }

    @Override
    public int getItemCount() {
        return 55;
    }
}