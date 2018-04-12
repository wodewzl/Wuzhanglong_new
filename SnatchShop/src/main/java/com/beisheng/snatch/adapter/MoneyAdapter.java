package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.MyFlowVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;


import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class MoneyAdapter extends RecyclerBaseAdapter{
    public MoneyAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.money_adapter_layout);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MyFlowVO bean= (MyFlowVO) model;
        helper.setText(R.id.money_tv,bean.getMoney());
        if(bean.isSelect()){
            helper.getTextView(R.id.money_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext,5,R.color.colorAccent,R.color.C1));
            helper.setTextColorRes(R.id.money_tv,R.color.colorAccent);
        }else {
            helper.getTextView(R.id.money_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext,5,R.color.C3_1,R.color.C1));
            helper.setTextColorRes(R.id.money_tv,R.color.C4);

        }
    }
}
