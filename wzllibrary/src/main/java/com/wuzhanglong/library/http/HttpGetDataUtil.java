package com.wuzhanglong.library.http;

import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.tamic.novate.BaseSubscriber;
import com.tamic.novate.Novate;
import com.tamic.novate.Throwable;
import com.tamic.novate.callback.RxStringCallback;
import com.wuzhanglong.library.activity.BaseActivity;
import com.wuzhanglong.library.cache.ACache;
import com.wuzhanglong.library.constant.BaseConstant;
import com.wuzhanglong.library.interfaces.PostCallback;
import com.wuzhanglong.library.interfaces.PostStringCallback;
import com.wuzhanglong.library.interfaces.UpdateCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ${Wuzhanglong} on 2017/9/12.
 */

public class HttpGetDataUtil {
    public static <T> void get(final BaseActivity activity, final UpdateCallback callback, final String url, final Map<String, Object> params, final Class<T> className) {
        final Gson gson = new Gson();
        final String allUrl = BaseConstant.DOMAIN_NAME + url;
        final String cacheStr = ACache.get(activity).getAsString(allUrl + params.toString());
        if (className != null) {
            final BaseVO vo = (BaseVO) gson.fromJson(cacheStr, className);
            if (vo != null) {
                Observable.create(new Observable.OnSubscribe<BaseVO>() {
                    @Override
                    public void call(Subscriber<? super BaseVO> subscriber) {
                        subscriber.onNext(vo);
                    }
                }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<BaseVO>() {
                    @Override
                    public void call(BaseVO baseVO) {
                        callback.baseHasData(vo);
                    }
                });

                if (!HttpUtils.isNetworkAvailable(activity)) {
                    return;
                }
            }
        }

        if (params == null || params.size() == 0) {
            Log.i("get_url", BaseConstant.DOMAIN_NAME + url);

        } else {
            Log.i("get_url", BaseConstant.DOMAIN_NAME + url + BaseCommonUtils.getUrl((HashMap<String, Object>) params));

        }

        new Novate.Builder(activity)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build()
                .rxGet(url, params, new RxStringCallback() {
                    @Override
                    public void onNext(Object o, String s) {
                        activity.dismissProgressDialog();
                        if (s.trim().equals(cacheStr) || className == null) {
                            System.out.println("===============");
                            return;
                        }
                        BaseVO baseVO = (BaseVO) gson.fromJson(s, className);
                        if ("200".equals(baseVO.getCode())) {
                            callback.baseHasData(baseVO);
                            if (!TextUtils.isEmpty(s)) {
                                ACache.get(activity).put(allUrl + params.toString(), s, 60 * 60 * 24);
                            }
                        } else if ("400".equals(baseVO.getCode())) {
                            callback.baseNoData(baseVO);
                        } else if ("600".equals(baseVO.getCode())) {
                            callback.baseNoNet();
                        } else if ("300".equals(baseVO.getCode())) {
                            callback.baseHasData(baseVO);
                        }
                    }

                    @Override
                    public void onError(Object o, Throwable throwable) {
                        System.out.println("===========");
                        activity.dismissProgressDialog();

                    }

                    @Override
                    public void onCancel(Object o, Throwable throwable) {
                        System.out.println("===========");
                        activity.dismissProgressDialog();

                    }
                });
    }

    public static <T> void post(final BaseActivity activity, final String url, final Map<String, Object> params, final Class<T> className, final PostCallback postCallback) {

        final Gson gson = new Gson();
//        final String allUrl = BaseConstant.DOMAIN_NAME + url;
        new Novate.Builder(activity)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build().rxPost(url, params, new RxStringCallback() {


            @Override
            public void onError(Object o, Throwable throwable) {
                System.out.println("=============");
                activity.dismissProgressDialog();
            }

            @Override
            public void onCancel(Object o, Throwable throwable) {
                System.out.println("=============");
                activity.dismissProgressDialog();

            }

            @Override
            public void onNext(Object o, String s) {
                activity.dismissProgressDialog();
                BaseVO vo = (BaseVO) gson.fromJson(s, className);
                if ("200".equals(vo.getCode())) {
                    postCallback.success(vo);
                } else {
                    activity.showCustomToast(vo.getMessage());
                }
            }
        });
    }

