package com.beisheng.snatch.activity;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.ShopDetailAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.ShopDetailListVO;
import com.beisheng.snatch.model.ShopDetailVO;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.rey.material.app.BottomSheetDialog;
import com.squareup.picasso.Picasso;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ShopDetailActivity extends BaseActivity implements ScrollableHelper.ScrollableContainer, View.OnClickListener, OnLoadMoreListener {
    private LuRecyclerView mRecyclerView;
    private ShopDetailAdapter mAdapter;
    private LinearLayout mBottomLayout, mNumberTrendLayout;
    private RelativeLayout mHeadLayout;
    private TextView mTitleTv, mBackTv;
    private ImageView mHomeImg, mShareImg;
    private LineChart mLineChart;
    private ScrollableLayout mScrollableLayout;
    private TextView mJoinCartTv, mQuckBuyTv;
    private BottomSheetDialog mDialog;
    private ShopDetailVO.DataBean mShopDetailVO;
    private Banner mBanner;
    private TextView mDescTv, mStatusTv, mHonor1GradeTv, mHonor1NameTv, mHonor1CountTv, mHonor2GradeTv, mHonor2NameTv, mHonor2CountTv, mHonor3GradeTv, mHonor3NameTv, mHonor3CountTv;
    private View mLayoutType1, mLayoutType2, mLayoutType3;
    private TextView mType1NameTv, mType1NumberTv, mType1BuyCoutTv, mType1TimeTv, mType1UserNoTv, mType1WinTv;
    private CircleImageView mType1HeadImg, mHonor1HeadImg, mHonor2HeadImg, mHonor3HeadImg;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private TextView mPublishTimeTv;
    private String[] mXData = new String[]{"开始", "中前", "中间", "中后", "疯抢",};

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.shop_detail_activity);
    }

    @Override
    public void initView() {
        mHeadLayout = getViewById(R.id.head_layout);
        mBackTv = getViewById(R.id.back_tv);
        mShareImg = getViewById(R.id.share_img);
        mScrollableLayout = getViewById(R.id.scrollable_layout);
        mScrollableLayout.getHelper().setCurrentScrollableContainer(this);
        mRecyclerView = getViewById(R.id.recycler_view);
        mBaseHeadLayout.setVisibility(View.GONE);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_1, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mAdapter = new ShopDetailAdapter(mRecyclerView);
        LuRecyclerViewAdapter luAdapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(luAdapter);
        mRecyclerView.setLoadMoreEnabled(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mBottomLayout = getViewById(R.id.bottom_layout);
        mNumberTrendLayout = getViewById(R.id.number_trend_layout);
        mJoinCartTv = getViewById(R.id.jion_cart_tv);
        mQuckBuyTv = getViewById(R.id.quick_tv);
        mLineChart = getViewById(R.id.lineChart);
//        initLineChart();

        mBanner = getViewById(R.id.banner);
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mDescTv = getViewById(R.id.desc_tv);
        mStatusTv = getViewById(R.id.status_tv);
        mLayoutType1 = getViewById(R.id.layout_type1);
        mLayoutType2 = getViewById(R.id.layout_type2);
        mLayoutType3 = getViewById(R.id.layout_type3);
        mType1NameTv = getViewById(R.id.type1_name_tv);
        mType1NumberTv = getViewById(R.id.type1_number_tv);
        mType1BuyCoutTv = getViewById(R.id.type1_buy_cout);
        mType1TimeTv = getViewById(R.id.type1_time_tv);
        mType1HeadImg = getViewById(R.id.type1_head_img);
        mType1UserNoTv = getViewById(R.id.type1_user_no_tv);
        mType1WinTv = getViewById(R.id.win_tv);
        mHonor1HeadImg = getViewById(R.id.honor1_head_img);
        mHonor2HeadImg = getViewById(R.id.honor1_head_img);
        mHonor3HeadImg = getViewById(R.id.honor1_head_img);
        mHonor1GradeTv = getViewById(R.id.honor1_grade_tv);
        mHonor2GradeTv = getViewById(R.id.honor1_grade_tv);
        mHonor3GradeTv = getViewById(R.id.honor1_grade_tv);
        mHonor1NameTv = getViewById(R.id.honor1_name_tv);
        mHonor2NameTv = getViewById(R.id.honor2_name_tv);
        mHonor3NameTv = getViewById(R.id.honor3_name_tv);
        mHonor1CountTv = getViewById(R.id.honor1_count_tv);
        mHonor2CountTv = getViewById(R.id.honor2_count_tv);
        mHonor3CountTv = getViewById(R.id.honor3_count_tv);
        mPublishTimeTv = getViewById(R.id.publish_time_tv);
    }

    public void initLineChart() {
        //设置描述文本不显示
        mLineChart.getDescription().setEnabled(false);
        //设置是否显示表格背景
        mLineChart.setDrawGridBackground(true);
        //设置是否可以触摸
        mLineChart.setTouchEnabled(true);
        mLineChart.setDragDecelerationFrictionCoef(0.9f);
        //设置是否可以拖拽
        mLineChart.setDragEnabled(true);
        //设置是否可以缩放
        mLineChart.setScaleEnabled(false);
        mLineChart.setDrawGridBackground(false);
        mLineChart.setHighlightPerDragEnabled(true);
        mLineChart.setPinchZoom(true);
        //设置背景颜色
        mLineChart.setBackgroundColor(ContextCompat.getColor(this, R.color.C1));
        //设置一页最大显示个数为6，超出部分就滑动
        float ratio = (float) 15 / (float) 6;
        //显示的时候是按照多大的比率缩放显示,1f表示不放大缩小
        mLineChart.zoom(ratio, 1f, 0, 0);
        //设置从X轴出来的动画时间
        //mLineChart.animateX(1500);
        //设置XY轴动画
        mLineChart.animateXY(1500, 1500, Easing.EasingOption.EaseInSine, Easing.EasingOption.EaseInSine);




        //X轴
        XAxis xAxis = mLineChart.getXAxis();
//        final List<String> list = Arrays.asList(mXData);
//        //自定义设置横坐标
//        xAxis.setValueFormatter(new IAxisValueFormatter() {
//            @Override
//            public String getFormattedValue(float value, AxisBase axis) {
//                return list.get((int) value);
//            }
//        });

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//值：BOTTOM,BOTH_SIDED,BOTTOM_INSIDE,TOP,TOP_INSIDE
        xAxis.setLabelRotationAngle(-60);

        //设置线为虚线
        //xAxis.enableGridDashedLine(10f, 10f, 0f);
        //设置字体大小10sp
        xAxis.setTextSize(10f);
        //设置X轴字体颜色
        xAxis.setTextColor(ContextCompat.getColor(this, R.color.C12));
        //设置从X轴发出横线
        xAxis.setDrawGridLines(false);
        xAxis.setGridColor(ContextCompat.getColor(this, R.color.C3));
        //设置网格线宽度
        xAxis.setGridLineWidth(1);
        //设置显示X轴
        xAxis.setDrawAxisLine(true);
        //设置X轴显示的位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置自定义X轴值
//        xAxis.setValueFormatter(xValueFormatter);
        //一个界面显示6个Lasble，那么这里要设置11个
        xAxis.setLabelCount(6, true);
        //设置最小间隔，防止当放大时出现重复标签
        xAxis.setGranularity(1f);
        //设置为true当一个页面显示条目过多，X轴值隔一个显示一个
        xAxis.setGranularityEnabled(true);
        //设置X轴的颜色
        xAxis.setAxisLineColor(ContextCompat.getColor(this, R.color.colorAccent));
        //设置X轴的宽度
        xAxis.setAxisLineWidth(1f);
        mLineChart.invalidate();


        final List<String> list = Arrays.asList(mXData);

        YAxis leftAxis = mLineChart.getAxisLeft();
        leftAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return list.get((int)value);
            }
        });
        //设置从Y轴发出横向直线(网格线)
        leftAxis.setDrawGridLines(false);
        //设置网格线的颜色
        leftAxis.setGridColor(ContextCompat.getColor(this, R.color.C3));
        //设置网格线宽度
        leftAxis.setGridLineWidth(1);
        //设置Y轴最小值是0，从0开始
        leftAxis.setAxisMinimum(0f);
        leftAxis.setGranularityEnabled(true);
        //设置最小间隔，防止当放大时出现重复标签
        leftAxis.setGranularity(1f);
        //如果沿着轴线的线应该被绘制，则将其设置为true,隐藏Y轴
        leftAxis.setDrawAxisLine(true);
        leftAxis.setDrawZeroLine(true);
        leftAxis.setTextSize(10f);
        leftAxis.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        //设置左边X轴显示
        leftAxis.setEnabled(true);
        //设置Y轴的颜色
        leftAxis.setAxisLineColor(ContextCompat.getColor(this, R.color.colorAccent));
        //设置Y轴的宽度
        leftAxis.setAxisLineWidth(1f);

        YAxis rightAxis = mLineChart.getAxisRight();
        //设置右边Y轴不显示
        rightAxis.setEnabled(false);


        //显示边界
        mLineChart.setDrawBorders(false);
        //设置数据
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
//            entries.add(new Entry(i, (float) (Math.random()) * 80));
            entries.add(new Entry(i, (float) (Math.random()) * 80));
        }
        //一个LineDataSet就是一条线
        LineDataSet lineDataSet = new LineDataSet(entries, "温度");
        LineData data = new LineData(lineDataSet);
        mLineChart.setData(data);

