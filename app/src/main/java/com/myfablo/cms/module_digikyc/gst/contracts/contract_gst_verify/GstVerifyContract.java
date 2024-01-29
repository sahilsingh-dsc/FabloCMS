package com.myfablo.cms.module_digikyc.gst.contracts.contract_gst_verify;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_digikyc.gst.models.response.GstVerifyResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.VerifyInterface;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GstVerifyContract {

    private Context context;
    private GstVerifyInterface gstVerifyInterface;
    private VerifyInterface verifyInterface;

    public GstVerifyContract(Context context, GstVerifyInterface gstVerifyInterface) {
        this.context = context;
        this.gstVerifyInterface = gstVerifyInterface;
        verifyInterface = RestClient.getRetrofitDigiKycService(context).create(VerifyInterface.class);
    }

    public void verifyGst(String gst) {
        gstVerifyInterface.onContractProgress();
        Call<GstVerifyResponse> call = verifyInterface.verifyGst(gst);
        call.enqueue(new Callback<GstVerifyResponse>() {
            @Override
            public void onResponse(@NonNull Call<GstVerifyResponse> call, @NonNull Response<GstVerifyResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            gstVerifyInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            gstVerifyInterface.onContractNotFound();
                        }
                    }
                } else {
                    gstVerifyInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<GstVerifyResponse> call, @NonNull Throwable t) {
                gstVerifyInterface.onContractFailure();
            }
        });
    }

}
