package com.bms.central_api_v1.integration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class AuthAPI extends RestAPI {

    @Value("${auth.api.base}")
    String baseUrl;

    public Object callGenerateTokenEndpoint(String userId, String password){
        String endPoint = "/token";
        HashMap queryParams = new HashMap();
        queryParams.put("userId", userId);
        queryParams.put("password", password);
        Object responseBody  = this.makeGetCall(baseUrl, endPoint, queryParams);
        return responseBody;
    }


}