    public static <T> void post(final BaseActivity activity, final String url, final Map<String, Object> params, final PostCallback postCallback) {

        final Gson gson = new Gson();
//        final String allUrl = BaseConstant.DOMAIN_NAME + url;
        new Novate.Builder(activity)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build().rxPost(url, params, new RxStringCallback() {


            @Override
            public void onError(Object o, Throwable throwable) {
                activity.dismissProgressDialog();
                System.out.println("=============");
            }

            @Override
            public void onCancel(Object o, Throwable throwable) {
                activity.dismissProgressDialog();
                System.out.println("=============");
            }

            @Override
            public void onNext(Object o, String s) {
                activity.dismissProgressDialog();
                final BaseVO vo = (BaseVO) gson.fromJson(s, BaseVO.class);
                if ("200".equals(vo.getCode())) {
                    postCallback.success(vo);
                } else {
                    activity.showCustomToast(vo.getDesc());
                }

            }
        });
    }

    public static <T> void postResult(final BaseActivity activity, final String url, final Map<String, Object> params, final PostStringCallback postCallback) {

        final Gson gson = new Gson();
//        final String allUrl = BaseConstant.DOMAIN_NAME + url;
        new Novate.Builder(activity)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build().rxPost(url, params, new RxStringCallback() {


            @Override
            public void onError(Object o, Throwable throwable) {
                activity.dismissProgressDialog();
                System.out.println("=============");
            }

            @Override
            public void onCancel(Object o, Throwable throwable) {
                activity.dismissProgressDialog();
                System.out.println("=============");
            }

            @Override
            public void onNext(Object o, String s) {
                activity.dismissProgressDialog();
                postCallback.success(s);
            }
        });
    }

    //提交文件
    public static <T> void post(final BaseActivity activity, final String url, RequestBody params, final Class<T> className, final PostCallback postCallback) {

        final Gson gson = new Gson();
//        final String allUrl = BaseConstant.DOMAIN_NAME + url;
        new Novate.Builder(activity)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build()
                .upload(url, params, new BaseSubscriber<ResponseBody>() {
                    @Override
                    public void onNext(ResponseBody responseBody) {
                        activity.dismissProgressDialog();
                        try {
                            String s = new String(responseBody.bytes());
                            final BaseVO vo = (BaseVO) gson.fromJson(s, className);
                            if ("200".equals(vo.getCode())) {
                                postCallback.success(vo);
                                activity.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        activity.showCustomToast(vo.getDesc());
                                    }
                                });
                            } else {
                                activity.showCustomToast(vo.getDesc());
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        activity.dismissProgressDialog();
                    }
                });
    }

    //多个文件提交
    public static <T> void post(final BaseActivity activity, final String url, RequestBody params, Callback callback) {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(params)
                .build();
        okHttpClient.newCall(request).enqueue(callback);
    }


//    public static <T> void postJson(final BaseActivity activity, final String url, Object obj , final Class<T> className, final PostCallback postCallback) {
//        if(obj ==null)
//            obj=new Object();
//        final Gson gson = new Gson();
////        final String allUrl = BaseConstant.DOMAIN_NAME + url;
//        new Novate.Builder(activity)
//                .baseUrl(BaseConstant.DOMAIN_NAME)
//                .addCache(false)
//                .build().RxBody(url, obj, new RxStringCallback() {
//
//
//            @Override
//            public void onError(Object o, Throwable throwable) {
//                System.out.println("=============");
//            }
//
//            @Override
//            public void onCancel(Object o, Throwable throwable) {
//                System.out.println("=============");
//            }
//
//            @Override
//            public void onNext(Object o, String s) {
//                BaseVO vo = (BaseVO) gson.fromJson(s, BaseVO.class);
//                if ("200".equals(vo.getCode())) {
//                    postCallback.success(vo);
//                } else {
//                    activity.showCustomToast(vo.getDesc());
//                }
//            }
//        });
//    }
}
