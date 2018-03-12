package com.beisheng.snatch.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.LotteryingAdapter;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import cn.bingoogolapple.baseadapter.BGAGridDivider;

public class TabTwoFragment extends BaseFragment {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private LotteryingAdapter mAdapter;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_two_fragment);
    }

    @Override
    public void initView(View view) {
        mActivity.mBaseHeadLayout.setVisibility(View.GONE);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity,2));
        BGAGridDivider divider =DividerUtil.bgaGridDivider(R.dimen.dp_2);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new LotteryingAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
    }

    @Override
    public void bindViewsListener() {

    }


    @Override
    public void getData() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("wuzhanglong", "牛逼");
//        map.put("jinrenzheng", "傻逼");
//        BSHttpUtils.post(mActivity, this, Constant.HOME_URL, map, HomeVO.class);
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


}
