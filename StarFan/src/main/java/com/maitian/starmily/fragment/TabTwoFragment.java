package com.maitian.starmily.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.maitian.starmily.R;
import com.maitian.starmily.activity.RiceCircleStarActivity;
import com.maitian.starmily.adapter.GuardAdapter;
import com.maitian.starmily.adapter.RiceCircleAdapter;
import com.maitian.starmily.adapter.RiceCircleAdapter.ChildClikCallback;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.MyIdolsVO;
import com.maitian.starmily.model.RiceCircleVO;
import com.maitian.starmily.utils.TaskUtil;
import com.maitian.starmily.view.CustomDialog;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.utils.WidthHigthUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class TabTwoFragment extends BaseFragment implements View.OnClickListener, Serializable, SwipeRefreshLayout.OnRefreshListener, OnLoadMoreListener, PostCallback, ChildClikCallback,
        BGAOnRVItemClickListener {
    private LuRecyclerView mRecyclerView;
    private RiceCircleAdapter mAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private boolean isLoadMore = true;
    private int mCurrentPage = 1;
    private TextView mNameTv;
    private ImageView mHeadIv, mGuardOneIv, mGuardTwoIv;
    private String mIdolId = "";
    private CustomDialog mCustomDialog;
    private GuardAdapter mGuardAdapter;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_two_fragment);
    }

    @Override
    public void initView(View view) {
        mNameTv = getViewById(R.id.name_tv);
        mHeadIv = getViewById(R.id.head_iv);
        mGuardOneIv = getViewById(R.id.guard_one_iv);
        mGuardTwoIv = getViewById(R.id.guard_two_iv);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new RiceCircleAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this.getActivity(), mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, true);
        if (AppApplication.getInstance().getMyIdolsVO() != null) {
            MyIdolsVO myIdolsVO = AppApplication.getInstance().getMyIdolsVO();
            mIdolId = myIdolsVO.getObj().get(0).getId() + "";
            mNameTv.setText(myIdolsVO.getObj().get(0).getIdolName());
            if (!TextUtils.isEmpty(myIdolsVO.getObj().get(0).getBackUrl())) {
                if (myIdolsVO.getObj().get(0).getBackUrl().contains("http://")) {
                    Picasso.with(mActivity).load(myIdolsVO.getObj().get(0).getBackUrl()).into(mHeadIv);
                } else {
                    Picasso.with(mActivity).load(Constant.DOMAIN_UR + "/" + myIdolsVO.getObj().get(0).getBackUrl()).into(mHeadIv);
                }
            }
            if (myIdolsVO.getObj().size() > 0) {
                if (!TextUtils.isEmpty(myIdolsVO.getObj().get(0).getIconUrl())) {
                    if (myIdolsVO.getObj().get(0).getBackUrl().contains("http://")) {
                        Picasso.with(mActivity).load(myIdolsVO.getObj().get(0).getIconUrl()).into(mGuardOneIv);
                    } else {
                        Picasso.with(mActivity).load(Constant.DOMAIN_UR + "/" + myIdolsVO.getObj().get(0).getIconUrl()).into(mGuardOneIv);
                    }
                }
                mGuardOneIv.setVisibility(View.VISIBLE);
            } else {
                mGuardOneIv.setVisibility(View.GONE);
            }
            if (myIdolsVO.getObj().size() > 1) {
                if (!TextUtils.isEmpty(myIdolsVO.getObj().get(1).getIconUrl())) {
                    if (myIdolsVO.getObj().get(1).getBackUrl().contains("http://")) {
                        Picasso.with(mActivity).load(myIdolsVO.getObj().get(1).getIconUrl()).into(mGuardTwoIv);
                    } else {
                        Picasso.with(mActivity).load(Constant.DOMAIN_UR + "/" + myIdolsVO.getObj().get(2).getIconUrl()).into(mGuardTwoIv);
                    }
                }
                mGuardTwoIv.setVisibility(View.VISIBLE);
            } else {
                mGuardTwoIv.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
//        mAdapter.setOnRVItemClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mAdapter.setChildClikCallback(this);
        mGuardTwoIv.setOnClickListener(this);
        mGuardOneIv.setOnClickListener(this);
//        EventBus.getDefault().register(this);
    }


    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("idolId", mIdolId);
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        map.put("pageNum", mCurrentPage + "");
        map.put("pageSize", "10");
        StartHttpUtils.get(mActivity, this, Constant.TOPIC_LIST, map, RiceCircleVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof RiceCircleVO) {
            RiceCircleVO riceCircleVO = (RiceCircleVO) vo;
            if (riceCircleVO.getObj().isHasNextPage()) {
                mRecyclerView.setNoMore(false);
            } else {
                mRecyclerView.setNoMore(true);
            }
            mAutoSwipeRefreshLayout.setRefreshing(false);
            List<RiceCircleVO.ObjBean.ListBeanXX> list = riceCircleVO.getObj().getList();
            if (isLoadMore) {
                mAdapter.updateDataLast(list);
                isLoadMore = false;
            } else {
                mAdapter.updateData(list);
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void noData(BaseVO vo) {
        showView();
    }

    @Override
    public void noNet() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.guard_one_iv:
            case R.id.guard_two_iv:
                showStarDialog();
                break;
            default:
                break;

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
//        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        getData();
    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        mCurrentPage++;
        getData();
    }


    @Override
    public void success(BaseVO vo) {
        mActivity.showCustomToast(vo.getMsg());
        getData();
    }

    @Override
    public void favorPost(String topicId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("topicId", topicId);
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.postCallBack(mActivity, Constant.FAVORIATE_TOPIC, map, BaseVO.class, this);
    }

    @Override
    public void likePost(String topicId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("topicId", topicId);
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        StartHttpUtils.postCallBack(mActivity, Constant.LIKE_TOPIC, map, BaseVO.class, this);
        new TaskUtil().taskShow(mActivity, "2");
    }

    @Override
    public void replayLikePost(String id, int status) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("commentId", id);
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        if (status == 1) {
            map.put("type", "0");
        } else {
            map.put("type", "1");
        }
        StartHttpUtils.postCallBack(mActivity, Constant.LIKE_COMMENT, map, BaseVO.class, this);
        new TaskUtil().taskShow(mActivity, "2");
    }

    public void showStarDialog() {
        View view = View.inflate(mActivity, R.layout.change_star, null);
        LuRecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        mGuardAdapter = new GuardAdapter(recyclerView);
        RecyclerViewUtil.initRecyclerViewGridLayoutManager(this.getActivity(), recyclerView, mGuardAdapter, 4, R.dimen.dp_5, R.color.C3, false);
        MyIdolsVO myIdolsVO = AppApplication.getInstance().getMyIdolsVO();
        mGuardAdapter.updateData(myIdolsVO.getObj());
        mGuardAdapter.setOnRVItemClickListener(this);
        CustomDialog.Builder builder = new CustomDialog.Builder(mActivity);
        mCustomDialog = builder
                .cancelTouchout(false)
                .view(view)
                .heightpx(WidthHigthUtil.getScreenHigh(mActivity))
                .widthpx(WidthHigthUtil.getScreenWidth(mActivity))
                .style(R.style.Dialog)
                .addViewOnclick(R.id.close_iv, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mCustomDialog.dismiss();
                    }
                })
                .addViewOnclick(R.id.add_more_bt, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mActivity.openActivity(RiceCircleStarActivity.class);
                    }
                })
                .build();
        mCustomDialog.show();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mCustomDialog != null && mCustomDialog.isShowing()) {
            MyIdolsVO myIdolsVO = AppApplication.getInstance().getMyIdolsVO();
            mGuardAdapter.updateData(myIdolsVO.getObj());
        }
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mGuardAdapter.getData().size() == 0)
            return;
        MyIdolsVO.ObjBean beans = (MyIdolsVO.ObjBean) mGuardAdapter.getItem(position);
        mIdolId = beans.getId() + "";

        mNameTv.setText(beans.getIdolName());
        if (!TextUtils.isEmpty(beans.getBackUrl())) {
            if (beans.getBackUrl().contains("http://")) {
                Picasso.with(mActivity).load(beans.getBackUrl()).into(mHeadIv);
            } else {
                Picasso.with(mActivity).load(Constant.DOMAIN_UR + "/" + beans.getBackUrl()).into(mHeadIv);
            }
        }
        mCustomDialog.dismiss();
        mAutoSwipeRefreshLayout.autoRefresh();

    }
}
