package com.example.administrator.app135_choosedate;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends Activity {
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatePicker datePicker=(DatePicker)findViewById(R.id.datePicker);
        TimePicker timePicker=(TimePicker)findViewById(R.id.timePicker);
        //获取当前年、月、日、时、分钟
        Calendar c=Calendar.getInstance();
        year=c.get(Calendar.YEAR);
        month=c.get(Calendar.MONTH);
        day=c.get(Calendar.DATE);
        hour=c.get(Calendar.HOUR);
        minute=c.get(Calendar.MINUTE);
        //初始化DatePicker组件，初始化时指定监听器
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year=year;
                MainActivity.this.month=monthOfYear;
                MainActivity.this.day=dayOfMonth;
                //显示当前日期、时间
                showDate(year,monthOfYear,dayOfMonth,hour,minute);
            }
        });
    }

    private void showDate(int year, int monthOfYear, int dayOfMonth,int hour,int minute) {
        EditText show=(EditText)findViewById(R.id.show);
        show.setText(String.format("您的购买日期是：%s年%s月%s日%s时%s分",year,monthOfYear,dayOfMonth,hour,minute));
    }
}
