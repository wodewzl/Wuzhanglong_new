package com.beisheng.snatch.activity;

import android.Manifest;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.AddressVO;
import com.beisheng.snatch.model.CityVO;
import com.bigkoo.pickerview.OptionsPickerView;
import com.google.gson.Gson;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;

import org.greenrobot.eventbus.EventBus;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class AddressAddActivity extends BaseActivity implements View.OnClickListener, PostCallback ,EasyPermissions.PermissionCallbacks  {
    private CityVO mCityVO;
    private ArrayList<CityVO> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<CityVO>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<CityVO>>> options3Items = new ArrayList<>();
    private String mProvince, mCity, mArea;
    private EditText mNameEt, mPhoneEt, mDescEt;
    private TextView mAddressTv;
    private Button mButton;
    private ImageView mLocationImg;
    private RelativeLayout rl_select_user;
    private String address_info;
    private AddressVO.DataBean.ListBean listBean;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.address_add_activity);
    }

    @Override
    public void initView() {

        mNameEt = getViewById(R.id.name_et);
        mPhoneEt = getViewById(R.id.phone_et);
        mDescEt = getViewById(R.id.desc_et);
        mAddressTv = getViewById(R.id.address_tv);
        mButton = getViewById(R.id.add_bt);
        mLocationImg = getViewById(R.id.location_img);

        rl_select_user = getViewById(R.id.rl_select_user);


        address_info = getIntent().getStringExtra("address_info");
        if (TextUtils.isEmpty(address_info)){
            mBaseTitleTv.setText("新增地址");
            mButton.setText("添加新地址");
        }else {
            mBaseTitleTv.setText("编辑地址");
            mButton.setText("保存修改");

            Gson gson=new Gson();
            listBean = gson.fromJson(address_info, AddressVO.DataBean.ListBean.class);

            mNameEt.setText(listBean.getConsigner());
            mPhoneEt.setText(listBean.getMobile());
            mAddressTv.setText(listBean.getProvince()+listBean.getCity()+listBean.getDistrict());
            mDescEt.setText(listBean.getAddress());

            mProvince=listBean.getProvince();
            mCity=listBean.getCity();
            mArea=listBean.getDistrict();


        }

    }

    @Override
    public void bindViewsListener() {
        mButton.setOnClickListener(this);
        mAddressTv.setOnClickListener(this);
        mLocationImg.setOnClickListener(this);
        rl_select_user.setOnClickListener(this);
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
               String name= mNameEt.getText().toString();

                if (TextUtils.isEmpty(name)) {
                    showCustomToast("请填写收货人姓名");
                    return;
                }

                /**
                 * 收货人姓名不要少于2个字
                 */
                if (name.length()<2){

                    showCustomToast("收货人姓名不要少于2个字");

                    return;
                }

                String phone = mPhoneEt.getText().toString();

                if (TextUtils.isEmpty(phone)) {
                    showCustomToast("请填写收货人电话");
                    return;
                }

                /**
                 * 手机号位数判断
                 */
                if (phone.length()!=11){

                    showCustomToast("手机号格式不正确");
                    return;

                }



                if (TextUtils.isEmpty(mAddressTv.getText().toString())) {
                    showCustomToast("请选择收货区域");
                    return;
                }


                String descArea = mDescEt.getText().toString();

                if (TextUtils.isEmpty(descArea)) {
                    showCustomToast("请填写详细地址");
                    return;
                }

                /**
                 * 详细地址不少于5个
                 */
                if (descArea.length()<5){
                    showCustomToast("详细地址请不要少于5个字");
                    return;

                }


                showProgressDialog();
                HashMap<String, Object> map = new HashMap<>();


                String mUrl;
                if (TextUtils.isEmpty(address_info)){
                     mUrl = Constant.ADDRESS_ADD_URL;
                }else {
                     mUrl=Constant.ADDRESS_UPDATA_URL;
                     map.put(" id",listBean.getId());

                }



                if (AppApplication.getInstance().getUserInfoVO() != null)
                    map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                map.put("consigner", mNameEt.getText().toString());
                map.put("mobile", mPhoneEt.getText().toString());
                map.put("province", mProvince);
                map.put("city", mCity);
                map.put("district", mArea);
//                map.put("area_info", mAddressTv.getText().toString());
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

                        mProvince = options1Items.get(options1).getProvince_name();
                        mCity = options2Items.get(options1).get(option2).getCity_name();
                        mArea = options3Items.get(options1).get(option2).get(options3).getDistrict_name();
                    }
                }).build();
                pvOptions.setPicker(options1Items, options2Items, options3Items);
                pvOptions.show();
                break;


            /**
             * 从通讯录添加联系人
             */
            case R.id.rl_select_user:

                reuestPerm();


                break;


            default:
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 从Intent通讯录返回拿到电话号码

       switch (requestCode){

           case 1000:

               if (resultCode == RESULT_OK) {
                   if (data == null) {
                       showCustomToast("抱歉，您选择的联系人没有电话，请重新选择！");
                       return;
                   }
                   Uri uri = data.getData();
                   String id = uri.getLastPathSegment();
                   setPhoneNumsByContactId(id);

               }

               break;


       }
    }




    /**
     * 设置选中联系人信息
     *
     * @param contactId
     *            联系人ID
     */

    public void setPhoneNumsByContactId(String contactId) {
        Cursor phonecursor = getContentResolver().query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
                ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
                new String[] { contactId }, null);
        List<String> phoneNums = new ArrayList<String>();
        List<String> phoneNames = new ArrayList<String>();
        while (phonecursor.moveToNext()) {
            String phoneNum = phonecursor
                    .getString(phonecursor
                            .getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            String phoneName = phonecursor.getString(phonecursor
                    .getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
            if (!TextUtils.isEmpty(phoneNum)) {
                phoneNums.add(phoneNum);
                phoneNames.add(phoneName == null ? "" : phoneName);
            }
        }
        if (phoneNums.size() == 0) {
            showCustomToast("抱歉，您选择的联系人没有电话，请重新选择！");
        } else if (phoneNums.size() > 0) {

           String name = phoneNames.get(0);
            String phone = phoneNums.get(0);

            Log.i("lyk",name+","+phone);
            mNameEt.setText(name);
            mPhoneEt.setText(trimTelNum(phone));


        }
    }



    /**
     * 消除电话号码中 可能含有的 IP号码、+86、0086等前缀
     *
     * @param telNum
     * @return
     */
    private static final String[] IPPFXS4 = { "1790", "1791", "1793", "1795",
            "1796", "1797", "1799" };
    private static final String[] IPPFXS5 = { "12583", "12593", "12589",
            "12520", "10193", "11808" };
    private static final String[] IPPFXS6 = { "118321" };
    public static String trimTelNum(String telNum) {

        if (telNum == null || "".equals(telNum)) {
            System.out.println("trimTelNum is null");
            return null;
        }

        String ippfx6 = substring(telNum,0, 6);
        String ippfx5 = substring(telNum,0, 5);
        String ippfx4 = substring(telNum,0, 4);

        if (telNum.length() > 7
                && (substring(telNum, 5, 1).equals("0")
                || substring(telNum, 5, 1).equals("1") || substring(
                telNum, 5, 3).equals("400") || substring(
                telNum, 5, 3).equals("+86"))
                && (inArray(ippfx5, IPPFXS5) || inArray(ippfx4, IPPFXS4)))
            telNum = substring(telNum, 5);
        else if (telNum.length() > 8
                && (substring(telNum, 6, 1).equals("0")
                || substring(telNum, 6, 1).equals("1") || substring(
                telNum, 6, 3).equals("400") || substring(
                telNum, 6, 3).equals("+86"))
                && inArray(ippfx6, IPPFXS6))
            telNum = substring(telNum, 6);
        // remove ip dial

        telNum = telNum.replace("-", "");
        telNum = telNum.replace(" ", "");

        if (substring(telNum, 0, 4).equals("0086"))
            telNum = substring(telNum, 4);
        else if (substring(telNum, 0, 3).equals("+86"))
            telNum = substring(telNum, 3);
        else if (substring(telNum, 0, 5).equals("00186"))
            telNum = substring(telNum, 5);

        return telNum;
    }

    /**
     * 截取字符串
     * @param s
     * @param from
     * @return
     */
    protected static String substring(String s, int from) {
        try {
            return s.substring(from);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    protected static String substring(String s, int from, int len) {
        try {
            return s.substring(from, from + len);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 判断一个字符串是否在一个字符串数组中
     * @param target
     * @param arr
     * @return
     */
    protected static boolean inArray(String target, String[] arr) {
        if (arr == null || arr.length == 0) {
            return false;
        }
        if (target == null) {
            return false;
        }
        for (String s : arr) {
            if (target.equals(s)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void success(BaseVO vo) {
        showSuccessToast(vo.getDesc());
        EventBus.getDefault().post(new EBMessageVO("refresh"));
        this.finish();
    }


    private static final int REQUEST_PERMISSIONS = 1;
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {

        enterContact();
    }


    /**
     * 申请联系人权限
     */
    private void reuestPerm() {
        String[] perms = {Manifest.permission.READ_CONTACTS};
        if (EasyPermissions.hasPermissions(this, perms)) {

            enterContact();

        } else {
            EasyPermissions.requestPermissions(this, "是否申请联系人权限？", REQUEST_PERMISSIONS, perms);
        }
    }


    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {

        showCustomToast("没有权限，无法获取联系人");
    }


    /**
     * 授权后进入通讯录
     */
    private void enterContact(){

        final int INTENT_CONTACT = 1000;
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_PICK);
        intent.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(intent, INTENT_CONTACT);

    }
}
