package com.beisheng.snatch.activity;

import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.DailyTaskDetailVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import java.util.HashMap;

public class DailyTaskDetailActivity extends BaseActivity {
    private ImageView mTaskImg;
    private TextView mBuyTv, mTv01, mTv02, mTv03, mTv04, mRuleTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.daily_task_detail_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("任务详情");
        mTaskImg = getViewById(R.id.img);
        mBuyTv = getViewById(R.id.buy_tv);
        mTv01 = getViewById(R.id.tv_01);
        mTv02 = getViewById(R.id.tv_02);
        mTv03 = getViewById(R.id.tv_03);
        mTv04 = getViewById(R.id.tv_04);
        mRuleTv = getViewById(R.id.rule_tv);
    }

    @Override
    public void bindViewsListener() {

    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.getIntent().getStringExtra("id"));
        BSHttpUtils.get(mActivity, this, Constant.DAILY_TASK_DETAIL_URL, map, DailyTaskDetailVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        DailyTaskDetailVO dailyTaskDetailVO = (DailyTaskDetailVO) vo;
        if (!TextUtils.isEmpty(dailyTaskDetailVO.getData().getTask_icon()))
            Picasso.with(this).load(dailyTaskDetailVO.getData().getTask_icon()).into(mTaskImg);
        mTv01.setText(dailyTaskDetailVO.getData().getTask_name());
        mTv02.setText("任务性质：" + dailyTaskDetailVO.getData().getTask_type());
        BaseCommonUtils.setTextTwoLast(this, mTv03, "奖励积分：", "+"+dailyTaskDetailVO.getData().getGive_points(), R.color.colorAccent, 1.3f);
        BaseCommonUtils.setTextTwoLast(this, mTv04, "完成情况：", dailyTaskDetailVO.getData().getUser_do_count() + "/" + dailyTaskDetailVO.getData().getDo_count(), R.color.colorAccent, 1.3f);
        mRuleTv.setText(dailyTaskDetailVO.getData().getContent());
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }
}
