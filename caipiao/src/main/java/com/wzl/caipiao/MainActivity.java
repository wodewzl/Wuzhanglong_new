package com.wzl.caipiao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.RecyclerViewUtil;


import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeSet;

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private EditText mNumberEt;
    private TextView mTv1, mTv2, mTv3, mTv4, mCommitTv;
    private List<String> mList = new ArrayList<>();
    private LuRecyclerView mRecyclerView;
    private MainAdapter mMainAdapter;
    private Map<String, String> mMap = new IdentityHashMap<String, String>();

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_main);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("预测");
        mBaseOkTv.setText("保存");
        mTv1 = getViewById(R.id.tv_1);
        mTv2 = getViewById(R.id.tv_2);
        mTv3 = getViewById(R.id.tv_3);
        mTv4 = getViewById(R.id.tv_4);
        mCommitTv = getViewById(R.id.commit_tv);
        mRecyclerView = getViewById(R.id.recycler_view);
        mMainAdapter = new MainAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mMainAdapter, R.dimen.dp_1, R.color.colorAccent, false);


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
//            case R.id.commit_tv:
//                break;
            default:
                break;
        }


    }

    private static String sortMapByValue(Map<String, Integer> map) {
        StringBuffer sb=new StringBuffer();
        List<Map.Entry<String, Integer>> mapList = new ArrayList<Map.Entry<String, Integer>>(
                map.entrySet());
        Collections.sort(mapList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        Map<String,Integer> result = new LinkedHashMap<String,Integer>();
        for(Map.Entry<String, Integer> entry:mapList){
//            result.put(entry.getKey(), entry.getValue());
            sb.append(entry.getKey());
        }
        return sb.toString();
    }

    public  void getlocalData(List<String> list){

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            //指定种子数100
            mList.add(random.nextInt(10) + "");
        }
//        ACache.get(this).put("list",mList);
        final Gson gson = new Gson();
        String listStr=gson.toJson(mList);
        ACache.get(this).put("list", listStr);
        final String cacheStr = ACache.get(this).getAsString("list");



        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < mList.size(); i++) {
            String key = mList.get(i);
            Integer count = map.get(key);
            if(count == null){
                count = 1;
            }else{
                count ++;
            }
            map.put(key, count);

            if (sb1.toString().contains(mList.get(i))) {
                if (!sb2.toString().contains(mList.get(i))) {
                    sb2.append(mList.get(i));
                }
            } else {
                sb1.append(mList.get(i));
            }
        }
        if (sb2.toString().length() == 10) {
            System.out.println("");
            mMap.size();
        }

        sortMapByValue(map);
    }
}
