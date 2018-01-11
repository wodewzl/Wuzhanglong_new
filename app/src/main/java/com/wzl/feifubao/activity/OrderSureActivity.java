package com.wzl.feifubao.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.OrderSureVO;
import com.wzl.feifubao.mode.PaymentRecordsVO;

import java.util.HashMap;

public class OrderSureActivity extends BaseActivity {
    private LinearLayout mAddAddressLayout;
    private RelativeLayout mAddressLayout;
    View mXuxian;
    private TextView mNameTv,mAddressTv;
    private OrderSureVO.DataBean mDataBean;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_order_sure);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("确认订单");
        mXuxian = getViewById(R.id.xuxian);
        mXuxian.setBackground(BaseCommonUtils.setBackgroundShap(this, 0, R.color.FUBColor7, R.color.FUBColor7, 1));
        mAddAddressLayout=getViewById(R.id.add_address_layout);
        mAddressLayout=getViewById(R.id.address_layout);
        mNameTv=getViewById(R.id.name_tv);
        mAddressTv=getViewById(R.id.address_tv);


    }

    @Override
    public void bindViewsListener() {

    }

    @Override
    public void getData() {

        HashMap<String, Object> map = new HashMap<>();
//        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("uid", "39");
        map.put("sku_list", this.getIntent().getStringExtra("sku_list"));

        HttpGetDataUtil.get(mActivity, this, Constant.COMMIT_ORDER_URL, map, PaymentRecordsVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        OrderSureVO orderSureVO= (OrderSureVO) vo;
        mDataBean=orderSureVO.getData();
        if("1".equals(mDataBean.getAddress_is_have())){
            mAddressLayout.setVisibility(View.VISIBLE);
            mAddAddressLayout.setVisibility(View.GONE);
        }else {
            mAddressLayout.setVisibility(View.GONE);
            mAddAddressLayout.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }
}
