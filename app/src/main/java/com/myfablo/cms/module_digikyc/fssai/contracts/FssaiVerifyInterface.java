package com.myfablo.cms.module_digikyc.fssai.contracts;

import com.myfablo.cms.module_digikyc.fssai.models.response.FssaiVerifyResponse;

public interface FssaiVerifyInterface {

    void onContractProgress();
    void onContractResponse(FssaiVerifyResponse fssaiVerifyResponse);
    void onContractNotFound();
    void onContractFailure();

}
