package com.wzl.feifubao.activity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.rey.material.widget.CheckBox;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.utils.NumberTypeUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.ShopCatLRAdapter;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.ShopCatVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class ShopCartActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener, PostCallback,BGAOnRVItemClickListener {
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_shop_cart);
    }

    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private ShopCatLRAdapter mAdapter;
    private TextView mTotalTv, mCommitTv;
    private CheckBox mAllCheck;
    private View mAllCheckView;
    private GridLayoutManager mLayoutManager;
    private LinearLayout mBottomLayout;


    @Override
    public void initView() {
        mBaseTitleTv.setText("购物车");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ShopCatLRAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setLoadMoreEnabled(false);


        mTotalTv = getViewById(R.id.total_tv);
        mCommitTv = getViewById(R.id.commit_tv);
        mAllCheck = getViewById(R.id.check_box);
        mAllCheckView = getViewById(R.id.view_check);
        mBottomLayout = getViewById(R.id.bottom_layout);

    }

    @Override
    public void bindViewsListener() {
        mAllCheckView.setOnClickListener(this);
        mCommitTv.setOnClickListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnRVItemClickListener(this);
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
//        BaseCommonUtils.setTextTwoLast(mActivity, mTotalTv, "合计总金额：", "￥" + mShopCatVO.getSum(), R.color.XJColor2, 1.5f);

        List<ShopCatVO> list = new ArrayList<>();
        if (shopCatVO.getData().getCart() != null) {
            mBottomLayout.setVisibility(View.VISIBLE);
            for (int i = 0; i < shopCatVO.getData().getCart().size(); i++) {
                ShopCatVO cartVo = shopCatVO.getData().getCart().get(i);
                cartVo.setType("1");
                list.add(cartVo);
            }
        }else {
            mBottomLayout.setVisibility(View.GONE);
        }

        if (shopCatVO.getData().getTuijian() != null) {

            ShopCatVO tuiJianTitle = new ShopCatVO();
            tuiJianTitle.setType("2");
            list.add(tuiJianTitle);
            for (int i = 0; i < shopCatVO.getData().getTuijian().size(); i++) {
                ShopCatVO tuiJianVo = shopCatVO.getData().getTuijian().get(i);
                tuiJianVo.setType("3");
                list.add(tuiJianVo);
            }
        }

        mAdapter.updateData(list);
        mAutoSwipeRefreshLayout.setRefreshing(false);
        mLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                ShopCatVO vo = (ShopCatVO) mAdapter.getData().get(position);
                if ("3".equals(vo.getType())) {
                    return 1;
                } else {
                    return 2;
                }
            }
        });
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
                Bundle bundle = new Bundle();
                StringBuffer sb = new StringBuffer();

                for (int i = 0; i < mAdapter.getData().size(); i++) {
                    ShopCatVO vo = (ShopCatVO) mAdapter.getData().get(i);
                    if (vo.getCart_id() != null && vo.isCheck()) {
                        sb.append(vo.getSku_id() + ":" + vo.getNum()).append(",");
                    }
                }
                if (sb.length() == 0) {
                    mActivity.showCustomToast("请选择商品");
                    return;
                }
                bundle.putString("sku_list", sb.toString().substring(0, sb.toString().length() - 1));

                mActivity.open(OrderSureActivity.class, bundle, 0);
                break;
            case R.id.view_check:
                if (mAllCheck.isChecked()) {
                    mAllCheck.setChecked(false);
                } else {
                    mAllCheck.setChecked(true);
                }
                for (int i = 0; i < mAdapter.getData().size(); i++) {
                    ShopCatVO vo = (ShopCatVO) mAdapter.getData().get(i);
                    vo.setCheck(mAllCheck.isChecked());
                }
                mAdapter.notifyDataSetChanged();
                break;
            default:
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

    }

    public void addShopCart(String cartId, String count) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("cart_id", cartId);
        map.put("num", count);
        HttpGetDataUtil.post(this, Constant.ADD_SHOP_COUNT, map, this);
    }

    public void deleteShop(String cartId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("cart_id", cartId);
        HttpGetDataUtil.post(this, Constant.DELETE_SHOP_COUNT, map, this);
    }

    public void countPrice() {
        double money = 0;
        for (int i = 0; i < mAdapter.getData().size(); i++) {
            ShopCatVO vo = (ShopCatVO) mAdapter.getData().get(i);
            if (vo.getCart_id() != null && vo.isCheck()) {
                money = NumberTypeUtil.add(money, NumberTypeUtil.mul(Double.parseDouble(vo.getNum()), Double.parseDouble(vo.getPrice())));
            }
        }
        BaseCommonUtils.setTextTwoLast(mActivity, mTotalTv, "合计总金额：", "￥" + money, R.color.FUBColor2, 1.5f);
    }

    @Override
    public void success(BaseVO vo) {

    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        ShopCatVO bean = mAdapter.getItem(position);
        if ("4".equals(bean.getType())) {
            Bundle bundle = new Bundle();
            bundle.putString("id", bean.getGoods_id());
            mActivity.open(ShopDetailActivity.class, bundle, 0);
        }
    }
}
