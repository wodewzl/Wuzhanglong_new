package com.wzl.feifubao.adapter;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.ShopEvaluationActivity;
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

        if ("1".equals(vo.getType())) {
            helper.setText(R.id.order_name_tv, vo.getOrder_no());
            helper.setText(R.id.order_time_tv, vo.getCreate_time());
        } else if ("3".equals(vo.getType())) {
            //            helper.setText(R.id.shop_status_tv,vo.get)
            BaseCommonUtils.setTextTwoLast(mContext, (TextView) helper.getView(R.id.total_money_tv), "合计：", "￥" + vo.getOrder_money(), R.color.FUBColor2, 1.3f);

          if("0".equals(vo.getOrder_status())){
              helper.setText(R.id.shop_status_tv,"待付款");
          }       else if("1".equals(vo.getOrder_status())){
              helper.setText(R.id.shop_status_tv,"待发货");
          }else if("2".equals(vo.getOrder_status())){
              helper.setText(R.id.shop_status_tv,"待收货");
          }else if("3".equals(vo.getOrder_status())){
              helper.setText(R.id.shop_status_tv,"已收货");

          }else if("4".equals(vo.getOrder_status())){
//              helper.setText(R.id.shop_status_tv,"待发货");
          } else if ("5".equals(vo.getOrder_status())) {
              helper.setText(R.id.shop_status_tv,"已关闭");
          }
            helper.getTextView(R.id.action_tv_01).setVisibility(View.GONE);
            helper.getTextView(R.id.action_tv_02).setVisibility(View.GONE);
            helper.getTextView(R.id.action_tv_03).setVisibility(View.GONE);
            helper.getTextView(R.id.action_tv_04).setVisibility(View.GONE);
            helper.getTextView(R.id.action_tv_05).setVisibility(View.GONE);

            helper.getTextView(R.id.action_tv_07).setVisibility(View.GONE);


            for (int i = 0; i < vo.getMember_operation().size(); i++) {
                if ("close".equals(vo.getMember_operation().get(i).getNo())) {
                    helper.getTextView(R.id.action_tv_01).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                    helper.getTextView(R.id.action_tv_01).setVisibility(View.VISIBLE);
                } else {
//                    helper.getTextView(R.id.action_tv_01).setVisibility(View.GONE);
                }
                if ("pay".equals(vo.getMember_operation().get(i).getNo())) {
                    helper.getTextView(R.id.action_tv_02).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                    helper.getTextView(R.id.action_tv_02).setVisibility(View.VISIBLE);
                } else {
//                    helper.getTextView(R.id.action_tv_02).setVisibility(View.GONE);
                }
                if ("getdelivery".equals(vo.getMember_operation().get(i).getNo())) {
                    helper.getTextView(R.id.action_tv_03).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                    helper.getTextView(R.id.action_tv_03).setVisibility(View.VISIBLE);
                } else {
//                    helper.getTextView(R.id.action_tv_03).setVisibility(View.GONE);
                }
                if ("logistics".equals(vo.getMember_operation().get(i).getNo())) {
                    helper.getTextView(R.id.action_tv_04).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                    helper.getTextView(R.id.action_tv_04).setVisibility(View.VISIBLE);
                } else {
//                    helper.getTextView(R.id.action_tv_04).setVisibility(View.GONE);
                }
                if ("delete_order".equals(vo.getMember_operation().get(i).getNo())) {
                    helper.getTextView(R.id.action_tv_05).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                    helper.getTextView(R.id.action_tv_05).setVisibility(View.VISIBLE);
                } else {
//                    helper.getTextView(R.id.action_tv_05).setVisibility(View.GONE);
                }
                if ("refund".equals(vo.getMember_operation().get(i).getNo())) {
                    helper.getTextView(R.id.action_tv_07).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.FUBColor2, R.color.C3));
                    helper.getTextView(R.id.action_tv_07).setVisibility(View.VISIBLE);
                } else {
//                    helper.getTextView(R.id.action_tv_07).setVisibility(View.GONE);
                }


                helper.setItemChildClickListener(R.id.action_tv_01);
                helper.setItemChildClickListener(R.id.action_tv_02);
                helper.setItemChildClickListener(R.id.action_tv_03);
                helper.setItemChildClickListener(R.id.action_tv_04);
                helper.setItemChildClickListener(R.id.action_tv_05);
                helper.setItemChildClickListener(R.id.action_tv_07);

                helper.setOnItemChildClickListener(new BGAOnItemChildClickListener() {
                    @Override
                    public void onItemChildClick(ViewGroup viewGroup, View v, int i) {
                        Bundle bundle = new Bundle();
                        switch (v.getId()) {
                            case R.id.action_tv_01:
                                new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE)
                                        .setTitleText("确定要取消该订单吗?")
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
                            default:
                                break;
                        }
                    }
                });


            }
        } else {

            if (!TextUtils.isEmpty(vo.getPic_cover_small()))
                Picasso.with(mActivity).load(vo.getPic_cover_small()).into(helper.getImageView(R.id.img));
            helper.setText(R.id.name_tv, vo.getGoods_name());
            helper.setText(R.id.price_tv, "￥" + vo.getPrice());
            helper.setText(R.id.desc_tv, "规格没反？？？？？");
            helper.setText(R.id.count_tv, "x" + vo.getNum());
            helper.getTextView(R.id.back_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.C3_1, R.color.C1));
            if("3".equals(vo.getOrder_status())){
                helper.setText(R.id.back_tv,"我要评价");
            }else {
                helper.setText(R.id.back_tv,"退货/退款");
            }
            helper.getTextView(R.id.back_tv).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if("3".equals(vo.getOrder_status())){
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("shop",vo);
                        mActivity.open(ShopEvaluationActivity.class,bundle,0);
                    }else {

                    }
                }
            });
        }


    }

    @Override
    public int getItemViewType(int position) {
        if (mData.size() == 0) {
            return super.getItemViewType(position);
        }

        OrderVO vo = (OrderVO) mData.get(position);
        if ("1".equals(vo.getType())) {
            return R.layout.order_adapter_type1;
        } else if ("3".equals(vo.getType())) {
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
