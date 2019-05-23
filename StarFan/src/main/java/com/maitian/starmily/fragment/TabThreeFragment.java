package com.maitian.starmily.fragment;


import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.maitian.starmily.R;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.MyIdolsVO;
import com.maitian.starmily.model.UpTokenVO;
import com.qiniu.android.http.ResponseInfo;
import com.qiniu.android.storage.UpCompletionHandler;
import com.qiniu.android.storage.UploadManager;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.PayInfoVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.JsonUtil;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;
import com.zhy.view.flowlayout.TagView;

import org.json.JSONObject;

import java.io.File;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class TabThreeFragment extends BaseFragment implements OnClickListener, PostCallback, Serializable, BGASortableNinePhotoLayout.Delegate, TagFlowLayout.OnTagClickListener {
    public BaseActivity mActivity;
    private static final int PRC_PHOTO_PICKER = 1;
    private static final int RC_PHOTO_PREVIEW = 2;
    private static final int RC_CHOOSE_PHOTO = 3;
    private BGASortableNinePhotoLayout mPhotoLayout;
    public ArrayList<String> mSelectList = new ArrayList<>();
    private List<File> mOneFiles = new ArrayList<>();
    private TagFlowLayout mFlowLayout;
    private String mToken, mMyIdlosId;
    private EditText mContentEt;
    private MyIdolsVO mMyIdlos;
    private StringBuffer mResultSb = new StringBuffer();
    private ArrayList<Integer> mMyIdlosIdList = new ArrayList<>();
    private TextView mOkTv;

    //登录
    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_three_fragment);
    }

    @Override
    public void initView(View view) {
        mActivity = (BaseActivity) this.getActivity();
        mPhotoLayout = getViewById(R.id.photo_layout);
        mFlowLayout = getViewById(R.id.flow_layout);
        mContentEt = getViewById(R.id.content_et);
        mOkTv = getViewById(R.id.ok_tv);
    }

    @Override
    public void bindViewsListener() {
        mPhotoLayout.setDelegate(this);
        mFlowLayout.setOnTagClickListener(this);
        mOkTv.setOnClickListener(this);
    }


    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", "4338");
        StartHttpUtils.get(mActivity, this, Constant.MY_IDOLS, map, MyIdolsVO.class);
        HashMap<String, Object> mapToken = new HashMap<>();
        StartHttpUtils.get(mActivity, this, Constant.UP_TOKEN, mapToken, UpTokenVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof MyIdolsVO) {
            mMyIdlos = (MyIdolsVO) vo;
            List<MyIdolsVO.ObjBean> myIdolsList = mMyIdlos.getObj();
            mFlowLayout.setAdapter(new TagAdapter<MyIdolsVO.ObjBean>(myIdolsList) {
                @Override
                public View getView(FlowLayout parent, final int position, MyIdolsVO.ObjBean objBean) {
                    final TextView tv = new TextView(mActivity);
                    tv.setPadding(15, 10, 15, 10);
                    tv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 22, R.color.C3, R.color.C3));
                    tv.setTextColor(ContextCompat.getColor(mActivity, R.color.C5));
                    tv.setText(objBean.getIdolName());
                    return tv;
                }
            });
        } else {
            UpTokenVO upTokenVO = (UpTokenVO) vo;
            mToken = upTokenVO.getObj();
        }

    }

    @Override
    public void noData(BaseVO vo) {
        showView();
    }

    @Override
    public void noNet() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ok_tv:
                mActivity.showProgressDialog();
                uploadeFile();
                break;
            default:
                break;
        }
    }

    @Override
    public void success(BaseVO vo) {
        System.out.println("=============");
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
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
        startActivityForResult(photoPickerPreviewIntent, PRC_PHOTO_PICKER);
    }

    @Override
    public void onNinePhotoItemExchanged(BGASortableNinePhotoLayout sortableNinePhotoLayout, int fromPosition, int toPosition, ArrayList<String> models) {

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
            startActivityForResult(photoPickerIntent, RC_CHOOSE_PHOTO);
        } else {
            EasyPermissions.requestPermissions(activity, "图片选择需要以下权限:\n\n1.访问设备上的照片\n\n2.拍照", PRC_PHOTO_PICKER, perms);
        }
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
//            File newFile = CompressHelper.getDefault(mActivity).compressToFile(file);
            mOneFiles.add(file);
        }
    }

    @Override
    public boolean onTagClick(View view, int position, FlowLayout parent) {
        TagView tagView = (TagView) view;
        TextView tv = (TextView) tagView.getChildAt(position);

        tv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 22, R.color.colorAccent, R.color.color_FAD6D6));
        tv.setTextColor(ContextCompat.getColor(mActivity, R.color.colorAccent));
        int myIdlosId = mMyIdlos.getObj().get(position).getId();
        if (!mMyIdlosIdList.contains(myIdlosId)) {
            mMyIdlosIdList.add(myIdlosId);
        }
        return false;
    }

    public void uploadeFile() {
        mResultSb.setLength(0);
        UploadManager uploadManager = new UploadManager();
        // 设置图片名字
        for (int i = 0; i < mOneFiles.size(); i++) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            String key = "icon_" + sdf.format(new Date());
            String picPath = mOneFiles.get(i).getPath();
            //Auth.create(AccessKey, SecretKey).uploadToken("zhongshan-avatar")，这句就是生成token
            uploadManager.put(picPath, key, mToken, new UpCompletionHandler() {
                @Override
                public void complete(String key, ResponseInfo info, JSONObject res) {
                    // info.error中包含了错误信息，可打印调试
                    // 上传成功后将key值上传到自己的服务器
                    mResultSb.append(key);
                    if (mResultSb.toString().split(",").length < mOneFiles.size()) {
                        mResultSb.append(",");
                    }

                    if (mResultSb.toString().split(",").length == mOneFiles.size()) {
                        pushPost();
                    }
                }
            }, null);
        }


    }

    public void pushPost() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", "4338");
        map.put("content", mContentEt.getText().toString());
        map.put("imgs", mResultSb.toString());
        map.put("idolIds", JsonUtil.toJson(mMyIdlosIdList));
        map.put("title", "");
        StartHttpUtils.postCallBack(mActivity, Constant.SAVE_TOPIC, map, PayInfoVO.class, this);
    }
}
