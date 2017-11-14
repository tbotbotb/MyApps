package com.example.administrator.app209_handler;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    int[] images=new int[]{
            R.drawable.java,
            R.drawable.javaee,
            R.drawable.ajax,
            R.drawable.android,
            R.drawable.swift
    };
    int currentImageId=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView show=(ImageView)findViewById(R.id.show);
        final Handler myHandler=new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what==0x1233){
                    show.setImageResource(images[currentImageId++%images.length]);
                }
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //发送空消息
                myHandler.sendEmptyMessage(0x1233);
            }
        },0,1200);
    }
}
