package com.wzl.feifubao.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.alipay.android.phone.mrpc.core.ThreadUtil;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.AddressSelectAdapter;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.AddressVO;

import org.greenrobot.eventbus.EventBus;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;


public class AddressSelectActivity extends BaseActivity implements BGAOnRVItemClickListener,View.OnClickListener{
    private RecyclerView mRecyclerView;
    private AddressSelectAdapter mAdapter;
    private Button mAddBt;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.address_activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initView() {
        mBaseTitleTv.setText("选择地址");
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new AddressSelectAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_10, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAddBt=getViewById(R.id.add_bt);
    }

    @Override
    public void bindViewsListener() {
        mAdapter.setOnRVItemClickListener(this);
        mAddBt.setOnClickListener(this);
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
        EBMessageVO vo = new EBMessageVO("order");
        AddressVO addressVO = (AddressVO) mAdapter.getData().get(i);
        String[] params = new String[4];
//        params[0] = addressVO.getTrue_name();
//        params[1] = addressVO.getMob_phone();
//        params[2] = addressVO.getArea_info();
//        params[3] = addressVO.getAddress_id();
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
}
