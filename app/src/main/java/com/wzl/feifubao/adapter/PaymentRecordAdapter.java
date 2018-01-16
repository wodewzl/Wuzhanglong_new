package com.wzl.feifubao.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.PaymentRecordsVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/29.
 */


public class PaymentRecordAdapter extends RecyclerBaseAdapter<PaymentRecordsVO.DataBeanX.DataBean> {
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
        PaymentRecordsVO.DataBeanX.DataBean vo = (PaymentRecordsVO.DataBeanX.DataBean) model;
        PaymentRecordsVO.DataBeanX.DataBean dataBean = (PaymentRecordsVO.DataBeanX.DataBean) this.getData().get(position);
        if ("1".equals(dataBean.getTypeView())) {

            helper.setText(R.id.title_tv, vo.getCreate_time().split("-")[1]+"月");
        } else {
            helper.setText(R.id.title_tv, vo.getSku_name());
            helper.setText(R.id.time_tv, vo.getCreate_time());
            helper.setText(R.id.money_tv, vo.getPrice() + "P");
            if("1".equals(type)){
                helper.setImageResource(R.id.type_img,R.drawable.pay_record_type1);
            }else if("2".equals(type)){
                helper.setImageResource(R.id.type_img,R.drawable.pay_record_type2);
            }else if("3".equals(type)){
                helper.setImageResource(R.id.type_img,R.drawable.pay_record_type3);
            }

        }
    }

    @Override
    public int getItemViewType(int position) {
        if(this.getData().size()==0){
            return super.getItemViewType(position);
        }
        PaymentRecordsVO.DataBeanX.DataBean dataBean = (PaymentRecordsVO.DataBeanX.DataBean) this.getData().get(position);
        if ("1".equals(dataBean.getTypeView())) {
            return R.layout.payment_record_adapter_type1;
        } else {
            return R.layout.payment_record_adapter_type2;
        }
    }
}
