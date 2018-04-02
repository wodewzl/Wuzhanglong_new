package com.beisheng.snatch.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.RedMoneyAdapter;
import com.beisheng.snatch.adapter.ShopCatAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.HomeVO;
import com.beisheng.snatch.model.SearchShopVO;
import com.beisheng.snatch.model.ShopCatVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.rey.material.app.BottomSheetDialog;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.BottomDialogUtil;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.baseadapter.BGAOnRVItemLongClickListener;

public class TabFourFragment extends BaseFragment implements View.OnClickListener, BGAOnRVItemClickListener,SwipeRefreshLayout.OnRefreshListener,BGAOnRVItemLongClickListener{
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private ShopCatAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private TextView mOkTv;
    private TextView mPayTypeTv, mRedMoneyTv;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_four_fragment);
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
        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(false);
        mOkTv = getViewById(R.id.ok_tv);
    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnRVItemLongClickListener(this);
    }


    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("cart_info", "");
        map.put("user_no", "10005");
//        map.put(" payment_code", "");
//        map.put("coupon_id", "");
        BSHttpUtils.get(mActivity, this, Constant.SHOP_CART_URL, map, ShopCatVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        ShopCatVO shopCatVO = (ShopCatVO) vo;
        List<ShopCatVO.DataBean.ListBean> list = shopCatVO.getData().getList();

        List<ShopCatVO.DataBean.ListBean> listOne = new ArrayList<>();//可购买的
        List<ShopCatVO.DataBean.ListBean> listTwo = new ArrayList<>();//失效的
        List<ShopCatVO.DataBean.ListBean> listAll = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ("1".equals(list.get(i).getIs_valid())) {
                listOne.add(list.get(i));
            } else {
                listTwo.add(list.get(i));
            }
        }
        listAll.addAll(listOne);
        ShopCatVO.DataBean.ListBean titleVO = new ShopCatVO.DataBean.ListBean();
        titleVO.setValidedCount(listTwo.size() + "");
        listAll.add(titleVO);
        listAll.addAll(listTwo);
        mAdapter.updateData(listAll);
        mAdapter.notifyDataSetChanged();
        mAutoSwipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_tv:
                BottomSheetDialog dialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.buy_dialog);
                mPayTypeTv = dialog.getWindow().getDecorView().findViewById(R.id.pay_type_tv);
                mRedMoneyTv = dialog.getWindow().getDecorView().findViewById(R.id.red_money_tv);
                mPayTypeTv.setOnClickListener(this);
                mRedMoneyTv.setOnClickListener(this);
                break;

            case R.id.pay_type_tv:
                BottomSheetDialog payuDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.buy_pay_dialog);
                System.out.println("=========>");
                break;
            case R.id.red_money_tv:
                BottomSheetDialog redDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.red_money_list_dialog);
                LuRecyclerView recyclerView = redDialog.getWindow().getDecorView().findViewById(R.id.dialog_recycler_view);
                RedMoneyAdapter dialogAdapter = new RedMoneyAdapter(recyclerView);
                RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, recyclerView, dialogAdapter, R.dimen.dp_10, R.color.C3, false);
                break;
            default:
                break;
        }
    }


    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {

    }

    @Override
    public void onRefresh() {
        getData();
    }

    @Override
    public boolean onRVItemLongClick(ViewGroup parent, View itemView, int position) {
        if(mAdapter.getData().size()==0)
            return false;
        ShopCatVO.DataBean.ListBean vo= (ShopCatVO.DataBean.ListBean) mAdapter.getItem(position);
        vo.setLongClick(true);
        mAdapter.notifyDataSetChanged();
        return false;
    }
}
