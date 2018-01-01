package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.JobOffersVO;
import com.wzl.feifubao.mode.MoneyVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class MoneyAdapter  extends RecyclerBaseAdapter<MoneyVO> {
    public MoneyAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.money_adapter_layout);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MoneyVO vo= (MoneyVO) model;
        helper.setText(R.id.money_tv,vo.getMoney());
        TextView moneyTv=helper.getTextView(R.id.money_tv);
        if("1".equals(vo.getStatus())){
            moneyTv.setBackgroundResource(R.drawable.frame_kong_yellow);
        }else {
            moneyTv.setBackgroundResource(R.drawable.frame_kong_gray);
        }
    }

}
