package com.beisheng.snatch.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.WuLiuVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class WuLiuAdapter extends RecyclerBaseAdapter {
    public WuLiuAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.wu_liu_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        WuLiuVO.DataBean.TracesBean vo = ( WuLiuVO.DataBean.TracesBean) model;
        helper.setText(R.id.time_tv,vo.getAcceptTime().split(" ")[0]+"\n"+vo.getAcceptTime().split(" ")[1]);
        helper.setText(R.id.title_tv,vo.getAcceptStation());
        TextView titleTv=helper.getTextView(R.id.title_tv);
        TextView timeTv=helper.getTextView(R.id.time_tv);

        if (position == 0) {
            helper.getView(R.id.divider_1).setVisibility(View.INVISIBLE);
            helper.getView(R.id.divider_2).setVisibility(View.VISIBLE);
            titleTv.setTextColor(ContextCompat.getColor(mContext,R.color.C7));
            timeTv.setTextColor(ContextCompat.getColor(mContext,R.color.C4));
        } else if (position == this.getData().size() - 1) {
            helper.getView(R.id.divider_1).setVisibility(View.VISIBLE);
            helper.getView(R.id.divider_2).setVisibility(View.INVISIBLE);
            titleTv.setTextColor(ContextCompat.getColor(mContext,R.color.C4));
            timeTv.setTextColor(ContextCompat.getColor(mContext,R.color.C6));
        } else {
            helper.getView(R.id.divider_1).setVisibility(View.VISIBLE);
            helper.getView(R.id.divider_2).setVisibility(View.VISIBLE);
            titleTv.setTextColor(ContextCompat.getColor(mContext,R.color.C4));
            timeTv.setTextColor(ContextCompat.getColor(mContext,R.color.C6));
        }


    }

}
