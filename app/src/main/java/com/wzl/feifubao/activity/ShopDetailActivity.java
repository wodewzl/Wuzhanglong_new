package com.wzl.feifubao.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rey.material.app.BottomSheetDialog;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.FileUtil;
import com.wuzhanglong.library.utils.WebviewUtil;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.ShopChoseAdapter;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.ShopDetailVO;
import com.wzl.feifubao.view.NumberButton;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import q.rorbin.badgeview.QBadgeView;

public class ShopDetailActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private BottomSheetDialog mDialog;
    private Banner mBanner;
    private TextView mNameTv, mPriceTv, mCommentTv, mCommentCountTv;
    private MaterialRatingBar mRatingBar;
    private WebView mWebView;
    private List<ShopDetailVO.DataBean.SpecListBean.ValueBean> mList = new ArrayList<>();
    private TextView mAddCartTv, mBuyTv;
    private ShopDetailVO.DataBean mDataBean;
    private String mType;
    private TextView mShopTypeTv;
    private String mGoodName, mGoodsId, mGoodPrice, mShopType;
    private int mCount;
    private LinearLayout mCartLayout;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_shop_detail);
    }

    @Override
    public void initView() {
        mBanner = getViewById(R.id.banner);
        mBanner.setBannerStyle(BannerConfig.NUM_INDICATOR);
        mBanner.setIndicatorGravity(BannerConfig.RIGHT);
        mNameTv = getViewById(R.id.name_tv);
        mPriceTv = getViewById(R.id.price_tv);
        mRatingBar = getViewById(R.id.rating_bar);
        mWebView = getViewById(R.id.webView);
        WebviewUtil.SetWebview(mWebView);
        mCommentTv = getViewById(R.id.comment_tv);
        mCommentCountTv = getViewById(R.id.comment_count_tv);
        mAddCartTv = getViewById(R.id.add_cart_tv);
        mBuyTv = getViewById(R.id.buy_tv);
        mShopTypeTv = getViewById(R.id.shop_type_tv);
        mCartLayout=getViewById(R.id.add_cart_layout);
    }

    @Override
    public void bindViewsListener() {
        mAddCartTv.setOnClickListener(this);
        mBuyTv.setOnClickListener(this);
    }

    @Override
    public void getData() {

        HashMap<String, Object> map = new HashMap<>();
        if (AppApplication.getInstance().getUserInfoVO() != null)
            map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
//        map.put("goodsId", this.getIntent().getStringExtra("id"));
        map.put("goodsId", "3");
        HttpGetDataUtil.get(mActivity, this, Constant.SHOP_DETAIL_ULR, map, ShopDetailVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        ShopDetailVO shopDetailVO = (ShopDetailVO) vo;
        ShopDetailVO.DataBean dataBean = shopDetailVO.getData();
        mDataBean = dataBean;
        if (dataBean.getImg_list() != null && dataBean.getImg_list().size() > 0) {
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
        mPriceTv.setText(dataBean.getPrice() + "P");
        mRatingBar.setEnabled(false);
        mRatingBar.setRating(BaseCommonUtils.parseInt(dataBean.getMatch_point()));
        mWebView.loadDataWithBaseURL(FileUtil.getSaveFilePath(this, Constant.SDCARD_CACHE), dataBean.getDescription(), "text/html", "utf-8", null);
        mCommentTv.setText(dataBean.getMatch_point());
        mCommentCountTv.setText(dataBean.getEvaluates_count() + "人已评价");

        for (int i = 0; i < dataBean.getSpec_list().size(); i++) {
            ShopDetailVO.DataBean.SpecListBean.ValueBean valueBean = new ShopDetailVO.DataBean.SpecListBean.ValueBean();
            valueBean.setSpec_id(dataBean.getSpec_list().get(i).getSpec_id());
            valueBean.setSpec_name(dataBean.getSpec_list().get(i).getSpec_name());
            mList.add(valueBean);
            for (int j = 0; j < dataBean.getSpec_list().get(i).getValue().size(); j++) {
                mList.add(dataBean.getSpec_list().get(i).getValue().get(j));

            }
        }
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    public void choseShop() {
        View dialogView = View.inflate(this, R.layout.shop_chose_dialog, null);

        mDialog = new BottomSheetDialog(mActivity);
        RecyclerView recyclerView = dialogView.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        final ShopChoseAdapter adapter = new ShopChoseAdapter(recyclerView);
        recyclerView.setAdapter(adapter);
        adapter.updateData(mList);

        TextView moneTv = dialogView.findViewById(R.id.money_tv);
        ImageView shopImg = dialogView.findViewById(R.id.shop_img);
        ImageView colseIm = dialogView.findViewById(R.id.colse_img);
        TextView okTv = dialogView.findViewById(R.id.ok_tv);
        NumberButton numberBt=dialogView.findViewById(R.id.number_bt);
        numberBt.setmOnTextChangeListener(new NumberButton.OnTextChangeListener() {
            @Override
            public void onTextChange(int count) {
                mCount=count;
            }
        });
       numberBt.setBuyMax(99).setCurrentNumber(1);
        moneTv.setText(mDataBean.getPrice());
        Picasso.with(this).load(mDataBean.getImg_list().get(0)).into(shopImg);


        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                ShopDetailVO.DataBean.SpecListBean.ValueBean vo = (ShopDetailVO.DataBean.SpecListBean.ValueBean) adapter.getData().get(position);
                if (TextUtils.isEmpty(vo.getSpec_value_name())) {
                    return 5;
                } else {
                    return 1;
                }
            }
        });

        colseIm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });
        okTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuffer sb = new StringBuffer();
                ComparatorObj comparator=new ComparatorObj();
                List<ShopDetailVO.DataBean.SpecListBean.ValueBean>list=new ArrayList<>();
                list.addAll(adapter.getData());
                Collections.sort(list, comparator);
                for (int i = 0; i < list.size(); i++) {
                    ShopDetailVO.DataBean.SpecListBean.ValueBean vo = (ShopDetailVO.DataBean.SpecListBean.ValueBean)list.get(i);
                    if ("1".equals(vo.getSelect())) {
                        sb.append(vo.getSpec_id()).append(":").append(vo.getSpec_value_id()).append(";");
                    }
                }

                String str = sb.toString().substring(0, sb.toString().length() - 1);
                for (int i = 0; i < mDataBean.getSku_list().size(); i++) {
                    if (str.equals(mDataBean.getSku_list().get(i).getAttr_value_items())) {
                        mShopTypeTv.setText(mDataBean.getSku_list().get(i).getSku_name());
                        mGoodName = mDataBean.getGoods_name();
                        mGoodsId = mDataBean.getSku_list().get(i).getGoods_id();
                        mGoodPrice = mDataBean.getSku_list().get(i).getPrice();
                        mShopType = mDataBean.getSku_list().get(i).getSku_id() + ":" + mDataBean.getSku_list().get(i).getSku_name();
                        break;
                    }
                }
                if("1".equals(mType)){
                    addCart();
                }else {
                    Bundle bundle =new Bundle();
                    bundle.putString("sku_list",mShopType.split(":")[0]+":"+mCount);
                    mActivity.open(OrderSureActivity.class,bundle,0);
                }

            }
        });
        mDialog.contentView(dialogView)
                .heightParam(ViewGroup.LayoutParams.WRAP_CONTENT)
                .inDuration(500)
                .cancelable(true)
                .show();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_cart_tv:
                if (AppApplication.getInstance().getUserInfoVO() == null) {
                    openActivity(LoginActivity.class);
                    return;
                }
                mType = "1";
                choseShop();
                break;
            case R.id.buy_tv:
                if (AppApplication.getInstance().getUserInfoVO() == null) {
                    openActivity(LoginActivity.class);
                    return;
                }
                mType = "2";
                choseShop();
                break;
            default:
                break;
        }
    }

    class ComparatorObj implements Comparator {

        public int compare(Object obj0, Object obj1) {
            ShopDetailVO.DataBean.SpecListBean.ValueBean value1 = (ShopDetailVO.DataBean.SpecListBean.ValueBean) obj0;
            ShopDetailVO.DataBean.SpecListBean.ValueBean value2 = (ShopDetailVO.DataBean.SpecListBean.ValueBean) obj1;

            //首先比较年龄，如果年龄相同，则比较名字

            return value1.getSpec_id().compareTo(value2.getSpec_id());
        }
    }

    public void addCart() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("goods_id", mGoodsId);
        map.put("goods_name", mGoodName);
        map.put("count", mCount);
        map.put("list", mShopType + ":" + mCount);
        map.put("price", mGoodPrice);
        HttpGetDataUtil.post(this, Constant.SHOP_ADD_CART_URL, map,this);
    }

    @Override
    public void success(BaseVO vo) {
        mDialog.dismiss();
            QBadgeView qbadgeView = (QBadgeView) new QBadgeView(mActivity).bindTarget(mCartLayout).setBadgeGravity(Gravity.END | Gravity
                .TOP).setShowShadow(true).setBadgeTextSize(10,true).setBadgeNumber(mCount);
    }
}
