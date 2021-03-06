package com.beisheng.snatch.activity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.PayTypeAdapter;
import com.beisheng.snatch.adapter.RedMoneyAdapter;
import com.beisheng.snatch.adapter.ShopDetailAdapter;
import com.beisheng.snatch.application.AppApplication;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.PayRedVO;
import com.beisheng.snatch.model.PayTypeVO;
import com.beisheng.snatch.model.ShopDetailListVO;
import com.beisheng.snatch.model.ShopDetailVO;
import com.beisheng.snatch.model.UserInfoVO;
import com.beisheng.snatch.view.NumberButton;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.dou361.dialogui.DialogUIUtils;
import com.dou361.dialogui.bean.BuildBean;
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
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.rey.material.app.BottomSheetDialog;
import com.rey.material.widget.CheckBox;
import com.squareup.picasso.Picasso;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.vondear.rxui.view.dialog.RxDialogSure;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.interfaces.PayCallback;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wuzhanglong.library.mode.PayInfoVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.BottomDialogUtil;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.utils.PayUtis;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.wuzhanglong.library.utils.ShareUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;
import cn.iwgang.countdownview.CountdownView;
import de.hdodenhof.circleimageview.CircleImageView;

public class ShopDetailActivity extends BaseActivity implements ScrollableHelper.ScrollableContainer, View.OnClickListener, OnLoadMoreListener, BGAOnRVItemClickListener, PostCallback {
    private LuRecyclerView mRecyclerView;
    private ShopDetailAdapter mAdapter;
    private LinearLayout mBottomLayout, mNumberTrendLayout;
    private LinearLayout mHeadLayout;
    private TextView mTitleTv, mBackTv;
    private ImageView mHomeImg, mShareImg;
    private LineChart mLineChart;
    private ScrollableLayout mScrollableLayout;
    private TextView mJoinCartTv, mQuckBuyTv;
    private BottomSheetDialog mDialog;
    private ShopDetailVO.DataBean mShopDetailVO;
    private Banner mBanner;
    private TextView mDescTv, mStatusTv, mHonor1GradeTv, mHonor1NameTv, mHonor1CountTv, mHonor2GradeTv, mHonor2NameTv, mHonor2CountTv,
            mHonor3GradeTv, mHonor3NameTv, mHonor3CountTv;
    private View mLayoutType1, mLayoutType2, mLayoutType3;
    private TextView mType3NameTv, mType3NumberTv, mType3BuyCoutTv, mType3TimeTv, mType3UserNoTv, mType3RunTv, mType3WinTv, mType3MyBuyTv;
    private TextView mType1NumberTv, mType1JoinCountTv, mType1TotalCountTv;
    private CircleImageView mType3HeadImg, mHonor1HeadImg, mHonor2HeadImg, mHonor3HeadImg;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private TextView mPublishTimeTv;
    private String[] mXData = new String[]{"100", "开始", "中前", "中间", "中后", "疯抢",};
    private ProgressBar mProgressBar;
    private TagFlowLayout mType2NumberLayout;
    private TextView mType2MyBuyCoutTv, mType2TimeTv, mType2RunTv;
    private CountdownView mType2CountdownView;
    private ImageView mType2MoreImg;
    private TextView mDiscussTv, mPastBuyTv;
    private TextView mRegistOkTv, mRegistGetMsgCodeTv, mLoginOkTv, mLoginBackPasswordTv, mLoginChangeLoginTypeTv, mLoginTypeTv, mLoginMsgPhoneEt, mLoginMsgCodeEt, mLoginMsgGetCodeTv,
            mLoginBindPhoneTv, mBackPwdTv;
    private EditText mRegistCodeEt, mRegistPhoneEt, mRegistPaswrodEt, mLoginPhoneEt, mLoginPasswordEt, mBackPwdSureEt;
    private boolean mRegistCodeStae = true;
    private String mSuccessType = "";//1注册验证码2注册3手机号登陆4短信登陆5加入购物车//6威信登录7QQ登录//8找回密码发送验证码//10找回密码9邦定手机号发送验证码//11邦定手机号
    private String mLoginType = "1";//1手机号登陆2短信登陆
    private String mOhterLoginType = "1";//1微信2QQ
    private CheckBox mRegistCheckBox;
    private BottomSheetDialog mRegistDialog, mLoginTypeDialog, mLoginDialog, mBackPwdDialog, mBindPhoneDialog;
    private View mLoginPasswrodLayout, mLoginMsgLayout;
    private ImageView mAddFavorImg, mKeFuImg;
    private String mIsFavor = "0";
    private String mPayType = "", mRedId = "";
    private BottomSheetDialog mPayDialog;
    private TextView mPayTypeTv, mRedMoneyTv, mBuyTv;
    private int mTotalCount = 0;
    private PayTypeVO mPayTypeVO;
    private PayTypeVO.DataBean.ListBean mPaySellectVO;
    private PayRedVO mPayRedVO;
    private TextView mCount1, mCount2, mCount3, mCount4, mCount5;
    private NumberButton mNumberButton;
    private TextView mLoginTv, mRegistTv, mLoginWeixinTv, mLoginQqTv;
    private UserInfoVO mUserInfoVO;
    private LinearLayout mRankOneLayout, mRankTwoLayout, mRankThreeLayout, mRankRuleLayout;

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
        mKeFuImg = getViewById(R.id.kefu_img);
        mLineChart = getViewById(R.id.lineChart);

