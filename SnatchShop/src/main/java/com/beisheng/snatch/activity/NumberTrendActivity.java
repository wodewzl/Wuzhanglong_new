package com.beisheng.snatch.activity;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.NumberTrendAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.NumberTrendVO;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
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
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.utils.WidthHigthUtil;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.UIUtil;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class NumberTrendActivity extends BaseActivity implements ScrollableHelper.ScrollableContainer {
    private String[] mTitleDataList = {"号码走势", "抢购次数", "剩余数量"};
    private LuRecyclerView mRecyclerView;
    private NumberTrendAdapter mAdapter;
    private ScrollableLayout mScrollableLayout;
    private MagicIndicator magicIndicator;
    private LinearLayout mHeadLayout;
    private LineChart mLineChart;
    private NumberTrendVO mNumberTrendVO;
    private String[] mXData = new String[]{"开始", "中前", "中间", "中后", "疯抢",};

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.number_trend_activity);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void initView() {
        mBaseTitleTv.setText("走势图");
        mScrollableLayout = getViewById(R.id.scrollable_layout);
        mScrollableLayout.getHelper().setCurrentScrollableContainer(this);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        mAdapter = new NumberTrendAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);
        mHeadLayout = getViewById(R.id.head_layout);
        initMagicIndicator();
        mLineChart = getViewById(R.id.lineChart);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initMagicIndicator() {
        magicIndicator = (MagicIndicator) getViewById(R.id.magic_indicator);
        magicIndicator.setBackgroundColor(ContextCompat.getColor(this, R.color.C3));
        CommonNavigator commonNavigator = new CommonNavigator(mActivity);
        commonNavigator.setAdjustMode(false);
        commonNavigator.setAdapter(new CommonNavigatorAdapter() {
            @Override
            public int getCount() {
                return mTitleDataList.length;
            }

            @Override
            public IPagerTitleView getTitleView(final Context context, final int index) {
                SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
                simplePagerTitleView.setText(mTitleDataList[index]);
                simplePagerTitleView.setWidth(WidthHigthUtil.getScreenWidth(mActivity) / 3);
                simplePagerTitleView.setTextSize(14);
                simplePagerTitleView.setNormalColor(ContextCompat.getColor(NumberTrendActivity.this, R.color.C4));

                simplePagerTitleView.setSelectedColor(ContextCompat.getColor(NumberTrendActivity.this, R.color.colorAccent));
                simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        magicIndicator.post(new Runnable() {
                            @Override
                            public void run() {
                                EventBus.getDefault().post(new EBMessageVO("change_tb", index + ""));
                            }
                        });
                        dataByType(index);
                    }
                });
                return simplePagerTitleView;
            }

            @Override
            public IPagerIndicator getIndicator(Context context) {
                LinePagerIndicator indicator = new LinePagerIndicator(context);
                indicator.setStartInterpolator(new AccelerateInterpolator());
                indicator.setEndInterpolator(new DecelerateInterpolator(1.6f));
                indicator.setLineHeight(UIUtil.dip2px(context, 2));
                indicator.setColors(ContextCompat.getColor(NumberTrendActivity.this, R.color.colorAccent));

                return indicator;
            }

            @Override
            public float getTitleWeight(Context context, int index) {
                if (index == 0) {
                    return 1.0f;
                } else if (index == 1) {
                    return 1.0f;
                } else {
                    return 1.0f;
                }
            }
        });


        magicIndicator.setNavigator(commonNavigator);

    }

    @Override
    public void bindViewsListener() {
        EventBus.getDefault().register(this);
        mScrollableLayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                mHeadLayout.setTranslationY(currentY / 2);

            }
        });
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("goods_id", this.getIntent().getStringExtra("id"));
        map.put("goods_id", "57");
        map.put("is_fq", "");
        BSHttpUtils.get(mActivity, this, Constant.NUMBER_TREND_URL, map, NumberTrendVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        mNumberTrendVO = (NumberTrendVO) vo;
        mAdapter.updateData(mNumberTrendVO.getData().getList());
        dataByType(0);
    }

    public void dataByType(int type) {
        initLineChart(type);
        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(0, 1));
        for (int i = 0; i < mNumberTrendVO.getData().getList().size(); i++) {
            entries.add(new Entry(i + 1, i));
        }
        // 每一个LineDataSet代表一条线
        LineDataSet lineDataSet = new LineDataSet(entries, "用户");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet);
        LineData data = new LineData(dataSets);
        //设置X轴的刻度数
//        xAxis.setLabelCount(xAxisValues.size(), true);
        mLineChart.setData(data);
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
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Subscribe
    public void onEventMainThread(EBMessageVO event) {
        if ("change_tb".equals(event.getMessage())) {
            initMagicIndicator();
            magicIndicator.onPageSelected(Integer.parseInt(event.getMsg()));
        }
    }

    public void initLineChart(final int type) {
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
//        //设置一页最大显示个数为6，超出部分就滑动
//        float ratio = (float) 15 / (float) 6;
//        //显示的时候是按照多大的比率缩放显示,1f表示不放大缩小
//        mLineChart.zoom(ratio, 1f, 0, 0);
        //设置从X轴出来的动画时间
        //设置XY轴动画
        mLineChart.animateXY(1500, 1500, Easing.EasingOption.EaseInSine, Easing.EasingOption.EaseInSine);


        //X轴
        XAxis xAxis = mLineChart.getXAxis();
//        final List<String> list = Arrays.asList(mXData);
//        //自定义设置横坐标
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (mNumberTrendVO.getData().getList().size() == 0) {
                    return "";
                } else {
                    int index = (int) value;
                    if (index == 0) {
                        return "100";
                    } else {
                        return mNumberTrendVO.getData().getList().get(index - 1).getPf_no();
                    }
                }


            }
        });

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//值：BOTTOM,BOTH_SIDED,BOTTOM_INSIDE,TOP,TOP_INSIDE
//        xAxis.setLabelRotationAngle(-60);

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
//        xAxis.setLabelCount(6, true);
        //设置最小间隔，防止当放大时出现重复标签
//        xAxis.setGranularity(1f);
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
                int yIndex = (int) value;
//                return list.get((int)value);
                if (yIndex == 0) {
                    return "";
                } else {

                    if (type == 0) {
                        return list.get(yIndex - 1);

                    } else if (type == 1) {
                        return mNumberTrendVO.getData().getList().get(yIndex - 1).getBuy_count();

                    } else {
                        return mNumberTrendVO.getData().getList().get(yIndex - 1).getRemain_count();

                    }
                }
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

    }
}
