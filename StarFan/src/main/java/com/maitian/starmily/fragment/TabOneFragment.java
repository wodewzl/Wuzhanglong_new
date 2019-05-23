package com.maitian.starmily.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.HomeAdapter;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;

import java.io.Serializable;

public class TabOneFragment extends BaseFragment implements View.OnClickListener, PostCallback, Serializable {
    private LuRecyclerView mRecyclerView;
    private HomeAdapter mAdapter;
    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_one_frament);
    }

    @Override
    public void initView(View view) {
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_10, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new HomeAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        adapter.addHeaderView(findHeadView());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(false);
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
    }


    public View findHeadView() {
        View view = View.inflate(mActivity, R.layout.home_head, null);
        return view;
    }
}
