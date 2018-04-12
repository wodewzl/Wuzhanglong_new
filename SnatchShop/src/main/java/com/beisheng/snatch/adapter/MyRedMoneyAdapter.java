package com.beisheng.snatch.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.MyRedMoneyVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class MyRedMoneyAdapter extends RecyclerBaseAdapter {
    public MyRedMoneyAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_red_money_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MyRedMoneyVO.DataBean.CouponListBean bean= (MyRedMoneyVO.DataBean.CouponListBean) model;
        helper.setText(R.id.name_tv,bean.getCoupon_name());
        helper.setText(R.id.time_tv,"使用时间:"+bean.getStart_date().split(" ")[0]+"至"+bean.getEnd_date().split(" ")[0]);
        helper.setText(R.id.desc_tv,bean.getTips());
        helper.setText(R.id.status_tv,bean.getState_text());
        helper.setText(R.id.money_tv,"￥"+bean.getMoney());
        if("3".equals(bean.getState())){
            helper.setTextColorRes(R.id.money_tv,R.color.C6);
        }else {
            helper.setTextColorRes(R.id.money_tv,R.color.colorAccent);

        }
    }

}
