package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.DiscussVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import java.util.ArrayList;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.bingoogolapple.photopicker.widget.BGANinePhotoLayout;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class DiscussAdapter extends RecyclerBaseAdapter {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DiscussAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.disscuss_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        DiscussVO.DataBean.ListBean bean = (DiscussVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getAvatar()))
            Picasso.with(mActivity).load(bean.getAvatar()).into(helper.getImageView(R.id.head_img));
        helper.setText(R.id.name_tv, bean.getNickname());
        helper.setText(R.id.content_tv, bean.getContent());

        BGANinePhotoLayout photoLayout = helper.getView(R.id.photo_layout);
        photoLayout.setData((ArrayList<String>) bean.getImgs());
        helper.setText(R.id.agree_count_tv, bean.getLikes());
        helper.setText(R.id.comment_count_tv, bean.getComments());
        helper.setText(R.id.share_count_tv, bean.getShares());
        helper.setItemChildClickListener(R.id.buy_tv);
    }
}
