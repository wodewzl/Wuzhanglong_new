package com.wzl.feifubao.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
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
import com.wzl.feifubao.mode.ShopCatVO;
import com.wzl.feifubao.mode.ShopHomeVO;

import java.util.List;

import cc.solart.turbo.BaseTurboAdapter;
import cc.solart.turbo.BaseViewHolder;
import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;
import cn.pedant.SweetAlert.SweetAlertDialog;


//import ren.qinc.numberbutton.NumberButton;

/**
 * Created by Administrator on 2017/2/13.
 */

public class ShopCatLRAdapter extends RecyclerBaseAdapter<ShopCatVO.DataBean> {
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
        ShopCatVO.DataBean dataBean= (ShopCatVO.DataBean) model;
        helper.setText(R.id.name_tv,dataBean.getGoods_name());
        helper.setText(R.id.price_tv,dataBean.getPrice());
    }
}
