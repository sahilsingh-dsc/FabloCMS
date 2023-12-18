package com.myfablo.cms.module_menu_sync.contract_get_addons;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_menu_sync.models.addons.product.ProductAddonsResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetProductAddonsContract {

    private Context context;
    private GetProductAddonsInterface getProductAddonsInterface;
    private MenuInterface menuInterface;

    public GetProductAddonsContract(Context context, GetProductAddonsInterface getProductAddonsInterface) {
        this.context = context;
        this.getProductAddonsInterface = getProductAddonsInterface;
        menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);
    }

    public void getProductAddons(String productId) {
        getProductAddonsInterface.onContractProgress();
        AuthPref authPref = new AuthPref(context);
        Call<ProductAddonsResponse> call = menuInterface.getProductAddons(authPref.getBearerToken(), productId);
        call.enqueue(new Callback<ProductAddonsResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProductAddonsResponse> call, @NonNull Response<ProductAddonsResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            getProductAddonsInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            getProductAddonsInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    getProductAddonsInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ProductAddonsResponse> call, @NonNull Throwable t) {
                getProductAddonsInterface.onContractFailure();
            }
        });
    }

}
