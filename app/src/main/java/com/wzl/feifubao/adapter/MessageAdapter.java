package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.JobOffersVO;
import com.wzl.feifubao.mode.MessageVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/29.
 */


public class MessageAdapter extends RecyclerBaseAdapter<MessageVO.DataBeanX.DataBean> {
    public MessageAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.message_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MessageVO.DataBeanX.DataBean bean= (MessageVO.DataBeanX.DataBean) model;
        helper.setText(R.id.time_tv,bean.getJpush_addtime());
        helper.setText(R.id.title_tv,bean.getJpush_title());
        helper.setText(R.id.content_tv,bean.getJpush_content());
    }


}
