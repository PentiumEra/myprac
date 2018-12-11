package com.example.mymvp;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.amber.myprac.R;

public class MvpActivity extends AppCompatActivity implements MvpView{
    /*widget*/
    ProgressDialog mProgress;
    TextView mText;

    MvpPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        initView();
    }

    private void initView() {
        mText = (TextView)findViewById(R.id.text);
        // 初始化进度条
        mProgress = new ProgressDialog(this);
        mProgress.setCancelable(false);
        mProgress.setMessage("正在加载数据");
        //初始化Presenter

    }

    // button 点击事件调用方法
    public void getData(View view){
        mPresenter.getData("normal");
    }
    // button 点击事件调用方法
    public void getDataForFailure(View view){
        mPresenter.getData("failure");
    }
    // button 点击事件调用方法
    public void getDataForError(View view){
        mPresenter.getData("error");
    }

    @Override
    public void showLoading() {
        if (!mProgress.isShowing()) {
            mProgress.show();
        }
    }

    @Override
    public void hideLoading() {
        if (mProgress.isShowing()) {
            mProgress.dismiss();
        }
    }

    @Override
    public void showData(String data) {
        mText.setText(data);
    }

    @Override
    public void showFailureMessage(String msg) {

    }

    @Override
    public void showErrorMessage() {

    }
}
