package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.HomeVO;
import com.beisheng.snatch.model.ShowVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class ShowAdapter extends RecyclerBaseAdapter {

    public ShowAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.show_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ShowVO.DataBean.ListBean bean= (ShowVO.DataBean.ListBean) model;

    }

}
