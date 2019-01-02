package com.example.amber.myprac;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class SurfaceActivity extends AppCompatActivity implements SoundPool.OnLoadCompleteListener {
    private static final String TAG = "SurfaceActivity";
    /*widget*/
    private SurfaceView mSurfaceView;
    private SurfaceHolder mHolder;
    private ImageView mIvBtn;

    private SoundPool mSoundPool;
    private boolean loaded = false;
    private int mSoundOff;
    private int mSoundOn;

    private boolean isSwitchOn = false;
    public static Handler mHandler = new Handler();
    private Runnable r;
    /*media*/
    private MyPlayer myPlayer = null;

    private boolean isLoaded = false;

    private ImageView ivBggg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myPlayer = new MyPlayer();
        /*findviewbyid*/
        mSurfaceView = findViewById(R.id.surface_view);
        mIvBtn = findViewById(R.id.surface_switch_iv);
        ivBggg = findViewById(R.id.iv_bggg);
        ivBggg.setVisibility(View.INVISIBLE);
        /*surfaceView*/
        mHolder = mSurfaceView.getHolder();
        mHolder.setKeepScreenOn(true);
        mHolder.addCallback(new SurfaceViewLis());
        playMayWait();
        mSurfaceView.setZOrderMediaOverlay(true);
        mHolder.setFormat(PixelFormat.RGB_888);
        /*设置回调*/
        mIvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isSwitchOn) {
                    switchOn();
                    mHandler.removeCallbacks(r);
                    r = new Runnable() {
                        @Override
                        public void run() {
                            if (isSwitchOn) {
                                Log.e(TAG, "run: +++++" + isSwitchOn);
                                mIvBtn.setBackgroundResource(R.drawable.close);
                                myPlayer.start();
                                myPlayer.seekTo(0);
                                myPlayer.pause();
                                isSwitchOn = false;
                            }
                        }
                    };
                    mHandler.postDelayed(r, 3100);
                } else {
                    switchOff();
                    mHandler.removeCallbacks(r);
                }
            }
        });
    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        loaded = true;
    }

    class SurfaceViewLis implements SurfaceHolder.Callback {

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            Log.e(TAG, "surfaceCreated: +++");
            myPlayer.setIvBg(ivBggg);
            myPlayer.play(SurfaceActivity.this, "bg2.mp4", mHolder);

        }

        public Bitmap getBitmapFormResources() {
            return BitmapFactory.decodeResource(SurfaceActivity.this.getResources(), R.drawable
                    .bgggg);
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            Log.e(TAG, "surfaceChanged: ");
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            ivBggg.setVisibility(View.VISIBLE);
            mSurfaceView.setVisibility(View.INVISIBLE);
            myPlayer.release();
            isLoaded = false;
        }
    }

    @SuppressLint("ObsoleteSdkInt")
    private void createSountPool() {
        if (mSoundPool == null) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                AudioAttributes audioAttributes = null;
                audioAttributes = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build();

                mSoundPool = new SoundPool.Builder()
                        .setMaxStreams(2)
                        .setAudioAttributes(audioAttributes)
                        .build();
            } else { // 5.0 以前
                mSoundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);  // 创建SoundPool
            }
            mSoundPool.setOnLoadCompleteListener(this);  // 设置加载完成监听
        }

    }

    public void switchOn() {
        ivBggg.setVisibility(View.GONE);
        mIvBtn.setBackgroundResource(R.drawable.open);
        mSurfaceView.setVisibility(View.VISIBLE);
        mSoundPool.play(mSoundOn, 1, 1, 0, 0, 1);
        isSwitchOn = true;
        myPlayer.seekTo(0);
        myPlayer.start();
    }

    public void switchOff() {
        mIvBtn.setBackgroundResource(R.drawable.close);
        mSoundPool.play(mSoundOff, 1, 1, 0, 0, 1);
        myPlayer.start();
        myPlayer.seekTo(0);
        myPlayer.pause();
        isSwitchOn = false;
    }

    public void playMayWait() {
        createSountPool();
        try {
            /*关闭的声音*/
            mSoundOff = mSoundPool.load(this.getAssets().openFd("music_switch_off.mp3"), 1);
            /*开启的声音*/
            mSoundOn = mSoundPool.load(this.getAssets().openFd("music_switch_on.mp3"), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
