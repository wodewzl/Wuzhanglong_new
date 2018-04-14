package com.beisheng.snatch.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.PayRedVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class RedMoneyAdapter extends RecyclerBaseAdapter {
    public RedMoneyAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.red_money_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        PayRedVO.DataBean.CouponListBean bean= (PayRedVO.DataBean.CouponListBean) model;
        helper.setText(R.id.name_tv,bean.getCoupon_name());
        helper.setText(R.id.time_tv,"使用时间:"+bean.getStart_date()+"至"+bean.getEnd_date());
        helper.setText(R.id.desc_tv,bean.getTips());
        helper.setText(R.id.money_tv,"￥"+bean.getMoney());

    }

}
