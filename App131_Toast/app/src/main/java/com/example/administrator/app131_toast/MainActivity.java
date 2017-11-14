package com.example.administrator.app131_toast;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button simple=(Button)findViewById(R.id.simple);
        //为按钮的单击事件绑定事件监听器
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建一个toast提示信息
                Toast toast=Toast.makeText(MainActivity.this,"简单的提示信息",Toast.LENGTH_SHORT);
                System.out.println("long"+"   "+Toast.LENGTH_LONG);
                toast.show();
            }
        });
        Button bn=(Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //创建一个Toast提示信息
                Toast toast=new Toast(MainActivity.this);
                //设置Toast的显示位置
                toast.setGravity(Gravity.CENTER,0,0);
                //创建一个ImageView
                ImageView image=new ImageView(MainActivity.this);
                image.setImageResource(R.drawable.tools);
                //创建一个LinearLayout容器
                LinearLayout l1=new LinearLayout(MainActivity.this);
                //向LinearLayout中添加图片、原有的View
                l1.addView(image);
                //创建一个TextView
                TextView textView=new TextView(MainActivity.this);
                textView.setText("带图片的提示信息");
                //设置文本框内字号的大小和字体颜色
                textView.setTextSize(24);
                textView.setTextColor(Color.MAGENTA);
                l1.addView(textView);
                //设置Toast显示自定义view
                toast.setView(l1);
                //设置Toast的显示时间
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
