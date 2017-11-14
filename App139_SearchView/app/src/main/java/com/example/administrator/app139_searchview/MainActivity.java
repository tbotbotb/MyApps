package com.example.administrator.app139_searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SearchView sv;
    private ListView lv;
    //自动完成列表
    private final String[] mString=new String[]{"aaaa","bbbbb","cccccc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);
        sv=(SearchView)findViewById(R.id.sv);
        lv.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,mString));
        //设置ListView启用过滤
        lv.setTextFilterEnabled(true);
        //设置该SearchView默认是否自动缩小为图标
        sv.setIconifiedByDefault(false);
        //设置该SearchView显示搜索按钮
        sv.setSubmitButtonEnabled(true);
        //设置该SearchView内默认显示的提示文本
        sv.setQueryHint("查找");
        //为该SearchView组件设置事件监听器
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            //用户点击搜索按钮时激发该方法
            public boolean onQueryTextSubmit(String query) {
                //实际应用中应该在方法内执行实际查询
                //此处仅使用Toast显示用户输入的查询内容
                Toast.makeText(MainActivity.this,"您的选择是："+query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            //用户输入字符时激发该方法
            public boolean onQueryTextChange(String newText) {
                //如果不是长度为0的字符串
                if(TextUtils.isEmpty(newText)){
                    //清除ListView的过滤
                    lv.clearTextFilter();
                }
                else{
                    //使用用户输入的内容对ListView的列表项进行过滤
                    lv.setFilterText(newText);
                }
                return true;
            }
        });

    }
}
