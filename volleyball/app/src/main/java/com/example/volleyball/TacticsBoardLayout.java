package com.example.volleyball;
 
import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * 自定义view
 */

public class TacticsBoardLayout extends RelativeLayout
{
    private ViewDragHelper mDragger;
 
    protected void onFinshInflate(){
        super.onFinishInflate();
    }
    public TacticsBoardLayout(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        mDragger = ViewDragHelper.create(this, 1.0f, new ViewDragHelper.Callback()
        {
            /* 进行拦截，哪些view可以进行drag操作
            ** return true 代表拦截所有view
             */
            @Override
            public boolean tryCaptureView(View child, int pointerId)
            {
 
                return true;
            }
            //水平滑动，控制left
            @Override
            public int clampViewPositionHorizontal(View child, int left, int dx)
            {
                return left;
            }
            //垂直滑动，控制top
            @Override
            public int clampViewPositionVertical(View child, int top, int dy)
            {
                return top;
            }
        });
    }
  // 事件分发
   @Override
    public boolean onInterceptTouchEvent(MotionEvent event)
    {
        return mDragger.shouldInterceptTouchEvent(event);
    }
 
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        mDragger.processTouchEvent(event);
        return true;
    }
 
}