package com.beisheng.snatch.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.MyMesssageAdapter;
import com.beisheng.snatch.adapter.MyScortAdapter;
import com.beisheng.snatch.adapter.ScortDetailAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.ScortDetailVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;

import java.util.HashMap;

public class MyScortActivity extends BaseActivity implements View.OnClickListener{
    private LuRecyclerView mRecyclerView;
    private MyScortAdapter mAdapter;
    private TextView mDetailTv;
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
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
        mDetailTv=getViewById(R.id.detial_tv);
    }

    @Override
    public void bindViewsListener() {
        mDetailTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", "10005");
        BSHttpUtils.post(mActivity, this, Constant.MY_SCORT_URL, map, ScortDetailVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {

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
            case R.id.detial_tv:
                openActivity(ScortDetailActivity.class);
                break;
            default:
                break;
        }
    }
}
