package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.MoneyVO;
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
        helper.setText(R.id.type_tv,vo.getText());
        helper.setText(R.id.desc_tv,vo.getCreate_time());
        helper.setText(R.id.money_tv,vo.getNumber());
        helper.setText(R.id.over_tv,"余额："+vo.getNumber());
    }

}
