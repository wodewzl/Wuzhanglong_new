package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.JobOffersAdapter;
import com.wzl.feifubao.adapter.MyOverAdapter;
import com.wzl.feifubao.mode.MyoverVO;

import java.util.ArrayList;

public class MyOverActivity extends BaseActivity implements  ScrollableHelper.ScrollableContainer,View.OnClickListener{
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private MyOverAdapter mAdapter;
    private TextView mOkTv;
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_my_over);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("我的余额");
        mOkTv=getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.FUBColor7, R.color.FUBColor7));
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new MyOverAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);

    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
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
    public View getScrollableView() {
        return mRecyclerView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_tv:
                openActivity(WithdrawActivity.class);

                break;
            default:
                break;
        }
    }
}
