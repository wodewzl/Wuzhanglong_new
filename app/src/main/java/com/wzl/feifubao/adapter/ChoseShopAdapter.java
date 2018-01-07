package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.ShopVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class ChoseShopAdapter extends RecyclerBaseAdapter<ShopVO.DataBean.GoodsBean> {
    public ChoseShopAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.shop_adapter_layout);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ShopVO.DataBean.GoodsBean bean= (ShopVO.DataBean.GoodsBean) model;
        ImageView goodsImg=helper.getImageView(R.id.img);
        Picasso.with(mContext).load(bean.getPic_cover_small()).into(goodsImg);

        helper.setText(R.id.name_tv,bean.getGoods_name());
        helper.setText(R.id.price_tv,bean.getPrice());

    }

}
