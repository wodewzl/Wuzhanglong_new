package com.beisheng.snatch.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.WebViewActivity;
import com.beisheng.snatch.adapter.ActiviesAdapter;
import com.beisheng.snatch.adapter.FindAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.DiscoverIndexVO;
import com.beisheng.snatch.model.NameConfirmVO;
import com.beisheng.snatch.model.UserInfoVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

public class TabThreeFragment extends BaseFragment implements View.OnClickListener {


    private LinearLayout ll_photo_share;
    private LinearLayout ll_player_guide;
    private RecyclerView recyclerview_active;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_three_fragment);
    }

    @Override
    public void initView(View view) {

        ll_photo_share = getViewById(R.id.ll_photo_share);
        ll_player_guide = getViewById(R.id.ll_player_guide);
        recyclerview_active = getViewById(R.id.recyclerview_active);

    }

    @Override
    public void bindViewsListener() {
        ll_photo_share.setOnClickListener(this);
        ll_player_guide.setOnClickListener(this);


    }


    @Override
    public void getData() {

       showView();
        HashMap<String, Object> map = new HashMap<>();
        BSHttpUtils.get(mActivity, this, Constant.DISCOVERY_INDEX, map, DiscoverIndexVO.class);

    }

    @Override
    public void hasData(BaseVO vo) {

        DiscoverIndexVO discoverIndexVO= (DiscoverIndexVO) vo;
        List<DiscoverIndexVO.DataBean.ListBean> list = discoverIndexVO.getData().getList();
        ActiviesAdapter activiesAdapter=new ActiviesAdapter(mActivity,list);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false);
        recyclerview_active.setLayoutManager(linearLayoutManager);
        recyclerview_active.setAdapter(activiesAdapter);

        activiesAdapter.setOnItemClickListener(new ActiviesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position,String title,String url) {
                Bundle bundle=new Bundle();
                bundle.putString("title", title);
                bundle.putString("url",url);
                mActivity.open(WebViewActivity.class, bundle, 0);


            }
        });


    }

    @Override
    public void noData(BaseVO vo) {



    }

    @Override
    public void noNet() {

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()){
            /**
             * 拍照分享
             */
            case R.id.ll_photo_share:


                break;


            /**
             * 新手指导
             */
            case R.id.ll_player_guide:


                break;



        }

    }
}
