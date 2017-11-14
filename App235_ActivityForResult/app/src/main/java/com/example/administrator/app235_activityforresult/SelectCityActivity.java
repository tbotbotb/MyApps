package com.example.administrator.app235_activityforresult;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/8/21.
 */

public class SelectCityActivity extends ExpandableListActivity {
    // 定义省份数组
    private String[] provinces = new String[]
            {"广东", "广西", "湖南"};
    private String[][] cities = new String[][]
            {
                    {"广州", "深圳", "珠海", "中山"},
                    {"桂林", "柳州", "南宁", "北海"},
                    {"长沙", "岳阳", "衡阳", "株洲"}
            };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ExpandableListAdapter adapter=new BaseExpandableListAdapter() {
            @Override
            public int getGroupCount() {
                return provinces.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return cities[groupPosition].length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return provinces[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return cities[groupPosition][childPosition];
            }

            @Override
            public long getGroupId(int groupPosition) {
                return groupPosition;
            }

            @Override
            public long getChildId(int groupPosition, int childPosition) {
                return childPosition;
            }

            @Override
            public boolean hasStableIds() {
                return true;
            }

            @Override
            public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                LinearLayout l1=new LinearLayout(SelectCityActivity.this);
                l1.setOrientation(LinearLayout.HORIZONTAL);
                ImageView logo=new ImageView(SelectCityActivity.this);
                l1.addView(logo);
                TextView textView=getTextView();
                textView.setText(getGroup(groupPosition).toString());
                l1.addView(textView);
                return l1;
            }

            private TextView getTextView()
            {
                AbsListView.LayoutParams lp = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT, 64);
                TextView textView = new TextView(SelectCityActivity.this);
                textView.setLayoutParams(lp);
                textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                textView.setPadding(36, 0, 0, 0);
                textView.setTextSize(20);
                return textView;
            }
            // 该方法决定每个子选项的外观
            @Override
            public View getChildView(int groupPosition, int childPosition,
                                     boolean isLastChild, View convertView, ViewGroup parent)
            {
                TextView textView = getTextView();
                textView.setText(getChild(groupPosition, childPosition)
                        .toString());
                return textView;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }
        };
        // 设置该窗口显示列表
        setListAdapter(adapter);
        getExpandableListView().setOnChildClickListener(
                new ExpandableListView.OnChildClickListener()
                {
                    @Override
                    public boolean onChildClick(ExpandableListView parent,
                                                View source, int groupPosition, int childPosition,
                                                long id)
                    {
                        // 获取启动该Activity之前的Activity对应的Intent
                        Intent intent = getIntent();
                        Bundle bundle=new Bundle();
                        bundle.putSerializable("city",cities[groupPosition][childPosition]);
//                        intent.putExtra("city",
//                                cities[groupPosition][childPosition]);
                        intent.putExtras(bundle);
                        // 设置该SelectCityActivity的结果码，并设置结束之后退回的Activity
                        SelectCityActivity.this.setResult(0, intent);
                        // 结束SelectCityActivity。
                        SelectCityActivity.this.finish();
                        return false;
                    }
                });
    }
}
