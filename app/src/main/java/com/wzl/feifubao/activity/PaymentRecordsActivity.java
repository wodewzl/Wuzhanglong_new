package com.wzl.feifubao.activity;

import android.Manifest;
import android.os.Environment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.google.gson.Gson;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.CheckBox;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostStringCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.PayResult;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.PayUtis;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wuzhanglong.library.view.PinnedHeaderDecoration;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.PaymentRecordAdapter;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.PaymentRecordsVO;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGANinePhotoLayout;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class PaymentRecordsActivity extends BaseActivity implements OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, PostStringCallback,BGANinePhotoLayout.Delegate {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private PaymentRecordAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String mType;
    private BottomSheetDialog mDialog;
    private static final int PRC_PHOTO_PICKER = 1;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_payment_records);
    }

    @Override
    public void initView() {

        mType = this.getIntent().getStringExtra("type");
        if ("1".equals(mType)) {
            mBaseTitleTv.setText("电费");
        } else if ("2".equals(mType)) {
            mBaseTitleTv.setText("网费");
        } else if ("3".equals(mType)) {
            mBaseTitleTv.setText("手机费");
        }
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        final PinnedHeaderDecoration decoration = new PinnedHeaderDecoration();
        decoration.registerTypePinnedHeader(R.layout.payment_record_adapter_type1, new PinnedHeaderDecoration.PinnedHeaderCreator() {
            @Override
            public boolean create(RecyclerView parent, int adapterPosition) {
                return true;
            }
        });
        mRecyclerView.addItemDecoration(decoration);

        mAdapter = new PaymentRecordAdapter(mRecyclerView);
        mAdapter.setType(mType);
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
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
//        map.put("uid", "39");
        map.put("page", mCurrentPage + "");
        map.put("type", mType);
        map.put("pagesize", "10");
        HttpGetDataUtil.get(mActivity, this, Constant.PAYMENT_RECORDS_URL, map, PaymentRecordsVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        PaymentRecordsVO paymentRecordsVO = (PaymentRecordsVO) vo;

        if (BaseCommonUtils.parseInt(paymentRecordsVO.getData().getPage_count()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(paymentRecordsVO.getData().getPage_count())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }

        List<PaymentRecordsVO.DataBeanX> list = new ArrayList<>();
        for (int i = 0; i < paymentRecordsVO.getData().getData().size(); i++) {
            list.add(paymentRecordsVO.getData().getData().get(i));
            for (int j = 0; j < paymentRecordsVO.getData().getData().get(i).getLists().size(); j++) {
                list.add(paymentRecordsVO.getData().getData().get(i).getLists().get(j));
            }
        }

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
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }

    public void showPayDialog(final PaymentRecordsVO.DataBeanX vo) {
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
        payCb1.setChecked(true);
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
            public void onError(Object tag, Throwable e) {

            }

            @Override
            public void onCancel(Object tag, Throwable e) {

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
                                    if (type == 1) {
                                        mActivity.showCustomToast("支付成功");
                                        mAutoSwipeRefreshLayout.autoRefresh();
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


    @Override
    public void success(String result) {

    }



    @AfterPermissionGranted(PRC_PHOTO_PICKER)
    public void choicePhotoWrapper(String path) {
//        ArrayList<String> list=new ArrayList<>();
//        list.add(path);
//        mPhotoLyout.setData(list);
//        mPhotoLyout.setDelegate(this);
//        path="http://gwhb.work.csongdai.com/Uploads/bs0640/Log/image/20180120/5a62e3a52890a.jpeg";
        // 保存图片的目录，改成你自己要保存图片的目录。如果不传递该参数的话就不会显示右上角的保存按钮
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            File downloadDir = new File(Environment.getExternalStorageDirectory(), BaseConstant.SDCARD_CACHE);
            BGAPhotoPreviewActivity.IntentBuilder photoPreviewIntentBuilder = new BGAPhotoPreviewActivity.IntentBuilder(this)
                    .saveImgDir(downloadDir); // 保存图片的目录，如果传 null，则没有保存图片功能

            photoPreviewIntentBuilder.previewPhoto(path);
            startActivity(photoPreviewIntentBuilder.build());
        } else {
            EasyPermissions.requestPermissions(this, "图片预览需要以下权限:\n\n1.访问设备上的照片", PRC_PHOTO_PICKER, perms);
        }
    }

    @Override
    public void onClickNinePhotoItem(BGANinePhotoLayout ninePhotoLayout, View view, int position, String model, List<String> models) {

    }
}