        mBanner = getViewById(R.id.banner);
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mDescTv = getViewById(R.id.desc_tv);
        mStatusTv = getViewById(R.id.status_tv);
        mLayoutType1 = getViewById(R.id.layout_type1);
        mLayoutType2 = getViewById(R.id.layout_type2);
        mLayoutType3 = getViewById(R.id.layout_type3);
        mType1NumberTv = getViewById(R.id.type1_number_tv);
        mType1JoinCountTv = getViewById(R.id.type1_join_count_tv);
        mType1TotalCountTv = getViewById(R.id.type1_total_count_tv);
        mProgressBar = getViewById(R.id.progress_bar);
        mType3NameTv = getViewById(R.id.type3_name_tv);
        mType3NumberTv = getViewById(R.id.type3_number_tv);
        mType3BuyCoutTv = getViewById(R.id.type3_buy_cout);
        mType3TimeTv = getViewById(R.id.type3_time_tv);
        mType3HeadImg = getViewById(R.id.type3_head_img);
        mType3UserNoTv = getViewById(R.id.type3_user_no_tv);
        mType3WinTv = getViewById(R.id.type3_win_tv);
        mHonor1HeadImg = getViewById(R.id.honor1_head_img);
        mHonor2HeadImg = getViewById(R.id.honor2_head_img);
        mHonor3HeadImg = getViewById(R.id.honor3_head_img);
        mHonor1GradeTv = getViewById(R.id.honor1_grade_tv);
        mHonor2GradeTv = getViewById(R.id.honor2_grade_tv);
        mHonor3GradeTv = getViewById(R.id.honor3_grade_tv);
        mHonor1NameTv = getViewById(R.id.honor1_name_tv);
        mHonor2NameTv = getViewById(R.id.honor2_name_tv);
        mHonor3NameTv = getViewById(R.id.honor3_name_tv);
        mHonor1CountTv = getViewById(R.id.honor1_count_tv);
        mHonor2CountTv = getViewById(R.id.honor2_count_tv);
        mHonor3CountTv = getViewById(R.id.honor3_count_tv);
        mPublishTimeTv = getViewById(R.id.publish_time_tv);
        mType2NumberLayout = getViewById(R.id.number_layout);
        mType2MyBuyCoutTv = getViewById(R.id.type2_my_cout_tv);
        mType2TimeTv = getViewById(R.id.type2_time_tv);
        mType2RunTv = getViewById(R.id.type2_run_tv);
        mType2CountdownView = getViewById(R.id.type2_countdown_view);
        mType2MoreImg = getViewById(R.id.type2_more_img);
        mDiscussTv = getViewById(R.id.discuss_tv);
        mPastBuyTv = getViewById(R.id.past_buy_tv);
        mAddFavorImg = getViewById(R.id.add_favor_img);
        mType3RunTv = getViewById(R.id.type3_run_tv);
        mType3MyBuyTv = getViewById(R.id.type3_my_buy_tv);
        mRankOneLayout = getViewById(R.id.rank_one_layout);
        mRankTwoLayout = getViewById(R.id.rank_two_layout);
        mRankThreeLayout = getViewById(R.id.rank_three_layout);
        mRankRuleLayout = getViewById(R.id.rank_rule_layout);
        initLineChart();
    }

    public void initLineChart() {
        //设置描述文本不显示
        mLineChart.getDescription().setEnabled(false);
        //设置是否显示表格背景
        mLineChart.setDrawGridBackground(false);
        //设置是否可以触摸
        mLineChart.setTouchEnabled(true);
        mLineChart.setDragDecelerationFrictionCoef(0.9f);
        //设置是否可以拖拽
        mLineChart.setDragEnabled(true);
        //设置是否可以缩放
        mLineChart.setScaleEnabled(false);
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
//                if (mShopDetailVO.getChart_data().size() == 0) {
//                    return "";
//                } else {
//                    int index = (int) value;
////                    return mShopDetailVO.getChart_data().get(index - 1).getPf_no();
//                    return "8525585252";
//
//                }
                int index = (int) value;
//                    return mShopDetailVO.getChart_data().get(index - 1).getPf_no();
                if (index == 0) {
                    return "";
                } else {
                    return "8525585252";
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
        xAxis.setTextColor(ContextCompat.getColor(this, R.color.C4));
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
                return list.get(yIndex / 100 - 1);
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
        leftAxis.setTextColor(ContextCompat.getColor(this, R.color.C5));
        //设置左边X轴显示
        leftAxis.setEnabled(true);
        //设置Y轴的颜色
        leftAxis.setAxisLineColor(ContextCompat.getColor(this, R.color.colorAccent));
        //设置Y轴的宽度
        leftAxis.setAxisLineWidth(1f);
        leftAxis.setAxisMinimum(100f);
//        leftAxis.setAxisMaximum(500f);


        YAxis rightAxis = mLineChart.getAxisRight();
        //设置右边Y轴不显示
        rightAxis.setEnabled(false);

        //显示边界
        mLineChart.setDrawBorders(false);
    }


    @Override
    public void bindViewsListener() {
        mNumberTrendLayout.setOnClickListener(this);
        mJoinCartTv.setOnClickListener(this);
        mQuckBuyTv.setOnClickListener(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mAdapter.setOnRVItemClickListener(this);
        mType2MoreImg.setOnClickListener(this);
        mPastBuyTv.setOnClickListener(this);
        mDiscussTv.setOnClickListener(this);
        mAddFavorImg.setOnClickListener(this);
        mType2RunTv.setOnClickListener(this);
        mType3RunTv.setOnClickListener(this);
        mBackTv.setOnClickListener(this);
        mShareImg.setOnClickListener(this);
        mQuckBuyTv.setOnClickListener(this);
        mType3MyBuyTv.setOnClickListener(this);
        mKeFuImg.setOnClickListener(this);
        EventBus.getDefault().register(this);
        mRankOneLayout.setOnClickListener(this);
        mRankTwoLayout.setOnClickListener(this);
        mRankThreeLayout.setOnClickListener(this);
        mRankRuleLayout.setOnClickListener(this);
    }


    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        if (AppApplication.getInstance().getUserInfoVO() != null)
            map.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        map.put("id", this.getIntent().getStringExtra("id"));
//        map.put("id", "2");
        BSHttpUtils.post(mActivity, this, Constant.SHOP_DETAIL_URL, map, ShopDetailVO.class);
        HashMap<String, Object> mapList = new HashMap<>();
        mapList.put("curpage", mCurrentPage + "");
//        mapList.put("id", "2");
        mapList.put("id", this.getIntent().getStringExtra("id"));

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
                    imageView.setScaleType(ImageView.ScaleType.CENTER);
                    String url = (String) o;
                    Picasso.with(context).load(url).into(imageView);
                }
            });
            mBanner.start();
            mDescTv.setText(mShopDetailVO.getGoods_name());
            mType1NumberTv.setText(mShopDetailVO.getIssue_no());


            switch (mShopDetailVO.getPrise_status()) {
                case "1":
                    mLayoutType1.setVisibility(View.VISIBLE);
                    mStatusTv.setText(mShopDetailVO.getStatus_text());
                    mStatusTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.colorAccent, R.color.C1));
                    mStatusTv.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                    BaseCommonUtils.setTextThree(this, mType1JoinCountTv, "已参与", mShopDetailVO.getBuy_count(), "次", R.color.colorAccent, 1.3f);
                    BaseCommonUtils.setTextThree(this, mType1TotalCountTv, "剩余", mShopDetailVO.getRemain_count(), "人次", R.color.colorAccent, 1.3f);
                    mProgressBar.setProgress(BaseCommonUtils.parseInt(mShopDetailVO.getPercent()));
                    break;
                case "2":
                    mLayoutType2.setVisibility(View.VISIBLE);
                    mStatusTv.setText(mShopDetailVO.getStatus_text());
                    mStatusTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.colorAccent, R.color.C1));
                    mStatusTv.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                    BaseCommonUtils.setTextThree(this, mType2MyBuyCoutTv, "你抢购了", mShopDetailVO.getUser_data().getBuy_count(), "次(抢购号码如下)", R.color.colorAccent, 1.3f);

                    List<String> allList = (List<String>) mShopDetailVO.getUser_data().getBuy_codes();
                    mType2NumberLayout.setAdapter(new TagAdapter<String>(allList.subList(0, 12)) {
                        @Override
                        public View getView(FlowLayout parent, int position, String s) {
                            TextView tv = new TextView(ShopDetailActivity.this);
                            tv.setText(s);
                            return tv;
                        }
                    });
                    mType2CountdownView.start(BaseCommonUtils.parseLong(mShopDetailVO.getCreate_time()) * 1000); // Millisecond
                    mType2RunTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.C1, R.color.colorAccent));
                    break;
                case "3":
                    mLayoutType3.setVisibility(View.VISIBLE);
                    mStatusTv.setText(mShopDetailVO.getStatus_text());
                    mStatusTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.snatch_02, R.color.C1));
                    mStatusTv.setTextColor(ContextCompat.getColor(this, R.color.snatch_02));
                    if (!TextUtils.isEmpty(mShopDetailVO.getLucky_user().getAvatar()))
                        Picasso.with(this).load(mShopDetailVO.getLucky_user().getAvatar()).into(mType3HeadImg);
                    mType3NumberTv.setText("期号：" + mShopDetailVO.getIssue_no());
                    mType3NameTv.setText("获奖者：" + mShopDetailVO.getLucky_user().getNickname());
                    mType3UserNoTv.setText("用户ID：" + mShopDetailVO.getLucky_user().getUser_no());
                    mType3BuyCoutTv.setText("抢购次数：" + mShopDetailVO.getLucky_user().getBuy_count() + "次");
                    mType3TimeTv.setText("揭晓时间：" + mShopDetailVO.getLucky_user().getPublish_time());
                    mType3WinTv.setText("幸运号码：" + mShopDetailVO.getLucky_user().getPrise_code());
                    mType3RunTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.C1, R.color.colorAccent));

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
                mHonor2GradeTv.setText("二当家");
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
                mHonor3GradeTv.setText("小地主");
                mHonor3GradeTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 5, R.color.C3, R.color.C3));
                mHonor3NameTv.setText("虚拟待位");
                mHonor3CountTv.setText("最后一个参与");
            }

            if (mShopDetailVO.getChart_data().size() > 0) {
                ArrayList<Entry> entries = new ArrayList<>();
                entries.add(new Entry(0, 100));
                for (int i = 0; i < mShopDetailVO.getChart_data().size(); i++) {
                    entries.add(new Entry(i + 1, Integer.parseInt(mShopDetailVO.getChart_data().get(i).getBuy_period()) * 100 + 100));
                }
//            for (int i = 0; i < 6; i++) {
//                entries.add(new Entry(i , i*100+100));
//            }

                // 每一个LineDataSet代表一条线
                LineDataSet lineDataSet = new LineDataSet(entries, "用户");
                lineDataSet.setCircleColor(ContextCompat.getColor(this, R.color.colorAccent));
                lineDataSet.setValueTextColor(ContextCompat.getColor(this, R.color.colorAccent));
                lineDataSet.setColor(ContextCompat.getColor(this, R.color.colorAccent));
                lineDataSet.setValueFormatter(new IValueFormatter() {
                    @Override
                    public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                        int IValue = (int) value;
                        if (IValue == 100) {
                            return "";
                        } else {
                            return "疯抢";
                        }

                    }
                });
                ArrayList<ILineDataSet> dataSets = new ArrayList<>();
                dataSets.add(lineDataSet);
                LineData data = new LineData(dataSets);
                //设置X轴的刻度数
