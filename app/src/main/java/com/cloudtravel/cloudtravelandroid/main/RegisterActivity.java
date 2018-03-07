package com.cloudtravel.cloudtravelandroid.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;

public class RegisterActivity extends AppCompatActivity {
    private EditText et_postbox;
    private EditText et_name;
    private EditText et_password;
    private EditText et_confirming;
    private Button m_register;
    private TextView tv_existing;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }
    private void initView(){
        et_postbox=(EditText)findViewById(R.id.et_postbox);
        et_name=(EditText)findViewById(R.id.et_name);
        et_password=(EditText)findViewById(R.id.et_password);
        et_confirming=(EditText)findViewById(R.id.et_comfirming);
        m_register=(Button)findViewById(R.id.m_register);
        tv_existing=(TextView)findViewById(R.id.tv_existing);
    }
}
