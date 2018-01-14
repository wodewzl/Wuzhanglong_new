package com.wzl.feifubao.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.TreeVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.utils.WidthHigthUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wuzhanglong.library.view.BSPopupWindowsTitle;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.HouseListAdapter;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.HouseListVO;
import com.wzl.feifubao.mode.HouseOptionVO;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class HouseListOneActivity extends BaseActivity implements BGAOnRVItemClickListener, View.OnClickListener, OnLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener {
    private LuRecyclerView mRecyclerView;
    private HouseListAdapter mAdapter;


    private boolean mFlag = true;
    private TextView mOptions1Tv, mOptionsTv2, mOptionsTv3;
    private BSPopupWindowsTitle mOption1Pop, mOption2Pop, mOption3Pop;
    private HouseOptionVO.DataBean mOptionDataBean;
    private View mDivider;


    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String mLanguageId = "";
    private String mCityId = "";
    private String mProvinceId = "";
    private String mPayClassId = "";
    private String mRentingStyleId = "";

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_house_list_one);
    }

    @Override
    public void initView() {
        Intent intent = this.getIntent();

        mBaseTitleTv.setText(intent.getStringExtra("name"));
        mRentingStyleId = intent.getStringExtra("rentingStyleId");

        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new HouseListAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadMoreEnabled(false);


        mOptions1Tv = getViewById(R.id.options1_tv);
        mOptionsTv2 = getViewById(R.id.options2_tv);
        mOptionsTv3 = getViewById(R.id.options3_tv);
        mDivider = getViewById(R.id.divider);
    }

    @Override
    public void bindViewsListener() {
        mOptions1Tv.setOnClickListener(this);
        mOptionsTv2.setOnClickListener(this);
        mOptionsTv3.setOnClickListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        ;
    }

    @Override
    public void getData() {
        if (mFlag) {
            HashMap<String, Object> map = new HashMap<>();
            HttpGetDataUtil.get(mActivity, this, Constant.HOUSE_LIST_OPTION_URL, map, HouseOptionVO.class);
            mFlag = false;
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("page", mCurrentPage + "");
        map.put("pagesize", "10");

        map.put("languageId", mLanguageId);
        map.put("provinceId", mProvinceId);
        map.put("payClassId", mPayClassId);
        map.put("rentingStyleId", mRentingStyleId);
        HttpGetDataUtil.get(mActivity, this, Constant.HOUSE_LIST_URL, map, HouseListVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof HouseOptionVO) {
            HouseOptionVO houseOptionVO = (HouseOptionVO) vo;
            mOptionDataBean = houseOptionVO.getData();

        } else if (vo instanceof HouseListVO) {
            HouseListVO houseListVO = (HouseListVO) vo;
            mAutoSwipeRefreshLayout.setRefreshing(false);
            mAdapter.updateData(houseListVO.getData().getHouse());
        }


    }

    @Override
    public void noData(BaseVO vo) {
        mAutoSwipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void noNet() {
        mAutoSwipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        Bundle bundle = new Bundle();
        HouseListVO.DataBean.HouseBean bean = (HouseListVO.DataBean.HouseBean) mAdapter.getData().get(position);
        bundle.putString("id", bean.getHouse_id());
        open(HouseDetailActivity.class, bundle, 0);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.options1_tv:
                if (mOption1Pop == null) {
                    String[] typeName = new String[mOptionDataBean.getLanguage().size()];
                    String[] typeid = new String[mOptionDataBean.getLanguage().size()];
                    for (int i = 0; i < mOptionDataBean.getLanguage().size(); i++) {
                        typeName[i] = mOptionDataBean.getLanguage().get(i).getName();
                        typeid[i] = mOptionDataBean.getLanguage().get(i).getClass_id();
                    }
                    List<TreeVO> typeList = BaseCommonUtils.getOneLeveTreeVoZero(typeName, typeid);
                    mOption1Pop = new BSPopupWindowsTitle(mActivity, typeList, option1Callback, WidthHigthUtil.getScreenHigh(HouseListOneActivity.this) / 3);
                }
                mOption1Pop.showAsDropDown(mDivider);
                break;
            case R.id.options2_tv:
                if (mOption2Pop == null) {
                    String[] typeName = new String[mOptionDataBean.getRentingStyle().size()];
                    String[] typeid = new String[mOptionDataBean.getRentingStyle().size()];
                    for (int i = 0; i < mOptionDataBean.getRentingStyle().size(); i++) {
                        typeName[i] = mOptionDataBean.getRentingStyle().get(i).getName();
                        typeid[i] = mOptionDataBean.getRentingStyle().get(i).getClass_id();
                    }
                    List<TreeVO> typeList = BaseCommonUtils.getOneLeveTreeVoZero(typeName, typeid);
                    mOption2Pop = new BSPopupWindowsTitle(mActivity, typeList, option1Callback, WidthHigthUtil.getScreenHigh(HouseListOneActivity.this) / 3);
                }
                mOption2Pop.showAsDropDown(mDivider);
                break;
            case R.id.options3_tv:
                if (mOption3Pop == null) {
                    String[] typeName = new String[mOptionDataBean.getFukuan().size()];
                    String[] typeid = new String[mOptionDataBean.getFukuan().size()];
                    for (int i = 0; i < mOptionDataBean.getFukuan().size(); i++) {
                        typeName[i] = mOptionDataBean.getFukuan().get(i).getName();
                        typeid[i] = mOptionDataBean.getFukuan().get(i).getClass_id();
                    }
                    List<TreeVO> typeList = BaseCommonUtils.getOneLeveTreeVoZero(typeName, typeid);
                    mOption3Pop = new BSPopupWindowsTitle(mActivity, typeList, option3Callback, WidthHigthUtil.getScreenHigh(HouseListOneActivity.this) / 3);
                }
                mOption3Pop.showAsDropDown(mDivider);
                break;
            default:
                break;
        }
    }

    BSPopupWindowsTitle.TreeCallBack option1Callback = new BSPopupWindowsTitle.TreeCallBack() {
        @Override
        public void callback(TreeVO vo) {
            String id = vo.getSearchId();
            mOptions1Tv.setText(vo.getName());
            match(1, id);
        }
    };

    BSPopupWindowsTitle.TreeCallBack option3Callback = new BSPopupWindowsTitle.TreeCallBack() {
        @Override
        public void callback(TreeVO vo) {
            String id = vo.getSearchId();
            mOptionsTv3.setText(vo.getName());
            match(3, id);
        }
    };

    @Override
    public void onRefresh() {
        mCurrentPage = 1;

        getData();
    }


    @Override
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }


    public void match(int key, String value) {
        mCurrentPage = 1;
        switch (key) {
            case 0:
                mCurrentPage = 1;
                mLanguageId = "";
                mProvinceId = "";
                mPayClassId = "";
                mRentingStyleId = "";
                break;
            case 1:
                mLanguageId = value;
                break;
            case 2:

                break;
            case 3:
                mPayClassId = value;
                break;


            default:
                break;
        }
        mAutoSwipeRefreshLayout.autoRefresh();
    }
}