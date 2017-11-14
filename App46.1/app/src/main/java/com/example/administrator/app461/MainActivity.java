package com.example.administrator.app461;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    int[] images=new int[]{
            R.drawable.p2,
            R.drawable.p3,
            R.drawable.p4,
            R.drawable.p5
    };
    int currentImage=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取LinearLayout布局容器
        LinearLayout main=(LinearLayout)findViewById(R.id.root);
        //程序创建ImageView组件
        final ImageView image=new ImageView(this);
        //将ImageView组件添加到LinearLayout布局容器中
        main.addView(image);
        image.setImageResource(images[0]);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //改变ImageView里的图片
                image.setImageResource(images[++currentImage%images.length]);
            }
        });
    }
}
