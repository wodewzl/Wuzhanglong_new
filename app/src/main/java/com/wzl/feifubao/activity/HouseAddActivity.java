package com.wzl.feifubao.activity;

import android.Manifest;
import android.content.Intent;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.adapter.TieAdapter;
import com.dou361.dialogui.bean.BuildBean;
import com.dou361.dialogui.bean.TieBean;
import com.dou361.dialogui.listener.DialogUIItemListener;
import com.dou361.dialogui.listener.DialogUIListener;
import com.google.gson.Gson;
import com.nanchen.compresshelper.CompressHelper;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.Button;
import com.rey.material.widget.CheckBox;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.PayResult;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.PayUtis;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.CityVO;
import com.wzl.feifubao.mode.HouseAddVO;
import com.wzl.feifubao.mode.HouseOptionVO;
import com.wzl.feifubao.mode.MyHouseVO;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerActivity;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPickerPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGASortableNinePhotoLayout;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import cn.pedant.SweetAlert.SweetAlertDialog;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class HouseAddActivity extends BaseActivity implements BGASortableNinePhotoLayout.Delegate, View.OnClickListener, PostCallback {
    private static final int PRC_PHOTO_PICKER = 1;
    private static final int RC_CHOOSE_PHOTO = 1;
    private static final int RC_PHOTO_PREVIEW = 2;
    private BGASortableNinePhotoLayout mPhotoLayout;
    public ArrayList<String> mSelectList = new ArrayList<>();
    private List<File> mOneFiles = new ArrayList<>();
    private HouseOptionVO.DataBean mOptionDataBean;
    private EditText mParams1Et, mParams3Et, mParams5Et, mParams8Et, mParams14Et, mParams15Et;
    private TextView mParams2Tv, mParams4Tv, mParams6Tv, mParams7Tv, mParams9Tv, mParams10Tv, mParams11Tv, mParams12Tv, mParams13Tv;
    private String mParams2 = "", mParams3 = "", mParams4 = "", mParams5 = "", mParams6 = "", mParams7 = "", mParams9 = "", mParams10 = "", mParams11 = "", mParams12 = "", mParams13 = "";
    private String mType = "2";
    private ArrayList<CityVO.DataBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<CityVO.DataBean.CitysBean>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<CityVO.DataBean.CitysBean.DistrictsBean>>> options3Items = new ArrayList<>();
    private String mProvinceId = "", mCityId = "", mAreaId = "";
    private String mHouseId = "";
    private BottomSheetDialog mDialog;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_add_house);
    }

    @Override
    public void initView() {

        mBaseOkTv.setText("发布");
        mPhotoLayout = getViewById(R.id.phone_layout);
        mPhotoLayout.setMaxItemCount(9);
        mPhotoLayout.setEditable(true);//有加号，有删除，可以点加号选择，false没有加号，点其他按钮选择，也没有删除
        mPhotoLayout.setPlusEnable(true);//有加号，可以点加号选择，false没有加号，点其他按钮选择
        mPhotoLayout.setSortable(true);//排序
        mParams2Tv = getViewById(R.id.params2_tv);

        mParams4Tv = getViewById(R.id.params4_tv);

        mParams6Tv = getViewById(R.id.params6_tv);
        mParams7Tv = getViewById(R.id.params7_tv);
        mParams9Tv = getViewById(R.id.params9_tv);
        mParams10Tv = getViewById(R.id.params10_tv);
        mParams11Tv = getViewById(R.id.params11_tv);
        mParams12Tv = getViewById(R.id.params12_tv);
        mParams13Tv = getViewById(R.id.params13_tv);
        mParams1Et = getViewById(R.id.params1_et);
        mParams8Et = getViewById(R.id.params8_et);
        mParams3Et = getViewById(R.id.params3_et);
        mParams5Et = getViewById(R.id.params5_et);
        mParams14Et = getViewById(R.id.params14_et);
        mParams15Et = getViewById(R.id.params15_et);


    }

    @Override
    public void bindViewsListener() {
        mPhotoLayout.setDelegate(this);
        mParams2Tv.setOnClickListener(this);
        mParams4Tv.setOnClickListener(this);
        mParams6Tv.setOnClickListener(this);
        mParams7Tv.setOnClickListener(this);
        mParams9Tv.setOnClickListener(this);
        mParams10Tv.setOnClickListener(this);
        mParams11Tv.setOnClickListener(this);
        mParams12Tv.setOnClickListener(this);
        mParams13Tv.setOnClickListener(this);
        mBaseOkTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        HttpGetDataUtil.get(mActivity, this, Constant.HOUSE_LIST_OPTION_URL, map, HouseOptionVO.class);
        HttpGetDataUtil.get(mActivity, this, Constant.CITY_URL, map, CityVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof HouseOptionVO) {
            HouseOptionVO houseOptionVO = (HouseOptionVO) vo;
            mOptionDataBean = houseOptionVO.getData();
        } else {
            CityVO cityVO = (CityVO) vo;
            options1Items = (ArrayList<CityVO.DataBean>) cityVO.getData();

            for (int i = 0; i < options1Items.size(); i++) {//遍历省份
                ArrayList<CityVO.DataBean.CitysBean> CityList = new ArrayList<>();//该省的城市列表（第二级）
                ArrayList<ArrayList<CityVO.DataBean.CitysBean.DistrictsBean>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

                for (int c = 0; c < options1Items.get(i).getCitys().size(); c++) {//遍历该省份的所有城市
                    CityVO.DataBean.CitysBean city = options1Items.get(i).getCitys().get(c);
                    CityList.add(city);//添加城市
                    ArrayList<CityVO.DataBean.CitysBean.DistrictsBean> City_AreaList = new ArrayList<>();//该城市的所有地区列表
                    //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                    if (options1Items.get(i).getCitys().get(c).getDistricts() == null
                            || options1Items.get(i).getCitys().get(c).getDistricts().size() == 0) {
                        City_AreaList.add(new CityVO.DataBean.CitysBean.DistrictsBean());
                    } else {
                        for (int d = 0; d < options1Items.get(i).getCitys().get(c).getDistricts().size(); d++) {//该城市对应地区所有数据
                            CityVO.DataBean.CitysBean.DistrictsBean districts = options1Items.get(i).getCitys().get(c).getDistricts().get(d);
                            City_AreaList.add(districts);//添加该城市所有地区数据
                        }
                    }
                    Province_AreaList.add(City_AreaList);//添加该省所有地区数据
                }
                options2Items.add(CityList);
                options3Items.add(Province_AreaList);
            }
        }

        MyHouseVO.DataBean.HouseBean bean = (MyHouseVO.DataBean.HouseBean) this.getIntent().getSerializableExtra("bean");
        String type = this.getIntent().getStringExtra("type");
        if ("2".equals(type)) {
            mHouseId = bean.getHouse_id();
            mBaseTitleTv.setText("编辑租房信息");
            mParams1Et.setText(bean.getHouse_name());
            mParams2Tv.setText(bean.getRenting_style());
            mParams2 = bean.getRenting_style_id();
            mParams3Et.setText(bean.getHouse_price());
            mParams3 = bean.getHouse_price();
            mParams4Tv.setText(bean.getApartment());
            mParams4 = bean.getClass_id();
            mParams5Et.setText(bean.getHouse_area());
            mParams5 = bean.getHouse_area();
            mParams6Tv.setText(bean.getHouse_type());
            mParams6 = bean.getHouse_type();
            mParams7Tv.setText(bean.getHouse_face());
            mParams7 = bean.getHouse_face();
            mParams8Et.setText(bean.getHouse_floor());

            mParams9Tv.setText(bean.getHouse_decorate());
            mParams9 = bean.getHouse_decorate();
            mParams10 = bean.getPay_class_id();
            for (int i = 0; i < mOptionDataBean.getFukuan().size(); i++) {
                if (bean.getPay_class_id().equals(mOptionDataBean.getFukuan().get(i).getClass_id())) {
                    mParams10Tv.setText(mOptionDataBean.getFukuan().get(i).getName());
                }
            }
            mParams11 = bean.getHouse_language();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < bean.getHouse_language().split(",").length; i++) {
                for (int j = 0; j < mOptionDataBean.getLanguage().size(); j++) {
                    if (bean.getHouse_language().split(",")[i].equals(mOptionDataBean.getLanguage().get(i).getClass_id())) {
                        sb.append(mOptionDataBean.getLanguage().get(i).getName()).append("、");
                        ;
                        break;
                    }
                }
            }

            mParams11Tv.setText(sb.toString().substring(0, sb.toString().length() - 1));
            mParams13Tv.setText(bean.getArea());
            mParams14Et.setText(bean.getHouse_phone());
            mParams15Et.setText(bean.getHouse_details());

            mCityId = bean.getCity_id();
            mProvinceId = bean.getProvince_id();

            mParams13Tv.setText(bean.getArea());
        } else {
            mBaseTitleTv.setText("发布租房信息");
        }


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
            File newFile = CompressHelper.getDefault(HouseAddActivity.this).compressToFile(file);
            mOneFiles.add(newFile);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.params2_tv:
                mType = "2";
                selectData();
                break;

            case R.id.params4_tv:
                mType = "4";
                selectData();
                break;

            case R.id.params6_tv:
                mType = "6";
                selectData();
                break;
            case R.id.params7_tv:
                mType = "7";
                selectData();
                break;
            case R.id.params9_tv:
                mType = "9";
                selectData();
                break;
            case R.id.params10_tv:
                mType = "10";
                selectData();
                break;
            case R.id.params11_tv:
                mType = "11";
