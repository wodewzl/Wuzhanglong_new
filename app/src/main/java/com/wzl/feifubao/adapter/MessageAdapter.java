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
        MessageVO.DataBeanX.DataBean bean = (MessageVO.DataBeanX.DataBean) model;
        helper.setText(R.id.time_tv, bean.getJpush_addtime());
        String type = bean.getJpush_type();
        if ("1".equals(type)) {
            helper.setText(R.id.title_tv, "缴费回执");
        } else if ("2".equals(type)) {
            helper.setText(R.id.title_tv, "订单发货");
        } else if ("3".equals(type)) {
            helper.setText(R.id.title_tv, "订单退款");
        } else if ("4".equals(type)) {
            helper.setText(R.id.title_tv, "资讯");
        } else if ("5".equals(type)) {
            helper.setText(R.id.title_tv, "消息");
        } else if ("6".equals(type)) {
            helper.setText(R.id.title_tv, "消息");
        } else {
            helper.setText(R.id.title_tv, bean.getJpush_title());
        }

        helper.setText(R.id.content_tv, bean.getJpush_content());
    }


}
