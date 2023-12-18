package com.myfablo.cms.module_outlet.contracts.contract_get_all_outlets;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_outlet.models.OutletResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.OutletInterface;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetAllOutletContract {

    private Context context;
    private GetAllOutletInterface getAllOutletInterface;
    private OutletInterface outletInterface;

    private static final String TAG = "GetAllOutletContract";

    public GetAllOutletContract(Context context, GetAllOutletInterface getAllOutletInterface) {
        this.context = context;
        this.getAllOutletInterface = getAllOutletInterface;
        outletInterface = RestClient.getRetrofitFabloInventoryService(context).create(OutletInterface.class);
    }

    public void getAllOutlets() {
        getAllOutletInterface.onContractProgress();
        Call<OutletResponse> call = outletInterface.getAllOutlets();
        call.enqueue(new Callback<OutletResponse>() {
            @Override
            public void onResponse(@NonNull Call<OutletResponse> call, @NonNull Response<OutletResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            getAllOutletInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            getAllOutletInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    getAllOutletInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<OutletResponse> call, @NonNull Throwable t) {
                getAllOutletInterface.onContractFailure();
                Log.e(TAG, "onFailure: "+t.getMessage());
            }
        });
    }

}
