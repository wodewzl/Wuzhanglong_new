package com.maitian.starmily.adapter;

import android.Manifest;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.NewsDetailBeans;
import com.maitian.starmily.model.NewsDiscussBean;
import com.maitian.starmily.model.RiceCircleVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGANinePhotoLayout;
import de.hdodenhof.circleimageview.CircleImageView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by ${Wuzhanglong} on 2019/3/31.
 */
public class NewsDiscussAdapter extends RecyclerBaseAdapter {
    public NewsDiscussAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.news_discuss_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        NewsDiscussBean.ObjBean.ListBeanX vo = (NewsDiscussBean.ObjBean.ListBeanX) model;
        if (!TextUtils.isEmpty(vo.getIcon_url()))
            Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + vo.getIcon_url()).into(helper.getImageView(R.id.reply_head_iv));
        helper.setText(R.id.reply_name_tv, vo.getUserName());
        helper.setText(R.id.reply_content_tv, vo.getReplyMsg());
        TextView replyPeopleTv = helper.getTextView(R.id.reply_people_tv);
        if (vo.getCommentReply() != null) {
            BaseCommonUtils.setTextTwoBefore(mContext, replyPeopleTv, vo.getCommentReply().getList().get(0).getFromUserName(),
                    " 等" + vo.getCommentReply().getSize() + "人觉得很赞", R.color.colorAccent, 1.0f);
            helper.setText(R.id.reply_count_tv, vo.getCommentReply().getTotal() + "");
        } else {
            BaseCommonUtils.setTextTwoBefore(mContext, replyPeopleTv, "",
                    " 等" + 0 + "人觉得很赞", R.color.colorAccent, 1.0f);
            helper.setText(R.id.reply_count_tv, "0");
        }
        helper.setText(R.id.reply_favout_tv, vo.getLikeCount() + "");
        helper.setItemChildClickListener(R.id.reply_count_tv);
        helper.setItemChildClickListener(R.id.reply_favout_tv);
        helper.setItemChildClickListener(R.id.reply_people_tv);
    }

}
