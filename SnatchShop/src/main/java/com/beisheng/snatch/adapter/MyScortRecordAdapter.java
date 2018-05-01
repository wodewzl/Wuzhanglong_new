package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.MyScortRecordVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class MyScortRecordAdapter extends RecyclerBaseAdapter {

    public MyScortRecordAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_scort_record_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MyScortRecordVO.DataBean.ListBean bean = (MyScortRecordVO.DataBean.ListBean) model;
        helper.setText(R.id.title_tv,bean.getExchange_name());
        helper.setText(R.id.time_tv,bean.getExchange_time());
        helper.setText(R.id.money_tv,bean.getConsume_points());
        if("1".equals(bean.getDelivery_status())){
            helper.setVisibility(R.id.card_pwd_tv, View.VISIBLE);
        }else {
            helper.setVisibility(R.id.card_pwd_tv, View.GONE);
        }

        helper.setItemChildClickListener(R.id.card_pwd_tv);
    }

}
