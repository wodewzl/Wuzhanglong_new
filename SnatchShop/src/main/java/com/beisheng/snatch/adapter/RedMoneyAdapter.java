package com.beisheng.snatch.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ProgressBar;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.SearchShopVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class RedMoneyAdapter extends RecyclerBaseAdapter {
    public RedMoneyAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.red_money_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {

    }
    @Override
    public int getItemViewType(int position) {
        return R.layout.red_money_adapter;
    }

    @Override
    public int getItemCount() {
        return 55;
    }
}
