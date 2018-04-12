package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.ShowDetailListVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class ShowDetailAdapter extends RecyclerBaseAdapter {

    public ShowDetailAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.show_detail_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ShowDetailListVO.DataBean.ListBean bean= (ShowDetailListVO.DataBean.ListBean) model;
        if(!TextUtils.isEmpty(bean.getAvatar()))
            Picasso.with(mActivity).load(bean.getAvatar()).into(helper.getImageView(R.id.head_img));

        helper.setText(R.id.time_tv,bean.getAddtime());
        helper.setText(R.id.name_tv,bean.getNickname());
        helper.setText(R.id.content_tv,bean.getContent());
    }


}
