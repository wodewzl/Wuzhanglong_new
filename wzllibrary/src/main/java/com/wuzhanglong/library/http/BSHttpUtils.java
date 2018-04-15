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
import com.wuzhanglong.library.interfaces.UpdateCallback;
import com.wuzhanglong.library.mode.BaseVO;
import com.wuzhanglong.library.utils.BaseCommonUtils;
import com.wuzhanglong.library.utils.MD5;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ${Wuzhanglong} on 2018/3/9.
 */

public class BSHttpUtils {

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
                            System.out.println("使用缓存数据");
                            return;
                        }
                        BaseVO baseVO = (BaseVO) gson.fromJson(s, className);
                        if ("200".equals(baseVO.getCode())) {
                            callback.baseHasData(baseVO);
                            if (!TextUtils.isEmpty(s)) {
                                ACache.get(activity).put(allUrl + params.toString(), s, 60 * 60 * 24);
                            }
                        } else if ("201".equals(baseVO.getCode())) {
                            activity.showCustomToast(baseVO.getDesc());
                            callback.baseHasData(baseVO);
                            if (!TextUtils.isEmpty(s)) {
                                ACache.get(activity).put(allUrl + params.toString(), s, 60 * 60 * 24);
                            }
                        } else if ("202".equals(baseVO.getCode())) {
                            callback.baseHasData(baseVO);
                            if (!TextUtils.isEmpty(s)) {
                                ACache.get(activity).put(allUrl + params.toString(), s, 60 * 60 * 24);
                            }
                        } else if ("400".equals(baseVO.getCode())) {
                            callback.baseNoData(baseVO);
                            activity.showFailToast(baseVO.getDesc());
                        } else if ("600".equals(baseVO.getCode())) {
                            callback.baseNoNet();
                        } else if ("300".equals(baseVO.getCode())) {
                            callback.baseNoData(baseVO);
                            activity.showFailToast(baseVO.getDesc());
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


    public static <T> void post(final BaseActivity activity, final UpdateCallback callback, final String url, final Map<String, Object> params, final Class<T> className) {
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

        params.put("timestamp", System.currentTimeMillis() / 1000);
        Map<String, Object> resultMap = sortMapByKey(params);
        StringBuffer signSb = new StringBuffer();
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            signSb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        signSb.append(BaseConstant.APP_KEY);
        String sign = MD5.Md5(signSb.toString());
        params.put("sign", sign);
        new Novate.Builder(activity)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build().rxPost(url, params, new RxStringCallback() {

            @Override
            public void onError(Object o, Throwable throwable) {
                activity.dismissProgressDialog();
            }

            @Override
            public void onCancel(Object o, Throwable throwable) {
                activity.dismissProgressDialog();

            }

            @Override
            public void onNext(Object o, String s) {
                activity.dismissProgressDialog();
                if (s.trim().equals(cacheStr) || className == null) {
                    System.out.println("使用缓存数据");
                    return;
                }
                BaseVO baseVO = (BaseVO) gson.fromJson(s, className);
                if ("200".equals(baseVO.getCode())) {
                    callback.baseHasData(baseVO);
                    if (!TextUtils.isEmpty(s)) {
                        ACache.get(activity).put(allUrl + params.toString(), s, 60 * 60 * 24);
                    }
                } else if ("201".equals(baseVO.getCode())) {
                    activity.showCustomToast(baseVO.getDesc());
                    callback.baseHasData(baseVO);
                    if (!TextUtils.isEmpty(s)) {
                        ACache.get(activity).put(allUrl + params.toString(), s, 60 * 60 * 24);
                    }
                } else if ("202".equals(baseVO.getCode())) {
                    callback.baseHasData(baseVO);
                    if (!TextUtils.isEmpty(s)) {
                        ACache.get(activity).put(allUrl + params.toString(), s, 60 * 60 * 24);
                    }
                } else if ("400".equals(baseVO.getCode())) {
                    callback.baseNoData(baseVO);
                    activity.showFailToast(baseVO.getDesc());
                } else if ("600".equals(baseVO.getCode())) {
                    callback.baseNoNet();
                } else if ("300".equals(baseVO.getCode())) {
                    callback.baseNoData(baseVO);
                    activity.showFailToast(baseVO.getDesc());
                }
            }
        });
    }

    public static <T> void postCallBack(final BaseActivity activity, final String url, final Map<String, Object> params, final Class<T> className, final PostCallback postCallback) {
        final Gson gson = new Gson();
        final String allUrl = BaseConstant.DOMAIN_NAME + url;

        if (params == null || params.size() == 0) {
            Log.i("get_url", BaseConstant.DOMAIN_NAME + url);
        } else {
            Log.i("get_url", BaseConstant.DOMAIN_NAME + url + BaseCommonUtils.getUrl((HashMap<String, Object>) params));
        }

        params.put("timestamp", System.currentTimeMillis() / 1000);
        Map<String, Object> resultMap = sortMapByKey(params);
        StringBuffer signSb = new StringBuffer();
        for (Map.Entry<String, Object> entry : resultMap.entrySet()) {
            signSb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        signSb.append(BaseConstant.APP_KEY);
        String sign = MD5.Md5(signSb.toString());
        params.put("sign", sign);
        new Novate.Builder(activity)
                .baseUrl(BaseConstant.DOMAIN_NAME)
                .addCache(false)
                .build().rxPost(url, params, new RxStringCallback() {

            @Override
            public void onError(Object o, Throwable throwable) {
                activity.dismissProgressDialog();
            }

            @Override
            public void onCancel(Object o, Throwable throwable) {
                activity.dismissProgressDialog();

            }

            @Override
            public void onNext(Object o, String s) {
                activity.dismissProgressDialog();
                BaseVO baseVO = (BaseVO) gson.fromJson(s, className);
                if ("200".equals(baseVO.getCode())) {
                    postCallback.success(baseVO);
                } else if ("201".equals(baseVO.getCode())) {
                    activity.showCustomToast(baseVO.getDesc());
                    postCallback.success(baseVO);
                } else if ("202".equals(baseVO.getCode())) {
                    postCallback.success(baseVO);
                } else if ("400".equals(baseVO.getCode())) {
                    activity.showFailToast(baseVO.getDesc());
                } else if ("600".equals(baseVO.getCode())) {
                } else if ("300".equals(baseVO.getCode())) {
                    activity.showFailToast(baseVO.getDesc());
                }
            }
        });
    }

    public static Map<String, Object> sortMapByKey(Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, Object> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    static class MapKeyComparator implements Comparator<String> {

        @Override
        public int compare(String str1, String str2) {

            return str1.compareTo(str2);
        }
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
}
