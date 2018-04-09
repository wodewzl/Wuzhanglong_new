package com.beisheng.snatch.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.ShopCatVO;
import com.beisheng.snatch.view.NumberButton;
import com.rey.material.widget.CheckBox;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.pedant.SweetAlert.SweetAlertDialog;


//import ren.qinc.numberbutton.NumberButton;

/**
 * Created by Administrator on 2017/2/13.
 */

public class ShopCatAdapter extends RecyclerBaseAdapter {
    private ShopCatListener shopCatListener;

    public ShopCatListener getShopCatListener() {
        return shopCatListener;
    }

    public void setShopCatListener(ShopCatListener shopCatListener) {
        this.shopCatListener = shopCatListener;
    }

    public interface ShopCatListener {
        void moneyChage();

        void allCheck(boolean isCheck);

        void cartDelete();

        void deleteOne(ShopCatVO.DataBean.ListBean bean);

        void deleteAll();
    }

    public ShopCatAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.shop_cat_adapter_type1);
    }

    @SuppressLint("ResourceType")
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ShopCatVO.DataBean.ListBean dataBean = (ShopCatVO.DataBean.ListBean) model;

        if ("1".equals(dataBean.getIs_valid())) {
            if (!TextUtils.isEmpty(dataBean.getGoods_image()))
                Picasso.with(mActivity).load(dataBean.getGoods_image()).into(helper.getImageView(R.id.shop_img));
            helper.setText(R.id.name_tv, dataBean.getGoods_name());
            NumberButton numberBt = helper.getView(R.id.number_bt);
            numberBt.setmOnTextChangeListener(new NumberButton.OnTextChangeListener() {
                @Override
                public void onTextChange(int count) {
//                    ShopCartActivity activity = (ShopCartActivity) mActivity;
//                    dataBean.setNum(count + "");
//                    activity.addShopCart(dataBean.getCart_id(), count + "");
//                    activity.countPrice();
                }
            });
            numberBt.setBuyMax(Integer.parseInt(dataBean.getMax_count())).setCurrentNumber(BaseCommonUtils.parseInt(dataBean.getNum()));
            CheckBox checkBox = helper.getView(R.id.check_box);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                    dataBean.setCheck(b);
//                    ShopCartActivity activity = (ShopCartActivity) mActivity;
//                    activity.countPrice();
                }
            });
//            final LinearLayout layout = helper.getView(R.id.menu_layout);
//            if (dataBean.isLongClick()) {
//                layout.setVisibility(View.VISIBLE);
//            } else {
//                layout.setVisibility(View.GONE);
//            }
            helper.getTextView(R.id.collect_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 100, R.color.C1, R.color.C1));
            helper.getTextView(R.id.see_same_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 100, R.color.color_yellow, R.color.color_yellow));
            helper.getTextView(R.id.delete_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 100, R.color.colorAccent, R.color.colorAccent));
            helper.setItemChildClickListener(R.id.collect_tv);
            helper.setItemChildClickListener(R.id.see_same_tv);
            helper.setItemChildClickListener(R.id.delete_tv);


        } else if ("0".equals(dataBean.getIs_valid())) {
            if (!TextUtils.isEmpty(dataBean.getGoods_image()))
                Picasso.with(mActivity).load(dataBean.getGoods_image()).into(helper.getImageView(R.id.shop_img));
            helper.setText(R.id.name_tv, dataBean.getGoods_name());
            helper.getTextView(R.id.status_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 30, R.color.C6, R.color.C6));
            helper.setItemChildClickListener(R.id.delete_one_tv);
        } else {
            BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.title_tv), "失效宝贝", dataBean.getValidedCount() + "", "件", R.color.colorAccent, 1.3f);
            helper.setItemChildClickListener(R.id.clean_tv);
        }

        helper.setOnItemChildClickListener(new BGAOnItemChildClickListener() {
            @Override
            public void onItemChildClick(ViewGroup parent, View v, final int position) {
                final ShopCatVO.DataBean.ListBean dataBean = (ShopCatVO.DataBean.ListBean) ShopCatAdapter.this.getItem(position);
                switch (v.getId()) {
                    case R.id.collect_tv:
//                            layout.setVisibility(View.GONE);
//                            dataBean.setLongClick(false);
                        break;
                    case R.id.see_same_tv:
//                            layout.setVisibility(View.GONE);
//                            dataBean.setLongClick(false);
                        break;
                    case R.id.delete_tv:
//                            layout.setVisibility(View.GONE);
//                            dataBean.setLongClick(false);
                        break;
                    case R.id.clean_tv:
                        new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("确定要清空?")
                                .setConfirmText("确定")
                                .setCancelText("取消")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {
                                        shopCatListener.deleteAll();
                                        sDialog.dismissWithAnimation();//直接消失
                                    }
                                })
                                .show();
                        break;

                    case R.id.delete_one_tv:
                        new SweetAlertDialog(mActivity, SweetAlertDialog.WARNING_TYPE)
                                .setTitleText("确定要删除?")
                                .setConfirmText("确定")
                                .setCancelText("取消")
                                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                    @Override
                                    public void onClick(SweetAlertDialog sDialog) {
                                       ShopCatAdapter.this.getData().remove(position);
                                        shopCatListener.deleteOne(dataBean);
                                        ShopCatAdapter.this.notifyDataSetChanged();
                                        sDialog.dismissWithAnimation();//直接消失
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
    public int getItemViewType(int position) {
        ShopCatVO.DataBean.ListBean vo = (ShopCatVO.DataBean.ListBean) this.getItem(position);

        if ("1".equals(vo.getIs_valid())) {
            return R.layout.shop_cat_adapter_type1;
        } else if ("0".equals(vo.getIs_valid())) {
            return R.layout.shop_cat_adapter_type3;
        } else {
            return R.layout.shop_cat_adapter_type2;
        }

    }
}