//        xAxis.setLabelCount(xAxisValues.size(), true);
//        //设置一页最大显示个数为6，超出部分就滑动
                float ratio = (float) entries.size() / (float) 5;
                //显示的时候是按照多大的比率缩放显示,1f表示不放大缩小
                mLineChart.zoom(ratio, 1f, 0, 0);
                mLineChart.setData(data);
            }


            if ("1".equals(mShopDetailVO.getIs_favor())) {
                mAddFavorImg.setImageResource(R.drawable.collect_img_select);
            } else {
                mAddFavorImg.setImageResource(R.drawable.collect_img_normal);
            }

            mIsFavor = mShopDetailVO.getIs_favor();
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
            } else {
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
        Bundle bundle = new Bundle();
        switch (v.getId()) {
            case R.id.number_trend_layout:
                bundle.putString("id", mShopDetailVO.getGoods_id());
                open(NumberTrendActivity.class, bundle, 0);
                break;
            case R.id.jion_cart_tv:
                if (AppApplication.getInstance().getUserInfoVO() == null) {
                    loginType();
                    return;
                }
                HashMap<String, Object> jionMap = new HashMap<>();
                jionMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                jionMap.put("panic_id", mShopDetailVO.getId());//
                BSHttpUtils.postCallBack(mActivity, Constant.SHOPCAT_JOIN_URL, jionMap, BaseVO.class, this);
                mSuccessType = "5";
                break;
            case R.id.quick_tv:
                if (AppApplication.getInstance().getUserInfoVO() == null) {
                    loginType();
                    return;
                }
                quickBuy();
                break;

            case R.id.type2_more_img:
                List<String> allList = (List<String>) mShopDetailVO.getUser_data().getBuy_codes();
                mType2NumberLayout.setAdapter(new TagAdapter<String>(allList) {
                    @Override
                    public View getView(FlowLayout parent, int position, String s) {
                        TextView tv = new TextView(ShopDetailActivity.this);
                        tv.setText(s);
                        return tv;
                    }
                });
                v.setVisibility(View.GONE);
                break;
            case R.id.discuss_tv:
                bundle.putString("id", mShopDetailVO.getGoods_id());
                open(DisscussActivity.class, bundle, 0);
                break;
            case R.id.past_buy_tv:
                bundle.putString("id", mShopDetailVO.getGoods_id());
                open(PastBuyActivity.class, bundle, 0);
                break;
            case R.id.regist_get_msge_code_tv:

                if (mRegistCodeStae) {
                    if (TextUtils.isEmpty(mRegistPhoneEt.getText().toString())) {
                        showCustomToast("请填写手机号");
                        return;
                    }
                    HashMap<String, Object> registMsgMap = new HashMap<>();
                    registMsgMap.put("mobile", mRegistPhoneEt.getText().toString());
                    if ("8".equals(mSuccessType)) {
                        registMsgMap.put("type", "5");// 1-注册验证码 2-验证码登录 3-修改密码 4-绑定手机号 5-忘记密码
                    } else {
                        registMsgMap.put("type", "1");// 1-注册验证码 2-验证码登录 3-修改密码
                    }
                    mRegistGetMsgCodeTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.C6, R.color.C6));
                    BSHttpUtils.postCallBack(mActivity, Constant.GET_MSG_CODE_URL, registMsgMap, BaseVO.class, this);
                    daoJishi(mRegistGetMsgCodeTv);
                    mRegistCodeStae = false;
                }

                break;

            case R.id.register_ok_tv:
                if (TextUtils.isEmpty(mRegistPhoneEt.getText().toString())) {
                    showCustomToast("请填写手机号");
                    return;
                }
                if (TextUtils.isEmpty(mRegistCodeEt.getText().toString())) {
                    showCustomToast("请填验证码");
                    return;
                }
                if (TextUtils.isEmpty(mRegistPaswrodEt.getText().toString())) {
                    showCustomToast("请填写注册密码");
                    return;
                }

                if (!mRegistCheckBox.isChecked()) {
                    showCustomToast("请同意服务条款与隐私相关权限");
                    return;
                }
                mSuccessType = "2";
                HashMap<String, Object> registMap = new HashMap<>();
                registMap.put("mobile", mRegistPhoneEt.getText().toString());
                registMap.put("sms_code", mRegistCodeEt.getText().toString());
                registMap.put("password", mRegistPaswrodEt.getText().toString());
                registMap.put("platform", "1");

                BSHttpUtils.postCallBack(mActivity, Constant.REGIST_URL, registMap, BaseVO.class, this);
                break;

            case R.id.login_back_passwrod_tv:
                mBackPwdDialog = BottomDialogUtil.initBottomDialog(this, R.layout.login__back_pwd);
                mRegistCodeEt = mBackPwdDialog.findViewById(R.id.regist_msg_et);
                mRegistPhoneEt = mBackPwdDialog.findViewById(R.id.regist_phone_et);
                mRegistPaswrodEt = mBackPwdDialog.findViewById(R.id.regist_password_et);
                mRegistCheckBox = mBackPwdDialog.findViewById(R.id.regist_check_box);
                mBackPwdTv = mBackPwdDialog.findViewById(R.id.back_pwd_tv);
                mBackPwdSureEt = mBackPwdDialog.findViewById(R.id.sure_password_et);
                mRegistGetMsgCodeTv = mBackPwdDialog.findViewById(R.id.regist_get_msge_code_tv);
                mRegistGetMsgCodeTv.setOnClickListener(this);
                mBackPwdTv.setOnClickListener(this);
                mSuccessType = "8";
                break;
            case R.id.login_change_login_type_tv:
                if ("1".equals(mLoginType)) {
                    mLoginType = "2";
                    mLoginMsgLayout.setVisibility(View.VISIBLE);
                    mLoginPasswrodLayout.setVisibility(View.GONE);
                    mLoginChangeLoginTypeTv.setText("使用短信登陆");
                } else {
                    mLoginType = "1";
                    mLoginMsgLayout.setVisibility(View.GONE);
                    mLoginPasswrodLayout.setVisibility(View.VISIBLE);
                    mLoginChangeLoginTypeTv.setText("使用密码登陆");
                }

                break;
            case R.id.login_ok_tv:
                if ("2".equals(mLoginType)) {
                    if (TextUtils.isEmpty(mLoginMsgPhoneEt.getText().toString())) {
                        showCustomToast("请填写手机号");
                        return;
                    }

                    if (TextUtils.isEmpty(mLoginMsgCodeEt.getText().toString())) {
                        showCustomToast("请填验证码");
                        return;
                    }

                } else {
                    if (TextUtils.isEmpty(mLoginPhoneEt.getText().toString())) {
                        showCustomToast("请填写手机号");
                        return;
                    }
                    if (TextUtils.isEmpty(mLoginPasswordEt.getText().toString())) {
                        showCustomToast("请填写注册密码");
                        return;
                    }
                }

                HashMap<String, Object> loginMap = new HashMap<>();
                if ("1".equals(mLoginType)) {
                    loginMap.put("username", mLoginPhoneEt.getText().toString());
                    loginMap.put("password", mLoginPasswordEt.getText().toString());
                    BSHttpUtils.postCallBack(mActivity, Constant.LOGIN_PASSWORD_URL, loginMap, UserInfoVO.class, this);
                    mSuccessType = "3";
                } else {
                    loginMap.put("mobile", mLoginMsgPhoneEt.getText().toString());
                    loginMap.put("sms_code", mLoginMsgCodeEt.getText().toString());
                    BSHttpUtils.postCallBack(mActivity, Constant.LOGIN_MSG_URL, loginMap, UserInfoVO.class, this);
                    mSuccessType = "4";
                }

                break;

            case R.id.login_get_msg_code_tv:
                if (mRegistCodeStae) {
                    if (TextUtils.isEmpty(mLoginMsgPhoneEt.getText().toString())) {
                        showCustomToast("请填写手机号");
                        return;
                    }

                    HashMap<String, Object> registMsgMap = new HashMap<>();
                    registMsgMap.put("mobile", mLoginMsgPhoneEt.getText().toString());
                    if ("9".equals(mSuccessType)) {
                        registMsgMap.put("type", "4");// 1-注册验证码 2-验证码登录 3-修改密码 4-绑定手机号 5-忘记密码
                    } else {
                        registMsgMap.put("type", "2");// 1-注册验证码 2-验证码登录 3-修改密码
                    }
                    mLoginMsgGetCodeTv.setBackground(BaseCommonUtils.setBackgroundShap(this, 30, R.color.C6, R.color.C6));
                    BSHttpUtils.postCallBack(mActivity, Constant.GET_MSG_CODE_URL, registMsgMap, BaseVO.class, this);
                    daoJishi(mLoginMsgGetCodeTv);
                    mRegistCodeStae = false;
                }
                break;

            case R.id.add_favor_img:
                if (AppApplication.getInstance().getUserInfoVO() == null) {
                    mLoginTypeDialog = BottomDialogUtil.initBottomDialog(this, R.layout.login_type);
                    return;
                }
                HashMap<String, Object> favorMap = new HashMap<>();
                favorMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());

                if ("1".equals(mIsFavor)) {
                    mIsFavor = "0";
                    mAddFavorImg.setImageResource(R.drawable.collect_img_normal);
                    favorMap.put("fav_id", mShopDetailVO.getId());
                    BSHttpUtils.postCallBack(mActivity, Constant.FAVOR_CANCEL_URL, favorMap, BaseVO.class, this);
                } else {
                    mIsFavor = "1";
                    mAddFavorImg.setImageResource(R.drawable.collect_img_select);
                    favorMap.put("id", mShopDetailVO.getId());
                    BSHttpUtils.postCallBack(mActivity, Constant.FAVOR_ADD_URL, favorMap, BaseVO.class, this);
                }
                break;
            case R.id.type2_run_tv:
            case R.id.type3_run_tv:
                bundle.putString("title", "运算详情");
                bundle.putString("url", mShopDetailVO.getCalc_detail_url());
                open(WebViewActivity.class, bundle, 0);
                break;

            case R.id.back_tv:
                this.finish();
                break;
            case R.id.share_img:

                if (Build.VERSION.SDK_INT >= 23) {
                    String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission
                            .READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW,
                            Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
                    ActivityCompat.requestPermissions(this, mPermissionList, 123);
                } else {
                    String title = ACache.get(mActivity).getAsString("share_title");
                    String desc = ACache.get(mActivity).getAsString("share_desc");
                    String img = ACache.get(mActivity).getAsString("share_img");
                    String url = ACache.get(mActivity).getAsString("share_url");
                    ShareUtil.share(this, img, title, desc, url);
                }
                break;
            case R.id.pay_type_tv:
