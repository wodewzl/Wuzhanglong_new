package com.beisheng.snatch.activity;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.SignAdapter;
import com.beisheng.snatch.adapter.SignDayAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.SignVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.suke.widget.SwitchButton;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.RecyclerViewUtil;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;

public class SignActivity extends BaseActivity implements View.OnClickListener, PostCallback, SwitchButton.OnCheckedChangeListener,BGAOnItemChildClickListener {
    private LuRecyclerView mRecyclerView;
    private SignAdapter mAdapter;
    private SignVO.DataBean mDataBean;
    private TextView mPointTv, mSignStatusTv;
    private SwitchButton mSwitchButton;
    private ImageView mGiftImg;
    private SignDayAdapter mSignDayAdapter;



    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.sign_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("签到有礼");
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity, 2));
        mAdapter = new SignAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        adapter.addHeaderView(initHeadView());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(false);

    }

    public View initHeadView() {
        View header = View.inflate(mActivity, R.layout.sign_head_layout, null);
        LuRecyclerView dayRecyclerView = header.findViewById(R.id.day_recycler_view);
        mSignDayAdapter = new SignDayAdapter(dayRecyclerView);
        RecyclerViewUtil.initRecyclerViewGridLayoutManager(mActivity, dayRecyclerView, mSignDayAdapter, 7, R.dimen.dp_0, R.color.C3, false);

        mPointTv = header.findViewById(R.id.my_point_tv);
        mSignStatusTv = header.findViewById(R.id.sign_status_tv);
        mSignStatusTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.color_green, R.color.color_green));
        mSignStatusTv.setTextColor(ContextCompat.getColor(this, R.color.C1));
        mSwitchButton = header.findViewById(R.id.switch_button);
        mGiftImg = header.findViewById(R.id.gift_img);
        return header;
    }

    @Override
    public void bindViewsListener() {
        mSignStatusTv.setOnClickListener(this);
        mSwitchButton.setOnCheckedChangeListener(this);
        mGiftImg.setOnClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        BSHttpUtils.post(mActivity, this, Constant.SIGN_DATA_URL, map, SignVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        SignVO signVO = (SignVO) vo;
        mDataBean = signVO.getData();
        mPointTv.setText(mDataBean.getPoint());
        if("1".equals(mDataBean.getIs_signin())){
            mSignStatusTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.snatch_01, R.color.snatch_01));
            mSignStatusTv.setTextColor(ContextCompat.getColor(this, R.color.C5));
            mSignStatusTv.setText("已签到");
        }else {
            mSignStatusTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.color_green, R.color.color_green));
            mSignStatusTv.setTextColor(ContextCompat.getColor(this, R.color.C1));
            mSignStatusTv.setText("签到");
        }

        List<SignVO.DataBean.ExchangeListBean> list = mDataBean.getExchange_list();
        mAdapter.updateData(list);
        mSignDayAdapter.setStatus(mDataBean.getContinuous_days());
        List<String> dayList=mDataBean.getSevenday_points_array();
        mSignDayAdapter.updateData(dayList);


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
            case R.id.sign_status_tv:
                HashMap<String, Object> map = new HashMap<>();
                map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                BSHttpUtils.postCallBack(mActivity, Constant.SIGN_URL, map, BaseVO.class, this);
                mSignStatusTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.snatch_01, R.color.snatch_01));
                mSignStatusTv.setTextColor(ContextCompat.getColor(this, R.color.C5));
                mSignStatusTv.setText("已签到");
                break;
            case R.id.gift_img:
                HashMap<String, Object> giftMap = new HashMap<>();
                giftMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                BSHttpUtils.postCallBack(mActivity, Constant.SIGN_GIFT_URL, giftMap, BaseVO.class, this);
                break;

            default:
                break;
        }
    }

    @Override
    public void success(BaseVO vo) {
        showSuccessToast(vo.getDesc());
        getData();
    }

    @Override
    public void onCheckedChanged(SwitchButton v, boolean isChecked) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        map.put("is_notify", isChecked ? "0" : "1");
        BSHttpUtils.postCallBack(mActivity, Constant.SIGN_NOTIFY_URL, map, BaseVO.class, this);
    }

    @Override
    public void onItemChildClick(ViewGroup parent, View childView, int position) {

    }
}
