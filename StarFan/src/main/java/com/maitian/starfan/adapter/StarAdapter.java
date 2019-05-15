package com.maitian.starfan.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maitian.starfan.R;
import com.maitian.starfan.activity.RiceCircleStarActivity;
import com.maitian.starfan.constant.Constant;
import com.maitian.starfan.model.StarVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class StarAdapter extends RecyclerBaseAdapter {
    public StarAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.star_adapter);

    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        final StarVO.ObjBean.ListBean vo = (StarVO.ObjBean.ListBean) model;
        if (!TextUtils.isEmpty(vo.getIcon_url()))
            Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + vo.getIcon_url()).into(helper.getImageView(R.id.head_img));
        helper.setText(R.id.name_tv, vo.getNickname());
        TextView statusTv = helper.getView(R.id.status_tv);
        if ("0".equals(vo.getStatus())) {
            statusTv.setBackground(BaseCommonUtils.setBackgroundShap(mContext, 17, R.color.C3, R.color.C3));
            statusTv.setTextColor(ContextCompat.getColor(mContext, R.color.star_gray_title));
            statusTv.setText("已守护");
        } else {
            statusTv.setBackground(BaseCommonUtils.setBackgroundShap(mContext, 17, R.color.colorAccent, R.color.colorAccent));
            statusTv.setTextColor(ContextCompat.getColor(mContext, R.color.C1));
            statusTv.setText("守护");
        }

        helper.setItemChildClickListener(R.id.status_tv);
        helper.setOnItemChildClickListener(new BGAOnItemChildClickListener() {
            @Override
            public void onItemChildClick(ViewGroup parent, View v, int position) {
                switch (v.getId()) {
                    case R.id.status_tv:
                        RiceCircleStarActivity activity = (RiceCircleStarActivity) mContext;
                        activity.defendStar(vo.getId() + "");
                        vo.setStatus(0);
                        notifyDataSetChanged();
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.star_adapter;
    }
}