//                selectData();
                final String[] langue = new String[mOptionDataBean.getTag().size()];

                for (int i = 0; i < mOptionDataBean.getLanguage().size(); i++) {
//                    datas.add(new TieBean(mOptionDataBean.getTag().get(i).getName(), BaseCommonUtils.parseInt(mOptionDataBean.getTag().get(i).getClass_id())));
                    langue[i] = mOptionDataBean.getLanguage().get(i).getName();
                }

                final boolean[] choseDefault = new boolean[]{false, false, false};
                DialogUIUtils.showMdMultiChoose(HouseAddActivity.this, "选择语种", langue, choseDefault, new DialogUIListener() {
                    @Override
                    public void onPositive() {
                        StringBuffer name = new StringBuffer();
                        StringBuffer id = new StringBuffer();
                        for (int i = 0; i < choseDefault.length; i++) {
                            if (choseDefault[i]) {
                                name.append(langue[i]).append("、");
                                id.append(mOptionDataBean.getLanguage().get(i).getClass_id()).append(",");
                            }
                        }
                        mParams11Tv.setText(name.toString().substring(0, name.length() - 1));
                        mParams11 = id.toString().substring(0, id.length() - 1);
                    }

                    @Override
                    public void onNegative() {

                    }
                }).show();
                break;
            case R.id.params12_tv:
                mType = "12";
