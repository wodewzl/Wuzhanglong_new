package com.wzl.feifubao.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.HomeVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

;


/**
 * Created by Administrator on 2017/2/13.
 */

public class HomeAdapter extends RecyclerBaseAdapter<HomeVO.DataBean.TishiBean> {
    private String signUrl;

    public HomeAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.home_adapter_type8);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        final HomeVO.DataBean.TishiBean houseBean = (HomeVO.DataBean.TishiBean) model;
        ImageView tiShiImg = helper.getImageView(R.id.tishi_img);
        if (!TextUtils.isEmpty(houseBean.getImage()))
            Picasso.with(mContext).load(houseBean.getImage()).into(tiShiImg);
        helper.setText(R.id.desc_tv, houseBean.getTitle());

//        helper.setText(R.id.title_tv, houseBean.getHouse_title());
//        helper.setText(R.id.desc_tv, houseBean.getApartment() + " | " + houseBean.getHouse_area() + "㎡" + " | " + houseBean.getProvince() + houseBean.getCity());
//        TextView priceTv = helper.getTextView(R.id.money_tv);
//        BaseCommonUtils.setTextTwoBefore(mContext, priceTv, houseBean.getHouse_price(), "元", R.color.FUBColor3, 1.3f);
//        helper.setText(R.id.tag_tv, houseBean.getHouse_face_name());
    }
}
