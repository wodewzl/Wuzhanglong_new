package com.beisheng.snatch.fragment;

import android.Manifest;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.activity.AddressAddActivity;
import com.beisheng.snatch.activity.ShopDetailActivity;
import com.beisheng.snatch.adapter.AddressDialogAdapter;
import com.beisheng.snatch.adapter.MyLuckyRecordAdapter;
import com.beisheng.snatch.adapter.WuLiuAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.AddressVO;
import com.beisheng.snatch.model.CardPasswordVO;
import com.beisheng.snatch.model.MyLuckyRecordVO;
import com.beisheng.snatch.model.WuLiuVO;
import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.bean.BuildBean;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.nanchen.compresshelper.CompressHelper;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.CheckBox;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.BottomDialogUtil;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;
import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import cn.pedant.SweetAlert.SweetAlertDialog;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MyLuckyRecordFragment extends BaseFragment implements OnLoadMoreListener, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener, MyLuckyRecordAdapter.MyLuckyRecordListener,
        BGAOnRVItemClickListener, BGASortableNinePhotoLayout.Delegate, PostCallback, BGAOnItemChildClickListener {
    private static final int PRC_PHOTO_PICKER = 1;
    private static final int RC_CHOOSE_PHOTO = 3;
    private static final int RC_PHOTO_PREVIEW = 2;
    private BGASortableNinePhotoLayout mPhotoLayout;
    public ArrayList<String> mSelectList = new ArrayList<>();
    private List<File> mOneFiles = new ArrayList<>();
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private MyLuckyRecordAdapter mAdapter;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private String type = "1";
    private TextView mOkTv;
    private LinearLayout mBottomLayout;
    private int mSelectCount = 0;
    private TextView mTotalCountTv;
    private AddressVO mAddressVO;
    private AddressDialogAdapter mAddressDialogAdapter;
    private View mViewCheck;
    private CheckBox mAllCheck;
    private EditText mTitleEt, mDescEt;
    private TextView mShowTv;
    private MyLuckyRecordVO.DataBean.ListBean mSelectVO;
    private WuLiuVO mWuLiuVO;
    private BottomSheetDialog mDialog;

    public static MyLuckyRecordFragment newInstance() {
        MyLuckyRecordFragment fragment = new MyLuckyRecordFragment();
        return fragment;
    }

    @Override
    public void noNet() {

    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.my_lucky_record_fragment);
    }

    @Override
    public void initView(View view) {
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new MyLuckyRecordAdapter(mRecyclerView);
        mAdapter.setType(type);
        mAdapter.setMyLuckyRecordListener(this);
        RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, true);
        mOkTv = getViewById(R.id.ok_tv);
        mBottomLayout = getViewById(R.id.bottom_layout);
        if ("0".equals(type)) {
            mBottomLayout.setVisibility(View.VISIBLE);
        } else {
            mBottomLayout.setVisibility(View.GONE);
        }
        mTotalCountTv = getViewById(R.id.total_count_tv);
        mViewCheck = getViewById(R.id.view_check);
        mAllCheck = getViewById(R.id.check_box);
    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mOkTv.setOnClickListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        EventBus.getDefault().register(this);
        mViewCheck.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        map.put("curpage", mCurrentPage + "");
        map.put("type", this.getType());
        BSHttpUtils.post(mActivity, this, Constant.MY_LUCKY_RECORD_URL, map, MyLuckyRecordVO.class);
        getAddress();
    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof MyLuckyRecordVO) {
            MyLuckyRecordVO bean = (MyLuckyRecordVO) vo;
            if (BaseCommonUtils.parseInt(bean.getData().getCount()) == 1) {
                mRecyclerView.setLoadMoreEnabled(false);
            }
            if (mCurrentPage == BaseCommonUtils.parseInt(bean.getData().getCount())) {
                mRecyclerView.setNoMore(true);
            } else {
                mRecyclerView.setNoMore(false);
            }
            List<MyLuckyRecordVO.DataBean.ListBean> list = bean.getData().getList();
            if (isLoadMore) {
                mAdapter.updateDataLast(list);
                isLoadMore = false;
            } else {
                mAdapter.updateData(list);
            }
            mAdapter.notifyDataSetChanged();
            count();


            mAutoSwipeRefreshLayout.setRefreshing(false);
        } else if (vo instanceof AddressVO) {
            mAddressVO = (AddressVO) vo;
            if (mAddressDialogAdapter != null)
                mAddressDialogAdapter.updateData(mAddressVO.getData().getList());
        }

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        mCurrentPage++;
        getData();
    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        getData();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_tv:
                final BottomSheetDialog dialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.address_list_dialog);
                LuRecyclerView recyclerView = dialog.getWindow().getDecorView().findViewById(R.id.dialog_recycler_view);
                TextView tv_no_address=dialog.getWindow().getDecorView().findViewById(R.id.tv_no_address);

                TextView addAddressTv = dialog.getWindow().getDecorView().findViewById(R.id.add_address_tv);
                addAddressTv.setOnClickListener(this);

                if (mAddressVO.getData().getList().size()>0) {

                    /**
                     * 有收货地址
                     */
                    tv_no_address.setVisibility(View.GONE);
                    recyclerView.setVisibility(View.VISIBLE);

                    mAddressDialogAdapter = new AddressDialogAdapter(recyclerView);
                    RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, recyclerView, mAddressDialogAdapter, R.dimen.dp_1, R.color.C3, false);
                    mAddressDialogAdapter.updateData(mAddressVO.getData().getList());
                    mAddressDialogAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                        @Override
                        public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                            final AddressVO.DataBean.ListBean bean = (AddressVO.DataBean.ListBean) mAddressDialogAdapter.getItem(position);
                            for (int i = 0; i < mAddressDialogAdapter.getData().size(); i++) {
                                AddressVO.DataBean.ListBean vo = (AddressVO.DataBean.ListBean) mAddressDialogAdapter.getData().get(i);
                                vo.setIs_default("0");
                            }
                            bean.setIs_default("1");
                            mAddressDialogAdapter.notifyDataSetChanged();

                            new SweetAlertDialog(mActivity, SweetAlertDialog.WARNING_TYPE)
                                    .setTitleText("确认要领取？")
