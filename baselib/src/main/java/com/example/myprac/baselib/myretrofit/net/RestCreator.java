package com.example.myprac.baselib.myretrofit.net;

import android.os.Handler;
import android.os.Looper;

import com.example.myprac.baselib.myretrofit.net.rx.RxRestService;

import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author linghailong
 * @date on 2019/1/14
 * @email 105354999@qq.com
 * @describe :
 */
public class RestCreator {
//    public static final WeakHashMap<String,Object>PARAMS=new WeakHashMap<>();

    public static RestService getRestService() {
        return RestServiceHolder.REST_SERVICE;
    }

    private static final class HandlerHolder {
        private static final Handler HANDLER = new Handler(Looper.getMainLooper());
    }

    /*单例模式的静态颞部类*/
    private static final class RetrofitHolder {
        /*baseAPI*/
        private static final String BASE_URL = "http://fanyi.youdao.com/";
        /*建造者模式*/
        /*添加转换器*/
        private static final Retrofit RETROFIT_CLIENT = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(OkHttpHolder.OK_HTTP_CLIENT)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private static final class OkHttpHolder {
        private static final int TIME_OUT = 60;
        private static final OkHttpClient OK_HTTP_CLIENT = new OkHttpClient.Builder().callTimeout
                (60, TimeUnit.SECONDS)
                .build();
    }

    private static final class RestServiceHolder {
        private static final RestService REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT.create
                (RestService.class);
    }

    public static RxRestService getRxRestService() {
        return RxRestServiceHolder.Rx_REST_SERVICE;
    }

    private static final class RxRestServiceHolder {
        private static final RxRestService Rx_REST_SERVICE = RetrofitHolder.RETROFIT_CLIENT.create
                (RxRestService.class);
    }

}
