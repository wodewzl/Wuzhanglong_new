package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.ShopCatLRAdapter;
import com.wzl.feifubao.adapter.YellowPagesAdapter;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.LifeVO;
import com.wzl.feifubao.mode.ShopCatVO;

import java.util.HashMap;

public class ShopCartActivity extends BaseActivity {
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_shop_cart);
    }
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private ShopCatLRAdapter mAdapter;
    @Override
    public void initView() {
        mBaseTitleTv.setText("购物车");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new ShopCatLRAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_10, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setLoadMoreEnabled(false);
    }

    @Override
    public void bindViewsListener() {

    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        HttpGetDataUtil.get(mActivity, this, Constant.SHOP_CART_LIST_URL, map, ShopCatVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        ShopCatVO shopCatVO= (ShopCatVO) vo;
        mAdapter.updateData(shopCatVO.getData());
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }
}
