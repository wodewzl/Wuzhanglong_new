package com.beisheng.snatch.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.RecordBuyAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.TABuyVO;
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

public class RecordBuyFragment extends BaseFragment implements OnLoadMoreListener, ScrollableHelper.ScrollableContainer {
    private LuRecyclerView mRecyclerView;
    private RecordBuyAdapter mAdapter;
    private LuRecyclerViewAdapter mLuAdapter;
    private String state;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;


    public static RecordBuyFragment newInstance() {
        RecordBuyFragment fragment = new RecordBuyFragment();
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
        mAdapter = new RecordBuyAdapter(mRecyclerView);
        mLuAdapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(mLuAdapter);
        mRecyclerView.setLoadMoreEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", mActivity.getIntent().getStringExtra("id"));
        BSHttpUtils.get(mActivity, this, Constant.OTHER_TAB_ONE_URL, map, TABuyVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        TABuyVO bean = (TABuyVO) vo;
        if (BaseCommonUtils.parseInt(bean.getData().getCount()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(bean.getData().getCount())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        List<TABuyVO.DataBean.ListBean> list = bean.getData().getList();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
            mCurrentPage++;
        } else {
            mCurrentPage++;
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
}
