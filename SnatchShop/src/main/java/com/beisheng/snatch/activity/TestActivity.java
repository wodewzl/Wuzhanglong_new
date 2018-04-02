package com.beisheng.snatch.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.beisheng.snatch.R;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.HomeVO;
import com.rey.material.app.BottomSheetDialog;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;

import java.util.HashMap;

public class TestActivity extends BaseActivity {
    private TextView mLoginTv;
    private BottomSheetDialog mDialog;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.test_layout);
    }

    @Override
    public void initView() {
        mLoginTv = getViewById(R.id.login_tv);
        mLoginTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPayDialog();
            }
        });
    }

    public void showPayDialog() {
        mDialog = new BottomSheetDialog(mActivity);
//        View dialogView = View.inflate(mActivity, R.layout.login_layout, null);
        View dialogView = View.inflate(mActivity, R.layout.quick_buy, null);
        mDialog.contentView(dialogView)
                .heightParam(ViewGroup.LayoutParams.WRAP_CONTENT)
                .inDuration(500)
                .cancelable(true)
                .show();
    }

    @Override
    public void bindViewsListener() {

    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        BSHttpUtils.get(mActivity, this, Constant.HOME_TITLE_URL, map, HomeVO.class);
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
