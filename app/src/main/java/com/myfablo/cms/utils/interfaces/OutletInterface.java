package com.myfablo.cms.utils.interfaces;

import com.myfablo.cms.module_outlet.models.OutletResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface OutletInterface {

    @GET("outlet/all")
    Call<OutletResponse> getAllOutlets();

}
