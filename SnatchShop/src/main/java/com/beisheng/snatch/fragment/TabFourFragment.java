package com.beisheng.snatch.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.QRCodeActivity;
import com.beisheng.snatch.activity.SearchShopActivity;
import com.beisheng.snatch.activity.WebViewActivity;
import com.beisheng.snatch.adapter.PayTypeAdapter;
import com.beisheng.snatch.adapter.RedMoneyAdapter;
import com.beisheng.snatch.adapter.ShopCatAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.PayRedVO;
import com.beisheng.snatch.model.PayTypeVO;
import com.beisheng.snatch.model.ShopCatVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.CheckBox;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.mode.PayInfoVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.BottomDialogUtil;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.utils.PayUtis;
import com.wuzhanglong.library.utils.RecyclerViewUtil;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.baseadapter.BGAOnRVItemLongClickListener;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class TabFourFragment extends BaseFragment implements View.OnClickListener, BGAOnRVItemClickListener, BGAOnRVItemLongClickListener, PostCallback, BGAOnItemChildClickListener, ShopCatAdapter
        .ShopCatListener {
    private LuRecyclerView mRecyclerView;
    private ShopCatAdapter mAdapter;
    private TextView mOkTv;
    private TextView mPayTypeTv, mRedMoneyTv, mDialogCountTv, mBuyTv;
    private ShopCatVO.DataBean mDataBean;
    private TextView mTotalCountTv;
    private CheckBox mAllCheck;
    private View mViewCheck;
    private TextView mEditTv;
    private PayTypeVO mPayTypeVO;
    private PayRedVO mPayRedVO;
    private int mTotalCount = 0;
    private String mPayType = "", mRedId = "";
    private BottomSheetDialog mPayDialog;

    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_four_fragment);
    }

    @Override
    public void initView(View view) {
        mActivity.mBaseHeadLayout.setVisibility(View.GONE);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new ShopCatAdapter(mRecyclerView);
        mAdapter.setShopCatListener(this);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(false);
        mOkTv = getViewById(R.id.ok_tv);
        mTotalCountTv = getViewById(R.id.total_count_tv);
        mAllCheck = getViewById(R.id.check_box);
        mViewCheck = getViewById(R.id.view_check);
        mEditTv = getViewById(R.id.edit_tv);
    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
        mAdapter.setOnRVItemLongClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        mViewCheck.setOnClickListener(this);
        mEditTv.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }


    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("cart_info", "");
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
//        map.put(" payment_code", "");
//        map.put("coupon_id", "");
        BSHttpUtils.post(mActivity, this, Constant.SHOP_CART_URL, map, ShopCatVO.class);


    }

    @Override
    public void hasData(BaseVO vo) {

        ShopCatVO shopCatVO = (ShopCatVO) vo;
        mDataBean = ((ShopCatVO) vo).getData();
        List<ShopCatVO.DataBean.ListBean> list = shopCatVO.getData().getList();
        List<ShopCatVO.DataBean.ListBean> listOne = new ArrayList<>();//可购买的
        List<ShopCatVO.DataBean.ListBean> listTwo = new ArrayList<>();//失效的
        List<ShopCatVO.DataBean.ListBean> listAll = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if ("1".equals(list.get(i).getIs_valid())) {
                listOne.add(list.get(i));
            } else {
                listTwo.add(list.get(i));
            }
        }
        listAll.addAll(listOne);
        ShopCatVO.DataBean.ListBean titleVO = new ShopCatVO.DataBean.ListBean();
        titleVO.setValidedCount(listTwo.size() + "");
        listAll.add(titleVO);
        listAll.addAll(listTwo);
        mAdapter.updateData(listAll);
        mAdapter.notifyDataSetChanged();


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
            case R.id.ok_tv:

                if ("删除".equals(mOkTv.getText().toString())) {

                    new SweetAlertDialog(mActivity, SweetAlertDialog.WARNING_TYPE)
                            .setTitleText("确定要删除?")
                            .setConfirmText("确定")
                            .setCancelText("取消")
                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                @Override
                                public void onClick(SweetAlertDialog sDialog) {
                                    final StringBuffer sb = new StringBuffer();
                                    List<ShopCatVO.DataBean.ListBean> list = mDataBean.getList();
                                    for (int i = 0; i < list.size(); i++) {
                                        if (mDataBean.getList().get(i).isCheck()) {
                                            if (i == mDataBean.getList().size() - 1) {
                                                sb.append(mDataBean.getList().get(i).getCart_id());
                                            } else {
                                                sb.append(mDataBean.getList().get(i).getCart_id()).append(",");
                                            }

                                            mAdapter.getData().remove(mDataBean.getList().get(i));
                                        }
                                    }
                                    sDialog.dismissWithAnimation();//直接消失
                                    if (sb.length() == 0) {
                                        mActivity.showCustomToast("请勾选想要删除的宝贝");
                                        return;
                                    }
                                    delete(sb.toString());
                                }
                            })
                            .show();


                } else {
                    if (mTotalCount == 0) {
                        mActivity.showCustomToast("请选择抢购的宝贝");
                        return;
                    }
                    mPayDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.buy_dialog);
                    mPayTypeTv = mPayDialog.getWindow().getDecorView().findViewById(R.id.pay_type_tv);
                    mRedMoneyTv = mPayDialog.getWindow().getDecorView().findViewById(R.id.red_money_tv);
                    mDialogCountTv = mPayDialog.getWindow().getDecorView().findViewById(R.id.dialog_count_tv);
                    mBuyTv = mPayDialog.getWindow().getDecorView().findViewById(R.id.buy_tv);
                    mPayTypeTv.setOnClickListener(this);
                    mRedMoneyTv.setOnClickListener(this);
                    mBuyTv.setOnClickListener(this);
