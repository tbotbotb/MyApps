package com.example.administrator.app137_numberpicker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    NumberPicker np1,np2;
    //定义最低价格、最高价格的初始值
    int minPrice=25,maxPrice=75;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        np1=(NumberPicker)findViewById(R.id.np1);
        np2=(NumberPicker)findViewById(R.id.np2);
        //设置np1的最小值和最大值
        np1.setMinValue(10);
        np1.setMaxValue(50);
        //设置np1的当前值
        np1.setValue(minPrice);
        np1.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                minPrice=newVal;
                showSelectedPrice();
            }
        });
        np2.setMinValue(60);
        np2.setMaxValue(100);
        //设置np2的当前值
        np2.setValue(maxPrice);
        np2.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                maxPrice=newVal;
                showSelectedPrice();
            }
        });
    }

    private void showSelectedPrice() {
        Toast.makeText(MainActivity.this,"您选择的最低价格是"+minPrice+"\r\n"+"您选择的最高价格是"+maxPrice, Toast.LENGTH_SHORT).show();
    }
}
