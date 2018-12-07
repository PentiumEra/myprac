package com.example.amber.view_chapter1;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

/**
 * @Auther linghailong
 * created at 2018/12/7
 * @duscribe:
 */
public class MyView extends android.support.v7.widget.AppCompatTextView {
    /**/
    private Paint mPaint;
    private Path mPath;
    private Region mRegion;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    private void init() {
        mPaint=new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath=new Path();

        mRegion=new Region();
    }

}
