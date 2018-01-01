package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.adapter.TieAdapter;
import com.dou361.dialogui.bean.BuildBean;
import com.dou361.dialogui.bean.TieBean;
import com.dou361.dialogui.listener.DialogUIItemListener;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.RateQueryVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RateExchageActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private LinearLayout mChageLayout;
    private EditText mMoneyEt;
    private TextView mMoneyTv, mOkTv;
    private String mTag = "CNY";

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_rate_exchage);
    }

    @Override
    public void initView() {
        mChageLayout = getViewById(R.id.change_layout);
        mMoneyEt = getViewById(R.id.money_et);
        mMoneyTv = getViewById(R.id.money_tv);
        mOkTv = getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this,30,R.color.colorAccent,R.color.colorAccent));
    }

    @Override
    public void bindViewsListener() {
        mChageLayout.setOnClickListener(this);
        mOkTv.setOnClickListener(this);
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.change_layout:
                List<TieBean> datas = new ArrayList<TieBean>();
                datas.add(new TieBean("人民币 CNY"));
                datas.add(new TieBean("美元 USD"));
                datas.add(new TieBean("日元 JPY"));
                datas.add(new TieBean("港币 HKD"));
                datas.add(new TieBean("欧元 EUR"));
                datas.add(new TieBean("英镑 GBP"));
                TieAdapter adapter = new TieAdapter(this, datas, true);
                BuildBean buildBean = DialogUIUtils.showMdBottomSheet(mActivity, true, "", datas, 0, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        String str = (String) text;
                        String[] array = str.split(" ");
                        mTag = array[1];
                    }
                });
                buildBean.mAdapter = adapter;
                buildBean.show();

                break;

            case R.id.ok_tv:
                if (TextUtils.isEmpty(mMoneyEt.getText().toString())) {
                    showCustomToast("请输入金额");
                    return;
                }
                HashMap<String, Object> map = new HashMap<>();
                map.put("num", mMoneyEt.getText().toString());
                map.put("tag", mTag);
                HttpGetDataUtil.post(mActivity, Constant.RATE_EXCHANGE_URL, map, RateQueryVO.class, this);
                break;
            default:
                break;
        }
    }

    @Override
    public void success(BaseVO vo) {
        RateQueryVO rateQueryVO = (RateQueryVO) vo;
        RateQueryVO.DataBean dataBean = rateQueryVO.getData();
        mMoneyTv.setText(dataBean.getMoney());

        showCustomToast("换算成功");
    }
}
