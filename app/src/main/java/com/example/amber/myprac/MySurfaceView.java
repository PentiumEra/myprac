package com.example.amber.myprac;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
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
    private SurfaceHolder holder;
    private Context mContext;
    private MyThread myThread;
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
        myThread=new MyThread(holder);

    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        myThread.isRun=true;
        myThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
            myThread.isRun=false;
    }
    class MyThread extends Thread{
        public  boolean isRun;
        private SurfaceHolder holder;

        public MyThread(SurfaceHolder holder) {
            this.holder = holder;
        }

        @Override
        public void run() {
            super.run();
            int count=0;
//            while (isRun){
//                Canvas canvas=null;
//                synchronized (holder){
//                    canvas = holder.lockCanvas();//锁定画布，一般在锁定后就可以通过其返回的画布对象Canvas，在其上面画图等操作了。
//                    canvas.drawColor(Color.GREEN);
//                    Paint p = new Paint();
//                    p.setColor(Color.WHITE);
//                    Rect r = new Rect(100, 50, 300, 250);
//                    canvas.drawRect(r, p);
//                    p.setTextSize(40);
//                    canvas.drawText("这是第" + (count++) + "秒", 100, 310, p);
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                }
//            }
        }
    }
}
