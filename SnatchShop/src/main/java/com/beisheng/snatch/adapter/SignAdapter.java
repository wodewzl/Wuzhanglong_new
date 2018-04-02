package com.beisheng.snatch.adapter;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.SignVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class SignAdapter extends RecyclerBaseAdapter {

    public SignAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.sign_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        SignVO.DataBean.ExchangeListBean vo = (SignVO.DataBean.ExchangeListBean) model;
        if (!TextUtils.isEmpty(vo.getPicture()))
            Picasso.with(mActivity).load(vo.getPicture()).into(helper.getImageView(R.id.img));
        helper.setText(R.id.name_tv, vo.getGoods_name());
        helper.setText(R.id.tv_01,vo.getPrice()+"积分");
        helper.setText(R.id.tv_02,vo.getScore()+"积分");
        helper.getTextView(R.id.tv_02).getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

    }

}
