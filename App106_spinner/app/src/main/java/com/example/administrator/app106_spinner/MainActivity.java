package com.example.administrator.app106_spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取spinner插件
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        String[] arr=new String[]{"孙悟空","猪八戒","沙和尚"};
        //创建ArrayAdapter对象
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,arr);
        //为Spinner设置Adapter
        spinner.setAdapter(adapter);
    }
}
