package com.cloudtravel.cloudtravelandroid.main;

import android.os.Bundle;
import android.widget.TextView;
import com.cloudtravel.cloudtravelandroid.R;
import com.cloudtravel.cloudtravelandroid.base.CloudTravelBaseActivity;
import com.cloudtravel.cloudtravelandroid.base.CloudTravelBaseCallBack;
import com.cloudtravel.cloudtravelandroid.main.api.UserInfoApi;
import com.cloudtravel.cloudtravelandroid.main.dto.User;
import com.cloudtravel.cloudtravelandroid.main.util.GsonUtil;

public class TestActivity extends CloudTravelBaseActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
    }

    private void initView() {
        textView = findViewById(R.id.test_text);
        addRequest(getService(UserInfoApi.class).doGetUserInfo(), new CloudTravelBaseCallBack() {
            @Override
            public void onSuccess200(Object o) {
                User user = GsonUtil.getEntity(o, new com.google.common.reflect.TypeToken<User>() {
                }.getType());
                textView.setText(user.getUserName());
            }
        });
    }

}
