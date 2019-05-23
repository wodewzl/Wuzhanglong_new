package com.maitian.starmily.fragment;


import android.view.View;

import com.maitian.starmily.R;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;

public class PaurseFragment extends BaseFragment implements View.OnClickListener, PostCallback, Serializable {

    @Override
    public void setContentView() {
        contentInflateView(R.layout.paruse_fragment);
    }

    @Override
    public void initView(View view) {

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
        showView();
    }

    @Override
    public void noNet() {

    }


    @Override
    public void onClick(View v) {

    }




    @Override
    public void success(BaseVO vo) {

    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void bindPhone() {

    }
}
