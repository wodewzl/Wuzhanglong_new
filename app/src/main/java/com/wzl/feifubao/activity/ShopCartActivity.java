package com.wzl.feifubao.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.rey.material.widget.CheckBox;
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
import com.wzl.feifubao.mode.ShopHomeVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShopCartActivity extends BaseActivity implements  SwipeRefreshLayout.OnRefreshListener,CompoundButton.OnCheckedChangeListener, View.OnClickListener{
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_shop_cart);
    }

    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private ShopCatLRAdapter mAdapter;
    private TextView mTotalTv,mCommitTv;
    private CheckBox mAllCheck;
    private View mAllCheckView;

    @Override
    public void initView() {
        mBaseTitleTv.setText("购物车");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ShopCatLRAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setLoadMoreEnabled(false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                ShopHomeVO vo = (ShopHomeVO) mAdapter.getData().get(position);
                if ("3".equals(vo.getType())) {
                    return 1;
                } else {
                    return 2;
                }
            }
        });

        mTotalTv = getViewById(R.id.total_tv);
        mCommitTv = getViewById(R.id.commit_tv);
        mAllCheck = getViewById(R.id.check_box);
        mAllCheckView = getViewById(R.id.view_check);
        mAllCheckView = getViewById(R.id.view_check);
    }

    @Override
    public void bindViewsListener() {
        mAllCheckView.setOnClickListener(this);
        mCommitTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        HttpGetDataUtil.get(mActivity, this, Constant.SHOP_CART_LIST_URL, map, ShopCatVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        ShopCatVO shopCatVO = (ShopCatVO) vo;
        List<ShopCatVO> list = new ArrayList<>();
        for (int i = 0; i < shopCatVO.getData().getCart().size(); i++) {
            ShopCatVO cartVo = shopCatVO.getData().getCart().get(i);
            cartVo.setType("1");
            list.add(cartVo);
        }
        ShopCatVO tuiJianTitle = new ShopCatVO();
        tuiJianTitle.setType("2");
        list.add(tuiJianTitle);
        for (int i = 0; i < shopCatVO.getData().getTuijian().size(); i++) {
            ShopCatVO tuiJianVo = shopCatVO.getData().getTuijian().get(i);
            tuiJianVo.setType("3");
            list.add(tuiJianVo);
        }
        mAdapter.updateData(list);
        mAutoSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onRefresh() {
        getData();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.commit_tv:

//                mSb = new StringBuffer();
//                Bundle bundle = new Bundle();
//                for (int i = 0; i < mAdapter.getData().size(); i++) {
//                    ShopCatVO vo = mAdapter.getData().get(i);
//                    if (vo.getCart_id() != null && vo.isCheck()) {
//                        mSb.append(vo.getCart_id() + "|" + vo.getGoods_num()).append(",");
//                    }
//                }
//                bundle.putString("cart_info", mSb.toString());
//                bundle.putString("ifcart", "1");
//                if (mSb.length() == 0) {
//                    mActivity.showCustomToast("请选择商品");
//                    return;
//                }
//                mActivity.open(OrderSureActivity.class, bundle, 0);
                break;
            case R.id.view_check:
                if (mAllCheck.isChecked()) {
                    mAllCheck.setChecked(false);
                } else {
                    mAllCheck.setChecked(true);
                }
//                for (int i = 0; i < mAdapter.getData().size(); i++) {
//                    ShopCatVO vo = mAdapter.getData().get(i);
//                    vo.setCheck(mAllCheck.isChecked());
//                }
                mAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }
}
