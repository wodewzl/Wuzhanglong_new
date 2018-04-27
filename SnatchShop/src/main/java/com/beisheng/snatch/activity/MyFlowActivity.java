package com.beisheng.snatch.activity;

import android.support.v7.widget.GridLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.MoneyAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.MyFlowVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class MyFlowActivity extends BaseActivity implements BGAOnRVItemClickListener, View.OnClickListener, PostCallback {
    private String[] mOneyArray = {"100M", "300M", "500M", "1G", "2G", "3G"};
    private LuRecyclerView mRecyclerView;
    private MoneyAdapter mAdapter;
    private MyFlowVO mSelectVO;
    private TextView mOkTv, mPhoneTv, mFlowTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_flow_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("我的流量");
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        mAdapter = new MoneyAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadMoreEnabled(false);
        mOkTv = getViewById(R.id.ok_tv);
        mPhoneTv = getViewById(R.id.phone_tv);
        mFlowTv = getViewById(R.id.flow_tv);
        mFlowTv.setText(AppApplication.getInstance().getUserInfoVO().getData().getFlow() + "M");
        mBaseOkTv.setText("兑换记录");
    }

    @Override
    public void bindViewsListener() {
        mAdapter.setOnRVItemClickListener(this);
        mOkTv.setOnClickListener(this);
        mBaseOkTv.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_tv:
                if (TextUtils.isEmpty(mPhoneTv.getText().toString())) {
                    showCustomToast("请输入手机号");
                    return;
                }
                HashMap<String, Object> map = new HashMap<>();
                map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                map.put("flow_id", mSelectVO.getId());
                map.put("mobile", mPhoneTv.getText().toString());
                BSHttpUtils.postCallBack(mActivity, Constant.FLOW_EXCHANGE_URL, map, BaseVO.class, this);
                break;
            case R.id.base_ok_tv:
                openActivity(MyFlowRecordActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    public void success(BaseVO vo) {
        showSuccessToast(vo.getDesc());
    }
}
