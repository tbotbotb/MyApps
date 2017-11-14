package com.example.administrator.app192_plane;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Administrator on 2017/8/19.
 */

public class PlaneView extends View {
    public  float currentX;
    public  float currentY;
    Bitmap plane;
    public PlaneView(Context context) {
        super(context);
        //定义飞机图片
        plane= BitmapFactory.decodeResource(context.getResources(),R.drawable.plane);
        setFocusable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint p=new Paint();
        //绘制飞机
        canvas.drawBitmap(plane,currentX,currentY,p);
    }
}
