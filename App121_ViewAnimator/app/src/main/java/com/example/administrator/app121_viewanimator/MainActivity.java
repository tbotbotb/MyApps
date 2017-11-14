package com.example.administrator.app121_viewanimator;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    //定义一个常量，泳衣显示每屏显示的应用程序数
    public static final int NUMBER_PER_SCREAN=12;

    public void prev(View view) {
        if(screenNo>0){
            screenNo--;
            //为ViewSwitcher的组件显示过程设置动画
            switcher.setInAnimation(this,R.anim.slide_in_left);
            //为ViewSwitcher的组件隐藏过程设置动画
            switcher.setOutAnimation(this,R.anim.slide_out_right);
            //控制下一屏将要显示的GridView对应的Adapter
            ((GridView)switcher.getNextView()).setAdapter(adapter);
            //单机左边按钮，显示上一屏，当然可以采用手势
            //学习手势检测后，也可以通过手势检测实现显示上一屏
            switcher.showPrevious();
        }
    }

    public void next(View view) {
        if(screenNo<screenCount-1){
            screenNo++;
            //为ViewSwitcher的组件显示过程设置动画
            switcher.setInAnimation(this,R.anim.slide_in_right);
            //为ViewSwitcher的组件隐藏过程设置动画
            switcher.setOutAnimation(this,R.anim.slide_out_left);
            //控制下一屏将要显示的GridView对应的adapter
            ((GridView)switcher.getNextView()).setAdapter(adapter);
            //单机右边按钮，显示下一屏
            //学习手势检测后，也可以通过手势检测实现显示下一屏
            switcher.showNext();
        }
    }

    //代表应用程序的内部类
    public static class DataItem{
        //应用程序名称
        public String dataName;
        //应用程序图标
        public Drawable drawable;
    }
    //保存系统所有应用程序的List集合
    private List<DataItem> items=new ArrayList<DataItem>();
    //记录当前第几屏的程序
    private int screenNo=-1;
    //保存程序所占的总屏数
    private int screenCount;
    ViewSwitcher switcher;
    //创建LayoutInflater对象
    LayoutInflater inflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inflater=LayoutInflater.from(MainActivity.this);
        //创建一个包含40个元素的List集合，用于模拟包含40个应用程序
        for (int i=0;i<40;i++){
            String label=""+i;
            Drawable drawable=getResources().getDrawable(R.drawable.ic_launcher);
            DataItem item=new DataItem();
            item.dataName=label;
            item.drawable=drawable;
            items.add(item);
        }
        //计算应用程序所占的总屏数
        //如果应用程序的数量能整除NUMBER_PER_SCREEN，除法的结果就是总屏数
        //如果不能整除，总屏数应该是除法的结构再加1
        screenCount=items.size()%NUMBER_PER_SCREAN+1==0?
                items.size()/NUMBER_PER_SCREAN:items.size()/NUMBER_PER_SCREAN+1;
        switcher=(ViewSwitcher)findViewById(R.id.viewSwitcher);
        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            //返回一个GridView组件
            @Override
            public View makeView() {
                //加载R.layout.slidelistview组件，实际上就是一个GridView组件
                return inflater.inflate(R.layout.slidelistview,null);
            }
        });
        //页面加载时先显示第一屏
        next(null);
    }

    BaseAdapter adapter=new BaseAdapter() {
        @Override
        public int getCount() {
            if(screenNo==screenCount-1&&screenNo%NUMBER_PER_SCREAN!=0){
                return  items.size()%NUMBER_PER_SCREAN;
            }
            else {
                return NUMBER_PER_SCREAN;
            }
        }

        @Override
        public DataItem getItem(int position) {
            return items.get(position+screenNo*NUMBER_PER_SCREAN);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view=convertView;
            if(convertView==null){
                //加载R.layout.labelicon布局文件
                view=inflater.inflate(R.layout.labelicon,null);
            }
            //获取R.layout.labelicon中的ImageView组件，并为之设置图标
            ImageView imageView=(ImageView)view.findViewById(R.id.imageview);
            imageView.setImageDrawable(getItem(position).drawable);
            //获取R.layout.labelicon布局文件中的TextView组件，并为之设置文本
            TextView textView=(TextView)view.findViewById(R.id.textview);
            textView.setText(getItem(position).dataName);
            return view;
        }
    };
}
