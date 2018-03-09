package com.beisheng.snatch.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.HomeAdapter;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.rey.material.app.BottomSheetDialog;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class TabOneChildFragment extends BaseFragment implements OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{
    private LuRecyclerView mRecyclerView;
    private HomeAdapter mAdapter;
    private LuRecyclerViewAdapter mLuAdapter;
    private String state;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private BottomSheetDialog mDialog;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new TabOneChildFragment();
        return fragment;
    }

    @Override
    public void noNet() {

    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_one_child_fragment);
    }

    @Override
    public void initView(View view) {
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new HomeAdapter(mRecyclerView);
        mLuAdapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(mLuAdapter);
        mRecyclerView.setLoadMoreEnabled(false);

    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        EventBus.getDefault().register(this);
    }


    @Override
    public void getData() {

    }

    @Override
    public void hasData(BaseVO vo) {

//        if (vo.getHasmore() != null && "1".equals(vo.getHasmore())) {
//            mRecyclerView.setNoMore(false);
//        } else {
//            mRecyclerView.setNoMore(true);
//        }
//        if (isLoadMore) {
//            mAdapter.updateDataLast(list);
//            isLoadMore = false;
//            mCurrentPage++;
//        } else {
//            mCurrentPage++;
//            mAdapter.updateData(list);
//        }
//        mAutoSwipeRefreshLayout.setRefreshing(false);
//        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void noData(BaseVO vo) {

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    @Override
    public void onLoadMore() {
        isLoadMore = true;

    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;

    }




    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {
        if ("kuaiqian_pay".equals(event.getMessage()) && "1".equals(state)) {
            mActivity.showCustomToast("支付成功");

            mDialog.dismiss();
        }

        if ("weixin_pay".equals(event.getMessage())&& "1".equals(state)) {
            mActivity.showCustomToast("支付成功");
            mDialog.dismiss();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


}
