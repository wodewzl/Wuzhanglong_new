package com.maitian.starmily.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.MessageVO;
import com.maitian.starmily.model.PromotionsBean;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.DateUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class PromotionsAdapter extends RecyclerBaseAdapter {
    public PromotionsAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.promotions_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        PromotionsBean.ObjBean.ListBean bean = (PromotionsBean.ObjBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getQiNiuAddress())) {
            if (bean.getQiNiuAddress().contains("http:")) {
                Picasso.with(mContext).load(bean.getQiNiuAddress()).into(helper.getImageView(R.id.item_iv));
            } else {
                Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + bean.getQiNiuAddress()).into(helper.getImageView(R.id.item_iv));
            }
        }

        helper.setText(R.id.time_tv,bean.getEventTitle());
        helper.setText(R.id.time_tv,"截止时间："+ DateUtils.parseDateDay(bean.getOfflineTime())+" 至 "+DateUtils.parseDateDay(bean.getOfflineTime()));

    }


}
