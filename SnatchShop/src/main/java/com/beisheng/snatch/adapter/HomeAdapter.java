package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.ShopVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/8.
 */

public class HomeAdapter extends RecyclerBaseAdapter {

    public HomeAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.home_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ShopVO.DataBean.ListBean bean = (ShopVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getGoods_image()))
            Picasso.with(mContext).load(bean.getGoods_image()).into(helper.getImageView(R.id.img));
        helper.setText(R.id.name, bean.getGoods_name());
        ProgressBar pb = helper.getView(R.id.progress_bar);
        pb.setProgress(BaseCommonUtils.parseInt(bean.getPercent()));
        TextView tv=helper.getTextView(R.id.progress_tv);
        BaseCommonUtils.setTextThree(mContext,tv,"剩余：",bean.getRemain_count(),"次",R.color.colorAccent,1.3f);
    }
}
