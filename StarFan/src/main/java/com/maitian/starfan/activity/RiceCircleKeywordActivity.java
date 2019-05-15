package com.maitian.starfan.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maitian.starfan.R;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.List;

public class RiceCircleKeywordActivity extends BaseActivity implements TextView.OnEditorActionListener, View.OnClickListener, TagFlowLayout.OnTagClickListener {
    private TagFlowLayout mHistoryFlowLayout, mHotFlowLayout;
    private String mKeyword = "";
    private EditText mSearchEt;
    private List<String> mHistoryKeyword = new ArrayList<>();
    private List<String> mHotKeyword = new ArrayList<>();
    private LinearLayout mHistoryLayout;
    private TextView mDeleteTv;
    private TextView mBackTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.rice_circle_keyword_activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    @Override
    public void initView() {
        mBaseHeadLayout.setVisibility(View.GONE);
        mHistoryFlowLayout = getViewById(R.id.history_flowlayout);
        mHotFlowLayout = getViewById(R.id.hot_flowlayout);
        mSearchEt = getViewById(R.id.search_et);
        mSearchEt.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        mSearchEt.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        mBackTv = getViewById(R.id.back_iv);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }


    @Override
    public void bindViewsListener() {
        mSearchEt.setOnEditorActionListener(this);
        mDeleteTv.setOnClickListener(this);
        mHistoryFlowLayout.setOnTagClickListener(this);
        mHotFlowLayout.setOnTagClickListener(this);
        mBackTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
//        HashMap<String, Object> map = new HashMap<>();
//        BSHttpUtils.post(mActivity, this, Constant.KEYWORD_URL, map, KeywordVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
//        KeywordVO keywordVO = (KeywordVO) vo;
//        mHotKeyword = keywordVO.getData().getKeywords_list();
//        mHotFlowLayout.setAdapter(new TagAdapter<String>(mHotKeyword) {
//@Override
//public View getView(FlowLayout parent, int position, String s) {
//        TextView tv = new TextView(KeywordActivity.this);
//        tv.setPadding(30, 10, 30, 10);
//        tv.setBackground(BaseCommonUtils.setBackgroundShap(KeywordActivity.this, 15, R.color.C3, R.color.C3));
//        tv.setTextColor(ContextCompat.getColor(KeywordActivity.this,R.color.C5));
//        tv.setText(s);
//        return tv;
//        }
//        });
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//        mKeyword = textView.getText().toString();
//        if (!"".equals(mKeyword)) {
//        if (!mHistoryKeyword.contains(mKeyword))
//        mHistoryKeyword.add(mKeyword);
//        KeywordVO dataBean = new KeywordVO();
//        dataBean.setKeywords_history(mHistoryKeyword);
//        Gson gson = new Gson();
//        ACache.get(KeywordActivity.this).put("history_keyword", new Gson().toJson(dataBean));
//
//        startSearchActivity();
//        }
        return false;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_iv:
                this.finish();
                break;
            default:
                break;
        }

    }

    @Override
    public boolean onTagClick(View view, int position, FlowLayout parent) {
        if (parent.getId() == R.id.history_flowlayout) {
            mKeyword = mHistoryKeyword.get(position);
        } else {
            mKeyword = mHotKeyword.get(position);
        }
        mSearchEt.setText(mKeyword);
        startSearchActivity();
        return true;
    }

    public void startSearchActivity() {
        Bundle bundle = new Bundle();
        bundle.putString("keyword", mKeyword);
//        open(SearchShopActivity.class,bundle,0);
    }
}
