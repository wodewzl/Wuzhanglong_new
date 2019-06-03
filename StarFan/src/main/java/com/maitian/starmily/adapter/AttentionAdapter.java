package com.maitian.starmily.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.AttentionBean;
import com.maitian.starmily.model.MessageVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class AttentionAdapter extends RecyclerBaseAdapter {
    public AttentionAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.attention_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        AttentionBean.ObjBean bean = (AttentionBean.ObjBean) model;
        if (!TextUtils.isEmpty(bean.getFollowIcon()))
            Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + bean.getFollowIcon()).into(helper.getImageView(R.id.head_img));
        helper.setText(R.id.name_tv, bean.getNickname());
        if (bean.getStatus() == 1) {
            helper.setBackgroundRes(R.id.status_tv, R.drawable.frame_kongxin_dark_15);
            helper.setText(R.id.status_tv, "已关注");
            helper.setTextColorRes(R.id.status_tv,R.color.color_858585);
        } else {
            helper.setBackgroundRes(R.id.status_tv, R.drawable.frame_kongxin_bright_15);
            helper.setText(R.id.status_tv, "关注Ta");
            helper.setTextColorRes(R.id.status_tv,R.color.colorAccent);
        }
    }


}
