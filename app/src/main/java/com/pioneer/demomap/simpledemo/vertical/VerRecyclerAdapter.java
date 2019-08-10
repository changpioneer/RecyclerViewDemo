package com.pioneer.demomap.simpledemo.vertical;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pioneer.demomap.R;

import java.util.List;

public class VerRecyclerAdapter extends RecyclerView.Adapter<VerRecyclerAdapter.MyHolder> implements View.OnClickListener, View.OnLongClickListener {

    private List<String> mList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    public VerRecyclerAdapter(Context context, List<String> list) {
        mList = list;
        this.context = context;
    }

    public void removeData(int position) {
        mList.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_ver_recyc, viewGroup, false);
        MyHolder holder = new MyHolder(view);

        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.tv.setText(mList.get(i));
        myHolder.itemView.setTag(i);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public void onClick(View view) {
        //单击事件
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, (int) view.getTag());
        }
    }

    @Override
    public boolean onLongClick(View view) {
        //长按事件
        if (onItemClickListener != null) {
            onItemClickListener.onItemLongClisck(view, (int) view.getTag());
        }
        return false;
    }

    class MyHolder extends RecyclerView.ViewHolder {

        private TextView tv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_item_content);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClisck(View view, int position);
    }
}
