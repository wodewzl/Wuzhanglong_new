package com.beisheng.snatch.activity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.CityVO;
import com.bigkoo.pickerview.OptionsPickerView;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;

public class AddressAddActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private CityVO mCityVO;
    private ArrayList<CityVO> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<CityVO>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<CityVO>>> options3Items = new ArrayList<>();
    private String mProvinceId, mCityId, mAreaId;
    private EditText mNameEt, mPhoneEt, mDescEt;
    private TextView mAddressTv;
    private Button mButton;
    private ImageView mLocationImg;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.address_add_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("新增地址");
        mNameEt = getViewById(R.id.name_et);
        mPhoneEt = getViewById(R.id.phone_et);
        mDescEt = getViewById(R.id.desc_et);
        mAddressTv = getViewById(R.id.address_tv);
        mButton = getViewById(R.id.add_bt);
        mLocationImg = getViewById(R.id.location_img);

    }

    @Override
    public void bindViewsListener() {
        mButton.setOnClickListener(this);
        mAddressTv.setOnClickListener(this);
        mLocationImg.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        HttpGetDataUtil.get(mActivity, this, Constant.GET_CITY_URL, map, CityVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        CityVO cityVO = (CityVO) vo;
        mCityVO = cityVO.getData();
        options1Items = mCityVO.getList();

        for (int i = 0; i < options1Items.size(); i++) {//遍历省份
            ArrayList<CityVO> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<CityVO>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < options1Items.get(i).getCitys().size(); c++) {//遍历该省份的所有城市
                CityVO city = options1Items.get(i).getCitys().get(c);
                CityList.add(city);//添加城市
                ArrayList<CityVO> City_AreaList = new ArrayList<>();//该城市的所有地区列表
                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (options1Items.get(i).getCitys().get(c).getDistricts() == null
                        || options1Items.get(i).getCitys().get(c).getDistricts().size() == 0) {
                    City_AreaList.add(new CityVO());
                } else {
                    for (int d = 0; d < options1Items.get(i).getCitys().get(c).getDistricts().size(); d++) {//该城市对应地区所有数据
                        CityVO districts = options1Items.get(i).getCitys().get(c).getDistricts().get(d);
                        City_AreaList.add(districts);//添加该城市所有地区数据
                    }
                }
                Province_AreaList.add(City_AreaList);//添加该省所有地区数据
            }
            options2Items.add(CityList);
            options3Items.add(Province_AreaList);
        }
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
            case R.id.add_bt:
                if (TextUtils.isEmpty(mNameEt.getText().toString())) {
                    showCustomToast("请填写收货人姓名");
                    return;
                }
                if (TextUtils.isEmpty(mPhoneEt.getText().toString())) {
                    showCustomToast("请填写收货人电话");
                    return;
                }
                if (TextUtils.isEmpty(mAddressTv.getText().toString())) {
                    showCustomToast("请选择收货区域");
                    return;
                }
                if (TextUtils.isEmpty(mDescEt.getText().toString())) {
                    showCustomToast("请填写详细地址");
                    return;
                }

                showProgressDialog();
                HashMap<String, Object> map = new HashMap<>();
                String mUrl = Constant.ADDRESS_ADD_URL;
                if (AppApplication.getInstance().getUserInfoVO() != null)
                    map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                map.put("consigner", mNameEt.getText().toString());
                map.put("mobile", mPhoneEt.getText().toString());
                map.put("province", mProvinceId);
                map.put("city", mCityId);
                map.put("district", mAreaId);
                map.put("area_info", mAddressTv.getText().toString());
                map.put("address", mDescEt.getText().toString());
                BSHttpUtils.postCallBack(this, mUrl, map, BaseVO.class, this);
                break;
            case R.id.address_tv:
                //条件选择器
                OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3, View v) {
                        //返回的分别是三个级别的选中位置
                        String tx = options1Items.get(options1).getProvince_name()
                                + options2Items.get(options1).get(option2).getCity_name()
                                + options3Items.get(options1).get(option2).get(options3).getDistrict_name();
                        mAddressTv.setText(tx);

                        mProvinceId = options1Items.get(options1).getProvince_id();
                        mCityId = options2Items.get(options1).get(option2).getCity_id();
                        mAreaId = options3Items.get(options1).get(option2).get(options3).getDistrict_id();
                    }
                }).build();
                pvOptions.setPicker(options1Items, options2Items, options3Items);
                pvOptions.show();
                break;
            default:
                break;
        }
    }

    @Override
    public void success(BaseVO vo) {
        showSuccessToast(vo.getDesc());
        EventBus.getDefault().post(new EBMessageVO("refresh"));
        this.finish();
    }
}
