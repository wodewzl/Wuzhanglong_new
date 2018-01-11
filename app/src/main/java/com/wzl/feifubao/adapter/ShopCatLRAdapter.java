package com.wzl.feifubao.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rey.material.widget.CheckBox;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.ShopCartActivity;
import com.wzl.feifubao.mode.ShopCatVO;
import com.wzl.feifubao.mode.ShopHomeVO;
import com.wzl.feifubao.view.NumberButton;

import java.util.List;

import cc.solart.turbo.BaseTurboAdapter;
import cc.solart.turbo.BaseViewHolder;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.pedant.SweetAlert.SweetAlertDialog;


//import ren.qinc.numberbutton.NumberButton;

/**
 * Created by Administrator on 2017/2/13.
 */

public class ShopCatLRAdapter extends RecyclerBaseAdapter<ShopCatVO> {
    private OnMoneyChageListener moneyChageListener;


    public interface OnMoneyChageListener {
        void moneyChage();

        void allCheck(boolean isCheck);

        void cartDelete();
    }

    public ShopCatLRAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.shop_cat_adapter_type2);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {

        final ShopCatVO dataBean = (ShopCatVO) model;
        int type = BaseCommonUtils.parseInt(dataBean.getType());
        if (type == 1) {
            helper.setText(R.id.name_tv, dataBean.getGoods_name());
            helper.setText(R.id.price_tv, dataBean.getPrice());
            NumberButton numberBt=helper.getView(R.id.number_bt);
            numberBt.setmOnTextChangeListener(new NumberButton.OnTextChangeListener() {
                @Override
                public void onTextChange(int count) {
                   ShopCartActivity activity = (ShopCartActivity) mActivity;
                    dataBean.setNum(count + "");
                   activity.addShopCart(dataBean.getCart_id(),count+"");
                    activity.countPrice();
                }
            });
            numberBt.setBuyMax(99).setCurrentNumber(BaseCommonUtils.parseInt(dataBean.getNum()));
            helper.getImageView(R.id.delete_img).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ShopCartActivity activity = (ShopCartActivity) mActivity;
                    activity.deleteShop(dataBean.getCart_id());
                    activity.countPrice();
                }
            });

            CheckBox checkBox=helper.getView(R.id.check_box);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    dataBean.setCheck(b);
                    ShopCartActivity activity = (ShopCartActivity) mActivity;
                    activity.deleteShop(dataBean.getCart_id());
                    activity.countPrice();
                }
            });

        } else if (type == 2) {

        } else if (type == 3) {
            helper.setText(R.id.type4_title_tv, dataBean.getGoods_name());
            helper.setText(R.id.type4_price_tv, "￥" + dataBean.getPrice());
            if (!TextUtils.isEmpty(dataBean.getPic_cover_small()))
                Picasso.with(mActivity).load(dataBean.getPic_cover_small()).into(helper.getImageView(R.id.type4_img));
        } else {

        }

    }

    @Override
    public int getItemViewType(int position) {
        if (this.getData().size() == 0) {
            return super.getItemViewType(position);
        }
        ShopCatVO catVO = (ShopCatVO) mData.get(position);
        int type = BaseCommonUtils.parseInt(catVO.getType());
        if (type == 1) {
            return R.layout.shop_cat_adapter_type2;
        } else if (type == 2) {
            return R.layout.shop_cat_adapter_type3;
        } else if (type == 3) {
            return R.layout.shop_cat_adapter_type4;
        } else {
            return R.layout.shop_cat_adapter_type5;
        }
    }
}
