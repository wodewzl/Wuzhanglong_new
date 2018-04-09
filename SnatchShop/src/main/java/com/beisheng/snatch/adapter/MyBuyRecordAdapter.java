package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.MyBuyRecordVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class MyBuyRecordAdapter extends RecyclerBaseAdapter {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MyBuyRecordAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_buy_record_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        final MyBuyRecordVO.DataBean.ListBean bean = (MyBuyRecordVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getGoods_image()))
            Picasso.with(mActivity).load(bean.getGoods_image()).into(helper.getImageView(R.id.img));
        helper.setText(R.id.tv_01, bean.getGoods_name());
        helper.setText(R.id.tv_02, "期号：" + bean.getIssue_no() + "期");
        BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.tv_03), "您抢购了：", bean.getTotal_buy(), "次", R.color.colorAccent, 1.3f);

        if ("1".equals(bean.getPrise_status())) {
            helper.setText(R.id.status_tv, "本期剩余");
            BaseCommonUtils.setTextTwoBefore(mContext,helper.getTextView(R.id.tv_04),bean.getRemain_count(),"次",R.color.colorAccent,1.3f);
        } else if ("".equals(bean.getPrise_status())) {
            helper.setText(R.id.status_tv, "倒计时中");
        } else if ("".equals(bean.getPrise_status())) {

        } else {

        }
    }

}
