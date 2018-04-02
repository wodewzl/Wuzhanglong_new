package com.beisheng.snatch.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.AddressVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.mode.EBMessageVO;


import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Administrator on 2017/2/13.
 */

public class AddressAdapter extends RecyclerBaseAdapter<AddressVO.DataBean> {
    private AddressVO.DataBean mDefalutVO;


    public AddressAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.address_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        AddressVO.DataBean vo = (AddressVO.DataBean) model;
        helper.setText(R.id.name_tv, vo.getConsigner());
        helper.setText(R.id.phone_tv, vo.getMobile());
        helper.setText(R.id.address_tv, vo.getAddress_info() + vo.getAddress());
        if ("1".equals(vo.getIs_default())) {
            helper.setImageResource(R.id.check_img, R.drawable.check_select);
            mDefalutVO = vo;
        } else {
            helper.setImageResource(R.id.check_img, R.drawable.check_normal);
        }

        helper.setItemChildClickListener(R.id.delete_tv);
        helper.setItemChildClickListener(R.id.edit_text);
        helper.setItemChildClickListener(R.id.check_img);
        helper.setOnItemChildClickListener(new BGAOnItemChildClickListener() {
            @Override
            public void onItemChildClick(ViewGroup viewGroup, View v, final int i) {
                final AddressVO.DataBean vo = (AddressVO.DataBean) mData.get(i);
                switch (v.getId()) {
                    case R.id.delete_tv:

                        new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("确定要删除该地址吗?")
//                            .setContentText("删除成功")
                                .setConfirmText("确定")
                                .setCancelText("取消")

                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {
                                        sDialog.dismissWithAnimation();//直接消失
                                        EBMessageVO ebMessageVO = new EBMessageVO("address_delete", vo.getId());
                                        EventBus.getDefault().post(ebMessageVO);
                                        mData.remove(i);
//                                        AddressRAdapter.this.notifyDataSetChanged();
                                    }
                                })
                                .show();

                        break;
                    case R.id.edit_text:

                        Intent intent = new Intent();
                        intent.putExtra("address", (Serializable) vo);
//                        intent.setClass(mActivity, AddressEditActivity.class);
                        mActivity.startActivity(intent);
                        break;
                    case R.id.check_img:
                        if ("1".equals(vo.getIs_default()))
                            return;

                        new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("确定设为默认地址吗?")
                                .setConfirmText("确定")
                                .setCancelText("取消")

                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {
                                        sDialog.dismissWithAnimation();//直接消失
                                        EBMessageVO ebMessageVO = new EBMessageVO("address_defalut", vo.getId());
                                        EventBus.getDefault().post(ebMessageVO);
                                        vo.setIs_default("1");
                                        if (mDefalutVO != null)
                                            mDefalutVO.setIs_default("0");
                                        notifyDataSetChanged();
                                    }
                                })
                                .show();


                        break;
                    default:
                        break;
                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.address_adapter;
    }
}
