package com.maitian.starmily.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.FindWelfareAdapter;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;

public class FindWelfareActivity extends BaseActivity implements ScrollableHelper.ScrollableContainer, View.OnClickListener {
    private LuRecyclerView mRecyclerView;
    private FindWelfareAdapter mAdapter;
    private ScrollableLayout mScrollableLayout;
    private LinearLayout mHeadLayout;
    private TextView mExchangeTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.find_welfare_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("XXX福利");
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new FindWelfareAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, true);
        mScrollableLayout = getViewById(R.id.scrollable_layout);
        mScrollableLayout.getHelper().setCurrentScrollableContainer(this);
        mHeadLayout = getViewById(R.id.head_layout);
        mExchangeTv = getViewById(R.id.exchange_tv);
    }

    @Override
    public void bindViewsListener() {
        mExchangeTv.setOnClickListener(this);
        mScrollableLayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                mHeadLayout.setTranslationY(currentY / 2);
            }
        });
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.exchange_tv:
                openActivity(FindWelfareExchangeActivity.class);
                break;
            default:
                break;

        }
    }
}
