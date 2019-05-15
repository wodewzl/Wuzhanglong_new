package com.wzl.txffc;

import android.view.View;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
    public static final String URL = "http://api.b1api.com/api?";//易网
    private MainAdapter mAdapter;
    private LuRecyclerView mRecyclerView;
    private UserInfoVO mUserInfoVO;
    private List<String> mList = new ArrayList<>();
    private String mLimit = "20";
    private Timer mTimer = new Timer();
    private TextView mNumTv, mResultTv, mYuCeTv, mSortTv, mLastTv, mGeWeiTv, mZabaTv;
    private StringBuffer mSortStrSb = new StringBuffer();
    private StringBuffer mSortStrSb1 = new StringBuffer();
    private double mBackPressed;


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
        mZabaTv = getViewById(R.id.zaba_tv);
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
        map.put("limit", mLimit);
        map.put("token", "F0AB156E84ED3A17");//易网
        get(mActivity, this, URL, map, UserInfoVO.class);

    }

    @Override
    public void hasData(BaseVO vo) {
        mUserInfoVO = (UserInfoVO) vo;
        mAdapter.updateData(mUserInfoVO.getData());
        countData();
    }

    @Override
    public void noData(BaseVO vo) {
        System.out.println("=======>");
    }

    @Override
    public void noNet() {

    }

    public void countData() {
        mList.clear();
        StringBuffer mLastSb = new StringBuffer();
        StringBuffer geWeiSbOne = new StringBuffer();
        StringBuffer geWeiSb = new StringBuffer();
        for (int i = 0; i < mUserInfoVO.getData().size(); i++) {
            String result = mUserInfoVO.getData().get(i).getOpencode().replace(",", "");

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
        mNumTv.setText(mUserInfoVO.getData().get(0).getExpect().substring(8, mUserInfoVO.getData().get(0).getExpect().length()));
        mResultTv.setText(mUserInfoVO.getData().get(0).getOpencode().replaceAll(",", ""));
        mYuCeTv.setText(mSortStrSb.substring(mSortStrSb.length() - 3, mSortStrSb.length()));
        mSortTv.setText(mSortStrSb1.toString());
        mGeWeiTv.setText(geWeiSb.toString().substring(0, 3));
        mLastTv.setText(mLastSb.toString());

        String[] wei = {"0", "1", "2", "3", "4"};
        List<String> list = Arrays.asList(wei);
        List<String> list2=new ArrayList<>();
        list2.addAll(list);
        for (int i = 0; i < 5; i++) {
            String result2 = mUserInfoVO.getData().get(i).getOpencode().replace(",", "");
            for (int j = 0; j < 5; j++) {
                if (mGeWeiTv.getText().toString().contains(String.valueOf(result2.charAt(j))) && list2.contains(j + "")) {
                    list2.remove(j + "");
                }
            }
        }

        StringBuffer zabaSb = new StringBuffer();
        if (list2.size() == 0) {
            mZabaTv.setText("暂无");
            return;
        }
        for (int i = 0; i < list2.size(); i++) {
            switch (list2.get(i)) {
                case "0":
                    zabaSb.append("万位: " + mGeWeiTv.getText().toString());
                    break;
                case "1":
                    zabaSb.append("千位: " + mGeWeiTv.getText().toString());
                    break;
                case "2":
                    zabaSb.append("百位: " + mGeWeiTv.getText().toString());
                    break;
                case "3":
                    zabaSb.append("十位: " + mGeWeiTv.getText().toString());
                    break;
                case "4":
                    zabaSb.append("个位: " + mGeWeiTv.getText().toString());
                    break;
                default:
                    zabaSb.append("暂无");
                    break;
            }
        }
        mZabaTv.setText(zabaSb.toString());
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
