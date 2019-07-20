package com.maitian.starmily.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.StarAdapter;
import com.maitian.starmily.adapter.StarAttentionAdapter;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.MyIdolsVO;
import com.maitian.starmily.model.StarVO;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class RiceCircleStarActivity extends BaseActivity implements BGAOnRVItemClickListener, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener, PostCallback, View.OnClickListener {

    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView, mAttentionRecyclerView;
    private StarAdapter mAdapter;
    private StarAttentionAdapter mAttentionAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String mKeyword;
    private EditText mSearchEt;
    private ImageView mDeleteIv;
    private TextView mSearchTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.rice_circle_star_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("明星守护");
        mBaseOkTv.setText("完成");
        mSearchEt = getViewById(R.id.search_et);
        mDeleteIv = getViewById(R.id.delete_iv);
        mSearchTv = getViewById(R.id.search_tv);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new StarAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, true);
        mAttentionRecyclerView = getViewById(R.id.attention_recycler_view);

        mAttentionAdapter = new StarAttentionAdapter(mAttentionRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayoutHorizontal(this, mAttentionRecyclerView, mAttentionAdapter, R.dimen.dp_1, R.color.C3);

    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAttentionAdapter.setOnRVItemClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mBaseOkTv.setOnClickListener(this);
        mSearchTv.setOnClickListener(this);
        mSearchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!TextUtils.isEmpty(charSequence.toString())) {
                    mDeleteIv.setVisibility(View.VISIBLE);
                    mKeyword = charSequence.toString();
                } else {
                    mDeleteIv.setVisibility(View.GONE);
                    mKeyword = "";
                    mAutoSwipeRefreshLayout.autoRefresh();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        map.put("pageNum", mCurrentPage + "");
        map.put("pageSize", "10");
//        map.put("name", mKeyword);
        StartHttpUtils.get(mActivity, this, Constant.FIND_IDOLS_BY_PAGE, map, StarVO.class);

        getGuardStar();
    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof StarVO) {
            StarVO starVO = (StarVO) vo;
            if (starVO.getObj().isHasNextPage()) {
                mRecyclerView.setNoMore(false);
                mRecyclerView.setLoadMoreEnabled(true);
            } else {
                mRecyclerView.setNoMore(true);
                mRecyclerView.setLoadMoreEnabled(false);
            }
            mAutoSwipeRefreshLayout.setRefreshing(false);
            List<StarVO.ObjBean.ListBean> list = starVO.getObj().getList();
            if (isLoadMore) {
                mAdapter.updateDataLast(list);
                isLoadMore = false;
            } else {
                mAdapter.updateData(list);
            }
            mAdapter.notifyDataSetChanged();

        } else if (vo instanceof MyIdolsVO) {
            MyIdolsVO myIdolsVO = (MyIdolsVO) vo;
            if (myIdolsVO.getObj().size() > 0) {
                AppApplication.getInstance().saveMyIdolsVO(myIdolsVO);
                mAttentionAdapter.updateData(myIdolsVO.getObj());
                mAttentionRecyclerView.setVisibility(View.VISIBLE);
            } else {
                mAttentionRecyclerView.setVisibility(View.GONE);
            }

        }

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAttentionAdapter.getData().size() == 0)
            return;
        MyIdolsVO.ObjBean beans = (MyIdolsVO.ObjBean) mAttentionAdapter.getItem(position);
        defendStar(beans.getId() + "");

    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        mRecyclerView.setLoadMoreEnabled(true);
        getData();
    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        mCurrentPage++;
        getData();
    }

    public void defendStar(String id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("idolId", id);
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.postCallBack(mActivity, Constant.GUARDIAN_IDOL, map, BaseVO.class, this);
    }

    @Override
    public void success(BaseVO vo) {
        showCustomToast(vo.getMsg());
        getGuardStar();
        getData();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.base_back_tv:
                openActivity(MainActivity.class);
                break;
            case R.id.search_tv:
                if (TextUtils.isEmpty(mKeyword)) {
                    return;
                }
                searchIdos();
                break;
            default:
                break;
        }

    }


    public void getGuardStar() {
        HashMap<String, Object> idolMap = new HashMap<>();
        idolMap.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.get(mActivity, this, Constant.MY_IDOLS, idolMap, MyIdolsVO.class);
    }

    public void searchIdos() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        map.put("pageNum", mCurrentPage + "");
        map.put("pageSize", "10");
        map.put("name", mKeyword);
        StartHttpUtils.get(mActivity, this, Constant.FIND_IDOLS_BY_PAGE, map, StarVO.class);
    }
}
