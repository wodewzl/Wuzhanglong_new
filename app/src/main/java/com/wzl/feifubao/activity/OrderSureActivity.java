package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.PaymentRecordsVO;

import java.util.HashMap;

public class OrderSureActivity extends BaseActivity {

    View mXuxian;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_order_sure);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("确认订单");
        mXuxian = getViewById(R.id.xuxian);
        mXuxian.setBackground(BaseCommonUtils.setBackgroundShap(this, 0, R.color.FUBColor7, R.color.FUBColor7, 1));
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

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }
}
