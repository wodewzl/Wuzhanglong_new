package com.beisheng.snatch.activity;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.NameConfirmVO;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.MD5;

import java.util.HashMap;
import java.util.Map;

import static com.wuzhanglong.library.http.BSHttpUtils.sortMapByKey;

public class NameConfirmActivity extends BaseActivity implements View.OnClickListener, PostCallback {
    private EditText mNameEt, mNumberEt;
    private TextView mOkTv, mNameTv, mNumberTv;
    private ImageView mConfirmImg;
    private LinearLayout commit_layout;
    private LinearLayout success_layout;
    private LinearLayout fail_layout;
    private TextView tv_re_confirm;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.name_confirm_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("实名认证");

        /**
         * 添加实名认证状态判断
         */
        commit_layout = getViewById(R.id.commit_layout);
        success_layout = getViewById(R.id.success_layout);
        fail_layout = getViewById(R.id.fail_layout);
        tv_re_confirm = getViewById(R.id.tv_re_confirm);
        tv_re_confirm.setOnClickListener(this);

        mNameEt = getViewById(R.id.name_et);
        mNumberEt = getViewById(R.id.number_et);
        mOkTv = getViewById(R.id.ok_tv);
        mNameTv = getViewById(R.id.name_tv);
        mNumberTv = getViewById(R.id.number_tv);
        mConfirmImg = getViewById(R.id.confirm_bg);


        Picasso.with(this).load(AppApplication.getInstance().getUserInfoVO().getData().getSmrz_banner()).into(mConfirmImg);

    }

    @Override
    public void bindViewsListener() {
        mOkTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        BSHttpUtils.post(mActivity, this, Constant.NAME_CONFIRM_INFO_URL, map, NameConfirmVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        NameConfirmVO bean = (NameConfirmVO) vo;

        String sm_status = bean.getData().getSm_status();

        switch (sm_status) {

            /**
             *  0-未通过或未认证（跳转提交界面）
             */
            case "0":

                commit_layout.setVisibility(View.VISIBLE);
                success_layout.setVisibility(View.GONE);
                fail_layout.setVisibility(View.GONE);


                break;

            /**
             * 1-已认证通过（展示实名认证信息）
             */
            case "1":

                success_layout.setVisibility(View.VISIBLE);
                commit_layout.setVisibility(View.GONE);
                fail_layout.setVisibility(View.GONE);

                confirmSuccess(bean.getData().getReal_name(), bean.getData().getId_card());

                break;


            /**
             * 默认未认证
             */
            default:
                commit_layout.setVisibility(View.VISIBLE);
                success_layout.setVisibility(View.GONE);
                fail_layout.setVisibility(View.GONE);

                break;


        }


//        mNameTv.setText("真实姓名："+bean.getData().getReal_name());
//        mNumberTv.setText("证件号码："+bean.getData().getId_card());
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

            /**
             * 立即认证
             */
            case R.id.ok_tv:
                if (TextUtils.isEmpty(mNameEt.getText().toString())) {
                    showCustomToast("请填写真实姓名");
                    return;
                }
                if (TextUtils.isEmpty(mNumberEt.getText().toString())) {
                    showCustomToast("请填写有效身份证号码");
                    return;
                }
                HashMap<String, Object> map = new HashMap<>();
                map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                map.put("real_name", mNameEt.getText().toString());
                map.put("id_card", mNumberEt.getText().toString());
                nameConfirm(mActivity, Constant.NAME_CONFIRM_URL, map, BaseVO.class, this);
                break;


            /**
             * 重新认证
             */
            case R.id.tv_re_confirm:

                commit_layout.setVisibility(View.VISIBLE);
                success_layout.setVisibility(View.GONE);
                fail_layout.setVisibility(View.GONE);
                mNameEt.setText("");
                mNumberEt.setText("");


                break;
            default:
                break;

        }
    }


    /**
     * 实名认证网络请求
     *
     * @param activity
     * @param url
     * @param params
     * @param className
     * @param postCallback
     * @param <T>
     */
    private <T> void nameConfirm(final BaseActivity activity, final String url, final Map<String, Object> params, final Class<T> className, final PostCallback postCallback) {
        final Gson gson = new Gson();
        final String allUrl = BaseConstant.DOMAIN_NAME + url;

        if (params == null || params.size() == 0) {
            Log.i("get_url", BaseConstant.DOMAIN_NAME + url);
        } else {
            Log.i("get_url", BaseConstant.DOMAIN_NAME + url + BaseCommonUtils.getUrl((HashMap<String, Object>) params));
        }

        params.put("timestamp", (System.currentTimeMillis() / 1000) + "");
        Map<String, Object> resultMap = sortMapByKey(params);
        StringBuffer signSb = new StringBuffer();
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            signSb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        signSb.append(BaseConstant.APP_KEY);
        String sign = MD5.Md5(signSb.toString());
        params.put("sign", sign);
        new Novate.Builder(activity)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build().rxPost(url, params, new RxStringCallback() {

            @Override
            public void onError(Object o, Throwable throwable) {
                activity.dismissProgressDialog();
            }

            @Override
            public void onCancel(Object o, Throwable throwable) {
                activity.dismissProgressDialog();

            }

            @Override
            public void onNext(Object o, String s) {
                activity.dismissProgressDialog();
                BaseVO baseVO = (BaseVO) gson.fromJson(s, className);
                if ("200".equals(baseVO.getCode())) {

                    NameConfirmVO bean = (NameConfirmVO) baseVO;

                    /**
                     * 认证成功
                     */
                    success_layout.setVisibility(View.VISIBLE);
                    commit_layout.setVisibility(View.GONE);
                    fail_layout.setVisibility(View.GONE);

                    confirmSuccess(bean.getData().getReal_name(), bean.getData().getId_card());

                } else if ("201".equals(baseVO.getCode())) {
                    activity.showCustomToast(baseVO.getDesc());
                    postCallback.success(baseVO);
                } else if ("202".equals(baseVO.getCode())) {
                    postCallback.success(baseVO);
                } else if ("400".equals(baseVO.getCode())) {
                    /**
                     * 认证失败
                     */

                    fail_layout.setVisibility(View.VISIBLE);
                    commit_layout.setVisibility(View.GONE);
                    success_layout.setVisibility(View.GONE);


                } else if ("600".equals(baseVO.getCode())) {
                } else if ("300".equals(baseVO.getCode())) {
                    activity.showFailToast(baseVO.getDesc());
                }
            }
        });
    }


    /**
     * 认证成功，填写用户真实姓名和证件号码
     *
     * @param realName 用户真实姓名
     * @param idCard   证件号码
     */
    private void confirmSuccess(String realName, String idCard) {

        BaseCommonUtils.setTextTwoBefore(this, mNameTv, "真实姓名：", realName, R.color.C5, 1.0f);
        BaseCommonUtils.setTextTwoBefore(this, mNumberTv, "证件号码：", idCard, R.color.C5, 1.0f);

    }


    @Override
    public void success(BaseVO vo) {


    }
}
