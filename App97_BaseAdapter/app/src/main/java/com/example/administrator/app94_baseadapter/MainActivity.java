package com.example.administrator.app94_baseadapter;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView mylist=(ListView)findViewById(R.id.mylist);

        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return 40;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                LinearLayout line=new LinearLayout(MainActivity.this);
                line.setOrientation(LinearLayout.VERTICAL);
                ImageView image=new ImageView(MainActivity.this);
                image.setImageResource(R.drawable.ic_launcher);
                TextView text=new TextView(MainActivity.this);
                text.setText("第"+(position+1)+"个列表项");
                text.setTextSize(20);
                text.setTextColor(Color.RED);
                line.addView(image);
                line.addView(text);
                return line;
            }
        };
        mylist.setAdapter(adapter);
    }
}
