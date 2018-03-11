package com.cloudtravel.cloudtravelandroid.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
<<<<<<< HEAD
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;
=======
import android.widget.TextView;

>>>>>>> b253ff74f8188b6207f7dd6ec2b993f0d8a455b9
import com.cloudtravel.cloudtravelandroid.R;

public class SignInActivity extends AppCompatActivity {

    private TextView signUpTextView;
    private Button signInButton;
    private EditText emailEditText;
    private EditText passwordEditText;
<<<<<<< HEAD
    private RelativeLayout signInLayout;
=======
>>>>>>> b253ff74f8188b6207f7dd6ec2b993f0d8a455b9

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        initView();
    }

    private void initView() {
<<<<<<< HEAD
        signInLayout=findViewById(R.id.sign_in_layout);
        /*Glide.with(this).load(R.drawable.sign_in_background)
                .into(new ViewTarget<View, GlideDrawable>(signInLayout) {
                    @Override
                    public void onResourceReady(GlideDrawable resource,
                                                GlideAnimation<? super GlideDrawable> glideAnimation) {
                        this.view.setBackground(resource.getCurrent());
                    }
                });*/
=======
>>>>>>> b253ff74f8188b6207f7dd6ec2b993f0d8a455b9
        signUpTextView=findViewById(R.id.sign_up_text_view);
        signInButton=findViewById(R.id.sign_in_button);
        emailEditText=findViewById(R.id.email_edit_text);
        passwordEditText=findViewById(R.id.password_edit_text);
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignInActivity.this,MainActivity.class);
                startActivity(intent);
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
<<<<<<< HEAD
        signInLayout.getBackground().setAlpha(255);
=======
        View view=findViewById(R.id.login_layout);
        view.getBackground().setAlpha(255);
>>>>>>> b253ff74f8188b6207f7dd6ec2b993f0d8a455b9
    }
}
