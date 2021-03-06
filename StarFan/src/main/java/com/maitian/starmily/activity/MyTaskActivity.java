package com.maitian.starmily.activity;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.maitian.starmily.R;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.MyTaskBean;
import com.maitian.starmily.model.TaskShowBean;
import com.maitian.starmily.utils.TaskUtil;
import com.maitian.starmily.view.StarmilyToast;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

public class MyTaskActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private TextView mMily01Tv, mMily02Tv, mMily03Tv, mMily04Tv, mMily05Tv, mMily06Tv, mMily07Tv;
    private TextView mCount02Tv, mCount03Tv, mCount04Tv;
    private TextView mStatus01Tv, mStatus02Tv, mStatus03Tv, mStatus04Tv, mStatus05Tv, mStatus06Tv, mStatus07Tv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_task_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("任务中心");
        mMily01Tv = getViewById(R.id.mily_01_tv);
        mMily02Tv = getViewById(R.id.mily_02_tv);
        mMily03Tv = getViewById(R.id.mily_03_tv);
        mMily04Tv = getViewById(R.id.mily_04_tv);
        mMily05Tv = getViewById(R.id.mily_05_tv);
        mMily06Tv = getViewById(R.id.mily_06_tv);
        mMily07Tv = getViewById(R.id.mily_07_tv);
        mCount02Tv = getViewById(R.id.count_02_tv);
        mCount03Tv = getViewById(R.id.count_03_tv);
        mCount04Tv = getViewById(R.id.count_04_tv);
        mStatus01Tv = getViewById(R.id.status_01_tv);
        mStatus02Tv = getViewById(R.id.status_02_tv);
        mStatus03Tv = getViewById(R.id.status_03_tv);
        mStatus04Tv = getViewById(R.id.status_04_tv);
        mStatus05Tv = getViewById(R.id.status_05_tv);
        mStatus06Tv = getViewById(R.id.status_06_tv);
        mStatus07Tv = getViewById(R.id.status_07_tv);

    }

    @Override
    public void bindViewsListener() {
        mStatus01Tv.setOnClickListener(this);
        mStatus02Tv.setOnClickListener(this);
        mStatus03Tv.setOnClickListener(this);
        mStatus04Tv.setOnClickListener(this);
        mStatus05Tv.setOnClickListener(this);
        mStatus06Tv.setOnClickListener(this);
        mStatus07Tv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.get(mActivity, this, Constant.GET_USER_TASK, map, MyTaskBean.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        MyTaskBean myTaskBean = (MyTaskBean) vo;
        List<MyTaskBean.ObjBean.TaskListBean> list = myTaskBean.getObj().getTaskList();
        mMily01Tv.setText(list.get(0).getMily() + "米币");
        mMily02Tv.setText(list.get(1).getMily() + "米币");
        mMily03Tv.setText(list.get(2).getMily() + "米币");
        mMily04Tv.setText(list.get(3).getMily() + "米币");
        mMily05Tv.setText(list.get(4).getMily() + "米币");
        mMily06Tv.setText(list.get(5).getMily() + "米币");
        mMily07Tv.setText(list.get(6).getMily() + "米币");
        BaseCommonUtils.setTextTwoBefore(this, mCount02Tv, list.get(1).getMinCount() + "", "/" + list.get(1).getMaxCount(), R.color.colorAccent, 1.0f);
        BaseCommonUtils.setTextTwoBefore(this, mCount03Tv, list.get(2).getMinCount() + "", "/" + list.get(2).getMaxCount(), R.color.colorAccent, 1.0f);
        BaseCommonUtils.setTextTwoBefore(this, mCount04Tv, list.get(3).getMinCount() + "", "/" + list.get(3).getMaxCount(), R.color.colorAccent, 1.0f);
        setStatus(mStatus01Tv, list.get(0).getStatus());
        setStatus(mStatus02Tv, list.get(1).getStatus());
        setStatus(mStatus03Tv, list.get(2).getStatus());
        setStatus(mStatus04Tv, list.get(3).getStatus());
        setStatus(mStatus05Tv, list.get(4).getStatus());
        setStatus(mStatus06Tv, list.get(5).getStatus());
        setStatus(mStatus07Tv, list.get(6).getStatus());
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    public void setStatus(TextView textView, int status) {
        if (status == 0) {
            if (textView == mStatus01Tv) {
                textView.setText("签到");
            } else {
                textView.setText("去参加");
            }
            textView.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        } else if (status == 1) {
            textView.setText("进行中");
            textView.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        } else if (status == 2) {
            textView.setText("领取");
            textView.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        } else if (status == 3) {
            textView.setText("已领取");
            textView.setTextColor(ContextCompat.getColor(this, R.color.star_gray));
        }
    }

    @Override
    public void onClick(View view) {
        TextView tv = (TextView) view;
        switch (view.getId()) {
            case R.id.status_01_tv:
                if ("签到".equals(tv.getText())) {
                    sign();
                } else if ("领取".equals(tv.getText())) {
                    taskReward("1");
                    tv.setTextColor(ContextCompat.getColor(this, R.color.star_gray));
                }
                break;
            case R.id.status_02_tv:
                if ("去参加".equals(tv.getText())) {
                    EventBus.getDefault().post(new EBMessageVO("task"));
                    this.finish();
                } else if ("领取".equals(tv.getText())) {
                    taskReward("2");
                    tv.setTextColor(ContextCompat.getColor(this, R.color.star_gray));
                }
                break;
            case R.id.status_03_tv:
                if ("去参加".equals(tv.getText())) {
                    EventBus.getDefault().post(new EBMessageVO("task"));
                    this.finish();
                } else if ("领取".equals(tv.getText())) {
                    taskReward("3");
                    tv.setTextColor(ContextCompat.getColor(this, R.color.star_gray));
                }
                break;
            case R.id.status_04_tv:
                if ("去参加".equals(tv.getText())) {
                    EventBus.getDefault().post(new EBMessageVO("task"));
                    this.finish();
                } else if ("领取".equals(tv.getText())) {
                    taskReward("4");
                    tv.setTextColor(ContextCompat.getColor(this, R.color.star_gray));
                }
                break;
            case R.id.status_05_tv:
                if ("去参加".equals(tv.getText())) {

                } else if ("领取".equals(tv.getText())) {

                }
                break;
            case R.id.status_06_tv:
                if ("去参加".equals(tv.getText())) {

                } else if ("领取".equals(tv.getText())) {

                }
                break;
            case R.id.status_07_tv:
                if ("去参加".equals(tv.getText())) {

                } else if ("领取".equals(tv.getText())) {

                }
                break;
            default:
                break;

        }
    }

    public void taskReward(String taskId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        map.put("taskId", taskId);
        StartHttpUtils.postCallBack(mActivity, Constant.TASK_REWARD, map, TaskShowBean.class, this);


    }

    @Override
    public void success(BaseVO vo) {
        if (vo instanceof TaskShowBean) {
            TaskShowBean bean = (TaskShowBean) vo;
            StarmilyToast.showTaskToast(this, bean.getObj().getTaskName(), "", "+"+bean.getObj().getMily() + "米粒");
        } else {
            new TaskUtil().taskShow(mActivity, "1");
        }

    }

    public void sign() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.postCallBack(mActivity, Constant.SIGN_IN, map, BaseVO.class, this);
    }
}
