package com.wzl.feifubao.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.CheckBox;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.PayResult;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.PayUtis;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.PayOrderVO;
import com.wzl.feifubao.mode.PaymentRecordsVO;

import org.json.JSONObject;

import java.util.HashMap;

public class PayStatusActivity extends BaseActivity implements View.OnClickListener {
    private LinearLayout mLayout01, mLayout02, mLayout03, mLayout04, mLayout05;
    private TextView mTv01, mTv02, mTv03, mTv04, mTv05, mTvValue01, mTvValue02, mTvValue03, mTvValue04, mTvValue05, mCancelTv, mOkTv, mPayStatusTv;
    private String mType = "1";
    private PayOrderVO.DataBean mDataBean;
    private BottomSheetDialog mDialog;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_pay_status);
    }

    @Override
    public void initView() {
        mLayout01 = getViewById(R.id.layout_01);
        mLayout02 = getViewById(R.id.layout_02);
        mLayout03 = getViewById(R.id.layout_03);
        mLayout04 = getViewById(R.id.layout_04);
        mLayout05 = getViewById(R.id.layout_05);
        mTv01 = getViewById(R.id.tv_01);
        mTv02 = getViewById(R.id.tv_02);
        mTv03 = getViewById(R.id.tv_03);
        mTv04 = getViewById(R.id.tv_04);
        mTv05 = getViewById(R.id.tv_05);
        mTvValue01 = getViewById(R.id.tv_value_01);
        mTvValue02 = getViewById(R.id.tv_value_02);
        mTvValue03 = getViewById(R.id.tv_value_03);
        mTvValue04 = getViewById(R.id.tv_value_04);
        mTvValue05 = getViewById(R.id.tv_value_05);
        mCancelTv = getViewById(R.id.cancle_tv);
        mOkTv = getViewById(R.id.ok_tv);
        mPayStatusTv = getViewById(R.id.pay_status_tv);
    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
        mCancelTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("order_id", this.getIntent().getStringExtra("order_id"));
        HttpGetDataUtil.get(mActivity, this, Constant.PAY_ORDER_URL, map, PayOrderVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {

        PayOrderVO payOrderVO = (PayOrderVO) vo;
        mDataBean = payOrderVO.getData();
        String type = mDataBean.getType();
        String payStatus = mDataBean.getPay_status();
        if ("2".equals(payStatus)) {
            mBaseTitleTv.setText("缴费成功");
            mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 15, R.color.colorAccent, R.color.colorAccent));
            mPayStatusTv.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pay_success, 0, 0);
            mCancelTv.setVisibility(View.GONE);
            mOkTv.setText("完成");

            mPayStatusTv.setText("恭喜你，缴费成功！");
        } else {
            mBaseTitleTv.setText("缴费失败");
            mCancelTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 15, R.color.FUBColor15, R.color.FUBColor15));
            mCancelTv.setVisibility(View.VISIBLE);
            mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 15, R.color.colorAccent, R.color.colorAccent));
            mPayStatusTv.setText("啊哦，缴费失败了！");
            mPayStatusTv.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.pay_fail, 0, 0);
            mOkTv.setText("继续支付");
        }

        if ("1".equals(type)) {
            mTv01.setText("订单号");
            mTv02.setText("户号");
            mTv03.setText("账单号");
            mTv04.setText("截止日期");
            mTv05.setText("缴费金额");
            mTvValue01.setText(mDataBean.getOrder_no());
            mTvValue02.setText(mDataBean.getBill_num());
            mTvValue03.setText(mDataBean.getAccount_number());
            mTvValue04.setText(mDataBean.getStoptime());
            BaseCommonUtils.setTextTwoBefore(this, mTvValue05, mDataBean.getPay_money(), "P", R.color.FUBColor3, 1.7f);
        } else if ("2".equals(type)) {
            mTv01.setText("订单号");
            mTv02.setText("户号");
            mTv03.setText("缴费金额");
            mLayout04.setVisibility(View.GONE);
            mLayout05.setVisibility(View.GONE);
            mTvValue01.setText(mDataBean.getOrder_no());
            mTvValue02.setText(mDataBean.getBill_num());
            BaseCommonUtils.setTextTwoBefore(this, mTvValue03, mDataBean.getPay_money(), "P", R.color.FUBColor3, 1.7f);
        } else {
            //手机号

            mLayout05.setVisibility(View.GONE);
            mTv01.setText("订单号");
            mTv02.setText("充值类型");
            mTv03.setText("充值号码");
            mTv04.setText("充值金额");
            mTvValue01.setText(mDataBean.getOrder_no());
            mTvValue02.setText(mDataBean.getCarrier_operator());
            mTvValue03.setText(mDataBean.getReceiver_mobile());
            mTvValue04.setTextColor(ContextCompat.getColor(this, R.color.FUBColor3));
            BaseCommonUtils.setTextTwoBefore(this, mTvValue04, mDataBean.getPay_money(), "P", R.color.FUBColor3, 1.7f);
        }
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
                if ("完成".equals(mOkTv.getText().toString())) {
                    this.finish();
                } else {
                    showPayDialog();
                }
                break;
            case R.id.cancle_tv:
                this.finish();
                break;
            default:
                break;
        }
    }

    public void pay(String orderNo, final String payType, String money) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("out_trade_no", orderNo);
        map.put("pay_type", payType);

        map.put("payment", money);

//        HttpGetDataUtil.post(this, Constant.SURE_ORDER2_URL, map, OrderPayVO.class,this);

        new Novate.Builder(PayStatusActivity.this)
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
                        if ("1".equals(payType)) {
                            Gson gson = new Gson();
                            final PayResult vo = gson.fromJson(s, PayResult.class);
                            PayUtis.weiXinPay(PayStatusActivity.this, vo.getData());
                        } else {
                            String payInfo = (String) jsonObject.get("data");
                            PayUtis.zhiFuBaoPay(PayStatusActivity.this, payInfo, new PayCallback() {
                                @Override
                                public void payResult(int type) {
                                    payFinish(type);
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


    public void showPayDialog() {
        mDialog = new BottomSheetDialog(mActivity);
        View dialogView = View.inflate(mActivity, R.layout.pay_view, null);
        final CheckBox payCb1 = (CheckBox) dialogView.findViewById(R.id.pay_cb_1);
        final CheckBox payCb2 = (CheckBox) dialogView.findViewById(R.id.pay_cb_2);
        Button payButton = (Button) dialogView.findViewById(R.id.commit_bt);
        payButton.setBackgroundDrawable(BaseCommonUtils.setBackgroundShap(mActivity, 5, R.color.colorAccent, R.color.colorAccent));
        LinearLayout payLayout01 = (LinearLayout) dialogView.findViewById(R.id.pay_layout_01);
        LinearLayout payLayout02 = (LinearLayout) dialogView.findViewById(R.id.pay_layout_02);


        mDialog.contentView(dialogView)
                .heightParam(ViewGroup.LayoutParams.WRAP_CONTENT)
                .inDuration(500)
                .cancelable(true)
                .show();

        payCb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    payCb2.setChecked(false);
                }
            }
        });
        payCb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    payCb1.setChecked(false);
                }
            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String payType = "";
                if (payCb1.isChecked()) {
                    payType = "2";
                } else if (payCb2.isChecked()) {
                    payType = "1";
                }

                pay(mDataBean.getOut_trade_no(), payType, mDataBean.getPay_rmb());
            }
        });
        payCb1.setChecked(true);
    }

    public void payFinish(int type) {

        if (type == 1) {
            showCustomToast("支付成功");
            this.finish();
        } else {

        }

    }
}
