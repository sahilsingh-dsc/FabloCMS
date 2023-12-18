package com.myfablo.cms.module_menu_sync.contract_get_sub_category;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_menu_sync.models.sub_category.get.MenuSubCategoryResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetSubCategoryContract {

    private Context context;
    private GetSubCategoryInterface getSubCategoryInterface;
    private MenuInterface menuInterface;

    public GetSubCategoryContract(Context context, GetSubCategoryInterface getSubCategoryInterface) {
        this.context = context;
        this.getSubCategoryInterface = getSubCategoryInterface;
        menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);
    }

    public void getSubCategory(String categoryId) {
        getSubCategoryInterface.onContractProgress();
        AuthPref authPref = new AuthPref(context);
        Call<MenuSubCategoryResponse> call = menuInterface.getSubCategory(authPref.getBearerToken(), categoryId);
        call.enqueue(new Callback<MenuSubCategoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<MenuSubCategoryResponse> call, @NonNull Response<MenuSubCategoryResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            getSubCategoryInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            getSubCategoryInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    getSubCategoryInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MenuSubCategoryResponse> call, @NonNull Throwable t) {
                getSubCategoryInterface.onContractFailure();
            }
        });
    }

}