//        XAxis xAxis = mLineChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//值：BOTTOM,BOTH_SIDED,BOTTOM_INSIDE,TOP,TOP_INSIDE
//        xAxis.setLabelCount(8, true);
//        xAxis.setLabelRotationAngle(-60);
    }

    public void showLineChart(List<Integer> xAxisValues, List<Integer> yAxisValues, String label) {
        initLineChart();
        ArrayList<Entry> entries = new ArrayList<>();
        for (int i = 0; i < xAxisValues.size(); i++) {
            entries.add(new Entry(xAxisValues.get(i), yAxisValues.get(i)));
        }
        // 每一个LineDataSet代表一条线
        LineDataSet lineDataSet = new LineDataSet(entries, label);

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);
        LineData data = new LineData(dataSets);
        //设置X轴的刻度数
//        xAxis.setLabelCount(xAxisValues.size(), true);
        mLineChart.setData(data);
    }



    @Override
    public void bindViewsListener() {
        mNumberTrendLayout.setOnClickListener(this);
        mJoinCartTv.setOnClickListener(this);
        mQuckBuyTv.setOnClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("user_no", "10005");
//        map.put("id", this.getIntent().getStringExtra("id"));
        map.put("id", "2");
        BSHttpUtils.post(mActivity, this, Constant.SHOP_DETAIL_URL, map, ShopDetailVO.class);
        HashMap<String, Object> mapList = new HashMap<>();
        mapList.put("curpage", mCurrentPage + "");
        mapList.put("id", "2");
        BSHttpUtils.post(mActivity, this, Constant.SHOP_BUY_LIST_URL, mapList, ShopDetailListVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof ShopDetailVO) {
            ShopDetailVO shopDetailVO = (ShopDetailVO) vo;
            mShopDetailVO = shopDetailVO.getData();
            mBanner.setImages(mShopDetailVO.getImg_list());
            mBanner.setImageLoader(new ImageLoader() {
                @Override
                public void displayImage(Context context, Object o, ImageView imageView) {
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    String url = (String) o;
                    Picasso.with(context).load(url).into(imageView);
                }
            });
            mBanner.start();
            mDescTv.setText(mShopDetailVO.getGoods_name());
            switch (mShopDetailVO.getPrise_status()) {
                case "1":

                    break;
                case "2":

                    break;
                case "3":
                    mStatusTv.setText(mShopDetailVO.getStatus_text());
                    mStatusTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.snatch_02, R.color.snatch_02));
                    mStatusTv.setTextColor(ContextCompat.getColor(this, R.color.C1));
                    mLayoutType3.setVisibility(View.VISIBLE);
                    if (!TextUtils.isEmpty(mShopDetailVO.getLucky_user().getAvatar()))
                        Picasso.with(this).load(mShopDetailVO.getLucky_user().getAvatar()).into(mType1HeadImg);
                    mType1NumberTv.setText("期号：" + mShopDetailVO.getIssue_no());
                    mType1NameTv.setText("获奖者：" + mShopDetailVO.getLucky_user().getNickname());
                    mType1UserNoTv.setText("用户ID：" + mShopDetailVO.getLucky_user().getUser_no());
                    mType1BuyCoutTv.setText("抢购次数：" + mShopDetailVO.getLucky_user().getBuy_count() + "次");
                    mType1TimeTv.setText("揭晓时间：" + mShopDetailVO.getLucky_user().getPublish_time());
                    mType1WinTv.setText("幸运号码：" + mShopDetailVO.getLucky_user().getPrise_code());
                    break;
                case "4":

                    break;
                case "5":

                    break;
                default:
                    break;
            }


            if (mShopDetailVO.getDfw_data() != null) {
                if (!TextUtils.isEmpty(mShopDetailVO.getDfw_data().getAvatar()))
                    Picasso.with(this).load(mShopDetailVO.getDfw_data().getAvatar()).into(mHonor1HeadImg);
                mHonor1GradeTv.setText("大富翁");
                mHonor1GradeTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.colorAccent, R.color.colorAccent));
                mHonor1NameTv.setText(mShopDetailVO.getDfw_data().getNickname());
                BaseCommonUtils.setTextThree(this, mHonor1CountTv, "参与", mShopDetailVO.getDfw_data().getTotal_buy(), "人次", R.color.colorAccent, 1.3f);
            } else {
                mHonor1GradeTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.C3, R.color.C3));
                mHonor1NameTv.setText("虚拟待位");
            }


            if (mShopDetailVO.getEdj_data() != null) {
                if (!TextUtils.isEmpty(mShopDetailVO.getEdj_data().getAvatar()))
                    Picasso.with(this).load(mShopDetailVO.getEdj_data().getAvatar()).into(mHonor2HeadImg);
                mHonor2GradeTv.setText("二当家");
                mHonor2GradeTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.colorAccent, R.color.colorAccent));
                mHonor2NameTv.setText(mShopDetailVO.getEdj_data().getNickname());
                mHonor2CountTv.setText("第一个参与");
            } else {
                mHonor2GradeTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.C3, R.color.C3));
                mHonor2NameTv.setText("虚拟待位");
                mHonor2CountTv.setText("第一个参与");
            }

            if (mShopDetailVO.getXdz_data() != null) {
                if (!TextUtils.isEmpty(mShopDetailVO.getXdz_data().getAvatar()))
                    Picasso.with(this).load(mShopDetailVO.getDfw_data().getAvatar()).into(mHonor3HeadImg);
                mHonor3GradeTv.setText("小地主");
                mHonor3GradeTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.colorAccent, R.color.colorAccent));
                mHonor3NameTv.setText(mShopDetailVO.getDfw_data().getNickname());
                mHonor3CountTv.setText("最后一个参与");
            } else {
                mHonor3GradeTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.C3, R.color.C3));
                mHonor3NameTv.setText("虚拟待位");
                mHonor3CountTv.setText("最后一个参与");
            }

            initLineChart();
            ArrayList<Entry> entries = new ArrayList<>();
            for (int i = 0; i < mShopDetailVO.getChart_data().size(); i++) {
                entries.add(new Entry(i, Integer.parseInt(mShopDetailVO.getChart_data().get(i).getBuy_period())));
            }
            // 每一个LineDataSet代表一条线
            LineDataSet lineDataSet = new LineDataSet(entries, "");

            ArrayList<ILineDataSet> dataSets = new ArrayList<>();
            dataSets.add(lineDataSet);
            LineData data = new LineData(dataSets);
            //设置X轴的刻度数
