package com.beisheng.snatch.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.AddressDialogAdapter;
import com.beisheng.snatch.adapter.MyLuckyRecordAdapter;
import com.beisheng.snatch.adapter.MyShowAdapter;
import com.beisheng.snatch.adapter.ShowAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.MyLuckyRecordVO;
import com.beisheng.snatch.model.ShowVO;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.CheckBox;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.BottomDialogUtil;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

public class MyShowRecordFragment extends BaseFragment implements OnLoadMoreListener, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private MyShowAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String type = "1";
    private TextView mOkTv;
    private LinearLayout mBottomLayout;

    public static MyShowRecordFragment newInstance() {
        MyShowRecordFragment fragment = new MyShowRecordFragment();
        return fragment;
    }

    @Override
    public void noNet() {

    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.my_show_record_fragment);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new MyShowAdapter(mRecyclerView);
        mAdapter.setType(type);
        RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, true);
        mOkTv = getViewById(R.id.ok_tv);
        mBottomLayout = getViewById(R.id.bottom_layout);
    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mOkTv.setOnClickListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", "10002");
        map.put("curpage", mCurrentPage + "");
        map.put("type", this.getType());
        BSHttpUtils.get(mActivity, this, Constant.MY_ORDER_SHOW, map, ShowVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        ShowVO bean = (ShowVO) vo;
        if (BaseCommonUtils.parseInt(bean.getData().getCount()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(bean.getData().getCount())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        List<ShowVO.DataBean.ListBean> list = bean.getData().getList();
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
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        getData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_tv:

                break;

            default:
                break;
        }

    }

}
