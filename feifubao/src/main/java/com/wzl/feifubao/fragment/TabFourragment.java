package com.wzl.feifubao.fragment;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.GeolocationPermissions;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.fragment.BaseFragment;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.mode.EBMessageVO;
import com.wzl.feifubao.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import static com.wuzhanglong.library.utils.WebviewUtil.SetWebview;

public class TabFourragment extends BaseFragment implements View.OnClickListener{
    private WebView mWebView;
    private ProgressBar progressbar;
    @Override
    public void setContentView() {
        contentInflateView(R.layout.tab_four_fragment);
    }

    @Override
    public void initView(View view) {
        mWebView = (WebView) getViewById(R.id.webview);
        SetWebview(mWebView);
////    mWebView.setWebViewClient(new WebViewPictureUtil(this, mWebView, "img", "this.src"));

        progressbar = new ProgressBar(mActivity, null, android.R.attr.progressBarStyleHorizontal);
        progressbar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, 5));
        Drawable drawable = this.getResources().getDrawable(R.drawable.webview_progress);
        progressbar.setProgressDrawable(drawable);
        mWebView.addView(progressbar);



    }


    @Override
    public void bindViewsListener() {
        EventBus.getDefault().register(this);
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    progressbar.setVisibility(View.INVISIBLE);
                } else {
                    if (View.INVISIBLE == progressbar.getVisibility()) {
                        progressbar.setVisibility(View.VISIBLE);
                    }
                    progressbar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }

            @Override
            public void onGeolocationPermissionsShowPrompt(String origin, GeolocationPermissions.Callback callback) {
                callback.invoke(origin, true, false);
                super.onGeolocationPermissionsShowPrompt(origin, callback);
            }


        });

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if ((url.startsWith("http:") || url.startsWith("https:")) && !url.endsWith(".apk")) {
                    return super.shouldOverrideUrlLoading(view, url);
                } else if (url.startsWith("itms-services:")) {
                    return true;
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mActivity.dismissProgressDialog();
            }
        });
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.cart_tv:

                break;
            default:
                break;
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(EBMessageVO event) {
        if ("load".equals(event.getMessage())) {
            String url= ACache.get(mActivity).getAsString("kefu");
            mWebView.loadUrl(url);
        }
    }
}
