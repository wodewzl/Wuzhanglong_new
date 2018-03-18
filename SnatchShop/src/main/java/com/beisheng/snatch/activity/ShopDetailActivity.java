package com.beisheng.snatch.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.RecordAwardAdapter;
import com.beisheng.snatch.adapter.ShowDetailAdapter;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;

public class ShopDetailActivity extends BaseActivity {
    private LuRecyclerView mRecyclerView;
    private ShowDetailAdapter mAdapter;
    private LinearLayout mBottomLayout, mHeadLayout;
    private TextView mTitleTv, mBackTv;
    private ImageView mHomeImg, mShareImg,mDetaiImg;
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.shop_detail_activity);
    }

    @Override
    public void initView() {
        mHeadLayout = getViewById(R.id.head_layout);

        mBackTv = getViewById(R.id.back_tv);
        mShareImg = getViewById(R.id.share_img);
        mRecyclerView = getViewById(R.id.recycler_view);
        mBaseHeadLayout.setVisibility(View.GONE);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new ShowDetailAdapter(mRecyclerView);
        LuRecyclerViewAdapter luAdapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(luAdapter);
        mRecyclerView.setLoadMoreEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        mBottomLayout = getViewById(R.id.bottom_layout);

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
