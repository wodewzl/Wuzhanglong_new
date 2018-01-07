package com.wzl.feifubao.fragment;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.github.jdsjlzx.ItemDecoration.GridItemDecoration;
import com.github.jdsjlzx.ItemDecoration.SpacesItemDecoration;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.utils.GridDivider;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.ShopDetailActivity;
import com.wzl.feifubao.adapter.ShopAdapter;
import com.wzl.feifubao.adapter.YellowPagesAdapter;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.LifeVO;
import com.wzl.feifubao.mode.RateQueryVO;
import com.wzl.feifubao.mode.ShopVO;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAGridDivider;
import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class ShopFragment extends BaseFragment implements BGAOnRVItemClickListener, OnLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener, android.widget.TextView.OnEditorActionListener, TextWatcher {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private ShopAdapter mAdapter;
    private EditText mSearchEt;
    public int type=3;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String mKeyword = "";

    public static BaseFragment newInstance() {
        BaseFragment fragment = new ShopFragment();
        return fragment;
    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.shop_fragment_layout);
    }

    @Override
    public void initView(View view) {
        mSearchEt = getViewById(R.id.search_et);
        mSearchEt.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        mSearchEt.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=  new GridLayoutManager(mActivity,2);
        mRecyclerView.setLayoutManager(layoutManager);
        BGAGridDivider divider =DividerUtil.bgaGridDivider(R.dimen.dp_2);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new ShopAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mAdapter.getData().size() == 0) {

                    return 2;
                } else {

                    return 1;
                }
            }
        });

    }

    @Override
    public void bindViewsListener() {
        mAdapter.setOnRVItemClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mSearchEt.setOnEditorActionListener(this);
        mSearchEt.addTextChangedListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("categoryId",this.getType()+"");
        HttpGetDataUtil.get(mActivity, this, Constant.SHOP_LIST_ULR, map, ShopVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        ShopVO shopVO= (ShopVO) vo;
        if (BaseCommonUtils.parseInt(shopVO.getData().getPage_count())==1 ) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(shopVO.getData().getPage_count())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }

        ShopVO.DataBean dataBean=shopVO.getData();
        List<ShopVO.DataBean.GoodsBean> list = shopVO.getData().getGoods();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
            mCurrentPage++;
        } else {
            mCurrentPage++;
            mAdapter.updateData(list);
        }
        mAutoSwipeRefreshLayout.setRefreshing(false);
        mAdapter.notifyDataSetChanged();


    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if(mAdapter.getData().size()==0)
            return;
        ShopVO.DataBean.GoodsBean bean=mAdapter.getItem(position);

        Bundle bundle= new Bundle();
        bundle.putString("id",bean.getGoods_id());
        mActivity.open(ShopDetailActivity.class,bundle,0);
    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        getData();
    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }


    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        mKeyword = textView.getText().toString();
        getData();
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence s, int i, int i1, int i2) {
        if ("".equals(s.toString())) {
            mKeyword = "";
            mCurrentPage=1;
            mAutoSwipeRefreshLayout.autoRefresh();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

}
