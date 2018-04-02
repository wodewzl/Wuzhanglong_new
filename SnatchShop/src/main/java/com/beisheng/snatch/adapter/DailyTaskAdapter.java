package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.DailyTaskVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/16.
 */

public class DailyTaskAdapter extends RecyclerBaseAdapter {
    public DailyTaskAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.dail_task_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        DailyTaskVO.DataBean.ListBean vo= (DailyTaskVO.DataBean.ListBean) this.getItem(position);
        if("1".equals(vo.getType())){
            helper.setText(R.id.title_tv,vo.getTask_name());
        }else {
            if (!TextUtils.isEmpty(vo.getTask_icon()))
                Picasso.with(mContext).load(vo.getTask_icon()).into(helper.getImageView(R.id.img));
            helper.setText(R.id.name_tv,vo.getTask_name());
            helper.setText(R.id.count_tv,"("+vo.getUser_do_count()+"/"+vo.getDo_count()+")");
            BaseCommonUtils.setTextTwoLast(mContext,helper.getTextView(R.id.point_tv),"积分","+"+vo.getGive_points(),R.color.colorAccent,1.3f);
        }
    }

    @Override
    public int getItemViewType(int position) {
        DailyTaskVO.DataBean.ListBean vo= (DailyTaskVO.DataBean.ListBean) this.getItem(position);
        if("1".equals(vo.getType())){
            return R.layout.title_view;
        }else {
            return R.layout.dail_task_adapter;
        }
    }

}
