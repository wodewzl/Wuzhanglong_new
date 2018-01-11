package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.HouseListVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/30.
 */

public class HouseListAdapter extends RecyclerBaseAdapter<HouseListVO.DataBean.HouseBean> {

    public HouseListAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.house_list_adapter_layout);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        HouseListVO.DataBean.HouseBean bean = (HouseListVO.DataBean.HouseBean) model;
        ImageView houseImg = helper.getImageView(R.id.house_img);
        if (!TextUtils.isEmpty(bean.getHouse_pic()))
            Picasso.with(mContext).load(bean.getHouse_pic()).into(houseImg);
        helper.setText(R.id.title_tv, bean.getRenting_style() + "·" + bean.getHouse_title());
        helper.setText(R.id.desc_tv, bean.getHouse_name() + "/" + bean.getApartment() + "/" + bean.getHouse_area() + "㎡" + "/" + bean.getHouse_face());
        helper.setText(R.id.address_tv, bean.getArea());
        helper.setText(R.id.money_tv, bean.getHouse_price() + "/月");
    }

}
