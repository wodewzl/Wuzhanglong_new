package com.beisheng.snatch.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.DailyTaskAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.DailyTaskVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class DailyTaskActivity extends BaseActivity implements BGAOnRVItemClickListener, SwipeRefreshLayout.OnRefreshListener,View.OnClickListener {
    private LuRecyclerView mRecyclerView;
    private DailyTaskAdapter mAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;

    /*
    * 每日任务
    * */
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.daily_task_activity);
    }

    @Override
    public void initView() {
        if(this.getIntent().getStringExtra("title")!=null){
            mBaseTitleTv.setText("每日积分");
            mBaseOkTv.setText("查看积分明细");
        }else {
            mBaseTitleTv.setText("每日任务");
            mBaseOkTv.setVisibility(View.GONE);
        }

        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new DailyTaskAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(false);
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mBaseOkTv.setOnClickListener(this);

    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        if(AppApplication.getInstance().getUserInfoVO()!=null)
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        BSHttpUtils.post(mActivity, this, Constant.DAILY_TASK_URL, map, DailyTaskVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        DailyTaskVO dailyTaskVO = (DailyTaskVO) vo;
        List<DailyTaskVO.DataBean.ListBean> list = dailyTaskVO.getData().getList();
        List<DailyTaskVO.DataBean.ListBean> listOne = new ArrayList<>();//每日
        List<DailyTaskVO.DataBean.ListBean> listTwo = new ArrayList<>();//新手
        List<DailyTaskVO.DataBean.ListBean> listAll = new ArrayList<>();
        DailyTaskVO.DataBean.ListBean oneTitle = new DailyTaskVO.DataBean.ListBean();
        oneTitle.setType("1");
        oneTitle.setTask_name("每日任务");
        listAll.add(oneTitle);
        for (int i = 0; i < list.size(); i++) {
            if ("每日任务".equals(list.get(i).getType_name())) {
                listOne.add(list.get(i));
            } else {
                continue;
            }
        }
        listAll.addAll(listOne);

        for (int i = 0; i < list.size(); i++) {
            if ("新手任务".equals(list.get(i).getType_name())) {
                listTwo.add(list.get(i));
            } else {
                continue;
            }
        }

        if (listTwo.size() > 0) {
            DailyTaskVO.DataBean.ListBean twoTitle = new DailyTaskVO.DataBean.ListBean();
            twoTitle.setType("1");
            twoTitle.setTask_name("新手任务");
            listAll.add(twoTitle);
            listAll.addAll(listTwo);
        }

        mAdapter.updateData(listAll);
        mAutoSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        DailyTaskVO.DataBean.ListBean vo = (DailyTaskVO.DataBean.ListBean) mAdapter.getItem(position);
        Bundle bundle = new Bundle();
        bundle.putString("id", vo.getId());
        open(DailyTaskDetailActivity.class, bundle, 0);
    }

    @Override
    public void onRefresh() {
        getData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.base_ok_tv:
                openActivity(MyFlowRecordActivity.class);
                break;
            default:
                break;
        }
    }
}
