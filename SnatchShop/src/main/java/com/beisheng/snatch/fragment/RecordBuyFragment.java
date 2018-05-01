package com.beisheng.snatch.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.ShopDetailActivity;
import com.beisheng.snatch.adapter.RecordBuyAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.TABuyVO;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.bean.BuildBean;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class RecordBuyFragment extends BaseFragment implements OnLoadMoreListener, ScrollableHelper.ScrollableContainer, BGAOnRVItemClickListener, BGAOnItemChildClickListener {
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
        mAdapter.setOnRVItemClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", mActivity.getIntent().getStringExtra("id"));
        BSHttpUtils.post(mActivity, this, Constant.OTHER_TAB_ONE_URL, map, TABuyVO.class);
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
    public void onItemChildClick(ViewGroup parent, View childView, int position) {
        TABuyVO.DataBean.ListBean bean = (TABuyVO.DataBean.ListBean) mAdapter.getItem(position);
        showDialog(bean.getBuy_codes());
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        TABuyVO.DataBean.ListBean bean = (TABuyVO.DataBean.ListBean) mAdapter.getItem(position);
        Bundle bundle = new Bundle();
        bundle.putString("id", bean.getPanic_id());
        mActivity.open(ShopDetailActivity.class, bundle, 0);
    }

    public void showDialog(List<String> allList) {
        DialogUIUtils.init(mActivity);
        View rootView = View.inflate(mActivity, R.layout.my_buy_number_dialog, null);
        TextView buyCountTv = rootView.findViewById(R.id.buy_count_tv);
        buyCountTv.setVisibility(View.GONE);
        BaseCommonUtils.setTextThree(mActivity, buyCountTv, "你抢购了", allList.size()+"", "次(抢购号码如下)", R.color.colorAccent, 1.3f);
        TagFlowLayout tagFlowLayout = rootView.findViewById(R.id.tag_flow_layout);
        List<String> tmp=new ArrayList<>();
        if(allList.size()>50){
            tmp.addAll(allList.subList(0, 50));
        }else {
            tmp.addAll(allList);
        }
        tagFlowLayout.setAdapter(new TagAdapter<String>(tmp) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = new TextView(mActivity);
                tv.setText(s);
                return tv;
            }
        });
        final BuildBean buildBean = DialogUIUtils.showCustomAlert(mActivity, rootView);
        buildBean.show();
    }
}
