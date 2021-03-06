package com.maitian.starmily.adapter;

import android.support.v7.widget.RecyclerView;

import com.maitian.starmily.R;
import com.maitian.starmily.model.MessageVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.DateUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class RiceCircleDetailAdapter extends RecyclerBaseAdapter {
    public RiceCircleDetailAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.rice_circle_detail_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MessageVO bean= (MessageVO) model;
//        helper.setText(R.id.money_tv,bean.getMoney());
//        if(bean.isSelect()){
//            helper.getTextView(R.id.money_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext,5,R.color.colorAccent,R.color.C1));
//            helper.setTextColorRes(R.id.money_tv,R.color.colorAccent);
//        }else {
//            helper.getTextView(R.id.money_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext,5,R.color.C3_1,R.color.C1));
//            helper.setTextColorRes(R.id.money_tv,R.color.C4);
//        }


    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.rice_circle_detail_adapter;
    }
}
