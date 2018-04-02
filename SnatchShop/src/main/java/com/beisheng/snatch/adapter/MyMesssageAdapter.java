package com.beisheng.snatch.adapter;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.MyMessageVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class MyMesssageAdapter extends RecyclerBaseAdapter {
    public MyMesssageAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_message_adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MyMessageVO.DataBean.ListBean vo = (MyMessageVO.DataBean.ListBean) model;
        helper.setText(R.id.title_tv, vo.getTitle());
        helper.setText(R.id.desc_tv, vo.getContent());
        helper.setText(R.id.time_tv, vo.getCreate_date());
    }
}
