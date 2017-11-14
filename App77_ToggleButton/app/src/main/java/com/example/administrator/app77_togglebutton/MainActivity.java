package com.example.administrator.app77_togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    Switch switcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton=(ToggleButton)findViewById(R.id.toggle);
        switcher=(Switch)findViewById(R.id.switcher);
        final LinearLayout test=(LinearLayout)findViewById(R.id.test);
        CompoundButton.OnCheckedChangeListener listener=new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
//                    设置LinearLayout垂直布局
                    test.setOrientation(LinearLayout.VERTICAL);
                    toggleButton.setChecked(true);
                    switcher.setChecked(true);
                }
                else{
                    test.setOrientation(LinearLayout.HORIZONTAL);
                    toggleButton.setChecked(false);
                    switcher.setChecked(false);
                }
            }
        };
        toggleButton.setOnCheckedChangeListener(listener);
        switcher.setOnCheckedChangeListener(listener);
    }
}
