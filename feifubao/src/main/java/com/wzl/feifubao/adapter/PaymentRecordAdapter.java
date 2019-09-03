package com.wzl.feifubao.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.PaymentRecordsActivity;
import com.wzl.feifubao.mode.PaymentRecordsVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/29.
 */


public class PaymentRecordAdapter extends RecyclerBaseAdapter<PaymentRecordsVO.DataBeanX> {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PaymentRecordAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.payment_record_adapter_type2);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        final PaymentRecordsVO.DataBeanX vo = (PaymentRecordsVO.DataBeanX) model;
        if (vo.getLists() != null) {
            helper.setText(R.id.title_tv, vo.getDatetime());
        } else {
            helper.setText(R.id.title_tv, vo.getSku_name());
            helper.setText(R.id.time_tv, vo.getCreate_time());

            helper.setText(R.id.money_tv, vo.getPrice() );
            if ("1".equals(type)) {
                helper.setImageResource(R.id.type_img, R.drawable.pay_record_type1);
            } else if ("2".equals(type)) {
                helper.setImageResource(R.id.type_img, R.drawable.pay_record_type3);
            } else if ("3".equals(type)) {
                helper.setImageResource(R.id.type_img, R.drawable.pay_record_type2);
            }
            final TextView statusTv = helper.getTextView(R.id.type_tv);

            if ("0".equals(vo.getPay_status())) {
                statusTv.setText("去支付");
                statusTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 15, R.color.FUBColor3, R.color.FUBColor3));

            } else if ("2".equals(vo.getPay_status())) {
                statusTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 15, R.color.C3_1, R.color.C3_1));
                statusTv.setText("已支付");
                statusTv.setVisibility(View.VISIBLE);
            }

//            if (TextUtils.isEmpty(vo.getReturn_img())) {
//                if ("0".equals(vo.getPay_status())) {
//                    statusTv.setText("去支付");
//                    statusTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 15, R.color.FUBColor3, R.color.FUBColor3));
//
//                } else if ("2".equals(vo.getPay_status())) {
//                    statusTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 15, R.color.C3_1, R.color.C3_1));
//                    statusTv.setText("已支付");
//                    statusTv.setVisibility(View.VISIBLE);
//                }
//            } else {
//                statusTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 15, R.color.colorAccent, R.color.colorAccent));
//                statusTv.setText("查看回执");
//
//            }

            statusTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (TextUtils.isEmpty(vo.getReturn_img())) {

                        if ("0".equals(vo.getPay_status())) {
                            PaymentRecordsActivity activity = (PaymentRecordsActivity) mActivity;
                            activity.showPayDialog(vo);
                        }
                    } else {
                        PaymentRecordsActivity activity = (PaymentRecordsActivity) mActivity;
                        activity.choicePhotoWrapper(vo.getReturn_img());
                    }

                }
            });

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (this.getData().size() == 0) {
            return super.getItemViewType(position);
        }
        PaymentRecordsVO.DataBeanX dataBean = (PaymentRecordsVO.DataBeanX) this.getData().get(position);
        if (dataBean.getLists() == null) {
            return R.layout.payment_record_adapter_type2;
        } else {
            return R.layout.payment_record_adapter_type1;

        }
    }
}
