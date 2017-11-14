package com.example.administrator.app61_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    GridLayout gridLayout;
    //定义16个按钮的文本
    String[] chars=new  String[]{"7","8","9","÷","4","5","6","×","1","2","3","-",".","0","=","+"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridLayout=(GridLayout)findViewById(R.id.root);
        for (int i=0;i<chars.length;i++){
            Button bn=new Button(this);
            bn.setText(chars[i]);
            //设置字号大小
            bn.setTextSize(40);
            //设置按钮四周空白区域
            bn.setPadding(5,35,5,35);
            //指定按钮所在行
            GridLayout.Spec row= GridLayout.spec(i/4+2);
            //指定按钮所在列
            GridLayout.Spec column= GridLayout.spec(i/4);
            GridLayout.LayoutParams layoutParams=new GridLayout.LayoutParams(row,column);
            //指定占满容器
            layoutParams.setGravity(Gravity.FILL);
            gridLayout.addView(bn);
        }
    }
}
