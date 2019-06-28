package com.maitian.starmily.fragment;


import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.view.ViewGroup;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.AttentionAdapter;
import com.maitian.starmily.application.AppApplication;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.AttentionBean;
import com.maitian.starmily.model.FindTopicVO;
import com.maitian.starmily.model.MyIdolsVO;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;

public class AttentionFragment extends BaseFragment implements View.OnClickListener, PostCallback, Serializable, BGAOnItemChildClickListener, SwipeRefreshLayout.OnRefreshListener {
    private LuRecyclerView mRecyclerView;
    private AttentionAdapter mAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private int mType=0;//0我的爱豆1我的粉丝2我的关注
    private int mCurrentPage = 1;
    @Override
    public void setContentView() {
        contentInflateView(R.layout.attention_fragment);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new AttentionAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this.getActivity(), mRecyclerView, mAdapter, R.dimen.dp_10, R.color.C3, false);
        mType= this.getArguments().getInt("type");
        mAdapter.setType(mType);
    }

    @Override
    public void bindViewsListener() {
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
    }


    @Override
    public void getData() {
        if(mType==0){
            HashMap<String, Object> map = new HashMap<>();
            map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
            StartHttpUtils.get(mActivity, this, Constant.MY_IDOLS, map, AttentionBean.class);
        }else if(mType==1){
            HashMap<String, Object> map = new HashMap<>();
            map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
            StartHttpUtils.get(mActivity, this, Constant.MY_FOLLOWS, map, AttentionBean.class);
        }else if(mType==2){
            HashMap<String, Object> map = new HashMap<>();
            map.put("userId",AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
            StartHttpUtils.get(mActivity, this, Constant.MY_FANS, map, AttentionBean.class);
        }


    }

    @Override
    public void hasData(BaseVO vo) {

//        if (attentionBean.getObj().isHasNextPage()) {
//            mRecyclerView.setNoMore(false);
//        } else {
//            mRecyclerView.setNoMore(true);
//        }
//        mAutoSwipeRefreshLayout.setRefreshing(false);
//        List<AttentionBean.ObjBean> list = attentionBean.getObj();
//        if (isLoadMore) {
//            mAdapter.updateDataLast(list);
//            isLoadMore = false;
//        } else {
//            mAdapter.updateData(list);
//        }
        mAutoSwipeRefreshLayout.setRefreshing(false);
        AttentionBean attentionBean = (AttentionBean) vo;
        List<AttentionBean.ObjBean> list = attentionBean.getObj();
        mAdapter.updateData(list);


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

    }




    @Override
    public void success(BaseVO vo) {

    }




    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    public void attent(String id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", AppApplication.getInstance().getUserInfoVO().getObj().getUserId());
        if(mType==0){

        }else if(mType==1){

        }
        else {
            map.put("followUserId", id);
            StartHttpUtils.postCallBack(mActivity, Constant.FOLLOW_USER, map, BaseVO.class, this);
        }
    }

    @Override
    public void onItemChildClick(ViewGroup parent, View childView, int position) {
        AttentionBean.ObjBean bean= (AttentionBean.ObjBean) mAdapter.getItem(position);

        if(mType==0){
            attent(bean.getId()+"");
        }else if(mType==1){
            attent(bean.getUserId()+"");
        }else {
            attent(bean.getFollowUserId()+"");
        }

    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        getData();
    }
}
