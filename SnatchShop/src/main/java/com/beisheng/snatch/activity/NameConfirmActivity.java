package com.beisheng.snatch.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.NameConfirmVO;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import java.util.HashMap;

public class NameConfirmActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private EditText mNameEt, mNumberEt;
    private TextView mOkTv,mNameTv,mNumberTv;
    private ImageView mConfirmImg;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.name_confirm_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("实名认证");
        mNameEt = getViewById(R.id.name_et);
        mNumberEt = getViewById(R.id.number_et);
        mOkTv = getViewById(R.id.ok_tv);
        mNameTv=getViewById(R.id.name_tv);
        mNumberTv=getViewById(R.id.number_tv);
        mConfirmImg=getViewById(R.id.confirm_bg);
        Picasso.with(this).load(AppApplication.getInstance().getUserInfoVO().getData().getSmrz_banner()).into(mConfirmImg);

    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        BSHttpUtils.post(mActivity, this, Constant.NAME_CONFIRM_INFO_URL, map, NameConfirmVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        NameConfirmVO bean= (NameConfirmVO) vo;
        BaseCommonUtils.setTextTwoBefore(this,mNameTv,"真实姓名：",bean.getData().getReal_name(),R.color.C5,1.0f);
        BaseCommonUtils.setTextTwoBefore(this,mNumberTv,"证件号码：",bean.getData().getId_card(),R.color.C5,1.0f);

//        mNameTv.setText("真实姓名："+bean.getData().getReal_name());
//        mNumberTv.setText("证件号码："+bean.getData().getId_card());
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
                if (TextUtils.isEmpty(mNameEt.getText().toString())) {
                    showCustomToast("请填写真实姓名");
                    return;
                }
                if (TextUtils.isEmpty(mNumberEt.getText().toString())) {
                    showCustomToast("请填写有效省份号");
                    return;
                }
                HashMap<String, Object> map = new HashMap<>();
                map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                map.put("real_name", mNameEt.getText().toString());
                map.put("id_card", mNumberEt.getText().toString());
                BSHttpUtils.postCallBack(mActivity, Constant.NAME_CONFIRM_URL, map, BaseVO.class, this);
                break;

            default:
                break;

        }
    }

    @Override
    public void success(BaseVO vo) {

    }
}
