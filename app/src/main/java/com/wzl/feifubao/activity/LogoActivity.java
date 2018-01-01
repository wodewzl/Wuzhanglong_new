package com.wzl.feifubao.activity;

import android.content.Intent;

import com.wuzhanglong.library.activity.BaseLogoActivity;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wzl.feifubao.R;
import com.wzl.feifubao.fragment.TabOneFragment;
import com.wzl.feifubao.fragment.TabThreeFragment;
import com.wzl.feifubao.fragment.TabTwoFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LogoActivity extends BaseLogoActivity {
    public List<BaseFragment> list = new ArrayList<>();

    @Override
    public void initLogo() {
        EventBus.getDefault().register(this);
        mLogoImageView.setBackgroundResource(R.drawable.logo);
//        initPermissions();
        list = new ArrayList<>();
        TabOneFragment one = new TabOneFragment();
        TabTwoFragment two = new TabTwoFragment();
        TabThreeFragment three = new TabThreeFragment();

        list.add(one);
        list.add(two);
        list.add(three);
    }


    @Subscribe
    public void onEventMainThread(EBMessageVO event) {
        if ("guide".equals(event.getMessage())) {
            Intent intent = new Intent();
            intent.putExtra("fragment_list", (Serializable) list);
            intent.setClass(this, MainActivity.class);
            startActivity(intent);
            this.finish();

//            Intent intent = new Intent();
//            intent.setClass(this, HouseListActivity.class);//房源列表
//            intent.setClass(this, HouseDetailActivity.class);//房源详情
//            intent.setClass(this, RegistActivity.class);//用户注册
//            intent.setClass(this, LoginActivity.class);//用户登陆
//                        intent.setClass(this, AddressAddActivity.class);//添加收获地址
//            intent.setClass(this, AddressActivity.class);//添加收获地址
//            intent.setClass(this, JobOffersActivity.class);//招聘信息
            startActivity(intent);
            this.finish();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);

    }

}
