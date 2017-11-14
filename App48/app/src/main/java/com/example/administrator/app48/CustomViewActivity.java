package com.example.administrator.app48;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        //获取布局文件中的linearlayout容器
        LinearLayout root=(LinearLayout)findViewById(R.id.root);
        //创建DrawView组件
        final DrawView drawView=new DrawView(this);
        //设置组件最小宽度、高度
        drawView.setMinimumWidth(300);
        drawView.setMinimumHeight(500);
        root.addView(drawView);
    }
}
