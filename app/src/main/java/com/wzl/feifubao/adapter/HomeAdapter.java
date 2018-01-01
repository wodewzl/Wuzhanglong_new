package com.wzl.feifubao.adapter;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.SharePreferenceUtil;;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.HomeVO;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;


/**
 * Created by Administrator on 2017/2/13.
 */

public class HomeAdapter extends RecyclerBaseAdapter<HomeVO.DataBean.HouseBean> {
    private String signUrl;

    public HomeAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.home_adapter_type6);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        final HomeVO.DataBean.HouseBean houseBean = (HomeVO.DataBean.HouseBean) model;
        ImageView horseImg = helper.getImageView(R.id.house_img);
        Picasso.with(mContext).load(houseBean.getHouse_pic()).into(horseImg);
        helper.setText(R.id.title_tv, houseBean.getHouse_title());
        helper.setText(R.id.desc_tv, houseBean.getApartment() + " | " + houseBean.getHouse_area() + "㎡" + " | " + houseBean.getProvince() + houseBean.getCity());
        TextView priceTv = helper.getTextView(R.id.money_tv);
        BaseCommonUtils.setTextTwoBefore(mContext, priceTv, houseBean.getHouse_price(), "元", R.color.FUBColor3, 1.3f);
        helper.setText(R.id.tag_tv, houseBean.getHouse_tag());
    }
}
