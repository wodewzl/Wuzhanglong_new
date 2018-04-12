package com.beisheng.snatch.activity;

import android.Manifest;
import android.os.Environment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.ShowDetailAdapter;
import com.beisheng.snatch.constant.Constant;
import com.beisheng.snatch.model.ShowDetailListVO;
import com.beisheng.snatch.model.ShowDetailVO;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.rey.material.app.BottomSheetDialog;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.BSHttpUtils;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGANinePhotoLayout;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class ShowDetailActivity extends BaseActivity implements BGANinePhotoLayout.Delegate, OnLoadMoreListener, ScrollableHelper.ScrollableContainer {
    private static final int PRC_PHOTO_PICKER = 1;
    private BGANinePhotoLayout mPhotoLyout;
    private LuRecyclerView mRecyclerView;
    private ShowDetailAdapter mAdapter;
    private ScrollableLayout mScrollableLayout;
    private BottomSheetDialog mDialog;
    private TextView mTitleTv, mBuyTv, mDescTv, mTimeTv, mBuyShopTv, mBuyShopNoTv, mBuyShopCountTv, mBuyShopNumberTv, mBuyShopTimeTv,mCommentTv;
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private TextView mDiscussTitleTv;
    private LinearLayout mHeadLayout;

    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.show_detail_activity);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("晒单详情");
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
//        DividerDecoration divider = DividerUtil.linnerDivider(mActivity, R.dimen.dp_1, R.color.C3);
//        mRecyclerView.addItemDecoration(divider);
        mAdapter = new ShowDetailAdapter(mRecyclerView);
        LuRecyclerViewAdapter luAdapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(luAdapter);
        mRecyclerView.setLoadMoreEnabled(false);

        mScrollableLayout = getViewById(R.id.scrollable_layout);
        mTitleTv = getViewById(R.id.title_tv);
        mDescTv = getViewById(R.id.desc_tv);
        mBuyTv = getViewById(R.id.buy_tv);
        mTimeTv = getViewById(R.id.time_tv);
        mBuyShopTv = getViewById(R.id.buy_shop_tv);
        mBuyShopNoTv = getViewById(R.id.buy_shop_no_tv);
        mBuyShopCountTv = getViewById(R.id.buy_shop_count_tv);
        mBuyShopNumberTv = getViewById(R.id.buy_shop_number_tv);
        mBuyShopTimeTv = getViewById(R.id.buy_shop_time_tv);
        mPhotoLyout = getViewById(R.id.photo_layout);
        mDiscussTitleTv = getViewById(R.id.discuss_title_tv);
        mHeadLayout=getViewById(R.id.head_layouat);
        mCommentTv=getViewById(R.id.comment_tv);
    }

    @Override
    public void bindViewsListener() {
        mScrollableLayout.getHelper().setCurrentScrollableContainer(this);
        mRecyclerView.setOnLoadMoreListener(this);
        mPhotoLyout.setDelegate(this);
        mScrollableLayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int currentY, int maxY) {
                mHeadLayout.setTranslationY(currentY / 2);

            }
        });
    }

    @Override
    public void getData() {
        HashMap<String, Object> mapList = new HashMap<>();
        mapList.put("eid", this.getIntent().getStringExtra("id"));
        BSHttpUtils.post(mActivity, this, Constant.SHOW_DETAIL_URL, mapList, ShowDetailVO.class);

        HashMap<String, Object> map = new HashMap<>();
        map.put("eid", this.getIntent().getStringExtra("id"));
        BSHttpUtils.post(mActivity, this, Constant.DISCUSS_LIST_URL, map, ShowDetailListVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        if (vo instanceof ShowDetailVO) {
            ShowDetailVO showDetailVO = (ShowDetailVO) vo;
            ShowDetailVO.DataBean bean = showDetailVO.getData();
            mTitleTv.setText(bean.getTitle());
            mDescTv.setText(bean.getContent());
            mTimeTv.setText(bean.getAddtime());

            BaseCommonUtils.setTextTwoLast(this, mBuyShopTv, "抢购商品：", bean.getPrise_info().getGoods_name(), R.color.C4, 1.0f);
            BaseCommonUtils.setTextTwoLast(this, mBuyShopNoTv, "本期期号：", bean.getPrise_info().getIssue_no(), R.color.C4, 1.0f);
            BaseCommonUtils.setTextThree(this, mBuyShopCountTv, "抢购次数：", bean.getPrise_info().getBuy_count(), "次", R.color.colorAccent, 1.3f);
            BaseCommonUtils.setTextTwoLast(this, mBuyShopNumberTv, "抢购号码：", bean.getPrise_info().getPrise_code(), R.color.C4, 1.0f);
            BaseCommonUtils.setTextTwoLast(this, mBuyShopTimeTv, "抢购时间：", bean.getPrise_info().getGet_time(), R.color.C4, 1.0f);
            mCommentTv.setText("金任正少个字段");
            mPhotoLyout.setData((ArrayList<String>) bean.getImgs());
        } else {
            ShowDetailListVO showDetailListVO = (ShowDetailListVO) vo;
            BaseCommonUtils.setTextTwoLast(this, mDiscussTitleTv, "用户评论", "(" + showDetailListVO.getData().getList().size() + ")", R.color.colorAccent, 1.3f);
            if (BaseCommonUtils.parseInt(showDetailListVO.getData().getCount()) == 1) {
                mRecyclerView.setLoadMoreEnabled(false);
            }
            if (mCurrentPage == BaseCommonUtils.parseInt(showDetailListVO.getData().getCount())) {
                mRecyclerView.setNoMore(true);
            } else {
                mRecyclerView.setNoMore(false);
            }
            List<ShowDetailListVO.DataBean.ListBean> list = showDetailListVO.getData().getList();
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
    public void onClickNinePhotoItem(BGANinePhotoLayout ninePhotoLayout, View view, int position, String model, List<String> models) {
        choicePhotoWrapper();
    }

    @AfterPermissionGranted(PRC_PHOTO_PICKER)
    public void choicePhotoWrapper() {

        // 保存图片的目录，改成你自己要保存图片的目录。如果不传递该参数的话就不会显示右上角的保存按钮
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            File downloadDir = new File(Environment.getExternalStorageDirectory(), BaseConstant.SDCARD_CACHE);
            BGAPhotoPreviewActivity.IntentBuilder photoPreviewIntentBuilder = new BGAPhotoPreviewActivity.IntentBuilder(this)
                    .saveImgDir(downloadDir); // 保存图片的目录，如果传 null，则没有保存图片功能

            if (mPhotoLyout.getItemCount() == 1) {
                // 预览单张图片
                photoPreviewIntentBuilder.previewPhoto(mPhotoLyout.getCurrentClickItem());
            } else if (mPhotoLyout.getItemCount() > 1) {
                // 预览多张图片
                photoPreviewIntentBuilder.previewPhotos(mPhotoLyout.getData())
                        .currentPosition(mPhotoLyout.getCurrentClickItemPosition()); // 当前预览图片的索引
            }
            startActivity(photoPreviewIntentBuilder.build());
        } else {
            EasyPermissions.requestPermissions(this, "图片预览需要以下权限:\n\n1.访问设备上的照片", PRC_PHOTO_PICKER, perms);
        }
    }

    @Override
    public View getScrollableView() {
        return mRecyclerView;
    }

    @Override
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }
}
