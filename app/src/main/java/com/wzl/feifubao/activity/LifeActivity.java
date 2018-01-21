package com.wzl.feifubao.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.LifeAdapter;
import com.wzl.feifubao.adapter.MessageAdapter;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.JobOffersVO;
import com.wzl.feifubao.mode.LifeVO;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class LifeActivity extends BaseActivity implements BGAOnRVItemClickListener, OnLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener, android.widget.TextView.OnEditorActionListener, TextWatcher {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private LifeAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private EditText mSearchEt;
    private String mKeyword = "";

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_life);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("菲度锦囊");
        mSearchEt = getViewById(R.id.search_et);
        mSearchEt.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        mSearchEt.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new LifeAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mSearchEt.setOnEditorActionListener(this);
        mSearchEt.addTextChangedListener(this);
        mAdapter.setOnRVItemClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", mCurrentPage+"");
        map.put("pagesize", "10");
        map.put("keyword", mKeyword);
        HttpGetDataUtil.get(mActivity, this, Constant.LIFE_LIST_URL, map, LifeVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        LifeVO lifeVO = (LifeVO) vo;

        if (BaseCommonUtils.parseInt(lifeVO.getData().getPage_count())==1 ) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(lifeVO.getData().getPage_count())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }

        List<LifeVO.DataBean.NewsBean> list = lifeVO.getData().getNews();
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

    @Override
    public void onRefresh() {
        mCurrentPage = 1;

        getData();
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if(mAdapter.getData().size()==0)
            return;
        LifeVO.DataBean.NewsBean lifeVO=mAdapter.getItem(position);
        Bundle bundle=new Bundle();
        bundle.putString("url",lifeVO.getContent());
        bundle.putString("title","文章详情");
        open(WebViewActivity.class,bundle,0);
    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        BaseCommonUtils.hideSoftKeybord(this);
        mKeyword = textView.getText().toString();
        mCurrentPage=1;
        mAutoSwipeRefreshLayout.autoRefresh();
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
