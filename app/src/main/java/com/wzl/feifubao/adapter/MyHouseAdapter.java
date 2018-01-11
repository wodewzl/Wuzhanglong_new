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
        if (TextUtils.isEmpty(bean.getHouse_pic()))
        Picasso.with(mContext).load(bean.getHouse_pic()).into(houseImg);
        helper.setText(R.id.title_tv,bean.getHouse_title());
        helper.setText(R.id.desc_tv, bean.getHouse_name()+"/"+bean.getApartment() + "/" + bean.getHouse_area() + "㎡" + "/" + bean.getHouse_face());
//        helper.setText(R.id.address_tv,bean.getArea());
        helper.setText(R.id.money_tv,bean.getHouse_price()+"/月");
        TextView editTv= helper.getTextView(R.id.edit_tv);
        editTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity,30,R.color.colorAccent,R.color.C1));
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
