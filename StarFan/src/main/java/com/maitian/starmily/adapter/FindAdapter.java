package com.maitian.starmily.adapter;

import android.support.v7.widget.RecyclerView;

import com.maitian.starmily.R;
import com.maitian.starmily.model.FindBean;
import com.maitian.starmily.model.MessageVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class FindAdapter extends RecyclerBaseAdapter {
    public FindAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.find_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        FindBean.ObjBean.ListBean bean= (FindBean.ObjBean.ListBean) model;

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.find_adapter;
    }
}
