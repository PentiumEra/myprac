package com.example.myprac.baselib.myretrofit.net.rx;

import com.example.myprac.baselib.myretrofit.net.HttpMethod;
import com.example.myprac.baselib.myretrofit.net.RestClientBuilder;
import com.example.myprac.baselib.myretrofit.net.RestCreator;
import com.example.myprac.baselib.myretrofit.net.RestService;
import com.example.myprac.baselib.myretrofit.net.callback.IError;
import com.example.myprac.baselib.myretrofit.net.callback.IFailure;
import com.example.myprac.baselib.myretrofit.net.callback.IRequest;
import com.example.myprac.baselib.myretrofit.net.callback.ISuccess;
import com.example.myprac.baselib.myretrofit.net.callback.RequestCallbacks;

import java.io.File;
import java.util.WeakHashMap;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;

/**
 * @author linghailong
 * @date on 2019/1/14
 * @email 105354999@qq.com
 * @describe :
 */
public class RxRestClient {
    private final String URL;
    private final RequestBody BODY;
    private final WeakHashMap<String, Object> PARAMS;
    private final File FILE;
    private final Object OBJECT;
    private final String DOWNLOAD_DIR;

    public RxRestClient(String url, WeakHashMap<String, Object> params,
                        RequestBody body,
                        File file,
                        Object object,
                        String download_dir) {
        this.URL = url;
        this.PARAMS = params;
        this.BODY = body;
        this.FILE = file;
        this.OBJECT = object;
        this.DOWNLOAD_DIR = download_dir;
    }

    public static RxRestClientBuilder builder() {
        return new RxRestClientBuilder();
    }

    private Observable<String> request(HttpMethod method) {
        final RxRestService restService = RestCreator.getRxRestService();
        Observable<String> observable = null;

        switch (method) {
            case GET:
                observable = restService.get(URL, PARAMS);
                break;
            case PUT:
                observable = restService.post(URL, PARAMS);
                break;
            case POST:
                observable = restService.put(URL, PARAMS);
                break;
            case DELETE:
                observable = restService.delete(URL, PARAMS);
                break;
            default:
                break;

        }
        return observable;
    }

    public final Observable<String> get() {
        return request(HttpMethod.GET);
    }

    public final Observable<String> post() {

        return request(HttpMethod.POST);
    }

    public final Observable<String> put() {

        return request(HttpMethod.PUT);
    }

    public final Observable<String> delete() {
        return request(HttpMethod.DELETE);
    }
}
