package com.beisheng.snatch.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.HomeAdapter;
import com.beisheng.snatch.adapter.RecordAwardAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.HomeChildVO;
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

import cn.bingoogolapple.baseadapter.BGAGridDivider;

public class RecordAwardFragment extends BaseFragment implements OnLoadMoreListener, ScrollableHelper.ScrollableContainer {
    private LuRecyclerView mRecyclerView;
    private RecordAwardAdapter mAdapter;
    private String state;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String type = "1";//1-人气 2-最新 3-进度 4-总需从大到小 5-总需从小到大


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
//        HomeChildVO homeChildVO = (HomeChildVO) vo;
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

    @Override
    public View getScrollableView() {
        return mRecyclerView;
    }
}
