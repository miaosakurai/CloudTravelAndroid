package com.cloudtravel.cloudtravelandroid.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cloudtravel.cloudtravelandroid.R;
import com.cloudtravel.cloudtravelandroid.base.CloudTravelBaseActivity;
import com.cloudtravel.cloudtravelandroid.base.CloudTravelBaseCallBack;
import com.cloudtravel.cloudtravelandroid.main.api.LoginApi;
import com.cloudtravel.cloudtravelandroid.main.request.UserLoginRequest;


public class SignInActivity extends CloudTravelBaseActivity {

    private TextView signUpTextView;
    private Button signInButton;
    private EditText emailEditText;
    private EditText passwordEditText;
    private RelativeLayout signInLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initView();
    }

    private void initView() {
        signInLayout=findViewById(R.id.sign_in_layout);
        /*Glide.with(this).load(R.drawable.sign_in_background)
                .into(new ViewTarget<View, GlideDrawable>(signInLayout) {
                    @Override
                    public void onResourceReady(GlideDrawable resource,
                                                GlideAnimation<? super GlideDrawable> glideAnimation) {
                        this.view.setBackground(resource.getCurrent());
                    }
                });*/
        signUpTextView=findViewById(R.id.sign_up_text_view);
        signInButton=findViewById(R.id.sign_in_button);
        emailEditText=findViewById(R.id.email_edit_text);
        passwordEditText=findViewById(R.id.password_edit_text);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UserLoginRequest request = new UserLoginRequest();
                request.setAccountNumber(emailEditText.getText().toString());
                request.setUserPassword(passwordEditText.getText().toString());
                addRequest(getService(LoginApi.class).doLogin(request), new CloudTravelBaseCallBack() {
                    @Override
                    public void onSuccess200(Object o) {
                        makeToast("登录成功");
                        Intent intent = new Intent(SignInActivity.this, TestActivity.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }
        });
        signUpTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        signInLayout.getBackground().setAlpha(255);
    }
}
