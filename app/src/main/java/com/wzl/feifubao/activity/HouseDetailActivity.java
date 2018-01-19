package com.wzl.feifubao.activity;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.HouseDetailVO;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.HashMap;


public class HouseDetailActivity extends BaseActivity implements View.OnClickListener {
    private Banner mBanner;
    private TextView mTag1Tv, mTag2Tv, mTimeTv, mMoneyTv, mPayTypeTv, mApartmentTv, mAreaTv, mRentingStyleTv, mDesc1Tv, mDesc2Tv, mDesc3Tv, mDesc4Tv, mDescTv, mTitleTv;
    private ImageView mHeadImg;
    private TextView mNameTv, mCallTv, mHelpTv;
    private HouseDetailVO.DataBean mDataBean;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_house_detail);
        ;
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("房源详情");
        mBanner = getViewById(R.id.banner);
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        mTag1Tv = getViewById(R.id.tag1_tv);
        mTag2Tv = getViewById(R.id.tag2_tv);
        mTimeTv = getViewById(R.id.time_tv);
        mMoneyTv = getViewById(R.id.money_tv);
        mPayTypeTv = getViewById(R.id.pay_type_tv);
        mApartmentTv = getViewById(R.id.apartment_tv);
        mAreaTv = getViewById(R.id.area_tv);
        mRentingStyleTv = getViewById(R.id.renting_style_tv);
        mDesc1Tv = getViewById(R.id.desc1_tv);
        mDesc2Tv = getViewById(R.id.desc2_tv);
        mDesc3Tv = getViewById(R.id.desc3_tv);
        mDesc4Tv = getViewById(R.id.desc4_tv);
        mDescTv = getViewById(R.id.desc_tv);
        mTitleTv = getViewById(R.id.title_tv);
        mHeadImg = getViewById(R.id.head_img);
        mNameTv = getViewById(R.id.name_tv);
        mCallTv = getViewById(R.id.call_tv);
        mHelpTv = getViewById(R.id.help_tv);
    }

    @Override
    public void bindViewsListener() {
        mCallTv.setOnClickListener(this);
        mHelpTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.getIntent().getStringExtra("id"));
        HttpGetDataUtil.get(mActivity, this, Constant.HOUSE_DETAIL_URL, map, HouseDetailVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        HouseDetailVO houseDetailVO = (HouseDetailVO) vo;
        HouseDetailVO.DataBean dataBean = houseDetailVO.getData();
        mDataBean = dataBean;
        if (dataBean.getHouse_pic() != null && dataBean.getHouse_pic().size() > 0) {
            mBanner.setImages(dataBean.getHouse_pic());

            mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object o, ImageView imageView) {
                    final String bannerVO = (String) o;
                    if (!TextUtils.isEmpty(bannerVO))
                        Picasso.with(context).load(bannerVO).into(imageView);
                }
            });
            mBanner.start();
        }
        mTitleTv.setText(dataBean.getHouse_name());
        String[] tag = dataBean.getHouse_tag().split(";");
        if (tag.length > 1) {
            if (!TextUtils.isEmpty(tag[0])) {
                mTag1Tv.setBackground(BaseCommonUtils.setBackgroundShap(this, 0, R.color.FUBColor3, R.color.C1));
                mTag1Tv.setText(tag[0]);
                mTag1Tv.setVisibility(View.VISIBLE);
            }
            if (!TextUtils.isEmpty(tag[1])) {
                mTag2Tv.setBackground(BaseCommonUtils.setBackgroundShap(this, 0, R.color.FUBColor3, R.color.C1));
                mTag2Tv.setText(tag[1]);
                mTag1Tv.setVisibility(View.VISIBLE);
            }
        }

        mTimeTv.setText(dataBean.getHouse_createtime());
        BaseCommonUtils.setTextTwoBefore(this, mMoneyTv, dataBean.getHouse_price(), "月/元", R.color.FUBColor3, 1.5f);
        mPayTypeTv.setText("????啥字段");

        mApartmentTv.setText(dataBean.getApartment());
        mAreaTv.setText(dataBean.getHouse_area());
        mRentingStyleTv.setText(dataBean.getRenting_style());

        BaseCommonUtils.setTextTwoBefore(this, mDesc1Tv, "朝向：", dataBean.getPosition(), R.color.C5, 1.0f);
        BaseCommonUtils.setTextTwoBefore(this, mDesc2Tv, "装修：", dataBean.getDecorateStyle(), R.color.C5, 1.0f);
        BaseCommonUtils.setTextTwoBefore(this, mDesc3Tv, "楼层：", dataBean.getHouse_floor(), R.color.C5, 1.0f);
        BaseCommonUtils.setTextTwoBefore(this, mDesc4Tv, "类型：", dataBean.getHouseStyle(), R.color.C5, 1.0f);
        mDescTv.setText(dataBean.getHouse_details());
        if (!TextUtils.isEmpty(dataBean.getUser_headimg()))
            Picasso.with(mActivity).load(dataBean.getUser_headimg()).into(mHeadImg);
//        mNameTv.setText(dataBean.get);
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.call_tv:
                BaseCommonUtils.call(this, mDataBean.getHouse_phone());
                break;
            default:
                break;
        }
    }
}
