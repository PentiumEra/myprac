package com.example.amber.view_chapter1;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.example.amber.myprac.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener{
    private ImageView ivTxt;
    private Button btnOn,btnOff;
    private AnimatorSet animatorSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         ivTxt=findViewById(R.id.iv_txt);
         btnOn=findViewById(R.id.btn_switch_on);
         btnOff=findViewById(R.id.btn_switch_off);
         btnOn.setOnClickListener(this);
         btnOff.setOnClickListener(this);
        setTxtAnimation();





    }
    public void setTxtAnimation(){
//        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat(ivTxt, "alpha", 1f, 1f);
//        alphaAnimator.setRepeatCount(1);
//        alphaAnimator.setDuration(200);

        ObjectAnimator translateAnimator=ObjectAnimator.ofFloat(ivTxt,"translationX",-50f,50f,1);
        translateAnimator.setDuration(800);
        translateAnimator.setRepeatCount(1);

        translateAnimator.setInterpolator(new BounceInterpolator());
        translateAnimator.setRepeatCount(1);
        translateAnimator.setRepeatMode(ValueAnimator.RESTART);
        ObjectAnimator alpha2Animator = ObjectAnimator.ofFloat(ivTxt, "alpha", 1f, 0f);
        alpha2Animator.setDuration(500);
         animatorSet=new AnimatorSet();
        animatorSet.play(translateAnimator).before(alpha2Animator);
//        .with(alphaAnimator)

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_switch_on:
                animatorSet.start();
                break;
            case R.id.btn_switch_off:
                animatorSet.end();
                break;
        }
    }
}
