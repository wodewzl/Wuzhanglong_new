package com.beisheng.snatch.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.AddressDialogAdapter;
import com.beisheng.snatch.adapter.LoveAdapter;
import com.beisheng.snatch.adapter.MyBuyRecordAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.MyBuyRecordVO;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.rey.material.app.BottomSheetDialog;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.BottomDialogUtil;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.util.HashMap;
import java.util.List;

import static com.beisheng.snatch.R.color.C3;

public class MyBuyRecordFragment extends BaseFragment implements OnLoadMoreListener, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView, mRecyclerViewLove;
    private MyBuyRecordAdapter mAdapter;
    private LoveAdapter mAdapterLove;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String type = "1";
    private boolean mFlag = true;


    public static MyBuyRecordFragment newInstance() {
        MyBuyRecordFragment fragment = new MyBuyRecordFragment();
        return fragment;
    }

    @Override
    public void noNet() {

    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.my_lucky_record_fragment);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new MyBuyRecordAdapter(mRecyclerView);
        mAdapter.setType(type);
        RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, mRecyclerView, mAdapter, R.dimen.dp_1, C3, true);

        mRecyclerViewLove = getViewById(R.id.recycler_view_love);
        mAdapterLove = new LoveAdapter(mRecyclerViewLove);
        RecyclerViewUtil.initRecyclerViewLinearLayoutHorizontal(mActivity, mRecyclerViewLove, mAdapterLove, R.dimen.dp_1, C3);

    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", "10005");
        map.put("curpage", mCurrentPage + "");
        map.put("type", this.getType());
        BSHttpUtils.get(mActivity, this, Constant.MY_BUY_RECORD_URL, map, MyBuyRecordVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        MyBuyRecordVO bean = (MyBuyRecordVO) vo;
        if (BaseCommonUtils.parseInt(bean.getData().getCount()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(bean.getData().getCount())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }
        List<MyBuyRecordVO.DataBean.ListBean> list = bean.getData().getList();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
            mCurrentPage++;
        } else {
            mCurrentPage++;
            mAdapter.updateData(list);
        }
        mAdapter.notifyDataSetChanged();
        mAutoSwipeRefreshLayout.setRefreshing(false);
        if (mFlag) {
            mFlag = false;
            List<MyBuyRecordVO.DataBean.GuessLikeBean> loveList = bean.getData().getGuess_like();
            mAdapterLove.updateData(loveList);
        }
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;

    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_tv:
                BottomSheetDialog dialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.address_list_dialog);
                LuRecyclerView recyclerView = dialog.getWindow().getDecorView().findViewById(R.id.dialog_recycler_view);
                AddressDialogAdapter dialogAdapter = new AddressDialogAdapter(recyclerView);
                RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, recyclerView, dialogAdapter, R.dimen.dp_1, C3, false);
                break;

            default:
                break;
        }

    }

    public void onAddressClick(View v) {
        switch (v.getId()) {
            case R.id.add_address_tv:
                System.out.println("=========>");
                BottomSheetDialog dialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.add_address_dialog);
                break;
            case R.id.check_img:
                System.out.println("=========>");
                break;
            default:
                break;
        }
    }

}
