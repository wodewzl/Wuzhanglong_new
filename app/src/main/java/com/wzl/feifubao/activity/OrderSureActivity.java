package com.wzl.feifubao.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.OrderSureAdapter;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.OrderSureVO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.Serializable;
import java.util.HashMap;

public class OrderSureActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mAddAddressLayout;
    private RelativeLayout mAddressLayout;
    View mXuxian;
    private TextView mNameTv, mPhoneTv, mAddressTv;
    private OrderSureVO.DataBean mDataBean;
    private LuRecyclerView mRecyclerView;
    private OrderSureAdapter mAdapter;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_order_sure);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("确认订单");
        mXuxian = getViewById(R.id.xuxian);
        mXuxian.setBackground(BaseCommonUtils.setBackgroundShap(this, 0, R.color.FUBColor7, R.color.FUBColor7, 1));
        mAddAddressLayout = getViewById(R.id.add_address_layout);
        mAddressLayout = getViewById(R.id.address_layout);
        mNameTv = getViewById(R.id.name_tv);
        mAddressTv = getViewById(R.id.address_tv);
        mPhoneTv = getViewById(R.id.phone_tv);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        mAdapter = new OrderSureAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);

        mRecyclerView.setLoadMoreEnabled(false);
    }

    @Override
    public void bindViewsListener() {
        mAddressLayout.setOnClickListener(this);
        mAddAddressLayout.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void getData() {

        HashMap<String, Object> map = new HashMap<>();
//        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("uid", "39");
        map.put("sku_list", this.getIntent().getStringExtra("sku_list"));

        HttpGetDataUtil.get(mActivity, this, Constant.COMMIT_ORDER_URL, map, OrderSureVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        OrderSureVO orderSureVO = (OrderSureVO) vo;
        mDataBean = orderSureVO.getData();
        if ("1".equals(mDataBean.getAddress_is_have())) {
            mAddressLayout.setVisibility(View.VISIBLE);
            mAddAddressLayout.setVisibility(View.GONE);
            mNameTv.setText("收货人："+mDataBean.getAddresslist().get(0).getConsigner());
            mPhoneTv.setText(""+mDataBean.getAddresslist().get(0).getMobile());
            mAddressTv.setText(mDataBean.getAddresslist().get(0).getAddress_info()+mDataBean.getAddresslist().get(0).getAddress());
        } else {
            mAddressLayout.setVisibility(View.GONE);
            mAddAddressLayout.setVisibility(View.VISIBLE);
        }

        if(mDataBean.getList()!=null&&mDataBean.getList().size()>0){
            mAdapter.updateData(mDataBean.getList());
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
            case R.id.address_layout:
                Bundle bundle = new Bundle();
                bundle.putSerializable("list", (Serializable) mDataBean.getAddresslist());
                open(AddressSelectActivity.class, bundle, 0);
                break;
            case R.id.add_address_layout:
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
        if ("refresh".equals(event.getMessage())) {
            getData();
        }
    }


}
