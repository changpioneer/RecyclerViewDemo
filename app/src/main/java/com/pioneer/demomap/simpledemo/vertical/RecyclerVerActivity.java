package com.pioneer.demomap.simpledemo.vertical;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.pioneer.demomap.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 垂直方向的列表
 */
public class RecyclerVerActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> list;
    private VerRecyclerAdapter verRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_ver);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_ver);
        initData();
        initRecyclerView();
        setClickListener();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "");
        }
    }

    private void initRecyclerView() {

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));

        verRecyclerAdapter = new VerRecyclerAdapter(this, list);
        mRecyclerView.setAdapter(verRecyclerAdapter);
    }

    private void setClickListener() {
        verRecyclerAdapter.setOnItemClickListener(new VerRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(RecyclerVerActivity.this, "position=" + position + ", value=" + list.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClisck(View view, int position) {
                showDeleteDialog(view, position);
            }
        });
    }

    private void showDeleteDialog(View view, final int position) {
        new AlertDialog.Builder(this)
                .setTitle("确认删除吗?")
                .setNegativeButton("取消", null)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        verRecyclerAdapter.removeData(position);
                    }
                })
                .show();
    }
}
