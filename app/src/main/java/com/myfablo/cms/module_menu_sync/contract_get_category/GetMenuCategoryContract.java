package com.myfablo.cms.module_menu_sync.contract_get_category;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_menu_sync.models.category.get.MenuCategoryResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMenuCategoryContract {

    private Context context;
    private GetMenuCategoryInterface getMenuCategoryInterface;
    private MenuInterface menuInterface;

    public GetMenuCategoryContract(Context context, GetMenuCategoryInterface getMenuCategoryInterface) {
        this.context = context;
        this.getMenuCategoryInterface = getMenuCategoryInterface;
        menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);
    }

    public void getMenuCategory(String outletId) {
        getMenuCategoryInterface.onContractProgress();
        AuthPref authPref = new AuthPref(context);
        Call<MenuCategoryResponse> call = menuInterface.getCategory(authPref.getBearerToken(), outletId, "customer");
        call.enqueue(new Callback<MenuCategoryResponse>() {
            @Override
            public void onResponse(@NonNull Call<MenuCategoryResponse> call, @NonNull Response<MenuCategoryResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            getMenuCategoryInterface.onContractResponse(response.body().getItems());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            getMenuCategoryInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    getMenuCategoryInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MenuCategoryResponse> call, @NonNull Throwable t) {
                getMenuCategoryInterface.onContractFailure();
            }
        });
    }

}
