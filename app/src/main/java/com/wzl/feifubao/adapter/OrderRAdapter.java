package com.wzl.feifubao.adapter;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.OrderVO;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Administrator on 2017/2/13.
 */

public class OrderRAdapter extends RecyclerBaseAdapter<OrderVO> {
    onTypeClickListener onTypeClickListener;

    public interface onTypeClickListener {
        //type 1 if_cancel 2 if_payment 3 if_receive 4 if_deliver 5 if_delete 6 if_evaluation 7if_refund_cancel
        void typeClick(String type, OrderVO vo);
    }


    public OrderRAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.order_adapter_type2);
    }

    @Override
    protected void fillData(BGAViewHolderHelper helper, int position, Object model) {
        if (mData.size() > 0) {
            super.fillData(helper, position, model);
        } else {
            mBaseAdapterTv = helper.getTextView(R.id.adapter_no_content_tv);
            mBaseAdapterTv.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.base_no_content, 0, 0);
            mBaseAdapterTv.setText("暂无相关订单哦");
        }

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, final Object model) {
        final OrderVO vo = (OrderVO) model;
        if (vo.isOrder()) {
            helper.setText(R.id.shop_people_name_tv, vo.getStore_name());
            helper.setText(R.id.order_state, vo.getState_desc());
        } else if (vo.getExtend_order_goods() != null) {
            BaseCommonUtils.setTextThree(mContext, (TextView) helper.getView(R.id.total_count_tv), "共：", vo.getGoods_count(), " 件商品", R.color.C4, 1.2f);
            BaseCommonUtils.setTextTwoLast(mContext, (TextView) helper.getView(R.id.total_money_tv), "合计：", "￥" + vo.getOrder_amount(), R.color.C4, 1.2f);
            BaseCommonUtils.setTextThree(mContext, (TextView) helper.getView(R.id.other_moeny_tv), "(含运费：", "￥" + vo.getShipping_fee(), "）", R.color.C4, 1.2f);

            if ("1".equals(vo.getIf_cancel())) {
                helper.getTextView(R.id.action_tv_01).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                helper.getTextView(R.id.action_tv_01).setVisibility(View.VISIBLE);
            } else {
                helper.getTextView(R.id.action_tv_01).setVisibility(View.GONE);
            }
            if ("1".equals(vo.getIf_payment())) {
                helper.getTextView(R.id.action_tv_02).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                helper.getTextView(R.id.action_tv_02).setVisibility(View.VISIBLE);
            } else {
                helper.getTextView(R.id.action_tv_02).setVisibility(View.GONE);
            }
            if ("1".equals(vo.getIf_receive())) {
                helper.getTextView(R.id.action_tv_03).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                helper.getTextView(R.id.action_tv_03).setVisibility(View.VISIBLE);
            } else {
                helper.getTextView(R.id.action_tv_03).setVisibility(View.GONE);
            }
            if ("1".equals(vo.getIf_deliver())) {
                helper.getTextView(R.id.action_tv_04).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                helper.getTextView(R.id.action_tv_04).setVisibility(View.VISIBLE);
            } else {
                helper.getTextView(R.id.action_tv_04).setVisibility(View.GONE);
            }
            if ("1".equals(vo.getIf_delete())) {
                helper.getTextView(R.id.action_tv_05).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                helper.getTextView(R.id.action_tv_05).setVisibility(View.VISIBLE);
            } else {
                helper.getTextView(R.id.action_tv_05).setVisibility(View.GONE);
            }

            if ("1".equals(vo.getIf_evaluation())) {
                helper.getTextView(R.id.action_tv_06).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                helper.getTextView(R.id.action_tv_06).setVisibility(View.VISIBLE);
            } else {
                helper.getTextView(R.id.action_tv_06).setVisibility(View.GONE);
            }

            if ("1".equals(vo.getIf_refund_cancel())) {
                helper.getTextView(R.id.action_tv_07).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                helper.getTextView(R.id.action_tv_07).setVisibility(View.VISIBLE);
            } else {
                helper.getTextView(R.id.action_tv_07).setVisibility(View.GONE);
            }

            helper.setItemChildClickListener(R.id.action_tv_01);
            helper.setItemChildClickListener(R.id.action_tv_02);
            helper.setItemChildClickListener(R.id.action_tv_03);
            helper.setItemChildClickListener(R.id.action_tv_04);
            helper.setItemChildClickListener(R.id.action_tv_05);
            helper.setItemChildClickListener(R.id.action_tv_06);
            helper.setItemChildClickListener(R.id.action_tv_07);
            helper.setOnItemChildClickListener(new BGAOnItemChildClickListener() {
                @Override
                public void onItemChildClick(ViewGroup viewGroup, View v, int i) {
                    Bundle bundle = new Bundle();
                    switch (v.getId()) {
                        case R.id.action_tv_01:
                            new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("确定要取消该订单吗?")
//                            .setContentText("删除成功")
                                    .setConfirmText("确定")
                                    .setCancelText("取消")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            onTypeClickListener.typeClick("1", vo);
                                            sDialog.dismissWithAnimation();//直接消失
                                        }
                                    })
                                    .show();
                            break;
                        case R.id.action_tv_02:
                            onTypeClickListener.typeClick("2", vo);

                            break;
                        case R.id.action_tv_03:
                            new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("确定收到货了吗?")
//                            .setContentText("删除成功")
                                    .setConfirmText("确定")
                                    .setCancelText("取消")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            onTypeClickListener.typeClick("3", vo);
                                            sDialog.dismissWithAnimation();//直接消失
                                        }
                                    })
                                    .show();
                            break;
                        case R.id.action_tv_04:
                            onTypeClickListener.typeClick("4", vo);
                            break;
                        case R.id.action_tv_05:
                            new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("确定要删除该订单吗?")
//                            .setContentText("删除成功")
                                    .setConfirmText("确定")
                                    .setCancelText("取消")
                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            onTypeClickListener.typeClick("5", vo);
                                            sDialog.dismissWithAnimation();//直接消失
                                        }
                                    })
                                    .show();
                            break;
                        case R.id.action_tv_06:

//                            bundle.putString("url", vo.getEvaluation_url());
//                            mActivity.open(WebViewActivity.class, bundle, 0);
                            break;
                        case R.id.action_tv_07:
//                            bundle.putString("url", vo.getRefund_cancel_url());
//                            mActivity.open(WebViewActivity.class, bundle, 0);
                            break;
                        default:
                            break;
                    }
                }
            });

        } else {
            Picasso.with(mContext).load(vo.getGoods_image_url()).placeholder(R.drawable.base_no_content).into(helper.getImageView(R.id.img));
            helper.setText(R.id.name_tv, vo.getGoods_name());
            helper.setText(R.id.price_tv, "￥" + vo.getGoods_price());
            helper.setText(R.id.count_tv, "X" + vo.getGoods_num());
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.size() == 0) {
            return super.getItemViewType(position);
        }

        OrderVO vo = (OrderVO) mData.get(position);
        if (vo.isOrder()) {
            return R.layout.order_adapter_type1;
        } else if (vo.getExtend_order_goods() != null) {
            return R.layout.order_adapter_type3;
        } else {
            return R.layout.order_adapter_type2;
        }
    }

    public OrderRAdapter.onTypeClickListener getOnTypeClickListener() {
        return onTypeClickListener;
    }

    public void setOnTypeClickListener(OrderRAdapter.onTypeClickListener onTypeClickListener) {
        this.onTypeClickListener = onTypeClickListener;
    }
}
