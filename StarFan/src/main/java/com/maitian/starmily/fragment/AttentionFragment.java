package com.maitian.starmily.fragment;


import android.view.View;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.AttentionAdapter;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.AttentionBean;
import com.maitian.starmily.model.FindTopicVO;
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

public class AttentionFragment extends BaseFragment implements View.OnClickListener, PostCallback, Serializable {
    private LuRecyclerView mRecyclerView;
    private AttentionAdapter mAdapter;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private int mType=0;//0我的爱豆1我的关注2我的粉丝
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
    }

    @Override
    public void bindViewsListener() {

    }


    @Override
    public void getData() {
        if(mType==0){
            HashMap<String, Object> map = new HashMap<>();
            map.put("userId", "4341");
            StartHttpUtils.get(mActivity, this, Constant.MY_FOLLOWS, map, AttentionBean.class);
        }else if(mType==1){
            HashMap<String, Object> map = new HashMap<>();
            map.put("userId", "4341");
            StartHttpUtils.get(mActivity, this, Constant.MY_FOLLOWS, map, AttentionBean.class);
        }else if(mType==2){
            HashMap<String, Object> map = new HashMap<>();
            map.put("userId", "4341");
            StartHttpUtils.get(mActivity, this, Constant.MY_FANS, map, AttentionBean.class);
        }


    }

    @Override
    public void hasData(BaseVO vo) {
        AttentionBean attentionBean = (AttentionBean) vo;
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

    public void bindPhone() {

    }
}
