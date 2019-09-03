package com.wzl.feifubao.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.AddressSelectAdapter;
import com.wzl.feifubao.mode.AddresslistBean;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;


public class AddressSelectActivity extends BaseActivity implements BGAOnRVItemClickListener, View.OnClickListener {
    private RecyclerView mRecyclerView;
    private AddressSelectAdapter mAdapter;
    private Button mAddBt;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.address_activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initView() {
        mBaseTitleTv.setText("选择地址");
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mAutoSwipeRefreshLayout.setEnabled(false);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AddressSelectAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_10, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAddBt = getViewById(R.id.add_bt);
        mAddBt.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.colorAccent, R.color.colorAccent));
        List<AddresslistBean> list = (List<AddresslistBean>) this.getIntent().getSerializableExtra("list");
        mAdapter.updateData(list);
    }

    @Override
    public void bindViewsListener() {
        mAdapter.setOnRVItemClickListener(this);
        mAddBt.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void getData() {
        showView();
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
    public void onRVItemClick(ViewGroup viewGroup, View view, int i) {
        if (mAdapter.getData().size() == 0)
            return;
        EBMessageVO vo = new EBMessageVO("order_change");
        AddresslistBean addressVO = (AddresslistBean) mAdapter.getData().get(i);
        String[] params = new String[5];
        params[0] = addressVO.getConsigner();
        params[1] = addressVO.getMobile();
        params[2] = addressVO.getAddress();
        params[3] = addressVO.getAddress_info();
        params[4] = addressVO.getId();
        vo.setParams(params);
        EventBus.getDefault().post(vo);
        this.finish();
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
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {
        if ("refresh".equals(event.getMessage())) {
            this.finish();
        }
    }
}
