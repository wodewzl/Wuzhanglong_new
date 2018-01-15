package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.HouseListVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2017/12/30.
 */

public class HouseListAdapter extends RecyclerBaseAdapter<HouseListVO.DataBean.HouseBean> {

    public HouseListAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.house_list_adapter_layout);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        HouseListVO.DataBean.HouseBean bean = (HouseListVO.DataBean.HouseBean) model;
        ImageView houseImg = helper.getImageView(R.id.house_img);
        if (!TextUtils.isEmpty(bean.getHouse_pic()))
            Picasso.with(mContext).load(bean.getHouse_pic()).into(houseImg);
        helper.setText(R.id.title_tv, bean.getHouse_title());
        helper.setText(R.id.desc_tv, bean.getDecorateStyleName() + "/" + bean.getHouse_area() + "㎡" + "/" + bean.getPositionName());
        helper.setText(R.id.address_tv, bean.getArea());
        helper.setText(R.id.money_tv, bean.getHouse_price() + "P/月");
        helper.getTextView(R.id.language1_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor12, R.color.FUBColor12));

        if (bean.getHouse_language_names() != null && bean.getHouse_language_names().size() > 0) {
            if (bean.getHouse_language_names().size() == 1) {
                helper.getTextView(R.id.language2_tv).setText(bean.getHouse_language_names().get(0));
                helper.getTextView(R.id.language2_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language2_tv).setVisibility(View.VISIBLE);
                helper.getTextView(R.id.language3_tv).setVisibility(View.GONE);
                helper.getTextView(R.id.language4_tv).setVisibility(View.GONE);
            }
            if (bean.getHouse_language_names().size() == 2) {
                helper.getTextView(R.id.language2_tv).setText(bean.getHouse_language_names().get(0));
                helper.getTextView(R.id.language3_tv).setText(bean.getHouse_language_names().get(1));
                helper.getTextView(R.id.language2_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language2_tv).setVisibility(View.VISIBLE);
                helper.getTextView(R.id.language3_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language3_tv).setVisibility(View.VISIBLE);
                helper.getTextView(R.id.language4_tv).setVisibility(View.GONE);
            }
            if (bean.getHouse_language_names().size() == 3) {
                helper.getTextView(R.id.language2_tv).setText(bean.getHouse_language_names().get(0));
                helper.getTextView(R.id.language3_tv).setText(bean.getHouse_language_names().get(1));
                helper.getTextView(R.id.language4_tv).setText(bean.getHouse_language_names().get(2));

                helper.getTextView(R.id.language2_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language2_tv).setVisibility(View.VISIBLE);
                helper.getTextView(R.id.language3_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language3_tv).setVisibility(View.VISIBLE);
                helper.getTextView(R.id.language4_tv).setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 3, R.color.FUBColor13, R.color.FUBColor13));
                helper.getTextView(R.id.language4_tv).setVisibility(View.VISIBLE);
            }

        } else {
            helper.getTextView(R.id.language2_tv).setVisibility(View.GONE);
            helper.getTextView(R.id.language3_tv).setVisibility(View.GONE);
            helper.getTextView(R.id.language4_tv).setVisibility(View.GONE);
        }

    }

}
