package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.TAShowVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class RecordShowAdapter extends RecyclerBaseAdapter {

    public RecordShowAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.record_show_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        TAShowVO.DataBean.ListBean vo = (TAShowVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(vo.getGoods_picture()))
            Picasso.with(mContext).load(vo.getImg()).into(helper.getImageView(R.id.shop_img));
        helper.setText(R.id.title_tv, vo.getTitle());
        helper.setText(R.id.content_tv, vo.getContent());
        helper.setText(R.id.time_tv, vo.getAddtime());
    }


}
