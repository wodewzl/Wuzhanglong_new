package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.AddressVO;
import com.wzl.feifubao.mode.OrderSureVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;


/**
 * Created by Administrator on 2017/2/13.
 */

public class OrderSureAdapter extends RecyclerBaseAdapter<OrderSureVO.DataBean.ListBean> {
    private AddressVO mDefalutVO;

    public OrderSureAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.order_sure_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        OrderSureVO.DataBean.ListBean vo = (OrderSureVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(vo.getPic_cover_micro()))
            Picasso.with(mActivity).load(vo.getPic_cover_micro()).into(helper.getImageView(R.id.goods_img));
        helper.setText(R.id.goods_name_tv, "接口没反？？？？");
        helper.setText(R.id.goods_desc_tv, vo.getSku_name());
        helper.setText(R.id.goods_price_tv, vo.getSubtotal());
    }


}
