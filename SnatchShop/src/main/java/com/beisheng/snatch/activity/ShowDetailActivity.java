package com.beisheng.snatch.activity;

import android.Manifest;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.beisheng.snatch.R;
import com.beisheng.snatch.adapter.RecordAwardAdapter;
import com.beisheng.snatch.adapter.ShowDetailAdapter;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.DividerUtil;

import java.io.File;
import java.util.List;

import cn.bingoogolapple.photopicker.activity.BGAPhotoPreviewActivity;
import cn.bingoogolapple.photopicker.widget.BGANinePhotoLayout;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class ShowDetailActivity extends BaseActivity  implements BGANinePhotoLayout.Delegate, OnLoadMoreListener, ScrollableHelper.ScrollableContainer {
    private static final int PRC_PHOTO_PICKER = 1;
    private BGANinePhotoLayout mPhotoLyout;
    private LuRecyclerView mRecyclerView;
    private ShowDetailAdapter mAdapter;
    private ScrollableLayout mScrollableLayout;
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

    }

    @Override
    public void bindViewsListener() {
        mScrollableLayout.getHelper().setCurrentScrollableContainer(this);
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

    }
}
