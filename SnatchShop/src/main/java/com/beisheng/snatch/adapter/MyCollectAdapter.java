package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.HomeVO;
import com.beisheng.snatch.model.MyCollectVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class MyCollectAdapter extends RecyclerBaseAdapter {

    public MyCollectAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_collect_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MyCollectVO.DataBean.ListBean bean = (MyCollectVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getGoods_image()))
            Picasso.with(mActivity).load(bean.getGoods_image()).into(helper.getImageView(R.id.img));
        helper.setText(R.id.tv_01, bean.getGoods_name());
        BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.tv_02), "总需：", bean.getTotal_count(), "次", R.color.colorAccent, 1.3f);
        helper.setText(R.id.tv_03, "收藏时间：" + bean.getFav_time());
    }

}