//                selectData();


                break;
            case R.id.params13_tv:
                //条件选择器
                OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3, View v) {
                        //返回的分别是三个级别的选中位置
                        String tx = options1Items.get(options1).getProvince_name()
                                + options2Items.get(options1).get(option2).getCity_name()
                                + options3Items.get(options1).get(option2).get(options3).getDistrict_name();
                        mParams13Tv.setText(tx);
                        mProvinceId = options1Items.get(options1).getProvince_id();
                        mCityId = options2Items.get(options1).get(option2).getCity_id();

                        mAreaId = options3Items.get(options1).get(option2).get(options3).getDistrict_id();
                    }
                }).build();
                pvOptions.setPicker(options1Items, options2Items, options3Items);
                pvOptions.show();

                break;

            case R.id.base_ok_tv:
                new SweetAlertDialog(mActivity, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要发布房源吗?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                commit();
                                sDialog.dismissWithAnimation();//直接消失
                            }
                        })
                        .show();

                break;
            default:
                break;
        }


    }


    public void selectData() {
        final List<TieBean> datas = new ArrayList<TieBean>();
        switch (mType) {
            case "2":
                for (int i = 0; i < mOptionDataBean.getRentingStyle().size(); i++) {
                    datas.add(new TieBean(mOptionDataBean.getRentingStyle().get(i).getName(), BaseCommonUtils.parseInt(mOptionDataBean.getRentingStyle().get(i).getClass_id())));
                }
                break;
            case "3":
//                for (int i = 0; i <mOptionDataBean.getRentingStyle().size() ; i++) {
//                    datas.add(new TieBean(mOptionDataBean.getRentingStyle().get(i).getName(),BaseCommonUtils.parseInt(mOptionDataBean.getRentingStyle().get(i).getClass_id())));
//                }
                break;
            case "4":
                for (int i = 0; i < mOptionDataBean.getHuxing().size(); i++) {
                    datas.add(new TieBean(mOptionDataBean.getHuxing().get(i).getName(), BaseCommonUtils.parseInt(mOptionDataBean.getHuxing().get(i).getClass_id())));
                }
                break;
            case "5":
//                for (int i = 0; i <mOptionDataBean.getHuxing().size() ; i++) {
//                    datas.add(new TieBean(mOptionDataBean.getRentingStyle().get(i).getName(),BaseCommonUtils.parseInt(mOptionDataBean.getRentingStyle().get(i).getClass_id())));
//                }
                break;
            case "6":
                for (int i = 0; i < mOptionDataBean.getHouseStyle().size(); i++) {
                    datas.add(new TieBean(mOptionDataBean.getHouseStyle().get(i).getName(), BaseCommonUtils.parseInt(mOptionDataBean.getHouseStyle().get(i).getClass_id())));
                }
                break;
            case "7":
                for (int i = 0; i < mOptionDataBean.getPosition().size(); i++) {
                    datas.add(new TieBean(mOptionDataBean.getPosition().get(i).getName(), BaseCommonUtils.parseInt(mOptionDataBean.getPosition().get(i).getClass_id())));
                }
                break;
            case "9":
                for (int i = 0; i < mOptionDataBean.getDecorateStyle().size(); i++) {
                    datas.add(new TieBean(mOptionDataBean.getDecorateStyle().get(i).getName(), BaseCommonUtils.parseInt(mOptionDataBean.getDecorateStyle().get(i).getClass_id())));
                }
                break;

            case "10":
                for (int i = 0; i < mOptionDataBean.getFukuan().size(); i++) {
                    datas.add(new TieBean(mOptionDataBean.getFukuan().get(i).getName(), BaseCommonUtils.parseInt(mOptionDataBean.getFukuan().get(i).getClass_id())));
                }
                break;
            case "11":
                for (int i = 0; i < mOptionDataBean.getLanguage().size(); i++) {
                    datas.add(new TieBean(mOptionDataBean.getLanguage().get(i).getName(), BaseCommonUtils.parseInt(mOptionDataBean.getLanguage().get(i).getClass_id())));
                }
                break;
            case "12":
                for (int i = 0; i < mOptionDataBean.getTag().size(); i++) {
                    datas.add(new TieBean(mOptionDataBean.getTag().get(i).getName(), BaseCommonUtils.parseInt(mOptionDataBean.getTag().get(i).getClass_id())));
                }
                break;
            default:
                break;
        }

        if (datas.size() == 0)
            return;
        final TieAdapter adapter = new TieAdapter(this, datas, true);
        final BuildBean buildBean = DialogUIUtils.showMdBottomSheet(mActivity, true, "", datas, 0, new DialogUIItemListener() {
            @Override
            public void onItemClick(CharSequence text, int position) {
                String str = (String) text;
                switch (mType) {
                    case "2":
                        mParams2Tv.setText(str);
                        mParams2 = datas.get(position).getId() + "";
                        break;
                    case "3":

                        break;
                    case "4":
                        mParams4Tv.setText(str);
                        mParams4 = datas.get(position).getId() + "";
                        break;
                    case "5":

                        break;
                    case "6":
                        mParams6Tv.setText(str);
                        mParams6 = str;
                        break;
                    case "7":
                        mParams7Tv.setText(str);
                        mParams7 = str;
                        break;
                    case "9":
                        mParams9Tv.setText(str);
                        mParams9 = str;
                        break;

                    case "10":
                        mParams10Tv.setText(str);
                        mParams10 = datas.get(position).getId() + "";
                        break;
                    case "11":
                        mParams11Tv.setText(str);
                        mParams11 = datas.get(position).getId() + "";
                        break;
                    case "12":
                        mParams12Tv.setText(str);
                        mParams12 = str;
                        break;
                    default:
                        break;
                }

            }
        });
        buildBean.mAdapter = adapter;
        buildBean.show();
    }

    public void commit() {

        MultipartBody.Builder requestBody = new MultipartBody.Builder().setType(MultipartBody.FORM);
        requestBody
                .addFormDataPart("house_id", mHouseId)
                .addFormDataPart("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid())
                .addFormDataPart("house_name", mParams1Et.getText().toString())
                .addFormDataPart("house_price", mParams3Et.getText().toString())
//                .addFormDataPart("house_tag", mParams12)
                .addFormDataPart("class_id", mParams4)
                .addFormDataPart("pay_class_id", mParams10)
                .addFormDataPart("house_area", mParams5Et.getText().toString())
                .addFormDataPart("province_id", mProvinceId)
                .addFormDataPart("city_id", mCityId)
                .addFormDataPart("house_face", mParams7)
                .addFormDataPart("house_floor", mParams8Et.getText().toString())
                .addFormDataPart("house_decorate", mParams9)
                .addFormDataPart("house_type", mParams6)
                .addFormDataPart("house_details", mParams15Et.getText().toString())
                .addFormDataPart("house_phone", mParams14Et.getText().toString())
                .addFormDataPart("house_language", mParams11)
                .addFormDataPart("renting_style_id", mParams2);

        for (int i = 0; i < mOneFiles.size(); i++) {
            requestBody.addFormDataPart("house_pic " + i, mOneFiles.get(i).getName(), RequestBody.create(MediaType.parse("image/*"), mOneFiles.get(i)));
        }
        MultipartBody rb = requestBody.build();
        HttpGetDataUtil.post(HouseAddActivity.this, Constant.HOUSE_ADD_URL, rb, HouseAddVO.class, this);
    }

    @Override
    public void success(BaseVO vo) {
        if (vo instanceof HouseAddVO) {
            HouseAddVO.DataBean dataBean = ((HouseAddVO) vo).getData();
            showPayDialog(dataBean);
        }
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
                                        mActivity.openActivity(MyHouseActivity.class);
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

    public void showPayDialog(final HouseAddVO.DataBean vo) {
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
}
