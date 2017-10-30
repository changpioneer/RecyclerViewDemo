package com.pioneer.demomap.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.pioneer.demomap.R;
import com.pioneer.demomap.adapter.RecyclerViewAdapter;
import com.pioneer.demomap.listener.PowerGroupListener;
import com.pioneer.demomap.module.City;
import com.pioneer.demomap.utils.CityUtil;
import com.pioneer.demomap.utils.DensityUtil;
import com.pioneer.demomap.widget.PowerfulStickyDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pioneerchang on 2017/10/29.
 */

public class PowerfulStickRecyclerViewActivity extends AppCompatActivity implements PowerGroupListener{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    List<City> cityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);
        cityList.addAll(CityUtil.getCityList());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(cityList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        PowerfulStickyDecoration decoration = PowerfulStickyDecoration.Builder
                .init(this)
                .setGroupHeight(DensityUtil.dip2px(this, 40))       //设置高度
                .isAlignLeft(true)                                 //靠右边显示   默认左边
                .setGroupBackground(Color.parseColor("#48BDFF"))    //设置背景   默认透明
                .setDivideColor(Color.parseColor("#CCCCCC"))        //分割线颜色
                .setDivideHeight(DensityUtil.dip2px(this, 1))       //分割线高度
                .build();

        recyclerView.addItemDecoration(decoration);
    }

    @Override
    public String getGroupName(int position) {
        //获取组名，用于判断是否是同一组
        if (cityList.size() > position) {
            return cityList.get(position).getProvince();
        }
        return null;
    }

    @Override
    public View getGroupView(int position) {
        if (cityList.size() > position) {
            View view = getLayoutInflater().inflate(R.layout.item_group, null, false);
            ((TextView) view.findViewById(R.id.tv)).setText(cityList.get(position).getProvince());
            return view;
        } else {
            return null;
        }
    }
}
