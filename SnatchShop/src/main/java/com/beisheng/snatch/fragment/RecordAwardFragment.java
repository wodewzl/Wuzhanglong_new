package com.beisheng.snatch.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.ShopDetailActivity;
import com.beisheng.snatch.adapter.RecordAwardAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.TAAwardVO;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class RecordAwardFragment extends BaseFragment implements OnLoadMoreListener, ScrollableHelper.ScrollableContainer,BGAOnRVItemClickListener {
    private LuRecyclerView mRecyclerView;
    private RecordAwardAdapter mAdapter;
    private String state;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;


    public static RecordAwardFragment newInstance() {
        RecordAwardFragment fragment = new RecordAwardFragment();
        return fragment;
    }

    @Override
    public void noNet() {

    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.record_fragment);
    }

    @Override
    public void initView(View view) {
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new RecordAwardAdapter(mRecyclerView);
        LuRecyclerViewAdapter luAdapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(luAdapter);
        mRecyclerView.setLoadMoreEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mAdapter.setOnRVItemClickListener(this);

    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", mActivity.getIntent().getStringExtra("id"));
        BSHttpUtils.post(mActivity, this, Constant.OTHER_TAB_TWO_URL, map, TAAwardVO.class);

    }

    @Override
    public void hasData(BaseVO vo) {
        TAAwardVO bean = (TAAwardVO) vo;
        if (BaseCommonUtils.parseInt(bean.getData().getCount()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(bean.getData().getCount())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        List<TAAwardVO.DataBean.ListBean> list = bean.getData().getList();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
        } else {
            mAdapter.updateData(list);
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        mCurrentPage++;
        getData();
    }



    @Override
    public void onDestroy() {
        super.onDestroy();

    }


    @Override
    public View getScrollableView() {
        return mRecyclerView;
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        TAAwardVO.DataBean.ListBean bean = (TAAwardVO.DataBean.ListBean) mAdapter.getItem(position);
        Bundle bundle = new Bundle();
        bundle.putString("id", bean.getPanic_id());
        mActivity.open(ShopDetailActivity.class, bundle, 0);
    }
}
