package com.beisheng.snatch.activity;

import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.MyScortRecordAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.CardPasswordVO;
import com.beisheng.snatch.model.MyScortRecordVO;
import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.bean.BuildBean;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class MyScortRecordActivity extends BaseActivity implements BGAOnRVItemClickListener, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener,BGAOnItemChildClickListener ,PostCallback{
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private MyScortRecordAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_scort_record_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("兑换记录");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new MyScortRecordAdapter(mRecyclerView);
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
        mAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        map.put("curpage", mCurrentPage + "");
        BSHttpUtils.post(mActivity, this, Constant.MY_SCORT_RECORD_URL, map, MyScortRecordVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        MyScortRecordVO bean = (MyScortRecordVO) vo;
        if (BaseCommonUtils.parseInt(bean.getData().getCount()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(bean.getData().getCount())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        List<MyScortRecordVO.DataBean.ListBean> list = bean.getData().getList();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
        } else {
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
        mCurrentPage++;
        getData();
    }

    @Override
    public void onItemChildClick(ViewGroup parent, View childView, int position) {
        MyScortRecordVO.DataBean.ListBean bean= (MyScortRecordVO.DataBean.ListBean) mAdapter.getItem(position);
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        map.put("id", bean.getId());
        map.put("type", "1");
        BSHttpUtils.postCallBack(mActivity, Constant.CARD_PWD_URL, map, CardPasswordVO.class, this);
    }

    @Override
    public void success(BaseVO vo) {
        CardPasswordVO bean = (CardPasswordVO) vo;
        showDialog(bean);
    }

    public void showDialog(CardPasswordVO bean) {
        DialogUIUtils.init(mActivity);
        View rootView = View.inflate(mActivity, R.layout.card_password_dialog, null);
        TextView statusTv = rootView.findViewById(R.id.status_tv);
        statusTv.setText(bean.getData().getStatus_text());
        if ("2".equals(bean.getData().getStatus())) {
            statusTv.setBackgroundResource(R.drawable.corners_5_gary);
            statusTv.setTextColor(ContextCompat.getColor(mActivity, R.color.C5));
        } else {
            statusTv.setBackgroundResource(R.drawable.corners_5_red);
            statusTv.setTextColor(ContextCompat.getColor(mActivity, R.color.C1));
        }
        TextView numberTv = rootView.findViewById(R.id.number_tv);
        numberTv.setVisibility(View.INVISIBLE);

        TextView contentTv = rootView.findViewById(R.id.content_tv);
        contentTv.setText("兑换码：" + bean.getData().getVirtual_code());
        final BuildBean buildBean = DialogUIUtils.showCustomAlert(mActivity, rootView);
        buildBean.show();
    }
}
