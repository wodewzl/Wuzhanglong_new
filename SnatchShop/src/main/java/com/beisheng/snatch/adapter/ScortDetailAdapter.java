package com.beisheng.snatch.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.ScortDetailVO;
import com.beisheng.snatch.model.TAShowVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class ScortDetailAdapter extends RecyclerBaseAdapter {
    public ScortDetailAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.scort_detail_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ScortDetailVO.DataBean.ListBean vo = (ScortDetailVO.DataBean.ListBean) model;
        helper.setText(R.id.month_tv, vo.getMonth());
        helper.setText(R.id.month_week_tv, vo.getDate_week());
        helper.setText(R.id.time_tv, vo.getDate_timeX());
        helper.setText(R.id.type_tv, vo.getType_name());
        if(BaseCommonUtils.parseInt(vo.getNumber())>0){
            helper.setText(R.id.number_tv, "积分+" + vo.getNumber());
        }else {
            helper.setText(R.id.number_tv, "积分" + vo.getNumber());
        }

        if (position == 0) {
            helper.getView(R.id.divider_1).setVisibility(View.INVISIBLE);
            helper.getView(R.id.divider_2).setVisibility(View.VISIBLE);
        } else if (position == this.getData().size() - 1) {
            helper.getView(R.id.divider_1).setVisibility(View.VISIBLE);
            helper.getView(R.id.divider_2).setVisibility(View.INVISIBLE);
        } else {
            helper.getView(R.id.divider_1).setVisibility(View.VISIBLE);
            helper.getView(R.id.divider_2).setVisibility(View.VISIBLE);
        }
    }
}
