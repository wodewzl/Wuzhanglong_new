package com.wzl.feifubao.adapter;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.ShopHomeVO;

import java.text.DecimalFormat;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class ShopHomeHorizontalAdapter extends RecyclerBaseAdapter<ShopHomeVO> {
    public ShopHomeHorizontalAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.shop_adapter_layout);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ShopHomeVO bean = (ShopHomeVO) model;
        if ("4".equals(bean.getType())) {
            if (!TextUtils.isEmpty(bean.getPic_cover_small()))
                Picasso.with(mActivity).load(bean.getPic_cover_small()).into(helper.getImageView(R.id.type4_img));
            helper.setText(R.id.type4_title_tv, bean.getGoods_name());
            helper.setText(R.id.type4_money_tv, "￥" + bean.getPrice());
        } else {
            if (!TextUtils.isEmpty(bean.getPic_cover_small()))
                Picasso.with(mActivity).load(bean.getPic_cover_small()).into(helper.getImageView(R.id.type6_img));
            helper.setText(R.id.type6_title_tv, bean.getGoods_name());
            DecimalFormat df = new DecimalFormat("#.0");
            if (!TextUtils.isEmpty(bean.getPrice()))
                helper.setText(R.id.type6_money_tv, "￥" + df.format(Double.parseDouble(bean.getPromotion_price())));
            TextView yuanjian = helper.getTextView(R.id.type6_yuanjian_tv);
            yuanjian.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            yuanjian.setText("￥" + df.format(Double.parseDouble(bean.getPrice())));
        }
    }


    @Override
    public int getItemViewType(int position) {
        if (this.getData().size() == 0) {
            return super.getItemViewType(position);
        }

        ShopHomeVO shopHomeVO = (ShopHomeVO) this.getData().get(position);
        if ("4".equals(shopHomeVO.getType())) {
            return R.layout.shop_home_adapter_type4_items;
        } else {
            return R.layout.shop_home_adapter_type6_item;
        }
    }
}
