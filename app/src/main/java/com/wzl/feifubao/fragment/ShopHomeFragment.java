package com.wzl.feifubao.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.HomeAdapter;
import com.wzl.feifubao.adapter.ShopHomeAdapter;
import com.wzl.feifubao.adapter.YellowPagesAdapter;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.ShopHomeVO;
import com.wzl.feifubao.mode.ShopVO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wuzhanglong on 2018/1/1.
 */

public class ShopHomeFragment extends BaseFragment{
    private LuRecyclerView mRecyclerView;
    private ShopHomeAdapter mAdapter;
    private LuRecyclerViewAdapter mLuAdapter;
    public static BaseFragment newInstance() {
        BaseFragment fragment = new ShopHomeFragment();
        return fragment;
    }

    @Override
    public void setContentView() {
        contentInflateView(R.layout.shop_home_fragment);
    }

    @Override
    public void initView(View view) {
        mRecyclerView = getViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=  new GridLayoutManager(mActivity,6);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new ShopHomeAdapter(mRecyclerView);
        mLuAdapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(mLuAdapter);
        mRecyclerView.setLoadMoreEnabled(false);
        layoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                ShopHomeVO vo= (ShopHomeVO) mAdapter.getData().get(position);
                if("4".equals(vo.getType())|| "6".equals(vo.getType())){
                    return 2;
                }else  if("9".equals(vo.getType())){
                    return 3;
                }
                else {
                    return 6;
                }

            }
        });

    }

    @Override
    public void bindViewsListener() {

    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        HttpGetDataUtil.get(mActivity, this, Constant.SHOP_HOME_ULR, map, ShopHomeVO.class);

    }

    @Override
    public void hasData(BaseVO vo) {
        ShopHomeVO shopHomeVO= (ShopHomeVO) vo;
        List<ShopHomeVO> list= new ArrayList<>();
        ShopHomeVO advs= new ShopHomeVO();
        advs.setData(shopHomeVO.getData());
        advs.setType("1");
        list.add(advs);
        ShopHomeVO articles= new ShopHomeVO();
        articles.setData(shopHomeVO.getData());
        articles.setType("2");
        list.add(articles);
        ShopHomeVO tehuiTitle=new ShopHomeVO();
        tehuiTitle.setType("3");
        list.add(tehuiTitle);
        List<ShopHomeVO> tehui=shopHomeVO.getData().getTehui();
        for (int i = 0; i <tehui.size() ; i++) {
            ShopHomeVO tehuiVO=tehui.get(i);
            tehuiVO.setType("4");
            list.add(tehuiVO);
        }

        ShopHomeVO xianshiTitle=new ShopHomeVO();
        xianshiTitle.setType("5");
        list.add(xianshiTitle);
        List<ShopHomeVO> xianshi=shopHomeVO.getData().getXianshi();
        for (int i = 0; i <xianshi.size() ; i++) {
            ShopHomeVO xianshiVO=xianshi.get(i);
            xianshiVO.setType("6");
            list.add(xianshiVO);
        }

        List<ShopHomeVO> tuijianadvs=shopHomeVO.getData().getTuijianadvs();
        for (int i = 0; i <tuijianadvs.size() ; i++) {
            ShopHomeVO tuijianadvsVO=tuijianadvs.get(i);
            tuijianadvsVO.setType("7");
            list.add(tuijianadvsVO);
        }

        ShopHomeVO tuijianTitle=new ShopHomeVO();
        tuijianTitle.setType("8");
        list.add(tuijianTitle);

        List<ShopHomeVO> tuijian=shopHomeVO.getData().getTuijian();
        for (int i = 0; i <tuijian.size() ; i++) {
            ShopHomeVO tuijianVO=tuijian.get(i);
            tuijianVO.setType("9");
            list.add(tuijianVO);
        }

        mAdapter.updateData(list);
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }
}
