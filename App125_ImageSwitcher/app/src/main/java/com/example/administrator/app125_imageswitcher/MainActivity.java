package com.example.administrator.app125_imageswitcher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    int[] imageIds = new int[]{
            R.drawable.bomb10,
            R.drawable.bomb11,
            R.drawable.bomb12,
            R.drawable.bomb13,
            R.drawable.bomb14,
            R.drawable.bomb15,
            R.drawable.bomb16,
            R.drawable.bomb5,
            R.drawable.bomb6,
            R.drawable.bomb7,
            R.drawable.bomb8,
            R.drawable.bomb9,
    };
    ImageSwitcher switcher;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个List对象，List对象的元素是Map
        List<Map<String,Object>> listItems=new ArrayList<>();
        for (int i=0;i<imageIds.length;i++){
            Map<String,Object> listItem=new HashMap<>();
            listItem.put("image",imageIds[i]);
            listItems.add(listItem);
        }
        //获取图片的ImageSwitcher
        switcher=(ImageSwitcher)findViewById(R.id.switcher);
        //为ImageSwitcher设置图片切换动画效果
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //创建ImageView对象
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                //返回ImageView对象
                return imageView;
            }
        });

        BaseAdapter adapter=new BaseAdapter() {
            @Override
            public int getCount() {
                return imageIds.length;
            }

            @Override
            public Object getItem(int position) {
                return imageIds[position];
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                //创建ImageView对象
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                imageView.setImageResource(imageIds[position]);
                //返回ImageView对象
                return imageView;
            }
        };

        GridView grid=(GridView)findViewById(R.id.grid01);
        grid.setAdapter(adapter);
        //添加列表备被选中的监听器
        grid.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //显示当前被选中的图片
                switcher.setImageResource(imageIds[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //显示被单击的图片
                switcher.setImageResource(imageIds[position]);
            }
        });
    }
}
