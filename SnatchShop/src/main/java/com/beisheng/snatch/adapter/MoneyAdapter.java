package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;


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
//        MoneyVO vo= (MoneyVO) model;
//        helper.setText(R.id.money_tv,vo.getMoney());
//        TextView moneyTv=helper.getTextView(R.id.money_tv);
//        if("1".equals(vo.getStatus())){
//            moneyTv.setBackgroundResource(R.drawable.frame_kong_yellow);
//        }else {
//            moneyTv.setBackgroundResource(R.drawable.frame_kong_gray);
//        }
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.money_adapter_layout;
    }
}
