package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.HomeVO;
import com.wzl.feifubao.mode.JobOffersVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/29.
 */


public class JobOffersAdapter extends RecyclerBaseAdapter<JobOffersVO> {
    public JobOffersAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.job_offer_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {

    }


    @Override
    public int getItemCount() {
        return 30;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.job_offer_adapter;
    }
}