//                    mDialogCountTv.setText("你抢购了");
                    BaseCommonUtils.setTextThree(mActivity, mDialogCountTv, "你抢购了", mTotalCount + "", "次", R.color.colorAccent, 1.3f);

                    //支付方式
                    HashMap<String, Object> payTypeMap = new HashMap<>();
                    payTypeMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                    payTypeMap.put("is_recharge", "0");
                    payTypeMap.put("total_count", mTotalCount + "");
                    BSHttpUtils.postCallBack(mActivity, Constant.PAY_TYPE_LIST_URL, payTypeMap, PayTypeVO.class, this);

                    //可用红包
                    final StringBuffer sb = new StringBuffer();

                    for (int i = 0; i < mDataBean.getList().size(); i++) {
                        if (mDataBean.getList().get(i).isCheck()) {
                            if (i == mDataBean.getList().size() - 1) {
                                sb.append(mDataBean.getList().get(i).getPanic_id()).append("|").append(mDataBean.getList().get(i).getNum());
                            } else {
                                sb.append(mDataBean.getList().get(i).getPanic_id()).append("|").append(mDataBean.getList().get(i).getNum()).append(",");
                            }
                        }
                    }

                    HashMap<String, Object> redMap = new HashMap<>();
                    redMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                    redMap.put("cart_info", sb.toString());
                    BSHttpUtils.postCallBack(mActivity, Constant.PAY_RED_LIST_URL, redMap, PayRedVO.class, this);
                }

                break;

            case R.id.pay_type_tv:
