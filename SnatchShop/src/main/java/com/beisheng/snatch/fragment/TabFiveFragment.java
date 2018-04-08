package com.beisheng.snatch.fragment;


import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.AddressActivity;
import com.beisheng.snatch.activity.BuyFlowActivity;
import com.beisheng.snatch.activity.HelpActivity;
import com.beisheng.snatch.activity.MyBuyRecordActivity;
import com.beisheng.snatch.activity.MyCollectActivity;
import com.beisheng.snatch.activity.MyFlowActivity;
import com.beisheng.snatch.activity.MyLuckyRecordActivity;
import com.beisheng.snatch.activity.MyMessageActivity;
import com.beisheng.snatch.activity.MyRedMoneyActivity;
import com.beisheng.snatch.activity.MyScortActivity;
import com.beisheng.snatch.activity.MyShowActivity;
import com.beisheng.snatch.activity.SettingActivity;
import com.beisheng.snatch.adapter.FindAdapter;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

public class TabFiveFragment extends BaseFragment implements View.OnClickListener {
    private ImageView mMessageImg, mSettingImg;
    private TextView mItem01Tv, mItem02Tv, mItem03Tv, mItem04Tv, mItem05Tv, mItem06Tv, mItem07Tv;
    private TextView mBuyFlowTv;
    private LinearLayout mMyFlowLayout, mMyRedMoneyLayout, mMyScortLayout;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_five_fragment);
    }

    @Override
    public void initView(View view) {
        mMessageImg = getViewById(R.id.msg_img);
        mSettingImg = getViewById(R.id.setting_img);
        mMyFlowLayout = getViewById(R.id.my_flow_layout);
        mMyRedMoneyLayout = getViewById(R.id.my_red_money_layout);
        mMyScortLayout = getViewById(R.id.my_red_scort_layout);
        mItem01Tv = getViewById(R.id.item_01_tv);
        mItem02Tv = getViewById(R.id.item_02_tv);
        mItem03Tv = getViewById(R.id.item_03_tv);
        mItem04Tv = getViewById(R.id.item_04_tv);
        mItem05Tv = getViewById(R.id.item_05_tv);
        mItem06Tv = getViewById(R.id.item_06_tv);
        mItem07Tv = getViewById(R.id.item_07_tv);
        mBuyFlowTv = getViewById(R.id.buy_flow_tv);
        mBuyFlowTv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 5, R.color.C1, R.color.color_black));
    }

    @Override
    public void bindViewsListener() {
        mMessageImg.setOnClickListener(this);
        mSettingImg.setOnClickListener(this);
        mMyFlowLayout.setOnClickListener(this);
        mMyRedMoneyLayout.setOnClickListener(this);
        mMyScortLayout.setOnClickListener(this);
        mItem01Tv.setOnClickListener(this);
        mItem02Tv.setOnClickListener(this);
        mItem03Tv.setOnClickListener(this);
        mItem04Tv.setOnClickListener(this);
        mItem05Tv.setOnClickListener(this);
        mItem06Tv.setOnClickListener(this);
        mItem07Tv.setOnClickListener(this);
        mBuyFlowTv.setOnClickListener(this);
    }


    @Override
    public void getData() {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("wuzhanglong", "牛逼");
//        map.put("jinrenzheng", "傻逼");
//        BSHttpUtils.post(mActivity, this, Constant.HOME_URL, map, HomeVO.class);
        showView();
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
            case R.id.msg_img:
                mActivity.openActivity(MyMessageActivity.class);
                break;
            case R.id.setting_img:
                mActivity.openActivity(SettingActivity.class);
                break;
            case R.id.my_flow_layout:
                mActivity.openActivity(MyFlowActivity.class);
                break;
            case R.id.my_red_money_layout:
                mActivity.openActivity(MyRedMoneyActivity.class);
                break;
            case R.id.my_red_scort_layout:
                mActivity.openActivity(MyScortActivity.class);
                break;
            case R.id.item_01_tv:
                mActivity.openActivity(MyBuyRecordActivity.class);
                break;
            case R.id.item_02_tv:
                mActivity.openActivity(MyLuckyRecordActivity.class);
                break;
            case R.id.item_03_tv:
                mActivity.openActivity(BuyFlowActivity.class);
                break;
            case R.id.item_04_tv:
                mActivity.openActivity(MyShowActivity.class);
                break;
            case R.id.item_05_tv:
                mActivity.openActivity(MyCollectActivity.class);
                break;
            case R.id.item_06_tv:
                mActivity.openActivity(AddressActivity.class);
                break;
            case R.id.item_07_tv:
                mActivity.openActivity(HelpActivity.class);
                break;
            case R.id.buy_flow_tv:
                mActivity.openActivity(BuyFlowActivity.class);
                break;
            default:
                break;
        }
    }
}
