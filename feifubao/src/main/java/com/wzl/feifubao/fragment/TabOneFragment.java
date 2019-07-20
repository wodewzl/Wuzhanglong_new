package com.wzl.feifubao.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.HouseDetailActivity;
import com.wzl.feifubao.activity.HouseListActivity;
import com.wzl.feifubao.activity.JobOffersActivity;
import com.wzl.feifubao.activity.JobOffersDetailActivity;
import com.wzl.feifubao.activity.LifeActivity;
import com.wzl.feifubao.activity.MessageActivity;
import com.wzl.feifubao.activity.PayElectricityActivity;
import com.wzl.feifubao.activity.PayInternetActivity;
import com.wzl.feifubao.activity.PhoneChargeActivity;
import com.wzl.feifubao.activity.RateQueryActivity;
import com.wzl.feifubao.activity.ShopDetailActivity;
import com.wzl.feifubao.activity.WebViewActivity;
import com.wzl.feifubao.activity.YellowPagesActivity;
import com.wzl.feifubao.adapter.HomeAdapter;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.HomeVO;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class TabOneFragment extends BaseFragment implements View.OnClickListener, BGAOnRVItemClickListener {

    private LuRecyclerView mRecyclerView;
    private HomeAdapter mAdapter;
    private LuRecyclerViewAdapter mLuAdapter;
    private HomeVO.DataBean mDataBean;
    private LinearLayout mType2Layout, mType3Layout, mType4Layout, mType5Layout, mType8Layout;
    private Banner mBanner;
    private TextView mType3v01Tv, mType3v02Tv, mType5TitleTv, mType5DescTv, mType5BuyTv;
    private ImageView mType4Img01, mType4Img02, mType5GoodsImg;
    private TextView mType1Tv01, mType1Tv02, mType1Tv03, mType1Tv04, mType1Tv05, mType1Tv06, mType1Tv07, mType1Tv08;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_one_fragment);
    }

    @Override
    public void initView(View view) {
        mActivity.mBaseHeadLayout.setVisibility(View.VISIBLE);
        mActivity.mBaseTitleTv.setText("菲付宝");

        initHeadView(view);
        mRecyclerView = getViewById(R.id.recycler_view);
//        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_1, R.color.C3);
//        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(mActivity);
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new HomeAdapter(mRecyclerView);
        mLuAdapter = new LuRecyclerViewAdapter(mAdapter);
//        mLuAdapter.addHeaderView(initHeadView());
        mRecyclerView.setAdapter(mLuAdapter);
        mRecyclerView.setLoadMoreEnabled(false);
    }

    @Override
    public void bindViewsListener() {
        mType1Tv01.setOnClickListener(this);
        mType1Tv02.setOnClickListener(this);
        mType1Tv03.setOnClickListener(this);
        mType1Tv04.setOnClickListener(this);
        mType1Tv05.setOnClickListener(this);
        mType1Tv06.setOnClickListener(this);
        mType1Tv07.setOnClickListener(this);
        mType1Tv08.setOnClickListener(this);
        mAdapter.setOnRVItemClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        HttpGetDataUtil.get(mActivity, this, Constant.HOME_URL, map, HomeVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        HomeVO homeVO = (HomeVO) vo;

        mDataBean = homeVO.getData();


        if (mDataBean.getAdvs() == null || mDataBean.getAdvs().size() == 0) {
            mType2Layout.setVisibility(View.GONE);
        } else {
            mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object o, ImageView imageView) {

                    final HomeVO.DataBean.AdvsBean bannerVO = (HomeVO.DataBean.AdvsBean) o;
                    Picasso.with(context).load(bannerVO.getAdv_image()).into(imageView);
                }
            });

            mBanner.setImages(mDataBean.getAdvs());
            mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
            mBanner.setIndicatorGravity(BannerConfig.CENTER);
            mBanner.setOnBannerListener(new OnBannerListener() {
                @Override
                public void OnBannerClick(int i) {
                    showActivity(mDataBean.getAdvs().get(i).getClass_id(), mDataBean.getAdvs().get(i).getId(), mDataBean.getAdvs().get(i).getContent());
                }
            });
            mBanner.start();
        }

        if (mDataBean.getArticles() == null || mDataBean.getArticles().size() == 0) {
            mType3Layout.setVisibility(View.GONE);
        } else {
            mType3v01Tv.setText(mDataBean.getArticles().get(0).getJpush_content());
            mType3v02Tv.setText(mDataBean.getArticles().get(1).getJpush_content());
            mType3Layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mActivity.openActivity(MessageActivity.class);
                }
            });

        }

        if (mDataBean.getHuo() == null || mDataBean.getHuo().size() == 0) {
            mType4Layout.setVisibility(View.GONE);

        } else {
            if (!TextUtils.isEmpty(mDataBean.getHuo().get(0).getAdv_image())) {
                Picasso.with(mActivity).load(mDataBean.getHuo().get(0).getAdv_image()).into(mType4Img01);
                mType4Img01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showActivity(mDataBean.getHuo().get(0).getClass_id(), mDataBean.getHuo().get(0).getId(), "");
                    }
                });

            }

            if (!TextUtils.isEmpty(mDataBean.getHuo().get(1).getAdv_image())) {
                Picasso.with(mActivity).load(mDataBean.getHuo().get(1).getAdv_image()).into(mType4Img02);
                mType4Img02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        showActivity(mDataBean.getHuo().get(1).getClass_id(), mDataBean.getHuo().get(1).getId(), "");

                    }
                });
            }


        }

