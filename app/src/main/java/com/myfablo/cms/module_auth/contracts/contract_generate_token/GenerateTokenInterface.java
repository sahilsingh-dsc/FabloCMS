package com.myfablo.cms.module_auth.contracts.contract_generate_token;

import com.myfablo.cms.module_auth.models.auth.response.AuthResponse;

public interface GenerateTokenInterface {

    void onContractProgress();
    void onContractResponse(AuthResponse authResponse);
    void onContractNotFound();
    void onContractFailure();


}
