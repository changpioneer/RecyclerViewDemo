package com.pioneer.demomap.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.pioneer.demomap.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_recycler, R.id.btn_recycler1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_recycler:
                startActivity(new Intent(MainActivity.this, StickRecyclerViewActivity.class));
                break;
            case R.id.btn_recycler1:
                startActivity(new Intent(MainActivity.this, PowerfulStickRecyclerViewActivity.class));
                break;
        }
    }
}
