package com.example.mymvp;


import android.os.Handler;


/**
 * @Auther linghailong
 * created at 2018/12/8
 * @duscribe: Model类定义了具体的网络请求操作，通过判断网络请求参数反馈不同的请求状态
 */
public class MvpModel {
    public static void getData(final String param, final MvpCallback callback) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (param) {
                    case "normal":
                        callback.onSuccess("根据参数"+param+"的请求网络成功");
                        break;
                    case "failure":
                        callback.onFailure("根据参数"+param+"请求失败");
                        break;
                    case "error":
                        callback.onError();
                        break;
                    default:
                        break;

                }
                callback.onComplete();
            }
        }, 3000);
    }
}
