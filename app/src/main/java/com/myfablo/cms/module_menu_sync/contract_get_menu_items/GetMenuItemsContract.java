package com.myfablo.cms.module_menu_sync.contract_get_menu_items;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_menu_sync.models.menu_items.MenuItemsResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetMenuItemsContract {

    private Context context;
    private GetMenuItemsInterface getMenuItemsInterface;
    private MenuInterface menuInterface;

    public GetMenuItemsContract(Context context, GetMenuItemsInterface getMenuItemsInterface) {
        this.context = context;
        this.getMenuItemsInterface = getMenuItemsInterface;
        menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);
    }

    public void getMenuItems(String categoryId) {
        getMenuItemsInterface.onContractProgress();
        AuthPref authPref = new AuthPref(context);
        Call<MenuItemsResponse> call = menuInterface.getMenuItemsFull(authPref.getBearerToken(), categoryId);
        call.enqueue(new Callback<MenuItemsResponse>() {
            @Override
            public void onResponse(@NonNull Call<MenuItemsResponse> call, @NonNull Response<MenuItemsResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            getMenuItemsInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            getMenuItemsInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    getMenuItemsInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<MenuItemsResponse> call, @NonNull Throwable t) {
                getMenuItemsInterface.onContractFailure();
            }
        });
    }

}
