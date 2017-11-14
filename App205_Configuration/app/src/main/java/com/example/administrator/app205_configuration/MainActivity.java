package com.example.administrator.app205_configuration;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText ori,navigation,touch,mnc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ori=(EditText)findViewById(R.id.ori);
        navigation=(EditText)findViewById(R.id.navigation);
        touch=(EditText)findViewById(R.id.touch);
        mnc=(EditText)findViewById(R.id.mnc);
        Button bn=(Button)findViewById(R.id.bn);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Configuration cfg=getResources().getConfiguration();
                ori.setText(cfg.orientation==Configuration.ORIENTATION_LANDSCAPE?"横向屏幕":"纵向屏幕");
                String naviName=null;
                switch (cfg.navigation){
                    case Configuration.NAVIGATION_NONAV:
                        naviName="没有方向控制";
                        break;
                    case Configuration.NAVIGATION_WHEEL:
                        naviName="滚轮控制方向";
                        break;
                    case Configuration.NAVIGATION_DPAD:
                        naviName="轨迹控制方向";
                }
                navigation.setText(naviName);
                touch.setText(cfg.touchscreen==Configuration.TOUCHSCREEN_NOTOUCH?"无触摸屏":"有触摸屏");
                mnc.setText(cfg.mnc+"");
            }
        });
    }
}
