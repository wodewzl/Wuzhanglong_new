package com.beisheng.snatch.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.RechargeRecordVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class RechargeRecordAdapter extends RecyclerBaseAdapter {
    public RechargeRecordAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.recharge_record_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        RechargeRecordVO.DataBean.ListBean vo = (RechargeRecordVO.DataBean.ListBean) model;
        helper.setText(R.id.month_tv, vo.getMonth());
        helper.setText(R.id.month_week_tv, vo.getDate_week());
        helper.setText(R.id.time_tv, vo.getDate_timeX());
        helper.setText(R.id.money_tv, vo.getRecharge_money());
        helper.setText(R.id.flow_tv, vo.getGive_flux());
        helper.setText(R.id.count_tv, vo.getGive_number());
        if (position == 0) {
            helper.getView(R.id.divider_1).setVisibility(View.INVISIBLE);
            helper.getView(R.id.divider_2).setVisibility(View.VISIBLE);
        } else if (position == this.getData().size() - 1) {
            helper.getView(R.id.divider_1).setVisibility(View.VISIBLE);
            helper.getView(R.id.divider_2).setVisibility(View.INVISIBLE);
        } else {
            helper.getView(R.id.divider_1).setVisibility(View.VISIBLE);
            helper.getView(R.id.divider_2).setVisibility(View.VISIBLE);
        }
    }

}
