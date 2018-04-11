package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.MyScortVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class MyScortAdapter extends RecyclerBaseAdapter {

    public MyScortAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_scort_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MyScortVO.DataBean.CouponListBean vo = (MyScortVO.DataBean.CouponListBean) model;
        BaseCommonUtils.setTextTwoLast(mActivity, helper.getTextView(R.id.tv_01), vo.getCoupon_name(), "(消耗积分：" + vo.getExchange_points() + "分", R.color.C5, 0.8f);
        helper.setText(R.id.tv_02, "有效期：" + vo.getValid_days() + "天");
        helper.setText(R.id.tv_03, "剩余数量：" + vo.getRemain_count() + "/" + vo.getCount()+")");
    }

}
