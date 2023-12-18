package com.myfablo.cms.utils.interfaces;

import com.myfablo.cms.module_auth.models.auth.request.AuthRequest;
import com.myfablo.cms.module_auth.models.auth.response.AuthResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface AuthInterface {

    @POST("auth/login")
    Call<AuthResponse>
    generateLoginToken(@Body AuthRequest authRequest);

}
