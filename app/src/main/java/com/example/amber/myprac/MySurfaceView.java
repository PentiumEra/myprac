package com.example.amber.myprac;

import android.content.Context;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * @Auther lignhailong
 * created at 2018/12/4
 * @duscribe: surfaceView 练习
 */
public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    public MediaPlayer mMediaPlayer;
    private SurfaceHolder holder;
    private Context mContext;
    public MySurfaceView(Context context) {
        this(context,null);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        holder=this.getHolder();
        holder.addCallback(this);
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
}
