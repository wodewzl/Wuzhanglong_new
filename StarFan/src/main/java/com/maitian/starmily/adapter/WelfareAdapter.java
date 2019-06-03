package com.maitian.starmily.adapter;

import android.support.v7.widget.RecyclerView;

import com.maitian.starmily.R;
import com.maitian.starmily.model.MessageVO;
import com.maitian.starmily.model.WelfareBean;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class WelfareAdapter extends RecyclerBaseAdapter {
    public WelfareAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.welfare_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        WelfareBean.ObjBean.ListBean bean = (WelfareBean.ObjBean.ListBean) model;
        helper.setText(R.id.name_tv, bean.getName());
        helper.setText(R.id.money_tv, bean.getName() + "星米粒");

    }
}
