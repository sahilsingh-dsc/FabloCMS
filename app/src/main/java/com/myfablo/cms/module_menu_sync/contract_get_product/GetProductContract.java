package com.myfablo.cms.module_menu_sync.contract_get_product;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_menu_sync.models.product.MenuProductResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetProductContract {

    private Context context;
    private GetProductInterface getProductInterface;
    private MenuInterface menuInterface;

    public GetProductContract(Context context, GetProductInterface getProductInterface) {
        this.context = context;
        this.getProductInterface = getProductInterface;
        menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);
    }

    public void getProduct(String categoryId) {
        getProductInterface.onContractProgress();
        AuthPref authPref = new AuthPref(context);
        Call<MenuProductResponse> call = menuInterface.getProduct(authPref.getBearerToken(), categoryId);
        call.enqueue(new Callback<MenuProductResponse>() {
            @Override
            public void onResponse(@NonNull Call<MenuProductResponse> call, @NonNull Response<MenuProductResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            getProductInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            getProductInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    getProductInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MenuProductResponse> call, @NonNull Throwable t) {
                getProductInterface.onContractFailure();
            }
        });
    }

}
