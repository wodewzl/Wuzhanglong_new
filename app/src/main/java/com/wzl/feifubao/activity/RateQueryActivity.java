package com.wzl.feifubao.activity;

import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wzl.feifubao.R;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.RateQueryVO;

import java.util.HashMap;

public class RateQueryActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTitle1, mTitle2, mCnyTv, mUsdTv, mJpyTv, mHkdTv, mEurTv, mGbpTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_exchange_rate_query);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("汇率查询");
        mTitle1 = getViewById(R.id.title1);
        mTitle2 = getViewById(R.id.title2);
        mCnyTv = getViewById(R.id.cny_tv);
        mUsdTv = getViewById(R.id.usd_tv);
        mJpyTv = getViewById(R.id.jpy_tv);
        mHkdTv = getViewById(R.id.hkd_tv);
        mEurTv = getViewById(R.id.eur_tv);
        mGbpTv = getViewById(R.id.gbp_tv);

    }

    @Override
    public void bindViewsListener() {
        mTitle1.setOnClickListener(this);
        mTitle2.setOnClickListener(this);

    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        HttpGetDataUtil.get(mActivity, this, Constant.RATE_URL, map, RateQueryVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        RateQueryVO rateQueryVO= (RateQueryVO) vo;
        RateQueryVO.DataBean dataBean=rateQueryVO.getData();
        mCnyTv.setText(dataBean.getCNY());
        mUsdTv.setText(dataBean.getUSD());
        mJpyTv.setText(dataBean.getJPY());
        mHkdTv.setText(dataBean.getHKD());
        mEurTv.setText(dataBean.getEUR());
        mGbpTv.setText(dataBean.getGBP());
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
            case R.id.title1:
                mTitle1.setBackgroundResource(R.drawable.corners_tab_left_select);
                mTitle1.setTextColor(ContextCompat.getColor(this,R.color.C1));
                mTitle2.setBackgroundResource(R.drawable.corners_tab_right_normal);
                mTitle2.setTextColor(ContextCompat.getColor(this,R.color.colorAccent));
                break;
            case R.id.title2:
                mTitle2.setBackgroundResource(R.drawable.corners_tab_right_select);
                mTitle2.setTextColor(ContextCompat.getColor(this,R.color.C1));
                mTitle1.setBackgroundResource(R.drawable.corners_tab_left_normal);
                mTitle1.setTextColor(ContextCompat.getColor(this,R.color.colorAccent));
                break;
            default:
                break;
        }
    }
}
