package com.pioneer.demomap.simpledemo.gridview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pioneer.demomap.R;

import java.util.List;

public class GridviewRecyclerAdapter extends RecyclerView.Adapter<GridviewRecyclerAdapter.GridViewHold> {

    private List<String> mList;
    private Context context;

    public GridviewRecyclerAdapter(Context context, List<String> list){
        this.context = context;
        mList = list;
    }

    @Override
    public GridViewHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_grid_recyc, parent, false);
        GridViewHold hold = new GridViewHold(view);
        return hold;
    }

    @Override
    public void onBindViewHolder(GridViewHold holder, int position) {
        holder.tv.setText(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class GridViewHold extends RecyclerView.ViewHolder{

        private TextView tv;
        public GridViewHold(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_item_grid);
        }
    }
}
