package com.example.administrator.app99_autocompletetext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    //定义字符串数组，作为提示文本
    String[] books=new String[]{"疯狂Java讲义","疯狂Ajax讲义","疯狂XML讲义","疯狂Workflow讲义","Java"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AutoCompleteTextView auto=(AutoCompleteTextView)findViewById(R.id.auto);
        MultiAutoCompleteTextView mauto=(MultiAutoCompleteTextView)findViewById(R.id.mauto);
        //创建一个ArrayAdapter，封装数组
        ArrayAdapter ba=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,books);
        //设置Adapter
        auto.setAdapter(ba);
        //设置Adapter
        mauto.setAdapter(ba);
        //为MultiAutoCompleteTextView设置分隔符
        mauto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
    }
}
