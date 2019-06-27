package com.maitian.starmily.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.FindTopicVO;
import com.maitian.starmily.model.MessageVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class FindTopicAdapter extends RecyclerBaseAdapter {
    public FindTopicAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.find_topic_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        FindTopicVO.ObjBean.ListBean bean = (FindTopicVO.ObjBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getQiNiuAddress())){
            if (bean.getQiNiuAddress().contains("http://")) {
                Picasso.with(mContext).load( bean.getQiNiuAddress()).into(helper.getImageView(R.id.item_img));
            }else {
                Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + bean.getQiNiuAddress()).into(helper.getImageView(R.id.item_img));
            }
        }
        helper.setText(R.id.title_tv, bean.getEventTitle());
    }

}