//                            .setContentText("删除成功")
                                    .setConfirmText("确定")
                                    .setCancelText("取消")

                                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                                        @Override
                                        public void onClick(SweetAlertDialog sDialog) {
                                            getShop(bean.getId());
                                            sDialog.dismissWithAnimation();//直接消失
                                            dialog.dismiss();
                                        }
                                    })
                                    .show();


                        }
                    });
                }else {

                    /**
                     * 没有收货地址
                     */

                    tv_no_address.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);




                }
                break;
            case R.id.add_address_tv:
                mActivity.openActivity(AddressAddActivity.class);
                break;

            case R.id.view_check:
                if (mAllCheck.isChecked()) {
                    mAllCheck.setChecked(false);
                } else {
                    mAllCheck.setChecked(true);
                }
                for (int i = 0; i < mAdapter.getData().size(); i++) {
                    MyLuckyRecordVO.DataBean.ListBean vo = (MyLuckyRecordVO.DataBean.ListBean) mAdapter.getData().get(i);
                    vo.setCheck(mAllCheck.isChecked());
                }
                mAdapter.notifyDataSetChanged();
                count();

                break;

            case R.id.show_tv:
                if (TextUtils.isEmpty(mTitleEt.getText().toString())) {
                    mActivity.showCustomToast("请填写标题");
                    return;
                }
                if (TextUtils.isEmpty(mDescEt.getText().toString())) {
                    mActivity.showCustomToast("请填写内容");
                    return;
                }
                if (mOneFiles.size() == 0) {
                    mActivity.showCustomToast("请拍照晒图");
                    return;
                }

                HashMap<String, Object> map = new HashMap<>();
                map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                map.put("id", mSelectVO.getId());
                map.put("title", mTitleEt.getText().toString());
                map.put("content", mDescEt.getText().toString());
                for (int i = 0; i < mOneFiles.size(); i++) {
                    map.put("image", mOneFiles.get(i));
                }
                BSHttpUtils.postFile(mActivity, Constant.SHOW_URL, map, BaseVO.class, this);

                break;
            default:
                break;
        }

    }


    @Override
    public void count() {
        mSelectCount = 0;

        mBottomLayout.setVisibility(View.GONE);
        for (int i = 0; i < mAdapter.getData().size(); i++) {
            MyLuckyRecordVO.DataBean.ListBean bean = (MyLuckyRecordVO.DataBean.ListBean) mAdapter.getData().get(i);
            if (bean.isCheck() && "0".equals(bean.getOvertime())) {
                mSelectCount = mSelectCount + 1;
                mBottomLayout.setVisibility(View.VISIBLE);
            }
        }
        BaseCommonUtils.setTextTwoLast(mActivity, mTotalCountTv, "全选", "(" + mSelectCount + ")", R.color.colorAccent, 1.0f);
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        MyLuckyRecordVO.DataBean.ListBean vo = (MyLuckyRecordVO.DataBean.ListBean) mAdapter.getItem(position);
        Bundle bundle = new Bundle();
        bundle.putString("id", vo.getId());
        mActivity.open(ShopDetailActivity.class, bundle, 0);

    }

    @AfterPermissionGranted(PRC_PHOTO_PICKER)
    public void choicePhotoWrapper(BaseActivity activity, int maxCount, String filePath) {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(activity, perms)) {
            // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话就没有拍照功能
            File takePhotoDir = new File(Environment.getExternalStorageDirectory(), filePath);

            Intent photoPickerIntent = new BGAPhotoPickerActivity.IntentBuilder(activity)
                    .cameraFileDir(takePhotoDir) // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话则不开启图库里的拍照功能
                    .maxChooseCount(3) // 图片选择张数的最大值
                    .selectedPhotos(null) // 当前已选中的图片路径集合
                    .pauseOnScroll(false)
                    .selectedPhotos(mSelectList)


                    // 滚动列表时是否暂停加载图片
                    .build();
            activity.startActivityForResult(photoPickerIntent, RC_CHOOSE_PHOTO);
        } else {
            EasyPermissions.requestPermissions(activity, "图片选择需要以下权限:\n\n1.访问设备上的照片\n\n2.拍照", PRC_PHOTO_PICKER, perms);
        }
    }


    @Override
    public void onClickAddNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {
        choicePhotoWrapper(mActivity, 3, BaseConstant.SDCARD_CACHE);
    }

    @Override
    public void onClickDeleteNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
        mPhotoLayout.removeItem(position);
    }

    @Override
    public void onClickNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
        Intent photoPickerPreviewIntent = new BGAPhotoPickerPreviewActivity.IntentBuilder(mActivity)
