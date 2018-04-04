package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.TAAwardVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class RecordAwardAdapter extends RecyclerBaseAdapter {

    public RecordAwardAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.record_award_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        TAAwardVO.DataBean.ListBean vo = (TAAwardVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(vo.getGoods_picture()))
            Picasso.with(mContext).load(vo.getGoods_picture()).into(helper.getImageView(R.id.img));
        helper.setText(R.id.tv_01, vo.getGoods_name());
        BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.tv_02), "期号：第", vo.getIssue_no(), "期", R.color.C7, 1.3f);
        helper.setText(R.id.tv_03, "总需：" + vo.getTotal_buy() + "人次");
        BaseCommonUtils.setTextTwoLast(mContext, helper.getTextView(R.id.tv_04), "获奖号码：", vo.getPrise_code(), R.color.C7, 1.3f);
        BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.tv_05), "本期抢购：", vo.getTotal_buy(), "次", R.color.colorAccent, 1.3f);
        helper.setText(R.id.tv_06, "购买时间：" + vo.getPublish_time());
    }


}
