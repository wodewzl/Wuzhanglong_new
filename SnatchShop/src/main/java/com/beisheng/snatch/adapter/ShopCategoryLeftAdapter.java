package com.beisheng.snatch.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.ShopCategoryLeftVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;


/**
 * Created by ${Wuzhanglong} on 2017/5/16.
 */

public class ShopCategoryLeftAdapter extends RecyclerBaseAdapter {
    public ShopCategoryLeftAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.shop_category_left_adapter);
    }

    public interface OnLeftSelectedListener {
        void onLeftItemSelected(ShopCategoryLeftVO.DataBean.CategoryListBean leftVO);

        void moveToTop(View view, int position);
    }

    private ShopCategoryLeftVO.DataBean.CategoryListBean mSelectVO;
    public OnLeftSelectedListener listener;


    @Override
    public void initData(final BGAViewHolderHelper helper, final int position, Object model) {
        final ShopCategoryLeftVO.DataBean.CategoryListBean vo = (ShopCategoryLeftVO.DataBean.CategoryListBean) model;
        helper.setText(R.id.left_menu_textview, vo.getCategory_name());
        final FrameLayout leftMenu = (FrameLayout) helper.getConvertView();
        if (mSelectVO == null && position == 0) {
            mSelectVO = vo;
            vo.setSelect(true);
//            helper.setVisibility(R.id.left_view, View.VISIBLE);
//            leftMenu.setBackgroundColor(mContext.getResources().getColor(R.color.C3));
            helper.setBackgroundRes(R.id.left_menu_textview, R.drawable.corners_30_red);
            helper.setTextColorRes(R.id.left_menu_textview, R.color.C1);
        }

        if (vo.isSelect()) {
//            helper.setVisibility(R.id.left_view, View.VISIBLE);
//            helper.setBackgroundColorRes(R.id.left_menu_textview, R.color.C1);
//            helper.setTextColorRes(R.id.left_menu_textview, R.color.C4);
            helper.setBackgroundRes(R.id.left_menu_textview, R.drawable.corners_30_red);
            helper.setTextColorRes(R.id.left_menu_textview, R.color.C1);
        } else {
//            helper.setVisibility(R.id.left_view, View.GONE);
//            helper.setBackgroundColorRes(R.id.left_menu_textview, R.color.C3);
//            helper.setTextColorRes(R.id.left_menu_textview, R.color.C5);
            helper.setBackgroundColorRes(R.id.left_menu_textview, R.color.C1);
            helper.setTextColorRes(R.id.left_menu_textview, R.color.C5);
        }

        leftMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mSelectVO != null)
                    mSelectVO.setSelect(false);
                mSelectVO = vo;
                mSelectVO.setSelect(true);
                notifyDataSetChanged();
                listener.onLeftItemSelected(vo);
                listener.moveToTop(view, position);
            }
        });

    }

    public void setListener(OnLeftSelectedListener listener) {
        this.listener = listener;
    }

    public OnLeftSelectedListener getListener() {
        return listener;
    }

}
