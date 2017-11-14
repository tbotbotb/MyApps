package com.example.administrator.app145_notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    NotificationManager nm;
    static final int NOTIFICATION_ID=0x123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取系统的NotificationManager服务
        nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
    }

    public void send(View view) {
        //创建一个启动其他Activity的Intent
        Intent intent=new Intent(MainActivity.this,OtherActivity.class);
        PendingIntent pi=PendingIntent.getActivity(MainActivity.this,0,intent,0);
        Notification notify=new Notification.Builder(this)
                //设置打开该通知
        .setAutoCancel(true)
                //设置显示在状态栏的通知提示信息
        .setTicker("有新消息")
                //设置通知图标
        .setSmallIcon(R.drawable.notify)
                //设置通知标题
        .setContentTitle("一条新通知")
                //设置通知内容
        .setContentText("恭喜您！您加薪了，工资增加20%！")
                //设置使用系统默认声音、默认LED灯
        //.setDefaults(Notification.DEFAULT_SOUND| Notification.DEFAULT_LIGHTS)
                //设置通知自定义声音
        .setSound(Uri.parse("android.resource://org.crazit.ui/"+R.raw.msg))
                .setWhen(System.currentTimeMillis())
                //设置通知将要启动的程序的Intent
        .setContentIntent(pi)
                .build();
        //发送通知
        nm.notify(NOTIFICATION_ID,notify);
    }

    public void cancel(View view) {
        nm.cancel(NOTIFICATION_ID);
    }
}
