package com.wzl.feifubao.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.lib.WheelView;
import com.google.gson.Gson;
import com.rey.material.widget.CheckBox;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.PayResult;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DateUtils;
import com.wuzhanglong.library.utils.NumberTypeUtil;
import com.wuzhanglong.library.utils.PayUtis;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.OrderCrateVO;

import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class PayElectricityActivity extends BaseActivity implements View.OnClickListener, PostCallback, CompoundButton.OnCheckedChangeListener {
    private CheckBox mPayCb1, mPayCb2;
    private String mPayType = "2";
    private EditText mEt01, mEt02, mEt03, mEt04;
    private TextView mOkTv, mTv05, mMoneTv;
    private String mType;
    private WheelView mDateWheelView;
    private String mOrderId = "";

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_pay_electricity);
    }

    @Override
    public void initView() {
        mType = this.getIntent().getStringExtra("type");
        mBaseTitleTv.setText("缴纳电费");


        mEt02 = getViewById(R.id.et_02);
        mEt03 = getViewById(R.id.et_03);
        mEt04 = getViewById(R.id.et_04);
        mTv05 = getViewById(R.id.tv_05);
        mPayCb1 = getViewById(R.id.pay_cb_1);
        mPayCb2 = getViewById(R.id.pay_cb_2);
        mMoneTv = getViewById(R.id.money_tv);
        mMoneTv.setVisibility(View.VISIBLE);
        mOkTv = getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.colorAccent, R.color.colorAccent));
        mBaseOkTv.setCompoundDrawablesRelativeWithIntrinsicBounds(R.drawable.help, 0, 0, 0);
    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
        mPayCb1.setOnCheckedChangeListener(this);
        mPayCb2.setOnCheckedChangeListener(this);
        mPayCb1.setChecked(true);
        mTv05.setOnClickListener(this);
        mBaseOkTv.setOnClickListener(this);
        mEt04.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String rate = ACache.get(PayElectricityActivity.this).getAsString("rate");
                String money = NumberTypeUtil.mul(Double.parseDouble(mEt04.getText().toString()), Double.parseDouble(rate)) + "";
                BaseCommonUtils.setTextThree(PayElectricityActivity.this, mMoneTv, "应付：", money, "元", R.color.FUBColor3, 1.5f);

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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_tv:
                commit();
                break;

            case R.id.base_ok_tv:
                String url = ACache.get(this).getAsString("electricity_bill");
                Bundle bundle = new Bundle();
                bundle.putString("url", url);
                bundle.putString("title", "文章详情");
                open(WebViewActivity.class, bundle, 0);
                break;

            case R.id.tv_05:
                //时间选择器
                //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
                //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
                Calendar selectedDate = Calendar.getInstance();
                Calendar startDate = Calendar.getInstance();
                startDate.set(2013, 0, 23);
                Calendar endDate = Calendar.getInstance();
                endDate.set(2019, 11, 28);
                //时间选择器
                TimePickerView pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {//选中事件回调
                        // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                /*btn_Time.setText(getTime(date));*/
                        mTv05.setText(getTime(date));
                        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            Date dt1 = df.parse(DateUtils.getCurrentDate());
                            Date dt2 = df.parse(getTime(date));
                            if (dt1.getTime() > dt2.getTime()) {
                                showCustomToast("已过截止日，请联系客服缴纳电费");
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }

                    }
                })

                        .setType(new boolean[]{true, true, true, false, false, false})//年月日时分秒 的显示与否，不设置则默认全部显示
                        .setLabel("年", "月", "日", "", "", "")
                        .isCenterLabel(false)
                        .setDividerColor(ContextCompat.getColor(this, R.color.C3_1))
                        .setContentSize(21)
                        .setTextColorCenter(ContextCompat.getColor(this, R.color.colorAccent))
                        .setDate(selectedDate)
                        .setRangDate(startDate, endDate)
//                .setBackgroundId(0x00FFFFFF) //设置外部遮罩颜色
                        .setDecorView(null)
                        .build();
         /* pvTime.show(); //show timePicker*/
                pvTime.show(v);//弹出时间选择器，传递参数过去，回调的时候则可以绑定此view
                break;
            default:
                break;
        }

    }

    @Override
    public void success(BaseVO vo) {
        if (vo instanceof OrderCrateVO) {
            OrderCrateVO orderCrateVO = (OrderCrateVO) vo;
            mOrderId=orderCrateVO.getData().getOrder_id();
            pay(orderCrateVO.getData().getOut_trade_no(), orderCrateVO.getData().getPay_rmb());
        }
    }

    public void pay(String orderNo, String money) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("out_trade_no", orderNo);
        map.put("pay_type", mPayType);
//        map.put("payment", money);
        map.put("payment", money);

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

    public void payFinish(int type) {
        Bundle bundle = new Bundle();
        bundle.putString("order_id", mOrderId);
        if (type == 1) {
            showCustomToast("支付成功");
        } else {
            showCustomToast("支付失败");
        }
        open(PayStatusActivity.class, bundle, 0);
        this.finish();
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

        if (TextUtils.isEmpty(mTv05.getText().toString())) {
            showCustomToast("请选择截止日期");
            return;
        }


        if (TextUtils.isEmpty(mEt03.getText().toString())) {
            showCustomToast("请输入账单号");
            return;
        }


        showProgressDialog();
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("type", "1");
        map.put("bill_num", mEt02.getText().toString());
        map.put("payment", mEt04.getText().toString());
        map.put("account_number", mEt03.getText().toString());
        map.put("stoptime", mTv05.getText().toString());
        HttpGetDataUtil.post(this, Constant.CHAGE_URL, map, OrderCrateVO.class, this);
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd");
        return format.format(date);
    }

}
