package com.example.administrator.app111_stackview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.StackView;

public class MainActivity extends AppCompatActivity {
    StackView stackView;
    int[] images=new int[]{
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
            R.drawable.bomb9
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        stackView=(StackView)findViewById(R.id.staticView);
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
                 return view;
            }
        };
        stackView.setAdapter(adapter);
    }

    public void prev(View view) {
        stackView.showPrevious();
    }

    public void next(View view) {
        stackView.showNext();
    }
}
