package com.example.amber.myprac;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;

public class SurfaceActivity extends AppCompatActivity {
    private boolean mSwitchOn=true;
    /*widget*/
    private SurfaceView mSurfaceView;
    private Button mButton;
    private MediaPlayer mBgPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*findviewbyid*/
        mSurfaceView=findViewById(R.id.surface_view);
        mButton=findViewById(R.id.surface_switch_btn);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mSwitchOn){
                    video_play(0);
                }
            }
        });
        mBgPlayer=new MediaPlayer();
        mSurfaceView.getHolder().setKeepScreenOn(true);
        mSurfaceView.getHolder().addCallback(new SurfaceViewLis());
    }
    class SurfaceViewLis implements SurfaceHolder.Callback{

        @Override
        public void surfaceCreated(SurfaceHolder holder) {

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
    protected void video_play(final int msec) {
//		// 获取视频文件地址
        try {
            mBgPlayer = new MediaPlayer();
            //设置音频流类型
//            AssetManager assetMg = this.getAssets();
//            AssetFileDescriptor fileDescriptor = assetMg.openFd("bg.mp4");
//            mBgPlayer.setDataSource(fileDescriptor.getFileDescriptor(),
//                    fileDescriptor.getStartOffset(), fileDescriptor.getLength());
            //设置音频流类型
            mBgPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            // 设置播放的视频源
            AssetFileDescriptor fd = this.getAssets().openFd("bg.mp4");
            mBgPlayer.setDataSource(fd.getFileDescriptor(), fd.getStartOffset(),
                    fd.getLength());
            // 设置显示视频的SurfaceHolder
            mBgPlayer.setDisplay(mSurfaceView.getHolder());//这一步是关键，制定用于显示视频的SurfaceView对象（通过setDisplay（））

            mBgPlayer.prepareAsync();
            mBgPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

                @Override
                public void onPrepared(MediaPlayer mp) {
                    mBgPlayer.start();

                    // 按照初始位置播放
                    mBgPlayer.seekTo(msec);
                    // 设置进度条的最大进度为视频流的最大播放时长
                }
            });
            mBgPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

                @Override
                public void onCompletion(MediaPlayer mp) {
                    // 在播放完毕被回调
                }
            });

            mBgPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {

                @Override
                public boolean onError(MediaPlayer mp, int what, int extra) {
                    // 发生错误重新播放
                    video_play(0);
                    mSwitchOn = false;
                    return false;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
