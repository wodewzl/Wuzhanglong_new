package com.beisheng.snatch.activity;

import android.widget.ImageView;

import com.beisheng.snatch.R;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.mode.PayInfoVO;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

public class QRCodeActivity extends BaseActivity implements PostCallback {
    private ImageView mImageView;
    private Timer mTimer;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.qrcode_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("微信扫码支付");
        mImageView = getViewById(R.id.img);
        String imgUrl = this.getIntent().getStringExtra("img");
        Picasso.with(this).load(imgUrl).into(mImageView);
        final String url = this.getIntent().getStringExtra("url");
        mTimer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                HashMap<String, Object> map = new HashMap<>();
                BSHttpUtils.postCallBack(mActivity, url.split(BaseConstant.DOMAIN_NAME)[1], map, PayInfoVO.class, QRCodeActivity.this);
            }
        };
        mTimer.schedule(task, 0, 1000);

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

    @Override
    public void success(BaseVO vo) {
        PayInfoVO payInfoVO= (PayInfoVO) vo;
        if("1".equals(payInfoVO.getData().getPay_status())){
            EventBus.getDefault().post(new EBMessageVO("wx_web"));
            showCustomToast(payInfoVO.getDesc());
            this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimer.cancel();
        mTimer=null;
    }
}
