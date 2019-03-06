package com.wzl.txffc;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class MainAdapter extends RecyclerBaseAdapter {
    public MainAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.main_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        UserInfoVO.DataBean dataBean = (UserInfoVO.DataBean) model;
        helper.setText(R.id.tv_1, dataBean.getOpencode().replaceAll(",",""));
        helper.setText(R.id.tv_2, dataBean.getExpect().substring(8,dataBean.getExpect().length()));

    }
}
