package com.example.administrator.app93_listactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
//继承ListActivity
public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //无需使用布局文件
        String[] arr={"孙悟空","猪八戒","沙和尚"};
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_multiple_choice,arr);
        //设置该窗口显示列表
        setListAdapter(adapter);
    }
}
