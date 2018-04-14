package com.beisheng.snatch.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.PayTypeVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class PayTypeAdapter extends RecyclerBaseAdapter {
    public PayTypeAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.pay_type_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        PayTypeVO.DataBean.ListBean bean = (PayTypeVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getPayment_icon()))
            Picasso.with(mContext).load(bean.getPayment_icon()).into(helper.getImageView(R.id.pay_img));
        helper.setText(R.id.pay_type_tv, bean.getPayment_name());
        helper.setChecked(R.id.check_box,bean.isCheck());
        helper.setItemChildCheckedChangeListener(R.id.check_box);


    }

}
