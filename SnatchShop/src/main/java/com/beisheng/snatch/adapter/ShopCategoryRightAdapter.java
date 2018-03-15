package com.beisheng.snatch.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ProgressBar;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.ShopCategoryRightVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class ShopCategoryRightAdapter extends RecyclerBaseAdapter {
    public ShopCategoryRightAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.shop_category_right_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ShopCategoryRightVO.DataBean.ListBean bean = (ShopCategoryRightVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getGoods_image()))
            Picasso.with(mContext).load(bean.getGoods_image()).into(helper.getImageView(R.id.shop_img));
        helper.setText(R.id.title_tv,bean.getGoods_name());
        ProgressBar pb = helper.getView(R.id.progress_bar);
        pb.setProgress(BaseCommonUtils.parseInt(bean.getPercent()));
        helper.setText(R.id.total_count_tv,"总需："+bean.getTotal_count()+"人次");
        BaseCommonUtils.setTextThree(mContext,helper.getTextView(R.id.remain_count_tv),"剩余：",bean.getRemain_count(),"人次",R.color.colorAccent,1.3f);
    }


}
