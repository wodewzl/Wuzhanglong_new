package com.wzl.feifubao.adapter;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.SharePreferenceUtil;;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.HomeVO;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import org.greenrobot.eventbus.EventBus;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;


/**
 * Created by Administrator on 2017/2/13.
 */

public class HomeRAdapter extends RecyclerBaseAdapter<HomeVO> {
    private String signUrl;

    public HomeRAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.home_adapter_type1);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        final HomeVO homeVO = (HomeVO) model;
        switch (getItemViewType(position)) {
            case R.layout.home_adapter_type2:
                Banner banner = helper.getView(R.id.banner);

                banner.setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object o, ImageView imageView) {
                        final HomeVO bannerVO = (HomeVO) o;
//                        Picasso.with(context).load(bannerVO.getImage()).into(imageView);
                    }
                });

//                banner.setImages(homeVO.getItem_data().getItem());
                banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
                banner.setBannerAnimation(Transformer.CubeIn);
                banner.setIndicatorGravity(BannerConfig.CENTER);

                banner.setOnBannerListener(new OnBannerListener() {
                    @Override
                    public void OnBannerClick(int i) {
                        final HomeVO bannerVO;
                    }
                });
                banner.start();


                break;
            case R.layout.home_adapter_type1:
                helper.setItemChildClickListener(R.id.type_01_tv);
                helper.setItemChildClickListener(R.id.type_02_tv);
                helper.setItemChildClickListener(R.id.type_03_tv);
                helper.setItemChildClickListener(R.id.type_04_tv);
                helper.setItemChildClickListener(R.id.type_05_tv);
                helper.setItemChildClickListener(R.id.type_06_tv);
                helper.setItemChildClickListener(R.id.type_07_tv);
                helper.setItemChildClickListener(R.id.type_08_tv);

              if("0".equals(SharePreferenceUtil.getSharedpreferenceValue(mActivity, "game_tag", "tag"))){
                  helper.getTextView(R.id.type_04_tv).setVisibility(View.INVISIBLE);
              }else{
                  helper.getTextView(R.id.type_04_tv).setVisibility(View.VISIBLE);
              }
//                helper.getTextView(R.id.type_04_tv).setVisibility(View.INVISIBLE);

            default:
                break;
        }

        helper.setOnItemChildClickListener(new BGAOnItemChildClickListener() {
            @Override
            public void onItemChildClick(ViewGroup viewGroup, View v, int i) {
                Bundle bundle = new Bundle();
                switch (v.getId()) {
                    case R.id.type_01_tv:

                        break;
                    case R.id.type_02_tv:

                        break;
                    case R.id.type_03_tv:

                        break;
                    case R.id.type_04_tv:

                        break;
                    case R.id.type_05_tv:
                        break;
                    case R.id.type_06_tv:
                 ;
                        break;
                    case R.id.type_07_tv:

                        break;
                    case R.id.type_08_tv:

                        break;
                    default:
                        break;
                }
            }
        });

    }



    @Override
    public int getItemViewType(int position) {
        HomeVO homeVO = (HomeVO) mData.get(position);
//        int type = BaseCommonUtils.parseInt(homeVO.getType());
        return getViewByType(0);
    }

    public int getViewByType(int type) {
        int viewType = 0;
//        switch (type) {
//            case 1:
//                viewType = R.layout.home_adapter_type0;
//                break;
//            case 2:
//                viewType = R.layout.home_adapter_type3;
//                break;
//            case 3:
//                viewType = R.layout.home_adapter_type2;
//                break;
//            case 4:
//                viewType = R.layout.home_adapter_type4;
//                break;
//            case 5:
//                viewType = R.layout.home_adapter_type7;
//                break;
//            case 6:
//                viewType = R.layout.home_adapter_type1;
//                break;
//            case 7:
//                viewType = R.layout.home_adapter_type5;
//                break;
//            default:
//                break;
//        }
        return viewType;
    }

    public String getSignUrl() {
        return signUrl;
    }

    public void setSignUrl(String signUrl) {
        this.signUrl = signUrl;
    }
}
