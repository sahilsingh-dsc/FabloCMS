package com.myfablo.cms.module_outlet.contracts.contract_get_all_outlets;

import com.myfablo.cms.module_outlet.models.OutletResponse;

public interface GetAllOutletInterface {

    void onContractProgress();
    void onContractResponse(OutletResponse outletResponse);
    void onContractNotFound();
    void onContractFailure();

}
