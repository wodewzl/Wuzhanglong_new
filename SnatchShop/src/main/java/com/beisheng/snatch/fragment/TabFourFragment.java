package com.beisheng.snatch.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.ShopCatAdapter;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

public class TabFourFragment extends BaseFragment {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private ShopCatAdapter mAdapter;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_three_fragment);
    }

    @Override
    public void initView(View view) {
        mActivity.mBaseHeadLayout.setVisibility(View.GONE);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        mAdapter = new ShopCatAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_10, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
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
