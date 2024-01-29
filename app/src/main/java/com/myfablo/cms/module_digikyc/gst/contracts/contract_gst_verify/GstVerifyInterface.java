package com.myfablo.cms.module_digikyc.gst.contracts.contract_gst_verify;

import com.myfablo.cms.module_digikyc.gst.models.response.GstVerifyResponse;

public interface GstVerifyInterface {

    void onContractProgress();
    void onContractResponse(GstVerifyResponse gstVerifyResponse);
    void onContractNotFound();
    void onContractFailure();

}
