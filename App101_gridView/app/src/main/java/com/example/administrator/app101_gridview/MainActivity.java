package com.example.administrator.app101_gridview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    GridView grid;
    ImageView imageView;
    int[] imageIds = new int[]{
            R.drawable.bomb5, R.drawable.bomb6, R.drawable.bomb7, R.drawable.bomb8, R.drawable.bomb9, R.drawable.bomb10,
            R.drawable.bomb11, R.drawable.bomb12, R.drawable.bomb13, R.drawable.bomb14, R.drawable.bomb15, R.drawable.bomb16
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        grid=(GridView)findViewById(R.id.grid01);
        imageView=(ImageView)findViewById(R.id.imageView) ;
        BaseAdapter ba=new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
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
//                ImageView image=new ImageView(MainActivity.this);
//                image.setImageResource(imageIds[position]);
//                return image;
                ImageView imageview; // 声明ImageView的对象
                if (convertView == null) {
                    imageview = new ImageView(MainActivity.this); // 实例化ImageView的对象
                    imageview.setScaleType(ImageView.ScaleType.CENTER_INSIDE); // 设置缩放方式
                    imageview.setPadding(5, 0, 5, 0); // 设置ImageView的内边距
                } else {
                    imageview = (ImageView) convertView;
                }
                imageview.setImageResource(imageIds[position]); // 为ImageView设置要显示的图片
                return imageview; // 返回ImageView
            }
        };
        grid.setAdapter(ba);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageView.setImageResource(imageIds[position]);
            }
        });
    }
}
