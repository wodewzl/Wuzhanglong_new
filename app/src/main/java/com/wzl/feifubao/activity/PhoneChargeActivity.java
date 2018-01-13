package com.wzl.feifubao.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.adapter.TieAdapter;
import com.dou361.dialogui.bean.BuildBean;
import com.dou361.dialogui.bean.TieBean;
import com.dou361.dialogui.listener.DialogUIItemListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.JobOffersAdapter;
import com.wzl.feifubao.adapter.MoneyAdapter;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.MoneyVO;
import com.wzl.feifubao.mode.OrderPayVO;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;

public class PhoneChargeActivity extends BaseActivity implements BGAOnRVItemClickListener,View.OnClickListener,PostCallback{
    private LuRecyclerView mRecyclerView;
    private MoneyAdapter mAdapter;
    private String[] mOneyArray = {"30PHP", "50PHP", "100PHP", "300PHP", "500PHP", "1000PHP", "2000PHP", "3000PHP"};
    private TextView mOkTv;
    private MoneyVO mSelectVO;
    private LinearLayout mTypeLayout;
    private TextView mTypeTv;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_phone_charge);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("花费充值");
        mTypeLayout=getViewById(R.id.type_layout);
        mTypeTv=getViewById(R.id.type_tv);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        mAdapter = new MoneyAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadMoreEnabled(false);
//        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_10, R.color.C3);
//        mRecyclerView.addItemDecoration(divider);
        List<MoneyVO> list = new ArrayList<>();
        for (int i = 0; i < mOneyArray.length; i++) {
            MoneyVO vo = new MoneyVO();
            vo.setMoney(mOneyArray[i]);
            vo.setId(i + "");
            list.add(vo);
        }
        mAdapter.updateData(list);

        mOkTv = getViewById(R.id.ok_tv);
        mOkTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.colorAccent, R.color.colorAccent));

    }

    @Override
    public void bindViewsListener() {
        mAdapter.setOnRVItemClickListener(this);
        mTypeLayout.setOnClickListener(this);
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
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        if (mSelectVO != null) {
            mSelectVO.setStatus("0");
        }
        mSelectVO = mAdapter.getItem(position);
        mSelectVO.setStatus("1");
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.type_layout:

                List<TieBean> datas = new ArrayList<TieBean>();
                datas.add(new TieBean("人民币 CNY"));
                datas.add(new TieBean("美元 USD"));
                datas.add(new TieBean("日元 JPY"));
                datas.add(new TieBean("港币 HKD"));
                datas.add(new TieBean("欧元 EUR"));
                datas.add(new TieBean("英镑 GBP"));
                TieAdapter adapter = new TieAdapter(this, datas, true);
                BuildBean buildBean = DialogUIUtils.showMdBottomSheet(mActivity, true, "", datas, 0, new DialogUIItemListener() {
                    @Override
                    public void onItemClick(CharSequence text, int position) {
                        String str = (String) text;
                        String[] array = str.split(" ");
                     mTypeTv.setText(array[1]);
                    }
                });
                buildBean.mAdapter = adapter;
                buildBean.show();

                break;
            default:
                break;
        }
    }

    @Override
    public void success(BaseVO vo) {

    }

    public void commit(){
        HashMap<String, Object> map = new HashMap<>();
////        map.put("uid", AppApplication.getInstance().getUserInfoVO().getData().getUid());
//        map.put("uid", "39");
//        map.put("out_trade_no", orderNo);
//        map.put("pay_type", mPayType);
////        map.put("payment", money);
//        map.put("payment", "0.01");
//        HttpGetDataUtil.post(this, Constant.SURE_ORDER2_URL, map, OrderPayVO.class,this);
    }
}
