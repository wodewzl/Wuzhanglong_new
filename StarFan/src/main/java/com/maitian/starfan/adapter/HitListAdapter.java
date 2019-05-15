package com.maitian.starfan.adapter;

import android.support.v7.widget.RecyclerView;

import com.maitian.starfan.R;
import com.maitian.starfan.model.MessageVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class HitListAdapter extends RecyclerBaseAdapter {
    public HitListAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.hit_list_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MessageVO bean = (MessageVO) model;
//        helper.setText(R.id.money_tv,bean.getMoney());
//        if(bean.isSelect()){
//            helper.getTextView(R.id.money_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext,5,R.color.colorAccent,R.color.C1));
//            helper.setTextColorRes(R.id.money_tv,R.color.colorAccent);
//        }else {
//            helper.getTextView(R.id.money_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext,5,R.color.C3_1,R.color.C1));
//            helper.setTextColorRes(R.id.money_tv,R.color.C4);

        helper.getTextView(R.id.hit_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 5, R.color.hit_bg, R.color.colorAccent));
        if (position == 0) {
            helper.setBackgroundColorRes(R.id.rank_view, R.color.hit_one);
        } else if (position == 1) {
            helper.setBackgroundColorRes(R.id.rank_view, R.color.hit_two);
        } else if (position == 2) {
            helper.setBackgroundColorRes(R.id.rank_view, R.color.hit_three);
        } else {
            helper.setBackgroundColorRes(R.id.rank_view, R.color.C15);
        }


//        }
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.hit_list_adapter;
    }
}