//                BottomSheetDialog payuDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.buy_pay_dialog);
                final BottomSheetDialog payTypeDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.pay_type_list_dialog);
                LuRecyclerView payTyperecyclerView = payTypeDialog.getWindow().getDecorView().findViewById(R.id.dialog_recycler_view);
                final PayTypeAdapter payTypeDialogAdapter = new PayTypeAdapter(payTyperecyclerView);
                RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, payTyperecyclerView, payTypeDialogAdapter, R.dimen.dp_1, R.color.C3, false);
                if (mPayTypeVO != null) {
                    List<PayTypeVO.DataBean.ListBean> list = mPayTypeVO.getData().getList();
                    if (mPaySellectVO == null) {
                        mPaySellectVO = list.get(0);
                        mPaySellectVO.setCheck(true);
                    }

                    payTypeDialogAdapter.updateData(list);
                    mPayType = list.get(0).getPayment_code();
                }
                payTypeDialogAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                    @Override
                    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                        PayTypeVO.DataBean.ListBean bean = (PayTypeVO.DataBean.ListBean) payTypeDialogAdapter.getItem(position);
//                        for (int i = 0; i < payTypeDialogAdapter.getData().size(); i++) {
//                            ((PayTypeVO.DataBean.ListBean)payTypeDialogAdapter.getData().get(i)).setCheck(false);
//                        }
                        mPaySellectVO.setCheck(false);
                        mPaySellectVO = bean;
                        mPaySellectVO.setCheck(true);
                        payTypeDialogAdapter.notifyDataSetChanged();
                        mPayTypeTv.setText(bean.getPayment_name());
                        mPayType = bean.getPayment_code();
                        if ("BALANCE".equals(bean.getPayment_code()) && BaseCommonUtils.parseInt(mPayRedVO.getData().getCoupon_count()) > 0) {
                            mRedMoneyTv.setTextColor(mActivity.getResources().getColor(R.color.colorAccent));
                            mRedMoneyTv.setClickable(true);
                        } else {
                            mRedMoneyTv.setTextColor(mActivity.getResources().getColor(R.color.C6));
                            mRedMoneyTv.setClickable(false);
                        }
                        payTypeDialog.dismiss();
                    }
                });

                break;
            case R.id.red_money_tv:
                final BottomSheetDialog redDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.red_money_list_dialog);
                LuRecyclerView recyclerView = redDialog.getWindow().getDecorView().findViewById(R.id.dialog_recycler_view);
                final RedMoneyAdapter dialogAdapter = new RedMoneyAdapter(recyclerView);
                RecyclerViewUtil.initRecyclerViewLinearLayout(mActivity, recyclerView, dialogAdapter, R.dimen.dp_10, R.color.C3, false);
                if (mPayRedVO != null)
                    dialogAdapter.updateData(mPayRedVO.getData().getCoupon_list());
                dialogAdapter.setOnRVItemClickListener(new BGAOnRVItemClickListener() {
                    @Override
                    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
                        PayRedVO.DataBean.CouponListBean bean = (PayRedVO.DataBean.CouponListBean) dialogAdapter.getItem(position);
                        mRedMoneyTv.setText("抵扣" + bean.getMoney() + "元");
                        mRedId = bean.getCoupon_id();
                        redDialog.dismiss();
                    }
                });
                break;

            case R.id.count1_tv:
            case R.id.count2_tv:
            case R.id.count3_tv:
            case R.id.count4_tv:
            case R.id.count5_tv:
                coountTv(v, v.getId());
                break;

            case R.id.buy_tv:
                final StringBuffer sb = new StringBuffer();
                sb.append(mShopDetailVO.getId()).append("|").append(mTotalCount + "");
                HashMap<String, Object> buyMap = new HashMap<>();
                buyMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                buyMap.put("cart_info", sb.toString());
                buyMap.put("payment_code", mPayType);
                buyMap.put("coupon_id", mRedId);
                buyMap.put("platform", "1");
                BSHttpUtils.postCallBack(mActivity, Constant.SHOPCAT_BUY_URL, buyMap, PayInfoVO.class, this);
                break;
            case R.id.login_tv:
                mLoginType = "1";
                mSuccessType = "1";
                mLoginDialog = BottomDialogUtil.initBottomDialog(this, R.layout.login_layout);
                mLoginPhoneEt = mLoginDialog.findViewById(R.id.login_phone_et);
                mLoginPasswordEt = mLoginDialog.findViewById(R.id.login_password_et);
                mLoginBackPasswordTv = mLoginDialog.findViewById(R.id.login_back_passwrod_tv);
                mLoginChangeLoginTypeTv = mLoginDialog.findViewById(R.id.login_change_login_type_tv);
                mLoginOkTv = mLoginDialog.findViewById(R.id.login_ok_tv);
                mLoginPasswrodLayout = mLoginDialog.findViewById(R.id.login_passwrod_layout);
                mLoginMsgLayout = mLoginDialog.findViewById(R.id.Login_msg_layout);
                mLoginTypeTv = mLoginDialog.findViewById(R.id.login_type_tv);
                mLoginMsgPhoneEt = mLoginDialog.findViewById(R.id.login_msg_phone_et);
                mLoginMsgCodeEt = mLoginDialog.findViewById(R.id.login_msg_code_et);
                mLoginMsgGetCodeTv = mLoginDialog.findViewById(R.id.login_get_msg_code_tv);
                mLoginMsgGetCodeTv.setOnClickListener(this);
                mLoginChangeLoginTypeTv.setOnClickListener(this);
                mLoginBackPasswordTv.setOnClickListener(this);
                mLoginOkTv.setOnClickListener(this);
                break;
            case R.id.regist_tv:
                mRegistDialog = BottomDialogUtil.initBottomDialog(this, R.layout.login_regist);
                mRegistCodeEt = mRegistDialog.findViewById(R.id.regist_msg_et);
                mRegistPhoneEt = mRegistDialog.findViewById(R.id.regist_phone_et);
                mRegistPaswrodEt = mRegistDialog.findViewById(R.id.regist_password_et);
                mRegistCheckBox = mRegistDialog.findViewById(R.id.regist_check_box);
                mRegistOkTv = mRegistDialog.findViewById(R.id.register_ok_tv);
                mRegistGetMsgCodeTv = mRegistDialog.findViewById(R.id.regist_get_msge_code_tv);
                mRegistGetMsgCodeTv.setOnClickListener(this);
                mRegistOkTv.setOnClickListener(this);
                mSuccessType = "1";
                break;

            case R.id.login_weixin_tv:
                mOhterLoginType = "1";
                UMShareAPI shareAPI = UMShareAPI.get(this);
                shareAPI.getPlatformInfo(this, SHARE_MEDIA.WEIXIN, authListener);

                break;
            case R.id.login_qq_tv:
                mOhterLoginType = "2";
                UMShareAPI shareQqAPI = UMShareAPI.get(this);
                shareQqAPI.getPlatformInfo(this, SHARE_MEDIA.QQ, authListener);
                break;
            case R.id.type3_my_buy_tv:
                showDialog();
                break;

            case R.id.login_bind_phone_tv:
                if (TextUtils.isEmpty(mLoginMsgPhoneEt.getText().toString())) {
                    showCustomToast("请填写手机号");
                    return;
                }

                if (TextUtils.isEmpty(mLoginMsgCodeEt.getText().toString())) {
                    showCustomToast("请填验证码");
                    return;
                }
                HashMap<String, Object> bindPhoneMap = new HashMap<>();
                bindPhoneMap.put("mobile", mLoginMsgPhoneEt.getText().toString());
                bindPhoneMap.put("sms_code", mLoginMsgCodeEt.getText().toString());
                bindPhoneMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                BSHttpUtils.postCallBack(mActivity, Constant.LOGIN_BIND_PHONE_URL, bindPhoneMap, UserInfoVO.class, this);
                mSuccessType = "11";
                break;

            case R.id.back_pwd_tv:
                if (TextUtils.isEmpty(mRegistPhoneEt.getText().toString())) {
                    showCustomToast("请填写手机号");
                    return;
                }
                if (TextUtils.isEmpty(mRegistCodeEt.getText().toString())) {
                    showCustomToast("请填验证码");
                    return;
                }
                if (TextUtils.isEmpty(mRegistPaswrodEt.getText().toString())) {
                    showCustomToast("请填写新的密码");
                    return;
                }
                if (TextUtils.isEmpty(mBackPwdSureEt.getText().toString())) {
                    showCustomToast("请确认密码");
                    return;
                }

                if (!mRegistPaswrodEt.getText().toString().equals(mBackPwdSureEt.getText().toString())) {
                    showCustomToast("密码不一致");
                    return;
                }


                mSuccessType = "10";
                HashMap<String, Object> backMap = new HashMap<>();
                backMap.put("mobile", mRegistPhoneEt.getText().toString());
                backMap.put("sms_code", mRegistCodeEt.getText().toString());
                backMap.put("password", mRegistPaswrodEt.getText().toString());
                backMap.put("repassword", mBackPwdSureEt.getText().toString());

                BSHttpUtils.postCallBack(mActivity, Constant.BACK_PWD_URL, backMap, BaseVO.class, this);
                break;

            case R.id.kefu_img:
                openActivity(HelpActivity.class);
                break;

            case R.id.rank_one_layout:
                bundle.putString("id", mShopDetailVO.getDfw_data().getUid());
                open(PersonalCenterActivity.class, bundle, 0);
                break;
            case R.id.rank_two_layout:
                bundle.putString("id", mShopDetailVO.getEdj_data().getUid());
                open(PersonalCenterActivity.class, bundle, 0);
                break;
            case R.id.rank_three_layout:
                bundle.putString("id", mShopDetailVO.getXdz_data().getUid());
                open(PersonalCenterActivity.class, bundle, 0);
                break;
            case R.id.rank_rule_layout:
                showCustomDialog("上榜规则",mShopDetailVO.getHonor_rule());
                break;
            default:

                break;
        }
    }


    @Override
    public void onLoadMore() {
        isLoadMore = true;
        mCurrentPage++;
        getData();
    }


    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if (mAdapter.getData().size() == 0)
            return;
        Bundle bundle = new Bundle();
        ShopDetailListVO.DataBean.ListBean vo = (ShopDetailListVO.DataBean.ListBean) mAdapter.getItem(position);
        bundle.putString("id", vo.getUid());
        open(PersonalCenterActivity.class, bundle, 0);
    }

    public void daoJishi(final TextView tv) {
        final CountDownTimer timer = new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long arg0) {
                tv.setText(arg0 / 1000 + "s后重发 ");
            }

            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onFinish() {
                tv.setText("获取验证码");
                mRegistCodeStae = true;
                tv.setBackground(BaseCommonUtils.setBackgroundShap(ShopDetailActivity.this, 30, R.color.color_yellow, R.color.color_yellow));
            }
        };
        timer.start();

    }

    @Override
    public void success(BaseVO vo) {

        if ("2".equals(mSuccessType)) {
            showSuccessToast(vo.getDesc());
            if (mRegistDialog != null)
                mRegistDialog.dismiss();
        } else if ("3".equals(mSuccessType) || "4".equals(mSuccessType) || "6".equals(mSuccessType) || "7".equals(mSuccessType)) {
            showSuccessToast(vo.getDesc());
            mUserInfoVO = (UserInfoVO) vo;

            if (!"1".equals(mUserInfoVO.getData().getUser_tel_bind())) {
                bindPhone();
            } else {
                if (mLoginDialog != null)
                    mLoginDialog.dismiss();
                if (mLoginTypeDialog != null)
                    mLoginTypeDialog.dismiss();
                AppApplication.getInstance().saveUserInfoVO(mUserInfoVO);
            }

        } else if ("8".equals(mSuccessType)) {
            //忘记密码发送验证码
            showSuccessToast(vo.getDesc());
        } else if ("10".equals(mSuccessType)) {
            //忘记密码
            showSuccessToast(vo.getDesc());
        } else if ("9".equals(mSuccessType)) {
            //绑定手机号
            if (mBindPhoneDialog != null)
                mBindPhoneDialog.dismiss();
            AppApplication.getInstance().saveUserInfoVO(mUserInfoVO);
        } else if ("11".equals(mSuccessType)) {
            if (mBackPwdDialog != null)
                mBackPwdDialog.dismiss();
            if (mLoginDialog != null)
                mLoginDialog.dismiss();
            if (mLoginTypeDialog != null)
                mLoginTypeDialog.dismiss();
        } else if ("5".equals(mSuccessType)) {
            showSuccessToast(vo.getDesc());
            EventBus.getDefault().post(new EBMessageVO("shopcat_update"));
        } else if (vo instanceof PayTypeVO) {
            mPayTypeVO = (PayTypeVO) vo;
            mRedMoneyTv.setText(mPayRedVO.getData().getCoupon_count() + "个红包可用");
            mPayTypeTv.setText(mPayTypeVO.getData().getList().get(0).getPayment_name());
            mPayType = mPayTypeVO.getData().getList().get(0).getPayment_code();
        } else if (vo instanceof PayRedVO) {
            mPayRedVO = (PayRedVO) vo;
            if ("BALANCE".equals(mPayType) && BaseCommonUtils.parseInt(mPayRedVO.getData().getCoupon_count()) > 0) {
                mRedMoneyTv.setTextColor(ContextCompat.getColor(mActivity, R.color.colorAccent));
                mRedMoneyTv.setClickable(true);
            } else {
                mRedMoneyTv.setClickable(false);
                mRedMoneyTv.setTextColor(ContextCompat.getColor(mActivity, R.color.C6));
            }
            mRedMoneyTv.setText(mPayRedVO.getData().getCoupon_count() + "个红包可用");

        } else if (vo instanceof PayInfoVO) {
            PayInfoVO payInfoVO = (PayInfoVO) vo;
            showSuccessToast(vo.getDesc());
            if ("200".equals(vo.getCode())) {
                if ("WPAY".equals(mPayType)) {
                    PayUtis.weiXinPay(mActivity, payInfoVO.getData().getWxpay_params());

                } else if ("ALIPAY".equals(mPayType)) {
                    String payInfo = payInfoVO.getData().getAlipay_string();
                    PayUtis.zhiFuBaoPay(mActivity, payInfo, new PayCallback() {
                        @Override
                        public void payResult(int type) {
                            buyRecord();
                        }
                    });
                } else if ("ALIWAP".equals(mPayType)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("title", "支付宝支付");
                    bundle.putString("content", payInfoVO.getData().getAlipay_wap_html());
                    mActivity.open(WebViewActivity.class, bundle, 0);
                } else if ("WSCAN".equals(mPayType)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("img", payInfoVO.getData().getWx_native_qrcode());
                    bundle.putString("url", payInfoVO.getData().getPayment_status_api());
                    mActivity.open(QRCodeActivity.class, bundle, 0);
                } else if ("BALANCE".equals(mPayType)) {
                    mActivity.showCustomToast(vo.getDesc());
                    buyRecord();
                }

            }
        } else {
            showSuccessToast(vo.getDesc());
        }
    }

    public void quickBuy() {
        mPayDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.quick_buy);
        mPayTypeTv = mPayDialog.getWindow().getDecorView().findViewById(R.id.pay_type_tv);
        mRedMoneyTv = mPayDialog.getWindow().getDecorView().findViewById(R.id.red_money_tv);
        mBuyTv = mPayDialog.getWindow().getDecorView().findViewById(R.id.buy_tv);
        mNumberButton = mPayDialog.getWindow().getDecorView().findViewById(R.id.number_bt);
        if (BaseCommonUtils.parseInt(mShopDetailVO.getRemain_count()) == 0) {
            mNumberButton.setEnabled(false);
            mNumberButton.setCurrentNumber(BaseCommonUtils.parseInt("0"));
        } else {
            mNumberButton.setBuyMax(Integer.parseInt(mShopDetailVO.getRemain_count())).setCurrentNumber(BaseCommonUtils.parseInt("1"));
        }
        mNumberButton.setmOnTextChangeListener(new NumberButton.OnTextChangeListener() {
            @Override
            public void onTextChange(int count) {
                if (Integer.parseInt(mShopDetailVO.getRemain_count()) == 0) {
                    return;
                }
                mTotalCount = count;
                //可用红包
                final StringBuffer sb = new StringBuffer();
                sb.append(mShopDetailVO.getId()).append("|").append(mTotalCount + "");
                HashMap<String, Object> redMap = new HashMap<>();
                redMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
                redMap.put("cart_info", sb.toString());
                BSHttpUtils.postCallBack(mActivity, Constant.PAY_RED_LIST_URL, redMap, PayRedVO.class, ShopDetailActivity.this);
            }
        });

        mCount1 = mPayDialog.getWindow().getDecorView().findViewById(R.id.count1_tv);
        mCount2 = mPayDialog.getWindow().getDecorView().findViewById(R.id.count2_tv);
        mCount3 = mPayDialog.getWindow().getDecorView().findViewById(R.id.count3_tv);
        mCount4 = mPayDialog.getWindow().getDecorView().findViewById(R.id.count4_tv);
        mCount5 = mPayDialog.getWindow().getDecorView().findViewById(R.id.count5_tv);
        mCount1.setOnClickListener(this);
        mCount2.setOnClickListener(this);
        mCount3.setOnClickListener(this);
        mCount4.setOnClickListener(this);
        mCount5.setOnClickListener(this);
        mPayTypeTv.setOnClickListener(this);
        mRedMoneyTv.setOnClickListener(this);
        mBuyTv.setOnClickListener(this);
