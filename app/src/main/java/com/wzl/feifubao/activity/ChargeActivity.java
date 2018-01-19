package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.mode.PayResult;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.PayUtis;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.HashMap;

public class ChargeActivity extends BaseActivity implements View.OnClickListener, PostCallback, CompoundButton.OnCheckedChangeListener {
    private CheckBox mPayCb1, mPayCb2;
    private String mPayType = "2";
    private EditText mEt01;
    private TextView mOkTv;
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_charge);
    }

    @Override
    public void initView() {
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
            case R.id.ok_tv:

                break;
            default:
                break;
        }
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
    public void success(BaseVO vo) {

    }

//    public void pay(String orderNo, String money) {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
//        map.put("out_trade_no", orderNo);
//        map.put("pay_type", mPayType);
////        map.put("payment", money);
//        map.put("payment", "0.01");
////        HttpGetDataUtil.post(this, Constant.SURE_ORDER2_URL, map, OrderPayVO.class,this);
//
//        new Novate.Builder(ChargeActivity.this)
//                .baseUrl(BaseConstant.DOMAIN_NAME)
//                .addCache(false)
//                .build().rxPost(Constant.SURE_ORDER2_URL, map, new RxStringCallback() {
//
//
//            @Override
//            public void onError(Object o, Throwable throwable) {
//
//                System.out.println("=============");
//            }
//
//            @Override
//            public void onCancel(Object o, Throwable throwable) {
//
//                System.out.println("=============");
//            }
//
//            @Override
//            public void onNext(Object o, String s) {
//                try {
//                    JSONObject jsonObject = new JSONObject(s);
//                    int code = (int) jsonObject.get("code");
//                    if (code == 200) {
//                        if ("1".equals(mPayType)) {
//                            Gson gson = new Gson();
//                            final PayResult vo = gson.fromJson(s, PayResult.class);
//                            PayUtis.weiXinPay(ChargeActivity.this, vo.getData());
//                        } else {
//                            String payInfo = (String) jsonObject.get("data");
//                            PayUtis.zhiFuBaoPay(ChargeActivity.this, payInfo, new PayCallback() {
//                                @Override
//                                public void payResult(int type) {
//                                    ;
//                                    if (type == 1) {
//                                        showCustomToast(vo.getMessage());
//                                        EventBus.getDefault().post(new EBMessageVO("over_update"));
//                                    } else {
//                                        showCustomToast("支付失败");
//                                    }
//                                }
//                            });
//                        }
//
//                    } else {
//
//                    }
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//
//
//            }
//        });
//    }
}
