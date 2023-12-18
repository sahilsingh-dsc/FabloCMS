package com.myfablo.cms.module_menu_sync.contract_add_sub_category;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_menu_sync.models.sub_category.add.AddSubCategoryRequest;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.common_req_res.BasicResponse;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddSubCategoryContract {

    private Context context;
    private AddSubCategoryInterface addSubCategoryInterface;
    private MenuInterface menuInterface;

    public AddSubCategoryContract(Context context, AddSubCategoryInterface addSubCategoryInterface) {
        this.context = context;
        this.addSubCategoryInterface = addSubCategoryInterface;
        menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);
    }

    public void addCategory(AddSubCategoryRequest request) {
        AuthPref authPref = new AuthPref(context);
        addSubCategoryInterface.onContractProgress();
        Call<BasicResponse> call = menuInterface.addProductSubCategoryCategory(authPref.getBearerToken(), request);
        call.enqueue(new Callback<BasicResponse>() {
            
            @Override
            public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            addSubCategoryInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            addSubCategoryInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    addSubCategoryInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                addSubCategoryInterface.onContractFailure();
            }
        });
    }
}
