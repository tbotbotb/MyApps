package com.example.administrator.app87_quickcontactbadge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final QuickContactBadge badge;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取badge组件
        badge=(QuickContactBadge)findViewById(R.id.badge);
        //将QuickContackBadge组件与特定电话号码对应的联系人建立关联
        badge.assignContactFromPhone("13910000262",false);
        TextView text=(TextView)findViewById(R.id.text);
        text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                badge.onClick(v);
            }
        });
    }
}
