package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.YellowPagesVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/31.
 */

public class YellowPagesAdapter extends RecyclerBaseAdapter<YellowPagesVO> {
    public YellowPagesAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.yellow_pages_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        System.out.println("========>");
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.yellow_pages_adapter;
    }
}
