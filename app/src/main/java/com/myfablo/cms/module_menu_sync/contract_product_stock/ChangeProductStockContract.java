package com.myfablo.cms.module_menu_sync.contract_product_stock;

import android.content.Context;

import androidx.annotation.NonNull;

import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.common_req_res.BasicResponse;
import com.myfablo.cms.utils.interfaces.MenuInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChangeProductStockContract {

    private Context context;
    private ChangeProductStockInterface changeProductStockInterface;
    private MenuInterface menuInterface;

    public ChangeProductStockContract(Context context, ChangeProductStockInterface changeProductStockInterface) {
        this.context = context;
        this.changeProductStockInterface = changeProductStockInterface;
        menuInterface = RestClient.getRetrofitFabloInventoryService(context).create(MenuInterface.class);
    }

    public void changeProductStock(String productId) {
        changeProductStockInterface.onContractProgress();
        AuthPref authPref = new AuthPref(context);
        Call<BasicResponse> call = menuInterface.changeProductStock(authPref.getBearerToken(), productId);
        call.enqueue(new Callback<BasicResponse>() {
            @Override
            public void onResponse(@NonNull Call<BasicResponse> call, @NonNull Response<BasicResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            changeProductStockInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            changeProductStockInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    changeProductStockInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<BasicResponse> call, @NonNull Throwable t) {
                changeProductStockInterface.onContractFailure();
            }
        });
    }

}
