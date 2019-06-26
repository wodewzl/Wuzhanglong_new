package com.maitian.starmily.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maitian.starmily.R;
import com.maitian.starmily.activity.RiceCircleStarActivity;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.MyIdolsVO;
import com.maitian.starmily.model.StarVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class GuardAdapter extends RecyclerBaseAdapter {
    public GuardAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.guard_adapter);

    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        MyIdolsVO.ObjBean beans= (MyIdolsVO.ObjBean) model;
        if (!TextUtils.isEmpty(beans.getIconUrl())) {
            if (beans.getIconUrl().contains("http://")) {
                Picasso.with(mContext).load(beans.getIconUrl()).into(helper.getImageView(R.id.head_img));
            } else {
                Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + beans.getIconUrl()).into(helper.getImageView(R.id.head_img));
            }
        }
    }


}
