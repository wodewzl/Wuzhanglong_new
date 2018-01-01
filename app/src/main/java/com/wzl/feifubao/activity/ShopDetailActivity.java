package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wzl.feifubao.R;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.RateQueryVO;
import com.wzl.feifubao.mode.ShopVO;

import java.util.HashMap;

public class ShopDetailActivity extends BaseActivity {
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_shop_detail);
    }

    @Override
    public void initView() {

    }

    @Override
    public void bindViewsListener() {

    }

    @Override
    public void getData() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("uid","39");
        map.put("goodsId",this.getIntent().getStringExtra("id"));
        HttpGetDataUtil.get(mActivity, this, Constant.SHOP_DETAIL_ULR, map, ShopVO.class);
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
