package com.maitian.starmily.adapter;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maitian.starmily.R;
import com.maitian.starmily.activity.PublishDiscussActivity;
import com.maitian.starmily.activity.ReportActivity;
import com.maitian.starmily.activity.RiceCircleDetailActivity;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.RiceCircleVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
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
public class RiceCircleAdapter extends RecyclerBaseAdapter implements BGANinePhotoLayout.Delegate {
    private static final int PRC_PHOTO_PICKER = 1;
    private ChildClikCallback childClikCallback;

    public interface ChildClikCallback {
        void favorPost(String topicId);

        void likePost(String topicId);

        void replayLikePost(String topicId, int stauts);
    }

    public RiceCircleAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.rice_circle_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {

        RiceCircleVO.ObjBean.ListBeanXX vo = (RiceCircleVO.ObjBean.ListBeanXX) model;
        if (!TextUtils.isEmpty(vo.getIconUrl()))
            Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + vo.getIconUrl()).into(helper.getImageView(R.id.head_img));
        helper.setText(R.id.name_tv, vo.getNickname());
        helper.setText(R.id.content_one_tv, vo.getContent());

        if (vo.getFavoriateStatus() == 1) {
            helper.setImageResource(R.id.favor_iv, R.mipmap.favor_select);
        } else {
            helper.setImageResource(R.id.favor_iv, R.mipmap.favor_normal);
        }
        if (vo.getLikeStatus() == 1) {
            helper.setImageResource(R.id.like_iv, R.mipmap.like_press);
        } else {
            helper.setImageResource(R.id.like_iv, R.mipmap.like_normal);
        }
        helper.setItemChildClickListener(R.id.favor_iv);
        helper.setItemChildClickListener(R.id.like_iv);
        helper.setItemChildClickListener(R.id.report_tv);
        helper.setItemChildClickListener(R.id.discuss_tv);
        helper.setItemChildClickListener(R.id.more_tv);

