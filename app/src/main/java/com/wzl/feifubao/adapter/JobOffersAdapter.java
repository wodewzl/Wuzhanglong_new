package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;

import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.HomeVO;
import com.wzl.feifubao.mode.JobOffersVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/29.
 */


public class JobOffersAdapter extends RecyclerBaseAdapter<JobOffersVO.DataBeanX.DataBean> {
    public JobOffersAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.job_offer_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        JobOffersVO.DataBeanX.DataBean vo= (JobOffersVO.DataBeanX.DataBean) model;
        helper.setText(R.id.title_tv,vo.getPosition_name());
        helper.setText(R.id.money_tv,vo.getPosition_salary()+"P");
        helper.setText(R.id.desc_tv,vo.getPosition_class_name());
        helper.setText(R.id.time_tv, vo.getPosition_createtime());
        helper.setText(R.id.company_tv,vo.getSupplier_name());
    }


}
