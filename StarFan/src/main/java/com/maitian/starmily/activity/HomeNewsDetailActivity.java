package com.maitian.starmily.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.TextView;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.maitian.starmily.R;
import com.maitian.starmily.adapter.NewsDiscussAdapter;
import com.maitian.starmily.constant.Constant;
import com.maitian.starmily.model.DiscussReplyBean;
import com.maitian.starmily.model.NewsDetailBeans;
import com.maitian.starmily.model.NewsDiscussBean;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.http.StartHttpUtils;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DateUtils;
import com.wuzhanglong.library.utils.RecyclerViewUtil;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGAOnItemChildClickListener;

public class HomeNewsDetailActivity extends BaseActivity implements ScrollableHelper.ScrollableContainer, OnLoadMoreListener,
        TagFlowLayout.OnTagClickListener, BGAOnItemChildClickListener, PostCallback, View.OnClickListener {
    private TextView mTitleTv, mTimeTv, mOneDiscussTv, mOneLikeTv, mOneFavourTv, mOrderTv;
    private WebView mWebView;
    private LuRecyclerView mRecyclerView;
    private NewsDiscussAdapter mAdapter;
    private ScrollableLayout mScrollableLayout;
    private boolean isLoadMore = true;
    private int mCurrentPage = 1;
    private TagFlowLayout mFlowLayout;
    private NewsDetailBeans mBean;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.home_news_detail_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("资讯详情");
        mBaseOkTv.setCompoundDrawablesWithIntrinsicBounds(R.mipmap.share_img, 0, 0, 0);
        mTitleTv = getViewById(R.id.title_tv);
        mTimeTv = getViewById(R.id.time_tv);
        mWebView = getViewById(R.id.webview);
        mWebView.setHorizontalScrollBarEnabled(false);//水平不显示
        mWebView.setVerticalScrollBarEnabled(false); //垂直不显示
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowFileAccess(true);
        webSettings.setBuiltInZoomControls(true);

        mRecyclerView = getViewById(R.id.recycler_view);
        mAdapter = new NewsDiscussAdapter(mRecyclerView);
        RecyclerViewUtil.initRecyclerViewLinearLayout(this, mRecyclerView, mAdapter, R.dimen.dp_1, R.color.C3, false);
        mScrollableLayout = getViewById(R.id.scrollable_layout);
        mScrollableLayout.getHelper().setCurrentScrollableContainer(this);
        mFlowLayout = getViewById(R.id.flow_layout);
        mOneDiscussTv = getViewById(R.id.one_discuss_tv);
        mOneLikeTv = getViewById(R.id.one_like_tv);
        mOneFavourTv = getViewById(R.id.one_favor_tv);
        mOrderTv = getViewById(R.id.order_tv);
    }

    @Override
    public void bindViewsListener() {
        mFlowLayout.setOnTagClickListener(this);
        mOneDiscussTv.setOnClickListener(this);
        mOneLikeTv.setOnClickListener(this);
        mBaseOkTv.setOnClickListener(this);
        mOneFavourTv.setOnClickListener(this);
        mAdapter.setOnItemChildClickListener(this);
        mOrderTv.setOnClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("userId", this.getIntent().getStringExtra("userId"));
        map.put("newsId", this.getIntent().getStringExtra("newsId"));
        StartHttpUtils.get(mActivity, this, Constant.NEWS_DETAILS, map, NewsDetailBeans.class);

        order("0");
    }

    public void order(String order) {
        //0喜欢排序1时间正序2时间倒序
        HashMap<String, Object> discussMap = new HashMap<>();
        discussMap.put("pageNum", mCurrentPage + "");
        discussMap.put("pageSize", "10");
        discussMap.put("newsId", this.getIntent().getStringExtra("newsId"));
        discussMap.put("userId", this.getIntent().getStringExtra("userId"));
        StartHttpUtils.get(mActivity, this, Constant.FIND_COMMENT_BY_PAGE, discussMap, NewsDiscussBean.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof NewsDetailBeans) {
            mBean = (NewsDetailBeans) vo;
            mTitleTv.setText(mBean.getObj().getNews().getTitle());
            mTimeTv.setText(DateUtils.parseDateDay(mBean.getObj().getNews().getCreateTime()));
            mWebView.loadData(mBean.getObj().getNews().getContent(), "text/html", "UTF-8");
            List<NewsDetailBeans.ObjBean.IdolsBean> myIdolsList = mBean.getObj().getIdols();

            mFlowLayout.setAdapter(new TagAdapter<NewsDetailBeans.ObjBean.IdolsBean>(myIdolsList) {
                @Override
                public View getView(FlowLayout parent, int position, NewsDetailBeans.ObjBean.IdolsBean idolsBean) {
                    final TextView tv = new TextView(mActivity);
                    tv.setPadding(15, 10, 15, 10);
                    tv.setTextSize(10);
                    tv.setBackground(BaseCommonUtils.setBackgroundShap(mActivity, 15, R.color.colorAccent, R.color.color_FFD8D8));
                    tv.setTextColor(ContextCompat.getColor(mActivity, R.color.colorAccent));
                    tv.setText(idolsBean.getIdolName());
                    return tv;
                }
            });

        } else if (vo instanceof NewsDiscussBean) {
            NewsDiscussBean discussBean = (NewsDiscussBean) vo;
            if (discussBean.getObj().isHasNextPage()) {
                mRecyclerView.setNoMore(false);
            } else {
                mRecyclerView.setNoMore(true);
            }
            List<NewsDiscussBean.ObjBean.ListBeanX> list = discussBean.getObj().getList();
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
    public void onLoadMore() {
        isLoadMore = true;
        mCurrentPage++;
        getData();
    }

    @Override
    public boolean onTagClick(View view, int position, FlowLayout parent) {
        return false;
    }

    @Override
    public void onItemChildClick(ViewGroup parent, View childView, int position) {
        NewsDiscussBean.ObjBean.ListBeanX beanX = (NewsDiscussBean.ObjBean.ListBeanX) mAdapter.getItem(position);
        switch (childView.getId()) {
            case R.id.reply_count_tv:
//                Bundle bundleDiscuss = new Bundle();
//
//                map.put("commentId", this.getIntent().getStringExtra("newsId"));
//                map.put("fromUserId", this.getIntent().getStringExtra("userId"));
//                map.put("toUserId", this.getIntent().getStringExtra("userId"));
//
//                bundleDiscuss.putString("type", "3");
//                bundleDiscuss.putString("commentId", beanX.getCommentId() + "");
//                bundleDiscuss.putString("fromUserId", beanX.getCO() + "");
//                bundleDiscuss.putString("toUserId", beanX.getNewsId() + "");
//                open(PublishDiscussActivity.class, bundleDiscuss, 0);
                break;
            case R.id.reply_favout_tv:
                //点赞
                replayLikePost(beanX.getCommentId() + "");
                break;

            case R.id.reply_people_tv:
                //回复评论列表
                Bundle bundle = new Bundle();
                bundle.putString("head_url", beanX.getIcon_url());
                bundle.putString("name", beanX.getNickname());
                bundle.putString("content", beanX.getReplyMsg());
                bundle.putLong("time", beanX.getCreateTime());
                bundle.putString("like_count", beanX.getLikeCount() + "");
                bundle.putString("discuss_count", beanX.getCommentReply() != null ? beanX.getCommentReply().getList().size() + "" : "0");
                open(HomeNewsReplyActivity.class, bundle, 0);
                break;
            default:
                break;

        }
    }

    public void likePost(String newsId, String userId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("newsId", newsId);
        map.put("userId", userId);
//        map.put("userId", userId);
        StartHttpUtils.postCallBack(mActivity, Constant.LIKE_NEWS, map, BaseVO.class, this);
    }

    public void favorPost(String newsId, String userId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("newsId", newsId);
        map.put("userId", userId);
        StartHttpUtils.postCallBack(mActivity, Constant.FAVORIATE_NEWS, map, BaseVO.class, this);
    }

    @Override
    public void success(BaseVO vo) {
        mActivity.showCustomToast(vo.getMsg());
    }


    public void replayLikePost(String id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("commentId", id);
        map.put("userId", "4338");
        map.put("type", "4338");
        StartHttpUtils.postCallBack(mActivity, Constant.LIKE_TOPIC, map, BaseVO.class, this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.one_discuss_tv:
                Bundle bundleDiscuss = new Bundle();
                bundleDiscuss.putString("type", "3");
                bundleDiscuss.putString("newsId", mBean.getObj().getNews().getUserId() + "");
                bundleDiscuss.putString("userId", mBean.getObj().getNews().getNewsId() + "");
                open(PublishDiscussActivity.class, bundleDiscuss, 0);
                break;
            case R.id.one_like_tv:
                likePost(mBean.getObj().getNews().getNewsId() + "", mBean.getObj().getNews().getUserId() + "");
                break;

            case R.id.one_favor_tv:
                favorPost(mBean.getObj().getNews().getNewsId() + "", mBean.getObj().getNews().getUserId() + "");
                break;
            case R.id.base_ok_tv:
                break;
            case R.id.order_tv:
                if ("按热度".equals(mOrderTv.getText().toString())) {
                    mOrderTv.setText("按时间");
                    order("0");
                } else if ("按时间".equals(mOrderTv.getText().toString())) {
                    mOrderTv.setText("按热度");
                    order("1");
                }

                break;
            default:
                break;

        }
    }
}
