package com.wzl.feifubao.activity;

import android.Manifest;
import android.os.Environment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.github.jdsjlzx.interfaces.OnLoadMoreListener;
import com.github.jdsjlzx.recyclerview.LuRecyclerView;
import com.github.jdsjlzx.recyclerview.LuRecyclerViewAdapter;
import com.github.jdsjlzx.recyclerview.ProgressStyle;
import com.wuzhanglong.library.ItemDecoration.DividerDecoration;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.http.HttpGetDataUtil;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.DividerUtil;
import com.wuzhanglong.library.view.AutoSwipeRefreshLayout;
import com.wzl.feifubao.R;
import com.wzl.feifubao.adapter.JobOffersAdapter;
import com.wzl.feifubao.adapter.YellowPagesAdapter;
import com.wzl.feifubao.constant.Constant;
import com.wzl.feifubao.mode.JobOffersVO;
import com.wzl.feifubao.mode.YellowPagesVO;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bingoogolapple.baseadapter.BGADivider;
import cn.bingoogolapple.baseadapter.BGAOnRVItemClickListener;
import cn.bingoogolapple.photopicker.activity.BGAPhotoPreviewActivity;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class YellowPagesActivity extends BaseActivity implements BGAOnRVItemClickListener, OnLoadMoreListener,SwipeRefreshLayout.OnRefreshListener,android.widget.TextView.OnEditorActionListener, TextWatcher {
    private AutoSwipeRefreshLayout mAutoSwipeRefreshLayout;
    private LuRecyclerView mRecyclerView;
    private YellowPagesAdapter mAdapter;
    private EditText mSearchEt;
    private String mKeyword = "";
    private int mCurrentPage = 1;
    private boolean isLoadMore = true;
    private static final int PRC_PHOTO_PICKER = 1;
    @Override
    public void baseSetContentView() {
        contentInflateView(R.layout.activity_yellow_pages);
    }

    @Override
    public void initView() {
        mBaseTitleTv.setText("企业黄页");
        mSearchEt = getViewById(R.id.search_et);
        mSearchEt.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        mSearchEt.setInputType(EditorInfo.TYPE_CLASS_TEXT);
        mAutoSwipeRefreshLayout = getViewById(R.id.swipe_refresh_layout);
        mActivity.setSwipeRefreshLayoutColors(mAutoSwipeRefreshLayout);
        mRecyclerView = getViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity));

        mAdapter = new YellowPagesAdapter(mRecyclerView);
        LuRecyclerViewAdapter adapter = new LuRecyclerViewAdapter(mAdapter);
        mRecyclerView.setAdapter(adapter);
        DividerDecoration divider = DividerUtil.linnerDivider(this, R.dimen.dp_10, R.color.C3);
        mRecyclerView.addItemDecoration(divider);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadMoreEnabled(true);

//        mAdapter.updateData(new ArrayList<YellowPagesVO>());
    }

    @Override
    public void bindViewsListener() {
        mRecyclerView.setOnLoadMoreListener(this);
        mAutoSwipeRefreshLayout.setOnRefreshListener(this);
        mSearchEt.setOnEditorActionListener(this);
        mSearchEt.addTextChangedListener(this);
        mAdapter.setOnRVItemClickListener(this);
    }

    @Override
    public void getData() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("page", mCurrentPage+"");
        map.put("pagesize", "10");
        map.put("keyword", mKeyword);
        HttpGetDataUtil.get(mActivity, this, Constant.YELLOW_PAGE_LIST_URL, map, YellowPagesVO.class);
    }

    @Override
    public void hasData(BaseVO vo) {
        YellowPagesVO yellowPagesVO = (YellowPagesVO) vo;
        if (BaseCommonUtils.parseInt(yellowPagesVO.getData().getPage_count()) == 1) {
            mRecyclerView.setLoadMoreEnabled(false);
        }
        if (mCurrentPage == BaseCommonUtils.parseInt(yellowPagesVO.getData().getPage_count())) {
            mRecyclerView.setNoMore(true);
        } else {
            mRecyclerView.setNoMore(false);
        }

        List<YellowPagesVO.DataBeanX.DataBean> list = yellowPagesVO.getData().getData();
        if (isLoadMore) {
            mAdapter.updateDataLast(list);
            isLoadMore = false;
            mCurrentPage++;
        } else {
            mCurrentPage++;
            mAdapter.updateData(list);
        }
        mAutoSwipeRefreshLayout.setRefreshing(false);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void noData(BaseVO vo) {

    }

    @Override
    public void noNet() {

    }

    @Override
    public void onRefresh() {
        mCurrentPage = 1;
        mKeyword = "";
        getData();
    }

    @Override
    public void onRVItemClick(ViewGroup parent, View itemView, int position) {
        if(mAdapter.getData().size()==0)
            return;
//        YellowPagesVO.DataBeanX.DataBean vo=mAdapter.getItem(position);
//        Bundle bundle=new Bundle();
//        bundle.putString("id",vo.getId());
//        open(JobOffersDetailActivity.class,bundle,0);
    }


    @Override
    public void onLoadMore() {
        isLoadMore = true;
        getData();
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        mKeyword = textView.getText().toString();
        mCurrentPage=1;
        mAutoSwipeRefreshLayout.autoRefresh();
        return false;

    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence s, int i, int i1, int i2) {
        if ("".equals(s.toString())) {
            mKeyword = "";
            mCurrentPage=1;
            mAutoSwipeRefreshLayout.autoRefresh();
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }

    @AfterPermissionGranted(PRC_PHOTO_PICKER)
    public void choicePhotoWrapper(String path) {
//        ArrayList<String> list=new ArrayList<>();
//        list.add(path);
//        mPhotoLyout.setData(list);
//        mPhotoLyout.setDelegate(this);
//        path="http://gwhb.work.csongdai.com/Uploads/bs0640/Log/image/20180120/5a62e3a52890a.jpeg";
        // 保存图片的目录，改成你自己要保存图片的目录。如果不传递该参数的话就不会显示右上角的保存按钮
        String[] perms = {Manifest.permission.WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            File downloadDir = new File(Environment.getExternalStorageDirectory(), BaseConstant.SDCARD_CACHE);
            BGAPhotoPreviewActivity.IntentBuilder photoPreviewIntentBuilder = new BGAPhotoPreviewActivity.IntentBuilder(this)
                    .saveImgDir(downloadDir); // 保存图片的目录，如果传 null，则没有保存图片功能

            photoPreviewIntentBuilder.previewPhoto(path);
            startActivity(photoPreviewIntentBuilder.build());
        } else {
            EasyPermissions.requestPermissions(this, "图片预览需要以下权限:\n\n1.访问设备上的照片", PRC_PHOTO_PICKER, perms);
        }
    }
}
