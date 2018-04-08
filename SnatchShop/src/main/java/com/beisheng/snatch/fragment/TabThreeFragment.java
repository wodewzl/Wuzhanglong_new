package com.beisheng.snatch.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.FindAdapter;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

public class TabThreeFragment extends BaseFragment {


    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_three_fragment);
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

    }

    @Override
    public void noNet() {

    }


}
