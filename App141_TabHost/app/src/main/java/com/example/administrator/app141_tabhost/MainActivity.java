package com.example.administrator.app141_tabhost;

import android.app.TabActivity;
import android.os.Bundle;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取该Activity里面的TabHost组件
        TabHost tabHost = getTabHost();
        //创建第一个Tab页面
        TabHost.TabSpec tab1 = tabHost.newTabSpec("tab1")
                .setIndicator("已接电话")//设置标题
                .setContent(R.id.tab01);//设置内容
        TabHost.TabSpec tab2=tabHost.newTabSpec("tab2")
                //在标签上放置图片
        .setIndicator("呼出电话",getResources().getDrawable(R.drawable.ic_launcher))
                .setContent(R.id.tab02);
        TabHost.TabSpec tab3=tabHost.newTabSpec("tab3")
                .setIndicator("未接电话")
                .setContent(R.id.tab03);
        tabHost.addTab(tab1);
        tabHost.addTab(tab2);
        tabHost.addTab(tab3);
    }
}
