package com.example.amber.myprac;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @Auther linghailong
 * created at 2018/12/7
 * @duscribe:
 */
public class SurfaceViewL extends SurfaceView implements SurfaceHolder.Callback,Runnable {
    public SurfaceViewL(Context context) {
        this(context,null);
    }

    public SurfaceViewL(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public SurfaceViewL(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public void run() {

    }
}