//                BottomSheetDialog payuDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.buy_pay_dialog);
                final BottomSheetDialog payTypeDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.pay_type_list_dialog);
                LuRecyclerView payTyperecyclerView = payTypeDialog.getWindow().getDecorView().findViewById(R.id.dialog_recycler_view);
                final PayTypeAdapter payTypeDialogAdapter = new PayTypeAdapter(payTyperecyclerView);
                RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, payTyperecyclerView, payTypeDialogAdapter, R.dimen.dp_1, R.color.C3, false);
                if (mPayTypeVO != null){
                    List<PayTypeVO.DataBean.ListBean> list=  mPayTypeVO.getData().getList();
                    list.get(0).setCheck(true);
                    payTypeDialogAdapter.updateData(list);
                }
                payTypeDialogAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                    @Override
                    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                        PayTypeVO.DataBean.ListBean bean = (PayTypeVO.DataBean.ListBean) payTypeDialogAdapter.getItem(position);
                        for (int i = 0; i < mPayTypeVO.getData().getList().size(); i++) {
                            mPayTypeVO.getData().getList().get(i).setCheck(false);
                        }
                        bean.setCheck(true);
                        payTypeDialogAdapter.notifyDataSetChanged();
                        mPayTypeTv.setText(bean.getPayment_name());
                        mPayType = bean.getPayment_code();
                        if ("BALANCE".equals(bean.getPayment_code())) {
                            mRedMoneyTv.setTextColor(mActivity.getResources().getColor(R.color.colorAccent));
                            mRedMoneyTv.setClickable(true);
                        } else {
                            mRedMoneyTv.setTextColor(mActivity.getResources().getColor(R.color.C5));
                            mRedMoneyTv.setClickable(false);
                        }
                        payTypeDialog.dismiss();
                    }
                });

                break;
            case R.id.red_money_tv:
                final BottomSheetDialog redDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.red_money_list_dialog);
                LuRecyclerView recyclerView = redDialog.getWindow().getDecorView().findViewById(R.id.dialog_recycler_view);
                final RedMoneyAdapter dialogAdapter = new RedMoneyAdapter(recyclerView);
                RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, recyclerView, dialogAdapter, R.dimen.dp_10, R.color.C3, false);
                if (mPayRedVO != null)
                    dialogAdapter.updateData(mPayRedVO.getData().getCoupon_list());
                dialogAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                    @Override
                    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                        PayRedVO.DataBean.CouponListBean bean = (PayRedVO.DataBean.CouponListBean) dialogAdapter.getItem(position);
                        mRedMoneyTv.setText("抵扣" + bean.getMoney() + "元");
                        mRedId = bean.getCoupon_id();
                        redDialog.dismiss();
                    }
                });
                break;

            case R.id.view_check:
                if (mAllCheck.isChecked()) {
                    mAllCheck.setChecked(false);
                } else {
                    mAllCheck.setChecked(true);
                }
                for (int i = 0; i < mAdapter.getData().size(); i++) {
                    ShopCatVO.DataBean.ListBean vo = (ShopCatVO.DataBean.ListBean) mAdapter.getData().get(i);
                    vo.setCheck(mAllCheck.isChecked());
                }
                mAdapter.notifyDataSetChanged();
                break;

            case R.id.edit_tv:
                if ("编辑".equals(mEditTv.getText().toString())) {
                    mTotalCountTv.setVisibility(View.INVISIBLE);
                    mOkTv.setText("删除");
                    mEditTv.setText("完成");
                } else {
                    mTotalCountTv.setVisibility(View.VISIBLE);
                    mOkTv.setText("抢购");
                    mEditTv.setText("编辑");
                }
                break;

            case R.id.buy_tv:
                final StringBuffer sb = new StringBuffer();
                for (int i = 0; i < mDataBean.getList().size(); i++) {
                    if (i == mDataBean.getList().size() - 1) {
                        sb.append(mDataBean.getList().get(i).getPanic_id()).append("|").append(mDataBean.getList().get(i).getNum());
                    } else {
                        sb.append(mDataBean.getList().get(i).getPanic_id()).append("|").append(mDataBean.getList().get(i).getNum()).append(",");
                    }
                }
                HashMap<String, Object> buyMap = new HashMap<>();
                buyMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                buyMap.put("cart_info", sb.toString());
                buyMap.put("payment_code", mPayType);
                buyMap.put("coupon_id", mRedId);
                buyMap.put("platform", "1");
                BSHttpUtils.postCallBack(mActivity, Constant.SHOPCAT_BUY_URL, buyMap, PayInfoVO.class, this);
                break;
            default:
                break;
        }
    }


    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {

    }

    @Override
    public boolean onRVItemLongClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return false;
        ShopCatVO.DataBean.ListBean vo = (ShopCatVO.DataBean.ListBean) mAdapter.getItem(position);
        vo.setLongClick(true);
        mAdapter.notifyDataSetChanged();
        return false;
    }

    //    final ShopCatVO.DataBean.ListBean bean
    public void delete(String id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("cart_id", id);
        BSHttpUtils.postCallBack(mActivity, Constant.SHOPCART_DELETE_ONE_ULR, map, BaseVO.class, TabFourFragment.this);
    }

    public void deleteAll() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("del_invalid", "1");
        BSHttpUtils.postCallBack(mActivity, Constant.SHOPCART_DELETE_ONE_ULR, map, BaseVO.class, this);
        for (int i = 0; i < mDataBean.getList().size(); i++) {
            if ("0".equals(mDataBean.getList().get(i).getIs_valid())) {
                mAdapter.getData().remove(mDataBean.getList().get(i));
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void totalCount() {
        mTotalCount = 0;
        for (int i = 0; i < mAdapter.getData().size(); i++) {
            ShopCatVO.DataBean.ListBean vo = (ShopCatVO.DataBean.ListBean) mAdapter.getData().get(i);
            if (vo.getCart_id() != null && vo.isCheck()) {
                mTotalCount = mTotalCount + BaseCommonUtils.parseInt(vo.getNum());
            }
        }
        BaseCommonUtils.setTextThree(mActivity, mTotalCountTv, "合计抢购：", mTotalCount + "", "次", R.color.colorAccent, 1.5f);
    }

    @Override
    public void success(BaseVO vo) {
        if (vo instanceof PayTypeVO) {
            mPayTypeVO = (PayTypeVO) vo;
            mPayTypeTv.setText(mPayTypeVO.getData().getList().get(0).getPayment_name());
            mPayType=mPayTypeVO.getData().getList().get(0).getPayment_code();
        } else if (vo instanceof PayRedVO) {
            mPayRedVO = (PayRedVO) vo;
            mRedMoneyTv.setText(mPayRedVO.getData().getCoupon_count() + "个红包可用");
        } else if (vo instanceof ShopCatVO) {
            System.out.println("===========");
        } else if (vo instanceof PayInfoVO) {
            PayInfoVO payInfoVO = (PayInfoVO) vo;
            if ("200".equals(vo.getCode())) {
                if ("WPAY".equals(mPayType)) {
                    PayUtis.weiXinPay(mActivity, payInfoVO.getData().getWxpay_params());

                } else if ("ALIPAY".equals(mPayType)) {
                    String payInfo = payInfoVO.getData().getAlipay_string();
                    PayUtis.zhiFuBaoPay(mActivity, payInfo, new PayCallback() {
                        @Override
                        public void payResult(int type) {
                            mPayDialog.dismiss();
                            getData();
                        }
                    });
                }else if("ALIWAP".equals(mPayType)){
                    Bundle bundle=new Bundle();
                    bundle.putString("title","支付宝支付");
                    bundle.putString("content",payInfoVO.getData().getAlipay_wap_html());
                    mActivity.open(WebViewActivity.class,bundle,0);
                }else if("WSCAN".equals(mPayType)){
                    Bundle bundle=new Bundle();
                    bundle.putString("img",payInfoVO.getData().getWx_native_qrcode());
                    bundle.putString("url",payInfoVO.getData().getPayment_status_api());
                    mActivity.open(QRCodeActivity.class,bundle,0);
                }else if("BALANCE".equals(mPayType)){
                    mActivity.showCustomToast(vo.getDesc());
                    getData();
                }

            }
        } else {
            mActivity.showSuccessToast(vo.getDesc());
        }
    }


    @Override
    public void onItemChildClick(ViewGroup parent, View v, final int position) {
        final ShopCatVO.DataBean.ListBean dataBean = (ShopCatVO.DataBean.ListBean) mAdapter.getItem(position);
        switch (v.getId()) {
            case R.id.collect_tv:
                dataBean.setLongClick(true);
                mAdapter.notifyDataSetChanged();
                HashMap<String, Object> favorMap = new HashMap<>();
                favorMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                favorMap.put("id", dataBean.getPanic_id());
                BSHttpUtils.postCallBack(mActivity, Constant.FAVOR_ADD_URL, favorMap, BaseVO.class, this);
                dataBean.setLongClick(false);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.see_same_tv:
                dataBean.setLongClick(true);
                mAdapter.notifyDataSetChanged();
                Bundle bundle = new Bundle();
                bundle.putString("id", dataBean.getCategory_id());
                mActivity.open(SearchShopActivity.class, bundle, 0);
                dataBean.setLongClick(false);
                mAdapter.notifyDataSetChanged();
                break;
            case R.id.delete_tv:
                dataBean.setLongClick(true);
                mAdapter.notifyDataSetChanged();
                new SweetAlertDialog(mActivity, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要删除?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                mAdapter.getData().remove(position);
                                delete(dataBean.getCart_id());
                                mAdapter.notifyDataSetChanged();
                                sDialog.dismissWithAnimation();//直接消失
                            }
                        })
                        .show();
                break;
            case R.id.clean_tv:
                new SweetAlertDialog(mActivity, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要清空?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                deleteAll();
                                sDialog.dismissWithAnimation();//直接消失
                            }
                        })
                        .show();
                break;

            case R.id.delete_one_tv:
                new SweetAlertDialog(mActivity, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要删除?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                mAdapter.getData().remove(position);
                                delete(dataBean.getCart_id());
                                mAdapter.notifyDataSetChanged();
                                sDialog.dismissWithAnimation();//直接消失
                            }
                        })
                        .show();
                break;
            default:
                break;
        }
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        System.out.println("==========");
        if (!isVisibleToUser && mDataBean != null && mDataBean.getList().size() > 0) {
            final StringBuffer sb = new StringBuffer();
            for (int i = 0; i < mDataBean.getList().size(); i++) {
                if (i == mDataBean.getList().size() - 1) {
                    sb.append(mDataBean.getList().get(i).getCart_id()).append("|").append(mDataBean.getList().get(i).getNum());
                } else {
                    sb.append(mDataBean.getList().get(i).getCart_id()).append("|").append(mDataBean.getList().get(i).getNum()).append(",");
                }
            }
            HashMap<String, Object> favorMap = new HashMap<>();
            favorMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
            favorMap.put("cart_info", sb.toString());
            BSHttpUtils.postCallBack(mActivity, Constant.SHOPCAT_UPDATE_URL, favorMap, ShopCatVO.class, this);
        }
//        getData();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {
        if ("weixin_pay".equals(event.getMessage())) {
            mPayDialog.dismiss();
            getData();
        }else if("shopcat_update".equals(event.getMessage())){
            getData();
        }else if("wx_web".equals(event.getMessage())){
            mPayDialog.dismiss();
            getData();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}

