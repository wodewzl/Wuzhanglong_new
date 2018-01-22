package com.wzl.feifubao.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;


import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.HouseOptionVO;
import com.yang.flowlayoutlibrary.FlowLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class KeyWrodActivity extends BaseActivity {
    private FlowLayout mFlowLayout;
    private EditText mSearchEt;
    private String mKeyword = "";

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.key_wrod_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("关键字");
        mFlowLayout = (FlowLayout) findViewById(R.id.fl_keyword);
        mSearchEt = getViewById(R.id.search_et);
        mSearchEt.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        mSearchEt.setInputType(EditorInfo.TYPE_CLASS_TEXT);
    }

    @Override
    public void bindViewsListener() {
        mSearchEt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                mKeyword = textView.getText().toString();
//                Bundle bundle = new Bundle();
//                bundle.putString("keyword", mKeyword);
//                open(YellowPagesActivity.class, bundle, 0);
                EBMessageVO ebMessageVO=   new EBMessageVO("keyword");
                ebMessageVO.setMsg(mKeyword);
                EventBus.getDefault().post(ebMessageVO);
                KeyWrodActivity.this.finish();
                return false;
            }
        });

    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        HttpGetDataUtil.get(mActivity, this, Constant.HOUSE_LIST_OPTION_URL, map, HouseOptionVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        HouseOptionVO houseOptionVO = (HouseOptionVO) vo;
        mFlowLayout.setFlowLayout((List<String>) houseOptionVO.getData().getYellowPagesClass(), new FlowLayout.OnItemClickListener() {
            @Override
            public void onItemClick(String content) {
                mKeyword = content;
//                Bundle bundle = new Bundle();
//                bundle.putString("keyword", mKeyword);
//                open(YellowPagesActivity.class, bundle, 0);
             EBMessageVO ebMessageVO=   new EBMessageVO("keyword");
                ebMessageVO.setMsg(mKeyword);
                EventBus.getDefault().post(ebMessageVO);
                KeyWrodActivity.this.finish();
            }
        });
    }
    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }


}
