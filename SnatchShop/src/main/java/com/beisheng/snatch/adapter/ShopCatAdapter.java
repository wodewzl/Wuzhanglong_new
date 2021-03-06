package com.beisheng.snatch.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.ShopCatVO;
import com.beisheng.snatch.view.NumberButton;
import com.rey.material.widget.CheckBox;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;


//import ren.qinc.numberbutton.NumberButton;

/**
 * Created by Administrator on 2017/2/13.
 */

public class ShopCatAdapter extends RecyclerBaseAdapter {
    private ShopCatListener shopCatListener;

    public ShopCatListener getShopCatListener() {
        return shopCatListener;
    }

    public void setShopCatListener(ShopCatListener shopCatListener) {
        this.shopCatListener = shopCatListener;
    }

    public interface ShopCatListener {
        void totalCount();
    }

    public ShopCatAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.shop_cat_adapter_type1);
    }

    @SuppressLint("ResourceType")
    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        final ShopCatVO.DataBean.ListBean dataBean = (ShopCatVO.DataBean.ListBean) model;

        if ("1".equals(dataBean.getIs_valid())) {
            if (!TextUtils.isEmpty(dataBean.getGoods_image()))
                Picasso.with(mActivity).load(dataBean.getGoods_image()).into(helper.getImageView(R.id.shop_img));
            helper.setText(R.id.name_tv, dataBean.getGoods_name());
            NumberButton numberBt = helper.getView(R.id.number_bt);
            numberBt.setmOnTextChangeListener(new NumberButton.OnTextChangeListener() {
                @Override
                public void onTextChange(int count) {
                    dataBean.setNum(count + "");
                    shopCatListener.totalCount();
                }
            });
            numberBt.setBuyMax(Integer.parseInt(dataBean.getMax_count())).setCurrentNumber(BaseCommonUtils.parseInt(dataBean.getNum()));
            CheckBox checkBox = helper.getView(R.id.check_box);
            checkBox.setChecked(dataBean.isCheck());
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    dataBean.setCheck(b);
                    shopCatListener.totalCount();
                }
            });
            final LinearLayout layout = helper.getView(R.id.menu_layout);
            if (dataBean.isLongClick()) {
                layout.setVisibility(View.VISIBLE);
            } else {
                layout.setVisibility(View.GONE);
            }
            helper.getTextView(R.id.collect_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 100, R.color.C1, R.color.C1));
            helper.getTextView(R.id.see_same_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 100, R.color.color_yellow, R.color.color_yellow));
            helper.getTextView(R.id.delete_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 100, R.color.colorAccent, R.color.colorAccent));
            helper.setItemChildClickListener(R.id.collect_tv);
            helper.setItemChildClickListener(R.id.see_same_tv);
            helper.setItemChildClickListener(R.id.delete_tv);


        } else if ("0".equals(dataBean.getIs_valid())) {
            if (!TextUtils.isEmpty(dataBean.getGoods_image()))
                Picasso.with(mActivity).load(dataBean.getGoods_image()).into(helper.getImageView(R.id.shop_img));
            helper.setText(R.id.name_tv, dataBean.getGoods_name());
            helper.getTextView(R.id.status_tv).setBackground(BaseCommonUtils.setBackgroundShap(mContext, 30, R.color.C6, R.color.C6));
            helper.setItemChildClickListener(R.id.delete_one_tv);
        } else if("1".equals(dataBean.getTitle())){
            BaseCommonUtils.setTextThree(mContext, helper.getTextView(R.id.title_tv), "失效宝贝", dataBean.getValidedCount() + "", "件", R.color.colorAccent, 1.3f);
            helper.setItemChildClickListener(R.id.clean_tv);
        }else {

        }
    }

    @Override
    public int getItemViewType(int position) {
        if (this.getData().size() == 0) {
            return super.getItemViewType(position);
        }
        ShopCatVO.DataBean.ListBean vo = (ShopCatVO.DataBean.ListBean) this.getItem(position);

        if ("1".equals(vo.getIs_valid())) {
            return R.layout.shop_cat_adapter_type1;
        } else if ("0".equals(vo.getIs_valid())) {
            return R.layout.shop_cat_adapter_type3;
        }else  if("1".equals(vo.getTitle())){
            return R.layout.shop_cat_adapter_type2;

        }
        else {
            return R.layout.shop_cat_adapter_type4;
        }

    }
}
