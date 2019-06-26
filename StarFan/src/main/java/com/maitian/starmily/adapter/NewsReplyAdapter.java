package com.maitian.starmily.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.DiscussReplyBean;
import com.maitian.starmily.model.MessageVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.DateUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class NewsReplyAdapter extends RecyclerBaseAdapter {
    private int type;

    public NewsReplyAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.news_reply_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        DiscussReplyBean.ObjBean.ListBean bean = (DiscussReplyBean.ObjBean.ListBean) model;
        if (type == 1) {
            if (!TextUtils.isEmpty(bean.getIcon_url())) {
                if (bean.getIcon_url().contains("http://")) {
                    Picasso.with(mContext).load(bean.getIcon_url()).error(R.drawable.user_icon_def).into(helper.getImageView(R.id.head_img));
                } else {
                    Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + bean.getIcon_url()).error(R.drawable.user_icon_def).into(helper.getImageView(R.id.head_img));
                }
            }
            helper.setText(R.id.name_tv, bean.getNickname());
            helper.setText(R.id.content_tv, bean.getReplyMsg());
            helper.setText(R.id.time_tv, DateUtils.parseDateDayAndHour(bean.getCreateTime() + ""));
            helper.setText(R.id.content_tv, bean.getReplyMsg());
            helper.setText(R.id.like_count_tv, bean.getLikeCount() + "");
            if (bean.getLikeStatus() == 0) {
                helper.getTextView(R.id.like_count_tv).setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_normal_small, 0, 0, 0);
            } else {
                helper.getTextView(R.id.like_count_tv).setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_press_small, 0, 0, 0);
            }
        } else if (type == 2) {
            if (!TextUtils.isEmpty(bean.getToIcon())) {
                if (bean.getToIcon().contains("http://")) {
                    Picasso.with(mContext).load(bean.getToIcon()).error(R.drawable.user_icon_def).into(helper.getImageView(R.id.head_img));
                } else {
                    Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + bean.getToIcon()).error(R.drawable.user_icon_def).into(helper.getImageView(R.id.head_img));
                }
            }
            helper.setText(R.id.name_tv, bean.getToNickname());
            helper.setText(R.id.content_tv, bean.getReplyMsg());
            helper.setText(R.id.time_tv, DateUtils.parseDateDayAndHour(bean.getCreateTime() + ""));
            helper.setText(R.id.content_tv, bean.getReplyMsg());
            helper.setText(R.id.like_count_tv, bean.getLikeCount() + "");
            if (bean.getLikeStatus() == 0) {
                helper.getTextView(R.id.like_count_tv).setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_normal_small, 0, 0, 0);
            } else {
                helper.getTextView(R.id.like_count_tv).setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_press_small, 0, 0, 0);
            }
        } else if (type == 3) {
            if (!TextUtils.isEmpty(bean.getToIcon())) {
                if (bean.getToIcon().contains("http://")) {
                    Picasso.with(mContext).load(bean.getToIcon()).error(R.drawable.user_icon_def).into(helper.getImageView(R.id.head_img));
                } else {
                    Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + bean.getToIcon()).error(R.drawable.user_icon_def).into(helper.getImageView(R.id.head_img));
                }
            }
            helper.setText(R.id.name_tv, bean.getToNickname());
            helper.setText(R.id.content_tv, bean.getReplyMsg());
            helper.setText(R.id.time_tv, DateUtils.parseDateDayAndHour(bean.getCreateTime() + ""));
            helper.setText(R.id.content_tv, bean.getReplyMsg());
            helper.setText(R.id.like_count_tv, bean.getLikeCount() + "");
        }

        helper.setItemChildClickListener(R.id.like_count_tv);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
