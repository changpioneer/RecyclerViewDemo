package com.pioneer.demomap.simpledemo.gridview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pioneer.demomap.R;

import java.util.ArrayList;
import java.util.List;

public class GrideViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> list;
//    private VerRecyclerAdapter adapter;
    private GridviewRecyclerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_ver);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_ver);
        initData();
        initRecyclerView();
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i + "");
        }
    }

    private void initRecyclerView() {

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 4));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.HORIZONTAL));

//        verRecyclerAdapter = new VerRecyclerAdapter(this, list);

        adapter = new GridviewRecyclerAdapter(this, list);
        mRecyclerView.setAdapter(adapter);
    }
}
