package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.MyoverVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;


/**
 * Created by Administrator on 2017/2/13.
 */

public class MyOverAdapter extends RecyclerBaseAdapter<MyoverVO.DataBeanX.DataBean> {

    public MyOverAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_over_adapter_type1);
    }

    @Override
    public void initData(final BGAViewHolderHelper helper, int position, Object model) {
        final MyoverVO.DataBeanX.DataBean vo = (MyoverVO.DataBeanX.DataBean) model;
        helper.setText(R.id.type_tv,vo.getType_name());
        helper.setText(R.id.desc_tv,vo.getCreate_time());
        double money=Double.parseDouble(vo.getNumber());

        if(money<0){
            helper.setText(R.id.money_tv, vo.getNumber() );
        }else {
            helper.setText(R.id.money_tv, "+"+vo.getNumber() );
        }

        helper.setText(R.id.over_tv,"余额："+vo.getCurrent_balance());
    }

}
