package com.maitian.starmily.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.FindBean;
import com.maitian.starmily.model.MessageVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.DateUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class FindAdapter extends RecyclerBaseAdapter {
    public FindAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.find_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        FindBean.ObjBean.ListBean bean= (FindBean.ObjBean.ListBean) model;
//        helper.setText(R.id.title_tv,bean.getTitle());
        if (!TextUtils.isEmpty(bean.getPicturesAddress())){
            if (bean.getPicturesAddress().contains("http://")) {
                Picasso.with(mContext).load(bean.getPicturesAddress()).into(helper.getImageView(R.id.item_iv));
            }else {
                Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + bean.getPicturesAddress()).into(helper.getImageView(R.id.item_iv));
            }
        }
        helper.setText(R.id.content_tv, bean.getEventTitle());
    }

}
