package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rey.material.widget.CheckBox;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.PayResult;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.PayUtis;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.OrderCrateVO;

import org.json.JSONObject;

import java.util.HashMap;

public class PayElectricityActivity extends BaseActivity implements View.OnClickListener, PostCallback, CompoundButton.OnCheckedChangeListener {
    private CheckBox mPayCb1, mPayCb2;
    private String mPayType = "2";
    private EditText mEt01,mEt02,mEt03,mEt04;
    private TextView mOkTv;
    private String mType;
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_pay_electricity);
    }

    @Override
    public void initView() {
        mType=this.getIntent().getStringExtra("type");
        if("1".equals(mType)){
            mBaseTitleTv.setText("电费充值");
        }else {
            mBaseTitleTv.setText("网费充值");
        }


        mEt02=getViewById(R.id.et_02);
        mEt04=getViewById(R.id.et_04);
        mPayCb1 = getViewById(R.id.pay_cb_1);
        mPayCb2 = getViewById(R.id.pay_cb_2);
        mOkTv = getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.colorAccent, R.color.colorAccent));
    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
        mPayCb1.setOnCheckedChangeListener(this);
        mPayCb2.setOnCheckedChangeListener(this);
        mPayCb1.setChecked(true);
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
    public void onCheckedChanged(CompoundButton v, boolean b) {
        switch (v.getId()) {
            case R.id.pay_cb_1:
                if (b) {
                    mPayCb2.setChecked(false);
                }

                break;
            case R.id.pay_cb_2:
                if (b) {
                    mPayCb1.setChecked(false);
                }
                break;


            default:
                break;
        }

        if (mPayCb1.isChecked()) {
            mPayType = "2";
        } else {
            mPayType = "1";
        }
    }

    @Override
    public void onClick(View view) {
        commit();
    }

    @Override
    public void success(BaseVO vo) {
        if (vo instanceof OrderCrateVO) {
            OrderCrateVO orderCrateVO = (OrderCrateVO) vo;
            pay(orderCrateVO.getData().getOut_trade_no(), orderCrateVO.getData().getPay_rmb());
        }
    }

    public void pay(String orderNo, String money) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("out_trade_no", orderNo);
        map.put("pay_type", mPayType);
//        map.put("payment", money);
        map.put("payment", "0.01");
//        HttpGetDataUtil.post(this, Constant.SURE_ORDER2_URL, map, OrderPayVO.class,this);

        new Novate.Builder(PayElectricityActivity.this)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build().rxPost(Constant.SURE_ORDER2_URL, map, new RxStringCallback() {


            @Override
            public void onError(Object o, Throwable throwable) {

                System.out.println("=============");
            }

            @Override
            public void onCancel(Object o, Throwable throwable) {

                System.out.println("=============");
            }

            @Override
            public void onNext(Object o, String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    int code = (int) jsonObject.get("code");
                    if (code == 200) {
                        if ("1".equals(mPayType)) {
                            Gson gson = new Gson();
                            final PayResult vo = gson.fromJson(s, PayResult.class);
                            PayUtis.weiXinPay(PayElectricityActivity.this, vo.getData());
                        } else {
                            String payInfo = (String) jsonObject.get("data");
                            PayUtis.zhiFuBaoPay(PayElectricityActivity.this, payInfo, new PayCallback() {
                                @Override
                                public void payResult(int type) {
                                    ;
                                    if (type == 1) {
                                        payFinish();
                                    } else {
                                        showCustomToast("支付失败");
                                    }
                                }
                            });
                        }

                    } else {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }

    public void payFinish() {
        showCustomToast("支付成功");
        mOkTv.postDelayed(new Runnable() {
            @Override
            public void run() {
                Bundle bundle = new Bundle();
                bundle.putString("type", mType);
                mActivity.open(PaymentRecordsActivity.class, bundle, 0);
                PayElectricityActivity.this.finish();
            }


        }, 1000);
    }

    public void commit() {
        if (TextUtils.isEmpty(mEt02.getText().toString())) {
            showCustomToast("请输入户号");
            return;
        }
        if (TextUtils.isEmpty(mEt04.getText().toString())) {
            showCustomToast("请输入金额");
            return;
        }


        showProgressDialog();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("type", mType);
        map.put("bill_num", mEt02.getText().toString());
        map.put("payment", mEt04.getText().toString());
        HttpGetDataUtil.post(this, Constant.CHAGE_URL, map, OrderCrateVO.class, this);
    }

}
