package com.example.myprac.baselib.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.myprac.baselib.presenters.BasePresenter;

import me.yokeyword.fragmentation.ISupportActivity;

/**
 * @Auther linghailong
 * created at 2019/1/2
 * @duscribe:
 */
public abstract class MvpBaseAcvity<V, T extends BasePresenter<V>> extends BaseActivity
        implements ISupportActivity {
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        mPresenter.attachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.detachView();
    }

    protected abstract T createPresenter();
    Bitmap
}
