package com.wzl.feifubao.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

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
import com.wzl.feifubao.adapter.LifeAdapter;
import com.wzl.feifubao.adapter.RateQueryAdapter;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.RateQueryVO;

import java.util.HashMap;

public class RateQueryActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTitle1, mTitle2;
    private RateQueryVO.DataBean mTodayBean, mYestadyBean;
    private String mTag = "";

    private LuRecyclerView mRecyclerView;
    private RateQueryAdapter mAdapter;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_exchange_rate_query);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("汇率查询");
        mBaseOkTv.setText("汇率计算");
        mTitle1 = getViewById(R.id.title1);
        mTitle2 = getViewById(R.id.title2);

        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new RateQueryAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadMoreEnabled(false);
    }

    @Override
    public void bindViewsListener() {
        mTitle1.setOnClickListener(this);
        mTitle2.setOnClickListener(this);
        mBaseOkTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("tag", mTag);
        HttpGetDataUtil.get(mActivity, this, Constant.RATE_URL, map, RateQueryVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        RateQueryVO rateQueryVO = (RateQueryVO) vo;
        RateQueryVO.DataBean dataBean = rateQueryVO.getData();

        if ("local".equals(mTag)) {
            mYestadyBean = dataBean;
            mAdapter.updateData(mYestadyBean.getRate());
        } else {
            mTodayBean = dataBean;
            mAdapter.updateData(mTodayBean.getRate());
        }

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
            case R.id.title1:
                mTitle1.setBackgroundResource(R.drawable.corners_tab_left_select);
                mTitle1.setTextColor(ContextCompat.getColor(this, R.color.C1));
                mTitle2.setBackgroundResource(R.drawable.corners_tab_right_normal);
                mTitle2.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                if (mYestadyBean == null) {
                    mTag = "local";
                    getData();
                } else {
                    mAdapter.updateData(mYestadyBean.getRate());

                }
                break;
            case R.id.title2:
                mTitle2.setBackgroundResource(R.drawable.corners_tab_right_select);
                mTitle2.setTextColor(ContextCompat.getColor(this, R.color.C1));
                mTitle1.setBackgroundResource(R.drawable.corners_tab_left_normal);
                mTitle1.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                if (mTodayBean == null) {
                    mTag = "now";
                    getData();
                } else {
                    mAdapter.updateData(mTodayBean.getRate());

                }
                break;
            case R.id.base_ok_tv:
                openActivity(RateExchageActivity.class);
                break;
            default:
                break;
        }
    }
}
