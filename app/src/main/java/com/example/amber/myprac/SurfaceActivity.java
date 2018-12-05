package com.example.amber.myprac;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
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
    private boolean mSwitchOn = false;
    /*widget*/
    private MySurfaceView mSurfaceView;
    private SurfaceHolder mHolder;
    private Button mButton;
    private MediaPlayer mBgPlayer;
    private ImageView mIvBtn;

    private SoundPool mSoundPool;
    private int mSoundId;
    private int mStreamID;
    private boolean loaded=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*findviewbyid*/
        mSurfaceView = findViewById(R.id.surface_view);
//        mButton = findViewById(R.id.surface_switch_btn);
        mIvBtn=findViewById(R.id.surface_switch_iv);
       mBgPlayer = new MediaPlayer();
        mHolder = mSurfaceView.getHolder();
        mHolder.setKeepScreenOn(true);
        mHolder.addCallback(new SurfaceViewLis());
        playMayWait();

        /*设置回调*/
        mIvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mSwitchOn) {
                    video_play(0);
                    mSoundPool.resume(mStreamID);
//                    mSoundPool.play(mSoundId,1,1,0,-1,1.0f);
                    mSwitchOn = true;


                } else {
                    Log.e(TAG, "onClick:seekTO0 " );
                        mBgPlayer.seekTo(0);
                        mBgPlayer.stop();
                        mSoundPool.pause(mStreamID);
                        mSwitchOn=false;
                }
            }
        });

    }

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
        //        if (mSoundPool != null) {
                mStreamID = mSoundPool.play(mSoundId,1,1,0,-1,1.0f);
//        }
        loaded=true;

    }

    class SurfaceViewLis implements SurfaceHolder.Callback {

        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            video_play(0);
            mBgPlayer.seekTo(0);
            mBgPlayer.stop();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            // 销毁SurfaceHolder的时候记录当前的播放位置并停止播放
            if (mBgPlayer != null && mBgPlayer.isPlaying()) {
                mBgPlayer.stop();
            }
        }
    }
    @SuppressLint("ObsoleteSdkInt")
    private void createSountPool(){
        if(mSoundPool==null){
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                AudioAttributes audioAttributes = null;
                audioAttributes = new AudioAttributes.Builder()
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .build();

                mSoundPool = new SoundPool.Builder()
                        .setMaxStreams(1)
                        .setAudioAttributes(audioAttributes)
                        .build();
            } else { // 5.0 以前
                mSoundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);  // 创建SoundPool
            }
            mSoundPool.setOnLoadCompleteListener(this);  // 设置加载完成监听
        }

    }


    protected void video_play(final int msec) {
//		// 获取视频文件地址
        try {
            /***/
            mBgPlayer.reset();
            //设置音频流类型
            mBgPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            // 设置播放的视频源
            AssetFileDescriptor fd = this.getAssets().openFd("bg2.mp4");
            mBgPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(),
                    fd.getLength());
            // 设置显示视频的SurfaceHolder
            mBgPlayer.setDisplay(mHolder);//这一步是关键，制定用于显示视频的SurfaceView对象（通过setDisplay（））
            mBgPlayer.prepare();
            mBgPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mBgPlayer.start();

                    // 按照初始位置播放
                    mBgPlayer.seekTo(msec);
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void playMayWait(){
        createSountPool();
        try {
            AssetFileDescriptor fd = this.getAssets().openFd("bg_switch.mp3");
            mSoundId=mSoundPool.load(fd,1);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
