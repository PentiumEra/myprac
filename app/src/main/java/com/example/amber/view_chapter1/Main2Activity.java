package com.example.amber.view_chapter1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;

import com.example.amber.myprac.R;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1);
        alphaAnimation.setRepeatMode(-1);
    }

}
