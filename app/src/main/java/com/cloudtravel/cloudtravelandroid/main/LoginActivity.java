package com.cloudtravel.cloudtravelandroid.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;

public class LoginActivity extends AppCompatActivity {
    private EditText ed_postbox;
    private EditText ed_password;
    private TextView tv_forgetting;
    private Button bt_login;
    private Button bt_register;

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
        bt_login=(Button)findViewById(R.id.m_login);
        bt_register=(Button)findViewById(R.id.m_register);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        bt_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

}
