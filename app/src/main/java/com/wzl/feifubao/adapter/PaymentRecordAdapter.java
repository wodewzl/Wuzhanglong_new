package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.JobOffersVO;
import com.wzl.feifubao.mode.PaymentRecordsVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/29.
 */


public class PaymentRecordAdapter extends RecyclerBaseAdapter<PaymentRecordsVO> {
    public PaymentRecordAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.payment_record_adapter_type2);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.payment_record_adapter_type2;
    }
}
