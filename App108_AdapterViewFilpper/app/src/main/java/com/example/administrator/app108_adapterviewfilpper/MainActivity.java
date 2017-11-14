package com.example.administrator.app108_adapterviewfilpper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int[] images=new int[]{
            R.drawable.baiyang,
            R.drawable.chunv,
            R.drawable.jinniu,
            R.drawable.juxie,
            R.drawable.mojie,
            R.drawable.sheshou,
            R.drawable.shizi,
            R.drawable.shuangyu,
            R.drawable.shuangzi,
            R.drawable.shuiping,
            R.drawable.tiancheng,
            R.drawable.tianxie
    };
    AdapterViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flipper=(AdapterViewFlipper)findViewById(R.id.flipper);
        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return images.length;
            }

            @Override
            public Object getItem(int position) {
                return position;
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                ImageView view=new ImageView(MainActivity.this);
                view.setImageResource(images[position]);
                view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                //设置ImageView的缩放类型
                view.setScaleType(ImageView.ScaleType.FIT_XY);
                //为imageView设置布局参数
                return view;
            }
        };

        flipper.setAdapter(adapter);
    }

    public void prev(View source)
    {
        // 显示上一个组件
        flipper.showPrevious();
        // 停止自动播放
        flipper.stopFlipping();
    }
    public void next(View source)
    {
        // 显示下一个组件。
        flipper.showNext();
        // 停止自动播放
        flipper.stopFlipping();
    }
    public void auto(View source)
    {
        // 开始自动播放
        flipper.startFlipping();
    }
}
