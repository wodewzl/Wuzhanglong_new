package com.wzl.txffc;

import android.view.View;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DateUtils;
import com.wuzhanglong.library.utils.RecyclerViewUtil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

import static com.wuzhanglong.library.http.BSHttpUtils.get;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    public static final String URL = "http://api.b1api.com/api?";//博易网
    //public static final String URL = "http://api.b1api.com/t?";
    private MainAdapter mAdapter;
    private LuRecyclerView mRecyclerView;
    private UserInfoVO mUserInfoVO;
    private List<String> mList = new ArrayList<>();
    private String mLimit = "20";
    private Timer mTimer = new Timer();
    private TextView mNumTv, mResultTv, mYuCeTv, mSortTv, mLastTv, mGeWeiTv;
    private StringBuffer mSortStrSb = new StringBuffer();
    private StringBuffer mSortStrSb1 = new StringBuffer();
    private double mBackPressed;
    private List<UserInfoVO.DataBean> mListData;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.main_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("TXFFC");
        mBaseOkTv.setText(mLimit);
        mBaseOkTv.setText("刷新");
        mNumTv = getViewById(R.id.num_tv);
        mResultTv = getViewById(R.id.result_tv);
        mYuCeTv = getViewById(R.id.yuce_tv);
        mSortTv = getViewById(R.id.sort_tv);
        mLastTv = getViewById(R.id.last_tv);
        mGeWeiTv = getViewById(R.id.single_tv);

        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new MainAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_1, R.color.colorAccent, false);
//        mTimer.schedule(mTimerTask, 6, 6);
    }

    @Override
    public void bindViewsListener() {
        mBaseOkTv.setOnClickListener(this);
        mBaseBackTv.setOnClickListener(this);
    }

    @Override
    public void getData() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("p", "json");
        map.put("t", "txffc");
//        map.put("limit", mLimit);
        map.put("token", "F0AB156E84ED3A17");//易网
//        map.put("token", "829C56AE65D54968");//易网
        map.put("date", parseDateDay(System.currentTimeMillis()));
        get(mActivity, this, URL, map, UserInfoVO.class);
    }

    public static String parseDateDay(long milliseconds) {
        Date date = new Date(milliseconds);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String format = simpleDateFormat.format(date);
        return format;
    }
    @Override
    public void hasData(BaseVO vo) {
        mUserInfoVO = (UserInfoVO) vo;
        List<UserInfoVO.DataBean> list = mUserInfoVO.getData().subList(0, 80);
        mAdapter.updateData(list);
        countData(list);
    }

    @Override
    public void noData(BaseVO vo) {
        System.out.println("=======>");
    }

    @Override
    public void noNet() {

    }

    public void countData(List<UserInfoVO.DataBean> listData) {
        mList.clear();
        StringBuffer mLastSb = new StringBuffer();
        StringBuffer geWeiSbOne = new StringBuffer();
        StringBuffer geWeiSb = new StringBuffer();
        for (int i = 0; i < listData.size(); i++) {
            String result = listData.get(i).getOpencode().replace(",", "");

            if (i > 4) {
                if (geWeiSbOne.toString().contains(String.valueOf(result.charAt(4)))) {
                    if (!geWeiSb.toString().contains(String.valueOf(result.charAt(4)))) {
                        geWeiSb.append(String.valueOf(result.charAt(4)));
                    }
                } else {
                    geWeiSbOne.append(String.valueOf(result.charAt(4)));
                }
            }


            for (int j = 0; j < 5; j++) {
                mList.add(String.valueOf(result.charAt(j)));
                if (!mLastSb.toString().contains(String.valueOf(result.charAt(j)))) {
                    mLastSb.append(String.valueOf(result.charAt(j)));
                }
            }
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        Set<String> set = new HashSet<String>(mList);
        for (String str : set) {
            for (String lstr : mList) {
                if (str.equals(lstr)) {
                    if (map.containsKey(str)) {
                        Integer count = map.get(str);
                        count++;
                        map.put(str, count);
                    } else {
                        map.put(str, 1);
                    }

                }
            }
        }
        //printMap(map);
        Map<String, Integer> sortMap = sortMapByValue(map);
        printMap(sortMap);
        mNumTv.setText(listData.get(0).getExpect().substring(8, listData.get(0).getExpect().length()));
        mResultTv.setText(listData.get(0).getOpencode().replaceAll(",", ""));
        mYuCeTv.setText(mSortStrSb.substring(mSortStrSb.length() - 3, mSortStrSb.length()));
        mSortTv.setText(mSortStrSb1.toString());
        mGeWeiTv.setText(geWeiSb.toString().substring(0, 3));
        mLastTv.setText(mLastSb.toString());

    }

    private Map<String, Integer> sortMapByValue(Map<String, Integer> map) {
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
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }

    public void printMap(Map<String, Integer> map) {
        mSortStrSb.setLength(0);
        mSortStrSb1.setLength(0);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey() + " Value : "
                    + entry.getValue());
            mSortStrSb.append(entry.getKey());
//            mSortStrSb1.append(entry.getKey()).append("(" + entry.getValue() + ")");
            mSortStrSb1.append(entry.getKey());
        }
    }

    TimerTask mTimerTask = new TimerTask() {
        @Override
        public void run() {
            try {
                getData();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.base_ok_tv:
                getData();
//                if ("7".equals(mLimit)) {
//                    mLimit = "20";
//                } else {
//                    mLimit = "7";
//                }
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (isShow()) {
//            dismissProgressDialog();
        } else {
            if (mBackPressed + 3000 > System.currentTimeMillis()) {
                finish();
                super.onBackPressed();
            } else {
                showCustomToast("再次点击，退出" + getString(R.string.app_name));

            }
            mBackPressed = System.currentTimeMillis();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }
}
