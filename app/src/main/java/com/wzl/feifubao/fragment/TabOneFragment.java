package com.wzl.feifubao.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.SharePreferenceUtil;
import com.wzl.feifubao.R;

import java.util.ArrayList;
import java.util.List;

public class TabOneFragment extends BaseFragment {

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_one_fragment);
    }

    @Override
    public void initView(View view) {
        mActivity.mBaseHeadLayout.setVisibility(View.VISIBLE);
        mActivity.mBaseTitleTv.setText("feifubao");
    }

    @Override
    public void bindViewsListener() {

    }

    @Override
    public void getData() {

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
