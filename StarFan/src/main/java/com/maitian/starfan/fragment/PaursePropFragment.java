package com.maitian.starfan.fragment;


import android.view.View;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.maitian.starfan.R;
import com.maitian.starfan.adapter.PaursePropAdapter;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;

public class PaursePropFragment extends BaseFragment implements View.OnClickListener, PostCallback, Serializable {
    private LuRecyclerView mRecyclerView;
    private PaursePropAdapter mAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    @Override
    public void setContentView() {
        contentInflateView(R.layout.attention_fragment);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new PaursePropAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this.getActivity(), mRecyclerView, mAdapter, R.dimen.dp_10, R.color.C3, true);
    }

    @Override
    public void bindViewsListener() {

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

    }




    @Override
    public void success(BaseVO vo) {

    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void bindPhone() {

    }
}
