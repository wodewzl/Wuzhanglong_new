package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.LotteryingVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.iwgang.countdownview.CountdownView;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class LotteryingAdapter extends RecyclerBaseAdapter {

    public LotteryingAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.lotterying_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        LotteryingVO.DataBean.ListBean dataBean = (LotteryingVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(dataBean.getGoods_image()))
            Picasso.with(mActivity).load(dataBean.getGoods_image()).into(helper.getImageView(R.id.shop_img));
        helper.setText(R.id.name_tv, dataBean.getGoods_name());
        CountdownView mCvCountdownView = helper.getView(R.id.countdown_view);
        mCvCountdownView.start(BaseCommonUtils.parseLong(dataBean.getSeconds_remain())*1000); // Millisecond
        BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.number_tv), "期号:第", dataBean.getFront_issue_no(), "期", R.color.C7, 1.3f);
    }
}
