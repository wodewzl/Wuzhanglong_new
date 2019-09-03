package com.wzl.feifubao.activity;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.application.AppApplication;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.CityVO;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.HashMap;

public class AddressAddActivity extends BaseActivity implements View.OnClickListener ,PostCallback {
    private EditText mEt01, mEt02, mEt04;
    private TextView mTv03;
    private CityVO mCityVO;
    private Button mAddBt;

    private ArrayList<CityVO.DataBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<CityVO.DataBean.CitysBean>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<CityVO.DataBean.CitysBean.DistrictsBean>>> options3Items = new ArrayList<>();
    private String mProvinceId, mCityId, mAreaId;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.address_add_activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void initView() {
        mBaseTitleTv.setText("新增地址");
        mEt01 = getViewById(R.id.et_01);
        mEt02 = getViewById(R.id.et_02);
        mTv03 = getViewById(R.id.tv_03);
        mEt04 = getViewById(R.id.et_04);
        mAddBt = getViewById(R.id.add_bt);
        mAddBt.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.colorAccent, R.color.colorAccent));
    }

    @Override
    public void bindViewsListener() {
        mTv03.setOnClickListener(this);
        mAddBt.setOnClickListener(this);
    }

    @Override
    public void getData() {

        HashMap<String, Object> map = new HashMap<>();
        HttpGetDataUtil.get(mActivity, this, Constant.CITY_URL, map, CityVO.class);

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
                                + "-"+options2Items.get(options1).get(option2).getCity_name()
                                + "-"+options3Items.get(options1).get(option2).get(options3).getDistrict_name();
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
                HashMap<String, Object> map = new HashMap<>();
                String mUrl = Constant.ADDRESS_ADD_URL;
                map.put("uid",AppApplication.getInstance().getUserInfoVO().getData().getUid());
                map.put("consigner", mEt01.getText().toString());
                map.put("phone", mEt02.getText().toString());
                map.put("mobile", mEt02.getText().toString());
                map.put("province", mProvinceId);
                map.put("city", mCityId);
                map.put("district", mAreaId);
//                map.put("area_info", mTv03.getText().toString());
                map.put("address", mEt04.getText().toString());
                map.put("is_default", "1");
                HttpGetDataUtil.post(mActivity,  Constant.ADDRESS_ADD_URL, map, this);
                break;
            default:
                break;
        }
    }


    @Override
    public void success(BaseVO vo) {
        if(BaseConstant.RESULT_SUCCESS_CODE.equals(vo.getCode())){
            EventBus.getDefault().post(new EBMessageVO("refresh"));
            showCustomToast("提交成功");
            mBaseHeadLayout.postDelayed(new Runnable() {
                @Override
                public void run() {
                    AddressAddActivity.this.finish();
                }
            },1000);
        }else{
            showCustomToast("提交失败");
        }
    }
}
