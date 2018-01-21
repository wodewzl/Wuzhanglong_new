package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.YellowPagesActivity;
import com.wzl.feifubao.mode.JobOffersVO;
import com.wzl.feifubao.mode.YellowPagesVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/31.
 */

public class YellowPagesAdapter extends RecyclerBaseAdapter<YellowPagesVO.DataBeanX.DataBean> {
    public YellowPagesAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.yellow_pages_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        final YellowPagesVO.DataBeanX.DataBean vo = (YellowPagesVO.DataBeanX.DataBean) model;
        if (!TextUtils.isEmpty(vo.getPic()))
            Picasso.with(mActivity).load(vo.getPic()).into(helper.getImageView(R.id.img));
        helper.setText(R.id.title_tv, vo.getSupplier_name());
        helper.setText(R.id.type_tv, vo.getName());
        helper.setText(R.id.desc_tv, "主营业务：" + vo.getDescX());
        helper.setText(R.id.address_tv, "地址：" + vo.getLinkman_address());
        helper.setText(R.id.name_tv, "联系人：" + vo.getLinkman_name());
        helper.setText(R.id.phone_tv, vo.getLinkman_tel());
        helper.getTextView(R.id.phone_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 5, R.color.colorAccent, R.color.colorAccent));
        helper.getTextView(R.id.type_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 5, R.color.C3_1, R.color.C1));
        helper.getTextView(R.id.phone_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BaseCommonUtils.call(mActivity, vo.getLinkman_tel());
            }
        });

        helper.getImageView(R.id.img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!TextUtils.isEmpty(vo.getPic())) {
                    YellowPagesActivity activity = (YellowPagesActivity) mActivity;
                    activity.choicePhotoWrapper(vo.getPic());
                }
            }
        });
    }

}
