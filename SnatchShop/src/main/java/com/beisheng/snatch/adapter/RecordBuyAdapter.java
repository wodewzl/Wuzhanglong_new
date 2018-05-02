package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ProgressBar;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.TABuyVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class RecordBuyAdapter extends RecyclerBaseAdapter {

    public RecordBuyAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.record_redemption_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        TABuyVO.DataBean.ListBean vo = (TABuyVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(vo.getGoods_image()))
            Picasso.with(mContext).load(vo.getGoods_image()).into(helper.getImageView(R.id.img));
        helper.setText(R.id.tv_01, vo.getGoods_name());
        BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.tv_02), "期号：第", vo.getIssue_no(), "期", R.color.C7, 1.3f);
        helper.setText(R.id.tv_03, "总需：" + vo.getTotal_count() + "人次");
        ProgressBar pb = helper.getView(R.id.progress_bar);
        pb.setProgress(BaseCommonUtils.parseInt(vo.getPercent()));
        BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.tv_04), "剩余：", vo.getRemain_count(), "人次", R.color.colorAccent, 1.3f);
        BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.tv_05), "本次抢购：", vo.getTotal_buy(), "人次", R.color.colorAccent, 1.3f);
        helper.setItemChildClickListener(R.id.tv_07);
    }


}
