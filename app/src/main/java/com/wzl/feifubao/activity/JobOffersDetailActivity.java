package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wzl.feifubao.R;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.JobOffersDetailVO;
import com.wzl.feifubao.mode.JobOffersVO;

import java.util.HashMap;

import cn.bingoogolapple.baseadapter.BGADivider;

public class JobOffersDetailActivity extends BaseActivity implements View.OnClickListener{
    private TextView mPositionTv, mMoneyTv, mPositionRequireTv, mCompanyTv, mAddressTv, mCompanyDescTv, mPositionDescTv,mNameTv,mPhoneTv,mOtherPositionTv;
    private String mCompanyId,mPhone;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_job_offers_detail);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("招聘信息");
        mPositionTv = getViewById(R.id.position_tv);
        mMoneyTv = getViewById(R.id.money_tv);
        mPositionRequireTv = getViewById(R.id.position_require_tv);
        mCompanyTv = getViewById(R.id.company_tv);
        mAddressTv = getViewById(R.id.address_tv);
        mCompanyDescTv = getViewById(R.id.company_dec_tv);

        mPositionDescTv = getViewById(R.id.position_desc_tv);
        mNameTv=getViewById(R.id.name_tv);
        mPhoneTv=getViewById(R.id.tel_tv);
        mOtherPositionTv=getViewById(R.id.other_position_tv);
    }

    @Override
    public void bindViewsListener() {
        mOtherPositionTv.setOnClickListener(this);
        mPhoneTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", this.getIntent().getStringExtra("id"));
        HttpGetDataUtil.get(mActivity, this, Constant.JOBOFFER_DETAIL_URL, map, JobOffersDetailVO.class);

    }

    @Override
    public void hasData(BaseVO vo) {
        JobOffersDetailVO jobOffersDetailVO = (JobOffersDetailVO) vo;
        JobOffersDetailVO.DataBean dataBean = jobOffersDetailVO.getData();
        mCompanyId=dataBean.getSupplier_id();
        mPhone=dataBean.getLinkman_tel();
        mPositionTv.setText(dataBean.getPosition_name());
        mMoneyTv.setText("【" + dataBean.getPosition_salary() + "p】");
        mPositionRequireTv.setText(dataBean.getPosition_class_name() + " | " + dataBean.getPosition_education_name() + " | " + dataBean.getPosition_life_name());
        mPositionDescTv.setText(dataBean.getPosition_desc());
        mCompanyTv.setText(dataBean.getSupplier_name());
        mAddressTv.setText(dataBean.getAddress());
        mCompanyDescTv.setText(dataBean.getCompany_desc());
        mNameTv.setText("联系人："+dataBean.getLinkman_name());
        mPhoneTv.setText(dataBean.getLinkman_tel());

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
            case R.id.tel_tv:
                BaseCommonUtils.call(this,mPhone);
                break;
            case R.id.other_position_tv:
                Bundle bundle= new Bundle();
                bundle.putString("supplier_id",mCompanyId);
                open(JobOffersActivity.class,bundle,0);
                break;
            default:
                break;
        }

    }
}
