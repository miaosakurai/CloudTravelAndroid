package com.cloudtravel.cloudtravelandroid.main.request;

import com.cloudtravel.cloudtravelandroid.base.CloudTravelBaseRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserLoginRequest extends CloudTravelBaseRequest{
    private String accountNumber;
    private String userPassword;
}
