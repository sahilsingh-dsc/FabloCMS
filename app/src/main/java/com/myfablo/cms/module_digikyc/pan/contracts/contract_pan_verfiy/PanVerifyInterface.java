package com.myfablo.cms.module_digikyc.pan.contracts.contract_pan_verfiy;


import com.myfablo.cms.module_digikyc.pan.models.response.PanVerifyResponse;

public interface PanVerifyInterface {

    void onContractProgress();
    void onContractResponse(PanVerifyResponse panVerifyResponse);
    void onContractNotFound();
    void onContractFailure();

}
