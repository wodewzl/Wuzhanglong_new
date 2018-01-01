package com.wzl.feifubao.activity;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
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
import com.wuzhanglong.library.view.BSPopupWindowsTitle;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.HouseListAdapter;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.HomeVO;
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

public class HouseListActivity extends BaseActivity implements BGAOnRVItemClickListener, ScrollableHelper.ScrollableContainer,View.OnClickListener{
    private LuRecyclerView mRecyclerView;
    private HouseListAdapter mAdapter;
    private ScrollableLayout mScrollableLayout;
    private Banner mBanner;
    private boolean mFlag = true;
    private TextView mOptions1Tv, mOptionsTv2,mOptionsTv3;
    private BSPopupWindowsTitle mOption1Pop,mOption2Pop,mOption3Pop;
    private HouseOptionVO.DataBean mOptionDataBean;
    private View mDivider;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_house_list);
    }

    @Override
    public void initView() {
        mBaseHeadLayout.setVisibility(View.GONE);
        setTranslanteBar();
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
        mDivider=getViewById(R.id.divider);
    }

    @Override
    public void bindViewsListener() {
        mOptions1Tv.setOnClickListener(this);
        mOptionsTv2.setOnClickListener(this);
        mOptionsTv3.setOnClickListener(this);
        mAdapter.setOnRVItemClickListener(this);
    }

    @Override
    public void getData() {
        if (mFlag) {
            HashMap<String, Object> map = new HashMap<>();
            HttpGetDataUtil.get(mActivity, this, Constant.HOUSE_LIST_OPTION_URL, map, HouseOptionVO.class);
            mFlag = false;
        }

        HashMap<String, Object> map = new HashMap<>();
        HttpGetDataUtil.get(mActivity, this, Constant.HOUSE_LIST_URL, map, HouseListVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof HouseOptionVO) {
            HouseOptionVO houseOptionVO = (HouseOptionVO) vo;
            mOptionDataBean=houseOptionVO.getData();

        } else if (vo instanceof HouseListVO) {
            HouseListVO houseListVO= (HouseListVO) vo;
            mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object o, ImageView imageView) {
                    final HouseListVO.DataBean.AdvsBean bannerVO = (HouseListVO.DataBean.AdvsBean) o;
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

            mAdapter.updateData(houseListVO.getData().getHouse());
        }


    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {

    }

    @Override
    public View getScrollableView() {
        return mRecyclerView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.options1_tv:
                if (mOption1Pop == null) {
                    String[] typeName = new String[mOptionDataBean.getHuxing().size()];
                    String[] typeid = new String[mOptionDataBean.getHuxing().size()];
                    for (int i = 0; i <mOptionDataBean.getHuxing().size(); i++) {
                        typeName[i] = mOptionDataBean.getHuxing().get(i).getName();
                        typeid[i] = mOptionDataBean.getHuxing().get(i).getClass_id();
                    }
                    List<TreeVO> typeList = BaseCommonUtils.getOneLeveTreeVoZero(typeName, typeid);
                    mOption1Pop= new BSPopupWindowsTitle(mActivity, typeList, option1Callback, WidthHigthUtil.getScreenHigh(HouseListActivity.this) / 3);
                }
                mOption1Pop.showAsDropDown(mDivider);
                break;
            case R.id.options2_tv:
                if (mOption2Pop == null) {
                    String[] typeName = new String[mOptionDataBean.getRentingStyle().size()];
                    String[] typeid = new String[mOptionDataBean.getRentingStyle().size()];
                    for (int i = 0; i <mOptionDataBean.getRentingStyle().size(); i++) {
                        typeName[i] = mOptionDataBean.getRentingStyle().get(i).getName();
                        typeid[i] = mOptionDataBean.getRentingStyle().get(i).getClass_id();
                    }
                    List<TreeVO> typeList = BaseCommonUtils.getOneLeveTreeVoZero(typeName, typeid);
                    mOption2Pop= new BSPopupWindowsTitle(mActivity, typeList, option1Callback, WidthHigthUtil.getScreenHigh(HouseListActivity.this) / 3);
                }
                mOption2Pop.showAsDropDown(mDivider);
                break;
            case R.id.options3_tv:
                if (mOption3Pop == null) {
                    String[] typeName = new String[mOptionDataBean.getFukuan().size()];
                    String[] typeid = new String[mOptionDataBean.getFukuan().size()];
                    for (int i = 0; i <mOptionDataBean.getFukuan().size(); i++) {
                        typeName[i] = mOptionDataBean.getFukuan().get(i).getName();
                        typeid[i] = mOptionDataBean.getFukuan().get(i).getClass_id();
                    }
                    List<TreeVO> typeList = BaseCommonUtils.getOneLeveTreeVoZero(typeName, typeid);
                    mOption3Pop= new BSPopupWindowsTitle(mActivity, typeList, option1Callback, WidthHigthUtil.getScreenHigh(HouseListActivity.this) / 3);
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
//            mType = vo.getSearchId();
            mOptionsTv2.setText(vo.getName());
//            mAutoSwipeRefreshLayout.autoRefresh();
        }
    };
}
