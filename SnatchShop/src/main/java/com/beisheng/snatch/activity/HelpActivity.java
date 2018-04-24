package com.beisheng.snatch.activity;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.beisheng.snatch.R;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.HelpVO;
import com.meiqia.core.callback.OnInitCallback;
import com.meiqia.meiqiasdk.util.MQConfig;
import com.meiqia.meiqiasdk.util.MQIntentBuilder;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import java.util.HashMap;

public class HelpActivity extends BaseActivity implements View.OnClickListener {
    private TextView mTv01, mTv02, mTv03;
    private HelpVO mHelpVO;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.help_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("联系我们");
        mTv01 = getViewById(R.id.tv_01);
        mTv02 = getViewById(R.id.tv_02);
        mTv03 = getViewById(R.id.tv_03);
        initMQ();
    }

    @Override
    public void bindViewsListener() {
        showView();
        mTv01.setOnClickListener(this);
        mTv02.setOnClickListener(this);
        mTv03.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        BSHttpUtils.post(mActivity, this, Constant.HELP_URL, map, HelpVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        mHelpVO = (HelpVO) vo;
        mTv03.setText(mHelpVO.getData().getService_tel());
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    public void initMQ() {
        MQConfig.init(this, "2bee70a2b29531b579c2c20cffe7ff63", new OnInitCallback() {
            @Override
            public void onSuccess(String clientId) {

            }

            @Override
            public void onFailure(int code, String message) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_01:
                if(TextUtils.isEmpty(mHelpVO.getData().getQq_group_no()))
                    return;
                try {
                    //第二种方式：可以跳转到添加好友，如果qq号是好友了，直接聊天
                    String url = "mqqwpa://im/chat?chat_type=wpa&uin=" + mHelpVO.getData().getQq_group_no();//uin是发送过去的qq号码
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                } catch (Exception e) {
                    e.printStackTrace();
                    showFailToast("请检查是否安装QQ");
                }
                break;
            case R.id.tv_02:

                Intent intent = new MQIntentBuilder(this)
                        .setCustomizedId(AppApplication.getInstance().getUserInfoVO().getData().getJiguang_alias())
                        .build();
                startActivity(intent);
                break;
            case R.id.tv_03:
                if(TextUtils.isEmpty(mHelpVO.getData().getService_tel()))
                    return;
                BaseCommonUtils.call(this,mHelpVO.getData().getService_tel());
                break;
            default:
                break;
        }
    }
}
