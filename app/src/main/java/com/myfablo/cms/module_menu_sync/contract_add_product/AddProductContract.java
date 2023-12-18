package com.myfablo.cms.module_menu_sync.contract_add_product;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_menu_sync.models.product.add.AddProductRequest;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.common_req_res.BasicResponse;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddProductContract {

    private Context context;
    private AddProductInterface addProductInterface;
    private MenuInterface menuInterface;

    public AddProductContract(Context context, AddProductInterface addProductInterface) {
        this.context = context;
        this.addProductInterface = addProductInterface;
        menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);
    }

    public void addProduct(AddProductRequest addProductRequest) {
        addProductInterface.onContractProgress();
        AuthPref authPref = new AuthPref(context);
        Call<BasicResponse> call = menuInterface.addProduct(authPref.getBearerToken(), addProductRequest);
        call.enqueue(new Callback<BasicResponse>() {
            @Override
            public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() ==  Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            addProductInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            addProductInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    addProductInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                addProductInterface.onContractFailure();
            }
        });
    }

}
