package com.example.administrator.app203_custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by Administrator on 2017/8/20.
 */

public class DrawView extends View {
    public float currentX=40;
    public float currentY=50;
    Paint p=new Paint();
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        p.setColor(Color.RED);
        canvas.drawCircle(currentX,currentY,15,p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.currentX=event.getX();
        this.currentY=event.getY();
        this.invalidate();
        return true;
    }
}
