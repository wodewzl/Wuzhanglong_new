package com.wzl.feifubao.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
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
import com.wzl.feifubao.mode.CityVO;
import com.wzl.feifubao.mode.HouseListVO;
import com.wzl.feifubao.mode.HouseOptionVO;

import java.util.ArrayList;
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
            HttpGetDataUtil.get(mActivity, this, Constant.CITY_URL, map, CityVO.class);
            mFlag = false;
        }

        HashMap<String, Object> map = new HashMap<>();
        map.put("page", mCurrentPage + "");
        map.put("pagesize", "10");
        map.put("cityId", mCityId);
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

        } else if (vo instanceof CityVO) {
            CityVO cityVO = (CityVO) vo;

            ArrayList<TreeVO> treeList = getTreeVOList((ArrayList<CityVO.DataBean>) cityVO.getData());
            mOption2Pop = new BSPopupWindowsTitle(mActivity, treeList, callbackCity);


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
                    List<TreeVO> typeList = BaseCommonUtils.getOneLeveTreeVoHasAll(typeName, typeid);
                    mOption1Pop = new BSPopupWindowsTitle(mActivity, typeList, option1Callback, WidthHigthUtil.getScreenHigh(HouseListOneActivity.this) / 3);
                }
                mOption1Pop.showAsDropDown(mDivider);
                break;
            case R.id.options2_tv:
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
                    List<TreeVO> typeList = BaseCommonUtils.getOneLeveTreeVoHasAll(typeName, typeid);
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
            if ("全部".equals(vo.getName())) {
                mOptions1Tv.setTextColor(ContextCompat.getColor(HouseListOneActivity.this, R.color.C4));
            } else {
                mOptions1Tv.setTextColor(ContextCompat.getColor(HouseListOneActivity.this, R.color.colorAccent));
            }
            mOptions1Tv.setText(vo.getName());
            match(1, id);
        }
    };

    BSPopupWindowsTitle.TreeCallBack option3Callback = new BSPopupWindowsTitle.TreeCallBack() {
        @Override
        public void callback(TreeVO vo) {
            String id = vo.getSearchId();
            if ("全部".equals(vo.getName())) {
                mOptionsTv3.setTextColor(ContextCompat.getColor(HouseListOneActivity.this, R.color.C4));
            } else {
                mOptionsTv3.setTextColor(ContextCompat.getColor(HouseListOneActivity.this, R.color.colorAccent));
            }
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
                mCityId = value;
                break;
            case 5:
                mProvinceId = value;
                break;
            case 3:
                mPayClassId = value;
                break;


            default:
                break;
        }
        mAutoSwipeRefreshLayout.autoRefresh();
    }

    // 一级二级都带全部的菜单
    public ArrayList<TreeVO> getTreeVOList(ArrayList<CityVO.DataBean> allList) {
        ArrayList<TreeVO> treeList = new ArrayList<TreeVO>();
        for (int i = 0; i < allList.size(); i++) {
            if (i == 0) {
                TreeVO oneTitleTreeVo = new TreeVO();
                oneTitleTreeVo.setSearchId("");
                oneTitleTreeVo.setName("全部");
                oneTitleTreeVo.setLevel(1);
                treeList.add(oneTitleTreeVo);
            }

            CityVO.DataBean oneCityVO = allList.get(i);
            TreeVO oneTreeVo = new TreeVO();
            oneTreeVo.setSearchId(oneCityVO.getProvince_id());
            oneTreeVo.setParentId(0);
            oneTreeVo.setId(Integer.parseInt(oneCityVO.getProvince_id()));
            oneTreeVo.setName(oneCityVO.getProvince_name());
            oneTreeVo.setLevel(1);
            if (oneCityVO.getCitys().size() > 0) {
                oneTreeVo.setHaschild(true);
            } else {
                oneTreeVo.setHaschild(false);
            }
            treeList.add(oneTreeVo);
            for (int j = 0; j < oneCityVO.getCitys().size(); j++) {

                if (j == 0) {
                    TreeVO twoTitleTreeVo = new TreeVO();
                    twoTitleTreeVo.setSearchId(oneCityVO.getProvince_id());
                    twoTitleTreeVo.setName("全部");
                    twoTitleTreeVo.setLevel(1);
                    twoTitleTreeVo.setParentId(Integer.parseInt(oneCityVO.getProvince_id()));
                    treeList.add(twoTitleTreeVo);
                }

                CityVO.DataBean.CitysBean twoCityVO = oneCityVO.getCitys().get(j);
                TreeVO twoTreeVo = new TreeVO();
                twoTreeVo.setSearchId(twoCityVO.getCity_id());
                twoTreeVo.setName(twoCityVO.getCity_name());
                twoTreeVo.setLevel(2);
                twoTreeVo.setParentId(Integer.parseInt(oneCityVO.getProvince_id()));
                twoTreeVo.setId(Integer.parseInt(twoCityVO.getCity_id()));
                if (twoCityVO.getDistricts().size() > 0) {
                    twoTreeVo.setHaschild(true);
                } else {
                    twoTreeVo.setHaschild(false);
                }
                treeList.add(twoTreeVo);

            }
        }
        return treeList;
    }

    // 菜单点击回调函数
    BSPopupWindowsTitle.TreeCallBack callbackCity = new BSPopupWindowsTitle.TreeCallBack() {
        @Override
        public void callback(TreeVO vo) {
            if ("全部".equals(vo.getName())) {
                mOptionsTv2.setTextColor(ContextCompat.getColor(HouseListOneActivity.this, R.color.C4));
            } else {
                mOptionsTv2.setTextColor(ContextCompat.getColor(HouseListOneActivity.this, R.color.colorAccent));
            }
            mOptionsTv2.setText(vo.getName());
            if(vo.getLevel()==1){
                match(5, vo.getSearchId());
                mCityId="";
            }else {
                match(2, vo.getSearchId());
            }
        }
    };

}