//        if (mDataBean.getGoods() == null || mDataBean.getGoods().size() == 0) {
//            mType5Layout.setVisibility(View.GONE);
//        } else {
//            mType5TitleTv.setText(mDataBean.getGoods().get(0).getGoods_name());
//            mType5DescTv.setText(mDataBean.getGoods().get(0).getDescription());
//            if (!TextUtils.isEmpty(mDataBean.getGoods().get(0).getPic_cover_small()))
//                Picasso.with(mActivity).load(mDataBean.getGoods().get(0).getPic_cover_small()).into(mType5GoodsImg);
//            mType5BuyTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, BaseCommonUtils.dip2px(mActivity, 30), R.color.colorAccent, R.color.FUBColor5));
//            mType5BuyTv.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                }
//            });
//        }
        mAdapter.updateData(mDataBean.getTishi());

        ACache.get(mActivity).put("kefu", mDataBean.getKefu());

        ACache.get(mActivity).put("electricity_bill", mDataBean.getElectricity_bill());

        ACache.get(mActivity).put("internet_information", mDataBean.getInternet_information());
        ACache.get(mActivity).put("rate", mDataBean.getRate());
        EventBus.getDefault().post(new EBMessageVO("load"));
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    public View initHeadView(View header) {
//        View header = View.inflate(mActivity, R.layout.home_head_layout, null);
        mType1Tv01 = header.findViewById(R.id.type_01_tv);
        mType1Tv02 = header.findViewById(R.id.type_02_tv);
        mType1Tv03 = header.findViewById(R.id.type_03_tv);
        mType1Tv04 = header.findViewById(R.id.type_04_tv);
        mType1Tv05 = header.findViewById(R.id.type_05_tv);
        mType1Tv06 = header.findViewById(R.id.type_06_tv);
        mType1Tv07 = header.findViewById(R.id.type_07_tv);
        mType1Tv08 = header.findViewById(R.id.type_08_tv);

        mType2Layout = header.findViewById(R.id.type2_layout);
        mBanner = header.findViewById(R.id.banner);

        mType3Layout = header.findViewById(R.id.type3_layout);
        mType3v01Tv = header.findViewById(R.id.type3_tv01);
        mType3v02Tv = header.findViewById(R.id.type3_tv02);

        mType4Layout = header.findViewById(R.id.type4_layout);
        mType4Img01 = header.findViewById(R.id.typ4_01_img);
        mType4Img02 = header.findViewById(R.id.typ4_02_img);

        mType5Layout = header.findViewById(R.id.type5_layout);
        mType5TitleTv = header.findViewById(R.id.typ5_title_tv);
        mType5DescTv = header.findViewById(R.id.typ5_desc_tv);
        mType5BuyTv = header.findViewById(R.id.type5_buy_tv);
        mType5GoodsImg = header.findViewById(R.id.type5_googs_tv);
        return header;
    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.type_01_tv:
                mActivity.openActivity(PhoneChargeActivity.class);
                break;
            case R.id.type_02_tv:

                mActivity.openActivity(PayElectricityActivity.class);

                break;
            case R.id.type_03_tv:

                mActivity.openActivity(PayInternetActivity.class);

                break;
            case R.id.type_04_tv:
                mActivity.openActivity(LifeActivity.class);
                break;
            case R.id.type_05_tv:
                mActivity.openActivity(HouseListActivity.class);
                break;
            case R.id.type_06_tv:
                mActivity.openActivity(JobOffersActivity.class);
//                mActivity.openActivity(JobOffersDetailActivity.class);
                break;
            case R.id.type_07_tv:
                mActivity.openActivity(RateQueryActivity.class);
                break;
            case R.id.type_08_tv:
                mActivity.openActivity(YellowPagesActivity.class);
                break;
            default:
                break;
        }
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        HomeVO.DataBean.TishiBean tishiBean= (HomeVO.DataBean.TishiBean) mAdapter.getData().get(position);
        Bundle bundle = new Bundle();
        bundle.putString("url", tishiBean.getUrl());
        bundle.putString("title", "文章详情");
        mActivity.open(WebViewActivity.class, bundle, 0);
    }

    public void showActivity(String type, String id, String url) {
        Bundle bundle = new Bundle();
        bundle.putString("id", id);
        if ("1".equals(type)) {
            mActivity.open(HouseDetailActivity.class, bundle, 0);

        } else if ("2".equals(type)) {
            mActivity.open(JobOffersDetailActivity.class, bundle, 0);
        } else if ("3".equals(type)) {
            mActivity.open(ShopDetailActivity.class, bundle, 0);

        } else if ("4".equals(type)) {
            bundle.putString("url", url);
            bundle.putString("title", "文章详情");
            mActivity.open(WebViewActivity.class, bundle, 0);
        }
    }


}
