package com.wzl.feifubao.adapter;

import android.content.Context;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.ShopHomeVO;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.text.DecimalFormat;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

;


/**
 * Created by Administrator on 2017/2/13.
 */

public class ShopHomeAdapter extends RecyclerBaseAdapter<ShopHomeVO> {
    private String signUrl;

    public ShopHomeAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.home_adapter_type7);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        ShopHomeVO vo = (ShopHomeVO) model;
        switch (vo.getType()) {
            case "1":
                Banner banner = helper.getView(R.id.banner);

                banner.setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object o, ImageView imageView) {
                        final ShopHomeVO bannerVO = (ShopHomeVO) o;
                        Picasso.with(context).load(bannerVO.getAdv_image()).into(imageView);
                    }
                });

                banner.setImages(vo.getData().getAdvs());
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                banner.setIndicatorGravity(BannerConfig.CENTER);
                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int i) {

                    }
                });
                banner.start();

                break;
            case "2":
                helper.setText(R.id.type2_title_tv, vo.getData().getArticles().get(0).getTitle());
                break;
            case "3":
                break;
            case "4":
                RecyclerView recyclerView = helper.getView(R.id.typ4_recycler_view);

                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mActivity);
                linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView.setLayoutManager(linearLayoutManager);
                ShopHomeHorizontalAdapter adapter = new ShopHomeHorizontalAdapter(recyclerView);
                recyclerView.setAdapter(adapter);

                for (int i = 0; i <vo.getTehui().size() ; i++) {
                    vo.getTehui().get(i).setType("4");
                }
                adapter.updateData(vo.getTehui());
//                if (!TextUtils.isEmpty(vo.getPic_cover_small()))
//                    Picasso.with(mActivity).load(vo.getPic_cover_small()).into(helper.getImageView(R.id.type4_img));
//                helper.setText(R.id.type4_title_tv, vo.getGoods_name());
//                helper.setText(R.id.type4_money_tv, "￥" + vo.getPrice());
                break;
            case "5":
                System.out.println("ddddddddddddddd");
                break;
            case "6":
                RecyclerView recyclerView6 = helper.getView(R.id.typ6_recycler_view);

                LinearLayoutManager linearLayoutManager6 = new LinearLayoutManager(mActivity);
                linearLayoutManager6.setOrientation(LinearLayoutManager.HORIZONTAL);
                recyclerView6.setLayoutManager(linearLayoutManager6);
                ShopHomeHorizontalAdapter adapter6 = new ShopHomeHorizontalAdapter(recyclerView6);
                recyclerView6.setAdapter(adapter6);

                for (int i = 0; i <vo.getXianshi().size() ; i++) {
                    vo.getXianshi().get(i).setType("6");
                }
                adapter6.updateData(vo.getXianshi());

//                if (!TextUtils.isEmpty(vo.getPic_cover_small()))
//                    Picasso.with(mActivity).load(vo.getPic_cover_small()).into(helper.getImageView(R.id.type6_img));
//                helper.setText(R.id.type6_title_tv, vo.getGoods_name());
//                DecimalFormat df = new DecimalFormat("#.0");
//                if (!TextUtils.isEmpty(vo.getPrice()))
//                    helper.setText(R.id.type6_money_tv, "￥" + df.format(Double.parseDouble(vo.getPromotion_price())));
//                TextView yuanjian = helper.getTextView(R.id.type6_yuanjian_tv);
//                yuanjian.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
//                yuanjian.setText("￥" + df.format(Double.parseDouble(vo.getPrice())));
                break;
            case "7":
                if (!TextUtils.isEmpty(vo.getAdv_image()))
                    Picasso.with(mActivity).load(vo.getAdv_image()).into(helper.getImageView(R.id.type7_img));
                break;
            case "8":
                break;
            case "9":
                if (!TextUtils.isEmpty(vo.getPic_cover_small()))
                    Picasso.with(mActivity).load(vo.getPic_cover_small()).into(helper.getImageView(R.id.type9_img));
                helper.setText(R.id.type9_title_tv, vo.getGoods_name());
                helper.setText(R.id.type9_desc_tv, vo.getDescription());
                DecimalFormat dfx = new DecimalFormat("#.0");
                helper.setText(R.id.type9_money_tv, "￥" + dfx.format(Double.parseDouble(vo.getPromotion_price())));
                TextView type9yuanjian = helper.getTextView(R.id.type9_yuanjian_tv);
                type9yuanjian.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);

                type9yuanjian.setText("￥" + dfx.format(Double.parseDouble(vo.getPrice())));
                break;
            default:
                break;
        }
    }


    @Override
    public int getItemViewType(int position) {
        if(this.getData().size()==0){
            return  super.getItemViewType(position);
        }
        ShopHomeVO shopHomeVO = (ShopHomeVO) mData.get(position);
        int type = BaseCommonUtils.parseInt(shopHomeVO.getType());
        return getViewByType(type);
    }

    public int getViewByType(int type) {
        int viewType = 0;
        switch (type) {
            case 1:
                viewType = R.layout.shop_home_adapter_type1;
                break;
            case 2:
                viewType = R.layout.shop_home_adapter_type2;
                break;
            case 3:
                viewType = R.layout.shop_home_adapter_type3;
                break;
            case 4:
                viewType = R.layout.shop_home_adapter_type4;
                break;
            case 5:
                viewType = R.layout.shop_home_adapter_type5;
                break;
            case 6:
                viewType = R.layout.shop_home_adapter_type6;
                break;
            case 7:
                viewType = R.layout.shop_home_adapter_type7;
                break;
            case 8:
                viewType = R.layout.shop_home_adapter_type8;
                break;
            case 9:
                viewType = R.layout.shop_home_adapter_type9;
                break;
            default:
                break;
        }
        return viewType;
    }
}
