package com.beisheng.snatch.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.AddressDialogAdapter;
import com.beisheng.snatch.adapter.MyBuyRecordAdapter;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.nanchen.compresshelper.CompressHelper;
import com.rey.material.app.BottomSheetDialog;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.adapter.RecyclerBaseAdapter;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BottomDialogUtil;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MyLuckyRecordActivity extends BaseActivity implements View.OnClickListener, BGAOnRVItemClickListener, BGASortableNinePhotoLayout.Delegate {
    private static final int PRC_PHOTO_PICKER = 1;
    private static final int RC_CHOOSE_PHOTO = 1;
    private static final int RC_PHOTO_PREVIEW = 2;
    private BGASortableNinePhotoLayout mPhotoLayout;
    public ArrayList<String> mSelectList = new ArrayList<>();
    private List<File> mOneFiles = new ArrayList<>();
    private TextView mTitle1, mTitle2, mOkTv;
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private RecyclerBaseAdapter mAdapter;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.my_lucky_record_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("幸运记录");
        mTitle1 = getViewById(R.id.title1);
        mTitle2 = getViewById(R.id.title2);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
//        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_1, R.color.C3);
//        mRecyclerView.addItemDecoration(divider);
//        mAdapter = new MyBuyRecordAdapter(mRecyclerView);
//        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
//        mRecyclerView.setAdapter(adapter);
//        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
//        mRecyclerView.setLoadMoreEnabled(true);
        mAdapter = new MyBuyRecordAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, true);
        mOkTv = getViewById(R.id.ok_tv);

    }

    @Override
    public void bindViewsListener() {
        mTitle1.setOnClickListener(this);
        mTitle2.setOnClickListener(this);
        mOkTv.setOnClickListener(this);
        mAdapter.setOnRVItemClickListener(this);
    }

    @Override
    public void getData() {
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
            case R.id.title1:
                mTitle1.setBackgroundResource(R.drawable.corners_tab_left_select);
                mTitle1.setTextColor(ContextCompat.getColor(this, R.color.C1));
                mTitle2.setBackgroundResource(R.drawable.corners_tab_right_normal);
                mTitle2.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
//                if (mYestadyBean == null) {
//                    mTag = "local";
//                    getData();
//                } else {
//                    mAdapter.updateData(mYestadyBean.getRate());
//
//                }
                break;
            case R.id.title2:
                mTitle2.setBackgroundResource(R.drawable.corners_tab_right_select);
                mTitle2.setTextColor(ContextCompat.getColor(this, R.color.C1));
                mTitle1.setBackgroundResource(R.drawable.corners_tab_left_normal);
                mTitle1.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
//                if (mTodayBean == null) {
//                    mTag = "now";
//                    getData();
//                } else {
//                    mAdapter.updateData(mTodayBean.getRate());
//
//                }
                break;

            case R.id.ok_tv:
                BottomSheetDialog dialog = BottomDialogUtil.initBottomDialog(this, R.layout.address_list_dialog);
                LuRecyclerView recyclerView = dialog.getWindow().getDecorView().findViewById(R.id.dialog_recycler_view);
                AddressDialogAdapter dialogAdapter = new AddressDialogAdapter(recyclerView);
                RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, recyclerView, dialogAdapter, R.dimen.dp_1, R.color.C3, false);
                break;

            default:
                break;
        }
    }

    public void onAddressClick(View v) {
        switch (v.getId()) {
            case R.id.add_address_tv:
                System.out.println("=========>");
                BottomSheetDialog dialog = BottomDialogUtil.initBottomDialog(this, R.layout.add_address_dialog);
                break;
            case R.id.check_img:
                System.out.println("=========>");
                break;
            default:
                break;
        }
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        BottomSheetDialog dialog = BottomDialogUtil.initBottomDialog(this, R.layout.show_order_dialog);
        mPhotoLayout = dialog.getWindow().getDecorView().findViewById(R.id.phone_layout);
        mPhotoLayout.setMaxItemCount(3);
        mPhotoLayout.setEditable(true);//有加号，有删除，可以点加号选择，false没有加号，点其他按钮选择，也没有删除
        mPhotoLayout.setPlusEnable(true);//有加号，可以点加号选择，false没有加号，点其他按钮选择
        mPhotoLayout.setSortable(true);//排序
        mPhotoLayout.setDelegate(this);
    }


    @Override
    public void onClickAddNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {
        choicePhotoWrapper(this, 3, BaseConstant.SDCARD_CACHE);
    }

    @Override
    public void onClickDeleteNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
        mPhotoLayout.removeItem(position);
    }

    @Override
    public void onClickNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
        Intent photoPickerPreviewIntent = new BGAPhotoPickerPreviewActivity.IntentBuilder(this)
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
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == RC_CHOOSE_PHOTO) {
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
            File newFile = CompressHelper.getDefault(MyLuckyRecordActivity.this).compressToFile(file);
            mOneFiles.add(newFile);
        }
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
}