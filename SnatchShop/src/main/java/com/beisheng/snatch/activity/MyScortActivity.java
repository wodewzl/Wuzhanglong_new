package com.beisheng.snatch.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.MyScortAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.MyScortVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;

import java.util.HashMap;

public class MyScortActivity extends BaseActivity implements View.OnClickListener {
    private LuRecyclerView mRecyclerView;
    private MyScortAdapter mAdapter;
    private TextView mDetailTv, mScortTv, mDescTv, mTodayTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_scort_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("我的积分");
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new MyScortAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadMoreEnabled(false);
        mDetailTv = getViewById(R.id.today_tv);
        mScortTv=getViewById(R.id.scort_tv);
        mDescTv=getViewById(R.id.desc_tv);
        mTodayTv=getViewById(R.id.today_tv);
    }

    @Override
    public void bindViewsListener() {
        mDetailTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", "10005");
        BSHttpUtils.post(mActivity, this, Constant.MY_SCORT_URL, map, MyScortVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        MyScortVO bean = (MyScortVO) vo;
        BaseCommonUtils.setTextTwoBefore(this, mScortTv, bean.getData().getPoint(), "分", R.color.C4, 1.6f);
        mDescTv.setText(bean.getData().getPoint_issue());
        BaseCommonUtils.setTextTwoBefore(this, mTodayTv, bean.getData().getToday_point(), "分", R.color.colorAccent, 1.3f);
        mAdapter.updateData(bean.getData().getCoupon_list());
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.today_tv:
                Bundle bundle = new Bundle();
                bundle.putString("title", "今日积分");
                open(DailyTaskActivity.class, bundle, 0);
                break;
            default:
                break;
        }
    }
}
