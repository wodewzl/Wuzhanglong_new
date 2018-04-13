package com.beisheng.snatch.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.AddressAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.AddressVO;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.HashMap;


public class AddressActivity extends BaseActivity implements View.OnClickListener, PostCallback, SwipeRefreshLayout.OnRefreshListener {
    private RecyclerView mRecyclerView;
    private AddressAdapter mAdapter;
    private Button mAddBt;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.address_activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initView() {
        mBaseTitleTv.setText("地址管理");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AddressAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_10, R.color.C3);
        mAddBt = getViewById(R.id.add_bt);
        mRecyclerView.addItemDecoration(divider);
    }

    @Override
    public void bindViewsListener() {
        mAddBt.setOnClickListener(this);
        EventBus.getDefault().register(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        BSHttpUtils.post(mActivity, this, Constant.ADDRESS_LIST_URL, map, AddressVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        AddressVO addressVO = (AddressVO) vo;
        mAdapter.updateData(addressVO.getData());
        mAutoSwipeRefreshLayout.setRefreshing(false);
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
            case R.id.add_bt:
                openActivity(AddressAddActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {
        if ("address_delete".equals(event.getMessage())) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
            map.put("id", event.getMsg());
            BSHttpUtils.postCallBack(this, Constant.ADDRESS_DELETE_URL, map, BaseVO.class, this);
        } else if ("address_edit".equals(event.getMessage())) {
            getData();
        } else if ("address_defalut".equals(event.getMessage())) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
            map.put("id", event.getMsg());
            HttpGetDataUtil.post(this, Constant.ADDRESS_SET_URL, map, BaseVO.class, this);
        } else if ("refresh".equals(event.getMessage())) {
            mAutoSwipeRefreshLayout.autoRefresh();
        }
    }

    @Override
    public void success(BaseVO vo) {
        showSuccessToast(vo.getDesc());
    }

    @Override
    public void onRefresh() {
        getData();
    }
}
