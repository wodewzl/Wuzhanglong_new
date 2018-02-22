package com.wzl.feifubao.adapter;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.LifeVO;

import java.util.List;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by wuzhanglong on 2018/1/23.
 */

public class RateQueryAdapter extends RecyclerBaseAdapter<List<String>> {
    public RateQueryAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.rate_query_adapter);
    }

    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
        List<String> list= (List<String>) model;
        switch (list.get(0)) {
            case "CNY":
                helper.setImageResource(R.id.type_img,R.drawable.rate_1);
                helper.setText(R.id.name_tv,list.get(0));
                helper.setText(R.id.old_tv1,list.get(1));
                helper.setText(R.id.old_tv2,"人民币￥");
                helper.setText(R.id.new_tv1,list.get(2));
                helper.setText(R.id.new_tv2,"人民币￥");
                break;
            case "USD":
                helper.setImageResource(R.id.type_img,R.drawable.rate_2);
                helper.setText(R.id.name_tv,list.get(0));
                helper.setText(R.id.old_tv1,list.get(1));
                helper.setText(R.id.old_tv2,"美元$");
                helper.setText(R.id.new_tv1,list.get(2));
                helper.setText(R.id.new_tv2,"美元$");
                break;
            case "HKD":
                helper.setImageResource(R.id.type_img,R.drawable.rate_4);
                helper.setText(R.id.name_tv,list.get(0));
                helper.setText(R.id.old_tv1,list.get(1));
                helper.setText(R.id.old_tv2,"港币HK$");
                helper.setText(R.id.new_tv1,list.get(2));
                helper.setText(R.id.new_tv2,"港币HK$");
                break;
            case "EUR":
                helper.setImageResource(R.id.type_img,R.drawable.rate_5);
                helper.setText(R.id.name_tv,list.get(0));
                helper.setText(R.id.old_tv1,list.get(1));
                helper.setText(R.id.old_tv2,"欧元€");
                helper.setText(R.id.new_tv1,list.get(2));
                helper.setText(R.id.new_tv2,"欧元€");
                break;
            case "JPY":
                helper.setImageResource(R.id.type_img,R.drawable.rate_3);
                helper.setText(R.id.name_tv,list.get(0));
                helper.setText(R.id.old_tv1,list.get(1));
                helper.setText(R.id.old_tv2,"日元￥");
                helper.setText(R.id.new_tv1,list.get(2));
                helper.setText(R.id.new_tv2,"日元￥");
                break;
            case "GBP":
                helper.setImageResource(R.id.type_img,R.drawable.rate_6);
                helper.setText(R.id.name_tv,list.get(0));
                helper.setText(R.id.old_tv1,list.get(1));
                helper.setText(R.id.old_tv2,"英镑￡");
                helper.setText(R.id.new_tv1,list.get(2));
                helper.setText(R.id.new_tv2,"英镑￡");
                break;
            default:
                break;
        }
    }


}
