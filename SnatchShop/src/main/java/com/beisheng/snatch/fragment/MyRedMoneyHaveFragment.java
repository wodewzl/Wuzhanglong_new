package com.beisheng.snatch.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.MyRedMoneyAdapter;
import com.beisheng.snatch.adapter.RecordAwardAdapter;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

public class MyRedMoneyHaveFragment extends BaseFragment implements OnLoadMoreListener {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private MyRedMoneyAdapter mAdapter;
    private String state;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String type = "1";


    public static MyRedMoneyHaveFragment newInstance() {
        MyRedMoneyHaveFragment fragment = new MyRedMoneyHaveFragment();
        return fragment;
    }

    @Override
    public void noNet() {

    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.my_red_money_fragment);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_10, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new MyRedMoneyAdapter(mRecyclerView);
        LuRecyclerViewAdapter luAdapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(luAdapter);
        mRecyclerView.setLoadMoreEnabled(false);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);

    }

    @Override
    public void getData() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("order_type", this.getType());
//        BSHttpUtils.get(mActivity, this, Constant.HOME_LIST_URL, map, HomeChildVO.class);
        showView();
    }

    @Override
    public void hasData(BaseVO vo) {
//        ShopVO homeChildVO = (ShopVO) vo;
//        if (BaseCommonUtils.parseInt(homeChildVO.getData().getCount()) == 1) {
//            mRecyclerView.setLoadMoreEnabled(false);
//        }
//        if (mCurrentPage == BaseCommonUtils.parseInt(homeChildVO.getData().getCount())) {
//            mRecyclerView.setNoMore(true);
//        } else {
//            mRecyclerView.setNoMore(false);
//        }
//        List<HomeChildVO.DataBean.ListBean> list = homeChildVO.getData().getList();
//        if (isLoadMore) {
//            mAdapter.updateDataLast(list);
//            isLoadMore = false;
//            mCurrentPage++;
//        } else {
//            mCurrentPage++;
//            mAdapter.updateData(list);
//        }
//        mAdapter.notifyDataSetChanged();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
