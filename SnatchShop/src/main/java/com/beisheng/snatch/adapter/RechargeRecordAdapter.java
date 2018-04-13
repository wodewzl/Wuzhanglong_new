package com.beisheng.snatch.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.MyFlowVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

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
        MyFlowVO bean = (MyFlowVO) model;
        helper.setText(R.id.money_tv, bean.getMoney());
        if (bean.isSelect()) {
            helper.getTextView(R.id.money_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.colorAccent, R.color.C1));
            helper.setTextColorRes(R.id.money_tv, R.color.colorAccent);
        } else {
            helper.getTextView(R.id.money_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.C3_1, R.color.C1));
            helper.setTextColorRes(R.id.money_tv, R.color.C4);

        }
    }

}
