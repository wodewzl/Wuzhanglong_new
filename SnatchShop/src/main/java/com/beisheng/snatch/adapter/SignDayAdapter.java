package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class SignDayAdapter extends RecyclerBaseAdapter {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public SignDayAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.sign_day_adapter);
    }
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        String point= (String) model;
        helper.setText(R.id.point_tv,"+"+point);
        helper.setText(R.id.day_tv,position+1+"天");

        if(position< BaseCommonUtils.parseInt(this.getStatus())){
            helper.setBackgroundColorRes(R.id.line_view,R.color.C1);
            helper.setBackgroundRes(R.id.img,R.drawable.bg_circle_03);
        }else {
            helper.setBackgroundColorRes(R.id.line_view,R.color.C3);
            helper.setBackgroundRes(R.id.img,R.drawable.bg_circle_04);
        }
    }


}
