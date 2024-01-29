package com.myfablo.cms.module_order.feature_get_order.contracts;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.myfablo.cms.module_order.feature_get_order.models.response.OrderResponse;
import com.myfablo.cms.utils.Constant;
import com.myfablo.cms.utils.interfaces.OrderInterface;
import com.myfablo.cms.utils.prefs.AuthPref;
import com.myfablo.cms.utils.retrofit.RestClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GetOrderContract {

    private Context context;
    private GetOrderInterface getOrderInterface;
    private OrderInterface ordersInterface;

    public GetOrderContract(Context context, GetOrderInterface getOrderInterface) {
        this.context = context;
        this.getOrderInterface = getOrderInterface;
        ordersInterface = RestClient.getRetrofitFabloAdminService(context).create(OrderInterface.class);
    }

    public void getOrders(String orderStatus) {
        getOrderInterface.onContractProgress();
        AuthPref authPref = new AuthPref(context);
        Call<OrderResponse> call = ordersInterface.getOrders(authPref.getBearerToken(), orderStatus);
        call.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(@NonNull Call<OrderResponse> call, @NonNull Response<OrderResponse> response) {
                if (response.code() == Constant.HTTP_RESPONSE_SUCCESS) {
                    if (response.body() != null) {
                        if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_SUCCESS) {
                            getOrderInterface.onContractResponse(response.body());
                        } else if (response.body().getSubCode() == Constant.SERVICE_RESPONSE_CODE_NO_DATA) {
                            getOrderInterface.onContractNotFound();
                        }
                    }
                } else if (response.code() == Constant.HTTP_SERVER_ERROR) {
                    getOrderInterface.onContractFailure();
                }
            }

            @Override
            public void onFailure(@NonNull Call<OrderResponse> call, @NonNull Throwable t) {
                Log.e("OrderResponse", "onFailure: "+t.getMessage());
                getOrderInterface.onContractFailure();
            }
        });
    }

}
