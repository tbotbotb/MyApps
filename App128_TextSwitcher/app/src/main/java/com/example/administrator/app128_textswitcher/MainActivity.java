package com.example.administrator.app128_textswitcher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    TextSwitcher textSwitcher;
    String[] strs=new String[]{
            "疯狂java讲义",
            "轻量级Java EE企业应用实战",
            "疯狂android讲义",
            "疯狂ajax讲义"
    };
    int curStr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textSwitcher=(TextSwitcher)findViewById(R.id.textSwitcher);
        textSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                TextView tv=new TextView(MainActivity.this);
                tv.setLayoutParams(new TextSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tv.setTextSize(40);
                tv.setTextColor(Color.MAGENTA);
                return tv;
            }
        });
        next(null);
    }

    public void next(View view) {
        textSwitcher.setText(strs[curStr++%strs.length]);
    }
}
