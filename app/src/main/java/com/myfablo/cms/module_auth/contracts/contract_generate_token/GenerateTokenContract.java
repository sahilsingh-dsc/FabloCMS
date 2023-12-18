package com.myfablo.cms.module_auth.contracts.contract_generate_token;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_auth.models.auth.request.AuthRequest;
import com.myfablo.cms.module_auth.models.auth.response.AuthResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.AuthInterface;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenerateTokenContract {

    private Context context;
    private GenerateTokenInterface generateTokenInterface;
    private AuthInterface authInterface;

    public GenerateTokenContract(Context context, GenerateTokenInterface generateTokenInterface) {
        this.context = context;
        this.generateTokenInterface = generateTokenInterface;
        authInterface = RestClient.getRetrofitFabloAdminService(context).create(AuthInterface.class);
    }

    public void generateToken(AuthRequest authRequest) {
        generateTokenInterface.onContractProgress();
        Call<AuthResponse> call = authInterface.generateLoginToken(authRequest);
        call.enqueue(new Callback<AuthResponse>() {
            @Override
            public void onResponse(@NonNull Call<AuthResponse> call, @NonNull Response<AuthResponse> response) {
                if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    generateTokenInterface.onContractFailure();
                    return;
                }

                if (response.body() == null) {
                    generateTokenInterface.onContractFailure();
                    return;
                }

                if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                    generateTokenInterface.onContractNotFound();
                    return;
                }

                generateTokenInterface.onContractResponse(response.body());

            }

            @Override
            public void onFailure(@NonNull Call<AuthResponse> call, @NonNull Throwable t) {
                generateTokenInterface.onContractFailure();
            }
        });
    }

}
