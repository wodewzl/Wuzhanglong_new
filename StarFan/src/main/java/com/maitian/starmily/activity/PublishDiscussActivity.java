package com.maitian.starmily.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.maitian.starmily.R;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;

import java.util.HashMap;

public class PublishDiscussActivity extends BaseActivity implements PostCallback, View.OnClickListener {
    private EditText mContentEt;
    private String mType;//1饭圈评论2饭圈回复3资讯评论4资讯回复

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.publish_discuss_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("发布评论");
        mContentEt = getViewById(R.id.content_et);
        mBaseOkTv.setText("发送");
        mType = this.getIntent().getStringExtra("type");
    }

    @Override
    public void bindViewsListener() {
        mBaseOkTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        showView();
    }

    @Override
    public void hasData(BaseVO vo) {

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void success(BaseVO vo) {
        this.finish();
    }

    public void commit() {
        showProgressDialog();
        if ("1".equals(mType)) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("topicId", this.getIntent().getStringExtra("topicId"));
            map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
            map.put("replyMsg", mContentEt.getText().toString());
            StartHttpUtils.postCallBack(mActivity, Constant.TOPIC_SAVE_COMMENT, map, BaseVO.class, this);
        } else if ("2".equals(mType)) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("commentId", this.getIntent().getStringExtra("commentId"));
            map.put("fromUserId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
            map.put("toUserId", this.getIntent().getStringExtra("toUserId"));
            map.put("replyMsg", mContentEt.getText().toString());
            StartHttpUtils.postCallBack(mActivity, Constant.TOPIC_SAVE_REPLY, map, BaseVO.class, this);

        } else if ("3".equals(mType)) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("newsId", this.getIntent().getStringExtra("newsId"));
            map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
            map.put("replyMsg", mContentEt.getText().toString());
            StartHttpUtils.postCallBack(mActivity, Constant.SAVE_COMMENT, map, BaseVO.class, this);
        } else if ("4".equals(mType)) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("commentId", this.getIntent().getStringExtra("commentId"));
            map.put("fromUserId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
            map.put("toUserId", this.getIntent().getStringExtra("toUserId"));
            map.put("replyMsg", mContentEt.getText().toString());
            StartHttpUtils.postCallBack(mActivity, Constant.SAVE_REPLY, map, BaseVO.class, this);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.base_ok_tv:
                commit();
                break;
            default:
                break;

        }
    }
}
