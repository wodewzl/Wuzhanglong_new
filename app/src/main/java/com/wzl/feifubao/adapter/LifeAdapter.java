package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.LifeVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/29.
 */


public class LifeAdapter extends RecyclerBaseAdapter<LifeVO.DataBean.NewsBean> {
    public LifeAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.life_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        LifeVO.DataBean.NewsBean vo = (LifeVO.DataBean.NewsBean) model;
        helper.setText(R.id.time_tv, vo.getCreate_time());
        helper.setText(R.id.title_tv, vo.getTitle());
        if (TextUtils.isEmpty(vo.getImage()))
        Picasso.with(mActivity).load(vo.getImage()).into(helper.getImageView(R.id.img));
        helper.setText(R.id.desc_tv, vo.getShort_title());
    }


}
