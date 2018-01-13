package com.wzl.feifubao.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.ShopDetailVO;
import com.wzl.feifubao.mode.ShopVO;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class ShopChoseAdapter extends RecyclerBaseAdapter<ShopDetailVO.DataBean.SpecListBean.ValueBean> {
    public ShopChoseAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.shop_chose_adapter_type1);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        final ShopDetailVO.DataBean.SpecListBean.ValueBean vo= (ShopDetailVO.DataBean.SpecListBean.ValueBean) model;
        if(getItemViewType( position)==R.layout.shop_chose_adapter_type1){
            helper.setText(R.id.title_tv,vo.getSpec_name());
        }else{
            helper.setText(R.id.value_tv,vo.getSpec_value_name());
            if("1".equals(vo.getSelect())){
                helper.getTextView(R.id.value_tv).setBackgroundResource(R.drawable.frame_kong_yellow);
                helper.getTextView(R.id.value_tv).setTextColor(ContextCompat.getColor(mActivity,R.color.FUBColor6));
            }else {
                helper.getTextView(R.id.value_tv).setBackgroundResource(R.drawable.frame_kong_gray);
                helper.getTextView(R.id.value_tv).setTextColor(ContextCompat.getColor(mActivity,R.color.C5));
            }

            helper.getTextView(R.id.value_tv).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i <ShopChoseAdapter.this.getData().size() ; i++) {
                        ShopDetailVO.DataBean.SpecListBean.ValueBean valueBean = (ShopDetailVO.DataBean.SpecListBean.ValueBean) ShopChoseAdapter.this.getData().get(i);
                        if(valueBean.getSpec_id().equals(vo.getSpec_id())){
                            valueBean.setSelect("0");
                        }
                    }
                    vo.setSelect("1");
                    notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(this.getData().size()==0)
            return super.getItemViewType(position);
        ShopDetailVO.DataBean.SpecListBean.ValueBean valueBean= (ShopDetailVO.DataBean.SpecListBean.ValueBean) this.getData().get(position);
        if(TextUtils.isEmpty(valueBean.getSpec_value_name())){
            return R.layout.shop_chose_adapter_type1;
        }else {
            return R.layout.shop_chose_adapter_type2;
        }
    }
}
