package com.myfablo.cms.module_digikyc.pan.contracts.contract_pan_verfiy;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_digikyc.pan.models.response.PanVerifyResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.VerifyInterface;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PanVerifyContract {

    private Context context;
    private PanVerifyInterface panVerifyInterface;
    private VerifyInterface verifyInterface;

    public PanVerifyContract(Context context, PanVerifyInterface panVerifyInterface) {
        this.context = context;
        this.panVerifyInterface = panVerifyInterface;
        verifyInterface = RestClient.getRetrofitDigiKycService(context).create(VerifyInterface.class);
    }

    public void verifyPan(String pan) {
        panVerifyInterface.onContractProgress();
        Call<PanVerifyResponse> call = verifyInterface.verifyPan(pan);
        call.enqueue(new Callback<PanVerifyResponse>() {
            @Override
            public void onResponse(@NonNull Call<PanVerifyResponse> call, @NonNull Response<PanVerifyResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            panVerifyInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            panVerifyInterface.onContractNotFound();
                        }
                    } else {
                        panVerifyInterface.onContractFailure();
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    panVerifyInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<PanVerifyResponse> call, @NonNull Throwable t) {
                panVerifyInterface.onContractFailure();
            }
        });
    }

}
