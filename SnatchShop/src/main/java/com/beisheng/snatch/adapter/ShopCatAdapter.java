package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.CompoundButton;

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

public class ShopCatAdapter extends RecyclerBaseAdapter<ShopCatVO> {
    private OnMoneyChageListener moneyChageListener;


    public interface OnMoneyChageListener {
        void moneyChage();

        void allCheck(boolean isCheck);

        void cartDelete();
    }

    public ShopCatAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.shop_cat_adapter_type2);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {

        final ShopCatVO dataBean = (ShopCatVO) model;
        int type = BaseCommonUtils.parseInt(dataBean.getType());
        if (type == 1) {
            if (!TextUtils.isEmpty(dataBean.getPicture()))
                Picasso.with(mActivity).load(dataBean.getPicture()).into(helper.getImageView(R.id.shop_img));
            helper.setText(R.id.name_tv, dataBean.getGoods_name());
            helper.setText(R.id.price_tv, dataBean.getPrice());
            NumberButton numberBt = helper.getView(R.id.number_bt);
            numberBt.setmOnTextChangeListener(new NumberButton.OnTextChangeListener() {
                @Override
                public void onTextChange(int count) {
//                    ShopCartActivity activity = (ShopCartActivity) mActivity;
//                    dataBean.setNum(count + "");
//                    activity.addShopCart(dataBean.getCart_id(), count + "");
//                    activity.countPrice();
                }
            });
            numberBt.setBuyMax(99).setCurrentNumber(BaseCommonUtils.parseInt(dataBean.getNum()));


            CheckBox checkBox = helper.getView(R.id.check_box);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    dataBean.setCheck(b);
//                    ShopCartActivity activity = (ShopCartActivity) mActivity;
//                    activity.countPrice();
                }
            });

        }

    }

    @Override
    public int getItemViewType(int position) {
//        if (this.getData().size() == 0) {
//            return super.getItemViewType(position);
//        }
//        ShopCatVO catVO = (ShopCatVO) mData.get(position);
//        int type = BaseCommonUtils.parseInt(catVO.getType());
        return R.layout.shop_cat_adapter_type2;
    }

    @Override
    public int getItemCount() {
        return 55;
    }
}
