package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.PastBuyVO;
import com.beisheng.snatch.model.TAAwardVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class PastBuyAdapter extends RecyclerBaseAdapter {

    public PastBuyAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.past_buy_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        PastBuyVO.DataBean.ListBean vo = (PastBuyVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(vo.getGoods_image()))
            Picasso.with(mContext).load(vo.getGoods_image()).into(helper.getImageView(R.id.img));
        helper.setText(R.id.tv_01, vo.getGoods_name());
        BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.tv_02), "期号：第", vo.getFront_issue_no(), "期", R.color.C7, 1.3f);
        BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.tv_03), "抢购次数", vo.getBuy_total(), "次", R.color.colorAccent, 1.3f);
        helper.setText(R.id.tv_04, "购买者：" + vo.getNickname());
        helper.setText(R.id.tv_05, "购买时间：" + vo.getBuy_time());
    }


}
