package com.beisheng.snatch.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.MyScortAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.MyScortVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.vondear.rxtools.view.dialog.RxDialogSure;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;

import java.util.HashMap;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class MyScortActivity extends BaseActivity implements View.OnClickListener , BGAOnRVItemClickListener,PostCallback {
    private LuRecyclerView mRecyclerView;
    private MyScortAdapter mAdapter;
    private TextView mDetailTv, mScortTv, mDescTv, mTodayTv;
    private LinearLayout mRuleLayout;
    private MyScortVO mMyScortVO;

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
        mRuleLayout=getViewById(R.id.rule_layout);
    }

    @Override
    public void bindViewsListener() {
        mDetailTv.setOnClickListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mRuleLayout.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        BSHttpUtils.post(mActivity, this, Constant.MY_SCORT_URL, map, MyScortVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        mMyScortVO = (MyScortVO) vo;
        BaseCommonUtils.setTextTwoBefore(this, mScortTv, mMyScortVO.getData().getPoint(), "分", R.color.C4, 1.6f);
        mDescTv.setText(mMyScortVO.getData().getPoint_issue());
        BaseCommonUtils.setTextTwoBefore(this, mTodayTv, mMyScortVO.getData().getToday_point(), "分", R.color.colorAccent, 1.3f);
        mAdapter.updateData(mMyScortVO.getData().getCoupon_list());
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onClick(View v) {
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.today_tv:
                bundle.putString("title", "今日积分");
                open(DailyTaskActivity.class, bundle, 0);
                break;
            case R.id.rule_layout:
                StringBuffer sb=new StringBuffer();
                sb.append(mMyScortVO.getData().getPoint_way()).append("\n").append(mMyScortVO.getData().getExchange_rule());
//                bundle.putString("content", sb.toString());
//                open(DailyTaskActivity.class, bundle, 0);
                RxDialogSure dialogSure=new RxDialogSure(this);
                dialogSure.setContent(sb.toString());
                dialogSure.getTvContent().setTextColor(ContextCompat.getColor(this,R.color.C6));
                dialogSure.getIvLogo().setVisibility(View.GONE);
                dialogSure.getTvTitle().setTextSize(13);
                dialogSure.setTitle("积分获取与规则");
                dialogSure.getTvSure().setTextSize(13);
                dialogSure.show();
                break;
            default:
                break;
        }
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if(mAdapter.getData().size()==0)
            return;
        final MyScortVO.DataBean.CouponListBean bean= (MyScortVO.DataBean.CouponListBean) mAdapter.getItem(position);
        new SweetAlertDialog(mActivity, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("确定要用积分兑换红包码?")
                .setConfirmText("确定")
                .setCancelText("取消")

                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                        map.put("coupon_type_id", bean.getCoupon_type_id());
                        BSHttpUtils.postCallBack(mActivity,Constant.SORT_EXCHANGE_RED_URL, map, BaseVO.class, MyScortActivity.this);
                        sDialog.dismissWithAnimation();//直接消失
                    }
                })
                .show();
        }

    @Override
    public void success(BaseVO vo) {
        showSuccessToast(vo.getDesc());
        getData();
    }
}
