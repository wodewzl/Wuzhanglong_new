package com.maitian.starmily.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.NewsBean;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.DateUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class NewsAdapter extends RecyclerBaseAdapter {
    public NewsAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.news_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        NewsBean.ObjBean.ListBean bean = (NewsBean.ObjBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getIconUrl())) {
            if (bean.getIconUrl().contains("http:")) {
                Picasso.with(mContext).load(bean.getIconUrl()).into(helper.getImageView(R.id.head_img));
            } else {
                Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + bean.getIconUrl()).into(helper.getImageView(R.id.head_img));
            }
        }
        if (!TextUtils.isEmpty(bean.getAdImg())) {
            if (bean.getAdImg().contains("http:")) {
                Picasso.with(mContext).load(bean.getIconUrl()).into(helper.getImageView(R.id.item_iv));
            } else {
                Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + bean.getAdImg()).into(helper.getImageView(R.id.item_iv));
            }
        }
        helper.setText(R.id.time_tv, DateUtils.getStandardDate(bean.getCreateTime() + ""));
        helper.setText(R.id.title_tv, bean.getTitle());
        helper.setText(R.id.desc_tv, bean.getContentDesc());
        helper.setText(R.id.like_count_tv, bean.getLikeCount() + "");
        helper.setText(R.id.replay_count_tv, bean.getCommentReplyCount() + "");
        if (bean.getStatus() == 1) {
            helper.getTextView(R.id.like_count_tv).setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_press, 0, 0, 0);
        } else {
            helper.getTextView(R.id.like_count_tv).setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_normal, 0, 0, 0);
        }
        helper.setText(R.id.read_count_tv, bean.getCount() + "");
        if (bean.getTop() == 1) {
            helper.getView(R.id.top_tv).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.top_tv).setVisibility(View.GONE);
        }
        if (bean.getHot() == 1) {
            helper.getView(R.id.hot_tv).setVisibility(View.VISIBLE);
        } else {
            helper.getView(R.id.hot_tv).setVisibility(View.GONE);
        }
    }
}
