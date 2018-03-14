package com.cloudtravel.cloudtravelandroid.main.api;

import com.cloudtravel.cloudtravelandroid.base.CloudTravelBaseResponse;
import com.cloudtravel.cloudtravelandroid.main.request.UserLoginRequest;
import com.lemon.support.request.SimpleCall;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {
    @POST("user/login")
    SimpleCall<CloudTravelBaseResponse> doLogin(@Body UserLoginRequest request);
}
