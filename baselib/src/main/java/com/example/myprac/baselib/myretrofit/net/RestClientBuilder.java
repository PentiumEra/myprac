package com.example.myprac.baselib.myretrofit.net;

import android.content.Context;

import com.example.myprac.baselib.myretrofit.net.callback.IError;
import com.example.myprac.baselib.myretrofit.net.callback.IFailure;
import com.example.myprac.baselib.myretrofit.net.callback.IRequest;
import com.example.myprac.baselib.myretrofit.net.callback.ISuccess;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * @author linghailong
 * @date on 2019/1/14
 * @email 105354999@qq.com
 * @describe :
 */
public class RestClientBuilder {
    private String mUrl=null;
    private final WeakHashMap<String, Object> PARAMS =new WeakHashMap<>();
    private IRequest mIRequest=null;
    private ISuccess mISuccess=null;
    private IFailure mIFailure=null;
    private IError mIError=null;
    private RequestBody mBody=null;
    private Object object=null;
    private File mFile = null;
    private String mDownloadDir = null;
    private String mExtension = null;
    private String mName = null;

    RestClientBuilder() {
    }

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }

    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }

    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }

    public final RestClientBuilder irequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }
    public final RestClientBuilder name(String name) {
        this.mName = name;
        return this;
    }

    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mIRequest = iRequest;
        return this;
    }

    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mISuccess = iSuccess;
        return this;
    }

    public final RestClientBuilder failure(IFailure iFailure) {
        this.mIFailure = iFailure;
        return this;
    }

    public final RestClientBuilder error(IError iError) {
        this.mIError = iError;
        return this;
    }

    /**
     * @param object progressbar所在的View
     * @return
     */
    public final RestClientBuilder loader(Object object) {
        this.object=object;
        return this;
    }
    public final RestClientBuilder dir(String dir) {
        this.mDownloadDir = dir;
        return this;
    }

    public final RestClientBuilder extension(String extension) {
        this.mExtension = extension;
        return this;
    }
    public final RestClient build(){
       return new RestClient(mUrl,PARAMS,mIRequest,mISuccess,mIFailure,mIError,mBody,mFile,
               object,mName,mDownloadDir,mExtension);
    }

}