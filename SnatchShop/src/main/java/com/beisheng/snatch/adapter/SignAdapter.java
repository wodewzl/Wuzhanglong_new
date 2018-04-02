package com.beisheng.snatch.adapter;

import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.HomeVO;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;

import cn.bingoogolapple.baseadapter.BGAViewHolderHelper;

/**
 * Created by ${Wuzhanglong} on 2018/3/12.
 */

public class SignAdapter extends RecyclerBaseAdapter<HomeVO> {

    public SignAdapter(RecyclerView recyclerView) {
        super(recyclerView, R.layout.sign_adapter);
    }


    @Override
    public void initData(BGAViewHolderHelper helper, int position, Object model) {
//        CountdownView mCvCountdownView = (CountdownView)findViewById(R.id.cv_countdownViewTest1);
//        mCvCountdownView.start(995550000); // Millisecond
//        yuanjian.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }


    @Override
    public int getItemViewType(int position) {
        return R.layout.sign_adapter;
    }

    @Override
    public int getItemCount() {
        return 55;
    }
}