//        xAxis.setLabelCount(xAxisValues.size(), true);
            mLineChart.setData(data);

        } else {
            ShopDetailListVO mShopDetailListVO = (ShopDetailListVO) vo;
            mPublishTimeTv.setText(mShopDetailListVO.getData().getStart_time());
            if (BaseCommonUtils.parseInt(mShopDetailListVO.getData().getCount()) == 1) {
                mRecyclerView.setLoadMoreEnabled(false);
            }
            if (mCurrentPage == BaseCommonUtils.parseInt(mShopDetailListVO.getData().getCount())) {
                mRecyclerView.setNoMore(true);
            } else {
                mRecyclerView.setNoMore(false);
            }
            List<ShopDetailListVO.DataBean.ListBean> list = mShopDetailListVO.getData().getList();
            if (isLoadMore) {
                mAdapter.updateDataLast(list);
                isLoadMore = false;
                mCurrentPage++;
            } else {
                mCurrentPage++;
                mAdapter.updateData(list);
            }
            mAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public View getScrollableView() {
        return mRecyclerView;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.number_trend_layout:
                openActivity(NumberTrendActivity.class);
                break;
            case R.id.jion_cart_tv:
                if (AppApplication.getInstance().getUserInfoVO() == null) {
                    showCustomDialog(R.layout.login_type);
                    return;
                }
                break;
            case R.id.quick_tv:

                break;
            default:

                break;
        }
    }

    public void showCustomDialog(int layoutId) {
//        BottomSheetDialog dialog = new BottomSheetDialog(mActivity);
        BottomSheetDialog dialog = new BottomSheetDialog(mActivity);
        View dialogView = View.inflate(mActivity, layoutId, null);
        dialog.contentView(dialogView)
                .heightParam(ViewGroup.LayoutParams.WRAP_CONTENT)
                .inDuration(500)
                .cancelable(true)
                .show();
    }

    public void onLoginClick(View v) {
        switch (v.getId()) {
            case R.id.login_tv:
                System.out.println("=========>");
                showCustomDialog(R.layout.login_layout);
                break;
            case R.id.regist_tv:
                System.out.println("=========>");
                showCustomDialog(R.layout.login_regist);
                break;
            default:
                break;
        }
    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }
}
