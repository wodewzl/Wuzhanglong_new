package com.wzl.feifubao.fragment;

import android.os.Bundle;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.alipay.android.phone.mrpc.core.ThreadUtil;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.google.gson.Gson;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.Button;
import com.rey.material.widget.CheckBox;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.mode.PayResult;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DateUtils;
import com.wuzhanglong.library.utils.PayUtis;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wuzhanglong.library.view.PinnedHeaderDecoration;
import com.wzl.feifubao.R;
import com.wzl.feifubao.activity.OrderSureActivity;
import com.wzl.feifubao.adapter.OrderRAdapter;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.LifeVO;
import com.wzl.feifubao.mode.OrderVO;
import com.wzl.feifubao.mode.ShopVO;
import com.wzl.feifubao.mode.UserInfoVO;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;


public class OrderFragment extends BaseFragment implements OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, OrderRAdapter.onTypeClickListener, BGAOnRVItemClickListener,PostCallback {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private OrderRAdapter mAdapter;
    private int state;//0全部 1待付款 2待发货 3待收货 4待评价
    private OrderVO mOrderVO;
    private int mCurrentPage = 1;
    private boolean isLoadMore = false;
    private String mType = "0";//type 0 初始请求数据 1 取消订单 2 if_payment 3 if_receive 4 if_deliver 5 if_delete
    private OrderVO mPayVO;
    private BottomSheetDialog mDialog;

    public static BaseFragment newInstance() {
        BaseFragment fragment = new OrderFragment();
        return fragment;
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("page", mCurrentPage+"");
        map.put("pagesize", "10");
        map.put("status",this.getState()+"" );
        HttpGetDataUtil.get(mActivity, this, Constant.MY_ORDER_URL, map, OrderVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        mActivity.dismissProgressDialog();
        OrderVO orderVO = (OrderVO) vo;
        mOrderVO = orderVO.getData();

        if (BaseCommonUtils.parseInt(mOrderVO.getPage_count()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(mOrderVO.getPage_count())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }

        mAdapter.notifyDataSetChanged();
        List<OrderVO> list = mOrderVO.getOrder_list();
        List<OrderVO> listBean = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            OrderVO top=new OrderVO();
            top.setOrder_no(list.get(i).getOrder_no());
            top.setCreate_time(list.get(i).getCreate_time());
            top.setType("1");
            listBean.add(top);
            for (int j = 0; j < list.get(i).getOrder_item_list().size(); j++) {
                OrderVO shopOrder=list.get(i).getOrder_item_list().get(j);
                shopOrder.setOrder_status(list.get(i).getOrder_status());
                shopOrder.setOrder_id(list.get(i).getOrder_id());
                listBean.add(shopOrder);
            }
            OrderVO bottom=list.get(i);
            bottom.setType("3");
            listBean.add(bottom);
        }
        if (isLoadMore) {
            mAdapter.updateDataLast(listBean);
            isLoadMore = false;
            mCurrentPage++;
        } else {
            mCurrentPage++;
            mAdapter.updateData(listBean);
        }
        mAutoSwipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void noData(BaseVO vo) {
        mAutoSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void noNet() {
        mAutoSwipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.order_fragment);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        final PinnedHeaderDecoration decoration = new PinnedHeaderDecoration();
        decoration.registerTypePinnedHeader(R.layout.order_adapter_type1, new PinnedHeaderDecoration.PinnedHeaderCreator() {
            @Override
            public boolean create(RecyclerView parent, int adapterPosition) {
                return true;
            }
        });
        mRecyclerView.addItemDecoration(decoration);
        mAdapter = new OrderRAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadMoreEnabled(true);
    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnTypeClickListener(this);
        mAdapter.setOnRVItemClickListener(this);
        EventBus.getDefault().register(this);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getOrderState(int type) {
        String orderType = "";
        switch (type) {
            case 1:
                orderType = "state_new";
                break;
            case 2:
                orderType = "state_pay";
                break;
            case 3:
                orderType = "state_send";
                break;
            case 4:
                orderType = "state_noeval";
                break;
            default:
                break;
        }
        return orderType;
    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        getData();
    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }
    @Override
    public void typeClick(String type, final OrderVO vo) {
        String orderId = vo.getOrder_id();
        String url = "";
        switch (BaseCommonUtils.parseInt(type)) {
            case 1:
                url = Constant.ORDER_CANCEL_URL;
                commitData(orderId, url);
                break;
            case 2:
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

                        commit(vo.getOut_trade_no(), payType);
                    }
                });
                break;
            case 3:
                url = Constant.SHOP_RECIVER_URL;
                commitData(orderId, url);
                break;
            case 4:
//                Bundle bundle = new Bundle();
//                bundle.putString("order_id", orderId);
//                mActivity.open(DeliverActivity.class, bundle, 0);
                break;
            case 5:
                url = Constant.ORDER_DELETE_URL;
                commitData(orderId, url);

                break;
            default:
                break;
        }


    }

    //操作后刷新界面
    public void commitData(String orderId, String url) {
        //定单状态操作
        HashMap<String, Object> map = new HashMap<>();
        map.put("order_id", orderId);
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
//        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        HttpGetDataUtil.post(mActivity, url, map,this);
    }


    @Override
    public void onRVItemClick(ViewGroup viewGroup, View view, int i) {
//        if (mAdapter.getData().size() == 0)
//            return;
//        OrderVO vo = (OrderVO) mAdapter.getData().get(i);
//        if (vo.getDetail_url() == null)
//            return;
//        Bundle bundle = new Bundle();
//        bundle.putString("url", vo.getDetail_url());
//        mActivity.open(WebViewActivity.class, bundle, 0);

    }


    public void commit(String orderNo, final String payType) {
        HashMap<String, Object> map = new HashMap<>();

        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("out_trade_no", orderNo);
        map.put("pay_type", payType);
//        map.put("payment", money);
        map.put("payment", "0.01");

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
                                        payFinish();
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {
        if ("weixin_pay".equals(event.getMessage()) && state == 1) {
            payFinish();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void success(BaseVO vo) {
        mAutoSwipeRefreshLayout.autoRefresh();
    }

    public void payFinish(){
        mActivity.showCustomToast("支付成功");
        mAutoSwipeRefreshLayout.autoRefresh();
        mDialog.dismiss();
    }
}