//                .cameraFileDir(mTakePhotoCb.isChecked() ? takePhotoDir : null) // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话则不开启图库里的拍照功能
                .previewPhotos(models) // 当前预览的图片路径集合
                .selectedPhotos(models) // 当前已选中的图片路径集合
                .maxChooseCount(mPhotoLayout.getMaxItemCount()) // 图片选择张数的最大值
                .currentPosition(position) // 当前预览图片的位置
                .isFromTakePhoto(false) // 是否是拍完照后跳转过来
                .build();
        startActivityForResult(photoPickerPreviewIntent, RC_PHOTO_PREVIEW);
    }

    @Override
    public void onNinePhotoItemExchanged(BGASortableNinePhotoLayout sortableNinePhotoLayout, int fromPosition, int toPosition, ArrayList<String> models) {

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_CHOOSE_PHOTO) {
            //是否单选，单选走true 语句，多选走false语句，这么默认false
//            List<String> selectedPhotos = BGAPhotoPickerActivity.getSelectedPhotos(data);
            mSelectList = BGAPhotoPickerActivity.getSelectedPhotos(data);
            mPhotoLayout.setData(mSelectList);
        } else if (requestCode == RC_PHOTO_PREVIEW) {
            // 在预览界面按返回也会回传预览界面已选择的图片集合
//            List<String> selectedPhotos = BGAPhotoPickerPreviewActivity.getSelectedPhotos(data);
//            mPhotoLayout.setData(BGAPhotoPickerPreviewActivity.getSelectedPhotos(data));
            mSelectList = BGAPhotoPickerPreviewActivity.getSelectedPhotos(data);
            mPhotoLayout.setData(mSelectList);
        }

        mOneFiles.clear();
        for (int i = 0; i < mPhotoLayout.getData().size(); i++) {
            File file = new File(mPhotoLayout.getData().get(i));
            File newFile = CompressHelper.getDefault(mActivity).compressToFile(file);
            mOneFiles.add(newFile);
        }
    }

    @Override
    public void success(BaseVO vo) {
        if (vo instanceof WuLiuVO) {
            mWuLiuVO = (WuLiuVO) vo;
//            helper.setText(R.id.tv_04,"查看物流详情");
            final BottomSheetDialog dialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.wuliu_list_dialog);
            ImageView img = dialog.getWindow().getDecorView().findViewById(R.id.img);
            Picasso.with(mActivity).load(mSelectVO.getGoods_picture()).into(img);
            TextView titleTv = dialog.getWindow().getDecorView().findViewById(R.id.title_tv);
            titleTv.setText(mWuLiuVO.getData().getExpress_name());
            TextView numberTv = dialog.getWindow().getDecorView().findViewById(R.id.number_tv);
            numberTv.setText(mWuLiuVO.getData().getLogistic_code());
            TextView copyTv = dialog.getWindow().getDecorView().findViewById(R.id.copy_tv);
            copyTv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClipboardManager cm = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
                    // 将文本内容放到系统剪贴板里。
                    cm.setText(mWuLiuVO.getData().getLogistic_code());
                    mActivity.showCustomToast("复制成功");
                }
            });
            LuRecyclerView recyclerView = dialog.getWindow().getDecorView().findViewById(R.id.dialog_recycler_view);
            final WuLiuAdapter dialogAdapter = new WuLiuAdapter(recyclerView);
            RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, recyclerView, dialogAdapter, R.dimen.dp_0, R.color.C3, false);
            dialogAdapter.updateData(mWuLiuVO.getData().getTraces());
        } else if (vo instanceof CardPasswordVO) {
            CardPasswordVO bean = (CardPasswordVO) vo;
            showDialog(bean);
        } else {
            mActivity.showSuccessToast(vo.getDesc());
            mAutoSwipeRefreshLayout.autoRefresh();
            if (mDialog != null)
                mDialog.dismiss();
        }

    }

    public void getAddress() {
        HashMap<String, Object> addressMap = new HashMap<>();
        addressMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        BSHttpUtils.post(mActivity, this, Constant.ADDRESS_LIST_URL, addressMap, AddressVO.class);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {
        if ("refresh".equals(event.getMessage())) {
            getAddress();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        EventBus.getDefault().unregister(this);
    }

    public void getShop(String addressId) {
        mActivity.showProgressDialog();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mAdapter.getData().size(); i++) {
            MyLuckyRecordVO.DataBean.ListBean myLuckyRecordVO = (MyLuckyRecordVO.DataBean.ListBean) mAdapter.getData().get(i);
            if (myLuckyRecordVO.isCheck()) {
                sb.append(myLuckyRecordVO.getId()).append(",");
            }
        }
        if (sb.length() == 0) {
            mActivity.showSuccessToast("请选择要领取的宝贝");
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        if (AppApplication.getInstance().getUserInfoVO() != null)
            map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());

        map.put("id", sb.toString().substring(0, sb.toString().length() - 1));
        map.put("address_id", addressId);
        BSHttpUtils.postCallBack(mActivity, Constant.GET_SHOP_URL, map, BaseVO.class, this);

    }

    @Override
    public void onItemChildClick(ViewGroup parent, View childView, int position) {
        mSelectVO = (MyLuckyRecordVO.DataBean.ListBean) mAdapter.getItem(position);

        if ("1".equals(mSelectVO.getIs_virtual())) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
            map.put("id", mSelectVO.getId());
            map.put("type", "1");
            BSHttpUtils.postCallBack(mActivity, Constant.CARD_PWD_URL, map, CardPasswordVO.class, this);
        } else {
            if ("1".equals(mSelectVO.getDelivery_status())) {
                HashMap<String, Object> map = new HashMap<>();
                map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                map.put("id", mSelectVO.getId());
                BSHttpUtils.postCallBack(mActivity, Constant.WU_LIU_URL, map, WuLiuVO.class, this);

            } else if ("2".equals(mSelectVO.getDelivery_status())) {
                if ("0".equals(mSelectVO.getIs_evaluate())) {
                    mDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.show_order_dialog);
                    mPhotoLayout = mDialog.getWindow().getDecorView().findViewById(R.id.phone_layout);
                    mPhotoLayout.setMaxItemCount(3);
                    mPhotoLayout.setEditable(true);//有加号，有删除，可以点加号选择，false没有加号，点其他按钮选择，也没有删除
                    mPhotoLayout.setPlusEnable(true);//有加号，可以点加号选择，false没有加号，点其他按钮选择
                    mPhotoLayout.setSortable(true);//排序
                    mPhotoLayout.setDelegate(this);
                    mTitleEt = mDialog.getWindow().getDecorView().findViewById(R.id.title_et);
                    mDescEt = mDialog.getWindow().getDecorView().findViewById(R.id.desc_et);
                    mShowTv = mDialog.getWindow().getDecorView().findViewById(R.id.show_tv);
                    mShowTv.setOnClickListener(this);
                }
            }
        }
    }

    public void showDialog(CardPasswordVO bean) {
        DialogUIUtils.init(mActivity);
        View rootView = View.inflate(mActivity, R.layout.card_password_dialog, null);
        TextView statusTv = rootView.findViewById(R.id.status_tv);
        statusTv.setText(bean.getData().getStatus_text());
        if ("2".equals(bean.getData().getStatus())) {
            statusTv.setBackgroundResource(R.drawable.corners_5_gary);
            statusTv.setTextColor(ContextCompat.getColor(mActivity, R.color.C5));
        } else {
            statusTv.setBackgroundResource(R.drawable.corners_5_red);
            statusTv.setTextColor(ContextCompat.getColor(mActivity, R.color.C1));
        }
        TextView numberTv = rootView.findViewById(R.id.number_tv);
        numberTv.setText("期号：" + mSelectVO.getIssue_no() + "期");

        TextView contentTv = rootView.findViewById(R.id.content_tv);
        contentTv.setText("兑换码：" + bean.getData().getVirtual_code());
        final BuildBean buildBean = DialogUIUtils.showCustomAlert(mActivity, rootView);
        buildBean.show();
    }
}
