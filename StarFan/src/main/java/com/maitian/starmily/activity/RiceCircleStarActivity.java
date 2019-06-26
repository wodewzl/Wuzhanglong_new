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

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.StarAdapter;
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

public class RiceCircleStarActivity extends BaseActivity implements BGAOnRVItemClickListener, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener, PostCallback , View.OnClickListener {

    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private StarAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String mKeyword;
    private EditText mSearchEt;
    private ImageView mDeleteIv;
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.home_promotions_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("明星守护");
        mBaseOkTv.setText("完成");
        mSearchEt = getViewById(R.id.search_et);
        mDeleteIv = getViewById(R.id.delete_iv);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new StarAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, true);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mBaseOkTv.setOnClickListener(this);
        mSearchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!TextUtils.isEmpty(charSequence)) {
                    mDeleteIv.setVisibility(View.VISIBLE);
                    mKeyword= (String) charSequence;
                } else {
                    mDeleteIv.setVisibility(View.GONE);
                    mKeyword="";
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
    }

    @Override
    public void hasData(BaseVO vo) {
        if(vo instanceof StarVO){
            StarVO starVO = (StarVO) vo;
            if (starVO.getObj().isHasNextPage()) {
                mRecyclerView.setNoMore(false);
            } else {
                mRecyclerView.setNoMore(true);
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
        }else if(vo instanceof MyIdolsVO){
            MyIdolsVO myIdolsVO = (MyIdolsVO) vo;
            if (myIdolsVO.getObj().size() > 0)
                AppApplication.getInstance().saveMyIdolsVO(myIdolsVO);
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
//        if (mAdapter.getData().size() == 0)
//            return;
//
//        MyMessageVO.DataBean.ListBean vo= (MyMessageVO.DataBean.ListBean) mAdapter.getItem(position);
//
//        Bundle bundle = new Bundle();
//        bundle.putString("url", vo.getDetail_url());
//        bundle.putString("title", "消息详情");
//        open(WebViewActivity.class, bundle, 0);
    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
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
        showCustomToast("守护成功");
        getGuardStar();
    }

    @Override
    public void onClick(View view) {
        openActivity(MainActivity.class);
    }


    public void getGuardStar(){
        HashMap<String, Object> idolMap = new HashMap<>();
        idolMap.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.get(mActivity, this, Constant.MY_IDOLS, idolMap, MyIdolsVO.class);
    }
}
