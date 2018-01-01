package com.wzl.feifubao.activity;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.mode.AddressVO;
import com.wzl.feifubao.mode.CityVO;

import java.util.ArrayList;

public class AddressEditActivity extends BaseActivity implements View.OnClickListener {
    private EditText mEt01, mEt02, mEt04;
    private TextView mTv03;
    private CityVO mCityVO;
    private Button mAddBt;

    private ArrayList<CityVO.DataBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<CityVO.DataBean.CitysBean>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<CityVO.DataBean.CitysBean.DistrictsBean>>> options3Items = new ArrayList<>();
    private String mProvinceId, mCityId, mAreaId, mAddressId, mIsDefault;


    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.address_edit_activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initView() {
        mBaseTitleTv.setText("修改地址");
        mEt01 = getViewById(R.id.et_01);
        mEt02 = getViewById(R.id.et_02);
        mTv03 = getViewById(R.id.tv_03);
        mEt04 = getViewById(R.id.et_04);
        mAddBt = getViewById(R.id.add_bt);
        mAddBt.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.C7, R.color.C7));

        Intent intent = this.getIntent();
        AddressVO vo = (AddressVO) intent.getSerializableExtra("address");
        mEt01.setText(vo.getTrue_name());
        mEt02.setText(vo.getMob_phone());
        mTv03.setText(vo.getArea_info());
        mEt04.setText(vo.getAddress());
        mAddressId = vo.getAddress_id();
        mIsDefault = vo.getIs_default();
    }

    @Override
    public void bindViewsListener() {
        mTv03.setOnClickListener(this);
        mAddBt.setOnClickListener(this);
    }

    @Override
    public void getData() {
//        RequestParams paramsMap = new RequestParams();
//        String mUrl = Constant.GET_CITY_URL;
//        HttpClientUtil.get(mActivity, mThreadUtil, mUrl, paramsMap, CityVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        CityVO cityVO = (CityVO) vo;
        options1Items = (ArrayList<CityVO.DataBean>) cityVO.getData();

        for (int i = 0; i < options1Items.size(); i++) {//遍历省份
            ArrayList<CityVO.DataBean.CitysBean> CityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<CityVO.DataBean.CitysBean.DistrictsBean>> Province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            for (int c = 0; c < options1Items.get(i).getCitys().size(); c++) {//遍历该省份的所有城市
                CityVO.DataBean.CitysBean city = options1Items.get(i).getCitys().get(c);
                CityList.add(city);//添加城市
                ArrayList<  CityVO.DataBean.CitysBean.DistrictsBean > City_AreaList = new ArrayList<>();//该城市的所有地区列表
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

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_03:
                //条件选择器
                OptionsPickerView pvOptions = new OptionsPickerView.Builder(this, new OptionsPickerView.OnOptionsSelectListener() {
                    @Override
                    public void onOptionsSelect(int options1, int option2, int options3, View v) {
                        //返回的分别是三个级别的选中位置
                        String tx = options1Items.get(options1).getProvince_name()
                                + options2Items.get(options1).get(option2).getCity_name()
                                + options3Items.get(options1).get(option2).get(options3).getDistrict_name();
                        mTv03.setText(tx);

                        mProvinceId = options1Items.get(options1).getProvince_id();
                        mCityId = options2Items.get(options1).get(option2).getCity_id();
                        mAreaId = options3Items.get(options1).get(option2).get(options3).getDistrict_id();
                    }
                }).build();
                pvOptions.setPicker(options1Items, options2Items, options3Items);
                pvOptions.show();
                break;
            case R.id.add_bt:
                showProgressDialog();
//                RequestParams paramsMap = new RequestParams();
//                String mUrl = Constant.EDIT_ADDRESS_URL;
//                if (AppApplication.getInstance().getUserInfoVO() != null)
//                    paramsMap.put("key", AppApplication.getInstance().getUserInfoVO().getKey());
//                paramsMap.put("address_id", mAddressId);
//                paramsMap.put("true_name", mEt01.getText().toString());
//                paramsMap.put("mob_phone", mEt02.getText().toString());
//                paramsMap.put("province_id", mProvinceId);
//                paramsMap.put("city_id", mCityId);
//                paramsMap.put("area_id", mAreaId);
//                paramsMap.put("area_info", mTv03.getText().toString());
//                paramsMap.put("address", mEt04.getText().toString());
//                paramsMap.put("is_default", mIsDefault);
//                HttpClientUtil.post(mActivity, this, mUrl, paramsMap, null, "2");
                break;
            default:
                break;
        }

    }
}
