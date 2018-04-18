package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.NumberTrendVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/16.
 */

public class NumberTrendAdapter extends RecyclerBaseAdapter {
    public NumberTrendAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.number_trend_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        NumberTrendVO.DataBean.ListBean listBean = (NumberTrendVO.DataBean.ListBean) model;
        helper.setText(R.id.tv_01, listBean.getPf_no());
        helper.setText(R.id.tv_02, listBean.getPrise_code());
        helper.setText(R.id.tv_03, listBean.getRemain_count() + "次");
        helper.setText(R.id.tv_04, listBean.getBuy_count() + "次");
        LinearLayout layout = helper.getView(R.id.item_layout);
        if (position % 2 == 0) {
            helper.setBackgroundColorRes(R.id.item_layout, R.color.C1);
        } else {
            helper.setBackgroundColorRes(R.id.item_layout, R.color.C3);
        }


    }


}
