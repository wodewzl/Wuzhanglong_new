package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.MyHouseActivity;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.MyHouseVO;

import java.util.HashMap;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by wuzhanglong on 2017/12/30.
 */

public class MyHouseAdapter extends RecyclerBaseAdapter<MyHouseVO.DataBean.HouseBean> {

    public MyHouseAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_house_adapter);
    }
    @Override
    public void initData(BGAViewHolderHelper helper, final int position, Object model) {
        final MyHouseVO.DataBean.HouseBean bean= (MyHouseVO.DataBean.HouseBean) model;
        ImageView houseImg = helper.getImageView(R.id.house_img);
        if (!TextUtils.isEmpty(bean.getHouse_pic()))
        Picasso.with(mContext).load(bean.getHouse_pic()).into(houseImg);
        helper.setText(R.id.title_tv,bean.getHouse_title());
        helper.setText(R.id.desc_tv, bean.getApartment() + "/" + bean.getHouse_area() + "㎡" + "/" + bean.getHouse_face());
//        helper.setText(R.id.address_tv,bean.getArea());
        helper.setText(R.id.money_tv,bean.getHouse_price()+"/月");

        helper.getTextView(R.id.language1_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor12, R.color.FUBColor12));

        if (bean.getHouse_language_names() != null && bean.getHouse_language_names().size() > 0) {
            if (bean.getHouse_language_names().size() == 1) {
                helper.getTextView(R.id.language2_tv).setText(bean.getHouse_language_names().get(0));
                helper.getTextView(R.id.language2_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language2_tv).setVisibility(View.VISIBLE);
                helper.getTextView(R.id.language3_tv).setVisibility(View.GONE);
                helper.getTextView(R.id.language4_tv).setVisibility(View.GONE);
            }
            if (bean.getHouse_language_names().size() == 2) {
                helper.getTextView(R.id.language2_tv).setText(bean.getHouse_language_names().get(0));
                helper.getTextView(R.id.language3_tv).setText(bean.getHouse_language_names().get(1));
                helper.getTextView(R.id.language2_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language2_tv).setVisibility(View.VISIBLE);
                helper.getTextView(R.id.language3_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language3_tv).setVisibility(View.VISIBLE);
                helper.getTextView(R.id.language4_tv).setVisibility(View.GONE);
            }
            if (bean.getHouse_language_names().size() == 3) {
                helper.getTextView(R.id.language2_tv).setText(bean.getHouse_language_names().get(0));
                helper.getTextView(R.id.language3_tv).setText(bean.getHouse_language_names().get(1));
                helper.getTextView(R.id.language4_tv).setText(bean.getHouse_language_names().get(2));

                helper.getTextView(R.id.language2_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language2_tv).setVisibility(View.VISIBLE);
                helper.getTextView(R.id.language3_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language3_tv).setVisibility(View.VISIBLE);
                helper.getTextView(R.id.language4_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language4_tv).setVisibility(View.VISIBLE);
            }

        } else {
            helper.getTextView(R.id.language2_tv).setVisibility(View.GONE);
            helper.getTextView(R.id.language3_tv).setVisibility(View.GONE);
            helper.getTextView(R.id.language4_tv).setVisibility(View.GONE);
        }

        TextView editTv= helper.getTextView(R.id.edit_tv);
        editTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity,30,R.color.colorAccent,R.color.C1));
        editTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHouseActivity activity= (MyHouseActivity) mActivity;
                activity.editHouse(bean);
            }
        });
        TextView payTv= helper.getTextView(R.id.pay_tv);
        if("0".equals(bean.getPay_status())){
            payTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity,30,R.color.colorAccent,R.color.C1));
            payTv.setVisibility(View.VISIBLE);
        }else {
            payTv.setVisibility(View.GONE);
        }

        helper.getTextView(R.id.pay_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyHouseActivity activity= (MyHouseActivity) mActivity;
                activity.showPayDialog(bean);
            }
        });
        TextView deleteTv= helper.getTextView(R.id.delete_tv);
        deleteTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity,30,R.color.FUBColor3,R.color.C1));
        deleteTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(mActivity, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要删除?")
//                            .setContentText("删除成功")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                HashMap<String, Object> map = new HashMap<>();
                                map.put("house_id", bean.getHouse_id());
                                MyHouseActivity activity= (MyHouseActivity) mActivity;
                                HttpGetDataUtil.post(activity, Constant.DELETE_HOUSE_URL, map, activity);
                                MyHouseAdapter.this.getData().remove(position);
                                MyHouseAdapter.this.notifyDataSetChanged();
                                sDialog.dismissWithAnimation();//直接消失
                            }
                        })
                        .show();


            }
        });
    }

}
