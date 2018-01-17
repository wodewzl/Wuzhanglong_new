package com.wzl.feifubao.activity;


import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alipay.android.phone.mrpc.core.ThreadUtil;
import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.bean.BuildBean;
import com.nanchen.compresshelper.CompressHelper;
import com.squareup.picasso.Picasso;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.UserInfoVO;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cn.bingoogolapple.baseadapter.BGABaseAdapterUtil;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.imageloader.BGAImage;
import cn.bingoogolapple.photopicker.util.BGAPhotoHelper;
import cn.bingoogolapple.photopicker.util.BGAPhotoPickerUtil;
import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

import static com.wuzhanglong.library.http.NetWorkHelper.uri;

public class UserInfoActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private static final int PRC_PHOTO_PICKER = 1;
    private static final int RC_CHOOSE_PHOTO = 1;
    private static final int RC_PHOTO_PREVIEW = 2;
    private static final int REQUEST_CODE_CROP = 3;
    private Uri resultUri;
    private UserInfoVO mUserInfo;
    private TextView mTextView01, mTextView02, mTextView03, mTextView04, mTextView05;
    private LinearLayout mLayout01, mLayout02, mLayout03;
    private CircleImageView mHeadImg;
    private Button mBt;
    private BGAPhotoHelper mPhotoHelper;
    private File mHeadImgFile;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.user_info_activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initView() {
        mBaseTitleTv.setText("个人信息");
        mLayout01 = (LinearLayout) findViewById(R.id.layout_01);
        mLayout02 = (LinearLayout) findViewById(R.id.layout_02);
        mLayout03 = (LinearLayout) findViewById(R.id.layout_03);

        mTextView01 = (TextView) findViewById(R.id.tv_01);
        mTextView02 = (TextView) findViewById(R.id.tv_02);
        mTextView03 = (TextView) findViewById(R.id.tv_03);
        mHeadImg = (CircleImageView) findViewById(R.id.head_img);
        if (AppApplication.getInstance().getUserInfoVO() != null) {
            if (!TextUtils.isEmpty(AppApplication.getInstance().getUserInfoVO().getData().getUser_headimg()))
                Picasso.with(mActivity).load(AppApplication.getInstance().getUserInfoVO().getData().getUser_headimg()).into(mHeadImg);
            mTextView02.setText(AppApplication.getInstance().getUserInfoVO().getData().getUser_name());
            mTextView03.setText(AppApplication.getInstance().getUserInfoVO().getData().getNick_name());
        }

        File takePhotoDir = new File(Environment.getExternalStorageDirectory(), BaseConstant.SDCARD_CACHE);
        mPhotoHelper = new BGAPhotoHelper(takePhotoDir);
    }

    @Override
    public void bindViewsListener() {
        mHeadImg.setOnClickListener(this);
        mLayout01.setOnClickListener(this);
        mLayout02.setOnClickListener(this);
        mLayout03.setOnClickListener(this);
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
            case R.id.layout_01:
                choicePhotoWrapper(this, 1, BaseConstant.SDCARD_CACHE);
                break;
            case R.id.layout_02:
                showCustomToast("用户名无法修改！");
                break;
            case R.id.layout_03:
                showDialog();
                break;


            default:
                break;
        }
    }


    public void uplaodHeadImg(File file) {
        try {

        } catch (Exception e) {

        }

        mBaseContentLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefault().post(new EBMessageVO("update_info"));
            }
        }, 1000);

    }

    public void updateNickName(String nickname) {
        if (nickname.length() == 0) {
            showCustomToast("请填写昵称再尝试");
            return;
        }


        mBaseContentLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                EventBus.getDefault().post(new EBMessageVO("update_info"));
            }
        }, 1000);

    }

    @AfterPermissionGranted(PRC_PHOTO_PICKER)
    public void choicePhotoWrapper(BaseActivity activity, int maxCount, String file) {
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
        if (EasyPermissions.hasPermissions(activity, perms)) {
            // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话就没有拍照功能
            File takePhotoDir = new File(Environment.getExternalStorageDirectory(), BaseConstant.SDCARD_CACHE);

            Intent photoPickerIntent = new BGAPhotoPickerActivity.IntentBuilder(activity)
                    .cameraFileDir(TextUtils.isEmpty(file) ? null : takePhotoDir) // 拍照后照片的存放目录，改成你自己拍照后要存放照片的目录。如果不传递该参数的话则不开启图库里的拍照功能
                    .maxChooseCount(1) // 图片选择张数的最大值
                    .selectedPhotos(null) // 当前已选中的图片路径集合
                    .pauseOnScroll(false)
//                    .selectedPhotos(mSelectList)
                    // 滚动列表时是否暂停加载图片
                    .build();
            activity.startActivityForResult(photoPickerIntent, RC_CHOOSE_PHOTO);
        } else {
            EasyPermissions.requestPermissions(activity, "图片选择需要以下权限:\n\n1.访问设备上的照片\n\n2.拍照", PRC_PHOTO_PICKER, perms);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == RC_CHOOSE_PHOTO) {
                //是否单选，单选走true 语句，多选走false语句，这么默认false
                List<String> selectedPhotos = BGAPhotoPickerActivity.getSelectedPhotos(data);
//                File file = new File(selectedPhotos.get(0));
//                mHeadImgFile = CompressHelper.getDefault(MainActivity.this).compressToFile(file);
                try {
                    startActivityForResult(mPhotoHelper.getCropIntent(mPhotoHelper.getFilePathFromUri(Uri.parse(selectedPhotos.get(0))), 200, 200), REQUEST_CODE_CROP);
                } catch (Exception e) {
                    mPhotoHelper.deleteCropFile();
                    BGAPhotoPickerUtil.show(R.string.bga_pp_not_support_crop);
                    e.printStackTrace();
                }
            } else if (requestCode == RC_PHOTO_PREVIEW) {
                // 在预览界面按返回也会回传预览界面已选择的图片集合
                List<String> selectedPhotos = BGAPhotoPickerPreviewActivity.getSelectedPhotos(data);
                try {
                    startActivityForResult(mPhotoHelper.getCropIntent(mPhotoHelper.getCameraFilePath(), 200, 200), REQUEST_CODE_CROP);
                } catch (Exception e) {
                    mPhotoHelper.deleteCameraFile();
                    mPhotoHelper.deleteCropFile();
                    BGAPhotoPickerUtil.show(R.string.bga_pp_not_support_crop);
                    e.printStackTrace();
                }
            } else if (requestCode == REQUEST_CODE_CROP) {
                BGAImage.display(mHeadImg, R.mipmap.bga_pp_ic_holder_light, mPhotoHelper.getCropFilePath(), BGABaseAdapterUtil.dp2px(200));
                File file = new File(mPhotoHelper.getCropFilePath());
                mHeadImgFile = CompressHelper.getDefault(UserInfoActivity.this).compressToFile(file);
                updateHeadImg(mHeadImgFile);

            }
        } else {
            if (requestCode == REQUEST_CODE_CROP) {
                mPhotoHelper.deleteCameraFile();
                mPhotoHelper.deleteCropFile();
            }
        }
    }

    public void updateNickName() {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("nickname", mTextView03.getText().toString())
                .addFormDataPart("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid())
                .build();
        HttpGetDataUtil.post(UserInfoActivity.this, Constant.UPDATE_USERINFO_URL, requestBody, UserInfoVO.class, UserInfoActivity.this);
    }

    public void updateHeadImg(File file) {
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid())
                .addFormDataPart("file", mHeadImgFile.getName(), RequestBody.create(MediaType.parse("image/*"), mHeadImgFile))
                .build();
        HttpGetDataUtil.post(UserInfoActivity.this, Constant.UPDATE_USERINFO_URL, requestBody, UserInfoVO.class, this);
    }

    @Override
    public void success(BaseVO vo) {
        UserInfoVO userInfoVO= (UserInfoVO) vo;
        AppApplication.getInstance().saveUserInfoVO(userInfoVO);
        EventBus.getDefault().post(new EBMessageVO("update"));
    }

    public void showDialog() {
        DialogUIUtils.init(UserInfoActivity.this);
        View rootView = View.inflate(UserInfoActivity.this, R.layout.custom_dialog_layout, null);
        final EditText nickName = rootView.findViewById(R.id.nick_name_tv);

        TextView cancelTv = rootView.findViewById(R.id.cancle_tv);
        TextView okTv = rootView.findViewById(R.id.ok_tv);
        final BuildBean buildBean = DialogUIUtils.showCustomAlert(UserInfoActivity.this, rootView);
        buildBean.show();
        cancelTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogUIUtils.dismiss(buildBean);
            }
        });
        okTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTextView03.setText(nickName.getText().toString());
                updateNickName();
                DialogUIUtils.dismiss(buildBean);
            }
        });

    }

}
