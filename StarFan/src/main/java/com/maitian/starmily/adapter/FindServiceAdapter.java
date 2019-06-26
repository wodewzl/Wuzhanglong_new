package com.maitian.starmily.adapter;

import android.support.v7.widget.RecyclerView;

import com.maitian.starmily.R;
import com.maitian.starmily.model.FindServiceBean;
import com.maitian.starmily.model.MessageVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class FindServiceAdapter extends RecyclerBaseAdapter {
    public FindServiceAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.find_service_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        FindServiceBean.ObjBean.ListBean bean= (FindServiceBean.ObjBean.ListBean) model;
        helper.setText(R.id.name_tv,bean.getName());
    }


}
