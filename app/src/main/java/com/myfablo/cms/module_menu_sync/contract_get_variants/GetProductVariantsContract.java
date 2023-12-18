package com.myfablo.cms.module_menu_sync.contract_get_variants;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_menu_sync.models.variants.ProductVariantResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetProductVariantsContract {

    private Context context;
    private GetProductVariantsInterface getProductVariantsInterface;
    private MenuInterface menuInterface;

    public GetProductVariantsContract(Context context, GetProductVariantsInterface getProductVariantsInterface) {
        this.context = context;
        this.getProductVariantsInterface = getProductVariantsInterface;
        menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);
    }

    public void getProductVariants(String productId) {
        AuthPref authPref = new AuthPref(context);
        Call<ProductVariantResponse> call = menuInterface.getProductVariant(authPref.getBearerToken(), productId);
        call.enqueue(new Callback<ProductVariantResponse>() {
            @Override
            public void onResponse(@NonNull Call<ProductVariantResponse> call, @NonNull Response<ProductVariantResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            getProductVariantsInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            getProductVariantsInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    getProductVariantsInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<ProductVariantResponse> call, @NonNull Throwable t) {
                getProductVariantsInterface.onContractFailure();
            }
        });
    }

}
