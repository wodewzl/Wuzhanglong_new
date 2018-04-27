package com.beisheng.snatch.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.MyFlowRecordVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class MyFlowRecordAdapter extends RecyclerBaseAdapter {
    public MyFlowRecordAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_flow_record_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MyFlowRecordVO.DataBean.ListBean vo = (MyFlowRecordVO.DataBean.ListBean) model;
        helper.setText(R.id.month_tv, vo.getMonth());
        helper.setText(R.id.month_week_tv, vo.getDate_week());
        helper.setText(R.id.time_tv, vo.getDate_timeX());
        helper.setText(R.id.phone_tv, vo.getMobile());
        helper.setText(R.id.number_tv, vo.getFlow_count());

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
