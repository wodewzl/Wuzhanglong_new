package com.wzl.feifubao.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.google.gson.Gson;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.Button;
import com.rey.material.widget.CheckBox;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.PayResult;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.utils.PayUtis;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.MessageAdapter;
import com.wzl.feifubao.adapter.MyHouseAdapter;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.HouseAddVO;
import com.wzl.feifubao.mode.HouseListVO;
import com.wzl.feifubao.mode.JobOffersVO;
import com.wzl.feifubao.mode.LifeVO;
import com.wzl.feifubao.mode.MyHouseVO;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;
import retrofit2.http.POST;

public class MyHouseActivity extends BaseActivity implements BGAOnRVItemClickListener, OnLoadMoreListener,
        SwipeRefreshLayout.OnRefreshListener, PostCallback {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private MyHouseAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private BottomSheetDialog mDialog;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_my_house);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("我的房源");

        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_10, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new MyHouseAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", mCurrentPage + "");
        map.put("pagesize", "10");
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        HttpGetDataUtil.get(mActivity, this, Constant.MY_HOUSE_LIST_URL, map, MyHouseVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        MyHouseVO myHouseVO = (MyHouseVO) vo;

        if (BaseCommonUtils.parseInt(myHouseVO.getData().getPage_count()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(myHouseVO.getData().getPage_count())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }

        List<MyHouseVO.DataBean.HouseBean> list = myHouseVO.getData().getHouse();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
            mCurrentPage++;
        } else {
            mCurrentPage++;
            mAdapter.updateData(list);
        }
        mAutoSwipeRefreshLayout.setRefreshing(false);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        getData();
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        Bundle bundle = new Bundle();
        HouseListVO.DataBean.HouseBean bean = (HouseListVO.DataBean.HouseBean) mAdapter.getData().get(position);
        bundle.putString("id", bean.getHouse_id());
        open(HouseDetailActivity.class, bundle, 0);


    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }


    @Override
    public void success(BaseVO vo) {
        showCustomToast("删除成功");
        mAutoSwipeRefreshLayout.autoRefresh();
    }

    public void showPayDialog(final MyHouseVO.DataBean.HouseBean vo) {
        mDialog = new BottomSheetDialog(mActivity);
        View dialogView = View.inflate(mActivity, R.layout.pay_view, null);
        final CheckBox payCb1 = (CheckBox) dialogView.findViewById(R.id.pay_cb_1);
        final CheckBox payCb2 = (CheckBox) dialogView.findViewById(R.id.pay_cb_2);
        Button payButton = (Button) dialogView.findViewById(R.id.commit_bt);
        payButton.setBackgroundDrawable(BaseCommonUtils.setBackgroundShap(mActivity, 5, R.color.colorAccent, R.color.colorAccent));
        LinearLayout payLayout01 = (LinearLayout) dialogView.findViewById(R.id.pay_layout_01);
        LinearLayout payLayout02 = (LinearLayout) dialogView.findViewById(R.id.pay_layout_02);


        mDialog.contentView(dialogView)
                .heightParam(ViewGroup.LayoutParams.WRAP_CONTENT)
                .inDuration(500)
                .cancelable(true)
                .show();

        payCb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    payCb2.setChecked(false);
                }
            }
        });
        payCb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    payCb1.setChecked(false);
                }
            }
        });

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String payType = "";
                if (payCb1.isChecked()) {
                    payType = "2";
                } else if (payCb2.isChecked()) {
                    payType = "1";
                }

                commit(vo.getOut_trade_no(), payType, vo.getPay_rmb());
            }
        });
    }

    public void commit(String orderNo, final String payType, String payMoney) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("out_trade_no", orderNo);
        map.put("pay_type", payType);
//        map.put("payment", money);
        map.put("payment", payMoney);

        new Novate.Builder(mActivity)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build().rxPost(Constant.SURE_ORDER2_URL, map, new RxStringCallback() {


            @Override
            public void onError(Object o, Throwable throwable) {

                System.out.println("=============");
            }

            @Override
            public void onCancel(Object o, Throwable throwable) {

                System.out.println("=============");
            }

            @Override
            public void onNext(Object o, String s) {
                try {
                    JSONObject jsonObject = new JSONObject(s);
                    int code = (int) jsonObject.get("code");
                    if (code == 200) {
                        if ("1".equals(payType)) {
                            Gson gson = new Gson();
                            final PayResult vo = gson.fromJson(s, PayResult.class);
                            PayUtis.weiXinPay(mActivity, vo.getData());
                        } else {
                            String payInfo = (String) jsonObject.get("data");
                            PayUtis.zhiFuBaoPay(mActivity, payInfo, new PayCallback() {
                                @Override
                                public void payResult(int type) {
                                    ;
                                    if (type == 1) {
                                        mActivity.openActivity(MyHouseActivity.class);
                                    } else {
                                        mActivity.showCustomToast("支付失败");
                                    }
                                }
                            });
                        }

                    } else {

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        });
    }

    public void editHouse(final MyHouseVO.DataBean.HouseBean bean) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("bean", bean);
        bundle.putString("type", "2");
        open(HouseAddActivity.class, bundle, 0);
    }
}
