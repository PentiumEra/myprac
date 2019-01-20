package com.example.myprac.baselib.myretrofit.net.rx;

import com.example.myprac.baselib.myretrofit.net.RestClient;
import com.example.myprac.baselib.myretrofit.net.callback.IError;
import com.example.myprac.baselib.myretrofit.net.callback.IFailure;
import com.example.myprac.baselib.myretrofit.net.callback.IRequest;
import com.example.myprac.baselib.myretrofit.net.callback.ISuccess;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author linghailong
 * @date on 2019/1/14
 * @email 105354999@qq.com
 * @describe :
 */
public class RxRestClientBuilder {
    private String mUrl = null;
    private final WeakHashMap<String, Object> PARAMS = new WeakHashMap<>();
    private RequestBody mBody = null;
    private Object object = null;
    private File mFile = null;
    private String mDownloadDir = null;

    RxRestClientBuilder() {
    }

    public final RxRestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RxRestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RxRestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }


    public final RxRestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }
    /**
     * @param object progressbar所在的View
     * @return
     */
    public final RxRestClientBuilder loader(Object object) {
        this.object = object;
        return this;
    }

    public final RxRestClientBuilder dir(String dir) {
        this.mDownloadDir = dir;
        return this;
    }
    public final RxRestClient build() {
        return new RxRestClient(mUrl, PARAMS,  mBody,
                mFile,
                object,mDownloadDir);
    }

}
