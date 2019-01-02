package com.example.amber.myprac;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;

/**
 * @Auther linghailong
 * created at 2018/12/28
 * @duscribe:
 */
public class MyPlayer implements MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener,
        MediaPlayer.OnErrorListener,MediaPlayer.OnInfoListener {
    private MediaPlayer mPlayer;
    private boolean hasPrepared;
    private ImageView ivBg;
    private SurfaceView mSurfaceView;

    private void initIfNessary() {
        if (null == mPlayer) {
            mPlayer = new MediaPlayer();
            mPlayer.setOnErrorListener(this);
            mPlayer.setOnCompletionListener(this);
            mPlayer.setOnPreparedListener(this);
            mPlayer.setOnPreparedListener(this);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        hasPrepared = false;
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        hasPrepared = true;
        start();
        seekTo(0);
        pause();


    }

    public void play(Context context, String dataSource,SurfaceHolder holder ) {
        hasPrepared = false;
        initIfNessary();
        //设置音频流类型
        mPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        // 设置播放的视频源
        AssetFileDescriptor fd = null;
        try {
            fd = context.getAssets().openFd(dataSource);
            mPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(),
                    fd.getLength());
            mPlayer.setDisplay(holder);
            mPlayer.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void start(){
        if (null!=mPlayer&&hasPrepared){
            mPlayer.start();
        }
    }
    public void pause(){
        if (null!=mPlayer&&hasPrepared){
            mPlayer.pause();
        }
    }

    public void seekTo(int position){
        if(null!=mPlayer&&hasPrepared){
            mPlayer.seekTo(position);
        }
    }

    /**
     * 绑定surfaceHolder
     * @param holder
     */
    public void setDisplay(SurfaceHolder holder){
        if (null!=mPlayer){
            mPlayer.setDisplay(holder);
        }
    }
    public void setImgBg(ImageView imageView,SurfaceView surfaceView){
        this.ivBg=imageView;
        this.mSurfaceView=surfaceView;
    }

    /**
     * 释放资源
     */
    public void release(){
        hasPrepared=false;
        mPlayer.stop();
        mPlayer.release();
        mPlayer=null;
    }

    public void setIvBg(ImageView ivBg) {
        this.ivBg = ivBg;
    }

    @Override
    public boolean onInfo(MediaPlayer mp, int what, int extra) {
            if(what == mp.MEDIA_INFO_BUFFERING_END){
                //隐藏缩略图
                ivBg.setVisibility(View.GONE);
            }
        return false;
    }
}