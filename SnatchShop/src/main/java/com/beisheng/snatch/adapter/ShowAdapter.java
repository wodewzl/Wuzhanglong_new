package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.HomeVO;
import com.beisheng.snatch.model.ShowVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import java.util.ArrayList;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.bingoogolapple.photopicker.widget.BGANinePhotoLayout;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class ShowAdapter extends RecyclerBaseAdapter {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ShowAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.show_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ShowVO.DataBean.ListBean bean= (ShowVO.DataBean.ListBean) model;
        BGANinePhotoLayout photoLayout=helper.getView(R.id.photo_layout);
        photoLayout.setData((ArrayList<String>) bean.getImgs());
    }

}
