package com.myfablo.cms.module_menu_sync.contract_add_category;

import com.myfablo.cms.utils.common_req_res.BasicResponse;

public interface AddCategoryInterface {

    void onContractProgress();

    void onContractResponse(BasicResponse basicResponse);

    void onContractNotFound();

    void onContractFailure();
}