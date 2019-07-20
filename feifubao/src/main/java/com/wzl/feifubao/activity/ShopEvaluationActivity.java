package com.wzl.feifubao.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nanchen.compresshelper.CompressHelper;
import com.rey.material.widget.CheckBox;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.OrderVO;
import com.wzl.feifubao.mode.UserInfoVO;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import me.zhanghai.android.materialratingbar.MaterialRatingBar;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class ShopEvaluationActivity extends BaseActivity implements BGASortableNinePhotoLayout.Delegate, PostCallback, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private static final int PRC_PHOTO_PICKER = 1;
    private static final int RC_CHOOSE_PHOTO = 1;
    private static final int RC_PHOTO_PREVIEW = 2;
    private BGASortableNinePhotoLayout mPhotoLayout;
    public ArrayList<String> mSelectList = new ArrayList<>();
    private List<File> mOneFiles = new ArrayList<>();
    private ImageView mShopImg;
    private TextView mNameTv, mMoneyTv;
    private OrderVO mOrderVO;
    private EditText mEvaluationEt;
    private MaterialRatingBar mRatingBar;
    private CheckBox mCb1, mCb2, mCb3, mCb4;
    private String mExplainType = "1", mIsAnonymous="0";
    private TextView mOkTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_shop_evaluation);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("评价商品");
        mShopImg = getViewById(R.id.shop_img);
        mNameTv = getViewById(R.id.name_tv);
        mMoneyTv = getViewById(R.id.money_tv);
        mOrderVO = (OrderVO) this.getIntent().getSerializableExtra("shop");
        Picasso.with(this).load(mOrderVO.getPic_cover_small()).into(mShopImg);
        mNameTv.setText(mOrderVO.getGoods_name());
        mMoneyTv.setText("￥"+mOrderVO.getPrice());
        mEvaluationEt = getViewById(R.id.evaluation_et);
        mPhotoLayout = getViewById(R.id.photo_layout);
        mPhotoLayout.setMaxItemCount(9);
        mPhotoLayout.setEditable(true);//有加号，有删除，可以点加号选择，false没有加号，点其他按钮选择，也没有删除
        mPhotoLayout.setPlusEnable(true);//有加号，可以点加号选择，false没有加号，点其他按钮选择
        mPhotoLayout.setSortable(true);//排序
        mRatingBar = getViewById(R.id.rating_bar);
        mOkTv = getViewById(R.id.ok_tv);
        mCb1 = getViewById(R.id.cb_1);
        mCb2 = getViewById(R.id.cb_2);
        mCb3 = getViewById(R.id.cb_3);
        mCb4 = getViewById(R.id.cb_4);
    }

    @Override
    public void bindViewsListener() {
        mPhotoLayout.setDelegate(this);
        mOkTv.setOnClickListener(this);
        mCb1.setOnCheckedChangeListener(this);
        mCb2.setOnCheckedChangeListener(this);
        mCb3.setOnCheckedChangeListener(this);
        mCb4.setOnCheckedChangeListener(this);
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
    public void onClickAddNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {
        choicePhotoWrapper(this, 9, BaseConstant.SDCARD_CACHE);
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
            File newFile = CompressHelper.getDefault(ShopEvaluationActivity.this).compressToFile(file);
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
                    .maxChooseCount(9) // 图片选择张数的最大值
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_tv:
                if (TextUtils.isEmpty(mEvaluationEt.getText().toString())) {
                    showCustomToast("请输入您的美誉");
                    return;
                }
                commit();
                break;
            default:
                break;
        }
    }

    @Override
    public void success(BaseVO vo) {

    }

    public void commit() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
        map.put("order_id", mOrderVO.getOrder_id());
        map.put("order_no", mOrderVO.getOrder_no());
        map.put("order_goods_id", mOrderVO.getGoods_id());
        map.put("content", mEvaluationEt.getText().toString());
        map.put("scores", mRatingBar.getProgress() + "");
        map.put("explain_type", mExplainType);
        map.put("is_anonymous", mIsAnonymous);
        HttpGetDataUtil.post(this, Constant.SHOP_EVALUATION_URL, map, UserInfoVO.class, this);
    }

    @Override
    public void onCheckedChanged(CompoundButton v, boolean b) {
        switch (v.getId()) {
            case R.id.cb_1:
                if (b) {
                    mCb2.setChecked(false);
                    mCb3.setChecked(false);
                }

                break;
            case R.id.cb_2:
                if (b) {
                    mCb1.setChecked(false);
                    mCb3.setChecked(false);
                }
                break;
            case R.id.cb_3:
                if (b) {
                    mCb2.setChecked(false);
                    mCb1.setChecked(false);
                }
                break;
            case R.id.cb_4:
                if (b) {
                }

            default:
                break;
        }
        if (mCb1.isChecked()) {
            mExplainType = "1";
        } else if (mCb2.isChecked()) {
            mExplainType = "2";
        } else if (mCb3.isChecked()) {
            mExplainType = "3";
        }

        if (mCb4.isChecked()) {
            mIsAnonymous = "1";
        } else {
            mIsAnonymous = "0";
        }

    }
}
