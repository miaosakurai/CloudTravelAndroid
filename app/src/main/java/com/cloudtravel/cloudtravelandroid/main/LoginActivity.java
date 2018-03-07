package com.cloudtravel.cloudtravelandroid.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;

public class LoginActivity extends AppCompatActivity {
    private EditText ed_postbox;
    private EditText ed_password;
    private TextView tv_forgetting;
    private Button m_login;
    private Button m_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }
    private void initView(){
        ed_postbox=(EditText)findViewById(R.id.ed_postbox);
        ed_password=(EditText)findViewById(R.id.et_password);
        tv_forgetting=(TextView)findViewById(R.id.tv_forgetting);
        m_login=(Button)findViewById(R.id.m_login);
        m_register=(Button)findViewById(R.id.m_register);
    }

}
