package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.JobOffersVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/29.
 */


public class MessageAdapter extends RecyclerBaseAdapter<JobOffersVO.DataBeanX.DataBean> {
    public MessageAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.message_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {

    }


}
