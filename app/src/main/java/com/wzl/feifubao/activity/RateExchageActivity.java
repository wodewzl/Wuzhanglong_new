package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
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
    private TextView mMoneyTv, mOkTv, mFromTv;
    private String mFrom = "PHP";
    private String mTo = "CNY";
    private TextView mTypeTv;
    private LinearLayout mFromLayout;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_rate_exchage);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("汇率计算");
        mChageLayout = getViewById(R.id.change_layout);
        mMoneyEt = getViewById(R.id.money_et);
        mMoneyTv = getViewById(R.id.money_tv);
        mOkTv = getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.colorAccent, R.color.colorAccent));
        mTypeTv = getViewById(R.id.type_tv);
        mFromLayout = getViewById(R.id.from_layout);
        mFromTv = getViewById(R.id.from_tv);
    }

    @Override
    public void bindViewsListener() {
        mChageLayout.setOnClickListener(this);
        mOkTv.setOnClickListener(this);
        mFromLayout.setOnClickListener(this);
        mMoneyEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {


            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() > 0) {
                    commit();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
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
                setContury("2");
                break;

            case R.id.from_layout:
                setContury("1");
                break;

            case R.id.ok_tv:
                if (TextUtils.isEmpty(mMoneyEt.getText().toString())) {
                    showCustomToast("请输入金额");
                    return;
                }
                showProgressDialog();
                HashMap<String, Object> map = new HashMap<>();
                map.put("num", mMoneyEt.getText().toString());
                map.put("from", mFrom);
                map.put("to", mTo);
                HttpGetDataUtil.post(mActivity, Constant.RATE_EXCHANGE_URL, map, RateQueryVO.class, this);
                break;
//            mActivity.openActivity(RateExchageActivity.class);
            default:
                break;
        }
    }

    public void commit() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("num", mMoneyEt.getText().toString());
        map.put("from", mFrom);
        map.put("to", mTo);
        HttpGetDataUtil.post(mActivity, Constant.RATE_EXCHANGE_URL, map, RateQueryVO.class, this);
    }

    @Override
    public void success(BaseVO vo) {
        dismissProgressDialog();
        RateQueryVO rateQueryVO = (RateQueryVO) vo;
        RateQueryVO.DataBean dataBean = rateQueryVO.getData();
        mMoneyTv.setText(dataBean.getMoney());

//        showCustomToast("换算成功");
    }

    public void setContury(final String type) {
        List<TieBean> datas = new ArrayList<TieBean>();
        datas.add(new TieBean("人民币 CNY"));
        datas.add(new TieBean("美元 USD"));
        datas.add(new TieBean("日元 JPY"));
        datas.add(new TieBean("港币 HKD"));
        datas.add(new TieBean("欧元 EUR"));
        datas.add(new TieBean("英镑 GBP"));
        datas.add(new TieBean("比索 PHP"));
        final TieAdapter adapter = new TieAdapter(this, datas, true);
        final BuildBean buildBean = DialogUIUtils.showMdBottomSheet(mActivity, true, "", datas, 0, new DialogUIItemListener() {
            @Override
            public void onItemClick(CharSequence text, int position) {
                String str = (String) text;
                String[] array = str.split(" ");
                if ("1".equals(type)) {
                    mFrom = array[1];
                    mFromTv.setText(str);
                } else {
                    mTo = array[1];
                    mTypeTv.setText(str);
                }

            }
        });
        buildBean.mAdapter = adapter;
        buildBean.show();
    }
}
