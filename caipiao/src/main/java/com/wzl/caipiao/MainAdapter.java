package com.wzl.caipiao;

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
        UserInfoVO userInfoVO = (UserInfoVO) model;
        helper.setText(R.id.result_tv, userInfoVO.getResult());
        helper.setText(R.id.tv_1, userInfoVO.getYuce1());
        helper.setText(R.id.tv_2, userInfoVO.getYuce2());
        helper.setText(R.id.tv_3, userInfoVO.getYuce3());
    }
}
