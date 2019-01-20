package com.example.mymvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.amber.myprac.R;
import com.example.myprac.baselib.myretrofit.net.RestClient;
import com.example.myprac.baselib.myretrofit.net.callback.IError;
import com.example.myprac.baselib.myretrofit.net.callback.ISuccess;

/**
 * @author linghailong
 * @date on 2019/1/15
 * @email 105354999@qq.com
 * @describe :
 */
public class RestActivity extends AppCompatActivity {
    private static final String TAG = "RestActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);

        RestClient.builder().url("https://blog.csdn.net/carson_ho/article/details/73732076").success(new ISuccess() {
            @Override
            public void onSuccess(String response) {
                Log.e(TAG, "onSuccess: " + response);
            }
        }).error(new IError() {
            @Override
            public void onError(String msg) {
                Log.e(TAG, "onError: "+msg );
            }
        }).build().get();
    }
}
