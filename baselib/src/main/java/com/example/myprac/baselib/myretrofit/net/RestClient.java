package com.example.myprac.baselib.myretrofit.net;

import com.example.myprac.baselib.myretrofit.net.callback.IError;
import com.example.myprac.baselib.myretrofit.net.callback.IFailure;
import com.example.myprac.baselib.myretrofit.net.callback.IRequest;
import com.example.myprac.baselib.myretrofit.net.callback.ISuccess;
import com.example.myprac.baselib.myretrofit.net.callback.RequestCallbacks;

import java.io.File;
import java.util.WeakHashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * @author linghailong
 * @date on 2019/1/14
 * @email 105354999@qq.com
 * @describe :
 */
public class RestClient {
    private final String URL;
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IFailure FAILURE;
    private final IError ERROR;
    private final RequestBody BODY;
    private final WeakHashMap<String, Object> PARAMS;
    private final File FILE;
    private final Object OBJECT;
    private final String NAME;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;

    public RestClient(String url, WeakHashMap<String, Object> params,
                      IRequest request,
                      ISuccess success,
                      IFailure failure,
                      IError error,
                      RequestBody body,
                      File file,
                      Object object,
                      String name,
                      String download_dir,
                      String extension) {
        this.URL = url;
        this.PARAMS = params;
        this.REQUEST = request;
        this.SUCCESS = success;
        this.FAILURE = failure;
        this.ERROR = error;
        this.BODY = body;
        this.FILE = file;
        this.OBJECT = object;
        this.NAME = name;
        this.DOWNLOAD_DIR = download_dir;
        this.EXTENSION = extension;
    }

    public static RestClientBuilder builder() {
        return new RestClientBuilder();
    }

    private void request(HttpMethod method) {
        final RestService restService = RestCreator.getRestService();
        Call<String> call = null;
        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }
        switch (method) {
            case GET:
                call = restService.get(URL, PARAMS);
                break;
            case PUT:
                call = restService.post(URL, PARAMS);
                break;
            case POST:
                call = restService.put(URL, PARAMS);
                break;
            case DELETE:
                call = restService.delete(URL, PARAMS);
                break;
            default:
                break;

        }
        if (call != null) {
            /*异步执行*/
            call.enqueue(getRequestCallback());
        }
    }

    public final void get() {
        request(HttpMethod.GET);
    }

    public final void post() {
        request(HttpMethod.POST);
    }

    public final void put() {
        request(HttpMethod.PUT);
    }

    public final void delete() {
        request(HttpMethod.DELETE);
    }


    private Callback<String> getRequestCallback() {
        return new RequestCallbacks(REQUEST, SUCCESS, FAILURE, ERROR);
    }
}
