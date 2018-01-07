package com.wzl.feifubao.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.Button;
import com.rey.material.widget.CheckBox;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.FileUtil;
import com.wuzhanglong.library.utils.WebviewUtil;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.RateQueryVO;
import com.wzl.feifubao.mode.ShopDetailVO;
import com.wzl.feifubao.mode.ShopVO;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;


import java.util.HashMap;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class ShopDetailActivity extends BaseActivity {
    private BottomSheetDialog mDialog;
    private Banner mBanner;
    private TextView mNameTv,mPriceTv,mCommentTv,mCommentCountTv;
    private MaterialRatingBar mRatingBar;
    private WebView mWebView;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_shop_detail);
    }

    @Override
    public void initView() {
        mBanner = getViewById(R.id.banner);
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        mNameTv=getViewById(R.id.name_tv);
        mPriceTv=getViewById(R.id.price_tv);
        mRatingBar = getViewById(R.id.rating_bar);
        mWebView=getViewById(R.id.webView);
        WebviewUtil.SetWebview(mWebView);
        mCommentTv=getViewById(R.id.comment_tv);
        mCommentCountTv=getViewById(R.id.comment_count_tv);

    }

    @Override
    public void bindViewsListener() {
    }

    @Override
    public void getData() {

        HashMap<String, Object> map = new HashMap<>();
        if (AppApplication.getInstance().getUserInfoVO() != null)
            map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
//        map.put("goodsId", this.getIntent().getStringExtra("id"));
        map.put("goodsId", "3");
        HttpGetDataUtil.get(mActivity, this, Constant.SHOP_DETAIL_ULR, map,ShopDetailVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        ShopDetailVO shopDetailVO = (ShopDetailVO) vo;
        ShopDetailVO.DataBean dataBean=shopDetailVO.getData();
        if (dataBean.getImg_list() != null && dataBean.getImg_list().size()> 0) {
            mBanner.setImages(dataBean.getImg_list());

            mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object o, ImageView imageView) {
                    final String bannerVO = (String) o;
                    Picasso.with(context).load(bannerVO).into(imageView);
                }
            });
            mBanner.start();
        }

        mNameTv.setText(dataBean.getGoods_name());
        mPriceTv.setText(dataBean.getPrice()+"P");
        mRatingBar.setEnabled(false);
        mRatingBar.setRating(BaseCommonUtils.parseInt(dataBean.getMatch_point()));
        mWebView.loadDataWithBaseURL(FileUtil.getSaveFilePath(this,Constant.SDCARD_CACHE), dataBean.getDescription(), "text/html", "utf-8", null);
        mCommentTv.setText(dataBean.getMatch_point());
        mCommentCountTv.setText(dataBean.getEvaluates_count()+"人已评价");
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    public void choseShop(){
        mDialog = new BottomSheetDialog(mActivity);
        View dialogView = View.inflate(mActivity, R.layout.pay_view, null);
        mDialog.contentView(dialogView)
                .heightParam(ViewGroup.LayoutParams.WRAP_CONTENT)
                .inDuration(500)
                .cancelable(true)
                .show();
    }
}
