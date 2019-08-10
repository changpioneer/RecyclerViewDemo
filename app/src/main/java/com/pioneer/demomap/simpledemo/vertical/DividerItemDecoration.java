package com.pioneer.demomap.simpledemo.vertical;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerItemDecoration extends RecyclerView.ItemDecoration {


    private static final int[] ATTRS = new int[]{android.R.attr.listDivider};
    private Drawable mDivider;
    private int mOrientation;
    private Context context;

    public DividerItemDecoration(Context context, int orientation){
        this.context = context;
        final TypedArray typedArray = context.obtainStyledAttributes(ATTRS);
        mDivider = typedArray.getDrawable(0);
        typedArray.recycle();

//        mDivider = new ColorDrawable(context.getResources().getColor(R.color.colorAccent));
        setOrientation(orientation);
    }

    public void setOrientation(int orientation){
        if (orientation != LinearLayoutManager.HORIZONTAL && orientation != LinearLayoutManager.VERTICAL) {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    /**
     * onDraw可以通过一系列c.drawXXX()方法在绘制itemView之前绘制我们需要的内容。
     * onDrawOver与onDraw类似，只不过是在绘制itemView之后绘制，具体表现形式，就是绘制的内容在itemview上层。
     */
    @Override
    public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDraw(c, parent, state);
//        if(mOrientation == LinearLayoutManager.VERTICAL){
//            drawVertical(c, parent);
//        }else{
//
//        }
    } 

    @Override
    public void onDrawOver(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
        if(mOrientation == LinearLayoutManager.VERTICAL){
            drawVertical(c, parent);
        }else{

        }
    }

    public void drawVertical(@NonNull Canvas c, @NonNull RecyclerView parent){
        final int left = parent.getPaddingLeft();
        final int right = parent.getWidth() - parent.getPaddingRight();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int top = child.getBottom()+params.bottomMargin;
            final int bottom = top+mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    /**
     * getItemOffests可以通过outRect.set(l,t,r,b)设置指定itemview的paddingLeft，paddingTop， paddingRight， paddingBottom
     */
    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        if(mOrientation == LinearLayoutManager.VERTICAL){
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        }else{
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }

//        outRect.set(0, 100, 0, 0);
    }
}
