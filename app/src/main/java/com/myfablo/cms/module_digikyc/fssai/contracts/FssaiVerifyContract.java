package com.myfablo.cms.module_digikyc.fssai.contracts;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_digikyc.fssai.models.response.FssaiVerifyResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.VerifyInterface;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FssaiVerifyContract {

    private Context context;
    private FssaiVerifyInterface fssaiVerifyInterface;
    private VerifyInterface verifyInterface;

    public FssaiVerifyContract(Context context, FssaiVerifyInterface fssaiVerifyInterface) {
        this.context = context;
        this.fssaiVerifyInterface = fssaiVerifyInterface;
        verifyInterface = RestClient.getRetrofitDigiKycService(context).create(VerifyInterface.class);
    }

    public void verifyFssai(String fssai) {
        fssaiVerifyInterface.onContractProgress();
        Call<FssaiVerifyResponse> call = verifyInterface.verifyFssai(fssai);
        call.enqueue(new Callback<FssaiVerifyResponse>() {
            @Override
            public void onResponse(@NonNull Call<FssaiVerifyResponse> call, @NonNull Response<FssaiVerifyResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            fssaiVerifyInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            fssaiVerifyInterface.onContractNotFound();
                        }
                    }
                } else {
                    fssaiVerifyInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<FssaiVerifyResponse> call, @NonNull Throwable t) {
                fssaiVerifyInterface.onContractFailure();
            }
        });
    }

}
