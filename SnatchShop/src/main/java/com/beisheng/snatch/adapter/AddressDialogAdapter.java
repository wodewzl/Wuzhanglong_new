package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.AddressVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by Administrator on 2017/2/13.
 */

public class AddressDialogAdapter extends RecyclerBaseAdapter{
    public AddressDialogAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.address_dialog_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        AddressVO.DataBean.ListBean vo = (AddressVO.DataBean.ListBean) model;
        helper.setText(R.id.name_tv, vo.getConsigner());
        helper.setText(R.id.phone_tv, vo.getMobile());

        if ("1".equals(vo.getIs_default())) {
            helper.setImageResource(R.id.check_img, R.drawable.check_select);

            BaseCommonUtils.setTextTwoBefore(mContext,helper.getTextView(R.id.address_tv),"【默认】  ",vo.getAddress_info() + vo.getAddress(),R.color.colorAccent,1.0f);
        } else {
            helper.setImageResource(R.id.check_img, R.drawable.check_normal);
            helper.setText(R.id.address_tv, vo.getAddress_info() + vo.getAddress());
        }
    }

}
