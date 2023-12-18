package com.myfablo.cms.module_menu_sync.contract_add_category;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_menu_sync.models.category.add.AddCategoryRequest;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.common_req_res.BasicResponse;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddCategoryContract {

    private Context context;
    private AddCategoryInterface addCategoryInterface;
    private MenuInterface menuInterface;

    public AddCategoryContract(Context context, AddCategoryInterface addCategoryInterface) {
        this.context = context;
        this.addCategoryInterface = addCategoryInterface;
        menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);
    }

    public void addCategory(AddCategoryRequest request) {
        AuthPref authPref = new AuthPref(context);
        addCategoryInterface.onContractProgress();
        Call<BasicResponse> call = menuInterface.addProductCategory(authPref.getBearerToken(), request);
        call.enqueue(new Callback<BasicResponse>() {
            
            @Override
            public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            addCategoryInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            addCategoryInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    addCategoryInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                addCategoryInterface.onContractFailure();
            }
        });
    }
}
