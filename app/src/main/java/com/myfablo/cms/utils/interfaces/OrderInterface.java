package com.myfablo.cms.utils.interfaces;

import com.myfablo.cms.module_order.feature_get_order.models.response.OrderResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface OrderInterface {

    @GET("order/outlets")
    Call<OrderResponse>
    getOrders(@Header("Authorization") String token,
              @Query("status") String status);

}
