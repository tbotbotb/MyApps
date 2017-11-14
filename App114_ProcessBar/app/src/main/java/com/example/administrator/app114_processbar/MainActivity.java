package com.example.administrator.app114_processbar;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    //该程序模拟填充长度为100的数组
    private int[] data = new int[100];
    int hasData = 0;
    //记录ProgressBar的完成进度
    int status = 0;
    ProgressBar progressBar, progressBar2;
    //创建一个负责更新的进度的Handler
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if(msg.what==0x111){
                progressBar.setProgress(status);
                progressBar2.setProgress(status);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        progressBar2=(ProgressBar)findViewById(R.id.progressBar2);
        //启动线程来执行任务
        new Thread(){
            public void run(){
                while(status<100){
                    //获取耗时完成操作的完成百分比
                    status=doWork();
                    //发送消息
                    handler.sendEmptyMessage(0x111);
                }
            }
        }.start();
        //模拟一个耗时操作

    }

    private int doWork() {
        //为数组元赋值
        data[hasData++]=(int)(Math.random()*100);
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return hasData;
    }
}
