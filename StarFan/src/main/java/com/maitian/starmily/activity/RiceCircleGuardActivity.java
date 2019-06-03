package com.maitian.starmily.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.HitListAdapter;
import com.maitian.starmily.adapter.RiceCircleGuardAdapter;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;

public class RiceCircleGuardActivity extends BaseActivity {
    private EditText mSearchEt;
    private ImageView mDeleteIv;
    private LuRecyclerView mRecyclerView;
    private RiceCircleGuardAdapter mAdapter;
    private LinearLayout mKeywordTitleLayout;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.rice_circle_guard_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("明显守护");
        mSearchEt = getViewById(R.id.search_et);
        mDeleteIv = getViewById(R.id.delete_iv);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new RiceCircleGuardAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_10, R.color.C3, true);
        mKeywordTitleLayout = getViewById(R.id.keyword_title_layout);
    }

    @Override
    public void bindViewsListener() {
        mSearchEt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!TextUtils.isEmpty(charSequence)) {
                    mDeleteIv.setVisibility(View.VISIBLE);
                } else {
                    mDeleteIv.setVisibility(View.GONE);
                    mKeywordTitleLayout.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void getData() {

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
}
