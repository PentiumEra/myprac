package com.example.amber.myanim;

import android.app.Application;
import android.content.Context;

/**
 * @Auther linghailong
 * created at 2018/12/26
 * @duscribe:
 */
public class MyApplication extends Application {
    private static Context mContext;

    @Override public void onCreate() {
        super.onCreate();
//        Fresco.initialize(this);//Fresco初始化
        MyApplication.mContext = getApplicationContext();
    }
    public static Context getAppContext() {
        return MyApplication.mContext;
    }

}
