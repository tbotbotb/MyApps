package com.example.administrator.app199_mybutton;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;

/**
 * Created by Administrator on 2017/8/20.
 */

public class MyButton extends android.support.v7.widget.AppCompatButton
{
    public MyButton(Context context, AttributeSet set)
    {
        super(context, set);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        super.onKeyDown(keyCode, event);
        Log.v("-crazyit.org-", "the onKeyDown in MyButton");
        // 返回true，表明该事件不会向外扩散
        return true;
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        //super.setOnClickListener(l);
        System.out.println("xxxxxxx");
    }
}
