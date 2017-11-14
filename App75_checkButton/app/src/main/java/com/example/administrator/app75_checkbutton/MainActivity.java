package com.example.administrator.app75_checkbutton;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    TextView show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取界面上rg、show两个组件
        rg=(RadioGroup)findViewById(R.id.rg);
        show=(TextView)findViewById(R.id.show);
        //为RadioGroup组件的OnCheckedChangeListener时间绑定事件监听器
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                //根据用户勾选的单选按钮来动态改变tip字符串的值
                String tip=checkedId==R.id.male?"您的性别是男人":"您的性别是女人";
                show.setText(tip);
            }
        });
    }
}
