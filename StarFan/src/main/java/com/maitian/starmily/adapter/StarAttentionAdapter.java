package com.maitian.starmily.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.MyIdolsVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class StarAttentionAdapter extends RecyclerBaseAdapter {


    public StarAttentionAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.star_attention_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MyIdolsVO.ObjBean beans= (MyIdolsVO.ObjBean) model;
        if (!TextUtils.isEmpty(beans.getIconUrl())) {
            if (beans.getIconUrl().contains("http://")) {
                Picasso.with(mContext).load(beans.getIconUrl()).into(helper.getImageView(R.id.head_img));
            } else {
                Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + beans.getIconUrl()).into(helper.getImageView(R.id.head_img));
            }
        }
    }
}
