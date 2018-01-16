package com.wzl.feifubao.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wuzhanglong.library.view.PinnedHeaderDecoration;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.PaymentRecordAdapter;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.PaymentRecordsVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaymentRecordsActivity extends BaseActivity implements OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private PaymentRecordAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String mType;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_payment_records);
    }

    @Override
    public void initView() {

        mType=this.getIntent().getStringExtra("type");
        if("1".equals(mType)){
            mBaseTitleTv.setText("电费");
        }else if("2".equals(mType)){
            mBaseTitleTv.setText("网费");
        }else if("3".equals(mType)){
            mBaseTitleTv.setText("手机费");
        }
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        final PinnedHeaderDecoration decoration = new PinnedHeaderDecoration();
        decoration.registerTypePinnedHeader(R.layout.payment_record_adapter_type1, new PinnedHeaderDecoration.PinnedHeaderCreator() {
            @Override
            public boolean create(RecyclerView parent, int adapterPosition) {
                return true;
            }
        });
        mRecyclerView.addItemDecoration(decoration);

        mAdapter = new PaymentRecordAdapter(mRecyclerView);
        mAdapter.setType(mType);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("page", mCurrentPage+"");
        map.put("type",mType);
        map.put("pagesize", "10");
        HttpGetDataUtil.get(mActivity, this, Constant.PAYMENT_RECORDS_URL, map, PaymentRecordsVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        PaymentRecordsVO paymentRecordsVO = (PaymentRecordsVO) vo;

        if (BaseCommonUtils.parseInt(paymentRecordsVO.getData().getPage_count())==1 ) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(paymentRecordsVO.getData().getPage_count())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }

        List<PaymentRecordsVO.DataBeanX.DataBean> list = new ArrayList<>();

        for (int i = 0; i <paymentRecordsVO.getData().getData().size() ; i++) {
            if(i==0){
                PaymentRecordsVO.DataBeanX.DataBean firstBean=new PaymentRecordsVO.DataBeanX.DataBean();
                firstBean.setTypeView("1");
                firstBean.setCreate_time(paymentRecordsVO.getData().getData().get(0).getCreate_time());
                list.add(firstBean);
            }
            PaymentRecordsVO.DataBeanX.DataBean bean=paymentRecordsVO.getData().getData().get(i);
            bean.setTypeView("2");
            list.add(bean);
            if(paymentRecordsVO.getData().getData().size()-1==i){
                break;
            }
            if(!paymentRecordsVO.getData().getData().get(i).getCreate_time().split("-")[1].equals(paymentRecordsVO.getData().getData().get(i+1).getCreate_time().split("-")[1])){
                PaymentRecordsVO.DataBeanX.DataBean titleBean=new PaymentRecordsVO.DataBeanX.DataBean();
                titleBean.setTypeView("1");
                titleBean.setCreate_time(paymentRecordsVO.getData().getData().get(i+1).getCreate_time());
                list.add(titleBean);
            }

        }
                ;




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
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }
}
