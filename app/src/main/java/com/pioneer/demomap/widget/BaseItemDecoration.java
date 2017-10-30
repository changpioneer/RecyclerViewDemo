package com.pioneer.demomap.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

/**
 * Created by pioneerchang on 2017/10/28.
 */

public abstract class BaseItemDecoration extends RecyclerView.ItemDecoration {

    public int mGroupHeight;
    public int mDivideHeight;

    public BaseItemDecoration() {
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        int position = parent.getChildAdapterPosition(view);

        String groupName = getGroupName(position);
        if (groupName == null)return;
        if (isFirstInGroup(position)) {
            outRect.top = mGroupHeight;
        } else {
            outRect.top = mDivideHeight;
        }
    }

    //判断是不是组中的第一个位置
    //根据前一个组名，判断当前是否为新的组
    private boolean isFirstInGroup(int pos) {
        if (pos == 0) {
            return true;
        } else {
            String prevGroupId = getGroupName(pos - 1);
            String groupId = getGroupName(pos);
            return !TextUtils.equals(prevGroupId, groupId);
        }
    }


    abstract String getGroupName(int position);


}