        BGANinePhotoLayout photoLayout = helper.getView(R.id.photo_layout);
        //九宫格
        if (vo.getImgs() != null) {
            String[] imgs = vo.getImgs().split(",");
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < imgs.length; i++) {
                list.add(Constant.DOMAIN_UR + "/" + imgs[i]);
            }
            photoLayout.setData(list);
            photoLayout.setVisibility(View.VISIBLE);
            photoLayout.setDelegate(this);
        } else {
            photoLayout.setVisibility(View.GONE);
        }
        //XXX XXX 等人觉得很赞
        if (vo.getTopicLike() != null) {
            helper.setVisibility(R.id.like_layout, View.VISIBLE);
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < vo.getTopicLike().getTopicLikeUser().size(); i++) {
                stringBuffer.append(vo.getTopicLike().getTopicLikeUser().get(i).getUserName()).append(" ");
            }
            BaseCommonUtils.setTextTwoBefore(mContext, helper.getTextView(R.id.like_tv), "         " + stringBuffer.toString(),
                    "  等" + vo.getTopicLike().getCount() + "人觉得很赞", R.color.colorAccent, 1.0f);
        } else {
            helper.setVisibility(R.id.like_layout, View.GONE);
        }
        //一级评论列表
        LinearLayout linearLayout = helper.getView(R.id.reply_layout);
        linearLayout.removeAllViews();
        if (vo.getTopicComment() != null) {
            helper.setVisibility(R.id.reply_layout, View.VISIBLE);
            boolean isLast = false;
            for (int i = 0; i < vo.getTopicComment().getList().size(); i++) {
                addReplyLayout(linearLayout, vo.getTopicComment().getList().get(i), i);
                if (i == 2) {
                    break;
                }
            }

            if (vo.getTopicComment().getList().size() == 3) {
                helper.setVisibility(R.id.more_tv, View.VISIBLE);
            } else {
                helper.setVisibility(R.id.more_tv, View.GONE);
            }
        } else {
            helper.setVisibility(R.id.reply_layout, View.GONE);
            helper.setVisibility(R.id.more_tv, View.GONE);
        }


        helper.setOnItemChildClickListener(new BGAOnItemChildClickListener() {
            @Override
            public void onItemChildClick(ViewGroup parent, View childView, int position) {
                RiceCircleVO.ObjBean.ListBeanXX beanXX = (RiceCircleVO.ObjBean.ListBeanXX) mData.get(position);
                switch (childView.getId()) {
                    case R.id.favor_iv:
                        childClikCallback.favorPost(beanXX.getTopicId() + "");
//                        if (beanXX.getFavoriateStatus() == 1) {
//                            beanXX.setFavoriateStatus(0);
//                        } else {
//                            beanXX.setFavoriateStatus(1);
//                        }
                        break;
                    case R.id.like_iv:
                        childClikCallback.likePost(beanXX.getTopicId() + "");
//                        if (beanXX.getLikeStatus() == 1) {
//                            beanXX.setLikeStatus(0);
//                        } else {
//                            beanXX.setLikeStatus(1);
//                        }
                        notifyDataSetChanged();
                        break;
                    case R.id.report_tv:
                        mActivity.openActivity(ReportActivity.class);
                        break;
                    case R.id.discuss_tv:
//                        mActivity.openActivity(PublishDiscussActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("type", "1");
                        bundle.putString("topicId", beanXX.getTopicId() + "");
                        bundle.putString("userId", 4338 + "");
                        mActivity.open(PublishDiscussActivity.class, bundle, 0);
                        break;
                    case R.id.more_tv:
                        mActivity.openActivity(RiceCircleDetailActivity.class);
                        break;
                    default:
                        break;
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.rice_circle_adapter;
    }

    public void addReplyLayout(LinearLayout layout, final RiceCircleVO.ObjBean.ListBeanXX.TopicCommentBean.ListBeanX vo, int position) {
        View view = View.inflate(mContext, R.layout.reply_layout, null);
        CircleImageView circleImageView = view.findViewById(R.id.reply_head_iv);
        if (!TextUtils.isEmpty(vo.getIcon_url()))
            Picasso.with(mContext).load(Constant.DOMAIN_UR + "/" + vo.getIcon_url()).into(circleImageView);
        TextView replyNameTv = view.findViewById(R.id.reply_name_tv);
        replyNameTv.setText(vo.getNickname());
        TextView replyContentTv = view.findViewById(R.id.reply_content_tv);
        replyContentTv.setText(vo.getReplyMsg());
        TextView replyPeopleTv = view.findViewById(R.id.reply_people_tv);
        LinearLayout replayContentLayout = view.findViewById(R.id.replay_content_layout);
        replayContentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.openActivity(RiceCircleDetailActivity.class);
            }
        });
        TextView replyCountTv = view.findViewById(R.id.reply_count_tv);
        replyCountTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundleDiscuss = new Bundle();
                bundleDiscuss.putString("type", "2");
                bundleDiscuss.putString("commentId", vo.getCommentId() + "");
                bundleDiscuss.putString("fromUserId", 4338 + "");
                bundleDiscuss.putString("toUserId", vo.getUserId() + "");
                mActivity.open(PublishDiscussActivity.class, bundleDiscuss, 0);
            }
        });
        if (vo.getCommentReply() != null) {
            replayContentLayout.setVisibility(View.VISIBLE);
            BaseCommonUtils.setTextThree(mContext, replyPeopleTv, vo.getCommentReply().getList().get(0).getFromUserName(),
                    "  等人", "  共" + vo.getCommentReply().getSize() + "条回复", R.color.star_black, 1.0f);
            replyCountTv.setText(vo.getCommentReply().getTotal() + "");

        } else {
            replayContentLayout.setVisibility(View.GONE);
            replyCountTv.setText("0");
        }
        TextView replyLikeTv = view.findViewById(R.id.reply_like_tv);
        replyLikeTv.setText(vo.getLikeCount() + "");
        if (vo.getLikeStatus() == 0) {
            replyLikeTv.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_normal_small, 0, 0, 0);
        } else {
            replyLikeTv.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.like_press_small, 0, 0, 0);
        }
        replyLikeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                childClikCallback.replayLikePost(vo.getCommentId() + "", vo.getLikeStatus());
            }
        });
        view.findViewById(R.id.report_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mActivity.openActivity(ReportActivity.class);
            }
        });
        if (position == 2) {
            view.findViewById(R.id.divider_view).setVisibility(View.GONE);
        } else {
            view.findViewById(R.id.divider_view).setVisibility(View.VISIBLE);
        }
        layout.addView(view);
    }

    @Override
    public void onClickNinePhotoItem(BGANinePhotoLayout ninePhotoLayout, View view, int position, String model, List<String> models) {
        choicePhotoWrapper(ninePhotoLayout);
    }

    @AfterPermissionGranted(PRC_PHOTO_PICKER)
    public void choicePhotoWrapper(BGANinePhotoLayout ninePhotoLayout) {

        // 保存图片的目录，改成你自己要保存图片的目录。如果不传递该参数的话就不会显示右上角的保存按钮
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(mContext, perms)) {
            File downloadDir = new File(Environment.getExternalStorageDirectory(), BaseConstant.SDCARD_CACHE);
            BGAPhotoPreviewActivity.IntentBuilder photoPreviewIntentBuilder = new BGAPhotoPreviewActivity.IntentBuilder(mContext)
                    .saveImgDir(downloadDir); // 保存图片的目录，如果传 null，则没有保存图片功能

            if (ninePhotoLayout.getItemCount() == 1) {
                // 预览单张图片
                photoPreviewIntentBuilder.previewPhoto(ninePhotoLayout.getCurrentClickItem());
            } else if (ninePhotoLayout.getItemCount() > 1) {
                // 预览多张图片
                photoPreviewIntentBuilder.previewPhotos(ninePhotoLayout.getData())
                        .currentPosition(ninePhotoLayout.getCurrentClickItemPosition()); // 当前预览图片的索引
            }
            mContext.startActivity(photoPreviewIntentBuilder.build());
        } else {
            EasyPermissions.requestPermissions(mActivity, "图片预览需要以下权限:\n\n1.访问设备上的照片", PRC_PHOTO_PICKER, perms);
        }
    }

    public ChildClikCallback getChildClikCallback() {
        return childClikCallback;
    }

    public void setChildClikCallback(ChildClikCallback childClikCallback) {
        this.childClikCallback = childClikCallback;
    }
}
