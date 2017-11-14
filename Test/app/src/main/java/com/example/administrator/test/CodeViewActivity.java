package com.example.administrator.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class CodeViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建一个线性布局管理器
        LinearLayout layout=new LinearLayout(this);
        //设置该activiti显示layout
        super.setContentView(layout);
        //设置方向为垂直
        layout.setOrientation(LinearLayout.VERTICAL);
        //创建一个textview
        final TextView show=new TextView(this);
        //创建一个按钮
        Button bn=new Button(this);
        bn.setText(" 单击我");
        bn.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        ));
        //向layout容器中添加TextView
        layout.addView(show);
        //向layout容器中添加按钮
        layout.addView(bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show.setText("Hello , Android,"+new Date());
            }
        });

        //setContentView(R.layout.activity_main);
    }

//    public void clickHandler(View source) {
//        TextView tv = (TextView) findViewById(R.id.button2);
//        tv.setText("Hello Android-" + new Date());
//    }
//
//    public void start(View view) {
//        TextView tv=(TextView)findViewById(R.id.button);
//        tv.setText("Good job");
//        TextView tv1= (TextView) findViewById(R.id.background);
//        tv1.setText("Hello");
//    }
}
