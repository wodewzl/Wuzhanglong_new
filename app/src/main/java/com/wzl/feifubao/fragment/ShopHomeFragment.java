package com.wzl.feifubao.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.YellowPagesAdapter;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class ShopHomeFragment extends BaseFragment{
    public static BaseFragment newInstance() {
        BaseFragment fragment = new ShopHomeFragment();
        return fragment;
    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.shop_fragment_layout);
    }

    @Override
    public void initView(View view) {

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
