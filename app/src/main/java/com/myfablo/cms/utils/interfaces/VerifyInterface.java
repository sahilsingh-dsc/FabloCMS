package com.myfablo.cms.utils.interfaces;

import com.myfablo.cms.module_digikyc.fssai.models.response.FssaiVerifyResponse;
import com.myfablo.cms.module_digikyc.gst.models.response.GstVerifyResponse;
import com.myfablo.cms.module_digikyc.pan.models.response.PanVerifyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VerifyInterface {

    @GET("verify/pan/{pan}")
    Call<PanVerifyResponse> verifyPan(@Path("pan") String pan);

    @GET("verify/fssai/{fssai}")
    Call<FssaiVerifyResponse> verifyFssai(@Path("fssai") String fssai);

    @GET("verify/gst/{gst}")
    Call<GstVerifyResponse> verifyGst(@Path("gst") String gst);


}
