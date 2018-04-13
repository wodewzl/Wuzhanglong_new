package com.beisheng.snatch.fragment;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.SearchShopActivity;
import com.beisheng.snatch.adapter.RedMoneyAdapter;
import com.beisheng.snatch.adapter.ShopCatAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.ShopCatVO;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.CheckBox;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.BottomDialogUtil;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.utils.RecyclerViewUtil;

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
    private TextView mPayTypeTv, mRedMoneyTv,mDialogCountTv;
    private ShopCatVO.DataBean mDataBean;
    private TextView mTotalCountTv;
    private CheckBox mAllCheck;
    private View mViewCheck;

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

    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
        mAdapter.setOnRVItemLongClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        mViewCheck.setOnClickListener(this);
    }


    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("cart_info", "");
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
//        map.put(" payment_code", "");
//        map.put("coupon_id", "");
        BSHttpUtils.get(mActivity, this, Constant.SHOP_CART_URL, map, ShopCatVO.class);
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
                BottomSheetDialog dialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.buy_dialog);
                mPayTypeTv = dialog.getWindow().getDecorView().findViewById(R.id.pay_type_tv);
                mRedMoneyTv = dialog.getWindow().getDecorView().findViewById(R.id.red_money_tv);
                mDialogCountTv=dialog.getWindow().getDecorView().findViewById(R.id.dialog_count_tv);
                mPayTypeTv.setOnClickListener(this);
                mRedMoneyTv.setOnClickListener(this);
                break;

            case R.id.pay_type_tv:
                BottomSheetDialog payuDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.buy_pay_dialog);
                break;
            case R.id.red_money_tv:
                BottomSheetDialog redDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.red_money_list_dialog);
                LuRecyclerView recyclerView = redDialog.getWindow().getDecorView().findViewById(R.id.dialog_recycler_view);
                RedMoneyAdapter dialogAdapter = new RedMoneyAdapter(recyclerView);
                RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, recyclerView, dialogAdapter, R.dimen.dp_10, R.color.C3, false);
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

    public void deleteOne(final ShopCatVO.DataBean.ListBean bean) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("cart_id", bean.getCart_id());
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
        int count = 0;
        for (int i = 0; i < mAdapter.getData().size(); i++) {
            ShopCatVO.DataBean.ListBean vo = (ShopCatVO.DataBean.ListBean) mAdapter.getData().get(i);
            if (vo.getCart_id() != null && vo.isCheck()) {
                count = count + BaseCommonUtils.parseInt(vo.getNum());
            }
        }
        BaseCommonUtils.setTextThree(mActivity, mTotalCountTv, "合计抢购：", count + "", "次", R.color.colorAccent, 1.5f);
    }

    @Override
    public void success(BaseVO vo) {
        mActivity.showSuccessToast(vo.getDesc());
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
                                deleteOne(dataBean);
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
                                deleteOne(dataBean);
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


}
