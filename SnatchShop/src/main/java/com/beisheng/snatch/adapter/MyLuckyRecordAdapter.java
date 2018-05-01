package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.MyLuckyRecordVO;
import com.rey.material.widget.CheckBox;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class MyLuckyRecordAdapter extends RecyclerBaseAdapter {
    private String type;
    private MyLuckyRecordListener myLuckyRecordListener;

    public interface MyLuckyRecordListener {
        void count();
    }

    public MyLuckyRecordAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_lucky_record_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        final MyLuckyRecordVO.DataBean.ListBean bean = (MyLuckyRecordVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getGoods_picture()))
            Picasso.with(mActivity).load(bean.getGoods_picture()).into(helper.getImageView(R.id.img));
        helper.setText(R.id.tv_01, bean.getGoods_name());
        helper.setText(R.id.tv_02, "期号：" + bean.getIssue_no() + "期");
        if ("0".equals(this.getType())) {
            helper.getView(R.id.check_box).setVisibility(View.VISIBLE);
            helper.getView(R.id.tv_04).setVisibility(View.GONE);
            if (bean.isCheck()) {
                helper.setChecked(R.id.check_box, true);
            } else {
                helper.setChecked(R.id.check_box, false);
            }
            BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.tv_03), "您抢购了：", bean.getBuy_total(), "次", R.color.colorAccent, 1.3f);

            if ("1".equals(bean.getOvertime())) {
                helper.setVisibility(R.id.status_img, View.VISIBLE);
                helper.setImageResource(R.id.status_img, R.drawable.show_fail);
                helper.setVisibility(R.id.check_box, View.GONE);
            } else {
                helper.setVisibility(R.id.status_img, View.GONE);
                helper.setVisibility(R.id.check_box, View.VISIBLE);
            }
        } else {
            helper.getView(R.id.check_box).setVisibility(View.GONE);
            helper.getView(R.id.tv_04).setVisibility(View.VISIBLE);
            helper.setText(R.id.tv_03, bean.getDelivery_status_text());
            helper.setVisibility(R.id.status_img, View.GONE);
            if ("1".equals(bean.getIs_virtual())) {
                helper.setText(R.id.tv_04, "查看卡密");
                helper.setVisibility(R.id.tv_04, View.VISIBLE);
            } else {
                if ("0".equals(bean.getDelivery_status())) {
                    helper.setVisibility(R.id.tv_04, View.GONE);
                } else if ("1".equals(bean.getDelivery_status())) {
                    helper.setText(R.id.tv_04, "查看物流详情");
                    helper.setVisibility(R.id.tv_04, View.VISIBLE);
                } else if ("2".equals(bean.getDelivery_status())) {
                    if ("0".equals(bean.getIs_evaluate())) {
                        helper.setVisibility(R.id.tv_04, View.VISIBLE);
                        helper.setText(R.id.tv_04, "晒单有礼");
                        helper.setVisibility(R.id.tv_04, View.VISIBLE);
                        helper.setVisibility(R.id.status_img, View.VISIBLE);
                        helper.setImageResource(R.id.status_img, R.drawable.show_scuss);
                    } else {
                        helper.setVisibility(R.id.status_img, View.GONE);
                        helper.setVisibility(R.id.tv_04, View.GONE);
                    }
                }
            }


            helper.setItemChildClickListener(R.id.tv_04);

        }

        CheckBox checkBox = helper.getView(R.id.check_box);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                bean.setCheck(b);
//                    ShopCartActivity activity = (ShopCartActivity) mActivity;
//                    activity.countPrice();
                myLuckyRecordListener.count();
            }
        });
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MyLuckyRecordListener getMyLuckyRecordListener() {
        return myLuckyRecordListener;
    }

    public void setMyLuckyRecordListener(MyLuckyRecordListener myLuckyRecordListener) {
        this.myLuckyRecordListener = myLuckyRecordListener;
    }
}
