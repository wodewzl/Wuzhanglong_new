package com.wzl.feifubao.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
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
import android.widget.LinearLayout;
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
import com.wzl.feifubao.mode.CityVO;
import com.wzl.feifubao.mode.HouseListVO;
import com.wzl.feifubao.mode.HouseOptionVO;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class HouseListActivity extends BaseActivity implements BGAOnRVItemClickListener, ScrollableHelper.ScrollableContainer, View.OnClickListener, OnLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener, android.widget.TextView.OnEditorActionListener, TextWatcher {
    private LuRecyclerView mRecyclerView;
    private HouseListAdapter mAdapter;
    private ScrollableLayout mScrollableLayout;
    private Banner mBanner;
    private boolean mFlag = true;
    private TextView mOptions1Tv, mOptionsTv2, mOptionsTv3;
    private BSPopupWindowsTitle mOption1Pop, mOption2Pop, mOption3Pop;
    private HouseOptionVO.DataBean mOptionDataBean;
    private TextView mType1Tv, mType2Tv, mType3Tv, mType4Tv;
    private View mDivider;
    private EditText mSearchEt;
    private String mKeyword = "";
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String mLanguageId = "";
    private String mCityId = "";
    private String mProvinceId = "";
    private String mPayClassId = "";
    private String mRentingStyleId = "";
    private int mDistanceY;
    private LinearLayout mTitleLayout;
    private TextView mBackTv;
    private CityVO.DataBean mCityVO;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_house_list);
    }

    @Override
    public void initView() {
        mBaseHeadLayout.setVisibility(View.GONE);
        setTranslanteBar();
        mSearchEt = getViewById(R.id.search_et);
        mSearchEt.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        mSearchEt.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mScrollableLayout = getViewById(R.id.scrollable_Layout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mScrollableLayout.getHelper().setCurrentScrollableContainer(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new HouseListAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadMoreEnabled(false);
        mBanner = getViewById(R.id.banner);

        mOptions1Tv = getViewById(R.id.options1_tv);
        mOptionsTv2 = getViewById(R.id.options2_tv);
        mOptionsTv3 = getViewById(R.id.options3_tv);
        mDivider = getViewById(R.id.divider);

        mType1Tv = getViewById(R.id.type_01_tv);
        mType2Tv = getViewById(R.id.type_02_tv);
        mType3Tv = getViewById(R.id.type_03_tv);
        mType4Tv = getViewById(R.id.type_04_tv);
        mTitleLayout = getViewById(R.id.title_view);
        mBackTv = getViewById(R.id.back_tv);
    }

    @Override
    public void bindViewsListener() {
        mBackTv.setOnClickListener(this);
        mOptions1Tv.setOnClickListener(this);
        mOptionsTv2.setOnClickListener(this);
        mOptionsTv3.setOnClickListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mSearchEt.setOnEditorActionListener(this);
        mSearchEt.addTextChangedListener(this);
        mType1Tv.setOnClickListener(this);
        mType2Tv.setOnClickListener(this);
        mType3Tv.setOnClickListener(this);
        mType4Tv.setOnClickListener(this);

//        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                //滑动的距离
//                mDistanceY += dy;
//                //toolbar的高度
////                int toolbarHeight = mTitleLayout.getBottom();
//                int toolbarHeight = BaseCommonUtils.dip2px(mActivity, 200);
//                //当滑动的距离 <= toolbar高度的时候，改变Toolbar背景色的透明度，达到渐变的效果
//                if (mDistanceY <= toolbarHeight) {
//                    float scale = (float) mDistanceY / toolbarHeight;
//                    float alpha = scale * 255;
//                    mTitleLayout.setBackgroundColor(Color.argb((int) alpha, 28, 104, 239));
////                    RxAnimationUtils.animationColorGradient(R.color.C15, R.color.C7, new onUpdateListener() {
////                        @Override
////                        public void onUpdate(int i) {
////
////                        }
////                    });
//                } else {
//                    //将标题栏的颜色设置为完全不透明状态
//                    mTitleLayout.setBackgroundResource(R.color.colorAccent);
//                }
//            }
//        });
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
        map.put("keyword", mKeyword);
        map.put("languageId", mLanguageId);
        map.put("provinceId", mProvinceId);
        map.put("cityId", mCityId);
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
            mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object o, ImageView imageView) {
                    final HouseListVO.DataBean.AdvsBean bannerVO = (HouseListVO.DataBean.AdvsBean) o;
                    if (!TextUtils.isEmpty(bannerVO.getAdv_image()))
                        Picasso.with(context).load(bannerVO.getAdv_image()).into(imageView);
                }
            });

            mBanner.setImages(houseListVO.getData().getAdvs());
            mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            mBanner.setBannerAnimation(Transformer.CubeIn);
            mBanner.setIndicatorGravity(BannerConfig.CENTER);

            mBanner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int i) {
                }
            });
            mBanner.start();
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
    public View getScrollableView() {
        return mRecyclerView;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
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
                    mOption1Pop = new BSPopupWindowsTitle(mActivity, typeList, option1Callback, WidthHigthUtil.getScreenHigh(HouseListActivity.this) / 3);
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
                    mOption3Pop = new BSPopupWindowsTitle(mActivity, typeList, option3Callback, WidthHigthUtil.getScreenHigh(HouseListActivity.this) / 3);
                }
                mOption3Pop.showAsDropDown(mDivider);
                break;
            case R.id.type_01_tv:
                intent.setClass(this, HouseListOneActivity.class);
                intent.putExtra("rentingStyleId", mOptionDataBean.getRentingStyle().get(0).getClass_id());
                intent.putExtra("name", "整租");
                this.startActivity(intent);
                break;
            case R.id.type_02_tv:
                intent.setClass(this, HouseListOneActivity.class);
                intent.putExtra("rentingStyleId", mOptionDataBean.getRentingStyle().get(1).getClass_id());
                intent.putExtra("name", "合租");
                this.startActivity(intent);
                break;
            case R.id.type_03_tv:
                intent.setClass(this, HouseListOneActivity.class);
                intent.putExtra("rentingStyleId", mOptionDataBean.getRentingStyle().get(2).getClass_id());
                intent.putExtra("name", "短租");
                this.startActivity(intent);
                break;
            case R.id.type_04_tv:
                openActivity(HouseAddActivity.class);
                break;
            case R.id.back_tv:
                this.finish();
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
                mOptions1Tv.setTextColor(ContextCompat.getColor(HouseListActivity.this, R.color.C4));
            } else {
                mOptions1Tv.setTextColor(ContextCompat.getColor(HouseListActivity.this, R.color.colorAccent));
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
                mOptionsTv3.setTextColor(ContextCompat.getColor(HouseListActivity.this, R.color.C4));
            } else {
                mOptionsTv3.setTextColor(ContextCompat.getColor(HouseListActivity.this, R.color.colorAccent));
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

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        BaseCommonUtils.hideSoftKeybord(this);
        mKeyword = textView.getText().toString();
//        mCurrentPage=1;
//        getData();
        match(4, mKeyword);
        return false;
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence s, int i, int i1, int i2) {
        if ("".equals(s.toString())) {
            mKeyword = "";
            mCurrentPage = 1;
            mAutoSwipeRefreshLayout.autoRefresh();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    public void match(int key, String value) {
        mCurrentPage = 1;
        switch (key) {
            case 0:
                mKeyword = "";
                mCurrentPage = 1;
                mLanguageId = "";
                mProvinceId = "";
                mCityId="";
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
            case 4:
                mKeyword = value;
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
                for (int k = 0; k < twoCityVO.getDistricts().size(); k++) {
                    CityVO.DataBean.CitysBean.DistrictsBean threeCityVO = oneCityVO.getCitys().get(j).getDistricts().get(k);
                    TreeVO threeTreeVo = new TreeVO();
                    twoTreeVo.setSearchId(threeCityVO.getDistrict_id());
                    twoTreeVo.setName(threeCityVO.getDistrict_name());
                    twoTreeVo.setLevel(3);
                    twoTreeVo.setParentId(Integer.parseInt(twoCityVO.getCity_id()));
                    twoTreeVo.setId(Integer.parseInt(threeCityVO.getDistrict_id()));
                    treeList.add(threeTreeVo);
                }
            }
        }
        return treeList;
    }

    // 菜单点击回调函数
    BSPopupWindowsTitle.TreeCallBack callbackCity = new BSPopupWindowsTitle.TreeCallBack() {
        @Override
        public void callback(TreeVO vo) {
            if ("全部".equals(vo.getName())) {
                mOptionsTv2.setTextColor(ContextCompat.getColor(HouseListActivity.this, R.color.C4));
            } else {
                mOptionsTv2.setTextColor(ContextCompat.getColor(HouseListActivity.this, R.color.colorAccent));
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
