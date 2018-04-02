package com.beisheng.snatch.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.KeywordAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.KeywordVO;
import com.beisheng.snatch.model.SearchShopVO;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.google.gson.Gson;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class SearchShopActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener, TextView.OnEditorActionListener, BGAOnRVItemClickListener {
    private String mKeyword = "";
    private EditText mSearchEt;
    private List<String> mHistoryKeyword = new ArrayList<>();
    private List<String> mHotKeyword = new ArrayList<>();
    private LuRecyclerView mRecyclerView;
    private KeywordAdapter mAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LinearLayout mKeywordLayout, mHistoryLayout;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.search_shop_activity);
    }

    @Override
    public void initView() {
        mBaseHeadLayout.setVisibility(View.GONE);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mSearchEt = getViewById(R.id.search_et);
        mSearchEt.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        mSearchEt.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new KeywordAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
        mKeywordLayout = getViewById(R.id.keyword_layout);
        mHistoryLayout = getViewById(R.id.history_layout);
        mKeyword = this.getIntent().getStringExtra("keyword");
        Gson gson = new Gson();
        String historyStr = ACache.get(this).getAsString("history_keyword");
        if (!TextUtils.isEmpty(historyStr)) {
            KeywordVO historyData = gson.fromJson(historyStr, KeywordVO.class);
            mHistoryKeyword = historyData.getKeywords_history();
        }
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mSearchEt.setOnEditorActionListener(this);
        mAdapter.setOnRVItemClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("keyword", mKeyword);
        BSHttpUtils.get(mActivity, this, Constant.KEYWORD_LIST_URL, map, SearchShopVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        SearchShopVO searchShopVO = (SearchShopVO) vo;
        if (BaseCommonUtils.parseInt(searchShopVO.getData().getCount()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(searchShopVO.getData().getCount())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        List<SearchShopVO.DataBean.ListBean> list = searchShopVO.getData().getList();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
            mCurrentPage++;
        } else {
            mCurrentPage++;
            mAdapter.updateData(list);
        }
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
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
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
        if (!"".equals(mKeyword)) {
            if (!mHistoryKeyword.contains(mKeyword))
                mHistoryKeyword.add(mKeyword);
            KeywordVO dataBean = new KeywordVO();
            dataBean.setKeywords_history(mHistoryKeyword);
            Gson gson = new Gson();
            ACache.get(SearchShopActivity.this).put("history_keyword", new Gson().toJson(dataBean));
        }
        mAutoSwipeRefreshLayout.autoRefresh();
        return false;
    }
}
