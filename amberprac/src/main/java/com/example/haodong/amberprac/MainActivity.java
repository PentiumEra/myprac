package com.example.haodong.amberprac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.facebook.drawee.backends.pipeline.Fresco;

public class MainActivity extends AppCompatActivity {
    private static final String TAG =MainActivity.class.getSimpleName();
    RecyclerView mRecyclerView;
    private MyTestAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView=findViewById(R.id.recyclerview);
        if (mAdapter == null) {
            /*初始化Freco的默认配置使用*/
            Log.e(TAG, "onCreate: lhl"+Fresco.hasBeenInitialized());
            if (!Fresco.hasBeenInitialized()){
                Fresco.initialize(this);
            }
            mAdapter = new MyTestAdapter(getLayoutInflater());
            mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
            mRecyclerView.setAdapter(mAdapter);
        }
    }
}
