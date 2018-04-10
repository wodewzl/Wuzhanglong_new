package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.HomeVO;
import com.beisheng.snatch.model.ShowVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import java.util.ArrayList;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.bingoogolapple.photopicker.widget.BGANinePhotoLayout;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class MyShowAdapter extends RecyclerBaseAdapter {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public MyShowAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.my_show_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ShowVO.DataBean.ListBean bean = (ShowVO.DataBean.ListBean) model;
        if (!TextUtils.isEmpty(bean.getAvatar()))
            Picasso.with(mActivity).load(bean.getAvatar()).into(helper.getImageView(R.id.head_img));
        if("1".equals(bean.getStatus())){
            BaseCommonUtils.setTextThree(mContext,helper.getTextView(R.id.name_tv),bean.getNickname()+"(","审核成功",")",R.color.color_green,1.0f);

        }else if("2".equals(bean.getStatus())){
            BaseCommonUtils.setTextThree(mContext,helper.getTextView(R.id.name_tv),bean.getNickname()+"(","审核失败",")",R.color.colorAccent,1.0f);
        }else {
            BaseCommonUtils.setTextThree(mContext,helper.getTextView(R.id.name_tv),bean.getNickname()+"(","审核中",")",R.color.color_yellow,1.0f);
        }
        helper.setText(R.id.content_tv, bean.getContent());

        BGANinePhotoLayout photoLayout = helper.getView(R.id.photo_layout);
        photoLayout.setData((ArrayList<String>) bean.getImgs());
        helper.setText(R.id.agree_count_tv, bean.getLikes());
        helper.setText(R.id.comment_count_tv, bean.getComments());
        helper.setText(R.id.share_count_tv, bean.getShares());
    }

}
