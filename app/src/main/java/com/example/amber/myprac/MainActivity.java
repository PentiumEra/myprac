package com.example.amber.myprac;

import android.annotation.SuppressLint;
import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements SoundPool.OnLoadCompleteListener {
    private SoundPool mSoundPool;
    private int mSoundId;
    private int mStreamID;
    private boolean loaded=false;

    @SuppressLint("ObsoleteSdkInt")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

    @Override
    public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
//        if (mSoundPool != null) {
//                mStreamID = mSoundPool.play(mSoundId,1,1,16,-1,1.0f);
//        }
        loaded=true;
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
