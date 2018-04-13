package com.beisheng.snatch.activity;

import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.MoneyAdapter;
import com.beisheng.snatch.model.MyFlowVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;

import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class BuyFlowActivity extends BaseActivity implements BGAOnRVItemClickListener{
    private String[] mOneyArray = {"100M", "300M", "500M", "1G", "2G", "3G"};
    private LuRecyclerView mRecyclerView;
    private MoneyAdapter mAdapter;
    private MyFlowVO mSelectVO;
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.buy_flow_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("买流量");
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        mAdapter = new MoneyAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadMoreEnabled(false);
    }

    @Override
    public void bindViewsListener() {
        mAdapter.setOnRVItemClickListener(this);
    }

    @Override
    public void getData() {
        showView();
        List<MyFlowVO> list = new ArrayList<>();
        for (int i = 1; i <= mOneyArray.length; i++) {
            MyFlowVO myFlowVO = new MyFlowVO();
            myFlowVO.setMoney(mOneyArray[i - 1]);
            if (i == 1) {
                mSelectVO = myFlowVO;
                myFlowVO.setSelect(true);
            }
            myFlowVO.setId(i + "");
            list.add(myFlowVO);
        }

        mAdapter.updateData(list);
    }

    @Override
    public void hasData(BaseVO vo) {

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        MyFlowVO myFlowVO = (MyFlowVO) mAdapter.getItem(position);
        if (mSelectVO != null) {
            mSelectVO.setSelect(false);
        }
        mSelectVO = myFlowVO;
        mSelectVO.setSelect(true);
        mAdapter.notifyDataSetChanged();
    }
}
