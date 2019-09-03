package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.AddressVO;
import com.wzl.feifubao.mode.AddresslistBean;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;


/**
 * Created by Administrator on 2017/2/13.
 */

public class AddressSelectAdapter extends RecyclerBaseAdapter<AddresslistBean> {
    private AddressVO mDefalutVO;

    public AddressSelectAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.address_select_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        AddresslistBean vo = (AddresslistBean) model;
        helper.setText(R.id.name_tv, vo.getConsigner());
        helper.setText(R.id.phone_tv, vo.getMobile());
        helper.setText(R.id.address_tv, vo.getAddress_info() + vo.getAddress());

    }


}
