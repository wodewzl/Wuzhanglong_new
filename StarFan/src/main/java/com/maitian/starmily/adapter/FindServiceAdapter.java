package com.maitian.starmily.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.FindServiceBean;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class FindServiceAdapter extends RecyclerBaseAdapter {
    public FindServiceAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.find_service_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        FindServiceBean.ObjBean.ListBean bean= (FindServiceBean.ObjBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getImgUrl())){
            if (bean.getImgUrl().contains("http://")) {
                Picasso.with(mContext).load(bean.getImgUrl()).into(helper.getImageView(R.id.item_iv));
            }else {
                Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + bean.getImgUrl()).into(helper.getImageView(R.id.item_iv));
            }
        }
        helper.setText(R.id.name_tv,bean.getName());
    }
}
