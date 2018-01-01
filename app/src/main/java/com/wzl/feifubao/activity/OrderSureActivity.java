package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;

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
