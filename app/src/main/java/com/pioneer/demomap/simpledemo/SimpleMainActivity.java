package com.pioneer.demomap.simpledemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.pioneer.demomap.R;
import com.pioneer.demomap.simpledemo.vertical.RecyclerVerActivity;

public class SimpleMainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnVer;
    private Button btnHor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_simple);
        btnVer = (Button) findViewById(R.id.btn_main_ver);
        btnHor = (Button) findViewById(R.id.btn_main_hor);

        btnVer.setOnClickListener(this);
        btnHor.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main_ver:
                startActivity(new Intent(SimpleMainActivity.this, RecyclerVerActivity.class));
                break;
            case R.id.btn_main_hor:

                break;
        }
    }

}
