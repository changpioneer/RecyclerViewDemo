package com.pioneer.demomap.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pioneer.demomap.R;
import com.pioneer.demomap.adapter.RecyclerViewAdapter;
import com.pioneer.demomap.listener.GroupListener;
import com.pioneer.demomap.module.City;
import com.pioneer.demomap.utils.CityUtil;
import com.pioneer.demomap.utils.DensityUtil;
import com.pioneer.demomap.widget.StickItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by pioneerchang on 2017/10/25.
 */

public class StickRecyclerViewActivity extends AppCompatActivity implements GroupListener{

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    List<City> cityList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        ButterKnife.bind(this);

//        cityList = CityUtil.getCityList();
        cityList.addAll(CityUtil.getCityList());
        cityList.addAll(CityUtil.getCityList());

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(cityList);
        recyclerView.setLayoutManager(layoutManager);

        StickItemDecoration decoration = StickItemDecoration.Builder.init(this)
                .setGroupBackground(Color.parseColor("#48BDFF"))    //背景色
                .setGroupHeight(DensityUtil.dip2px(this, 35))       //高度
                .setDivideColor(Color.parseColor("#CCCCCC"))        //分割线颜色
                .setDivideHeight(DensityUtil.dip2px(this, 1))       //分割线高度 (默认没有分割线)
                .setGroupTextColor(Color.BLACK)                     //字体颜色
                .setGroupTextSize(DensityUtil.sp2px(this, 15))      //字体大小
                .setTextSideMargin(DensityUtil.dip2px(this, 10))    // 边距   靠左时为左边距  靠右时为右边距
                .isAlignLeft(true)                                 //靠右显示  （默认靠左）
                .build();
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public String getGroupName(int position) {
        //组名回调
        if (cityList.size() > position) {
            //获取城市对应的省份
            return cityList.get(position).getProvince();
        }
        return null;
    }
}
