package com.example.administrator.app55;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private  int currentColor=0;
    final int[] colors=new int[]{
      R.color.color1,
            R.color.color2,
            R.color.color3,
            R.color.color4,
            R.color.color5,
            R.color.color6,
    };
    final int[] names=new int[]{
      R.id.view01,
            R.id.view02,
            R.id.view03,
            R.id.view04,
            R.id.view05,
            R.id.view06,
    };

    TextView[] views=new TextView[names.length];

    Handler handler=new Handler(){
        @Override
        public  void handleMessage(Message msg){
            //表明消息来自本程序所发送
            if(msg.what==0x123){
                for (int i=0;i<names.length;i++){
                    views[i].setBackgroundResource(colors[(i+currentColor)%colors.length]);
                }
                currentColor++;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i=0;i<colors.length;i++){
            views[i]=(TextView)findViewById(names[i]);
        }
        //定义一个线程周期性改变currentColor
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,200);
    }
}
