package com.example.administrator.app232_bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/8/20.
 */

public class ResultActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        TextView name = (TextView) findViewById(R.id.name);
        TextView passwd = (TextView) findViewById(R.id.passwd);
        TextView gender = (TextView) findViewById(R.id.gender);
        Intent intent=getIntent();
        Person p=(Person)intent.getSerializableExtra("person");
        name.setText("您的用户名为："+p.getName());
        passwd.setText("您的密码为："+p.getPasswd());
        gender.setText("您的性别为："+p.getGender());
        Toast.makeText(ResultActivity.this,"您的用户名为："+p.getName()+"\n"+"您的密码为："+p.getPasswd()+
                "\n"+"您的性别为："+p.getGender(),Toast.LENGTH_SHORT).show();
    }
}
