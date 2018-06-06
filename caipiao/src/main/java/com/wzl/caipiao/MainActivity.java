package com.wzl.caipiao;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private EditText mNumberEt;
    private TextView mTv1, mTv2, mTv3, mTv4, mCommitTv;
    //    private List<String> mList = new ArrayList<>();
    private LuRecyclerView mRecyclerView;
    private MainAdapter mMainAdapter;


    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("预测");
        mBaseOkTv.setText("保存");
        mNumberEt = getViewById(R.id.number_et);
        mTv1 = getViewById(R.id.tv_1);
        mTv2 = getViewById(R.id.tv_2);
        mTv3 = getViewById(R.id.tv_3);
        mTv4 = getViewById(R.id.tv_4);
        mCommitTv = getViewById(R.id.commit_tv);
        mRecyclerView = getViewById(R.id.recycler_view);
        mMainAdapter = new MainAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mMainAdapter, R.dimen.dp_1, R.color.colorAccent, false);

        if (AppApplication.getInstance().getDataVO() != null) {
            List<UserInfoVO> list = AppApplication.getInstance().getDataVO();
            mMainAdapter.updateDataFrist(list);
//            countData(mMainAdapter.getData());
        }
    }

    @Override
    public void bindViewsListener() {
        mCommitTv.setOnClickListener(this);
        mBaseOkTv.setOnClickListener(this);
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
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.commit_tv:
                StringBuffer sb = new StringBuffer(mNumberEt.getText().toString());
                sb.reverse();
                String reslut = sb.toString();

//                StringBuffer sb = new StringBuffer();
//                for (int i = 0; i < 150; i++) {
//                    Random random=new Random();
//                    String str= random.nextInt(10)+"";
//                    sb.append(str);
//                }
//                String reslut = sb.toString();

                if (TextUtils.isEmpty(reslut)) {
                    showCustomToast("请输入开奖结果");
                    return;
                }
                List<UserInfoVO> list = new ArrayList<>();
                for (int i = 0; i < reslut.length(); i++) {
                    UserInfoVO userInfoVO = new UserInfoVO();
                    userInfoVO.setResult(String.valueOf(reslut.charAt(i)));
                    list.add(userInfoVO);
                }
                mMainAdapter.updateDataFrist(list);
                countData(list);
                mNumberEt.setText("");
                break;
            case R.id.base_ok_tv:
                new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("确定要保存数据吗吗?")
                        .setConfirmText("确定")
                        .setCancelText("取消")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();//直接消失
                                AppApplication.getInstance().saveDataVO(mMainAdapter.getData());
                                UserInfoVO dataVO = new UserInfoVO();
                                dataVO.setList(mMainAdapter.getData());
                            }
                        })
                        .show();
                break;
            default:
                break;
        }


    }

    private static String sortMapByValue(Map<String, Integer> map) {
        StringBuffer sb = new StringBuffer();
        List<Map.Entry<String, Integer>> mapList = new ArrayList<Map.Entry<String, Integer>>(
                map.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        Map<String, Integer> result = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : mapList) {
//            result.put(entry.getKey(), entry.getValue());
            sb.append(entry.getKey());
        }
        return sb.toString();
    }

    public void countData(List<UserInfoVO> list) {
        if (list == null)
            return;


        if (mMainAdapter.getData().size() > 10) {

            for (int j = 0; j < list.size(); j++) {
                StringBuffer sb1 = new StringBuffer();
                StringBuffer sb2 = new StringBuffer();
                HashMap<String, Integer> map = new HashMap<String, Integer>();
                for (int i = j; i < mMainAdapter.getData().size(); i++) {
                    //统计双数
                    if (sb1.toString().contains(((UserInfoVO) mMainAdapter.getData().get(i)).getResult())) {
                        if (!sb2.toString().contains(((UserInfoVO) mMainAdapter.getData().get(i)).getResult())) {
                            sb2.append(((UserInfoVO) mMainAdapter.getData().get(i)).getResult());
                        }
                    } else {
                        sb1.append(((UserInfoVO) mMainAdapter.getData().get(i)).getResult());
                    }
                    String tv1Str = sb2.toString();
                    mTv1.setText(tv1Str);


                    //统计数量
                    if (mMainAdapter.getData().size() > 120 && i < 120) {
                        String key = ((UserInfoVO) mMainAdapter.getData().get(i)).getResult();
                        Integer count = map.get(key);
                        if (count == null) {
                            count = 1;
                        } else {
                            count++;
                        }
                        map.put(key, count);
                    }
                }

                if (sb2.toString().length() > 1) {
                    mTv3.setText(sb2.toString().substring(0, 2));
                    ((UserInfoVO) mMainAdapter.getData().get(j)).setYuce1(mTv3.getText().toString());
                }

                if (mMainAdapter.getData().size() > 120) {
                    String tv2Str = sortMapByValue(map);
                    mTv2.setText(tv2Str);
                    if (tv2Str.length() > 1) {
                        mTv4.setText(tv2Str.substring(0, 2));
                    }
                }

                mMainAdapter.notifyDataSetChanged();
            }


        }
    }
}
