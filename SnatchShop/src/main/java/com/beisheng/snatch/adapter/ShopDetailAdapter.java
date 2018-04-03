package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.ShopDetailListVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class ShopDetailAdapter extends RecyclerBaseAdapter {

    public ShopDetailAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.shop_detail_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ShopDetailListVO.DataBean.ListBean vo = (ShopDetailListVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(vo.getAvatar()))
            Picasso.with(mContext).load(vo.getAvatar()).into(helper.getImageView(R.id.head_img));
        BaseCommonUtils.setTextTwoLast(mContext, helper.getTextView(R.id.tv_01), "参与者：", vo.getNickname(), R.color.C7, 1.0f);
        helper.setText(R.id.tv_02, vo.getUser_city() + "：" + vo.getUser_ip());
        helper.setText(R.id.tv_03, "参与时间：" + vo.getPayment_time());
        BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.tv_04), "本期购买：", vo.getBuy_count(), "人次", R.color.colorAccent, 1.3f);
    }


}
