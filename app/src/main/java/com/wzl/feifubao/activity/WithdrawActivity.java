package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;

public class WithdrawActivity extends BaseActivity {
    private TextView mOkTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_withdraw);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("提现");
        mOkTv = getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.colorAccent, R.color.colorAccent));
    }

    @Override
    public void bindViewsListener() {

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
}
