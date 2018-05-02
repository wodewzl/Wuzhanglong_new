package com.beisheng.snatch.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.ShopDetailActivity;
import com.beisheng.snatch.adapter.HomeAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.ShopVO;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class TabOneChildFragment extends BaseFragment implements OnLoadMoreListener, ScrollableHelper.ScrollableContainer, BGAOnRVItemClickListener {
    private LuRecyclerView mRecyclerView;
    private HomeAdapter mAdapter;
    private LuRecyclerViewAdapter mLuAdapter;
    private String state;
    private int mCurrentPage = 1;
    private boolean isLoadMore = false;
    private String type = "1";//1-人气 2-最新 3-进度 4-总需从大到小 5-总需从小到大


    public static TabOneChildFragment newInstance() {
        TabOneChildFragment fragment = new TabOneChildFragment();
        return fragment;
    }

    @Override
    public void noNet() {

    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_one_child_fragment);
    }

    @Override
    public void initView(View view) {
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_4, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new HomeAdapter(mRecyclerView);
        mLuAdapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(mLuAdapter);
        mRecyclerView.setLoadMoreEnabled(true);
        GridLayoutManager layoutManager = new GridLayoutManager(mActivity, 2);
        mRecyclerView.setLayoutManager(layoutManager);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (mAdapter.getData().size() == 0 || position == mAdapter.getData().size()) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        mRecyclerView.setFooterViewHint("正在加载中","一一一 我们是有底线的 一一一","");
        mRecyclerView.setFooterViewColor(R.color.colorAccent,R.color.C5,R.color.C3);
    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        EventBus.getDefault().register(this);
        mAdapter.setOnRVItemClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("order_type", this.getType());
        map.put("curpage", mCurrentPage + "");
        BSHttpUtils.post(mActivity, this, Constant.HOME_LIST_URL, map, ShopVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        ShopVO homeChildVO = (ShopVO) vo;
        if (BaseCommonUtils.parseInt(homeChildVO.getData().getCount()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(homeChildVO.getData().getCount())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        List<ShopVO.DataBean.ListBean> list = homeChildVO.getData().getList();
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
        EventBus.getDefault().unregister(this);
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

    @Subscribe
    public void onEventMainThread(EBMessageVO event) {
        if ("4".equals(type) || "5".equals(type)) {
            if ("order_low".equals(event.getMessage())) {
                type = "5";
                getData();
            } else if ("order_high".equals(event.getMessage())) {
                type = "4";
                getData();
            }
        }
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getItemCount() == 0)
            return;
        ShopVO.DataBean.ListBean vo = (ShopVO.DataBean.ListBean) mAdapter.getItem(position);
        Bundle bundle = new Bundle();
        bundle.putString("id", vo.getId());
        mActivity.open(ShopDetailActivity.class, bundle, 0);
    }
}
