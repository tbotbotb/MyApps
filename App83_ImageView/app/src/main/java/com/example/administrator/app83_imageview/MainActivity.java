package com.example.administrator.app83_imageview;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int[]images=new int[]{
            R.drawable.lijiang,
            R.drawable.qiao,
            R.drawable.shuangta,
            R.drawable.shui,
            R.drawable.xiangbi,
    };
    //定义默认显示的图片
    int currentImg=2;
    //定义图片的初始透明度
    private int alpha=255;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button plus=(Button)findViewById(R.id.plus);
        final Button minus=(Button)findViewById(R.id.minus);
        final Button next=(Button)findViewById(R.id.next);
        final ImageView image1=(ImageView)findViewById(R.id.image1);
        final  ImageView image2=(ImageView)findViewById(R.id.image2);
        //定义查看下一张图片的事件监听器
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                image1.setImageResource(images[++currentImg%images.length]);
            }
        });
        //定义改变图片透明度的方法
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(v==plus){
                    alpha+=20;
                }
                if(v==minus){
                    alpha-=20;
                }
                if(alpha>255){
                    alpha=255;
                }
                if(alpha<=0){
                    alpha=0;
                }
                image1.setImageAlpha(alpha);
            }
        };
        //为两个按钮添加监听器
        plus.setOnClickListener(listener);
        minus.setOnClickListener(listener);
        image1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                BitmapDrawable bitmapDrawable=(BitmapDrawable)image1.getDrawable();
                //获取第一个图片显示框中的位图
                Bitmap bitmap=bitmapDrawable.getBitmap();
                //bitmap图片的实际大小与第一个ImageView的缩放比例
//                double scale=1.0*bitmap.getHeight()/image1.getHeight();
                int scale=1;
                int x=(int)(event.getX()*scale);
                int y=(int)(event.getY()*scale);
                if(x+120>event.getX()*scale){
                    x=bitmap.getWidth()-120;
                }
                if(y+120> bitmap.getHeight()){
                    y=bitmap.getHeight()-120;
                }
                //显示图片指定区域
                image2.setImageBitmap(Bitmap.createBitmap(bitmap,x,y,120,120));
                return  false;
            }
        });
    }
}
