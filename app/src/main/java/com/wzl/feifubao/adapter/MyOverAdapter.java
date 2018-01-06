package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.MoneyVO;
import com.wzl.feifubao.mode.MyoverVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;


/**
 * Created by Administrator on 2017/2/13.
 */

public class MyOverAdapter extends RecyclerBaseAdapter<MyoverVO> {

    public MyOverAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_over_adapter_type1);
    }

    @Override
    public void initData(final BGAViewHolderHelper helper, int position, Object model) {
        final MoneyVO vo = (MoneyVO) model;

    }


    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.my_over_adapter_type1;
    }
}
