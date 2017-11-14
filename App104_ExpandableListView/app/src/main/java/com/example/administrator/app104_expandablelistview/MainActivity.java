package com.example.administrator.app104_expandablelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //创建一个BseExpandableListAdapter
        BaseExpandableListAdapter adapter = new BaseExpandableListAdapter() {
            int[] logos = new int[]{
                    R.drawable.p,
                    R.drawable.t,
                    R.drawable.z
            };
            String[] armType = new String[]{
                    "神族兵种",
                    "虫族兵种",
                    "人族兵种"
            };
            String[][] arms=new String[][]{
                    {"狂战士","龙骑士","黑暗圣堂","人族兵种"},
                    {"小狗","刺蛇","飞龙","自爆飞机"},
                    {"机枪兵","护士MM","幽灵"}
            } ;

            @Override
            public int getGroupCount() {
                return armType.length;
            }

            @Override
            public int getChildrenCount(int groupPosition) {
                return arms.length;
            }

            @Override
            public Object getGroup(int groupPosition) {
                return armType[groupPosition];
            }

            @Override
            public Object getChild(int groupPosition, int childPosition) {
                return arms[groupPosition][childPosition];
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
                LinearLayout linearLayout=new LinearLayout(MainActivity.this);
                LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                ImageView imageView=new ImageView(MainActivity.this);
                imageView.setImageResource(logos[groupPosition]);
                TextView textView=getTextView();
                textView.setText(getGroup(groupPosition).toString());
                linearLayout.addView(imageView);
                linearLayout.addView(textView);
                return linearLayout;
            }

            @Override
            public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
                TextView view=getTextView();
                view.setText(getChild(groupPosition,childPosition).toString());
                return view;
            }

            @Override
            public boolean isChildSelectable(int groupPosition, int childPosition) {
                return true;
            }

            private TextView getTextView(){
                TextView view =new TextView(MainActivity.this);
                LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,64);
                view.setLayoutParams(lp);
                view.setGravity(Gravity.CENTER_VERTICAL|Gravity.LEFT);
                view.setPadding(36,0,0,0);
                view.setTextSize(20);
                return view;
            }
        };
        ExpandableListView expandableListView=(ExpandableListView)findViewById(R.id.expand1);
        expandableListView.setAdapter(adapter);
    }
}