//                    mDialogCountTv.setText("你抢购了");//支付方式
        HashMap<String, Object> payTypeMap = new HashMap<>();
        payTypeMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        payTypeMap.put("is_recharge", "0");
        payTypeMap.put("total_count", mTotalCount + "");
        BSHttpUtils.postCallBack(mActivity, Constant.PAY_TYPE_LIST_URL, payTypeMap, PayTypeVO.class, this);

        final StringBuffer sb = new StringBuffer();
        sb.append(mShopDetailVO.getId()).append("|").append(mTotalCount + "");
        HashMap<String, Object> redMap = new HashMap<>();
        redMap.put("user_no", AppApplication.getInstance().getUserInfoVO().getData().getUser_no());
        redMap.put("cart_info", sb.toString());
        BSHttpUtils.postCallBack(mActivity, Constant.PAY_RED_LIST_URL, redMap, PayRedVO.class, ShopDetailActivity.this);
    }

    public void buyRecord() {
//        this.openActivity(MyBuyRecordActivity.class);
        mPayDialog.dismiss();
        mPayType = "";
    }

    public void coountTv(View view, int textViewId) {

        if (R.id.count1_tv == textViewId) {
            mCount1.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            mCount1.setBackgroundResource(R.drawable.frame_kongxin_white_red);
            mNumberButton.setCurrentNumber(BaseCommonUtils.parseInt(mCount1.getText().toString()));
        } else {
            mCount1.setTextColor(ContextCompat.getColor(this, R.color.C4));
            mCount1.setBackgroundResource(R.drawable.frame_kongxin_white_gray);
        }
        if (R.id.count2_tv == textViewId) {
            mCount2.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            mCount2.setBackgroundResource(R.drawable.frame_kongxin_white_red);
            mNumberButton.setCurrentNumber(BaseCommonUtils.parseInt(mCount2.getText().toString()));

        } else {
            mCount2.setTextColor(ContextCompat.getColor(this, R.color.C4));
            mCount2.setBackgroundResource(R.drawable.frame_kongxin_white_gray);
        }
        if (R.id.count3_tv == textViewId) {
            mCount3.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            mCount3.setBackgroundResource(R.drawable.frame_kongxin_white_red);
            mNumberButton.setCurrentNumber(BaseCommonUtils.parseInt(mCount3.getText().toString()));
        } else {
            mCount3.setTextColor(ContextCompat.getColor(this, R.color.C4));
            mCount3.setBackgroundResource(R.drawable.frame_kongxin_white_gray);
        }
        if (R.id.count4_tv == textViewId) {
            mCount4.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            mCount4.setBackgroundResource(R.drawable.frame_kongxin_white_red);
            mNumberButton.setCurrentNumber(BaseCommonUtils.parseInt(mCount4.getText().toString()));
        } else {
            mCount4.setTextColor(ContextCompat.getColor(this, R.color.C4));
            mCount4.setBackgroundResource(R.drawable.frame_kongxin_white_gray);
        }
        if (R.id.count5_tv == textViewId) {
            mCount5.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
            mCount5.setBackgroundResource(R.drawable.frame_kongxin_white_red);
            mNumberButton.setCurrentNumber(BaseCommonUtils.parseInt(mShopDetailVO.getRemain_count()));
        } else {
            mCount5.setTextColor(ContextCompat.getColor(this, R.color.C4));
            mCount5.setBackgroundResource(R.drawable.frame_kongxin_white_gray);
        }

    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(EBMessageVO event) {
        if ("weixin_pay".equals(event.getMessage())) {
            buyRecord();
        } else if ("wx_web".equals(event.getMessage())) {
            buyRecord();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        String title = ACache.get(mActivity).getAsString("share_title");
        String desc = ACache.get(mActivity).getAsString("share_desc");
        String img = ACache.get(mActivity).getAsString("share_img");
        String url = ACache.get(mActivity).getAsString("share_url");
        ShareUtil.share(this, img, title, desc, url);
    }

    public void otherLogin(String openid, String nickname, String headpicurl) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type", mOhterLoginType);
        map.put("openid", openid);
        map.put("nickname", nickname);
        map.put("platform", "1");
        map.put("headpicurl", headpicurl);
        BSHttpUtils.postCallBack(mActivity, Constant.LOGIN_OTHER_URL, map, UserInfoVO.class, this);
    }

    UMAuthListener authListener = new UMAuthListener() {
        /**
         * @desc 授权开始的回调
         * @param platform 平台名称
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @desc 授权成功的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param data 用户资料返回
         */
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            if (platform == SHARE_MEDIA.WEIXIN) {
                mSuccessType = "6";
            } else {
                mSuccessType = "7";
            }
            otherLogin(data.get("uid"), data.get("name"), data.get("iconurl"));
        }

        /**
         * @desc 授权失败的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            showFailToast("登录失败");
        }

        /**
         * @desc 授权取消的回调
         * @param platform 平台名称
         * @param action 行为序号，开发者用不上
         */
        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            showCustomToast("登录取消");
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    public void loginType() {
        mLoginTypeDialog = BottomDialogUtil.initBottomDialog(mActivity, R.layout.login_type);
        mLoginTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.login_tv);
        mRegistTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.regist_tv);
        mLoginWeixinTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.login_weixin_tv);
        mLoginQqTv = mLoginTypeDialog.getWindow().getDecorView().findViewById(R.id.login_qq_tv);
        mLoginTv.setOnClickListener(this);
        mRegistTv.setOnClickListener(this);
        mLoginWeixinTv.setOnClickListener(this);
        mLoginQqTv.setOnClickListener(this);
    }

    public void showDialog() {
        DialogUIUtils.init(ShopDetailActivity.this);
        View rootView = View.inflate(ShopDetailActivity.this, R.layout.my_buy_number_dialog, null);
        TextView buyCountTv = rootView.findViewById(R.id.buy_count_tv);
        BaseCommonUtils.setTextThree(this, buyCountTv, "你抢购了", mShopDetailVO.getUser_data().getBuy_count(), "次(抢购号码如下)", R.color.colorAccent, 1.3f);
        TagFlowLayout tagFlowLayout = rootView.findViewById(R.id.tag_flow_layout);

        List<String> allList = (List<String>) mShopDetailVO.getUser_data().getBuy_codes();
        List<String> tmp = new ArrayList<>();
        if (allList.size() > 50) {
            tmp.addAll(allList.subList(0, 50));
        } else {
            tmp.addAll(allList);
        }
        tagFlowLayout.setAdapter(new TagAdapter<String>(tmp) {
            @Override
            public View getView(FlowLayout parent, int position, String s) {
                TextView tv = new TextView(ShopDetailActivity.this);
                tv.setText(s);
                return tv;
            }
        });
        final BuildBean buildBean = DialogUIUtils.showCustomAlert(ShopDetailActivity.this, rootView);
        buildBean.show();
    }

    public void bindPhone() {
        mSuccessType = "9";
        mBindPhoneDialog = BottomDialogUtil.initBottomDialog(this, R.layout.login_bind_phone);
        mLoginMsgPhoneEt = mBindPhoneDialog.findViewById(R.id.login_msg_phone_et);
        mLoginMsgCodeEt = mBindPhoneDialog.findViewById(R.id.login_msg_code_et);
        mLoginMsgGetCodeTv = mBindPhoneDialog.findViewById(R.id.login_get_msg_code_tv);
        mLoginBindPhoneTv = mBindPhoneDialog.findViewById(R.id.login_bind_phone_tv);
        mLoginMsgGetCodeTv.setOnClickListener(this);
        mLoginBindPhoneTv.setOnClickListener(this);
    }


    public void showCustomDialog(String title, String content) {
        final RxDialogSure dialog = new RxDialogSure(this);
        dialog.setContent(content);
        dialog.getContentView().setTextColor(ContextCompat.getColor(this, R.color.C6));
        dialog.getLogoView().setVisibility(View.GONE);
        dialog.getTitleView().setTextSize(13);
        dialog.setTitle(title);
        dialog.getSureView().setTextSize(13);
        dialog.getSureView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}
