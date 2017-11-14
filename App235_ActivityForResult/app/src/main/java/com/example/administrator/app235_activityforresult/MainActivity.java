package com.example.administrator.app235_activityforresult;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
    Button bn;
    EditText city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 获取界面上的组件
        bn = (Button) findViewById(R.id.bn);
        city = (EditText) findViewById(R.id.city);
        // 为按钮绑定事件监听器
        bn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View source)
            {
                // 创建需要对应于目标Activity的Intent
                Intent intent = new Intent(MainActivity.this,
                        SelectCityActivity.class);
                // 启动指定Activity并等待返回的结果，其中0是请求码，用于标识该请求
                startActivityForResult(intent, 0);
            }
        });
    }
    //重写该方法，该方法以回调方式来获取指定Activity返回的结果

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==0&&requestCode==0)
        {
            //取出Intent里的Extras数据
            Bundle bundle=data.getExtras();
            //取出bundle中的数据
            String resultCity=bundle.getString("city");
            //修改city文本框内容
            city.setText(resultCity);
        }
    }
}
