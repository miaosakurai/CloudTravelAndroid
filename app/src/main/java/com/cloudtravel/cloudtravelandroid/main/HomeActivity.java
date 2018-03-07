package com.cloudtravel.cloudtravelandroid.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;

public class HomeActivity extends AppCompatActivity {
    private TextView tv_collection;
    private TextView tv_information;
    private TextView tv_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    private void initView(){
        tv_collection=(TextView)findViewById(R.id.tv_collection);
        tv_information=(TextView)findViewById(R.id.tv_information);
        tv_setting=(TextView)findViewById(R.id.tv_setting);

    }
}
