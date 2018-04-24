package com.beisheng.snatch.activity;


import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.UserInfoVO;
import com.nanchen.compresshelper.CompressHelper;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.vondear.rxtools.view.dialog.RxDialogEditSureCancel;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bingoogolapple.baseadapter.BGABaseAdapterUtil;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.imageloader.BGAImage;
import cn.bingoogolapple.photopicker.util.BGAPhotoHelper;
import cn.bingoogolapple.photopicker.util.BGAPhotoPickerUtil;
import cn.pedant.SweetAlert.SweetAlertDialog;
import de.hdodenhof.circleimageview.CircleImageView;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class UserInfoActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private static final int PRC_PHOTO_PICKER = 1;
    private static final int RC_CHOOSE_PHOTO = 1;
    private static final int RC_PHOTO_PREVIEW = 2;
    private static final int REQUEST_CODE_CROP = 3;
    private Uri resultUri;
    private UserInfoVO mUserInfo;
    private TextView mTextView01, mTextView02, mTextView03, mTextView04, mTextView05, mTextView06, mTextView07, mTextView08;
    private LinearLayout mLayout01, mLayout02, mLayout03,mLayout05,mLayout06,mLayout07;
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
        mLayout01 = getViewById(R.id.layout_01);
        mLayout02 = getViewById(R.id.layout_02);
        mLayout03 = getViewById(R.id.layout_03);
        mLayout05 = getViewById(R.id.layout_05);
        mLayout06 = getViewById(R.id.layout_06);
        mLayout07 = getViewById(R.id.layout_07);

        mTextView01 = getViewById(R.id.tv_01);
        mTextView02 = getViewById(R.id.tv_02);
        mTextView03 = getViewById(R.id.tv_03);
        mTextView04 = getViewById(R.id.tv_04);
        mTextView05 = getViewById(R.id.tv_05);
        mTextView06 = getViewById(R.id.tv_06);
        mTextView08 = getViewById(R.id.tv_08);
        mTextView07 = getViewById(R.id.tv_07);
        mHeadImg = (CircleImageView) findViewById(R.id.head_img);


        File takePhotoDir = new File(Environment.getExternalStorageDirectory(), BaseConstant.SDCARD_CACHE);
        mPhotoHelper = new BGAPhotoHelper(takePhotoDir);
    }

    public void getUserInfo() {
        if (AppApplication.getInstance().getUserInfoVO() != null) {
            if (!TextUtils.isEmpty(AppApplication.getInstance().getUserInfoVO().getData().getAvatar()))
                Picasso.with(mActivity).load(AppApplication.getInstance().getUserInfoVO().getData().getAvatar()).into(mHeadImg);
            mTextView02.setText(AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
            mTextView03.setText(AppApplication.getInstance().getUserInfoVO().getData().getNickname());
            mTextView05.setText(AppApplication.getInstance().getUserInfoVO().getData().getDefault_address());
            mTextView06.setText(AppApplication.getInstance().getUserInfoVO().getData().getWx_nickname());
            mTextView07.setText(AppApplication.getInstance().getUserInfoVO().getData().getQq_nickname());
            mTextView08.setText(AppApplication.getInstance().getUserInfoVO().getData().getUser_tel());
        }
    }

    @Override
    public void bindViewsListener() {
        mHeadImg.setOnClickListener(this);
        mLayout01.setOnClickListener(this);
        mLayout02.setOnClickListener(this);
        mLayout03.setOnClickListener(this);
        mLayout05.setOnClickListener(this);
        mLayout06.setOnClickListener(this);
        mLayout07.setOnClickListener(this);
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
        final UMShareAPI shareAPI = UMShareAPI.get(mActivity);
        switch (v.getId()) {
            case R.id.layout_01:
                choicePhotoWrapper(this, 1, BaseConstant.SDCARD_CACHE);
                break;
            case R.id.layout_02:
                showCustomToast("ID无法修改！");
                break;
            case R.id.layout_03:
                showDialog("修改昵称", "请输入昵称", 1);
                break;
            case R.id.layout_04:
                showDialog("修改性别", "请输入性别", 2);
                break;
            case R.id.layout_05:
                openActivity(AddressActivity.class);
                break;
            case R.id.layout_06:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要绑定微信码?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                shareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.WEIXIN, new UMShareListener());
                                sDialog.dismissWithAnimation();//直接消失
                            }


                        })
                        .show();

                break;
            case R.id.layout_07:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要绑定QQ吗?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                shareAPI.getPlatformInfo(mActivity, SHARE_MEDIA.QQ, new UMShareListener());
                                sDialog.dismissWithAnimation();//直接消失
                            }
                        })
                        .show();

                break;
            default:
                break;
        }
    }


    public void updateNickName(String nickname) {
        if (nickname.length() == 0) {
            showCustomToast("请填写昵称再尝试");
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        map.put("nickname", nickname);
        BSHttpUtils.postCallBack(mActivity, Constant.USER_INFO_NICKNAME_URL, map, UserInfoVO.class, UserInfoActivity.this);
    }

    public void updateSex(String nickname) {
        if (nickname.length() == 0) {
            showCustomToast("请填性别");
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        map.put("nickname", nickname);
        BSHttpUtils.postCallBack(mActivity, Constant.USER_INFO_SEX_URL, map, UserInfoVO.class, UserInfoActivity.this);
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
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
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

    public void updateHeadImg(File file) {
//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no())
//                .addFormDataPart("image", mHeadImgFile.getName(), RequestBody.create(MediaType.parse("image/*"), mHeadImgFile))
//                .build();
//        HttpGetDataUtil.post(UserInfoActivity.this, Constant.USER_INFO_HEAD_URL, requestBody, UserInfoVO.class, this);

        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        map.put("image", mHeadImgFile);
        BSHttpUtils.postFile(mActivity, Constant.USER_INFO_HEAD_URL, map, BaseVO.class, this);


    }

    @Override
    public void success(BaseVO vo) {
        showSuccessToast(vo.getDesc());
        EventBus.getDefault().post(new EBMessageVO("update_userinfo"));
        mTextView06.postDelayed(new Runnable() {
            @Override
            public void run() {
                getUserInfo();
            }
        }, 1000);
    }

    public void showDialog(String title, String hint, final int type) {
//        DialogUIUtils.init(UserInfoActivity.this);
//        View rootView = View.inflate(UserInfoActivity.this, R.layout.custom_dialog_layout, null);
//        final EditText nickName = rootView.findViewById(R.id.nick_name_tv);
//        nickName.setText(mTextView03.getText().toString());
//        TextView cancelTv = rootView.findViewById(R.id.cancle_tv);
//        TextView okTv = rootView.findViewById(R.id.ok_tv);
//        final BuildBean buildBean = DialogUIUtils.showCustomAlert(UserInfoActivity.this, rootView);
//        buildBean.show();
//        cancelTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                DialogUIUtils.dismiss(buildBean);
//            }
//        });
//        okTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mTextView03.setText(nickName.getText().toString());
//                updateNickName();
//                DialogUIUtils.dismiss(buildBean);
//            }
//        });

        final RxDialogEditSureCancel rxDialogEditTextSureCancle = new RxDialogEditSureCancel(this);//提示弹窗
        rxDialogEditTextSureCancle.setTitle(title);
        rxDialogEditTextSureCancle.getTvTitle().setBackgroundColor(ContextCompat.getColor(this, R.color.C1));
        rxDialogEditTextSureCancle.getTvTitle().setTextSize(15);
        rxDialogEditTextSureCancle.getEditText().setHint(hint);
        rxDialogEditTextSureCancle.getEditText().setTextSize(13);
        rxDialogEditTextSureCancle.getEditText().setHintTextColor(ContextCompat.getColor(this, R.color.C6));
        rxDialogEditTextSureCancle.getTvSure().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (type == 1) {
                    updateNickName(rxDialogEditTextSureCancle.getEditText().getText().toString());
                } else {
                    updateNickName(rxDialogEditTextSureCancle.getEditText().getText().toString());
                }
                rxDialogEditTextSureCancle.cancel();
            }
        });
        rxDialogEditTextSureCancle.getTvCancel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rxDialogEditTextSureCancle.cancel();
            }
        });
        rxDialogEditTextSureCancle.show();

    }

    @Override
    protected void onResume() {
        super.onResume();
        getUserInfo();
    }

    public void otherBind(String type, String openid, String nickname, String headpicurl) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", type);
        map.put("openid", openid);
        map.put("nickname", nickname);
        map.put("platform", "1");
        map.put("headpicurl", headpicurl);
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        BSHttpUtils.postCallBack(mActivity, Constant.OTHER_LOGIN_BIND_URL, map, UserInfoVO.class, this);
    }

    class UMShareListener implements Serializable, UMAuthListener {
        /**
         * @param platform 平台名称
         * @desc 授权开始的回调
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @param platform 平台名称
         * @param action   行为序号，开发者用不上
         * @param data     用户资料返回
         * @desc 授权成功的回调
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            if (platform == SHARE_MEDIA.WEIXIN) {
                otherBind("1", data.get("uid"), data.get("name"), data.get("iconurl"));
            } else {
                otherBind("2", data.get("uid"), data.get("name"), data.get("iconurl"));
            }

        }

        /**
         * @param platform 平台名称
         * @param action   行为序号，开发者用不上
         * @param t        错误原因
         * @desc 授权失败的回调
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {

        }

        /**
         * @param platform 平台名称
         * @param action   行为序号，开发者用不上
         * @desc 授权取消的回调
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {

        }
    }

}
