package com.maitian.starmily.fragment;


import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.maitian.starmily.R;
import com.maitian.starmily.activity.FindServiceActivity;
import com.maitian.starmily.activity.FindTopicActivity;
import com.maitian.starmily.activity.FindVoteActivity;
import com.maitian.starmily.activity.FindWelfareActivity;
import com.maitian.starmily.adapter.FindAdapter;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.DividerUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;

public class TabFourFragment extends BaseFragment implements View.OnClickListener, PostCallback, Serializable {
    private LuRecyclerView mRecyclerView;
    private FindAdapter mAdapter;


    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_four_fragment);
    }

    @Override
    public void initView(View view) {
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_10, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new FindAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        adapter.addHeaderView(findHeadView());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(false);
    }

    @Override
    public void bindViewsListener() {
        EventBus.getDefault().register(this);
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
        showView();
    }

    @Override
    public void noNet() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.head_child_four_layout:
                mActivity.openActivity(FindServiceActivity.class);
                break;

            case R.id.head_child_three_layout:
                mActivity.openActivity(FindWelfareActivity.class);
                break;

            case R.id.head_child_two_layout:
                mActivity.openActivity(FindVoteActivity.class);
                break;

            case R.id.head_child_one_layout:
               mActivity.openActivity(FindTopicActivity.class);
                break;

            default:
                break;
        }
    }

    @Override
    public void success(BaseVO vo) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public View findHeadView() {
        View view = View.inflate(mActivity, R.layout.find_adapter_head, null);
        view.findViewById(R.id.head_child_four_layout).setOnClickListener(this);
        view.findViewById(R.id.head_child_three_layout).setOnClickListener(this);
        view.findViewById(R.id.head_child_two_layout).setOnClickListener(this);
        view.findViewById(R.id.head_child_one_layout).setOnClickListener(this);
        return view;
    }
}
