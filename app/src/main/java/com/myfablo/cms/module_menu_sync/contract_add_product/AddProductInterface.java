package com.myfablo.cms.module_menu_sync.contract_add_product;

import com.myfablo.cms.utils.common_req_res.BasicResponse;

public interface AddProductInterface {

    void onContractProgress();
    void onContractResponse(BasicResponse basicResponse);
    void onContractNotFound();
    void onContractFailure();

}
